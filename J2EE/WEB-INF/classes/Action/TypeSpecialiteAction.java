package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeSpecialiteForm;
import Dao.Conn;
import Dao.TypeSpecialiteDao;

public class TypeSpecialiteAction extends Action {
	

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
		    TypeSpecialiteDao ldao =new TypeSpecialiteDao(cnx.getcnx());
try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("specialite", new TypeSpecialiteForm());
	        	boolean test=true;
	        	TypeSpecialiteForm tfrm=(TypeSpecialiteForm) form;
	            if(tfrm.getId_specialite()==null||tfrm.getId_specialite().equals("")||tfrm.getId_specialite().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("specialite", new TypeSpecialiteForm("",tfrm.getLibelle_specialite()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeSpecialiteForm> liste=new ArrayList<TypeSpecialiteForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_specialite", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");

	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeSpecialiteForm tfrm=(TypeSpecialiteForm) form;
	        	TypeSpecialiteForm aux=ldao.recup(tfrm.getId_specialite());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("specialite", new TypeSpecialiteForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeSpecialiteForm> liste=new ArrayList<TypeSpecialiteForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_specialite", liste);
		    	session.setAttribute("specialite",new TypeSpecialiteForm());
		    	session.removeAttribute("x");
	  		  
				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeSpecialiteForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("specialite", new TypeSpecialiteForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeSpecialiteForm x= ldao.recup(id);
	      session.setAttribute("specialite",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeSpecialiteForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeSpecialiteForm> liste=new ArrayList<TypeSpecialiteForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("type_specialite", liste);
		    	session.setAttribute("specialite", new TypeSpecialiteForm());
		    	
		    	session.removeAttribute("x");

			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeSpecialiteForm> liste=new ArrayList<TypeSpecialiteForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("type_specialite", liste);
			    	session.setAttribute("specialite", new TypeSpecialiteForm());
			    	session.removeAttribute("x");

			    }
			   
}catch(Exception e ){System.out.println(e);}		   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




