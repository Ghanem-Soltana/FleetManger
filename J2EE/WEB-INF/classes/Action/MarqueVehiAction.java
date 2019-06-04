package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.MarqueVehiForm;
import Dao.Conn;
import Dao.MarqueVehiDao;;

public class MarqueVehiAction extends Action {
	
		 
		
		
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
		    MarqueVehiDao ldao =new MarqueVehiDao(cnx.getcnx());
		    
		    
		    try{

	        if(action.equals("ajout"))
	        {   session.setAttribute("marque", new MarqueVehiForm());
	        	boolean test=true;
	        	MarqueVehiForm tfrm=(MarqueVehiForm) form;
	            if(tfrm.getId_marque()==null||tfrm.getId_marque().equals("")||tfrm.getId_marque().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("marque", new MarqueVehiForm("",tfrm.getLibelle_marque()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<MarqueVehiForm> liste=new ArrayList<MarqueVehiForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_marque", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	MarqueVehiForm tfrm=(MarqueVehiForm) form;
	        	MarqueVehiForm aux=ldao.recup(tfrm.getId_marque());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("marque", new MarqueVehiForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<MarqueVehiForm> liste=new ArrayList<MarqueVehiForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_marque", liste);
		    	session.setAttribute("marque",new MarqueVehiForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      MarqueVehiForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("marque", new MarqueVehiForm());
		  session.removeAttribute("x");
		  }
		  else{
		  MarqueVehiForm x= ldao.recup(id);
	      session.setAttribute("marque",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				MarqueVehiForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<MarqueVehiForm> liste=new ArrayList<MarqueVehiForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_marque", liste);
		    	session.setAttribute("marque", new MarqueVehiForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<MarqueVehiForm> liste=new ArrayList<MarqueVehiForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_marque", liste);
			    	session.setAttribute("marque", new MarqueVehiForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		    }catch(Exception e ){System.out.println(e);}
			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




