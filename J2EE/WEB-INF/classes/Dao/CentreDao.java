package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.CentreForm;

public class CentreDao {

	private Logger logger ;
	private Connection con ;
	
	public CentreDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<CentreForm> all ()
	   {
		 ArrayList<CentreForm> l = new  ArrayList<CentreForm>();
		   
			String sql = "SELECT * FROM centre" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new CentreForm(rs.getString("deccent"),rs.getString("delcent"),rs.getString("deobser")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<CentreForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM centre where  deccent='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(CentreForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into centre (deccent,delcent,deobser) values ('"+frm.getId_centre().replace("'", "''")+"','"+frm.getLibelle_centre().replace("'", "''")+"','"+frm.getRemarque_centre().replace("'", "''")+"')" ;
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
	 
	 public CentreForm recup (String id)
	   {
		 CentreForm aux=null;
		   
			String sql = "SELECT * FROM centre where deccent='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new CentreForm(rs.getString("deccent"),rs.getString("delcent"),rs.getString("deobser"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(CentreForm frm)
	 {boolean res=true;
	 
	 String sql = "update centre set delcent='"+frm.getLibelle_centre().replace("'", "''")+"',deobser='"+frm.getRemarque_centre().replace("'", "''")+"' where deccent='"+frm.getId_centre().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<CentreForm> inverse(ArrayList<CentreForm> l)
	 {
		 ArrayList<CentreForm> res=new ArrayList<CentreForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
