package Dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Conn{


	private String url;
	private String user;
	private String pass;
	private String driver;
	private Properties props;
	private Logger logger ;
	private Connection connexion;
	
	public Conn() {
	
		 props = new Properties();
		 try {
			props.load(getClass().getResourceAsStream("/configpostgres.properties"));
		} catch (IOException e1) {}
		
		this.url =get("url");
		this.user =get("user");
		this.pass =get("pass");
		this.driver =get("driver");
		this.logger = Logger.getLogger("Dao");
	
		try{
			
			Class.forName(driver);
			
			this.connexion = DriverManager.getConnection(url , user, pass);
			this.connexion.setAutoCommit(true);
		}
		catch (Exception e) {
			this.logger.error(e);
		}
	}
	
	public Connection getcnx()
	{return this.connexion;}
	
	public void closecnx()
	{
		try {
			this.connexion.close();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		
	}
	
	
	private String get(String obj )
	{
      return props.getProperty(obj).trim();
	}
	
	

	
}
