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
import Bean.LaisserPasserForm;
import Bean.SaisonForm;
import Bean.ServiceForm;
import Bean.StationMaintForm;
import Bean.VehiculeForm;
import Dao.AgentDao;
import Dao.Conn;
import Dao.FicheSocieteDao;
import Dao.LaisserPasserDao;
import Dao.SaisonDao;
import Dao.ServiceDao;
import Dao.StationMaintDao;
import Dao.VehiculeDao;



public class LaisserPasserAction extends Action {
	
		 
		
		
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



		   LaisserPasserDao ldao =new LaisserPasserDao(cnx.getcnx());
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

              
          
          if(action.equals("print"))
		    {   String id_laisser_passer=request.getParameter("id_laisser_passer");
		        String id_exercice=request.getParameter("id_exercice");
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
  		   	int id=fdao.getnb();
              String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
              
              temp4=temp4.replace(".gif", id-1+".gif");
              temp4.replace("\\", "\\\\");
		    	
				    String source = "/report/laisser_passer.jasper";
	                Map<String, String> hParametre = new HashMap<String, String>();
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());              
	                if(!new java.io.File(temp4).exists())
		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		              
	                hParametre.put("image", temp4);
	                hParametre.put("id_laisser_passer", id_laisser_passer);
	                hParametre.put("id_exercice", id_exercice);

	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
			 frd="";
		    }
		    

	        if(action.equals("ajout"))
	        {  
	        	boolean test=true;
	        	LaisserPasserForm tfrm=(LaisserPasserForm) form;
	        	 session.setAttribute("laisser_passer", new LaisserPasserForm());
	        	 if(tfrm.getId_laisser_passer()==null||tfrm.getId_laisser_passer().equals("")||tfrm.getId_laisser_passer().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_laisser_passer("");
		    	session.setAttribute("laisser_passer",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");
	           	session.setAttribute("laisser_passer",new LaisserPasserForm());
	        	}
	 
	            
	            }
	        	
	        	ArrayList<LaisserPasserForm> liste=new ArrayList<LaisserPasserForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_laisser_passer", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien"); 
		      	session.removeAttribute("x");
	        }
	        
	        if(action.equals("edit"))
	        {   session.setAttribute("x", ""); 
	        	session.setAttribute("laisser_passer",new LaisserPasserForm());
	        	LaisserPasserForm tfrm=(LaisserPasserForm) form;
	        	LaisserPasserForm aux=ldao.recup(tfrm.getId_laisser_passer(),tfrm.getId_annee());
	        	if(aux==null)
	        	{  session.setAttribute("erreur", "er_modif");
	          	session.setAttribute("laisser_passer",tfrm);
	        	session.setAttribute("x"," ");
	        	}
	        	else{
	        		
	        		
	     
	        	
	        		boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");  
	        	        tfrm.setValide("en attente");
	        	        session.setAttribute("laisser_passer",tfrm);

	        	        }
	        	        else{ session.setAttribute("erreur", "er_modif1");
	        	       	session.setAttribute("laisser_passer",tfrm);
	        	        session.setAttribute("x"," ");
	        	        }
	        	     }
	        
		   

	        	

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      String annee=request.getParameter("annee");
	      LaisserPasserForm aux=ldao.recup(id,annee);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.removeAttribute("x");
		  }
		  else{int pos=0;
			ArrayList<LaisserPasserForm> liste=new ArrayList<LaisserPasserForm>();
	    	liste=ldao.all();
	      session.setAttribute("laisser_passer",  aux);
	      System.out.println(aux.getId_station());
	      System.out.println(aux.getId_laisser_passer());
	      session.setAttribute("x", " ");
	      
	      
	      

			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", indice(aux.getId_laisser_passer(),liste));
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
				LaisserPasserForm aux=ldao.recup(id,annee);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id,annee);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<LaisserPasserForm> liste=new ArrayList<LaisserPasserForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_laisser_passer", liste);
		    	session.setAttribute("laisser_passer", new LaisserPasserForm());
	
		  
		    	
		    	
				liste=ldao.all();
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	LaisserPasserForm temp=liste.get(pos);
				    	if(Utilitaire.present(request, "x"))
				    	session.setAttribute("laisser_passer", temp);
				    	session.setAttribute("pos", indice(temp.getId_laisser_passer(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("laisser_passer", new LaisserPasserForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			}
			
			
			
			
			
			
			
			

		    

			
			
			   if(action.equals("all"))
			    {
				
			    	session.setAttribute("laisser_passer", new LaisserPasserForm());
			    	session.removeAttribute("x");
			   
			    	
			    }
			   
			   
		
			   
			   
			   
			   if(action.equals("sui"))
			   {
				   String id=request.getParameter("id");
				   ArrayList<LaisserPasserForm> liste=new ArrayList<LaisserPasserForm>();
			       liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	LaisserPasserForm temp=suivant(id,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	session.setAttribute("laisser_passer", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_laisser_passer(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("laisser_passer", new LaisserPasserForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   if(action.equals("pred"))
			   {
					 String id=request.getParameter("id");
				   ArrayList<LaisserPasserForm> liste=new ArrayList<LaisserPasserForm>();
			    	liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	LaisserPasserForm temp=pred(id,liste);
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	session.setAttribute("laisser_passer", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_laisser_passer(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("laisser_passer", new LaisserPasserForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   ArrayList<LaisserPasserForm> liste=new ArrayList<LaisserPasserForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_laisser_passer", liste);
		    	
			   
   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		public LaisserPasserForm suivant(String id, ArrayList<LaisserPasserForm> liste) 
		{LaisserPasserForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_laisser_passer().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public LaisserPasserForm pred(String id, ArrayList<LaisserPasserForm> liste) 
		{LaisserPasserForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_laisser_passer().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id, ArrayList<LaisserPasserForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_laisser_passer().equals(id))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
		
		

	
	}




