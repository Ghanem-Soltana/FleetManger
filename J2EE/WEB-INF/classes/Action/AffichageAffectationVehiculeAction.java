package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.AffectationVehiculeForm;
import Bean.AgenceForm;
import Bean.CentreForm;
import Dao.AffectationVehiculeDao;
import Dao.AgenceDao;
import Dao.CentreDao;
import Dao.Conn;
import Dao.AffichageAffectationVehiculeDao;


public class AffichageAffectationVehiculeAction extends Action {
	
		 
		
		
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
		  
		    
	
		    
		   AffichageAffectationVehiculeDao ldao =new AffichageAffectationVehiculeDao(cnx.getcnx());
		   AffectationVehiculeDao affectationdao =new AffectationVehiculeDao(cnx.getcnx());

		   CentreDao centredao =new CentreDao(cnx.getcnx());
		   AgenceDao agencedao =new AgenceDao(cnx.getcnx());

		   
		   

		   
	    	ArrayList<CentreForm> liste_centre=new ArrayList<CentreForm>();
	    	liste_centre=centredao.all();
	    	liste_centre.add(0,new CentreForm("xxxxxx","tous",""));
	    	session.setAttribute("liste_centre", liste_centre);
	    	
		   

		    ArrayList <AgenceForm> liste_agence =new ArrayList<AgenceForm>();
		    liste_agence=agencedao.all();
		    liste_agence.add((0),new AgenceForm("xxxxxx","tous","xxxxxx","tous"));
	    	session.setAttribute("liste_agence", liste_agence);
	
		    
		    AffectationVehiculeForm afficher=new AffectationVehiculeForm();
		    afficher.setId_centre("xxxxxx");
		    afficher.setId_agence("xxxxxx");


		    session.removeAttribute("listevide");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");

	        
	   
			try{
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_affect_vehi", liste);
			    	session.setAttribute("affect_vehi_aff", afficher);

			
			    }
			   
			   
			   

				if(action.equals("supp"))
				{   
					String id_vehi=request.getParameter("id_vehi");
					String id_serv=request.getParameter("id_serv");
					String date_affectation=request.getParameter("dat_aff");
					afficher=(AffectationVehiculeForm) session.getAttribute("affect_vehi_aff");
					AffectationVehiculeForm aux=affectationdao.recup(id_vehi,id_serv,date_affectation );
					if(aux==null)
					session.setAttribute("erreur", "er_suppinex");
					else{
					boolean test=affectationdao.delete(id_vehi,id_serv,date_affectation );
					if(!test)
					session.setAttribute("erreur", "er_suppcascade");
					else{session.setAttribute("sms", "supp_ok");}
					}
			    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
			    	liste=ldao.select(afficher);
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_affect_vehi", liste);
			
			    	

				
				}
				
				if(action.equals("refresh"))
				{
				afficher=(AffectationVehiculeForm) session.getAttribute("affect_vehi_aff");
				
				 
				   liste_agence=agencedao.select(afficher.getId_centre());
				   liste_agence.add((0),new AgenceForm("xxxxxx","tous","xxxxxx","tous"));
			       session.setAttribute("liste_agence", liste_agence);
			       ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
			       liste=ldao.select(afficher);
System.out.println(liste.size());
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_affect_vehi", liste);

					
				}
			   
			   
			   
			   if(action.equals("changement_centre"))
			   {
				   
				   String id_centre=request.getParameter("id_centre");
				   afficher= (AffectationVehiculeForm)form;
				   afficher.setId_centre(id_centre);
				   afficher.setId_agence("xxxxxx");
				
				   if(id_centre!=null)
				   {
					   
					   liste_agence=agencedao.select(id_centre);
					   liste_agence.add((0),new AgenceForm("xxxxxx","tous","xxxxxx","tous"));
				       session.setAttribute("liste_agence", liste_agence);
				       ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
				       liste=ldao.select(afficher);

				    	if(liste.size()==0)
				    	session.setAttribute("listevide", "rien");
				    	session.setAttribute("liste_affect_vehi", liste);
				    	session.setAttribute("affect_vehi_aff", afficher);
				   }
				   
			
			   }
			   
			   
			   
			   
			   if(action.equals("changement_agence"))
			   {
				   
				   String id_agence=request.getParameter("id_agence");
				   afficher= (AffectationVehiculeForm)form;
				   afficher.setId_agence(id_agence);
				   session.setAttribute("affect_vehi_aff", afficher);
				   
				   
				   
				   liste_agence=agencedao.select(afficher.getId_centre());
				   liste_agence.add((0),new AgenceForm("xxxxxx","tous","xxxxxx","tous"));
			       session.setAttribute("liste_agence", liste_agence);
			     
				 
				   ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
			       liste=ldao.select(afficher);

			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_affect_vehi", liste);
			    	session.setAttribute("affect_vehi_aff", afficher);
			
				   
				  
			   }
			   
			   
			   
	    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




