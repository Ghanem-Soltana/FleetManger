package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.StationMaintForm;

public class StationMaintDao {

	private Logger logger ;
	private Connection con ;
	
	public StationMaintDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<StationMaintForm> all ()
	   {
		 ArrayList<StationMaintForm> l = new  ArrayList<StationMaintForm>();
		   
			String sql = "SELECT * FROM STAT_ENT" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new StationMaintForm(rs.getString("CODSTAT"),rs.getString("libstat")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<StationMaintForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM STAT_ENT where  CODSTAT='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(StationMaintForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into STAT_ENT (CODSTAT,libstat) values ('"+frm.getId_station().replace("'", "''")+"','"+frm.getLibelle_station().replace("'", "''")+"')" ;
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
	 
	 public StationMaintForm recup (String id)
	   {
		 StationMaintForm aux=null;
		   
			String sql = "SELECT * FROM STAT_ENT where CODSTAT='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new StationMaintForm(rs.getString("CODSTAT"),rs.getString("libstat"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(StationMaintForm frm)
	 {boolean res=true;
	 
	 String sql = "update STAT_ENT set libstat='"+frm.getLibelle_station().replace("'", "''")+"' where CODSTAT='"+frm.getId_station().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<StationMaintForm> inverse(ArrayList<StationMaintForm> l)
	 {
		 ArrayList<StationMaintForm> res=new ArrayList<StationMaintForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
