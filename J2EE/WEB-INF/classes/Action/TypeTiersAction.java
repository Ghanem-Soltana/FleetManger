package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeTiersForm;
import Dao.Conn;
import Dao.TypeTiersDao;;

public class TypeTiersAction extends Action {
	
		 
		
		
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
		    TypeTiersDao ldao =new TypeTiersDao(cnx.getcnx());

		    
	try{	    
		    
	        if(action.equals("ajout"))
	        {   session.setAttribute("tiers", new TypeTiersForm());
	        	boolean test=true;
	        	TypeTiersForm tfrm=(TypeTiersForm) form;
	            if(tfrm.getId_tiers()==null||tfrm.getId_tiers().equals("")||tfrm.getId_tiers().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("tiers", new TypeTiersForm("",tfrm.getLibelle_tiers()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeTiersForm> liste=new ArrayList<TypeTiersForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_tiers", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeTiersForm tfrm=(TypeTiersForm) form;
	        	TypeTiersForm aux=ldao.recup(tfrm.getId_tiers());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("tiers", new TypeTiersForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeTiersForm> liste=new ArrayList<TypeTiersForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_tiers", liste);
		    	session.setAttribute("tiers",new TypeTiersForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeTiersForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("tiers", new TypeTiersForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeTiersForm x= ldao.recup(id);
	      session.setAttribute("tiers",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeTiersForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeTiersForm> liste=new ArrayList<TypeTiersForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_tiers", liste);
		    	session.setAttribute("tiers", new TypeTiersForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeTiersForm> liste=new ArrayList<TypeTiersForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_tiers", liste);
			    	session.setAttribute("tiers", new TypeTiersForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		}catch(Exception e ){System.out.println(e);}	   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




