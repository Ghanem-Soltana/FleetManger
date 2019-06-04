package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeMatiereForm;

public class TypeMatiereDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeMatiereDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeMatiereForm> all ()
	   {
		 ArrayList<TypeMatiereForm> l = new  ArrayList<TypeMatiereForm>();
		   
			String sql = "SELECT * FROM matiere" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeMatiereForm(rs.getString("cdmat"),rs.getString("lbmat")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeMatiereForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM matiere where  cdmat='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeMatiereForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into matiere (cdmat,lbmat) values ('"+frm.getId_matiere().replace("'", "''")+"','"+frm.getLibelle_matiere().replace("'", "''")+"')" ;
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
	 
	 public TypeMatiereForm recup (String id)
	   {
		 TypeMatiereForm aux=null;
		   
			String sql = "SELECT * FROM matiere where cdmat='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeMatiereForm(rs.getString("cdmat"),rs.getString("lbmat"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeMatiereForm frm)
	 {boolean res=true;
	 
	 String sql = "update matiere set lbmat='"+frm.getLibelle_matiere().replace("'", "''")+"' where cdmat='"+frm.getId_matiere().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeMatiereForm> inverse(ArrayList<TypeMatiereForm> l)
	 {
		 ArrayList<TypeMatiereForm> res=new ArrayList<TypeMatiereForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
