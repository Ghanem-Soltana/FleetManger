package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeMaintForm;

public class TypeMaintDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeMaintDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	
	 public ArrayList<TypeMaintForm> all ()
	   {
		 ArrayList<TypeMaintForm> l = new  ArrayList<TypeMaintForm>();
		   
			String sql = "SELECT * FROM TYP_MNT" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeMaintForm(rs.getString("CDTYPMNT"),rs.getString("LBTYPMNT")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeMaintForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM TYP_MNT where  cdtypmnt='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeMaintForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into TYP_MNT (cdtypmnt,lbtypmnt) values ('"+frm.getId_maint().replace("'", "''")+"','"+frm.getLibelle_maint().replace("'", "''")+"')" ;
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
	 
	 public TypeMaintForm recup (String id)
	   {
		 TypeMaintForm aux=null;
		   
			String sql = "SELECT * FROM TYP_MNT where cdtypmnt='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeMaintForm(rs.getString("cdtypmnt"),rs.getString("lbtypmnt"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeMaintForm frm)
	 {boolean res=true;
	 
	 String sql = "update TYP_MNT set lbtypmnt='"+frm.getLibelle_maint().replace("'", "''")+"' where cdtypmnt='"+frm.getId_maint().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeMaintForm> inverse(ArrayList<TypeMaintForm> l)
	 {
		 ArrayList<TypeMaintForm> res=new ArrayList<TypeMaintForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
