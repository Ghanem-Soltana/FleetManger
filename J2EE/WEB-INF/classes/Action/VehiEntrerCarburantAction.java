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
import Bean.BonEssenceForm;
import Bean.MagasinForm;
import Bean.SaisonForm;
import Bean.VehiEntrerCarburantForm;
import Dao.AgentDao;
import Dao.BonEssenceDao;
import Dao.Conn;
import Dao.MagasinDao;
import Dao.SaisonDao;
import Dao.VehiEntrerCarburantDao;

public class VehiEntrerCarburantAction extends Action {
	

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
		    
			SaisonDao anneedao =new  SaisonDao (cnx.getcnx());
			MagasinDao mdao =new MagasinDao(cnx.getcnx());
			AgentDao adap= new AgentDao(cnx.getcnx());
			VehiEntrerCarburantDao ldao= new VehiEntrerCarburantDao(cnx.getcnx());
			BonEssenceDao bdap= new BonEssenceDao(cnx.getcnx());

			  ArrayList<SaisonForm>liste_annee=  anneedao.noncloture();
			  ArrayList<MagasinForm>liste_magasin=mdao.all();
			  ArrayList<AgentForm>liste_agent=adap.all();
			  ArrayList<BonEssenceForm>liste_typebon=bdap.all();
			  session.setAttribute("liste_annee", liste_annee);
			  session.setAttribute("liste_magasin", liste_magasin);
			  session.setAttribute("liste_agent", liste_agent);
			  session.setAttribute("liste_typebon", liste_typebon);

	        if(action.equals("ajout"))
	        {		    	session.setAttribute("entrer_carburant",new VehiEntrerCarburantForm());

	        	boolean test=true;
	        	VehiEntrerCarburantForm tfrm=(VehiEntrerCarburantForm) form;
	        	System.out.println(ldao.verfifer_validite_bon(tfrm));
	            if(tfrm==null)
	            {  session.setAttribute("erreur", "er_invalide");
	            
	            }
	            else
	        	{
	            boolean valide=ldao.verfifer_validite_bon(tfrm);
	           if(valide)
	           {
	        	 test=ldao.add(tfrm);
	        	 
	            
	        	if(test==false)
	        	{
	        	session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_bon("");
		    	session.setAttribute("entrer_carburant",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	           else {session.setAttribute("sms", "entrer_bon_prob");}
	        	ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_entrer_carburant", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	        	}
	        	
	        }
	        
	        if(action.equals("edit"))
	        {
	        	VehiEntrerCarburantForm tfrm =(VehiEntrerCarburantForm)form;
				VehiEntrerCarburantForm aux=ldao.recup(tfrm.getId_bon(),tfrm.getId_exercice(),tfrm.getId_magasin());
if(aux==null)
{
	session.setAttribute("erreur", "er_suppinex");
}
else{
				boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");session.removeAttribute("x");	session.setAttribute("entrer_carburant",new VehiEntrerCarburantForm());}
	        	        else session.setAttribute("erreur", "er_modif1");
}       	     
	        	ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_entrer_carburant", liste);
		    
		    	
	  		  
				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
String id_bon=request.getParameter("id");
String id_exercice=request.getParameter("annee");
String id_mag=request.getParameter("mag");

VehiEntrerCarburantForm aux=ldao.recup(id_bon,id_exercice,id_mag);
	      if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("entrer_carburant", new VehiEntrerCarburantForm());
		  session.removeAttribute("x");
		  }
		  else{
	      session.setAttribute("entrer_carburant",  aux);
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
				
		    	ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_entrer_carburant", liste);
		    	session.setAttribute("entrer_carburant", new VehiEntrerCarburantForm());
		    	
		    	session.removeAttribute("x");

			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
			    	liste=ldao.all();
		        	session.setAttribute("entrer_carburant", new VehiEntrerCarburantForm());

			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_entrer_carburant", liste);
			    	session.removeAttribute("x");

			    }
			   
		   
			   cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




