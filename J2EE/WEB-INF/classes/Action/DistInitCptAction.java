package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.DistInitCptForm;
import Bean.TypeCompteurForm;
import Bean.VehiculeForm;
import Dao.Conn;
import Dao.DistInitCptDao;
import Dao.VehiculeDao;


public class DistInitCptAction extends Action {
	
		 
		
		
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
		    session.removeAttribute("liste_init_cpt");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
            



		    DistInitCptDao ldao =new DistInitCptDao(cnx.getcnx());
		    VehiculeDao vehiculedao =new VehiculeDao(cnx.getcnx());
		   
		    ArrayList<TypeCompteurForm> liste_type_compteur=ldao.getTypeCpt();
		    session.setAttribute("liste_type_compteur", liste_type_compteur);
		    ArrayList<VehiculeForm> liste_vehicule=vehiculedao.pas_encore_de_compteur();
		    session.setAttribute("liste_vehicule", liste_vehicule);


try{
	        if(action.equals("ajout"))
	        {  
	        	boolean test=true;
	        	DistInitCptForm tfrm=(DistInitCptForm) form;

	          
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_vehicue("");
	        	tfrm.setId_type_cpt("");
		    	session.setAttribute("init_cpt",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}
	        	
	        	ArrayList<DistInitCptForm> liste=new ArrayList<DistInitCptForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_init_cpt", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien"); 
		      	session.removeAttribute("x");
			    session.setAttribute("liste_vehicule", vehiculedao.pas_encore_de_compteur());
	        }
	        
	        if(action.equals("edit"))
	        { session.setAttribute("init_cpt",new DistInitCptForm());
	        	DistInitCptForm tfrm=(DistInitCptForm) form;
	        	DistInitCptForm aux=ldao.recup(tfrm.getId_vehicue(),tfrm.getId_type_cpt());
	        	if(aux==null)
	  		  session.setAttribute("erreur", "er_modif");
	  		  
	  		  
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");  
	        	        session.setAttribute("init_cpt",new DistInitCptForm());
	        	        session.removeAttribute("x");
	        	        }
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        
		   

	        	 ArrayList<DistInitCptForm> liste=new ArrayList<DistInitCptForm>();
			    	liste=ldao.all();
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_init_cpt", liste);
			    	

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	        	String id_mac=request.getParameter("id_mac");
				String id_rel=request.getParameter("id_rel");
				DistInitCptForm aux=ldao.recup(id_mac,id_rel);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("init_cpt", new DistInitCptForm());
		  session.removeAttribute("x");
		  }
		  else{
		  DistInitCptForm x= ldao.recup(id_mac,id_rel);
	      session.setAttribute("init_cpt",  x);

		  }
		  
			 ArrayList<DistInitCptForm> liste=new ArrayList<DistInitCptForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_init_cpt", liste);
		    	session.setAttribute("x"," ");
		  
		  


	        }  
		    
			if(action.equals("supp"))
			{   	
				String id_mac=request.getParameter("id_mac");
				String id_rel=request.getParameter("id_rel");
				DistInitCptForm aux=ldao.recup(id_mac,id_rel);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
					
				boolean libre=ldao.peutetresupprimer(id_mac,id_rel);	
					System.out.println(libre);
				if(libre)
				{
				boolean test=ldao.delete(id_mac,id_rel);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
				else 
					session.setAttribute("erreur", "er_releve");
				}
		    	ArrayList<DistInitCptForm> liste=new ArrayList<DistInitCptForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_init_cpt", liste);
		    	session.setAttribute("init_cpt", new DistInitCptForm());
			    session.setAttribute("liste_vehicule", liste_vehicule);
			    session.setAttribute("liste_vehicule", vehiculedao.pas_encore_de_compteur());
		  
		    
			}
			
		
		
			
			   if(action.equals("all"))
			    {
				
				   
				   ArrayList<DistInitCptForm> liste=new ArrayList<DistInitCptForm>();
			    	liste=ldao.all();
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_init_cpt", liste);
			    	session.removeAttribute("x");
			    	session.setAttribute("init_cpt",new DistInitCptForm());
			    	
			    }
			   
			   
		
			   
			   
			   
			 
			   
			   
			

		    	
			   
		}catch(Exception e ){System.out.println(e);}		   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		



	
	}




