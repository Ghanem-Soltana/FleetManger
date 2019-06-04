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
import Bean.FonctionForm;
import Bean.QualiteForm;
import Dao.AgentDao;
import Dao.Conn;
import Dao.FonctionDao;
import Dao.QualiteDao;


public class AgentAction extends Action {
	
		 
		
		
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
		    session.removeAttribute("agent");
		    session.removeAttribute("sms");
		    
		    session.removeAttribute("listef");
		    session.removeAttribute("listeq");
		    AgentDao adao =new AgentDao(cnx.getcnx());
		    FonctionDao fdao= new FonctionDao(cnx.getcnx());
		    QualiteDao qdao= new QualiteDao(cnx.getcnx());

		    ArrayList<FonctionForm> listef= new ArrayList<FonctionForm>();
	    	listef=fdao.all();
	    
	    	session.setAttribute("listef", listef);
	    	
	    	 ArrayList<QualiteForm> listeq= new ArrayList<QualiteForm>();
		    	listeq=qdao.all();
		    	
		    	session.setAttribute("listeq", listeq);
		 
		    	
		    	AgentForm agent=new AgentForm();
		    	session.setAttribute("agent", agent);
		   
		    	
		    	try{
	        if(action.equals("ajout"))
	        {   
	        	
	        	
	        	session.setAttribute("agent", new AgentForm());
	        	boolean test=true;
	        	AgentForm tfrm=(AgentForm) form;
	            if(tfrm.getId_agent()==null||tfrm.getId_agent().equals("")||tfrm.getId_agent().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	       
	            	test=adao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("agent", new AgentForm("",tfrm.getLibelle_agent(),tfrm.getId_fonction(),tfrm.getLibelle_fonction(),tfrm.getId_qualification(),tfrm.getLibelle_qualification(),tfrm.getStatut()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<AgentForm> liste=new ArrayList<AgentForm>();
		    	liste=adao.all();
		    	session.setAttribute("liste_agent", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
		   
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	AgentForm tfrm=(AgentForm) form;
	        	AgentForm aux=adao.recup(tfrm.getId_agent());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("agent",new AgentForm("",tfrm.getLibelle_agent(),tfrm.getId_fonction(),tfrm.getLibelle_fonction(),tfrm.getId_qualification(),tfrm.getLibelle_qualification(),tfrm.getStatut()));
	  		  }
	        	else{boolean modif=adao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<AgentForm> liste=new ArrayList<AgentForm>();
		    	liste=adao.all();
		    	session.setAttribute("liste_agent", liste);
		    	session.setAttribute("agent",new AgentForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      AgentForm aux=adao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.removeAttribute("x");
		  }
		  else{
		  AgentForm x= adao.recup(id);
	      session.setAttribute("agent",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				AgentForm aux=adao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=adao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<AgentForm> liste=new ArrayList<AgentForm>();
		    	liste=adao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_agent", liste);
		    	session.setAttribute("agent", new AgentForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<AgentForm> liste=new ArrayList<AgentForm>();
			    	liste=adao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_agent", liste);
			    	session.removeAttribute("x");
			   
			    	
			    }
			   
		    	}catch(Exception e ){System.out.println(e);} 
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




