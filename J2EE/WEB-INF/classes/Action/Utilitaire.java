package Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ArticleForm;
import Bean.FamArticlePrinciForm;
import Dao.Conn;
import Dao.FamArticlePrinciDao;
import Dao.TypeCarbArticleDao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;


public class Utilitaire  {
	
	
	
	public static boolean alerter1()
	{
		boolean res=false;
		
	    Conn cnx=new Conn();
	    Connection con = cnx.getcnx();
	    String sql="select * from alert_ordre_mission ";
	    	
	    	try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
			res=rs.getString("alerte").equals("true");		
					
					
				}
			}
			catch (Exception e) 
			{
			System.out.println(e+"requete =  "+sql);
			}
	    
	    
	    cnx.closecnx();
		
		
		
		return res;
	}
	
	
	

	public static boolean alerter2()
	{
		boolean res=false;
		
	    Conn cnx=new Conn();
	    Connection con = cnx.getcnx();
	    String sql="select * from alert_releve ";
	    	
	    	try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
			res=rs.getString("alerte").equals("true");		
					
					
				}
			}
			catch (Exception e) 
			{
			System.out.println(e+"requete =  "+sql);
			}
	    
	    
	    cnx.closecnx();
		
		
		
		return res;
	}
	
	

	public static boolean alerter3()
	{
		boolean res=false;
		
	    Conn cnx=new Conn();
	    Connection con = cnx.getcnx();
	    String sql="select * from alerte_entree_bon ";
	    	
	    	try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
			res=rs.getString("alerte").equals("true");		
					
					
				}
			}
			catch (Exception e) 
			{
			System.out.println(e+"requete =  "+sql);
			}
	    
	    
	    cnx.closecnx();
		
		
		
		return res;
	}
	
	public static boolean alerter()
	{
		boolean res=false;
		
	    Conn cnx=new Conn();
	    Connection con = cnx.getcnx();
	    String sql="select * from alert_laisser_passer ";
	    	
	    	try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
			res=rs.getString("alerte").equals("true");		
					
					
				}
			}
			catch (Exception e) 
			{
			System.out.println(e+"requete =  "+sql);
			}
	    
	    
	    cnx.closecnx();
		
		
		
		return res;
	}
	
	
	
	public static String connecte(HttpServletRequest request)
	{String res="ok";
     if(!present(request, "connecte"))
    	 {res="out";
    	 request.getSession().setAttribute("out"," " );
    	 
    	 }
	return res;
	}
	
	public static String creListefamille(String ch)
	{char split='$';String res="";
	  Conn cnx=new Conn();
	  FamArticlePrinciDao fdao =new FamArticlePrinciDao(cnx.getcnx());
	  ArrayList<FamArticlePrinciForm> liste=fdao.lienmagasin(ch);
	  
	  for(int i=0;i<liste.size();i++)
	  {
		  res=res+liste.get(i).getId_famille_princi()+split;
	  }

	return res;
	}
	
	public static String creListeCarbArticle(String ch)
	{char split='$';String res="";
	  Conn cnx=new Conn();
	  TypeCarbArticleDao fdao =new TypeCarbArticleDao(cnx.getcnx());
	  ArrayList<ArticleForm> liste=fdao.getArticles (ch);
	  
	  for(int i=0;i<liste.size();i++)
	  {
		  res=res+liste.get(i).getId_article()+split;
	  }

	return res;
	}

	@SuppressWarnings( { "deprecation" })
	public static String formatstring(String x) {
		String retour = "";

		String t[] = x.split("/");
		String ok = t[2] + "/" + t[1] + "/" + t[0];
		Date maDate = new Date(ok);
		Calendar c = Calendar.getInstance();
		c.setTime(maDate);
		retour += c.get(Calendar.DATE);
		retour += "/" + (c.get(Calendar.MONTH) + 1);
		retour += "/" + c.get(Calendar.YEAR);

		return retour;
	}

	@SuppressWarnings( { "deprecation" })
	public static int getmonth(String x) {
		String retour = "";
		int retour2 = 0;
		String t[] = x.split("/");
		String ok = t[2] + "/" + t[1] + "/" + t[0];
		Date maDate = new Date(ok);
		Calendar c = Calendar.getInstance();
		c.setTime(maDate);
		retour += (c.get(Calendar.MONTH) + 1);

		retour2 = Integer.parseInt(retour);

		return retour2;
	}

	
	public static int getyear(String x) {
		int retour2 = 0;
		String t[] = x.split("/");

		for(int i = 0 ; i < t.length ; i++)
			if(t[i].length()==4)
			{
				retour2 = Integer.parseInt(t[i]);
			}

		

		return retour2;
	}
	
	@SuppressWarnings( { "deprecation" })
	public static String formatadday(String x) {
		String retour = "";

		String t[] = x.split("/");
		String ok = t[2] + "/" + t[1] + "/" + t[0];
		Date maDate = new Date(ok);
		Calendar c = Calendar.getInstance();
		c.setTime(maDate);
		c.add(Calendar.DATE, 1);
		retour += c.get(Calendar.DATE);
		retour += "/" + (c.get(Calendar.MONTH) + 1);
		retour += "/" + c.get(Calendar.YEAR);

		return retour;
	}

	@SuppressWarnings( { "deprecation" })
	public static String formataddyear(String x) {
		String retour = "";

		String t[] = x.split("/");
		String ok = t[2] + "/" + t[1] + "/" + t[0];
		Date maDate = new Date(ok);
		Calendar c = Calendar.getInstance();
		c.setTime(maDate);
		c.add(Calendar.YEAR, 1);
		retour += c.get(Calendar.DATE);
		retour += "/" + (c.get(Calendar.MONTH) + 1);
		retour += "/" + c.get(Calendar.YEAR);

		return retour;
	}

	@SuppressWarnings("unchecked")
	public static void refrech_session(HttpServletRequest request) {
		HttpSession session = request.getSession();
		java.util.Enumeration en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			if (
					(!(name.equals("login")))
					&& 
					(!(name.startsWith("menu")))
			        &&
			        (!(name.equals("org.apache.struts.action.LOCALE"))
			        &&
			        (!(name.startsWith("fr.improve")))
			        )
			)
			
			{
				session.removeAttribute(name);
			}
		}

	}

	public static String formatweb(String x) {
		String ok = "";
		if (x != null) {
			
			String t[] = x.split("-");
			if (t[0].length() == 4) {
				ok = t[2] + "/" + t[1] + "/" + t[0];
			} else {
				ok = t[0] + "/" + t[1] + "/" + t[2];
			}
		}
		
		else
		 ok="";	
		 return ok;
	}

	public static String formatbd(String x) {
		String ok = "";
		
		if (x != null) {
			String t[] = x.split("/");
			if (t[0].length() == 4) 
			{
			if (!(t[0].equals("....")))
			ok = t[0] + "-" + t[1] + "-" + t[2];
			} 
			
			else 
			{
			if (!(t[2].equals("....")))
			ok = t[2] + "-" + t[1] + "-" + t[0];
			}
		}

		return ok;
	}
	
	public static void prepmenu(HttpServletRequest request,String list)
	{
		String l[]=list.split(";");
		HttpSession session = request.getSession();
		for(int i = 0;i<l.length;i++)
		{
			session.setAttribute("menu_"+l[i], "menu_"+l[i]);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void sessionformat(HttpServletRequest request) {
		HttpSession session = request.getSession();
		java.util.Enumeration en = session.getAttributeNames();
		while (en.hasMoreElements()) 
		{
			String name = (String) en.nextElement();
			session.removeAttribute(name);
		}
	}

	public static String bdstring(String var)
	{
		String rep = "";
		
		if(var.length() > 0)
			rep="Null";
		else
			rep="'"+var+"'";
		
		return rep ;
		
		
	}
	
	public static String bdstring2(String var)
	{
		String rep = "";
		if(var.length() > 0)
			rep="Null";
		else
			rep=var;
		
		return rep ;
		
		
	}
	public static String bdstring3(String var)
	{
		String rep = "";
		if(var.equals(""))
			rep="Null";
		else
			rep=var;
		
		return rep ;
		
		
	}

	@SuppressWarnings( "unchecked" )
	public static void doEtat(HttpServletRequest request,
			HttpServletResponse response, Map hParametre, String source,
			Connection c ,InputStream reportStream) throws IOException {
		ServletOutputStream servletOutputStream = response.getOutputStream();
			try {
				JasperRunManager.runReportToPdfStream(reportStream,servletOutputStream, hParametre, c);
			} catch (JRException e) {				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=etat.pdf");
     		        response.setContentLength(10000);
			servletOutputStream.flush();
			servletOutputStream.close();
			try {
				c.close();
			} catch (SQLException e) {
								e.printStackTrace();
			}
	}

	public static String getyear()
	{
		String ret = "";
			Date date1 = new Date();
			SimpleDateFormat  simpleFormat = new SimpleDateFormat("yyyy");
			ret=String.valueOf(simpleFormat.format(date1));	
		return ret ;
		
	}
	
	public static String moveblanc(String x)
	{
		String ret = "";
		if(x.contains("%20"))
		{
		String[] l  = x.split("%20");
		
			for(int i = 0 ; i < l.length ; i++)
			{
				ret += l[i]+" ";
			}
		}
		else
		{
			ret = x.trim();
		}
		
		ret.trim();
		return ret ;
		
	}
	
	@SuppressWarnings("unchecked")
	public static boolean present(HttpServletRequest request , String val) {
		boolean ret = false ;
		HttpSession session = request.getSession();
		java.util.Enumeration en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
            if (name.equals(val))
            ret = true ;
		}
     return ret ;
	}

	public static Date stringToDate(String sDate, String sFormat) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
        return sdf.parse(sDate);
}

		
		public static void doExportFichier(String url,HttpServletResponse res , String nomfich) throws Exception
		{
	        File f = new File(url);
	    	res.setContentType("application/txt");
	    	res.setHeader("Content-Disposition", "attachment; filename=\""+nomfich+".csv");
	    	InputStream in;
			in = new FileInputStream(f);
	    	javax.servlet.ServletOutputStream outs;
				outs = res.getOutputStream();
	    	try {
	    		int bit = in.read();
	    		while ((bit) >= 0) {
	    			outs.write(bit);
	    			bit = in.read();
	    		}
	    	} catch (Exception e) {
	    		e.printStackTrace(System.out);
	    	}
	    	in.close();	
	    	outs.flush();
	        outs.close();
		}	
		
		
		
		
		
		public static String addzeros(String temp)
		{
			
                   if(temp.contains("."))
            {
            while ((temp.length()-temp.indexOf("."))<4)
            	temp += "0";
            }
            else
            	temp += ".000";
                   
			return temp ;
			
		}
		
		@SuppressWarnings("unchecked")
		public static void afficherAttributes(HttpServletRequest request)
		{System.out.println(" agaga =");
			HttpSession session = request.getSession();
			java.util.Enumeration en = session.getAttributeNames();
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
			System.out.println("name= "+name+" contenu= "+session.getAttribute(name).toString());
			}
	      
		}
		
		
		
}
