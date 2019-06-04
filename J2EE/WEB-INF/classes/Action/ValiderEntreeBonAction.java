package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Bean.VehiEntrerCarburantForm;
import Dao.Conn;
import Dao.VehiEntrerCarburantDao;



public class ValiderEntreeBonAction extends Action {
	
		 
		
		
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





		   VehiEntrerCarburantDao ldao =new VehiEntrerCarburantDao(cnx.getcnx());
		 

		  
		  
       

           if(action.equals("valider"))
           {
        	   VehiEntrerCarburantForm tfrm=(VehiEntrerCarburantForm)form;
        	   ldao.valider(tfrm);
        	   session.setAttribute("sms", "valifer_entrer_bon_ok");

        	   int pos=0;
        	   
        	   ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_entree_bon", liste);

	
		    	
				
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	VehiEntrerCarburantForm temp=liste.get(pos);
				    	session.setAttribute("entree_bon", temp);
				    	session.setAttribute("pos", indice(temp.getId_bon(),temp.getId_exercice(),temp.getId_magasin(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					 session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("entree_bon", new VehiEntrerCarburantForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
           }

	        

           if(action.equals("refuser"))
           {

        	   VehiEntrerCarburantForm tfrm=(VehiEntrerCarburantForm)form;
        	   ldao.valider(tfrm);
        	   session.setAttribute("sms", "refus_laisser_ok");

        	   int pos=0;
        	   
        	   ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_entree_bon", liste);

	
		    	
				
				   if(pos<0)
					   pos=liste.size();
				   if(pos>=liste.size())
					   pos=0;
				   
				    	
				   if(liste.size()!=0)
				   {
				    	VehiEntrerCarburantForm temp=liste.get(pos);
				    	session.setAttribute("entree_bon", temp);
				    	session.setAttribute("pos", indice(temp.getId_bon(),temp.getId_exercice(),temp.getId_magasin(),liste));
				    	session.setAttribute("total", liste.size());
			
							    
				   }
				   else 
				   {  
					 session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("entree_bon", new VehiEntrerCarburantForm());
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
           }

	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      String annee=request.getParameter("id_exercice");
	      String magasin=request.getParameter("id_magasin");
	      VehiEntrerCarburantForm aux=ldao.recup(id,annee,magasin);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.removeAttribute("x");
		  }
		  else{int pos=0;
			ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
	    	liste=ldao.en_attente();
	      session.setAttribute("entree_bon",  aux);
	      session.setAttribute("x", " ");
	      
	      
	      

			   if(pos<0)
				   pos=liste.size();
			   if(pos>=liste.size())
				   pos=0;
			   
			    	
			   if(liste.size()!=0)
			   {
			    
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", indice(aux.getId_bon(),aux.getId_exercice(),aux.getId_magasin(),liste));
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
			    {ldao.annuler_alerte_entree_bon();
				
			    	session.setAttribute("entree_bon", new VehiEntrerCarburantForm());
			    	session.removeAttribute("x");
			    	
			    	int pos=0;
					ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
			    	liste=ldao.en_attente();
			    	VehiEntrerCarburantForm aux=new VehiEntrerCarburantForm();
			    	if(liste.size()!=0)
			    	 aux=liste.get(0);
			       session.setAttribute("entree_bon",  aux);
			       session.setAttribute("x", " ");
			      
			      
			      

					   if(pos<0)
						   pos=liste.size();
					   if(pos>=liste.size())
						   pos=0;
					   
					    	
					   if(liste.size()!=0)
					   {
					    
					    	session.setAttribute("x", "modifier");
					    	session.setAttribute("pos", indice(aux.getId_bon(),aux.getId_exercice(),aux.getId_magasin(),liste));
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
				   String id=request.getParameter("id");
				   String id_exercice=request.getParameter("id_exercice");
				   String id_magasin=request.getParameter("id_magasin");
				   ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
			       liste=ldao.en_attente();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	VehiEntrerCarburantForm temp=suivant(id,id_exercice,id_magasin,liste);
				    	if(temp==null)
				    	temp =liste.get(0);
				    	session.setAttribute("entree_bon", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos", indice(temp.getId_bon(),temp.getId_exercice(),temp.getId_magasin(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("entree_bon", new VehiEntrerCarburantForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   if(action.equals("pred"))
			   {
					   String id=request.getParameter("id");
					   String id_exercice=request.getParameter("id_exercice");
					   String id_magasin=request.getParameter("id_magasin");
				   ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
			    	liste=ldao.en_attente();
	
		
				  
				   if(liste.size()!=0)
				   {
				    	VehiEntrerCarburantForm temp=pred(id,id_exercice,id_magasin,liste);
				    	if(temp==null)
				    		temp =liste.get(liste.size()-1);
				    	session.setAttribute("entree_bon", temp);
				    	session.setAttribute("x", "modifier");
				    	session.setAttribute("pos",indice(temp.getId_bon(),temp.getId_exercice(),temp.getId_magasin(),liste));
				    	session.setAttribute("total", liste.size());
			
				   }
				   else 
				   {  
					   session.setAttribute("liste_vide", " ");    	
				  	session.setAttribute("entree_bon", new VehiEntrerCarburantForm());
			    	session.setAttribute("x", "modifier");
			    	session.setAttribute("pos", "0");
			    	session.setAttribute("total", "0");
				   }
			   }
			   
			   
			   
			   ArrayList<VehiEntrerCarburantForm> liste=new ArrayList<VehiEntrerCarburantForm>();
		    	liste=ldao.en_attente();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_entree_bon", liste);
		    	
		    	
		    	
			   
   
			    } cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
		
		
		
		public VehiEntrerCarburantForm suivant(String id,String id_exercice,String id_magasin, ArrayList<VehiEntrerCarburantForm> liste) 
		{VehiEntrerCarburantForm res=null;
		try{int i=0;
			boolean trouve=false;
			while (trouve==false && i<liste.size())
			{		System.out.print(id_exercice);

				if(liste.get(i).getId_bon().equals(id)&&liste.get(i).getId_exercice().equals(id_exercice)&&liste.get(i).getId_magasin().equals(id_magasin))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i+1);
		}catch(Exception e){}
		
		return res;
		}
		
		public VehiEntrerCarburantForm pred(String id,String id_exercice,String id_magasin, ArrayList<VehiEntrerCarburantForm> liste) 
		{VehiEntrerCarburantForm res=null;
		
		try{int i=0;
			boolean trouve=false;
			while (trouve==false && i<liste.size())
			{
				if(liste.get(i).getId_bon().equals(id)&&liste.get(i).getId_exercice().equals(id_exercice)&&liste.get(i).getId_magasin().equals(id_magasin))
					trouve =true;
				else
					i++;
			}
			
			res=liste.get(i-1);
		}catch(Exception e){}
		
		return res;
		}
		
		
		

		
		public int indice(String id,String id_exercice,String id_magasin, ArrayList<VehiEntrerCarburantForm> liste) 
		{
			int pos=0;int i=0;boolean trouve=false;
			try{
			
			while (trouve==false && i<liste.size())
			{
				if(liste.get(i).getId_bon().equals(id)&&liste.get(i).getId_exercice().equals(id_exercice)&&liste.get(i).getId_magasin().equals(id_magasin))
					trouve =true;
					i++;
			}
			
		}catch(Exception e){}
		
		if(trouve)pos=i;
		
			return pos;
			
		}
	
		
		

	
	}




