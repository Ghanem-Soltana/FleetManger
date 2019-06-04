package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeEnergieForm;
import Dao.Conn;
import Dao.TypeEnergieDao;;

public class TypeEnergieAction extends Action {
	
		 
		
		
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
		    TypeEnergieDao ldao =new TypeEnergieDao(cnx.getcnx());

	
		    
		    try{
		    if(action.equals("ajout"))
	        {   session.setAttribute("energie", new TypeEnergieForm());
	        	boolean test=true;
	        	TypeEnergieForm tfrm=(TypeEnergieForm) form;
	            if(tfrm.getId_energie()==null||tfrm.getId_energie().equals("")||tfrm.getId_energie().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("energie", new TypeEnergieForm("",tfrm.getLibelle_energie()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeEnergieForm> liste=new ArrayList<TypeEnergieForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_energie", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeEnergieForm tfrm=(TypeEnergieForm) form;
	        	TypeEnergieForm aux=ldao.recup(tfrm.getId_energie());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("energie", new TypeEnergieForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeEnergieForm> liste=new ArrayList<TypeEnergieForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_energie", liste);
		    	session.setAttribute("energie",new TypeEnergieForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeEnergieForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("energie", new TypeEnergieForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeEnergieForm x= ldao.recup(id);
	      session.setAttribute("energie",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeEnergieForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeEnergieForm> liste=new ArrayList<TypeEnergieForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_energie", liste);
		    	session.setAttribute("energie", new TypeEnergieForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeEnergieForm> liste=new ArrayList<TypeEnergieForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_energie", liste);
			    	session.setAttribute("energie", new TypeEnergieForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   
		    }catch(Exception e ){System.out.println(e);} 
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




