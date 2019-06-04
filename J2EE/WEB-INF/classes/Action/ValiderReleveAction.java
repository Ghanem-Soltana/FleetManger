

package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.DistDistanceForm;
import Dao.Conn;
import Dao.DistReleveDao;




public class ValiderReleveAction extends Action {
	
		 
		
		

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

       DistReleveDao ldao =new DistReleveDao(cnx.getcnx());
		

           if(action.equals("valider"))
           {
        	   DistDistanceForm tfrm=(DistDistanceForm)form;
        	   ldao.valider(tfrm);
        	   session.setAttribute("sms", "valifer_laisser_ok");

        	   int pos=0;
        	   
        	   ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_valider_releve", liste);

	
		    	
				
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	DistDistanceForm temp=liste.get(pos);
				    	session.setAttribute("valider_releve", temp);
				    	session.setAttribute("pos", indice(temp.getId_distance(),temp.getId_vehicule(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("valider_releve", new DistDistanceForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
           }

	        

           if(action.equals("refuser"))
           { DistDistanceForm tfrm=(DistDistanceForm)form;
    	   ldao.refuser(tfrm);
    	   session.setAttribute("sms", "valifer_laisser_ok");

    	   int pos=0;
    	   
    	   ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
	    	liste=ldao.en_attente();
	    	if(liste.size()==0)
	    	session.setAttribute("listevide", "rien");
	    	session.setAttribute("liste_valider_releve", liste);


	    	
			
			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    	DistDistanceForm temp=liste.get(pos);
			    	session.setAttribute("valider_releve", temp);
			    	session.setAttribute("pos", indice(temp.getId_distance(),temp.getId_vehicule(),liste));
			    	session.setAttribute("total", liste.size());
		
						    
			   }
			   else 
			   {  
				   session.setAttribute("liste_vide", " ");    	
			  	session.setAttribute("valider_releve", new DistDistanceForm());
		    	session.setAttribute("pos", "0");
		    	session.setAttribute("total", "0");
			   }
           }

	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      String annee=request.getParameter("annee");
	      DistDistanceForm aux=ldao.recup(id,annee);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.removeAttribute("x");
		  }
		  else{int pos=0;
			ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
	    	liste=ldao.en_attente();
	      session.setAttribute("valider_releve",  aux);
	      session.setAttribute("x", " ");
	      
	      
	      

			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", indice(aux.getId_distance(),aux.getId_vehicule(),liste));
			    	session.setAttribute("total", liste.size());
		
						    
			   }
			   else 
			   {  
				session.setAttribute("liste_vide", " ");    	
		    	session.setAttribute("pos", "0");
		    	session.setAttribute("total", "0");
			   }
		  }
	        }  
	        
	        
	        
	        
	  
			
			
			
			
			
			

		    

			
			
			   if(action.equals("all"))
			    {ldao.annuler_alerte_releve();
				
			    	session.setAttribute("valider_releve", new DistDistanceForm());
			    	session.removeAttribute("x");
			    	
			    	int pos=0;
					ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			    	liste=ldao.en_attente();
			    	DistDistanceForm aux=new DistDistanceForm();
			    	if(liste.size()!=0)
			    	 aux=liste.get(0);
		
			      session.setAttribute("valider_releve",  aux);
			      session.setAttribute("x", " ");
			      
			      
			      

					   if(pos<0)
						   pos=liste.size();
					   if(pos>=liste.size())
						   pos=0;
					   
					    	
					   if(liste.size()!=0)
					   {
					    
					    	session.setAttribute("x", "modifier");
					    	session.setAttribute("pos", indice(aux.getId_distance(),aux.getId_vehicule(),liste));
					    	session.setAttribute("total", liste.size());
				
								    
					   }
					   else 
					   {  
						session.setAttribute("liste_vide", " ");    	
				    	session.setAttribute("pos", "0");
				    	session.setAttribute("total", "0");
					   }
				  
			    	
			    }
			   
			   
		
			   
			   
			   
			   if(action.equals("sui"))
			   {
				   String id_rel=request.getParameter("id_rel");
				   String id_vehi=request.getParameter("id_vehi");

				   ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			       liste=ldao.en_attente();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	DistDistanceForm temp=suivant(id_rel,id_vehi,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	session.setAttribute("valider_releve", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_distance(),temp.getId_vehicule(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("valider_releve", new DistDistanceForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   if(action.equals("pred"))
			   {
				   String id_rel=request.getParameter("id_rel");
				   String id_vehi=request.getParameter("id_vehi");
				   ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
			    	liste=ldao.en_attente();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	DistDistanceForm temp=pred(id_rel,id_vehi,liste);
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	session.setAttribute("valider_releve", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_distance(),temp.getId_vehicule(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("valider_releve", new DistDistanceForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   ArrayList<DistDistanceForm> liste=new ArrayList<DistDistanceForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_valider_releve", liste);
		    	
		    	
		    	
			   
   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		public DistDistanceForm suivant(String id_rel,String id_vehi, ArrayList<DistDistanceForm> liste) 
		{DistDistanceForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
		   if(liste.get(i).getId_distance().equals(id_rel)&&liste.get(i).getId_vehicule().equals(id_vehi))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public DistDistanceForm pred(String id_rel,String id_vehi, ArrayList<DistDistanceForm> liste) 
		{DistDistanceForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_distance().equals(id_rel)&&liste.get(i).getId_vehicule().equals(id_vehi))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id_rel,String id_vehi, ArrayList<DistDistanceForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false & i<liste.size())
			{
				if(liste.get(i).getId_distance().equals(id_rel)&&liste.get(i).getId_vehicule().equals(id_vehi))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
		
		

	
	}







