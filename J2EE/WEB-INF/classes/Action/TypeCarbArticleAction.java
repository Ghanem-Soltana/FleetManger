package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.ArticleForm;
import Bean.TypeCarburantForm;
import Dao.Conn;
import Dao.TypeCarbArticleDao;
import Dao.TypeCarburantDao;
import Dao.ArticleDao;;

public class TypeCarbArticleAction extends Action  {
	
		 
		
		
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
		    session.removeAttribute("liste_article");
		    session.removeAttribute("liste_article1");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    session.removeAttribute("affichage");
		    TypeCarburantDao ldao =new TypeCarburantDao(cnx.getcnx());
		    ArticleDao articledao =new ArticleDao(cnx.getcnx());
		    TypeCarbArticleDao carb_articledao =new TypeCarbArticleDao(cnx.getcnx());
		    session.setAttribute("liste_article1", articledao.all());
		    session.setAttribute("liste_article", new ArrayList<ArticleForm>());
		
		    
		try{    
	        if(action.equals("edit"))
	        {
	        	TypeCarburantForm tfrm=(TypeCarburantForm) form;
	        	TypeCarburantForm aux=ldao.recup(tfrm.getid_carburant());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("carb_article", new TypeCarburantForm());
	  		    session.setAttribute("liste_article1", articledao.all());
    		    session.setAttribute("liste_article", new ArrayList<ArticleForm>());
	  		  }
	        	else{boolean modif=carb_articledao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");        
	        		    session.setAttribute("liste_article1",carb_articledao.reste(tfrm.getListe_article()));
					    session.setAttribute("liste_article",carb_articledao.getArticles( tfrm.getid_carburant()));
					    session.setAttribute("carb_article", tfrm);  
	        	        }
	        	        else {session.setAttribute("erreur", "er_modif1");
	        		    session.setAttribute("liste_article1", articledao.all());
	        		    session.setAttribute("liste_article", new ArrayList<ArticleForm>());
	        		    tfrm.setListe_article("");
	        		    session.setAttribute("carb_article",tfrm);  
	        	        }
	        	     }
	  

	

	        }
	        
	        
	        
	


	        
		    
		
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeCarburantForm> liste=new ArrayList<TypeCarburantForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_carb_article", liste);
			    	String id=request.getParameter("id");
			    	TypeCarburantForm	temp=null;
			    	if(id==null)
			    	temp= new TypeCarburantForm();
			    	else{
			    		if(id.equals(""))
			    			temp= new TypeCarburantForm();
			    		    else
					    	 temp= ldao.recup(id);
			    		
			    		 session.setAttribute("carb_article", temp);
			    		
			    	}
			    
			  try{
			   	   session.setAttribute("liste_article1",carb_articledao.reste(temp.getListe_article()));
				    session.setAttribute("liste_article",carb_articledao.getArticles( temp.getid_carburant()));	
			  }catch(Exception e){}
			  
			  }
			   
			
			   
			   
			   
		}catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			   
	
			return mapping.findForward(frd);
		}
		
		

	
	}




