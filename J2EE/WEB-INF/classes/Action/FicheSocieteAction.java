package Action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.FicheSocieteForm;
import Bean.UploadForm;
import Bean.VilleForm;
import Dao.Conn;
import Dao.FicheSocieteDao;
import Dao.VilleDao;

public class FicheSocieteAction extends Action {
	
		 
		
		
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
		  
		    session.removeAttribute("sms");
		    session.setAttribute("file",new UploadForm());
		    session.removeAttribute("erreur");


	
		    FicheSocieteDao ldao =new FicheSocieteDao (cnx.getcnx());
		    VilleDao edao=new VilleDao(cnx.getcnx());
		    
		    
		    ArrayList<VilleForm> liste2= new ArrayList<VilleForm>();
	    	liste2=edao.all();
	    	liste2.add(0,new VilleForm("xxxxx","          ",""));
	    	session.setAttribute("liste2", liste2);
	 
		    
	   try{
	        if(action.equals("edit"))
	        {
	        	FicheSocieteForm tfrm=(FicheSocieteForm) form;

	        
	        	       boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        session.setAttribute("sms", "modif_ok");
	        	        else session.setAttribute("erreur", "er_base");
	        	  
	        	FicheSocieteForm l=new FicheSocieteForm();
		    	l=ldao.all();
		    	if(l.getId_ville()==null||l.getId_ville().equals(""))
		    	l.setId_ville("xxxxxx");
		    	session.setAttribute("societe",l);
				
	        }
	        
	        
	        

			
			   if(action.equals("all"))
			    {
			    	FicheSocieteForm l=new FicheSocieteForm();
			    	l=ldao.all();
			    	if(l.getId_ville()==null||l.getId_ville().equals(""))
				    	l.setId_ville("xxxxxx");
			    	session.setAttribute("societe", l);
			      	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
				   	int id=fdao.getnb();
			        session.setAttribute("nb", String.valueOf(id-1));

			    }
			   
	   }catch(Exception e ){System.out.println(e);}
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




