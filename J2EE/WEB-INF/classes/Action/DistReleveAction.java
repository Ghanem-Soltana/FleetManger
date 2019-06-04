package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.DistDistanceForm;
import Bean.VehiculeForm;
import Dao.Conn;
import Dao.DistReleveDao;
import Dao.VehiculeDao;

public class DistReleveAction extends Action {
	
		 
		
		
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
		    DistReleveDao ldao =new DistReleveDao(cnx.getcnx());
		    VehiculeDao vehiculedao=new  VehiculeDao(cnx.getcnx());
		    ArrayList<VehiculeForm> liste_vehicule=vehiculedao.ceux_qui_ont_ete_definit();
		    session.setAttribute("liste_vehicule", liste_vehicule);
		    
		    
		  	

	        if(action.equals("ajout"))
	        {  
	        	boolean test=true;
	        	DistDistanceForm tfrm=(DistDistanceForm) form;
	            if(tfrm.getId_distance()==null||tfrm.getId_distance().equals("")||tfrm.getId_distance().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");

	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");
	        	
	        	ldao.alerte();	
	        	
	        	}}
	            
	            
	            ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
		    	liste=ldao.en_attente();
		    	
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_releve", liste);
		    	DistDistanceForm releve=new DistDistanceForm();
		    	
		    	if(liste_vehicule.size()!=0)
		    	{
		    		releve.setId_vehicule(liste_vehicule.get(0).getId_vehicule());
		    		releve=ldao.ajuster(releve);
		    	}
		    	session.setAttribute("releve", releve);
		    	session.removeAttribute("x");
	        
	        	

	
	        	
	        }
	        

	        
		    
			if(action.equals("supp"))
			{   
				String id_rel=request.getParameter("id_rel");
			      String id_vehi=request.getParameter("id_vehi");
				DistDistanceForm aux=ldao.recup(id_rel,id_vehi);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id_rel,id_vehi);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_releve", liste);
		    	session.setAttribute("releve", new DistDistanceForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			    	liste=ldao.en_attente();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_releve", liste);
			    	DistDistanceForm releve=new DistDistanceForm();
			    	
			    	if(liste_vehicule.size()!=0)
			    	{
			    		releve.setId_vehicule(liste_vehicule.get(0).getId_vehicule());
			    		releve=ldao.ajuster(releve);
			    	}
			    	session.setAttribute("releve", releve);
			    	session.removeAttribute("x");
			   
			    }
			   
			   
			   if(action.equals("maj_vehicule"))
			   {   String id_vehicuel=request.getParameter("id_vehi");
				   DistDistanceForm relle = (DistDistanceForm)form;
				   relle.setId_vehicule(id_vehicuel);
				   relle=ldao.ajuster(relle);
				
				   try{
				   String anterieur=relle.getAncien_compteur();
				   String actuelle=relle.getActuel_compteur();
				 

				   boolean test=!anterieur.equals("")&&!actuelle.equals("");
				   test=test&&Integer.parseInt(anterieur)<Integer.parseInt(actuelle);
				   double tehorique=Integer.parseInt(actuelle)-Integer.parseInt(anterieur);
				   test=test&&tehorique>0;
				   if(test)
				   relle.setRapport_distance_compteur(String.valueOf(tehorique));
				   else
				   relle.setRapport_distance_compteur("");
				   }catch(Exception e){		   relle.setRapport_distance_compteur("");}
				   
				   session.setAttribute("releve", relle);
				   
				   

			    	ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			    	liste=ldao.en_attente();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_releve", liste);
			    	
			   
			    
				   
			   }
			   
				}
			     cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




