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
import Bean.CategorieVehiculeForm;
import Bean.MarqueVehiForm;
import Bean.ModeleVehiForm;
import Bean.StationMaintForm;
import Bean.VehiculeForm;
import Dao.CategorieVehiculeDao;
import Dao.Conn;
import Dao.FicheSocieteDao;
import Dao.MarqueVehiDao;
import Dao.ModeleVehiDao;
import Dao.StationMaintDao;
import Dao.VehiculeDao;


public class VehiculeAction extends Action {
	
		 
		
		
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
		    session.removeAttribute("liste_modele");
	        session.removeAttribute("liste_marque");
	        session.removeAttribute("liste_categorie");
	        session.removeAttribute("liste_station");


		   VehiculeDao ldao =new VehiculeDao(cnx.getcnx());
		   ModeleVehiDao modeledao =new  ModeleVehiDao (cnx.getcnx());
		   MarqueVehiDao marquedao =new MarqueVehiDao(cnx.getcnx());
		   CategorieVehiculeDao categoriedao =new CategorieVehiculeDao(cnx.getcnx());
		   StationMaintDao stationdao =new  StationMaintDao (cnx.getcnx());
           
		  ArrayList< ModeleVehiForm >liste_modele= modeledao.all();
		  ArrayList< MarqueVehiForm >liste_marque= marquedao.all();
		  ArrayList< CategorieVehiculeForm >liste_categorie= categoriedao.all();
		  ArrayList< StationMaintForm >liste_station= stationdao.all();
		  
		  //peut ne pas définir une station
		  liste_station.add(0,new StationMaintForm("xxxxxx","          "));
		  
          session.setAttribute("liste_modele",liste_modele);
          session.setAttribute("liste_marque", liste_marque);
          session.setAttribute("liste_categorie", liste_categorie);
          session.setAttribute("liste_station", liste_station);
          
        	VehiculeForm vider =new VehiculeForm();
        	vider.setImprime(true);

          try{
        	    if(action.equals("print"))
    		    {   String id_vehiccule=request.getParameter("id_vehicule");
    		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
        		   	int id=fdao.getnb();
                    String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
                    
                    temp4=temp4.replace(".gif", id-1+".gif");
                    temp4.replace("\\", "\\\\");
    		    	
    				    String source = "/report/vehicule.jasper";
    	                Map<String, String> hParametre = new HashMap<String, String>();
    	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
    	                hParametre.put("societe", societeldao.all().getLibelle_societe());
    	                hParametre.put("sigle", societeldao.all().getSigle());              
    	                if(!new java.io.File(temp4).exists())
    		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
    		              
    	                hParametre.put("image", temp4);
    	                hParametre.put("id_vehicule", id_vehiccule);
    	                try{
    	                hParametre.put("station", ldao.recup(id_vehiccule).getLibelle_station());
    	                }catch(Exception e){ hParametre.put("station", " ");}
    	                response.setContentType("application/pdf");
    	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
    	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
    			 frd="";
    		    }
    		    

	        if(action.equals("ajout"))
	        {  
	        	boolean test=true;
	        	VehiculeForm tfrm=(VehiculeForm) form;
	      
	        	 session.setAttribute("vehicule", vider);
	   

	            if(tfrm.getId_vehicule()==null||tfrm.getId_vehicule().equals("")||tfrm.getId_vehicule().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_vehicule("");
		    	session.setAttribute("vehicule",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_vehicule", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien"); 
		      	session.removeAttribute("x");
	        }
	        
	        if(action.equals("edit"))
	        { session.setAttribute("vehicule",vider);
	        	VehiculeForm tfrm=(VehiculeForm) form;
	        	VehiculeForm aux=ldao.recup(tfrm.getId_vehicule());
	        	if(aux==null)
	  		  session.setAttribute("erreur", "er_modif");
	  		  
	  		  
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");  
	        	        session.setAttribute("vehicule",tfrm);

	        	        }
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        
		   

	        	session.setAttribute("x", ""); 

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      VehiculeForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("vehicule", vider);
		  session.removeAttribute("x");
		  }
		  else{int pos=0;
			ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
	    	liste=ldao.all();
		  VehiculeForm x= ldao.recup(id);
	      session.setAttribute("vehicule",  x);
	      session.setAttribute("x", "");
	      
	      
	      

			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    
			    	session.setAttribute("vehicule", x);
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", indice(x.getId_vehicule(),liste));
			    	session.setAttribute("total", liste.size());
		
						    
			   }
			   else 
			   {  
				   session.setAttribute("liste_vide", " ");    	
			  	session.setAttribute("vehicule", vider);
		    	session.setAttribute("x", "modifier");
		    	session.setAttribute("pos", "0");
		    	session.setAttribute("total", "0");
			   }
		  }


	        }  
		    
			if(action.equals("supp"))
			{   	int pos=0;
				String id=request.getParameter("id");
				VehiculeForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_vehicule", liste);
		    	session.setAttribute("vehicule", vider);
	
		  
		    	
		    	
				liste=ldao.all();
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	VehiculeForm temp=liste.get(pos);
				    	if(Utilitaire.present(request, "x"))
				    	session.setAttribute("vehicule", temp);
				    	session.setAttribute("pos", indice(temp.getId_vehicule(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("vehicule", vider);
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			}
			
			
			if(action.equals("supp1"))
			{   	
				String id=request.getParameter("id");
				VehiculeForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_vehicule", liste);
		    	session.setAttribute("vehicule",vider);
	
		  
		    	
		    
			}
			
			   if(action.equals("all"))
			    {
				
			    	session.setAttribute("vehicule", vider);
			    	session.removeAttribute("x");
			   
			    	
			    }
			   
			   
		
			   
			   
			   
			   if(action.equals("sui"))
			   {
				   String id=request.getParameter("id");
				   ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
			       liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	VehiculeForm temp=suivant(id,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	session.setAttribute("vehicule", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_vehicule(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("vehicule", vider);
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   if(action.equals("pred"))
			   {
					 String id=request.getParameter("id");
				   ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
			    	liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	VehiculeForm temp=pred(id,liste);
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	session.setAttribute("vehicule", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_vehicule(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("vehicule", vider);
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   ArrayList<VehiculeForm> liste=new ArrayList<VehiculeForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_vehicule", liste);
		    	
			   
          }catch(Exception e){}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		public VehiculeForm suivant(String id, ArrayList<VehiculeForm> liste) 
		{VehiculeForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_vehicule().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public VehiculeForm pred(String id, ArrayList<VehiculeForm> liste) 
		{VehiculeForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_vehicule().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id, ArrayList<VehiculeForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_vehicule().equals(id))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
		
		

	
	}




