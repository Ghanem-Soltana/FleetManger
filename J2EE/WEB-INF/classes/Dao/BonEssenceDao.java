package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.BonEssenceForm;

public class BonEssenceDao {

	private Logger logger ;
	private Connection con ;
	
	public BonEssenceDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	
	 public ArrayList<BonEssenceForm> all ()
	   {
		 ArrayList<BonEssenceForm> l = new  ArrayList<BonEssenceForm>();
		   
			String sql = "SELECT * FROM typ_bon" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new BonEssenceForm(rs.getString("cdtypbon"),rs.getString("lbtypbon"),rs.getString("qte"),rs.getString("valeur")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<BonEssenceForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM typ_bon where  cdtypbon="+id ;
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
	 
	 public boolean add(BonEssenceForm frm)
	 {boolean res=true;

		
	 String sql = "insert into typ_bon (cdtypbon,lbtypbon,qte,valeur) values ("+frm.getId_bon()+",'"+frm.getLibelle_bon().replace("'", "''")+"',"+frm.getQte_bon()+","+frm.getValeur_bon()+")" ;
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
	 
	 public BonEssenceForm recup (String id)
	   {
		 BonEssenceForm aux=null;
		   
			String sql = "SELECT * FROM typ_bon where cdtypbon="+id ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new BonEssenceForm(rs.getString("cdtypbon"),rs.getString("lbtypbon"),rs.getString("qte"),rs.getString("valeur"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(BonEssenceForm frm)
	 {boolean res=true;
	 
	 String sql = "update typ_bon set lbtypbon='"+frm.getLibelle_bon().replace("'", "''")+"' ,qte="+frm.getQte_bon()+",valeur="+frm.getValeur_bon()+" where cdtypbon="+frm.getId_bon() ;
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
	 
	 
	 public ArrayList<BonEssenceForm> inverse(ArrayList<BonEssenceForm> l)
	 {
		 ArrayList<BonEssenceForm> res=new ArrayList<BonEssenceForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
