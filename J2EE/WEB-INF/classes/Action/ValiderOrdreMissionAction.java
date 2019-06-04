package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.AgentForm;
import Bean.OrdreMissionForm;
import Bean.SaisonForm;
import Bean.ServiceForm;
import Bean.StationMaintForm;
import Bean.VehiculeForm;
import Dao.AgentDao;
import Dao.Conn;
import Dao.OrdreMissionDao;
import Dao.SaisonDao;
import Dao.ServiceDao;
import Dao.StationMaintDao;
import Dao.VehiculeDao;



public class ValiderOrdreMissionAction extends Action {
	
		 
		
		
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
	
		    

		    session.removeAttribute("listevide");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    session.removeAttribute("liste_accompagnants");




		   OrdreMissionDao ldao =new OrdreMissionDao(cnx.getcnx());
		   SaisonDao anneedao =new  SaisonDao (cnx.getcnx());
		   StationMaintDao stationdao =new StationMaintDao(cnx.getcnx());
		   VehiculeDao vehiculedao =new VehiculeDao(cnx.getcnx());
		   AgentDao agentdao =new  AgentDao (cnx.getcnx());
		   ServiceDao servicedao =new  ServiceDao (cnx.getcnx());

		  ArrayList< SaisonForm >liste_annee=  anneedao.noncloture();
		  ArrayList< StationMaintForm >liste_station= stationdao.all();
		  ArrayList< VehiculeForm >liste_vehicule= vehiculedao.nonarrete();
		  ArrayList< AgentForm >liste_agent= agentdao.operationelle();
		  ArrayList< ServiceForm >liste_service= servicedao.all();
		  
		  
          session.setAttribute("liste_annee",liste_annee);
          session.setAttribute("liste_station", liste_station);
          session.setAttribute("liste_vehicule", liste_vehicule);
          session.setAttribute("liste_agent", liste_agent);
          session.setAttribute("liste_service", liste_service);


           if(action.equals("valider"))
           {
        	   OrdreMissionForm tfrm=(OrdreMissionForm)form;
        	   ldao.valider(tfrm);
        	   session.setAttribute("sms", "valifer_laisser_ok");

        	   int pos=0;
        	   
        	   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_ordre_mission", liste);

	
		    	
				
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm temp=liste.get(pos);
				    	ldao.lienagent(temp);
				    	session.setAttribute("liste_accompagnants",ldao.getaccompagants(temp.getAccompagant()));
				    	session.setAttribute("ordre_mission", temp);
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					 session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("ordre_mission", new OrdreMissionForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
           }

	        

           if(action.equals("refuser"))
           {
        	   OrdreMissionForm tfrm=(OrdreMissionForm)form;
        	   ldao.refuser(tfrm);
        	   session.setAttribute("sms", "refus_laisser_ok");

        	   int pos=0;
        	   
        	   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
               liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_ordre_mission", liste);

	
		    	
				
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm temp=liste.get(pos);
				    	session.setAttribute("ordre_mission", temp);
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("ordre_mission", new OrdreMissionForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
           }

	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      String annee=request.getParameter("annee");
	      OrdreMissionForm aux=ldao.recup(id,annee);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.removeAttribute("x");
		  }
		  else{int pos=0;
			ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
	    	liste=ldao.en_attente();
	    	ldao.lienagent(aux);
		    session.setAttribute("liste_accompagnants",ldao.getaccompagants(aux.getAccompagant()));
	      session.setAttribute("ordre_mission",  aux);
	      session.setAttribute("x", " ");
	      
	      
	      

			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", indice(aux.getId_ordre_mission(),liste));
			    	session.setAttribute("total", liste.size());
		
						    
			   }
			   else 
			   {  
				session.setAttribute("liste_vide", " ");    	
		    	session.setAttribute("pos", "0");
		    	session.setAttribute("total", "0");
			   }
		  }
	        }  
	        
	        
	        
	        
	  
			
			
			
			
			
			

		    

			
			
			   if(action.equals("all"))
			    {ldao.annuler_alerte_ordre_mission();
				
			    	session.setAttribute("ordre_mission", new OrdreMissionForm());
			    	session.removeAttribute("x");
			    	
			    	int pos=0;
					ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
			    	liste=ldao.en_attente();
			    	OrdreMissionForm aux=new OrdreMissionForm();
			    	if(liste.size()!=0)
			    	 aux=liste.get(0);
			    	ldao.lienagent(aux);
			      session.setAttribute("liste_accompagnants",ldao.getaccompagants(aux.getAccompagant()));
			      session.setAttribute("ordre_mission",  aux);
			      session.setAttribute("x", " ");
			      
			      
			      

					   if(pos<0)
						   pos=liste.size();
					   if(pos>=liste.size())
						   pos=0;
					   
					    	
					   if(liste.size()!=0)
					   {
					    
					    	session.setAttribute("x", "modifier");
					    	session.setAttribute("pos", indice(aux.getId_ordre_mission(),liste));
					    	session.setAttribute("total", liste.size());
				
								    
					   }
					   else 
					   {  
						session.setAttribute("liste_vide", " ");    	
				    	session.setAttribute("pos", "0");
				    	session.setAttribute("total", "0");
					   }
				  
			    	
			    }
			   
			   
		
			   
			   
			   
			   if(action.equals("sui"))
			   {
				   String id=request.getParameter("id");
				   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
			       liste=ldao.en_attente();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm temp=suivant(id,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	ldao.lienagent(temp);
					    session.setAttribute("liste_accompagnants",ldao.getaccompagants(temp.getAccompagant()));
				    	session.setAttribute("ordre_mission", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("ordre_mission", new OrdreMissionForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   if(action.equals("pred"))
			   {
					 String id=request.getParameter("id");
				   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
			    	liste=ldao.en_attente();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm temp=pred(id,liste);
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	ldao.lienagent(temp);
					    session.setAttribute("liste_accompagnants",ldao.getaccompagants(temp.getAccompagant()));
				    	session.setAttribute("ordre_mission", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("ordre_mission", new OrdreMissionForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_ordre_mission", liste);
		    	
		    	
		    	
			   
   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		public OrdreMissionForm suivant(String id, ArrayList<OrdreMissionForm> liste) 
		{OrdreMissionForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_ordre_mission().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public OrdreMissionForm pred(String id, ArrayList<OrdreMissionForm> liste) 
		{OrdreMissionForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_ordre_mission().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id, ArrayList<OrdreMissionForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_ordre_mission().equals(id))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
		
		

	
	}




