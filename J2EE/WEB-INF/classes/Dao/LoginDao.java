package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import Bean.LoginForm;


public class LoginDao {
	Logger logger ;
	Connection con ;
	
	public LoginDao(Connection connexion) {
		this.con = connexion;
		this.logger = Logger.getLogger("Dao");
	}
	
   public boolean exist (LoginForm l)
   {
	   boolean ex = false ;
	   
		String sql = "SELECT count(*) FROM utilisateur where login = '"+l.getLogin()+"' and mot_passe = '"+l.getMdp()+"' " ;
		try{
			Statement instruction = con.createStatement();
			ResultSet rs = instruction.executeQuery(sql);
			while(rs.next())
			{
				if (rs.getInt(1) > 0 )
				{
					ex = true ;
				}
			}
		}
		catch (Exception e) 
		{
		logger.error(e+"requete =  "+sql);
		}
	   
	   return ex ;
	   
   }
   
   public String getprivilege(String login)
   {String res="";
	String sql = "SELECT * FROM utilisateur where login='"+login.replace("'", "''")+"'" ;
   
	try{
		Statement instruction = con.createStatement();
		ResultSet rs = instruction.executeQuery(sql);
		while(rs.next())
		{
			res=rs.getString("privilege");
		}	
		}
		catch (Exception e) 
		{logger.error(e+"requete =  "+sql);}
		
   
	   return res;
   }
		
}
