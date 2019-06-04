package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TypeUniteForm;

public class TypeUniteDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeUniteDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeUniteForm> all ()
	   {
		 ArrayList<TypeUniteForm> l = new  ArrayList<TypeUniteForm>();
		   
			String sql = "SELECT * FROM unite" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeUniteForm(rs.getString("cdunite"),rs.getString("lbunite"),rs.getString("nbr_dec")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeUniteForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM unite where  cdunite='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeUniteForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into unite (cdunite,lbunite,nbr_dec) values ('"+frm.getId_unite().replace("'", "''")+"','"+frm.getLibelle_unite().replace("'", "''")+"','"+frm.getDecimale()+"')" ;
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
	 
	 public TypeUniteForm recup (String id)
	   {
		 TypeUniteForm aux=null;
		   
			String sql = "SELECT * FROM unite where cdunite='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeUniteForm(rs.getString("cdunite"),rs.getString("lbunite"),rs.getString("nbr_dec"));

					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeUniteForm frm)
	 {boolean res=true;
	 
	 String sql = "update unite  set lbunite='"+frm.getLibelle_unite().replace("'", "''") +"' ,nbr_dec="+frm.getDecimale()+"  where cdunite='"+frm.getId_unite().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeUniteForm> inverse(ArrayList<TypeUniteForm> l)
	 {
		 ArrayList<TypeUniteForm> res=new ArrayList<TypeUniteForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
