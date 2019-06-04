package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.TypeArticleForm;
import Dao.Conn;
import Dao.TypeArticleDao;;

public class TypeArticleAction extends Action {
	
		 
		
		
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
		    TypeArticleDao ldao =new TypeArticleDao(cnx.getcnx());

		    
		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("article", new TypeArticleForm());
	        	boolean test=true;
	        	TypeArticleForm tfrm=(TypeArticleForm) form;
	            if(tfrm.getId_article()==null||tfrm.getId_article().equals("")||tfrm.getId_article().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("article", new TypeArticleForm("",tfrm.getLibelle_article()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeArticleForm> liste=new ArrayList<TypeArticleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_article", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeArticleForm tfrm=(TypeArticleForm) form;
	        	TypeArticleForm aux=ldao.recup(tfrm.getId_article());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("article", new TypeArticleForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeArticleForm> liste=new ArrayList<TypeArticleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_article", liste);
		    	session.setAttribute("article",new TypeArticleForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeArticleForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("article", new TypeArticleForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeArticleForm x= ldao.recup(id);
	      session.setAttribute("article",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeArticleForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeArticleForm> liste=new ArrayList<TypeArticleForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_article", liste);
		    	session.setAttribute("article", new TypeArticleForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeArticleForm> liste=new ArrayList<TypeArticleForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_article", liste);
			    	session.setAttribute("article", new TypeArticleForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   
			   
			   
		    }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
	
			return mapping.findForward(frd);
		}
		
		

	
	}




