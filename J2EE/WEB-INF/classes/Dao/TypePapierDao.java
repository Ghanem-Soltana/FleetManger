package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypePapierForm;

public class TypePapierDao {

	private Logger logger ;
	private Connection con ;
	
	public TypePapierDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypePapierForm> all ()
	   {
		 ArrayList<TypePapierForm> l = new  ArrayList<TypePapierForm>();
		   
			String sql = "SELECT * FROM TYP_PCE" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypePapierForm(rs.getString("cdtyppc"),rs.getString("lbtyppc")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypePapierForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM TYP_PCE where  cdtyppc='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypePapierForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into TYP_PCE (cdtyppc,lbtyppc) values ('"+frm.getId_papier().replace("'", "''")+"','"+frm.getLibelle_papier().replace("'", "''")+"')" ;
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
	 
	 public TypePapierForm recup (String id)
	   {
		 TypePapierForm aux=null;
		   
			String sql = "SELECT * FROM TYP_PCE where cdtyppc='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypePapierForm(rs.getString("cdtyppc"),rs.getString("lbtyppc"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypePapierForm frm)
	 {boolean res=true;
	 
	 String sql = "update TYP_PCE set lbtyppc='"+frm.getLibelle_papier().replace("'", "''")+"' where cdtyppc='"+frm.getId_papier().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypePapierForm> inverse(ArrayList<TypePapierForm> l)
	 {
		 ArrayList<TypePapierForm> res=new ArrayList<TypePapierForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
