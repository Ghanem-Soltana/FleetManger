package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeEnergieForm;

public class TypeEnergieDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeEnergieDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeEnergieForm> all ()
	   {
		 ArrayList<TypeEnergieForm> l = new  ArrayList<TypeEnergieForm>();
		   
			String sql = "SELECT * FROM energi" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeEnergieForm(rs.getString("cdener"),rs.getString("lbener")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeEnergieForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM energi where  cdener='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeEnergieForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into energi (cdener,lbener) values ('"+frm.getId_energie().replace("'", "''")+"','"+frm.getLibelle_energie().replace("'", "''")+"')" ;
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
	 
	 public TypeEnergieForm recup (String id)
	   {
		 TypeEnergieForm aux=null;
		   
			String sql = "SELECT * FROM energi where cdener='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeEnergieForm(rs.getString("cdener"),rs.getString("lbener"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeEnergieForm frm)
	 {boolean res=true;
	 
	 String sql = "update energi set lbener='"+frm.getLibelle_energie().replace("'", "''")+"' where cdener='"+frm.getId_energie().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeEnergieForm> inverse(ArrayList<TypeEnergieForm> l)
	 {
		 ArrayList<TypeEnergieForm> res=new ArrayList<TypeEnergieForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
