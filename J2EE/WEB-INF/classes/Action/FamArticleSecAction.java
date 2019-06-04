package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.FamArticlePrinciForm;
import Bean.FamArticleSecForm;
import Dao.Conn;
import Dao.FamArticlePrinciDao;
import Dao.FamArticleSecDao;

public class FamArticleSecAction extends Action {
	
		 
		
		
		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			 Conn cnx=new Conn();
			 
				String frd = Utilitaire.connecte(request);
				if(frd.equals("ok"))
				{
				
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
		   
		    
		    
		    session.removeAttribute("listevide");
		    session.removeAttribute("listevide2");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    session.removeAttribute("liste2");
		    session.removeAttribute("liste3");
		    FamArticleSecDao ldao =new FamArticleSecDao(cnx.getcnx());
		    FamArticlePrinciDao edao =new  FamArticlePrinciDao(cnx.getcnx());
		    FamArticleSecForm vider= new FamArticleSecForm("","","xxxxxx","");
		    ArrayList<FamArticlePrinciForm> liste2= new ArrayList<FamArticlePrinciForm>();
		    ArrayList<FamArticlePrinciForm> liste3= new ArrayList<FamArticlePrinciForm>();
	    	liste2=edao.all();
	    	liste3=edao.all();
	    	liste3.add(0,new FamArticlePrinciForm("xxxxxx","tous",true,true) );
	    	session.setAttribute("liste2", liste2);
	    	session.setAttribute("liste3", liste3);
	    	if(!Utilitaire.present(request, "vider"))
	    	session.setAttribute("vider", vider);

		    
try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("fam_sec", new FamArticleSecForm());
	        	boolean test=true;
	        	FamArticleSecForm tfrm=(FamArticleSecForm) form;
	            if(tfrm.getId_famille_sec()==null||tfrm.getId_famille_sec().equals("")||tfrm.getId_famille_sec().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("fam_sec", new FamArticleSecForm("",tfrm.getLibelle_famille_sec(),tfrm.getId_famille_princi(),tfrm.getLibelle_famille_princi()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	            
	        	 FamArticleSecForm temp=(FamArticleSecForm)session.getAttribute("vider");
	        	 ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
	        	 if(temp.getId_famille_princi().equals("xxxxxx"))
	        	 {
	        	
		    	liste=ldao.all();
		    	session.setAttribute("liste_fam_sec", liste);
		    
	        	 }
	        	 else{liste=ldao.select(temp.getId_famille_princi());
	        		 session.setAttribute("liste_fam_sec", liste);
	        	     
	        	    }
	        		if(liste.size()==0)
					    session.setAttribute("listevide", "rien");
	        		session.removeAttribute("x1");
	        }
	        
	        
	        
	        if(action.equals("edit"))
	        {
	        	FamArticleSecForm tfrm=(FamArticleSecForm) form;
	        	FamArticleSecForm aux=ldao.recup(tfrm.getId_famille_sec());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("fam_sec", new FamArticleSecForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	 FamArticleSecForm temp=(FamArticleSecForm)session.getAttribute("vider");
	        	 ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
	        	 if(temp.getId_famille_princi().equals("xxxxxx"))
	        	 {
	        	
		    	liste=ldao.all();
		    	session.setAttribute("liste_fam_sec", liste);
		    
	        	 }
	        	 else{liste=ldao.select(temp.getId_famille_princi());
	        		 session.setAttribute("liste_fam_sec", liste);
	        	     
	        	    }
	        		if(liste.size()==0)
					    session.setAttribute("listevide", "rien");
	        	 
		    	
		    	session.setAttribute("fam_sec",new FamArticleSecForm());
		    	session.removeAttribute("x1");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      FamArticleSecForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("fam_sec", new FamArticleSecForm());
		  session.removeAttribute("x1");
		  }
		  else{
		  FamArticleSecForm x= ldao.recup(id);
	      session.setAttribute("fam_sec",  x);
	      session.setAttribute("x1", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				FamArticleSecForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
				 FamArticleSecForm temp=(FamArticleSecForm)session.getAttribute("vider");
	        	 ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
	        	 if(temp.getId_famille_princi().equals("xxxxxx"))
	        	 {
	        	
		    	liste=ldao.all();
		    	session.setAttribute("liste_fam_sec", liste);
		    
	        	 }
	        	 else{liste=ldao.select(temp.getId_famille_princi());
	        		 session.setAttribute("liste_fam_sec", liste);
	        	     
	        	    }
	        		if(liste.size()==0)
					    session.setAttribute("listevide", "rien");
	        	 
		    	
		    	session.setAttribute("fam_sec", new FamArticleSecForm());
		    	
		    	session.removeAttribute("x1");
			
			}
			
			   if(action.equals("all"))
			    {
				    session.removeAttribute("x1");
			    	ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
			    	liste=ldao.all();
			    	
			  
			    	session.setAttribute("liste_fam_sec", liste);
			    	session.setAttribute("fam_sec", new FamArticleSecForm());
			    	session.removeAttribute("x1");
			    	if(liste.size()==0)
				 session.setAttribute("listevide", "rien");
			    	if(liste2.size()==0)
			session.setAttribute("listevide2", "rien");
			    	session.setAttribute("vider", vider);
			    }
			   
			   if(action.equals("select"))
			   {String id=request.getParameter("id");
			   ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
			   liste=ldao.select(id);
			   if(liste.size()==0)
			    session.setAttribute("listevide", "rien");
			    session.setAttribute("liste_fam_sec", liste);
			    vider.setId_famille_princi(id);
			    session.setAttribute("vider", vider);
			   
			    session.setAttribute("fam_sec",(FamArticleSecForm)form);
			    	 
			   }
			   
			   if(action.equals("annul"))
			   {     session.removeAttribute("x1");
					 FamArticleSecForm temp=(FamArticleSecForm)session.getAttribute("vider");
		        	 ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
		        	 if(temp.getId_famille_princi().equals("xxxxxx"))
		        	 {
		        	
			    	liste=ldao.all();
			    	session.setAttribute("liste_fam_sec", liste);
			    
		        	 }
		        	 else{liste=ldao.select(temp.getId_famille_princi());
		        		 session.setAttribute("liste_fam_sec", liste);
		        	     
		        	    }
		        		if(liste.size()==0)
					session.setAttribute("listevide", "rien");
		        	 
			   }
			   
}catch(Exception e ){System.out.println(e);}  
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




