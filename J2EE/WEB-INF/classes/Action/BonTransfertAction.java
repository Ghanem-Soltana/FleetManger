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
import Bean.BonTransfertForm;
import Dao.AgentDao;
import Dao.BonEssenceDao;
import Dao.Conn;
import Dao.MagasinDao;
import Dao.SaisonDao;
import Dao.BonTransfertDao;

public class BonTransfertAction extends Action {
	

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
			BonTransfertDao ldao= new BonTransfertDao(cnx.getcnx());
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
	        {		    	session.setAttribute("bon_transfert",new BonTransfertForm());

	        	boolean test=true;
	        	BonTransfertForm tfrm=(BonTransfertForm) form;
	            if(tfrm==null)
	            {  session.setAttribute("erreur", "er_invalide");
	            
	            }
	            else
	        	{test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{
	        	session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_transfert("");
		    	session.setAttribute("bon_transfert",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}
	        	
	        	ArrayList<BonTransfertForm> liste=new ArrayList<BonTransfertForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_bon_transfert", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	        	}
	        	
	        }
	        
	        if(action.equals("edit"))
	        {
	        	BonTransfertForm tfrm =(BonTransfertForm)form;
				BonTransfertForm aux=ldao.recup(tfrm.getId_transfert(),tfrm.getId_exercice(),tfrm.getId_magasin_depart());
if(aux==null)
{
	session.setAttribute("erreur", "er_suppinex");
}
else{
				boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");session.removeAttribute("x");	session.setAttribute("bon_transfert",new BonTransfertForm());}
	        	        else session.setAttribute("erreur", "er_modif1");
}       	     
	        	ArrayList<BonTransfertForm> liste=new ArrayList<BonTransfertForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_bon_transfert", liste);
		    
		    	
	  		  
				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
String id_bon=request.getParameter("id");
String id_exercice=request.getParameter("annee");
String id_mag=request.getParameter("mag");

BonTransfertForm aux=ldao.recup(id_bon,id_exercice,id_mag);
	      if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("bon_transfert", new BonTransfertForm());
		  session.removeAttribute("x");
		  }
		  else{
	      session.setAttribute("bon_transfert",  aux);
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
				
		    	ArrayList<BonTransfertForm> liste=new ArrayList<BonTransfertForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_bon_transfert", liste);
		    	session.setAttribute("bon_transfert", new BonTransfertForm());
		    	
		    	session.removeAttribute("x");

			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<BonTransfertForm> liste=new ArrayList<BonTransfertForm>();
			    	liste=ldao.all();
		        	session.setAttribute("bon_transfert", new BonTransfertForm());

			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_bon_transfert", liste);
			    	session.removeAttribute("x");

			    }
			   
		   
			   cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




