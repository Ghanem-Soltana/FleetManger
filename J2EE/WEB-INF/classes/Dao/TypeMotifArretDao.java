package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeMotifArretForm;

public class TypeMotifArretDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeMotifArretDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeMotifArretForm> all ()
	   {
		 ArrayList<TypeMotifArretForm> l = new  ArrayList<TypeMotifArretForm>();
		   
			String sql = "SELECT * FROM motif_depot" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeMotifArretForm(rs.getString("cddepot"),rs.getString("lbdepot")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeMotifArretForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM motif_depot where  cddepot='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeMotifArretForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into motif_depot (cddepot,lbdepot) values ('"+frm.getId_motif().replace("'", "''")+"','"+frm.getLibelle_motif().replace("'", "''")+"')" ;
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
	 
	 public TypeMotifArretForm recup (String id)
	   {
		 TypeMotifArretForm aux=null;
		   
			String sql = "SELECT * FROM motif_depot where cddepot='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeMotifArretForm(rs.getString("cddepot"),rs.getString("lbdepot"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeMotifArretForm frm)
	 {boolean res=true;
	 
	 String sql = "update motif_depot set lbdepot='"+frm.getLibelle_motif().replace("'", "''")+"' where cddepot='"+frm.getId_motif().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeMotifArretForm> inverse(ArrayList<TypeMotifArretForm> l)
	 {
		 ArrayList<TypeMotifArretForm> res=new ArrayList<TypeMotifArretForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
