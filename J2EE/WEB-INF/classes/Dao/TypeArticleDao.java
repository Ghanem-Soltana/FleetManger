package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeArticleForm;

public class TypeArticleDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeArticleDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeArticleForm> all ()
	   {
		 ArrayList<TypeArticleForm> l = new  ArrayList<TypeArticleForm>();
		   
			String sql = "SELECT * FROM nat_art" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeArticleForm(rs.getString("cdnatar"),rs.getString("lbnatar")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeArticleForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM nat_art where  cdnatar='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeArticleForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into nat_art (cdnatar,lbnatar) values ('"+frm.getId_article().replace("'", "''")+"','"+frm.getLibelle_article().replace("'", "''")+"')" ;
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
	 
	 public TypeArticleForm recup (String id)
	   {
		 TypeArticleForm aux=null;
		   
			String sql = "SELECT * FROM nat_art where cdnatar='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeArticleForm(rs.getString("cdnatar"),rs.getString("lbnatar"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeArticleForm frm)
	 {boolean res=true;
	 
	 String sql = "update nat_art set lbnatar='"+frm.getLibelle_article().replace("'", "''")+"' where cdnatar='"+frm.getId_article().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeArticleForm> inverse(ArrayList<TypeArticleForm> l)
	 {
		 ArrayList<TypeArticleForm> res=new ArrayList<TypeArticleForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
