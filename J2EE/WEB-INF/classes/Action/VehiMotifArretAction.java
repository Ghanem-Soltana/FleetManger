package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.TypeMotifArretForm;
import Bean.VehiMotifArretForm;
import Bean.VehiculeForm;
import Dao.Conn;
import Dao.TypeMotifArretDao;
import Dao.VehiMotifArretDao;
import Dao.VehiculeDao;

public class VehiMotifArretAction extends Action {
	
		 
		
		
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
		    VehiMotifArretDao ldao =new VehiMotifArretDao(cnx.getcnx());
		    VehiculeDao cdao= new VehiculeDao(cnx.getcnx());
		    TypeMotifArretDao mdao= new TypeMotifArretDao(cnx.getcnx());
		    ArrayList<VehiculeForm> liste1= new ArrayList<VehiculeForm>();	 
		    ArrayList<TypeMotifArretForm> liste2= new ArrayList<TypeMotifArretForm>();
		    liste1=cdao.all();
		    liste2=mdao.all();
		    session.setAttribute("liste1",liste1);
		    session.setAttribute("liste2",liste2);
	
		    
		    try{
		    if(action.equals("ajout"))
	        {   session.setAttribute("vehi_motif_arret", new VehiMotifArretForm());
	        	boolean test=true;
	        	VehiMotifArretForm tfrm=(VehiMotifArretForm) form;
	        	
	        	
	        	boolean valide=true;
	        	valide=ldao.verfifer_validite_date(tfrm);
	        	
	        	if(valide)
	        	{
	        	
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("vehi_motif_arret", tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}
	        	}
	        	else 
	        	{session.setAttribute("erreur", "er_motif_arret_date");
		    	session.setAttribute("vehi_motif_arret", tfrm);}
	        	
	        	ArrayList<VehiMotifArretForm> liste=new ArrayList<VehiMotifArretForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_vehi_motif_arret", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	        }
		    
	        if(action.equals("edit"))
	        {    
	        	VehiMotifArretForm ancien =(VehiMotifArretForm)session.getAttribute("motif_vehi_init");
	          	 
				String id_vehicule=ancien.getId_vehicule();
				String id_motif=ancien.getId_arret();
				String date=ancien.getDate_debut();
	        	VehiMotifArretForm tfrm=(VehiMotifArretForm) form;
	        	VehiMotifArretForm aux=ldao.recup(id_vehicule,id_motif,date);
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("vehi_motif_arret", new VehiMotifArretForm());
  		  }
	        	else{   
	        		
	        		  boolean valide=true;
	        		  valide=ldao.verfifer_validite_date_update(tfrm,id_vehicule, date);
	        		  
	        		  if(valide)
	        		  {
	        		    boolean modif=ldao.update(id_vehicule,id_motif,date,tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");
	        	    	session.setAttribute("vehi_motif_arret",new VehiMotifArretForm());
	    		    	session.removeAttribute("x");
	        	        }
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        		  else 
	        		  {session.setAttribute("erreur", "er_motif_arret_date");
	  		         	session.setAttribute("vehi_motif_arret", tfrm);}
	        		  
	        	}
	        	ArrayList<VehiMotifArretForm> liste=new ArrayList<VehiMotifArretForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_vehi_motif_arret", liste);
		    
	  		  

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	        	 
			String id_vehicule=request.getParameter("id_vehi");
			String id_motif=request.getParameter("id_arret");
			String date=request.getParameter("date");
			VehiMotifArretForm aux=ldao.recup(id_vehicule,id_motif,date);
			if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("vehi_motif_arret", new VehiMotifArretForm());
		  session.removeAttribute("x");
		  }
		  else{
		  VehiMotifArretForm x= ldao.recup(id_vehicule,id_motif,date);
	      session.setAttribute("vehi_motif_arret",  x);
	      session.setAttribute("motif_vehi_init",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id_vehicule=request.getParameter("id_vehi");
				String id_motif=request.getParameter("id_arret");
				String date=request.getParameter("date");
				VehiMotifArretForm aux=ldao.recup(id_vehicule,id_motif,date);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id_vehicule,id_motif,date);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<VehiMotifArretForm> liste=new ArrayList<VehiMotifArretForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_vehi_motif_arret", liste);
		    	session.setAttribute("vehi_motif_arret", new VehiMotifArretForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<VehiMotifArretForm> liste=new ArrayList<VehiMotifArretForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_vehi_motif_arret", liste);
			    	session.setAttribute("vehi_motif_arret", new VehiMotifArretForm());
			    	session.removeAttribute("x");
			    	
			   
			    }
			   
			}catch(Exception e ){System.out.println(e);}		
	
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




