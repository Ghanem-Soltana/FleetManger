package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.FonctionForm;

public class FonctionDao {

	private Logger logger ;
	private Connection con ;
	
	public FonctionDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<FonctionForm> all ()
	   {
		 ArrayList<FonctionForm> l = new  ArrayList<FonctionForm>();
		   
			String sql = "SELECT * FROM DRFONCT" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new FonctionForm(rs.getString("cdfonc"),rs.getString("lbfonc")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<FonctionForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM DRFONCT where  cdfonc='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(FonctionForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into DRFONCT (cdfonc,lbfonc) values ('"+frm.getId_fonction().replace("'", "''")+"','"+frm.getLibelle_fonction().replace("'", "''")+"')" ;
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
	 
	 public FonctionForm recup (String id)
	   {
		 FonctionForm aux=null;
		   
			String sql = "SELECT * FROM DRFONCT where cdfonc='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new FonctionForm(rs.getString("cdfonc"),rs.getString("lbfonc"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(FonctionForm frm)
	 {boolean res=true;
	 
	 String sql = "update DRFONCT set lbfonc='"+frm.getLibelle_fonction().replace("'", "''")+"' where cdfonc='"+frm.getId_fonction().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<FonctionForm> inverse(ArrayList<FonctionForm> l)
	 {
		 ArrayList<FonctionForm> res=new ArrayList<FonctionForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
