package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeSpecialiteForm;

public class TypeSpecialiteDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeSpecialiteDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeSpecialiteForm> all ()
	   {
		 ArrayList<TypeSpecialiteForm> l = new  ArrayList<TypeSpecialiteForm>();
		   
			String sql = "SELECT * FROM SPECIAL" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeSpecialiteForm(rs.getString("cdspec"),rs.getString("lbcpec")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeSpecialiteForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM SPECIAL where  cdspec='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeSpecialiteForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into SPECIAL (cdspec,lbcpec) values ('"+frm.getId_specialite().replace("'", "''")+"','"+frm.getLibelle_specialite().replace("'", "''")+"')" ;
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
	 
	 public TypeSpecialiteForm recup (String id)
	   {
		 TypeSpecialiteForm aux=null;
		   
			String sql = "SELECT * FROM SPECIAL where cdspec='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeSpecialiteForm(rs.getString("cdspec"),rs.getString("lbcpec"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeSpecialiteForm frm)
	 {boolean res=true;
	 
	 String sql = "update SPECIAL set lbcpec='"+frm.getLibelle_specialite().replace("'", "''")+"' where cdspec='"+frm.getId_specialite().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeSpecialiteForm> inverse(ArrayList<TypeSpecialiteForm> l)
	 {
		 ArrayList<TypeSpecialiteForm> res=new ArrayList<TypeSpecialiteForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
