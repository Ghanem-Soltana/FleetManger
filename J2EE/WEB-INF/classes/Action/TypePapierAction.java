package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypePapierForm;
import Dao.Conn;
import Dao.TypePapierDao;;

public class TypePapierAction extends Action {
	
		 
		
		
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
		    TypePapierDao ldao =new TypePapierDao(cnx.getcnx());
try{
	

	        if(action.equals("ajout"))
	        {   session.setAttribute("papier", new TypePapierForm());
	        	boolean test=true;
	        	TypePapierForm tfrm=(TypePapierForm) form;
	            if(tfrm.getId_papier()==null||tfrm.getId_papier().equals("")||tfrm.getId_papier().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("papier", new TypePapierForm("",tfrm.getLibelle_papier()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypePapierForm> liste=new ArrayList<TypePapierForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_papier", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypePapierForm tfrm=(TypePapierForm) form;
	        	TypePapierForm aux=ldao.recup(tfrm.getId_papier());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("papier", new TypePapierForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypePapierForm> liste=new ArrayList<TypePapierForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_papier", liste);
		    	session.setAttribute("papier",new TypePapierForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypePapierForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("papier", new TypePapierForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypePapierForm x= ldao.recup(id);
	      session.setAttribute("papier",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypePapierForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypePapierForm> liste=new ArrayList<TypePapierForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_papier", liste);
		    	session.setAttribute("papier", new TypePapierForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypePapierForm> liste=new ArrayList<TypePapierForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_papier", liste);
			    	session.setAttribute("papier", new TypePapierForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		}catch(Exception e ){System.out.println(e);}			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




