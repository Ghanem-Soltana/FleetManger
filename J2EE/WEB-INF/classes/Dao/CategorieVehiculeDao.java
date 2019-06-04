package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.CategorieVehiculeForm;

public class CategorieVehiculeDao {

	private Logger logger ;
	private Connection con ;
	
	public CategorieVehiculeDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<CategorieVehiculeForm> all ()
	   {
		 ArrayList<CategorieVehiculeForm> l = new  ArrayList<CategorieVehiculeForm>();
		   
			String sql = "SELECT * FROM categorie" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new CategorieVehiculeForm(rs.getString("cdcatvh"),rs.getString("lbcatvh"),rs.getString("nbre_plc")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<CategorieVehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM categorie where  cdcatvh='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(CategorieVehiculeForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into categorie (cdcatvh,lbcatvh,nbre_plc) values ('"+frm.getId_categovehi().replace("'", "''")+"','"+frm.getLibelle_categovehi().replace("'", "''")+"','"+frm.getNbr_place()+"')" ;
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
	 
	 public CategorieVehiculeForm recup (String id)
	   {
		 CategorieVehiculeForm aux=null;
		   
			String sql = "SELECT * FROM categorie where cdcatvh='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new CategorieVehiculeForm(rs.getString("cdcatvh"),rs.getString("lbcatvh"),rs.getString("nbre_plc"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(CategorieVehiculeForm frm)
	 {boolean res=true;
	 
	 String sql = "update categorie set lbcatvh='"+frm.getLibelle_categovehi().replace("'", "''")+"' where cdcatvh='"+frm.getId_categovehi().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<CategorieVehiculeForm> inverse(ArrayList<CategorieVehiculeForm> l)
	 {
		 ArrayList<CategorieVehiculeForm> res=new ArrayList<CategorieVehiculeForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
