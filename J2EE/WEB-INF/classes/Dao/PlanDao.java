package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import Bean.PlanForm;

public class PlanDao {

	private Logger logger ;
	private Connection con ;
	
	public PlanDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<PlanForm> all ()
	   {
		 ArrayList<PlanForm> l = new  ArrayList<PlanForm>();
		   
			String sql = "SELECT * FROM plan order by cdplan" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new PlanForm(rs.getString("cdplan"),rs.getString("lbplan")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<PlanForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 public boolean delete(int id)
	 {boolean res=true;
	 
	 String sql = "delete FROM plan where  cdplan="+id ;
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
	 
	 public boolean add(PlanForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into plan (cdplan,lbplan) values ("+frm.getId_plan()+",'"+frm.getLibelle_plan().replace("'", "''")+"')" ;
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
	 
	 public PlanForm recup (String id)
	   {
		 PlanForm aux=null;
		   
			String sql = "SELECT * FROM plan where cdplan='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new PlanForm(rs.getString("cdplan"),rs.getString("lbplan"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(PlanForm frm)
	 {boolean res=true;
	 
	 String sql = "update plan set lbplan='"+frm.getLibelle_plan().replace("'", "''")+"' where cdplan="+frm.getId_plan();
	 
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
	 
	 
	 public ArrayList<PlanForm> inverse(ArrayList<PlanForm> l)
	 {
		 ArrayList<PlanForm> res=new ArrayList<PlanForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
