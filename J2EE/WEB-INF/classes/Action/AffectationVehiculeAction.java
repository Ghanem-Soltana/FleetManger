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
import Bean.ServiceForm;
import Bean.VehiculeForm;
import Dao.AgenceDao;
import Dao.CentreDao;
import Dao.Conn;
import Dao.AffectationVehiculeDao;
import Dao.ServiceDao;
import Dao.VehiculeDao;

public class AffectationVehiculeAction extends Action {
	
		 
		
		
		@SuppressWarnings("unchecked")
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
		    session.removeAttribute("liste_vehicule");
		    
		   AffectationVehiculeDao ldao =new AffectationVehiculeDao(cnx.getcnx());
		   VehiculeDao vehiculedao =new VehiculeDao(cnx.getcnx());
		   CentreDao centredao =new CentreDao(cnx.getcnx());
		   AgenceDao agencedao =new AgenceDao(cnx.getcnx());
		   ServiceDao servicedao =new ServiceDao(cnx.getcnx());
		   
		   
		    ArrayList<VehiculeForm> liste_vehicule= new ArrayList<VehiculeForm>();	 
		   	liste_vehicule=vehiculedao.all();
	    	session.setAttribute("liste_vehicule", liste_vehicule);
		   
	    	ArrayList<CentreForm> liste_centre=new ArrayList<CentreForm>();
	    	liste_centre=centredao.all();
	    	session.setAttribute("liste_centre", liste_centre);
		   

		    ArrayList <AgenceForm> liste_agence =new ArrayList<AgenceForm>();
		    ArrayList <ServiceForm> liste_service =new ArrayList<ServiceForm>();

	    	
	    try{
	    	
	        if(action.equals("ajout"))
	        {   session.setAttribute("affect_vehi", new AffectationVehiculeForm());
	        	boolean test=true;
	        	AffectationVehiculeForm tfrm=(AffectationVehiculeForm) form;
	        	test=ldao.add(tfrm);
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant"); 
		    	session.setAttribute("affect_vehi", tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}

		    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
		    	liste=ldao.all();
		    	
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_affect_vehi", liste);
		    	session.setAttribute("affect_vehi", new AffectationVehiculeForm());
		    	session.setAttribute("liste_agence", liste_agence);
		    	session.setAttribute("liste_service", liste_service);
		    	
		    	if(liste_centre.size()!=0)
		    	{
		    	liste_agence=agencedao.select(liste_centre.get(0).getId_centre());
		    	session.setAttribute("liste_agence", liste_agence);
		    	}
		    	if(liste_agence.size()!=0)
		    	{
		    	liste_service=servicedao.select(new ServiceForm("","",liste_centre.get(0).getId_centre(),"",liste_agence.get(0).getId_agence(),""));
		    	session.setAttribute("liste_service", liste_service);
		    	}
		    	
		    	session.removeAttribute("x");	
	        	
	        }
	  
	        
	   

	        
		    
			if(action.equals("supp"))
			{   
				String id_vehi=request.getParameter("id_vehi");
				String id_serv=request.getParameter("id_serv");
				String date_affectation=request.getParameter("dat_aff");
				
				AffectationVehiculeForm aux=ldao.recup(id_vehi,id_serv,date_affectation );
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id_vehi,id_serv,date_affectation );
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_affect_vehi", liste);
		    	session.setAttribute("affect_vehi", new AffectationVehiculeForm());
		    	

			
			}
			
			
			if(action.equals("modif"))
			{
			String id_vehi=request.getParameter("id_vehi");
			String id_serv=request.getParameter("id_serv");
			String date_affectation=request.getParameter("dat_aff");
			AffectationVehiculeForm aux=ldao.recup(id_vehi,id_serv,date_affectation );
			
			if(aux==null)
				  {session.setAttribute("erreur", "er_modif");
			       session.removeAttribute("x");
				  }
				  else{
					  AffectationVehiculeForm x= ldao.recup(id_vehi,id_serv,date_affectation );
			          session.setAttribute("affect_vehi",  x);
			          session.setAttribute("affect_vehi_init",  x);
			          session.setAttribute("x", "");
			          
			         
				    
				    	liste_agence=agencedao.select(x.getId_centre());
				    	session.setAttribute("liste_agence", liste_agence);
				    
				    	
				    	liste_service=servicedao.select(new ServiceForm("","",x.getId_centre(),"",x.getId_agence(),""));
				    	session.setAttribute("liste_service", liste_service);
				    	
				      }
			}
			
			
			
			if(action.equals("edit") )
					{
				String id_vehi=request.getParameter("id_vehi");
				String id_serv=request.getParameter("id_serv");
				String date_affectation=request.getParameter("dat_aff");
				AffectationVehiculeForm aux=ldao.recup(id_vehi,id_serv,date_affectation );
				AffectationVehiculeForm tfrm= (AffectationVehiculeForm)form;
				
				if(aux==null)
		  		  {session.setAttribute("erreur", "er_modif");
			    	session.setAttribute("affect_vehi", new AffectationVehiculeForm());
		  		  }
		        	else{boolean modif=ldao.update(id_vehi,id_serv,date_affectation,tfrm);
		        	        if(modif)
		        	        {session.setAttribute("sms", "modif_ok");
		        	    	session.removeAttribute("x");
		        	    	session.removeAttribute("affect_vehi_init");
					    	session.setAttribute("affect_vehi", new AffectationVehiculeForm());
					    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
					    	liste=ldao.all();
					    	
					    	if(liste.size()==0)
					    	session.setAttribute("listevide", "rien");
					    	session.setAttribute("liste_affect_vehi", liste);

					    	
					    	session.setAttribute("liste_agence", liste_agence);
					    	session.setAttribute("liste_service", liste_service);
					    	
					    	if(liste_centre.size()!=0)
					    	{
					    	liste_agence=agencedao.select(liste_centre.get(0).getId_centre());
					    	session.setAttribute("liste_agence", liste_agence);
					    	}
					    	if(liste_agence.size()!=0)
					    	{
					    	liste_service=servicedao.select(new ServiceForm("","",liste_centre.get(0).getId_centre(),"",liste_agence.get(0).getId_agence(),""));
					    	session.setAttribute("liste_service", liste_service);
					    	}
					    
					    	
		        	        }
		        	        else session.setAttribute("erreur", "er_modif1");
		        	     }
		        
			   
				
					}
			
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_affect_vehi", liste);
			    	session.setAttribute("affect_vehi", new AffectationVehiculeForm());
			    	session.setAttribute("liste_agence", liste_agence);
			    	session.setAttribute("liste_service", liste_service);
			    	
			    	if(liste_centre.size()!=0)
			    	{
			    	liste_agence=agencedao.select(liste_centre.get(0).getId_centre());
			    	session.setAttribute("liste_agence", liste_agence);
			    	}
			    	if(liste_agence.size()!=0)
			    	{
			    	liste_service=servicedao.select(new ServiceForm("","",liste_centre.get(0).getId_centre(),"",liste_agence.get(0).getId_agence(),""));
			    	session.setAttribute("liste_service", liste_service);
			    	}
			    	
			    	session.removeAttribute("x");	
			    }
			   
			   
			   
			   
			   if(action.equals("changement_centre"))
			   {
				   
				   String id_centre=request.getParameter("id_centre");
				   AffectationVehiculeForm tfrm= (AffectationVehiculeForm)form;
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
				   
				   session.setAttribute("affect_vehi", tfrm);
			   }
			   
			   
			   
			   
			   if(action.equals("changement_agence"))
			   {
				   
				   String id_agence=request.getParameter("id_agence");
				   AffectationVehiculeForm tfrm= (AffectationVehiculeForm)form;
				   tfrm.setId_agence(id_agence);
				   session.setAttribute("affect_vehi", tfrm);
				   
				 
				   		
				    	liste_service=servicedao.select(new ServiceForm("","",tfrm.getId_centre(),"",id_agence,""));
				    	session.setAttribute("liste_service", liste_service);
				    	
				
				   
				  
			   }
			   
			   
			   try{
				   
			    	ArrayList<AffectationVehiculeForm> liste=new ArrayList<AffectationVehiculeForm>();
			    	liste=(ArrayList<AffectationVehiculeForm> )session.getAttribute("liste_affect_vehi");
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_affect_vehi", liste);
			   }catch(Exception e ){System.out.println(e);}
			   
			   
			   
	    }catch(Exception e ){System.out.println(e);}
			   } cnx.closecnx();
		   
			return mapping.findForward(frd);
		}
		
		

	
	}




