package Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.InputStream;
import Bean.TypeMaintForm;
import Dao.Conn;
import Dao.FicheSocieteDao;
import Dao.TypeMaintDao;

public class TypeMaintAction extends Action {
	
		 
		
		
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
		    TypeMaintDao ldao =new TypeMaintDao(cnx.getcnx());


		    if(action.equals("print4"))
		    {
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
    		   	int id=fdao.getnb();
                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
                
                temp4=temp4.replace(".gif", id-1+".gif");
                temp4.replace("\\", "\\\\");
		    	
				    String source = "/report/vehicule_tous.jasper";
	                Map<String, String> hParametre = new HashMap<String, String>();
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());              
	                if(!new java.io.File(temp4).exists())
		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		              
	                hParametre.put("image", temp4);
	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
	                frd="";
	       		 
		    }
		    
		    

		    if(action.equals("print3"))
		    {
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
    		   	int id=fdao.getnb();
                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
                
                temp4=temp4.replace(".gif", id-1+".gif");
                temp4.replace("\\", "\\\\");
		    	
				    String source = "/report/ordre_mission.jasper";
	                Map<String, String> hParametre = new HashMap<String, String>();
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());              
	                if(!new java.io.File(temp4).exists())
		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		              
	                hParametre.put("image", temp4);
	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
	                frd="";
	       		 
		    }
		    
		    
		    if(action.equals("print2"))
		    {
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
    		   	int id=fdao.getnb();
                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
                
                temp4=temp4.replace(".gif", id-1+".gif");
                temp4.replace("\\", "\\\\");
		    	
				    String source = "/report/validite.jasper";
	                Map<String, String> hParametre = new HashMap<String, String>();
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());              
	                if(!new java.io.File(temp4).exists())
		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		              
	                hParametre.put("image", temp4);
	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
	                frd="";
	       		 
		    }
		    
		    
		    if(action.equals("print1"))
		    { 	
		    	String id_centre=request.getParameter("id_centre");
		    	
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
		   		int id=fdao.getnb();
                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		   		temp4=temp4.replace(".gif", id-1+".gif");
		   		temp4.replace("\\", "\\\\");
            
		    	
				    String source = "/report/impression_selon_centre.jasper";
	                Map<String, String> hParametre = new HashMap<String, String>();
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());              
	                if(!new java.io.File(temp4).exists())
		                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
		              
	                hParametre.put("image", temp4);
                    
	                hParametre.put("id_centre", id_centre);
	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
			 
	                frd="";
	       		 
		    }
		    
		    
		    if(action.equals("print"))
		    {
		    	
		    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
    		   	int id=fdao.getnb();
                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
                
                temp4=temp4.replace(".gif", id-1+".gif");
                temp4.replace("\\", "\\\\");

				    String source = "/report/classic.jasper";
	                Map<String, String> hParametre = new HashMap<String, String>();
	                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
	                hParametre.put("societe", societeldao.all().getLibelle_societe());
	                hParametre.put("sigle", societeldao.all().getSigle());
	                if(!new java.io.File(temp4).exists())
	                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
	                hParametre.put("image", temp4);
	                response.setContentType("application/pdf");
	                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
	                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
			 
		   frd="";
		 
		     }
		    
		    try{
	        if(action.equals("ajout"))
	        {   session.setAttribute("maintenance", new TypeMaintForm());
	        	boolean test=true;
	        	TypeMaintForm tfrm=(TypeMaintForm) form;
	            if(tfrm.getId_maint()==null||tfrm.getId_maint().equals("")||tfrm.getId_maint().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("maintenance", new TypeMaintForm("",tfrm.getLibelle_maint()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TypeMaintForm> liste=new ArrayList<TypeMaintForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_maint", liste);
		      	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TypeMaintForm tfrm=(TypeMaintForm) form;
	        	TypeMaintForm aux=ldao.recup(tfrm.getId_maint());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("maintenance", new TypeMaintForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TypeMaintForm> liste=new ArrayList<TypeMaintForm>();
		    	liste=ldao.all();
		    	session.setAttribute("type_maint", liste);
		    	session.setAttribute("maintenance",new TypeMaintForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TypeMaintForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("maintenance", new TypeMaintForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TypeMaintForm x= ldao.recup(id);
	      session.setAttribute("maintenance",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TypeMaintForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TypeMaintForm> liste=new ArrayList<TypeMaintForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("type_maint", liste);
		    	session.setAttribute("maintenance", new TypeMaintForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TypeMaintForm> liste=new ArrayList<TypeMaintForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("type_maint", liste);
			    	session.setAttribute("maintenance", new TypeMaintForm());
			    	session.removeAttribute("x");
			   
			    }
			   
			   
			   
			   
		  
		    }catch(Exception e ){System.out.println(e);}			   
			  
			   } 

			 cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

	
	}




