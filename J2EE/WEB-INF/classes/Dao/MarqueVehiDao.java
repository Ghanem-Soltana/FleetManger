package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.MarqueVehiForm;

public class MarqueVehiDao {

	private Logger logger ;
	private Connection con ;
	
	public MarqueVehiDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<MarqueVehiForm> all ()
	   {
		 ArrayList<MarqueVehiForm> l = new  ArrayList<MarqueVehiForm>();
		   
			String sql = "SELECT * FROM MARQUE" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
						
					  l.add(new MarqueVehiForm(rs.getString("cdmarque"),rs.getString("lbmarque")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<MarqueVehiForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM MARQUE where  cdmarque='"+id.replace("\"", "\"\"")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 public boolean add(MarqueVehiForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into MARQUE (cdmarque,lbmarque) values ('"+frm.getId_marque().replace("'", "''")+"','"+frm.getLibelle_marque().replace("'", "''")+"')" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 public MarqueVehiForm recup (String id)
	   {
		 MarqueVehiForm aux=null;
		   
			String sql = "SELECT * FROM MARQUE where cdmarque='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new MarqueVehiForm(rs.getString("cdmarque"),rs.getString("lbmarque"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(MarqueVehiForm frm)
	 {boolean res=true;
	 
	 String sql = "update MARQUE set lbmarque='"+frm.getLibelle_marque().replace("'", "''")+"' where cdmarque='"+frm.getId_marque().replace("'", "''")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 
	 public ArrayList<MarqueVehiForm> inverse(ArrayList<MarqueVehiForm> l)
	 {
		 ArrayList<MarqueVehiForm> res=new ArrayList<MarqueVehiForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
