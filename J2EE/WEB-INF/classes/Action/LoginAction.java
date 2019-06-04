package Action;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import Dao.Conn;
import Dao.LoginDao;
import Bean.LoginForm;
public final class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String action="",memo="",auto="",slogin="",pass="";
		if(req.getParameter("action")!=null)
	    action = req.getParameter("action");
		String frd = null;
		
		Conn cnx = new Conn();
		
		
		try{
		if (action.equals("init")) 
		{	
			LoginForm login=new LoginForm("","",false,false);
			req.setAttribute("login", login);
			frd="pok";
			
			Cookie[] cookies = req.getCookies();
			
                   if(cookies!=null)
			for(int i=0; i < cookies.length; i++) {
				Cookie MonCookie = cookies[i];
				if (MonCookie.getName().equals("memo")) 
			    memo = cookies[i].getValue();
				if (MonCookie.getName().equals("auto")) 
				    auto = cookies[i].getValue();
				if (MonCookie.getName().equals("login")) 
				    slogin = cookies[i].getValue();
				if (MonCookie.getName().equals("pass")) 
				    pass = cookies[i].getValue();
				
				
				req.getSession().setAttribute("lng", getLocale(req).getLanguage());
		
		 }

	  login.setAuto(auto.equals("true")||auto.equals("cas3"));
	  login.setRapel(memo.equals("true"));
	  req.setAttribute("login", login);

	  if(memo.equals("true"))
	  {
		  login.setLogin(slogin);
		  login.setMdp(pass);
		  req.setAttribute("login", login);
	  }
	  
	  
	  
	  if(auto.equals("cas3"))
	  {	  login.setLogin(slogin);
	      login.setMdp(pass);
	      req.setAttribute("login", login);}
	  else{
	  if(auto.equals("true"))
	  {	  LoginDao ldao = new LoginDao(cnx.getcnx());
		  boolean test = ldao.exist(new LoginForm(slogin,pass));
		
		  if(test)
			{frd = "ok";
			 Cookie Cookiememo = new Cookie("memo", memo);
			 Cookiememo.setMaxAge(3000000);
			 res.addCookie(Cookiememo);
			 
			 
			 String privilege=ldao.getprivilege(slogin);
			 req.getSession().setAttribute("connecte", privilege);
			}
	  }}
	  
	  

		}
		

		
		if (action.equals("connexion")) 
		{boolean test=false;
	   	LoginDao ldao = new LoginDao(cnx.getcnx());
		LoginForm lgf = (LoginForm) form ;
			if(lgf.getLogin()!=null&&lgf.getMdp()!=null)
		  test=	ldao.exist(new LoginForm(lgf.getLogin(),lgf.getMdp()));
	 	 
			
			
			if(test)
			{frd = "ok";
		    
			  
			  Cookie Cookieauto = new Cookie("auto", String.valueOf(lgf.isAuto()));
			  Cookie Cookiememo = new Cookie("memo", String.valueOf(lgf.isRapel()));
			  Cookieauto.setMaxAge(3000000);
			  Cookiememo.setMaxAge(3000000);
			  res.addCookie(Cookieauto);
			  res.addCookie(Cookiememo);
			  
				 String privilege=ldao.getprivilege(lgf.getLogin());
				 req.getSession().setAttribute("connecte", privilege);
				 
			 if(lgf.isRapel()||lgf.isAuto())
			 {
				  Cookie Cookielogin = new Cookie("login", lgf.getLogin());
				  Cookie Cookiepass = new Cookie("pass", lgf.getMdp());
				  Cookielogin.setMaxAge(3000000);
				  Cookiepass.setMaxAge(3000000);
				  res.addCookie(Cookielogin);
				  res.addCookie(Cookiepass);
			 }
		
			
			}
	 	  else {frd="pok";
		        req.setAttribute("login", new LoginForm("",""));
		        req.setAttribute("info", "");
	 	       }
			
			
			
		}
		
		
		
		
		
		if(action.equals("logout"))	
		{    
			 frd="pok";
			 req.getSession().removeAttribute("connecte");
			 LoginForm login=new LoginForm("","",false,false);
			 req.setAttribute("login", login);
	       	Cookie[] cookies = req.getCookies();
	           	if(cookies!=null)
			for(int i=0; i < cookies.length; i++) {
				Cookie MonCookie = cookies[i];
				if (MonCookie.getName().equals("memo")) 
			    memo = cookies[i].getValue();
				if (MonCookie.getName().equals("auto")) 
				    auto = cookies[i].getValue();
				if (MonCookie.getName().equals("login")) 
				    slogin = cookies[i].getValue();
				if (MonCookie.getName().equals("pass")) 
				    pass = cookies[i].getValue();
				
		 }

	 login.setAuto(auto.equals("true"));
	 login.setRapel(memo.equals("true"));
	  req.setAttribute("login", login);


	  if(memo.equals("true"))
	  {
		  login.setLogin(slogin);
		  login.setMdp(pass);
		  req.setAttribute("login", login);
	  }
	  
	  if(auto.equals("true"))
	  {	
		  login.setLogin(slogin);
		  login.setMdp(pass);
		  req.setAttribute("login", login);
		  Cookie Cookiememo = new Cookie("auto","cas3");
		  Cookiememo.setMaxAge(3000000); 
		  res.addCookie(Cookiememo);
			
	  }
		}
		
		
		
		if(action.equals("out"))
		{
			
			
		req.getSession().setAttribute("out", " ");
		
		
		 req.setAttribute("login", new LoginForm("","",false,false));
 	     frd="pok";
		
		Cookie[] cookies = req.getCookies();
		
              if(cookies!=null)
		for(int i=0; i < cookies.length; i++) {
			Cookie MonCookie = cookies[i];
			if (MonCookie.getName().equals("memo")) 
		    memo = cookies[i].getValue();
			if (MonCookie.getName().equals("auto")) 
			    auto = cookies[i].getValue();
			if (MonCookie.getName().equals("login")) 
			    slogin = cookies[i].getValue();
			if (MonCookie.getName().equals("pass")) 
			    pass = cookies[i].getValue();
			
			
			req.getSession().setAttribute("lng", getLocale(req).getLanguage());
	
	 }

 LoginForm check=new LoginForm("","",auto.equals("true")||auto.equals("cas3"),memo.equals("true"));
 req.setAttribute("login", check);

 if(memo.equals("true")||auto.equals("cas3"))
 {
	  check.setLogin(slogin);
	  check.setMdp(pass);
	  req.setAttribute("login", check);
 }
 
 
}
		
		
		
		
		}catch(Exception e ){System.out.println(e);}
		cnx.closecnx();
		return mapping.findForward(frd);
	}

	
}

