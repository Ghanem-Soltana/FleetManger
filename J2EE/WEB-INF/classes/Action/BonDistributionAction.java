package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.AgenceForm;
import Bean.AgentForm;
import Bean.CentreForm;
import Bean.MagasinForm;
import Bean.SaisonForm;
import Bean.BonDistributionForm;
import Bean.ServiceForm;
import Bean.VehiculeForm;
import Dao.AgenceDao;
import Dao.AgentDao;
import Dao.CentreDao;
import Dao.Conn;
import Dao.MagasinDao;
import Dao.SaisonDao;
import Dao.BonDistributionDao;
import Dao.ServiceDao;
import Dao.VehiculeDao;

public class BonDistributionAction extends Action {
	

		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {

			String frd = "ok";
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
		    Conn cnx=new Conn();
		    
		    request.setAttribute("x", null);
		    session.removeAttribute("listevide");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    
		    VehiculeDao vehiculedao= new VehiculeDao(cnx.getcnx());
			SaisonDao anneedao =new  SaisonDao (cnx.getcnx());
			MagasinDao mdao =new MagasinDao(cnx.getcnx());
			AgentDao adap= new AgentDao(cnx.getcnx());
			BonDistributionDao ldao= new BonDistributionDao(cnx.getcnx());
			CentreDao centredao =new  CentreDao(cnx.getcnx());
			AgenceDao agencedao =new  AgenceDao(cnx.getcnx());
			ServiceDao servicedao =new ServiceDao(cnx.getcnx());
			
			  ArrayList<SaisonForm>liste_annee=  anneedao.noncloture();
			  ArrayList<MagasinForm>liste_magasin=mdao.all();
			  ArrayList<AgentForm>liste_agent=adap.operationelle();
			  ArrayList<VehiculeForm>liste_vehicule=vehiculedao.nonarrete();
			  ArrayList<CentreForm>liste_centre=centredao.all();
			  ArrayList<AgenceForm>liste_agence=new ArrayList<AgenceForm>() ;
			  ArrayList<ServiceForm>liste_service=new ArrayList<ServiceForm>();
			  
			  
			  if(liste_centre.size()!=0)
				 liste_agence=agencedao.select(liste_centre.get(0).getId_centre());
			  if(liste_agence.size()!=0)
				 liste_service=servicedao.select(liste_centre.get(0).getId_centre(), liste_agence.get(0).getId_agence());

			  session.setAttribute("liste_vehicule",liste_vehicule);
			  session.setAttribute("liste_annee", liste_annee);
			  session.setAttribute("liste_magasin", liste_magasin);
			  session.setAttribute("liste_agent", liste_agent);
			  session.setAttribute("liste_agent_recepteur", liste_agent);
			  session.setAttribute("liste_centre", liste_centre);
			  session.setAttribute("liste_agence", liste_agence);
			  session.setAttribute("liste_service", liste_service);
			  

	        if(action.equals("ajout"))
	        {		    	session.setAttribute("bon_distribution",new BonDistributionForm());

	        	boolean test=true;
	        	BonDistributionForm tfrm=(BonDistributionForm) form;
	            if(tfrm==null)
	            {  session.setAttribute("erreur", "er_invalide");
	            
	            }
	            else
	        	{test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{
	        	session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_distribution("");
		    	session.setAttribute("bon_distribution",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}
	        	
	        	ArrayList<BonDistributionForm> liste=new ArrayList<BonDistributionForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_bon_distribution", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	        	}
	        	
	        }
	        
	       
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
String id_bon=request.getParameter("id");
String id_exercice=request.getParameter("annee");
String id_mag=request.getParameter("mag");
BonDistributionForm aux=ldao.recup(id_exercice,id_bon,id_mag);

	      if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("bon_distribution", new BonDistributionForm());
		  session.removeAttribute("x");
		  }
		  else{
	      ldao.maj_distribution(aux);
	      session.setAttribute("bon_distribution",  aux);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
			String id=request.getParameter("id");
			String annee=request.getParameter("annee");
			String mag=request.getParameter("mag");

				boolean test=ldao.delete(id,annee,mag);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				
		    	ArrayList<BonDistributionForm> liste=new ArrayList<BonDistributionForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_bon_distribution", liste);
		    	session.setAttribute("bon_distribution", new BonDistributionForm());
		    	
		    	session.removeAttribute("x");

			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<BonDistributionForm> liste=new ArrayList<BonDistributionForm>();
			    	liste=ldao.all();
			    	BonDistributionForm mon_bon=new BonDistributionForm();
		        	session.setAttribute("bon_distribution", mon_bon);

			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			        if(liste_vehicule.size()!=0)
			        {
			        mon_bon.setId_vehicule(liste_vehicule.get(0).getId_vehicule());	 
			        ldao.maj_distribution(mon_bon);
			    	session.setAttribute("bon_distribution", mon_bon);
			        }
			        session.setAttribute("liste_bon_distribution", liste);
			    	session.removeAttribute("x");

			    }
			   
			   
			   
			   if(action.equals("changement_centre"))
			   {
				   
				   String id_centre=request.getParameter("id_centre");
				   BonDistributionForm tfrm= (BonDistributionForm)form;
				   if(id_centre!=null)
				   {
					   
					   liste_agence=agencedao.select(id_centre);
				    	session.setAttribute("liste_agence", liste_agence);
				    	
				    	if(liste_agence.size()!=0)
				    	{
				    	liste_service=servicedao.select(new ServiceForm("","",id_centre,"",liste_agence.get(0).getId_agence(),""));
				    	session.setAttribute("liste_service", liste_service);
				    	}
				    	else 
				    	 	session.setAttribute("liste_service", liste_service);
				     
				   }
				   
				   session.setAttribute("bon_distribution", tfrm);
			   }
			   
			   
			   
			   
			   if(action.equals("changement_agence"))
			   {
				   
				   String id_agence=request.getParameter("id_agence");
				   BonDistributionForm tfrm= (BonDistributionForm)form;
				   tfrm.setId_agence(id_agence);
				   session.setAttribute("bon_distribution", tfrm);
				   
				 
				   		
				    	liste_service=servicedao.select(new ServiceForm("","",tfrm.getId_centre(),"",id_agence,""));
				    	session.setAttribute("liste_service", liste_service);
				    	
				
				   
				  
			   }
			   
			   
			   if(action.equals("changement_vehicule"))
			   {
				   
				   String id_vehicule=request.getParameter("id_vehicule");
				   BonDistributionForm tfrm= (BonDistributionForm)form;
				   tfrm.setId_agence(id_vehicule);
				   ldao.maj_distribution(tfrm);
				   session.setAttribute("bon_distribution", tfrm);	   
				  
			   }
			   
		   
			   cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




