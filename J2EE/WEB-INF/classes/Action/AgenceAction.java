package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.CentreForm;
import Bean.AgenceForm;
import Dao.Conn;
import Dao.CentreDao;
import Dao.AgenceDao;

public class AgenceAction extends Action {
	
		 
		
		
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
		    AgenceDao ldao =new AgenceDao(cnx.getcnx());
		    CentreDao edao =new  CentreDao(cnx.getcnx());
		    AgenceForm vider= new AgenceForm("","","xxxxxx","");
		    ArrayList<CentreForm> liste2= new ArrayList<CentreForm>();
		    ArrayList<CentreForm> liste3= new ArrayList<CentreForm>();
	    	liste2=edao.all();
	    	liste3=edao.all();
	    	liste3.add(0,new CentreForm("xxxxxx","tous","") );
	    	session.setAttribute("liste2", liste2);
	    	session.setAttribute("liste3", liste3);
	    	if(!Utilitaire.present(request, "vider"))
	    	session.setAttribute("vider", vider);

		    try{

	        if(action.equals("ajout"))
	        {   session.setAttribute("agence", new AgenceForm());
	        	boolean test=true;
	        	AgenceForm tfrm=(AgenceForm) form;
	            if(tfrm.getId_agence()==null||tfrm.getId_agence().equals("")||tfrm.getId_agence().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("agence", new AgenceForm("",tfrm.getLibelle_agence(),tfrm.getId_centre(),tfrm.getLibelle_centre()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	
	        	
	        	 AgenceForm temp=(AgenceForm)session.getAttribute("vider");
	        	 ArrayList<AgenceForm> liste=new ArrayList<AgenceForm>();
	        	 if(temp.getId_centre().equals("xxxxxx"))
	        	 {
	        	
		    	liste=ldao.all();
		    	session.setAttribute("liste_agence", liste);
		    
	        	 }
	        	 else{liste=ldao.select(temp.getId_centre());
	        		 session.setAttribute("liste_agence", liste);
	        	     
	        	    }
	        		if(liste.size()==0)
					    session.setAttribute("listevide", "rien");
	        		session.removeAttribute("x1");
	        }
	        
	        
	        
	        if(action.equals("edit"))
	        {
	        	AgenceForm tfrm=(AgenceForm) form;
	        	AgenceForm aux=ldao.recup(tfrm.getId_agence());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("agence", new AgenceForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	 AgenceForm temp=(AgenceForm)session.getAttribute("vider");
	        	 ArrayList<AgenceForm> liste=new ArrayList<AgenceForm>();
	        	 if(temp.getId_centre().equals("xxxxxx"))
	        	 {
	        	
		    	liste=ldao.all();
		    	session.setAttribute("liste_agence", liste);
		    
	        	 }
	        	 else{liste=ldao.select(temp.getId_centre());
	        		 session.setAttribute("liste_agence", liste);
	        	     
	        	    }
	        		if(liste.size()==0)
					    session.setAttribute("listevide", "rien");
	        	 
		    	
		    	session.setAttribute("agence",new AgenceForm());
		    	session.removeAttribute("x1");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      AgenceForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("agence", new AgenceForm());
		  session.removeAttribute("x1");
		  }
		  else{
		  AgenceForm x= ldao.recup(id);
	      session.setAttribute("agence",  x);
	      session.setAttribute("x1", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				AgenceForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
				 AgenceForm temp=(AgenceForm)session.getAttribute("vider");
	        	 ArrayList<AgenceForm> liste=new ArrayList<AgenceForm>();
	        	 if(temp.getId_centre().equals("xxxxxx"))
	        	 {
	        	
		    	liste=ldao.all();
		    	session.setAttribute("liste_agence", liste);
		    
	        	 }
	        	 else{liste=ldao.select(temp.getId_centre());
	        		 session.setAttribute("liste_agence", liste);
	        	     
	        	    }
	        		if(liste.size()==0)
					    session.setAttribute("listevide", "rien");
	        	 
		    	
		    	session.setAttribute("agence", new AgenceForm());
		    	
		    	session.removeAttribute("x1");
			
			}
			
			   if(action.equals("all"))
			    {
				    session.removeAttribute("x1");
			    	ArrayList<AgenceForm> liste=new ArrayList<AgenceForm>();
			    	liste=ldao.all();
			    	
			  
			    	session.setAttribute("liste_agence", liste);
			    	session.setAttribute("agence", new AgenceForm());
			    	session.removeAttribute("x1");
			    	if(liste.size()==0)
				 session.setAttribute("listevide", "rien");
			    	if(liste2.size()==0)
			session.setAttribute("listevide2", "rien");
			    	session.setAttribute("vider", vider);
			    }
			   
			   if(action.equals("select"))
			   {String id=request.getParameter("id");
			   ArrayList<AgenceForm> liste=new ArrayList<AgenceForm>();
			   liste=ldao.select(id);
			   if(liste.size()==0)
			    session.setAttribute("listevide", "rien");
			    session.setAttribute("liste_agence", liste);
			    vider.setId_centre(id);
			    session.setAttribute("vider", vider);
			    	 
			   }
			   
			   if(action.equals("annul"))
			   {     session.removeAttribute("x1");
					 AgenceForm temp=(AgenceForm)session.getAttribute("vider");
		        	 ArrayList<AgenceForm> liste=new ArrayList<AgenceForm>();
		        	 if(temp.getId_centre().equals("xxxxxx"))
		        	 {
		        	
			    	liste=ldao.all();
			    	session.setAttribute("liste_agence", liste);
			    
		        	 }
		        	 else{liste=ldao.select(temp.getId_centre());
		        		 session.setAttribute("liste_agence", liste);
		        	     
		        	    }
		        		if(liste.size()==0)
					session.setAttribute("listevide", "rien");
		        	 
			   }
			   
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




