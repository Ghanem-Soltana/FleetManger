package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.SaisonForm;
import Dao.Conn;
import Dao.SaisonDao;;

public class SaisonAction extends Action  {
	
		 
		
		
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
		    SaisonDao ldao =new SaisonDao(cnx.getcnx());

		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("saison", new SaisonForm());
	        	boolean test=true;
	        	SaisonForm tfrm=(SaisonForm) form;
	            if(tfrm.getId_saison()==null||tfrm.getId_saison().equals("")||tfrm.getId_saison().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	            	
	            boolean valide=ldao.verfifer_validite_date(tfrm);
	            if(!valide)
	            {
	            	session.setAttribute("erreur", "er_exercice_date");
			    	session.setAttribute("saison", new SaisonForm(tfrm.getId_saison(),tfrm.getLibelle_saison(),"","",tfrm.getRemarque_saison(),tfrm.getCloture()));

	            }
	            else {
	            	
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("saison", new SaisonForm("",tfrm.getLibelle_saison(),tfrm.getDate_debut(),tfrm.getDate_fin(),tfrm.getRemarque_saison(),tfrm.getCloture()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}}
	        	
	        	ArrayList<SaisonForm> liste=new ArrayList<SaisonForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_saison", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        
	        
	        if(action.equals("edit"))
	        {
	        	SaisonForm tfrm=(SaisonForm) form;
	        	SaisonForm aux=ldao.recup(tfrm.getId_saison());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.removeAttribute("x");
	  	       session.setAttribute("saison", new SaisonForm());
	  		   
	  		  }
	        	else{   
	        		
	        		   boolean valide=ldao.verfifer_validite_date_update(tfrm);
	   	            if(!valide)
	   	            {
	   	            	session.setAttribute("erreur", "er_exercice_date");

	   	            }
	   	            else {
	        		
	        		    boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");
	        	        session.removeAttribute("x");
	        	        session.setAttribute("saison", new SaisonForm());
	        	        }
	        	        else {session.setAttribute("erreur", "er_modif1");
	   			    	session.setAttribute("saison", ( SaisonForm)form);

	        	              }
	        	        }
	        	     }
	        	ArrayList<SaisonForm> liste=new ArrayList<SaisonForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_saison", liste);
	            
		    	
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      SaisonForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("saison", new SaisonForm());
		  session.removeAttribute("x");
		  }
		  else{
		  SaisonForm x= ldao.recup(id);
	      session.setAttribute("saison",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				SaisonForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<SaisonForm> liste=new ArrayList<SaisonForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_saison", liste);
		    	session.setAttribute("saison", new SaisonForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<SaisonForm> liste=new ArrayList<SaisonForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_saison", liste);
			    	session.setAttribute("saison", new SaisonForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   
		    }catch(Exception e ){System.out.println(e);}
			   
			    } cnx.closecnx();
	
			return mapping.findForward(frd);
		}
		
		

	
	}




