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
import Bean.FamArticlePrinciForm;
import Bean.FamArticleSecForm;
import Bean.TypeUniteForm;
import Bean.TypeArticleForm;
import Bean.TypeNatArticleForm;
import Dao.Conn;
import Dao.FamArticlePrinciDao;
import Dao.FamArticleSecDao;
import Dao.ArticleDao;
import Dao.TypeUniteDao;
import Dao.TypeArticleDao;
import Dao.TypeNatArticleDao;

public class ArticleAction extends Action {
	
		 
		
		
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
	
		    
		    
		    session.removeAttribute("listevide");
		    session.removeAttribute("listevide2");
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    session.removeAttribute("liste_famille_principale");
		    session.removeAttribute("liste_famille_secondaire");
		    session.removeAttribute("liste_nature_article");
		    session.removeAttribute("liste_famille_principale_vide");
		    session.removeAttribute("liste_nature_article_vide");
		    ArticleDao ldao =new ArticleDao(cnx.getcnx());
		    FamArticlePrinciDao edao =new  FamArticlePrinciDao(cnx.getcnx());
		    FamArticleSecDao secdao =new  FamArticleSecDao(cnx.getcnx());
		    TypeArticleDao natdao =new  TypeArticleDao(cnx.getcnx());
		    TypeNatArticleDao naturedao =new  TypeNatArticleDao(cnx.getcnx());
		    TypeUniteDao unitedao=new TypeUniteDao(cnx.getcnx());;
		    ArrayList<FamArticlePrinciForm> liste2= new ArrayList<FamArticlePrinciForm>();
		    ArrayList<FamArticleSecForm> liste3= new ArrayList<FamArticleSecForm>();
		    ArrayList<TypeArticleForm> liste_nature_article= new ArrayList<TypeArticleForm>();
		    ArrayList<TypeNatArticleForm> liste_type_article= new ArrayList<TypeNatArticleForm>();
		    ArrayList<TypeUniteForm> liste_unite= new ArrayList<TypeUniteForm> ();

		    try{
		    liste2=edao.all();
	    	liste3=secdao.select(liste2.get(0).getId_famille_princi());
	    	session.setAttribute("liste_famille_principale", liste2);
	    	session.setAttribute("liste_famille_secondaire", liste3);
		    }catch(Exception e){}

		    try{
		    	    liste_nature_article=natdao.all();
			    	session.setAttribute("liste_nature_article", liste_nature_article);
				    }catch(Exception e){}
               if(liste_nature_article.size()==0)
               session.setAttribute("liste_nature_article_vide", " ");
               if(liste2.size()==0)
               session.setAttribute("liste_famille_principale_vide", " ");    
				    
				    
				    
				    try{
				    	liste_type_article=naturedao.all();
				    	session.setAttribute("liste_type_article", liste_type_article);
					    }catch(Exception e){}
		    
					    try{
					    	liste_unite=unitedao.all();
					    	session.setAttribute("liste_unite", liste_unite);
						    }catch(Exception e){}
			    
			    
	try{				

	        if(action.equals("ajout"))
	        {   session.setAttribute("articles", new ArticleForm());
	        	boolean test=true;
	        	ArticleForm tfrm=(ArticleForm) form;
	            if(tfrm.getId_article()==null||tfrm.getId_article().equals("")||tfrm.getId_article().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	tfrm.setId_article("");
	        	session.setAttribute("articles",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	 ArrayList<ArticleForm> liste=new ArrayList<ArticleForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_articles", liste);
	        		if(liste.size()==0)
					session.setAttribute("listevide", "rien");
	        		session.removeAttribute("x1");
	        }
	        
	        
	        
	        if(action.equals("edit"))
	        {
	        	ArticleForm tfrm=(ArticleForm) form;
	        	ArticleForm aux=ldao.recup(tfrm.getId_article());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");
	        	       	session.setAttribute("articles",tfrm);
	        	    	try{
					    	liste3=secdao.select(tfrm.getId_famille_principale());
					    	session.setAttribute("liste_famille_secondaire", liste3);
						    }catch(Exception e){}
	        	        }
	        	        else session.setAttribute("erreur", "er_modif1");
	        	        
	        	     }
	  		 
	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {int pos=0;			  	
	        ArrayList <ArticleForm> liste=new ArrayList<ArticleForm>();

	      String id=request.getParameter("id");
	      ArticleForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.removeAttribute("x1");
		  }
		  else{
		  ArticleForm x= ldao.recup(id);
	      session.setAttribute("articles",  x);
	      session.setAttribute("x1", "");
	      liste=ldao.all();
	      pos=indice(id,liste);
	      if(pos<0)
			   pos=liste.size();
		   if(pos>=liste.size())
			   pos=0;
		   
		   if(liste.size()!=0)
		   {
		
		    	session.setAttribute("pos", indice(x.getId_article(),liste));
		    	session.setAttribute("total", liste.size());
	
	             	try{
				    	liste3=secdao.select(x.getId_famille_principale());
				    	session.setAttribute("liste_famille_secondaire", liste3);
					    }catch(Exception e){}
					    
		   }
		   else 
		   {  
			   session.setAttribute("liste_vide", " ");    	
		  	session.setAttribute("articles", new ArticleForm());
	    	session.setAttribute("pos", "0");
	    	session.setAttribute("total", "0");
		   }
		  }
	        
	        
	        }
	        
	   


	        
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				ArticleForm aux=ldao.recup(id);
			  	 ArrayList<ArticleForm> liste=new ArrayList<ArticleForm>();
			  	int pos=0;
			    	liste=ldao.all();
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				 pos=indice(id,liste);
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
				
              
	
				liste=ldao.all();
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	ArticleForm temp=liste.get(pos);
				    	if(Utilitaire.present(request, "x1"))
				    	session.setAttribute("articles", temp);
				    	session.setAttribute("pos", indice(temp.getId_article(),liste));
				    	session.setAttribute("total", liste.size());
			
			             	try{
						    	liste3=secdao.select(temp.getId_famille_principale());
						    	session.setAttribute("liste_famille_secondaire", liste3);
							    }catch(Exception e){}
							    
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("articles", new ArticleForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   
		   
			
			}
			
			
			   
		
			
			   if(action.equals("all"))
			    {
				    session.removeAttribute("x1");
				    session.setAttribute("articles", new ArticleForm());

			    }
			   
			   
			   
			   if(action.equals("pred"))
			   {
					 String id=request.getParameter("id");
				   ArrayList<ArticleForm> liste=new ArrayList<ArticleForm>();
			    	liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	ArticleForm temp=pred(id,liste);
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	session.setAttribute("articles", temp);
				    	session.setAttribute("x1", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_article(),liste));
				    	session.setAttribute("total", liste.size());
			
			             	try{
						    	liste3=secdao.select(temp.getId_famille_principale());
						    	session.setAttribute("liste_famille_secondaire", liste3);
							    }catch(Exception e){}
							    
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("articles", new ArticleForm());
			    	session.setAttribute("x1", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   if(action.equals("sui"))
			   {
				   String id=request.getParameter("id");
				   ArrayList<ArticleForm> liste=new ArrayList<ArticleForm>();
			       liste=ldao.all();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	ArticleForm temp=suivant(id,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	session.setAttribute("articles", temp);
				    	session.setAttribute("x1", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_article(),liste));
				    	session.setAttribute("total", liste.size());
			
			             	try{
						    	liste3=secdao.select(temp.getId_famille_principale());
						    	session.setAttribute("liste_famille_secondaire", liste3);
							    }catch(Exception e){}
							    
				   }
				   else 
				   {  
					session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("articles", new ArticleForm());
			    	session.setAttribute("x1", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
	
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   if(action.equals("select"))
			   {String id=request.getParameter("id");
			   ArrayList<FamArticleSecForm> liste=new ArrayList<FamArticleSecForm>();
			   liste=secdao.select(id);
			   ArticleForm temp=(ArticleForm)form;
			   temp.setId_famille_principale(id);
		    	session.setAttribute("liste_famille_secondaire", liste);
		    	session.setAttribute("articles", temp);

			   }
			   
			   
			   
				ArrayList<ArticleForm> liste_articles=new ArrayList<ArticleForm>();
				liste_articles=ldao.all();
		    	session.setAttribute("liste_articles", liste_articles);
		    	if(liste_articles.size()==0)
		    		session.setAttribute("listevide", " ");
		    	
	
	}catch(Exception e ){System.out.println(e);} 
			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		
		public ArticleForm suivant(String id, ArrayList<ArticleForm> liste) 
		{ArticleForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_article().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public ArticleForm pred(String id, ArrayList<ArticleForm> liste) 
		{ArticleForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_article().equals(id))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id, ArrayList<ArticleForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_article().equals(id))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
	}




