package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.TypeCarburantForm;
import Dao.Conn;
import Dao.TypeCarburantDao;

public class TypeCarburantAction extends Action {
	
		 
		
		
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
		    TypeCarburantDao ldao =new TypeCarburantDao(cnx.getcnx());

		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("carburant", new TypeCarburantForm());
	        	boolean test=true;
	        	TypeCarburantForm tfrm=(TypeCarburantForm) form;
	            if(tfrm.getid_carburant()==null||tfrm.getid_carburant().equals("")||tfrm.getid_carburant().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("carburant", new TypeCarburantForm("",tfrm.getlibelle_carburant()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeCarburantForm> liste=new ArrayList<TypeCarburantForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_carburant", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeCarburantForm tfrm=(TypeCarburantForm) form;
	        	TypeCarburantForm aux=ldao.recup(tfrm.getid_carburant());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("carburant", new TypeCarburantForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeCarburantForm> liste=new ArrayList<TypeCarburantForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_carburant", liste);
		    	session.setAttribute("carburant",new TypeCarburantForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeCarburantForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("carburant", new TypeCarburantForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeCarburantForm x= ldao.recup(id);
	      session.setAttribute("carburant",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeCarburantForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeCarburantForm> liste=new ArrayList<TypeCarburantForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("type_carburant", liste);
		    	session.setAttribute("carburant", new TypeCarburantForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeCarburantForm> liste=new ArrayList<TypeCarburantForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("type_carburant", liste);
			    	session.setAttribute("carburant", new TypeCarburantForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   if(action.equals("details"))
			   {
				   frd="article";
			   }
			
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




