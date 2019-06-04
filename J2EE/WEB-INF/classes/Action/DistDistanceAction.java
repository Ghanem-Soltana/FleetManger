package Action;

import java.io.InputStream;
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
import Bean.DistDistanceForm;
import Bean.RechercheDateForm;
import Dao.Conn;
import Dao.DistDistanceDao;
import Dao.FicheSocieteDao;

public class DistDistanceAction extends Action {
	
		 
		
		
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
		    session.removeAttribute("erreur");
		    session.removeAttribute("sms");
		    DistDistanceDao ldao =new DistDistanceDao(cnx.getcnx());
try{
	

	     
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_distance", liste);
			    	RechercheDateForm ladate=new RechercheDateForm() ; 
			    	session.setAttribute("ladate", ladate);

			   
			    }
			   
			   
			   
			   
			   if(action.equals("imprimer_tous"))
			    { 
			    	
			    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
	    		   	int id=fdao.getnb();
	                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
	                
	                temp4=temp4.replace(".gif", id-1+".gif");
	                temp4.replace("\\", "\\\\");
			    	
					    String source = "/report/distance_all.jasper";
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
			   
			   
			   
			   if(action.equals("imprimer"))
			    { 	String date_debut=request.getParameter("date_debut");
			    	String date_fin=request.getParameter("date_fin");
				
			    	
			    	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
	    		   	int id=fdao.getnb();
	                String temp4=request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
	                
	                temp4=temp4.replace(".gif", id-1+".gif");
	                temp4.replace("\\", "\\\\");
			    	
					    String source = "/report/distance.jasper";
		                Map<String, String> hParametre = new HashMap<String, String>();
		                Dao.FicheSocieteDao societeldao =new Dao.FicheSocieteDao(cnx.getcnx());           
		                hParametre.put("societe", societeldao.all().getLibelle_societe());
		                hParametre.put("sigle", societeldao.all().getSigle());              
		                if(!new java.io.File(temp4).exists())
			                temp4=	request.getSession().getServletContext().getRealPath("//images//societe//logo0.gif");
			              
		                hParametre.put("image", temp4);
		                hParametre.put("date_debut",inverser(date_debut.replace("/","-"),"-"));              
		                hParametre.put("date_fin",inverser( date_fin.replace("/","-"),"-"));              
		                hParametre.put("debut","Du "+date_debut);              
		                hParametre.put("fin"," Au "+date_fin);              
		               
		                response.setContentType("application/pdf");
		                InputStream reportStream = this.servlet.getServletConfig().getServletContext().getResourceAsStream(source);
		                Utilitaire.doEtat(request, response , hParametre , source, cnx.getcnx() , reportStream);
	
		                frd="";
		 			   
			   
			    }
			   
			   
			   if(action.equals("rechercher"))
			    { 	String date_debut=request.getParameter("date_debut");
			    	String date_fin=request.getParameter("date_fin");
				
			    	ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			    	liste=ldao.all(date_debut,date_fin);
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_distance", liste);
                    session.setAttribute("ladate",new RechercheDateForm(date_debut,date_fin) ); 
			   
			    }
			   
		}catch(Exception e ){System.out.println(e);}			   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		

		
		 public String inverser(String ch,String split)
		 {
			 String res="";

			 if(!ch.equals("null"))
			 {
				 String tab[]=ch.split(split);
				 res=tab[2]+split+tab[1]+split+tab[0];
			 }
			 else{return ch;}
			 return res;
		 }

	
	}






