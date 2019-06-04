package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Action.Utilitaire;
import org.apache.log4j.Logger;
import Bean.TypeCarburantForm;

public class TypeCarburantDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeCarburantDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeCarburantForm> all ()
	   {
		 ArrayList<TypeCarburantForm> l = new  ArrayList<TypeCarburantForm>();
		   
			String sql = "SELECT * FROM typ_carb" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeCarburantForm(rs.getString("CDTYPCARB"),rs.getString("LBTYPCARB"),"","",Utilitaire.creListeCarbArticle(rs.getString("CDTYPCARB"))));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeCarburantForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM TYP_CARB where  cdtypcarb='"+id.replace("\"", "\"\"")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 

		 String sql1="delete from art_typ_carb where cdtypcarb='"+id.replace("\"", "\"\"")+"'";
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql1);
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 public boolean add(TypeCarburantForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into TYP_CARB (cdtypcarb,lbtypcarb) values ('"+frm.getid_carburant().replace("'", "''")+"','"+frm.getlibelle_carburant().replace("'", "''")+"')" ;
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
	 
	 public TypeCarburantForm recup (String id)
	   {
		 TypeCarburantForm aux=null;
		   
			String sql = "SELECT * FROM TYP_CARB where cdtypcarb='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TypeCarburantForm(rs.getString("CDTYPCARB"),rs.getString("LBTYPCARB"),"","",Utilitaire.creListeCarbArticle(rs.getString("CDTYPCARB")));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeCarburantForm frm)
	 {boolean res=true;
	 
	 String sql = "update TYP_CARB set lbtypcarb='"+frm.getlibelle_carburant().replace("'", "''")+"' where cdtypcarb='"+frm.getid_carburant().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<TypeCarburantForm> inverse(ArrayList<TypeCarburantForm> l)
	 {
		 ArrayList<TypeCarburantForm> res=new ArrayList<TypeCarburantForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
	 
	
}
