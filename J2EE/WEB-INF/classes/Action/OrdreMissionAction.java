package Action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import Dao.FicheSocieteDao;
import Dao.OrdreMissionDao;
import Dao.SaisonDao;
import Dao.ServiceDao;
import Dao.StationMaintDao;
import Dao.VehiculeDao;



public class OrdreMissionAction extends Action {
	
		 
		
		
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
          session.setAttribute("liste_agent_1", liste_agent);
          session.setAttribute("liste_agent_2",  new ArrayList< AgentForm >());
          session.setAttribute("liste_service", liste_service);

          if(action.equals("print"))
		    {   String id_ordre_mission=request.getParameter("id_ordre_mission");
		        String id_exercice=request.getParameter("id_exercice");
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
		   	int id=fdao.getnb();
            String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
            
            temp4=temp4.replace(".gif", id-1+".gif");
            temp4.replace("\\", "\\\\");
		    	
            
                  OrdreMissionForm imprime=ldao.recup(id_ordre_mission, id_exercice);
                  String source =""; 
                  Map<String, String> hParametre = new HashMap<String, String>();
                  if(imprime==null)
				   source = "/report/vide.jasper";
                  else    if(!imprime.getValide().equals("validé"))
   				   source = "/report/vide.jasper";
                  else{
                	source = "/report/ordre_mission_individuelle.jasper";
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());              
	                if(!new java.io.File(temp4).exists())
		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		              
	                hParametre.put("image", temp4);
	                hParametre.put("id_exercice", id_exercice);
	                hParametre.put("id_ordre_mission", imprime.getId_ordre_mission());
	                hParametre.put("libelle_exercice", imprime.getLibelle_annee());
	                hParametre.put("date", imprime.getDate_ordre_mission());
	                hParametre.put("vehicule", imprime.getLibelle_vehicule());
	              
                    try{
	                hParametre.put("station",  vehiculedao.recup(imprime.getId_vehicule()).getLibelle_station());
                    }catch(Exception e){hParametre.put("station",  " ");}
	                hParametre.put("agent", imprime.getLibelle_agent());
	                hParametre.put("objectif", imprime.getObjectif());
	                hParametre.put("depart", imprime.getDepart());
	                hParametre.put("destination", imprime.getDestination());
	                hParametre.put("marchandise", imprime.getMarchandise_transporte());
	            
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
                  }	              
           
	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
			 frd="";
		    }
		    

	        if(action.equals("ajout"))
	        {  
	        	boolean test=true;
	        	OrdreMissionForm tfrm=(OrdreMissionForm) form;
	        	 session.setAttribute("ordre_mission", new OrdreMissionForm());
	        	 if(tfrm.getId_ordre_mission()==null||tfrm.getId_ordre_mission().equals("")||tfrm.getId_ordre_mission().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_ordre_mission("");
	        	session.setAttribute("liste_agent_1", ldao.reste(tfrm.getAccompagant()) );
	        	session.setAttribute("liste_agent_2",ldao.getaccompagants(tfrm.getAccompagant()));
	        	session.setAttribute("ordre_mission",tfrm);
		    	
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");
	           	session.setAttribute("ordre_mission",new OrdreMissionForm());
	        	}
	 
	            
	            }
	        	
	        	ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_ordre_mission", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien"); 
		      	session.removeAttribute("x");
	        }
	        
	        if(action.equals("edit"))
	        {   session.setAttribute("x", ""); 
	        	session.setAttribute("ordre_mission",new OrdreMissionForm());
	        	OrdreMissionForm tfrm=(OrdreMissionForm) form;
	        	OrdreMissionForm aux=ldao.recup(tfrm.getId_ordre_mission(),tfrm.getId_annee());
	        	if(aux==null)
	        	{  session.setAttribute("erreur", "er_modif");
	          	   session.setAttribute("ordre_mission",tfrm);
	          	 	session.setAttribute("liste_agent_1", ldao.reste(tfrm.getAccompagant()) );
		        	session.setAttribute("liste_agent_2",ldao.getaccompagants(tfrm.getAccompagant()));
			
	        	}
	        	else{
	        		
	        		
	        	
	        		boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");  
	        	        tfrm.setValide("en attente");
	        	        session.setAttribute("ordre_mission",tfrm);
	        	    	session.setAttribute("liste_agent_1", ldao.reste(tfrm.getAccompagant()) );
			        	session.setAttribute("liste_agent_2",ldao.getaccompagants(tfrm.getAccompagant()));

	        	        }
	        	        else{ session.setAttribute("erreur", "er_modif1");
	        	       	session.setAttribute("ordre_mission",tfrm);
	        	    	session.setAttribute("liste_agent_1", ldao.reste(tfrm.getAccompagant()) );
			        	session.setAttribute("liste_agent_2",ldao.getaccompagants(tfrm.getAccompagant()));
	    
	        	        }
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
	    	liste=ldao.all();
	    	
	    	
	    	ldao.lienagent(aux);
	    	session.setAttribute("liste_agent_1", ldao.reste(aux.getAccompagant()) );
        	session.setAttribute("liste_agent_2",ldao.getaccompagants(aux.getAccompagant()));
	        session.setAttribute("ordre_mission",  aux);
	        session.setAttribute("x", " ");
	      
	      
	      

			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", indice(aux.getId_ordre_mission(),aux.getId_annee(),liste));
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
	        
	        
	        
	        
	  
		    
			if(action.equals("supp"))
			{   	int pos=0;
				String id=request.getParameter("id");
				String annee=request.getParameter("annee");
				OrdreMissionForm aux=ldao.recup(id,annee);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id,annee);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_ordre_mission", liste);
		    	session.setAttribute("ordre_mission", new OrdreMissionForm());
	
		  
		    	
		    	
				liste=ldao.all();
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm temp=liste.get(pos);
				    	if(Utilitaire.present(request, "x"))
				    	session.setAttribute("ordre_mission", temp);
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),temp.getId_annee(),liste));
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
			
			
			
			
			
			
			
			

		    

			
			
			   if(action.equals("all"))
			    {
				
			    	session.setAttribute("ordre_mission", new OrdreMissionForm());
			    	session.removeAttribute("x");
			   
			    	
			    }
			   
			   
		
			   
			   
			   
			   if(action.equals("sui"))
			   {
				   String id=request.getParameter("id");
				   String annee=request.getParameter("annee");
				   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
			       liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm
				    	
				    	
				    	
				    	temp=suivant(id,annee,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	ldao.lienagent(temp);
				    	session.setAttribute("ordre_mission", temp);
         		    	session.setAttribute("liste_agent_1", ldao.reste(temp.getAccompagant()) );
			        	session.setAttribute("liste_agent_2",ldao.getaccompagants(temp.getAccompagant()));
				
				       
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),temp.getId_annee(),liste));
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
					 String annee=request.getParameter("annee");
				   ArrayList<OrdreMissionForm> liste=new ArrayList<OrdreMissionForm>();
			    	liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	OrdreMissionForm temp=pred(id,annee,liste);
				    	
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	ldao.lienagent(temp);
				    	session.setAttribute("ordre_mission", temp);
         		    	session.setAttribute("liste_agent_1", ldao.reste(temp.getAccompagant()) );
			        	session.setAttribute("liste_agent_2",ldao.getaccompagants(temp.getAccompagant()));
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_ordre_mission(),temp.getId_annee(),liste));
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
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_ordre_mission", liste);
		    	
			   
   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		public OrdreMissionForm suivant(String id_ordren,String id_annee, ArrayList<OrdreMissionForm> liste) 
		{OrdreMissionForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_ordre_mission().equals(id_ordren)&&liste.get(i).getId_annee().equals(id_annee))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public OrdreMissionForm pred(String id_ordren,String id_annee, ArrayList<OrdreMissionForm> liste) 
		{OrdreMissionForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_ordre_mission().equals(id_ordren)&&liste.get(i).getId_annee().equals(id_annee))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id_ordren,String id_annee, ArrayList<OrdreMissionForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_ordre_mission().equals(id_ordren)&&liste.get(i).getId_annee().equals(id_annee))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
		
		

	
	}




