package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.VilleForm;
import Dao.Conn;
import Dao.VilleDao;;

public class VilleAction extends Action {
	
		 
		
		
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
		    VilleDao ldao =new VilleDao(cnx.getcnx());

		 try{   
		    
	        if(action.equals("ajout"))
	        {   session.setAttribute("ville", new VilleForm());
	        	boolean test=true;
	        	VilleForm tfrm=(VilleForm) form;
	            if(tfrm.getId_ville()==null||tfrm.getId_ville().equals("")||tfrm.getId_ville().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("ville", new VilleForm("",tfrm.getLibelle_ville(),tfrm.getCp()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<VilleForm> liste=new ArrayList<VilleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_ville", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	VilleForm tfrm=(VilleForm) form;
	        	VilleForm aux=ldao.recup(tfrm.getId_ville());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("ville", new VilleForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<VilleForm> liste=new ArrayList<VilleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_ville", liste);
		    	session.setAttribute("ville",new VilleForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      VilleForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("ville", new VilleForm());
		  session.removeAttribute("x");
		  }
		  else{
		  VilleForm x= ldao.recup(id);
	      session.setAttribute("ville",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				VilleForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<VilleForm> liste=new ArrayList<VilleForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_ville", liste);
		    	session.setAttribute("ville", new VilleForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<VilleForm> liste=new ArrayList<VilleForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_ville", liste);
			    	session.setAttribute("ville", new VilleForm());
			    	session.removeAttribute("x");
			   
			    }

			   
		}catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
	
			return mapping.findForward(frd);
		}
		
		

	
	}




