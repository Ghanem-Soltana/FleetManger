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
import Bean.MagasinForm;
import Dao.Conn;
import Dao.FamArticlePrinciDao;
import Dao.MagasinDao;;

public class MagasinAction extends Action  {
	
		 
		
		
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
		    session.removeAttribute("liste_famille");
		    session.removeAttribute("liste_famille1");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    session.removeAttribute("affichage");
		    MagasinDao ldao =new MagasinDao(cnx.getcnx());
		    FamArticlePrinciDao fdao =new FamArticlePrinciDao(cnx.getcnx());
		    session.setAttribute("liste_famille", fdao.all());
		    session.setAttribute("liste_famille1", new ArrayList<FamArticlePrinciForm>());
		    
		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("centre", new MagasinForm());
	        	boolean test=true;
	        	MagasinForm tfrm=(MagasinForm) form;
	            if(tfrm.getId_magasin()==null||tfrm.getId_magasin().equals("")||tfrm.getId_magasin().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("magasin", new MagasinForm("",tfrm.getLibelle_magasin(),tfrm.getAdresse_magasin(),tfrm.getTel_magasin(),tfrm.getFax_magasin(),tfrm.getNom_res(),tfrm.getRemarque_magasin(),tfrm.getListe_famille()));
	        	ArrayList<FamArticlePrinciForm>liste_fam2,liste_fam=new ArrayList<FamArticlePrinciForm>();
	        	liste_fam2=fdao.getfamille(tfrm.getListe_famille());
	        	liste_fam=fdao.reste(tfrm.getListe_famille());
	        	session.setAttribute("liste_famille1", liste_fam2);
	        	session.setAttribute("liste_famille", liste_fam);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<MagasinForm> liste=new ArrayList<MagasinForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_magasin", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	MagasinForm tfrm=(MagasinForm) form;
	        	MagasinForm aux=ldao.recup(tfrm.getId_magasin());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("magasin", new MagasinForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else {session.setAttribute("erreur", "er_modif1");
	                	ArrayList<FamArticlePrinciForm>liste_fam2,liste_fam=new ArrayList<FamArticlePrinciForm>();
	    	        	liste_fam2=fdao.getfamille(tfrm.getListe_famille());
	    	        	liste_fam=fdao.reste(tfrm.getListe_famille());
	    	        	session.setAttribute("liste_famille1", liste_fam2);
	    	        	session.setAttribute("liste_famille", liste_fam);
	        	              }
	        	     }
	        	ArrayList<MagasinForm> liste=new ArrayList<MagasinForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_magasin", liste);
		    	session.setAttribute("magasin",new MagasinForm());
		    	session.removeAttribute("x");
		    	action="aff";
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      MagasinForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("magasin", new MagasinForm());
		  session.removeAttribute("x");
		  
		  }
		  else{
		  MagasinForm x= ldao.recup(id);
	      session.setAttribute("magasin",  x);
	      session.setAttribute("x", "");
	      
	      
	   	ArrayList<FamArticlePrinciForm>liste_fam2,liste_fam=new ArrayList<FamArticlePrinciForm>();
    	liste_fam2=fdao.getfamille(Utilitaire.creListefamille(id));
    	liste_fam=fdao.reste(Utilitaire.creListefamille(id));
    	session.setAttribute("liste_famille1", liste_fam2);
    	session.setAttribute("liste_famille", liste_fam);
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				MagasinForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<MagasinForm> liste=new ArrayList<MagasinForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_magasin", liste);
		    	session.setAttribute("magasin", new MagasinForm());
		    	session.setAttribute("affichage", " ");
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<MagasinForm> liste=new ArrayList<MagasinForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_magasin", liste);
			    	session.setAttribute("magasin", new MagasinForm());
			    	session.removeAttribute("x");
			  
			   
			    }
			   
			   
			   if(action.equals("aff"))
			   {	
			    	ArrayList<MagasinForm> liste=new ArrayList<MagasinForm>();
			    	liste=ldao.all();
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			      	session.setAttribute("liste_magasin", liste);
			    	session.setAttribute("magasin", new MagasinForm());
				   session.setAttribute("affichage", " ");
			   }
			
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			   
	
			return mapping.findForward(frd);
		}
		
		

	
	}




