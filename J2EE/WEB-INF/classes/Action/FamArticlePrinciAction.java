package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.FamArticlePrinciForm;
import Dao.Conn;
import Dao.FamArticlePrinciDao;;

public class FamArticlePrinciAction extends Action {
	
		 
		
		
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
		    session.removeAttribute("sms");
		    FamArticlePrinciDao ldao =new FamArticlePrinciDao(cnx.getcnx());
try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("fam_princ", new FamArticlePrinciForm());
	        	boolean test=true;
	        	FamArticlePrinciForm tfrm=(FamArticlePrinciForm) form;
	            if(tfrm.getId_famille_princi()==null||tfrm.getId_famille_princi().equals("")||tfrm.getId_famille_princi().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("fam_princ", new FamArticlePrinciForm("",tfrm.getLibelle_famille_princi(),tfrm.isImpression(),tfrm.isStocke()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<FamArticlePrinciForm> liste=new ArrayList<FamArticlePrinciForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_fam_princ", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	FamArticlePrinciForm tfrm=(FamArticlePrinciForm) form;
	        	FamArticlePrinciForm aux=ldao.recup(tfrm.getId_famille_princi());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("fam_princ", new FamArticlePrinciForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<FamArticlePrinciForm> liste=new ArrayList<FamArticlePrinciForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_fam_princ", liste);
		    	session.setAttribute("fam_princ",new FamArticlePrinciForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      FamArticlePrinciForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("fam_princ", new FamArticlePrinciForm());
		  session.removeAttribute("x");
		  }
		  else{
		  FamArticlePrinciForm x= ldao.recup(id);
	      session.setAttribute("fam_princ",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				FamArticlePrinciForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<FamArticlePrinciForm> liste=new ArrayList<FamArticlePrinciForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_fam_princ", liste);
		    	session.setAttribute("fam_princ", new FamArticlePrinciForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<FamArticlePrinciForm> liste=new ArrayList<FamArticlePrinciForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_fam_princ", liste);
			    	session.setAttribute("fam_princ", new FamArticlePrinciForm());
			    	session.removeAttribute("x");
			   
			    }
			   
}catch(Exception e ){System.out.println(e);}	   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




