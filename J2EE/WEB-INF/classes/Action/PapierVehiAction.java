package Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import Bean.PapierVehiForm;
import Bean.TypePapierForm;
import Bean.VehiculeForm;
import Dao.Conn;
import Dao.PapierVehiDao;
import Dao.TypePapierDao;
import Dao.VehiculeDao;

public class PapierVehiAction extends Action{
	
	
	
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
	    session.removeAttribute("liste_papier");
	    session.removeAttribute("liste_vehicule");
	    PapierVehiDao pdao =new PapierVehiDao(cnx.getcnx());

	    TypePapierDao papierdao =new TypePapierDao(cnx.getcnx());
	    ArrayList<TypePapierForm> liste_type_papier= new ArrayList<TypePapierForm>();	 
	   	liste_type_papier=papierdao.all();
    	session.setAttribute("liste_papier", liste_type_papier);

	    VehiculeDao vehiculedao =new VehiculeDao(cnx.getcnx());
	    ArrayList<VehiculeForm> liste_vehicule= new ArrayList<VehiculeForm>();	 
	   	liste_vehicule=vehiculedao.all();
    	session.setAttribute("liste_vehicule", liste_vehicule);

	    
	    try{
	    
        if(action.equals("ajout"))
        {   session.setAttribute("papiervehi", new PapierVehiForm());
        	boolean test=true;
        	PapierVehiForm tfrm=(PapierVehiForm) form;
            if(tfrm.getId_vehicule()==null||tfrm.getId_vehicule().equals("")||tfrm.getId_vehicule().indexOf('&')!=-1)
            session.setAttribute("erreur", "er_invalide");
            else{
            	
            	boolean valide=true;
            	
            	if(!tfrm.getDate_debut_validation().equals(""))
            	valide=pdao.verfifer_validite_date(tfrm);
            	
            	
            	if(valide){
	
        	test=pdao.add(tfrm);
            
        	if(test==false)
        	{session.setAttribute("erreur", "er_existant");
        	tfrm.setId_type_papier("");
        	tfrm.setDate_papier("");        	
	    	session.setAttribute("papiervehi", tfrm);}
        	else
        	{session.setAttribute("sms", "ajout_ok");}}
            else 
            {session.setAttribute("erreur", "er_papier_date");      	
	    	session.setAttribute("papiervehi", tfrm);}}
            
            
        	ArrayList<PapierVehiForm> liste=new ArrayList<PapierVehiForm>();
	    	liste=pdao.all();
	    	session.setAttribute("liste_papiervehi", liste);
	      	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
	}
        
        if(action.equals("edit"))
        {
        	PapierVehiForm tfrm=(PapierVehiForm) form;
        	PapierVehiForm aux=pdao.recup(tfrm.getId_vehicule(),tfrm.getId_type_papier(),tfrm.getDate_papier());
        	if(aux==null)
  		  {session.setAttribute("erreur", "er_modif");
  		   session.setAttribute("papiervehi", new PapierVehiForm());
  		  }
        	else{   
        		
            	boolean valide=true;
            	
            	if(!tfrm.getDate_debut_validation().equals(""))
            	valide=pdao.verfifer_validite_date_update(tfrm);
            	
        		
            		if(valide)	
            			{
        		   boolean modif=pdao.update(tfrm);
        	        if(modif)
        	        {session.setAttribute("sms", "modif_ok");	session.removeAttribute("x");		   session.setAttribute("papiervehi", new PapierVehiForm());}
        	        else {session.setAttribute("erreur", "er_modif1");}
        	           } else 
        	               {session.setAttribute("erreur", "er_papier_date");      	
        	   	    	session.setAttribute("papiervehi", tfrm);}
            		
        	}
        	ArrayList<PapierVehiForm> liste=new ArrayList<PapierVehiForm>();
	    	liste=pdao.all();
	    	session.setAttribute("liste_papiervehi", liste);
	    	
	    	if(liste.size()==0)
	    	session.setAttribute("listevide", "rien");
	    	
	    

			

        }
        
        
        
        
        if(action.equals("modif"))
        {
        	String id_vehicule=request.getParameter("id");
        	String id_type_papier=request.getParameter("id_t");
        	String id_obtention=request.getParameter("id_o");
      PapierVehiForm aux=pdao.recup(id_vehicule,id_type_papier,id_obtention);
	  if(aux==null)
	  {session.setAttribute("erreur", "er_modif");
	  session.setAttribute("papiervehi", new PapierVehiForm());
	  session.removeAttribute("x");
	  }
	  else{
		  session.setAttribute("papiervehi", aux);
		  session.setAttribute("x", "modif");
        }
        }
	    
		if(action.equals("supp"))
		{   
        	String id_vehicule=request.getParameter("id");
        	String id_type_papier=request.getParameter("id_t");
        	String id_obtention=request.getParameter("id_o");
            PapierVehiForm aux=pdao.recup(id_vehicule,id_type_papier,id_obtention);
			if(aux==null)
			session.setAttribute("erreur", "er_suppinex");
			else{
			boolean test=pdao.delete(id_vehicule,id_type_papier,id_obtention);
			if(!test)
			session.setAttribute("erreur", "er_suppcascade");
			else{session.setAttribute("sms", "supp_ok");}
			}
	    	ArrayList<PapierVehiForm> liste=new ArrayList<PapierVehiForm>();
	    	liste=pdao.all();
	    	if(liste.size()==0)
	    	session.setAttribute("listevide", "rien");
	    	session.setAttribute("liste_papiervehi", liste);
	    	session.setAttribute("papiervehi", new PapierVehiForm());
	    	
	    	session.removeAttribute("x");
		
		}
		
	
		
		   if(action.equals("all"))
		    {
			
		    	ArrayList<PapierVehiForm> liste=new ArrayList<PapierVehiForm>();
		    	liste=pdao.all();
		    	
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_papiervehi", liste);
		    	session.setAttribute("papiervehi", new PapierVehiForm());
		    	session.removeAttribute("x");
		   
		    }
		   
		   if(action.equals("annul"))
		   {session.removeAttribute("x");
		   session.setAttribute("papiervehi", new PapierVehiForm());
			   
		   }
		  

        
        
        
	    }catch(Exception e ){System.out.println(e);}
		    } cnx.closecnx();

	      	return mapping.findForward(frd);
        	
        }

}
