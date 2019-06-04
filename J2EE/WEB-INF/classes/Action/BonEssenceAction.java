package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.BonEssenceForm;
import Dao.Conn;
import Dao.BonEssenceDao;

public class BonEssenceAction extends Action {
	
		 
		
		
		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			Utilitaire.afficherAttributes(request);
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
		    BonEssenceDao ldao =new BonEssenceDao(cnx.getcnx());

		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("type_bon", new BonEssenceForm());
	        	boolean test=true;
	        	BonEssenceForm tfrm=(BonEssenceForm) form;
	            if(tfrm.getId_bon()==null||tfrm.getId_bon().equals("")||tfrm.getId_bon().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
	        	tfrm.setId_bon("");
		    	session.setAttribute("type_bon",tfrm);
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<BonEssenceForm> liste=new ArrayList<BonEssenceForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_type_bon", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	BonEssenceForm tfrm=(BonEssenceForm) form;
	        	BonEssenceForm aux=ldao.recup(tfrm.getId_bon());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("type_bon", new BonEssenceForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<BonEssenceForm> liste=new ArrayList<BonEssenceForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_type_bon", liste);
		    	session.setAttribute("type_bon",new BonEssenceForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      BonEssenceForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("type_bon", new BonEssenceForm());
		  session.removeAttribute("x");
		  }
		  else{
		  BonEssenceForm x= ldao.recup(id);
	      session.setAttribute("type_bon",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				BonEssenceForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<BonEssenceForm> liste=new ArrayList<BonEssenceForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("type_type_bon", liste);
		    	session.setAttribute("type_bon", new BonEssenceForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<BonEssenceForm> liste=new ArrayList<BonEssenceForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("type_type_bon", liste);
			    	session.setAttribute("type_bon", new BonEssenceForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		    }catch(Exception e ){System.out.println(e);}			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




