package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.VilleForm;

public class VilleDao {

	private Logger logger ;
	private Connection con ;
	
	public VilleDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<VilleForm> all ()
	   {
		 ArrayList<VilleForm> l = new  ArrayList<VilleForm>();
		   
			String sql = "SELECT * FROM drville" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new VilleForm(rs.getString("cdville"),rs.getString("lbville"),rs.getString("cdpostal")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VilleForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM drville where  cdville='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(VilleForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into drville (cdville,lbville,cdpostal) values ('"+frm.getId_ville().replace("'", "''")+"','"+frm.getLibelle_ville().replace("'", "''")+"',"+frm.getCp()+")" ;
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
	 
	 public VilleForm recup (String id)
	   {
		 VilleForm aux=null;
		   
			String sql = "SELECT * FROM drville where cdville='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new VilleForm(rs.getString("cdville"),rs.getString("lbville"),rs.getString("cdpostal"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(VilleForm frm)
	 {boolean res=true;
	 
	 String sql = "update drville set lbville='"+frm.getLibelle_ville().replace("'", "''")+"' ,cdpostal="+frm.getCp()+" where cdville='"+frm.getId_ville().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<VilleForm> inverse(ArrayList<VilleForm> l)
	 {
		 ArrayList<VilleForm> res=new ArrayList<VilleForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
