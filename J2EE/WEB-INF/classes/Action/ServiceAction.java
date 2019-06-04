package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.CentreForm;
import Bean.AgenceForm;
import Bean.ServiceForm;
import Dao.Conn;
import Dao.CentreDao;
import Dao.AgenceDao;
import Dao.ServiceDao;

public class ServiceAction extends Action {
	
		 
		
		
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
		
		    
		    
		    session.removeAttribute("listevide");
		    session.removeAttribute("liste_vide_agence");
		    session.removeAttribute("liste_vide_centre");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    session.removeAttribute("liste2");
		    session.removeAttribute("liste3");
    	    session.removeAttribute("liste5");
		    ServiceDao ldao =new ServiceDao(cnx.getcnx());
		    CentreDao cdao =new  CentreDao(cnx.getcnx());
		    AgenceDao adao =new  AgenceDao(cnx.getcnx());
		    ServiceForm vider= new ServiceForm("","","xxxxxx","","","");
		    ArrayList<CentreForm> liste2= new ArrayList<CentreForm>();
		    ArrayList<CentreForm> liste3= new ArrayList<CentreForm>();
	    	liste2=cdao.all();
	    	liste3=cdao.all();
	    	liste3.add(0,new CentreForm("xxxxxx","tous","") );
	    	session.setAttribute("liste2", liste2);
	    	session.setAttribute("liste3", liste3);
	    	if(!Utilitaire.present(request, "vider"))
	    	session.setAttribute("vider", vider);
	    	
	    	   ServiceForm vider1= new ServiceForm("","","","","xxxxxx","");
			    ArrayList<AgenceForm> liste4= new ArrayList<AgenceForm>();
			    ArrayList<AgenceForm> liste5= new ArrayList<AgenceForm>();
			    if(liste2.size()!=0)
		    	liste4=adao.select(liste2.get(0).getId_centre());
		    	liste5=adao.all();
		    	liste5.add(0,new AgenceForm("xxxxxx","tous","","") );
		    	if(!action.equals("liste1")&&!action.equals("liste2")&&!action.equals("annul"))
		    	session.setAttribute("liste4", liste4);
		    	session.setAttribute("liste5", liste5);
		    	if(!Utilitaire.present(request, "vider1"))
		    	session.setAttribute("vider1", vider1);
		    
try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("service", new ServiceForm());
	        	boolean test=true;
	        	ServiceForm tfrm=(ServiceForm) form;
	            if(tfrm.getId_service()==null||tfrm.getId_service().equals("")||tfrm.getId_service().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("service", new ServiceForm("",tfrm.getLibelle_service(),tfrm.getId_centre(),tfrm.getLibelle_centre(),tfrm.getId_agence(),tfrm.getLibelle_agence()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	 ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_service", liste);
	        		if(liste.size()==0)
					  session.setAttribute("listevide", "rien");
	        		session.removeAttribute("x1");
	        }
	        
	        
	        
	        if(action.equals("edit"))
	        {
	        	ServiceForm tfrm=(ServiceForm) form;
	        	ServiceForm aux=ldao.recup(tfrm.getId_service());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("service", new ServiceForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	      
	        	 ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();   	
		    	liste=ldao.all();
		    	session.setAttribute("liste_service", liste);
		    
	    
	        		if(liste.size()==0)
				 session.setAttribute("listevide", "rien");
		    	session.setAttribute("service",new ServiceForm());
		    	session.removeAttribute("x1");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      ServiceForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("service", new ServiceForm());
		  session.removeAttribute("x1");
		  }
		  else{
		  ServiceForm x= ldao.recup(id);
	      session.setAttribute("service",  x);
	      session.setAttribute("x1", "");
	      liste4=adao.select(aux.getId_centre());
	      
	      
	      session.setAttribute("liste4",liste4);
		  if(liste4.size()==0)
	      session.setAttribute("liste_vide_agence", "rien");
	
	      
	      
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				ServiceForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}

	            ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();	  
		    	liste=ldao.all();
		    	session.setAttribute("liste_service", liste);
	
	        		if(liste.size()==0)
		 	   session.setAttribute("listevide", "rien");    	
		    	session.setAttribute("service", new ServiceForm());
		    	session.removeAttribute("x1");
			
			}
			
			   if(action.equals("all"))
			    {
				    session.removeAttribute("x1");
			    	ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
			    	liste=ldao.all();
			    	
			  
			    	session.setAttribute("liste_service", liste);
			    	session.setAttribute("service", new ServiceForm());
			    	session.removeAttribute("x1");
			    	if(liste.size()==0)
				 session.setAttribute("listevide", "rien");
			    	if(liste2.size()==0)
			     session.setAttribute("liste_vide_centre", "rien");
			    	if(liste4.size()==0)
				session.setAttribute("liste_vide_agence", "rien");
			    	vider.setId_agence("xxxxxx");
			    	vider.setId_centre("xxxxxx");
			    	session.setAttribute("vider", vider);
			    }
			   
			   if(action.equals("select"))
			   {String id=request.getParameter("id");
			   ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
			   liste=ldao.select(id);
			   if(liste.size()==0)
			    session.setAttribute("listevide", "rien");
			    session.setAttribute("liste_service", liste);
			    vider.setId_agence(id);
			    session.setAttribute("vider", vider);
			     
			   }
			   
			   if(action.equals("annul"))
			   {     session.removeAttribute("x1");
					 ServiceForm temp=(ServiceForm)session.getAttribute("vider1");
		        	 ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
		        	 if(temp.getId_agence().equals("xxxxxx"))
		        	 {
		        	
			    	liste=ldao.all();
			    	session.setAttribute("liste_service", liste);
			    
		        	 }
		        	 else{liste=ldao.select(temp.getId_agence());
		        		 session.setAttribute("liste_service", liste);
		        	     
		        	    }
		        		if(liste.size()==0)
					session.setAttribute("listevide", "rien");
		        	
		        		
		        	ServiceForm serv  =(ServiceForm)session.getAttribute("service");	
		        	serv.setId_service("");
		        	serv.setLibelle_service("");
		        	session.setAttribute("service", serv);	 
			   }
			   
			   
			   
			   if(action.equals("liste"))
			   {String id=request.getParameter("id");
			   liste4=adao.select(id);
			   session.setAttribute("liste4", liste4);
			   ServiceForm aux=(ServiceForm) form;
			  
			   if(liste4.size()!=0)
			   aux.setId_agence(liste4.get(0).getId_agence());
			   else 	
					session.setAttribute("liste_vide_agence", "rien");
			   session.setAttribute("service", aux);
			   }
	
			   
			   
			   if(action.equals("liste1"))
			   {String id=request.getParameter("id");
			   if(id==null||id.equals("xxxxxx"))
				{liste5=adao.all();}
			   else
			   liste5=adao.select(id);
			   liste5.add(0,new AgenceForm("xxxxxx","tous","",""));
			   vider=(ServiceForm)session.getAttribute("vider");
			   vider.setId_centre(id);

			   boolean test=false;
			   for(int i=0;i<liste5.size();i++)
			   {
				   if(liste5.get(i).getId_agence().equals(vider.getId_agence()))
					   test=true;
				 
			   }
			   

			   if(test==false)
			   {   vider.setId_agence("xxxxxx");}
			   
			   
			   
			   
			   ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
				liste=ldao.select(vider);
			   session.setAttribute("liste_service", liste);
	    		if(liste.size()==0)
			   session.setAttribute("listevide", "rien");
			   session.setAttribute("vider", vider);
			   session.setAttribute("liste5", liste5);
			   }
			   
			   
			   
			   
			   
			   
			   
			   if(action.equals("liste2"))
			   {String id=request.getParameter("id");
			   vider=(ServiceForm)session.getAttribute("vider");
			   vider.setId_agence(id);
			 	 ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
				liste=ldao.select(vider);
	
			   session.setAttribute("vider", vider);
			   session.setAttribute("liste_service", liste);
	    		if(liste.size()==0)
			    session.setAttribute("listevide", "rien");
	    		
	    		String id1=vider.getId_centre();
				   if(id1==null||id1.equals("xxxxxx"))
					{liste5=adao.all();}
				   else
				   liste5=adao.select(id1);
				   liste5.add(0,new AgenceForm("xxxxxx","tous","",""));
				   session.setAttribute("liste5", liste5);
			   }
			   
			   
			   
			   try{
				   
			    	ArrayList<ServiceForm> liste=new ArrayList<ServiceForm>();
			    	liste=(ArrayList<ServiceForm> )session.getAttribute("liste_service");
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_service", liste);
			   }catch(Exception e ){System.out.println(e);}
			   
			   
			  
			   
}catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




