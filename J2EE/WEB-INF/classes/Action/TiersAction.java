package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.BlockerForm;
import Bean.TiersForm;
import Bean.TypeTiersForm;
import Dao.Conn;
import Dao.TiersDao;
import Dao.TypeTiersDao;

public class TiersAction extends Action {
	
		 
		
		
		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			Conn cnx=new Conn();
			String frd = "ok";
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
		    
		    
		    request.setAttribute("x", null);
		    session.removeAttribute("listevide");
		    session.removeAttribute("erreur");
		    session.removeAttribute("pas_de_type");
		    session.removeAttribute("sms");
		    TiersDao ldao =new TiersDao(cnx.getcnx());
		    TypeTiersDao typedao =new TypeTiersDao(cnx.getcnx());
		    ArrayList<TypeTiersForm>liste_type=new ArrayList<TypeTiersForm>();
		    liste_type= typedao.all();
		    session.setAttribute("liste_type_tiers",liste_type);
		    session.setAttribute("liste_blocker",this.listeBlocker());
		   try{
		    if(liste_type.size()==0)
		    {
		    	 session.setAttribute("pas_de_type",liste_type);
		    }}catch(Exception e){session.setAttribute("pas_de_type",liste_type);}
		    
		    
		    
		    
		    
		    try{

	        if(action.equals("ajout"))
	        {   session.setAttribute("tiersss", new TiersForm());
	        	boolean test=true;
	        	TiersForm tfrm=(TiersForm) form;
	            if(tfrm.getId_tiers()==null||tfrm.getId_tiers().equals("")||tfrm.getId_tiers().indexOf('&')!=-1)
	            session.setAttribute("erreur", "er_invalide");
	            else{
	        	test=ldao.add(tfrm);
	            
	        	if(test==false)
	        	{session.setAttribute("erreur", "er_existant");
		    	session.setAttribute("tiersss", new TiersForm("",tfrm.getLibelle_tiers(),tfrm.getMatricule_fiscale(),tfrm.getTel_tiers(),tfrm.getBlockage_tiers(),tfrm.getAdresse_tiers(),tfrm.getCp_tiers(),tfrm.getFax_tiers(),tfrm.getRemarque_tiers(),tfrm.getMail_tiers(),tfrm.getContact_tiers(),tfrm.getId_type_tiers(),tfrm.getLibelle_type_tiers()));
	        	}
	        	else
	        	{session.setAttribute("sms", "ajout_ok");}}
	        	
	        	ArrayList<TiersForm> liste=new ArrayList<TiersForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_tiersss", liste);
		      	if(liste.size()==0)
			   session.setAttribute("listevide", "rien");
	
	        	
	        }
	        if(action.equals("edit"))
	        {
	        	TiersForm tfrm=(TiersForm) form;
	        	TiersForm aux=ldao.recup(tfrm.getId_tiers());
	        	if(aux==null)
	  		  {session.setAttribute("erreur", "er_modif");
	  		   session.setAttribute("tiersss", new TiersForm());
	  		  }
	        	else{boolean modif=ldao.update(tfrm);
	        	        if(modif)
	        	        {session.setAttribute("sms", "modif_ok");}
	        	        else session.setAttribute("erreur", "er_modif1");
	        	     }
	        	ArrayList<TiersForm> liste=new ArrayList<TiersForm>();
		    	liste=ldao.all();
		    	session.setAttribute("liste_tiersss", liste);
		    	session.setAttribute("tiersss",new TiersForm());
		    	session.removeAttribute("x");
	  		  

				

	        }
	        
	        
	        
	        
	        if(action.equals("modif"))
	        {
	      String id=request.getParameter("id");
	      TiersForm aux=ldao.recup(id);
		  if(aux==null)
		  {session.setAttribute("erreur", "er_modif");
		  session.setAttribute("tiersss", new TiersForm());
		  session.removeAttribute("x");
		  }
		  else{
		  TiersForm x= ldao.recup(id);
	      session.setAttribute("tiersss",  x);
	      session.setAttribute("x", "");
		  }


	        }  
		    
			if(action.equals("supp"))
			{   
				String id=request.getParameter("id");
				TiersForm aux=ldao.recup(id);
				if(aux==null)
				session.setAttribute("erreur", "er_suppinex");
				else{
				boolean test=ldao.delete(id);
				if(!test)
				session.setAttribute("erreur", "er_suppcascade");
				else{session.setAttribute("sms", "supp_ok");}
				}
		    	ArrayList<TiersForm> liste=new ArrayList<TiersForm>();
		    	liste=ldao.all();
		    	if(liste.size()==0)
		    	session.setAttribute("listevide", "rien");
		    	session.setAttribute("liste_tiersss", liste);
		    	session.setAttribute("tiersss", new TiersForm());
		    	
		    	session.removeAttribute("x");
			
			}
			
			   if(action.equals("all"))
			    {
				
			    	ArrayList<TiersForm> liste=new ArrayList<TiersForm>();
			    	liste=ldao.all();
			    	
			    	if(liste.size()==0)
			    	session.setAttribute("listevide", "rien");
			    	session.setAttribute("liste_tiersss", liste);
			    	session.setAttribute("tiersss", new TiersForm());
			    	session.removeAttribute("x");
			   
			    }
			   
		    }catch(Exception e ){System.out.println(e);}
			   
			   cnx.closecnx();
			return mapping.findForward(frd);
		}
		
		
public ArrayList<BlockerForm> listeBlocker()
{ArrayList<BlockerForm> res=new ArrayList<BlockerForm>();
res.add(new BlockerForm("r"," "));
res.add(new BlockerForm("o","blocké"));
res.add(new BlockerForm("n","non blocké"));
return res;
}
	
	}




