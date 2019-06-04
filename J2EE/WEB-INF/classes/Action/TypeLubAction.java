package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.FamArticlePrinciForm;
import Bean.FamArticleSecForm;

import Bean.ArticleForm;


import Bean.TypeLubForm;
import Dao.Conn;
import Dao.FamArticlePrinciDao;
import Dao.FamArticleSecDao;
import Dao.ArticleDao;

import Dao.TypeLubDao;

public class TypeLubAction extends Action {
	
		 
		
		
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
		   
		    
		

		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    
		    TypeLubForm afficher= new TypeLubForm("          ","          ","xxxxxx","          ","xxxxxx","          ","xxxxxx","          ");
		    TypeLubDao ldao =new TypeLubDao(cnx.getcnx());
		    FamArticlePrinciDao princidao =new FamArticlePrinciDao(cnx.getcnx());
		    FamArticleSecDao secdao=new FamArticleSecDao (cnx.getcnx());
		    ArticleDao articledao=new ArticleDao (cnx.getcnx());
		    ArrayList<FamArticlePrinciForm> liste_fam_princi= new ArrayList<FamArticlePrinciForm>();	 
		    ArrayList<FamArticlePrinciForm> liste_fam_princi_afficher= new ArrayList<FamArticlePrinciForm>();
		    ArrayList<FamArticleSecForm> liste_fam_sec= new ArrayList<FamArticleSecForm>();
	        ArrayList<FamArticleSecForm> liste_fam_sec_afficher= new ArrayList<FamArticleSecForm>();
	        ArrayList<ArticleForm> liste_article= new ArrayList<ArticleForm>();
		    ArrayList<ArticleForm> liste_article_afficher= new ArrayList<ArticleForm>();
		   
		    
		    
		    try{
		    if(action.equals("all"))
		    {
	
			if(!Utilitaire.present(request, "afficher"))
		    	session.setAttribute("afficher", afficher);
		    
		    	liste_fam_princi_afficher=princidao.all();
		   	liste_fam_princi=princidao.all();
	    	liste_fam_princi.add(0,new FamArticlePrinciForm("xxxxxx","          ",false,false));
	    	liste_fam_princi_afficher.add(0,new FamArticlePrinciForm("xxxxxx","tous ",false,false));
	    	session.setAttribute("liste_fam_princi", liste_fam_princi);
	    	session.setAttribute("liste_fam_princi_afficher", liste_fam_princi_afficher);
	    	
	    	
	    	
	        liste_fam_sec_afficher=secdao.all();
	    	liste_fam_sec.add(0,new FamArticleSecForm("xxxxxx","           ","          ","          "));
	    	liste_fam_sec_afficher.add(0,new FamArticleSecForm("xxxxxx","tous ","          ","          "));
	    	session.setAttribute("liste_fam_sec", liste_fam_sec);
	    	session.setAttribute("liste_fam_sec_afficher", liste_fam_sec_afficher);

	    	
	    	
	    	
		   liste_article_afficher=articledao.all();	 
		    ArticleForm temp= new ArticleForm();
		    temp.setId_article("xxxxxx");
		    liste_article.add(0,temp);

		    ArticleForm temp1= new ArticleForm();
		    temp1.setId_article("xxxxxx");
		    temp1.setLibelle_article("tous");
	    	liste_article_afficher.add(0,temp1);
	    	
	    	session.setAttribute("liste_article", liste_article);
	    	session.setAttribute("liste_article_afficher", liste_article_afficher);

	
	    	
		    }
	    	
	    	

	    	
	        if(action.equals("ajout"))
	        {   	        	session.setAttribute("typelub", new TypeLubForm());

	        	boolean test=true;
	        	TypeLubForm tfrm=(TypeLubForm) form;
	            if(tfrm.getId_typelub()==null||tfrm.getId_typelub().equals("")||tfrm.getId_typelub().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("typelub", new TypeLubForm("",tfrm.getLibelle_typelub(),"","","","","",""));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");
	        	ArrayList<FamArticleSecForm> liste_vide_sec=new ArrayList<FamArticleSecForm>();
			    ArrayList<ArticleForm> liste_vide_article=new ArrayList<ArticleForm>();
			    session.setAttribute("liste_fam_sec", liste_vide_sec); 
		        session.setAttribute("liste_article", liste_vide_article);
	        	
	        	}}
	        	
	        	ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_typelub", liste);
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeLubForm tfrm=(TypeLubForm) form;
	        	TypeLubForm aux=ldao.recup(tfrm.getId_typelub());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("typelub", new TypeLubForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	     }
	        	ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_typelub", liste);
		    	
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("typelub",new TypeLubForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeLubForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("typelub", new TypeLubForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeLubForm x= ldao.recup(id);
		   String id_princi=x.getId_famart();
	   ArrayList<FamArticleSecForm> l=new ArrayList<FamArticleSecForm>();
	   l=secdao.select(id_princi);
	    session.setAttribute("liste_fam_sec", l);
	    try{
	    session.setAttribute("liste_article",articledao.select(l.get(0).getId_famille_sec(), id_princi));
	    }catch(Exception e){}  
	    session.setAttribute("typelub",  x);
	      session.setAttribute("x", "");
	      
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeLubForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_typelub", liste);
		    	session.setAttribute("typelub", new TypeLubForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
		
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_typelub", liste);
			    	session.setAttribute("typelub", new TypeLubForm());
			    	session.setAttribute("afficher", afficher);
			    	session.removeAttribute("x");
			   
			    }
			   
			   if(action.equals("annul"))
			   {session.removeAttribute("x");
			   session.setAttribute("typelub", new TypeLubForm());
				   
			   }
			  
			   
			   
			   
			       //fini
			   if(action.equals("select"))
			   {
				   
			   String id_princi=request.getParameter("id");
			      ArticleForm article_tous= new ArticleForm();
			      article_tous.setId_article("xxxxxx");
			      article_tous.setLibelle_article("          ");
			   
			  if(!id_princi.equals("xxxxxx"))
			  {
			   ArrayList<FamArticleSecForm> liste_fam_sec_temp=new ArrayList<FamArticleSecForm>();
			   liste_fam_sec_temp=secdao.select(id_princi);
			   if(liste_fam_sec_temp.size()==0)
			   liste_fam_sec_temp.add(0,new FamArticleSecForm("xxxxxx","           ","          ","          "));
			   session.setAttribute("liste_fam_sec", liste_fam_sec_temp);
			    
				
	                
	                String id_secon="";
	                if(liste_fam_sec_temp.size()!=0)
	                id_secon  =liste_fam_sec_temp.get(0).getId_famille_sec();
	 			   ArrayList<ArticleForm> liste_article_temp=new ArrayList<ArticleForm>();
	 			   liste_article_temp=articledao.select(id_secon,id_princi);
	 			   if(liste_article_temp.size()==0)
	 			 liste_article_temp.add(0, article_tous);

	 			   
	 			   session.setAttribute("liste_article", liste_article_temp);
			  }
			  else{ArrayList<FamArticleSecForm> liste_vide_sec=new ArrayList<FamArticleSecForm>();
			       ArrayList<ArticleForm> liste_vide_article=new ArrayList<ArticleForm>();
			       liste_vide_sec.add(0,new FamArticleSecForm("xxxxxx","           ","          ","          "));
			       liste_vide_article.add(0,article_tous);
				    session.setAttribute("liste_fam_sec", liste_vide_sec); 
			        session.setAttribute("liste_article", liste_vide_article);
			      }
			  
			   TypeLubForm  aux=(TypeLubForm)form;
               aux.setId_famart(id_princi);
               session.setAttribute("typelub",aux);
	                
			   }
			   
			   
		
			   //fini
			   if(action.equals("select2"))
			   {
				   ArrayList<FamArticleSecForm> nouvelle_liste_sec=new ArrayList<FamArticleSecForm>();
				   nouvelle_liste_sec=secdao.select(((TypeLubForm)form).getId_famart());
				    session.setAttribute("liste_fam_sec", nouvelle_liste_sec);

					      ArticleForm article_tous= new ArticleForm();
					      article_tous.setId_article("xxxxxx");
					      article_tous.setLibelle_article("          ");

		       String id_sec=request.getParameter("id");
		       
		       if(!id_sec.equals("xxxxxx"))
		       {
			   ArrayList<ArticleForm> liste_article_temp=new ArrayList<ArticleForm>();
			   liste_article_temp=articledao.select(id_sec,((TypeLubForm)form).getId_famart());
	
			   if(liste_article_temp.size()==0)
		 	liste_article_temp.add(0, article_tous); 
			   session.setAttribute("liste_article", liste_article_temp);
		       }
		       else{
		    	   
		           ArrayList<ArticleForm> liste_vide_article=new ArrayList<ArticleForm>();
			       liste_vide_article.add(0,article_tous);
			       session.setAttribute("liste_article", liste_vide_article);
		       }
			   
			   
			    TypeLubForm  aux=(TypeLubForm)form;
                aux.setId_sfamart(id_sec);
                session.setAttribute("typelub",aux);
			   
			   }
		
			   
			  
			   
			   
			   
			   // fini
			   if(action.equals("select4"))
			   {session.removeAttribute("listevide");

				   String id_princi=request.getParameter("id");
				   ArticleForm article_tous= new ArticleForm();
				   article_tous.setId_article("xxxxxx");
				   article_tous.setLibelle_article("tous");      
				   ArrayList<FamArticleSecForm> liste_fam_sec_aff=new ArrayList<FamArticleSecForm>();
				   liste_fam_sec_aff=secdao.select(id_princi);
				   liste_fam_sec_aff.add(0,new FamArticleSecForm("xxxxxx","tous","          ","          "));
				   session.setAttribute("liste_fam_sec_afficher", liste_fam_sec_aff);
				   String id_secon="";
				   ArrayList<ArticleForm> liste_artic_aff=new ArrayList<ArticleForm>();
		           id_secon  =liste_fam_sec_aff.get(0).getId_famille_sec();	 
		           liste_artic_aff=articledao.select(id_secon,id_princi);
				   liste_artic_aff.add(0,article_tous);		 	
				   session.setAttribute("liste_article_afficher", liste_artic_aff);  
		 		   afficher=(TypeLubForm)session.getAttribute("afficher");
		 		   afficher.setId_famart(id_princi);
		 		   
		 		   
		 		   //correction beug
		 		   corrigeSec(liste_fam_sec_aff,afficher);
		 		   corrigeArt(liste_artic_aff,afficher);
				   session.setAttribute("afficher", afficher);
				   
				   
				   
				   
				   ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
				   liste=ldao.select(afficher);
				   session.setAttribute("liste_typelub", liste);
		    		if(liste.size()==0)
				    session.setAttribute("listevide", "rien");
		    		

		 			}
			   
			   
			   
			   
			   if(action.equals("select5"))
				   
			   {   session.removeAttribute("listevide");
				   
				   ArrayList<FamArticleSecForm> nouvelle_liste_sec_aff=new ArrayList<FamArticleSecForm>();
				   nouvelle_liste_sec_aff=secdao.select(((TypeLubForm)form).getId_famart());
				   nouvelle_liste_sec_aff.add(0,new FamArticleSecForm("xxxxxx","tous","",""));
				   session.setAttribute("liste_fam_sec_afficher",  nouvelle_liste_sec_aff);
				   
			   String id_sec=request.getParameter("id");
			   afficher=(TypeLubForm)session.getAttribute("afficher");
			   afficher.setId_sfamart(id_sec);
			   ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
			   liste=ldao.select(afficher);
	
			   
			  
			  
	    		
	    
				
					   
				   liste_article_afficher=articledao.select(id_sec,afficher.getId_famart());
	
				   
				   ArticleForm temp2= new ArticleForm();
				    temp2.setId_article("xxxxxx");
				    temp2.setLibelle_article("tous");
				   liste_article_afficher.add(0,temp2);
				   session.setAttribute("liste_article_afficher", liste_article_afficher);
			
				   
				   
				   
				//beug
		 		   corrigeArt(liste_article_afficher,afficher);
				   session.setAttribute("afficher", afficher);
				   session.setAttribute("liste_typelub", liste);
		    		if(liste.size()==0)
				    session.setAttribute("listevide", "rien");
			   }
			   
			   
		   if(action.equals("select6"))
				   
			   {   session.removeAttribute("listevide");
			   
			   ArrayList<FamArticleSecForm> nouvelle_liste_sec_aff=new ArrayList<FamArticleSecForm>();
			   nouvelle_liste_sec_aff=secdao.select(((TypeLubForm)form).getId_famart());
			   nouvelle_liste_sec_aff.add(0,new FamArticleSecForm("xxxxxx","tous","",""));
			   session.setAttribute("liste_fam_sec_afficher",  nouvelle_liste_sec_aff);
			   

				   
			   String id=request.getParameter("id");
			   afficher=(TypeLubForm)session.getAttribute("afficher");
			   afficher.setId_article(id);
		
			   session.setAttribute("afficher", afficher);
			
			   ArrayList<TypeLubForm> liste=new ArrayList<TypeLubForm>();
			   liste=ldao.select(afficher);
	
			   session.setAttribute("liste_typelub", liste);
	    		if(liste.size()==0)
			    session.setAttribute("listevide", "rien");
			   }		   
	
		   
		   
}catch(Exception e ){System.out.println(e);}
		   
		    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		
		public void corrigeSec(ArrayList<FamArticleSecForm> l_fam_sec ,TypeLubForm aff)
		{  
			boolean trouve =false;int i= 0;
			while (trouve==false && i<l_fam_sec.size())
			{ if(l_fam_sec.get(i).getId_famille_sec().equals(aff.getId_sfamart()))
	        	trouve=true;
	        else i++;
			}
			if(!trouve)
				aff.setId_sfamart("xxxxxx");
		
		}

	
		
		public void corrigeArt(ArrayList<ArticleForm> l_article ,TypeLubForm aff)
		{
			boolean trouve =false;int i= 0;
			while (trouve==false && i<l_article.size())
	        if(l_article.get(i).getId_article().equals(aff.getId_article()))
	        	trouve=true;
	        else i++;
			
			if(!trouve)
				aff.setId_article("xxxxxx");
		}
		
	}




