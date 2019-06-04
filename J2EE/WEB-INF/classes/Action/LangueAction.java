package Action;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import Bean.LangueForm;



public class LangueAction extends Action {

		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
	
			String frd = "ok";
			String action = request.getParameter("action");
			 HttpSession session = request.getSession();
			
			try{
			   if(action.equals("changer"))
			    {
				  
			   LangueForm frm=(LangueForm)form;
			   String ch=frm.getPage();
			   int nb=0;
			   for(int i=0;i<ch.length();i++)
			   {	
			   	if(ch.charAt(i)=='/')
			   		nb=i;
			   }
			   nb++;
			   ch=ch.substring(nb);
			   request.getSession().setAttribute("ch",ch);
			   setLocale( request, new Locale( frm.getLangue()) );
			   session.setAttribute("lng", getLocale(request).getLanguage());
			    
			    }
			   
			   
			}catch(Exception e ){System.out.println(e);}
			return mapping.findForward(frd);
		}
		
		
	
	
	}




