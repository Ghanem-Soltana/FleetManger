package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeNatArticleForm;

public class TypeNatArticleDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeNatArticleDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeNatArticleForm> all ()
	   {
		 ArrayList<TypeNatArticleForm> l = new  ArrayList<TypeNatArticleForm>();
		   
			String sql = "SELECT * FROM typ_art" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeNatArticleForm(rs.getString("cdtypar"),rs.getString("lbtypar")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeNatArticleForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM typ_art where  cdtypar='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeNatArticleForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into typ_art (cdtypar,lbtypar) values ('"+frm.getId_natarticle().replace("'", "''")+"','"+frm.getLibelle_natarticle().replace("'", "''")+"')" ;
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
	 
	 public TypeNatArticleForm recup (String id)
	   {
		 TypeNatArticleForm aux=null;
		   
			String sql = "SELECT * FROM typ_art where cdtypar='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeNatArticleForm(rs.getString("cdtypar"),rs.getString("lbtypar"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeNatArticleForm frm)
	 {boolean res=true;
	 
	 String sql = "update typ_art set lbtypar='"+frm.getLibelle_natarticle().replace("'", "''")+"' where cdtypar='"+frm.getId_natarticle().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeNatArticleForm> inverse(ArrayList<TypeNatArticleForm> l)
	 {
		 ArrayList<TypeNatArticleForm> res=new ArrayList<TypeNatArticleForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
