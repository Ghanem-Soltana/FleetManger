package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeMatiereForm;
import Dao.Conn;
import Dao.TypeMatiereDao;;

public class TypeMatiereAction extends Action {
	
		 
		
		
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
		    TypeMatiereDao ldao =new TypeMatiereDao(cnx.getcnx());

		    
		    
try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("matiere", new TypeMatiereForm());
	        	boolean test=true;
	        	TypeMatiereForm tfrm=(TypeMatiereForm) form;
	            if(tfrm.getId_matiere()==null||tfrm.getId_matiere().equals("")||tfrm.getId_matiere().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("matiere", new TypeMatiereForm("",tfrm.getLibelle_matiere()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeMatiereForm> liste=new ArrayList<TypeMatiereForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_matiere", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeMatiereForm tfrm=(TypeMatiereForm) form;
	        	TypeMatiereForm aux=ldao.recup(tfrm.getId_matiere());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("matiere", new TypeMatiereForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeMatiereForm> liste=new ArrayList<TypeMatiereForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_matiere", liste);
		    	session.setAttribute("matiere",new TypeMatiereForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeMatiereForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("matiere", new TypeMatiereForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeMatiereForm x= ldao.recup(id);
	      session.setAttribute("matiere",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeMatiereForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeMatiereForm> liste=new ArrayList<TypeMatiereForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_matiere", liste);
		    	session.setAttribute("matiere", new TypeMatiereForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeMatiereForm> liste=new ArrayList<TypeMatiereForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_matiere", liste);
			    	session.setAttribute("matiere", new TypeMatiereForm());
			    	session.removeAttribute("x");
			   
			    }
			   
}catch(Exception e ){System.out.println(e);}			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




