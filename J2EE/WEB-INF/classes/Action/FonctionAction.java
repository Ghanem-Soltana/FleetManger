package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.FonctionForm;
import Dao.Conn;
import Dao.FonctionDao;


public class FonctionAction extends Action {
	

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
		    FonctionDao ldao =new FonctionDao(cnx.getcnx());
		    
		    try{

	        if(action.equals("ajout"))
	        {   session.setAttribute("fonction", new FonctionForm());
	        	boolean test=true;
	        	FonctionForm tfrm=(FonctionForm) form;
	            if(tfrm.getId_fonction()==null||tfrm.getId_fonction().equals("")||tfrm.getId_fonction().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("fonction", new FonctionForm("",tfrm.getLibelle_fonction()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<FonctionForm> liste=new ArrayList<FonctionForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_fonction", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");

	        	
	        }
	        if(action.equals("edit"))
	        {
	        	FonctionForm tfrm=(FonctionForm) form;
	        	FonctionForm aux=ldao.recup(tfrm.getId_fonction());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("fonction", new FonctionForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<FonctionForm> liste=new ArrayList<FonctionForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_fonction", liste);
		    	session.setAttribute("fonction",new FonctionForm());
		    	session.removeAttribute("x");
	  		  
				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      FonctionForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("fonction", new FonctionForm());
		  session.removeAttribute("x");
		  }
		  else{
		  FonctionForm x= ldao.recup(id);
	      session.setAttribute("fonction",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				FonctionForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<FonctionForm> liste=new ArrayList<FonctionForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("type_fonction", liste);
		    	session.setAttribute("fonction", new FonctionForm());
		    	
		    	session.removeAttribute("x");

			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<FonctionForm> liste=new ArrayList<FonctionForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("type_fonction", liste);
			    	session.setAttribute("fonction", new FonctionForm());
			    	session.removeAttribute("x");

			    }
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




