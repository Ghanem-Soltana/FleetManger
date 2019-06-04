package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.StationMaintForm;
import Dao.Conn;
import Dao.StationMaintDao;

public class StationMaintAction extends Action {
	
		 
		
		
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
		    StationMaintDao ldao =new StationMaintDao(cnx.getcnx());

		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("station", new StationMaintForm());
	        	boolean test=true;
	        	StationMaintForm tfrm=(StationMaintForm) form;
	            if(tfrm.getId_station()==null||tfrm.getLibelle_station().equals("")||tfrm.getId_station().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("station", new StationMaintForm("",tfrm.getLibelle_station()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<StationMaintForm> liste=new ArrayList<StationMaintForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_station", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	StationMaintForm tfrm=(StationMaintForm) form;
	        	StationMaintForm aux=ldao.recup(tfrm.getId_station());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("station", new StationMaintForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<StationMaintForm> liste=new ArrayList<StationMaintForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_station", liste);
		    	session.setAttribute("station",new StationMaintForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      StationMaintForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("station", new StationMaintForm());
		  session.removeAttribute("x");
		  }
		  else{
		  StationMaintForm x= ldao.recup(id);
	      session.setAttribute("station",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				StationMaintForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<StationMaintForm> liste=new ArrayList<StationMaintForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_station", liste);
		    	session.setAttribute("station", new StationMaintForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<StationMaintForm> liste=new ArrayList<StationMaintForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_station", liste);
			    	session.setAttribute("station", new StationMaintForm());
			    	session.removeAttribute("x");
			   
			    }
			
			   
		    }catch(Exception e ){System.out.println(e);}
			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




