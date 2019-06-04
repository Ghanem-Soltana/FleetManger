package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeNatArticleForm;
import Dao.Conn;
import Dao.TypeNatArticleDao;;

public class TypeNatArticleAction extends Action {
	
		 
		
		
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
		   
		    
		    request.setAttribute("x", null);
		    session.removeAttribute("listevide");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    TypeNatArticleDao ldao =new TypeNatArticleDao(cnx.getcnx());

		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("natarticle", new TypeNatArticleForm());
	        	boolean test=true;
	        	TypeNatArticleForm tfrm=(TypeNatArticleForm) form;
	            if(tfrm.getId_natarticle()==null||tfrm.getId_natarticle().equals("")||tfrm.getId_natarticle().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("natarticle", new TypeNatArticleForm("",tfrm.getLibelle_natarticle()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeNatArticleForm> liste=new ArrayList<TypeNatArticleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_natarticle", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeNatArticleForm tfrm=(TypeNatArticleForm) form;
	        	TypeNatArticleForm aux=ldao.recup(tfrm.getId_natarticle());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("natarticle", new TypeNatArticleForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeNatArticleForm> liste=new ArrayList<TypeNatArticleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_natarticle", liste);
		    	session.setAttribute("natarticle",new TypeNatArticleForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeNatArticleForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("natarticle", new TypeNatArticleForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeNatArticleForm x= ldao.recup(id);
	      session.setAttribute("natarticle",  x);
	      session.setAttribute("x", "");
		  }


	        }  
	
			if(action.equals("supp1"))
			{    
				String id=request.getParameter("id");
            	TypeNatArticleForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeNatArticleForm> liste=new ArrayList<TypeNatArticleForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_natarticle", liste);
		    	session.setAttribute("natarticle", new TypeNatArticleForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeNatArticleForm> liste=new ArrayList<TypeNatArticleForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_natarticle", liste);
			    	session.setAttribute("natarticle", new TypeNatArticleForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		}catch(Exception e ){System.out.println(e);}		   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




