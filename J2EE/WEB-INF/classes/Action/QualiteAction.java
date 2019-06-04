package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.QualiteForm;
import Dao.Conn;
import Dao.QualiteDao;;

public class QualiteAction extends Action {
	
		 
		
		
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
		    QualiteDao ldao =new QualiteDao(cnx.getcnx());
		    
		    try{

	        if(action.equals("ajout"))
	        {   session.setAttribute("marque", new QualiteForm());
	        	boolean test=true;
	        	QualiteForm tfrm=(QualiteForm) form;
	            if(tfrm.getId_qualite()==null||tfrm.getId_qualite().equals("")||tfrm.getId_qualite().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("qualite", new QualiteForm("",tfrm.getLibelle_qualite()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<QualiteForm> liste=new ArrayList<QualiteForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_qualite", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	QualiteForm tfrm=(QualiteForm) form;
	        	QualiteForm aux=ldao.recup(tfrm.getId_qualite());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("qualite", new QualiteForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<QualiteForm> liste=new ArrayList<QualiteForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_qualite", liste);
		    	session.setAttribute("qualite",new QualiteForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      QualiteForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("qualite", new QualiteForm());
		  session.removeAttribute("x");
		  }
		  else{
		  QualiteForm x= ldao.recup(id);
	      session.setAttribute("qualite",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				QualiteForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<QualiteForm> liste=new ArrayList<QualiteForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_qualite", liste);
		    	session.setAttribute("qualite", new QualiteForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<QualiteForm> liste=new ArrayList<QualiteForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_qualite", liste);
			    	session.setAttribute("qualite", new QualiteForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




