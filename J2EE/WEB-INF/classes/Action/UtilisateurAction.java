package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.UtilisateurForm;
import Dao.Conn;
import Dao.UtilisateurDao;;

public class UtilisateurAction extends Action {
	
		 
		
		
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
		    UtilisateurDao ldao =new UtilisateurDao(cnx.getcnx());
try{
	

	        if(action.equals("ajout"))
	        {   session.setAttribute("utilisateur", new UtilisateurForm());
	        	boolean test=true;
	        	UtilisateurForm tfrm=(UtilisateurForm) form;
	            if(tfrm.getLogin_utilisateur()==null||tfrm.equals("")||tfrm.getLogin_utilisateur().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant_utilisateur");
		         tfrm.setLogin_utilisateur("");
	        	session.setAttribute("utilisateur", tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<UtilisateurForm> liste=new ArrayList<UtilisateurForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_utilisateur", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {	session.setAttribute("utilisateur",new UtilisateurForm());
	        	UtilisateurForm tfrm=(UtilisateurForm) form;
	        	UtilisateurForm aux=ldao.recup(tfrm.getLogin_utilisateur());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("utilisateur", new UtilisateurForm());
	  		  }
	        	else{
	        		
	        		if(!tfrm.getMot_passe1().equals(aux.getMot_passe1())&&!tfrm.getMot_passe1().equals(""))
	        			{session.setAttribute("erreur", "er_pass");
	        			 tfrm.setMot_passe1("");
	        	         tfrm.setMot_passe2("");
	     		    	session.setAttribute("utilisateur",tfrm);
	        	     
	        			
	        			}
	        		else{
	        		
	        		
	        		 boolean modif=ldao.update(tfrm);
	        	     
	        	       if(modif)
	        	        {session.setAttribute("sms", "modif_ok");
	        	    	session.removeAttribute("x");
	      	  		  
	        	        }
	        	         else {session.setAttribute("erreur", "er_modif1");
	        	         tfrm.setMot_passe1("");
	        	         tfrm.setMot_passe2("");
	     		    	session.setAttribute("utilisateur",tfrm);
	        	         }
	        	         }
	        	       }
	        	ArrayList<UtilisateurForm> liste=new ArrayList<UtilisateurForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_utilisateur", liste);

		

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      UtilisateurForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("utilisateur", new UtilisateurForm());
		  session.removeAttribute("x");
		  }
		  else{
		  UtilisateurForm x= ldao.recup(id);
		  x.setMot_passe1("");
	      session.setAttribute("utilisateur",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				UtilisateurForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<UtilisateurForm> liste=new ArrayList<UtilisateurForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_utilisateur", liste);
		    	session.setAttribute("utilisateur", new UtilisateurForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<UtilisateurForm> liste=new ArrayList<UtilisateurForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_utilisateur", liste);
			    	session.setAttribute("utilisateur", new UtilisateurForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		}catch(Exception e ){System.out.println(e);}			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




