package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeTiersForm;

public class TypeTiersDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeTiersDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeTiersForm> all ()
	   {
		 ArrayList<TypeTiersForm> l = new  ArrayList<TypeTiersForm>();
		   
			String sql = "SELECT * FROM type_tiers" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeTiersForm(rs.getString("cdtyptr"),rs.getString("lbtyptr")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeTiersForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM type_tiers where  cdtyptr='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeTiersForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into type_tiers (cdtyptr,lbtyptr) values ('"+frm.getId_tiers().replace("'", "''")+"','"+frm.getLibelle_tiers().replace("'", "''")+"')" ;
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
	 
	 public TypeTiersForm recup (String id)
	   {
		 TypeTiersForm aux=null;
		   
			String sql = "SELECT * FROM type_tiers where cdtyptr='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeTiersForm(rs.getString("cdtyptr"),rs.getString("lbtyptr"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeTiersForm frm)
	 {boolean res=true;
	 
	 String sql = "update type_tiers set lbtyptr='"+frm.getLibelle_tiers().replace("'", "''")+"' where cdtyptr='"+frm.getId_tiers().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeTiersForm> inverse(ArrayList<TypeTiersForm> l)
	 {
		 ArrayList<TypeTiersForm> res=new ArrayList<TypeTiersForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
