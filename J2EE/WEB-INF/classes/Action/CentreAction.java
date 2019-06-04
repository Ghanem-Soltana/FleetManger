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
import Dao.Conn;
import Dao.CentreDao;;

public class CentreAction extends Action  {
	
		 
		
		
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
		    CentreDao ldao =new CentreDao(cnx.getcnx());

		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("centre", new CentreForm());
	        	boolean test=true;
	        	CentreForm tfrm=(CentreForm) form;
	            if(tfrm.getId_centre()==null||tfrm.getId_centre().equals("")||tfrm.getId_centre().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("centre", new CentreForm("",tfrm.getLibelle_centre(),tfrm.getRemarque_centre()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<CentreForm> liste=new ArrayList<CentreForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_centre", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	CentreForm tfrm=(CentreForm) form;
	        	CentreForm aux=ldao.recup(tfrm.getId_centre());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("centre", new CentreForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<CentreForm> liste=new ArrayList<CentreForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_centre", liste);
		    	session.setAttribute("centre",new CentreForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      CentreForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("centre", new CentreForm());
		  session.removeAttribute("x");
		  }
		  else{
		  CentreForm x= ldao.recup(id);
	      session.setAttribute("centre",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				CentreForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<CentreForm> liste=new ArrayList<CentreForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_centre", liste);
		    	session.setAttribute("centre", new CentreForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<CentreForm> liste=new ArrayList<CentreForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_centre", liste);
			    	session.setAttribute("centre", new CentreForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
	
			return mapping.findForward(frd);
		}
		
		

	
	}




