package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeMotifArretForm;
import Dao.Conn;
import Dao.TypeMotifArretDao;;

public class TypeMotifArretAction extends Action {
	
		 
		
		
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
		    TypeMotifArretDao ldao =new TypeMotifArretDao(cnx.getcnx());

		    
		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("papier", new TypeMotifArretForm());
	        	boolean test=true;
	        	TypeMotifArretForm tfrm=(TypeMotifArretForm) form;
	            if(tfrm.getId_motif()==null||tfrm.getId_motif().equals("")||tfrm.getId_motif().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("motif", new TypeMotifArretForm("",tfrm.getLibelle_motif()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeMotifArretForm> liste=new ArrayList<TypeMotifArretForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_motif", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeMotifArretForm tfrm=(TypeMotifArretForm) form;
	        	TypeMotifArretForm aux=ldao.recup(tfrm.getId_motif());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("motif", new TypeMotifArretForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeMotifArretForm> liste=new ArrayList<TypeMotifArretForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_motif", liste);
		    	session.setAttribute("motif",new TypeMotifArretForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeMotifArretForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("motif", new TypeMotifArretForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeMotifArretForm x= ldao.recup(id);
	      session.setAttribute("motif",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeMotifArretForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeMotifArretForm> liste=new ArrayList<TypeMotifArretForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_motif", liste);
		    	session.setAttribute("motif", new TypeMotifArretForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeMotifArretForm> liste=new ArrayList<TypeMotifArretForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_motif", liste);
			    	session.setAttribute("motif", new TypeMotifArretForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		    }catch(Exception e ){System.out.println(e);}			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




