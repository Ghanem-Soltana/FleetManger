package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.PlanForm;
import Dao.Conn;
import Dao.PlanDao;;

public class PlanAction extends Action {
	
		 
		
		
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
		    PlanDao ldao =new PlanDao(cnx.getcnx());
		    
		    
		    try{

	        if(action.equals("ajout"))
	        {   session.setAttribute("plan", new PlanForm());
	        	boolean test=true;
	        	PlanForm tfrm=(PlanForm) form;
	        	 if(tfrm.getId_plan()==null||tfrm.getId_plan().equals("")||tfrm.getId_plan().indexOf('&')!=-1)
	                 session.setAttribute("erreur", "er_invalide");
	           
	        	 else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("plan", new PlanForm("",tfrm.getLibelle_plan()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<PlanForm> liste=new ArrayList<PlanForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_plan", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	PlanForm tfrm=(PlanForm) form;
	        	PlanForm aux=ldao.recup(tfrm.getId_plan());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("plan", new PlanForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<PlanForm> liste=new ArrayList<PlanForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_plan", liste);
		    	session.setAttribute("plan",new PlanForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      PlanForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("plan", new PlanForm());
		  session.removeAttribute("x");
		  }
		  else{
		  PlanForm x= ldao.recup(id);
	      session.setAttribute("plan",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				PlanForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(Integer.parseInt(id));
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<PlanForm> liste=new ArrayList<PlanForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_plan", liste);
		    	session.setAttribute("plan", new PlanForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<PlanForm> liste=new ArrayList<PlanForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_plan", liste);
			    	session.setAttribute("plan", new PlanForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
	
			return mapping.findForward(frd);
		}
		
		

	
	}




