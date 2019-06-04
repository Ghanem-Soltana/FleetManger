package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.ModeleVehiForm;
import Bean.TypeEnergieForm;
import Dao.Conn;
import Dao.ModeleVehiDao;
import Dao.TypeEnergieDao;

public class ModeleVehiAction extends Action {
	
		 
		
		
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
		    session.removeAttribute("modele");
		    session.removeAttribute("sms");
		    
		    session.removeAttribute("liste2");
		    ModeleVehiDao ldao =new ModeleVehiDao(cnx.getcnx());
		    TypeEnergieDao edao= new TypeEnergieDao(cnx.getcnx());
		  
		    ArrayList<TypeEnergieForm> liste2= new ArrayList<TypeEnergieForm>();
	    	liste2=edao.all();
	    	liste2.add(0,new TypeEnergieForm("xxxxx","          "));
	    	session.setAttribute("liste2", liste2);
	    	ModeleVehiForm aux1=new ModeleVehiForm();
	    	aux1.setId_energie("xxxxx");


	    	
	    	try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("modele", new ModeleVehiForm());
	        	boolean test=true;
	        	ModeleVehiForm tfrm=(ModeleVehiForm) form;
	            if(tfrm.getId_modelevehi()==null||tfrm.getId_modelevehi().equals("")||tfrm.getId_modelevehi().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("modele", new ModeleVehiForm("",tfrm.getLibelle_modelevehi(),tfrm.getQte_vidange(),tfrm.getTx_appoint(),tfrm.getNb_jour(),tfrm.getReleve(),tfrm.getId_energie(),tfrm.getLibelle_energie()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<ModeleVehiForm> liste=new ArrayList<ModeleVehiForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_modele", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
		   
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	ModeleVehiForm tfrm=(ModeleVehiForm) form;
	        	ModeleVehiForm aux=ldao.recup(tfrm.getId_modelevehi());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("modele",aux1);
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<ModeleVehiForm> liste=new ArrayList<ModeleVehiForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_modele", liste);
		    	session.setAttribute("modele",aux1);
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      ModeleVehiForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("modele", aux1);
		  session.removeAttribute("x");
		  }
		  else{
		  ModeleVehiForm x= ldao.recup(id);
	      session.setAttribute("modele",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				ModeleVehiForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<ModeleVehiForm> liste=new ArrayList<ModeleVehiForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_modele", liste);
		    	session.setAttribute("modele", aux1);
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<ModeleVehiForm> liste=new ArrayList<ModeleVehiForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_modele", liste);
			    	session.setAttribute("modele", aux1);
			    	session.removeAttribute("x");
			   
			    	
			    }
			  
			   
	    	}catch(Exception e ){System.out.println(e);}
			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




