package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.AgenceForm;

public class AgenceDao {

	private Logger logger ;
	private Connection con ;
	
	public AgenceDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<AgenceForm> all ()
	   {
		 ArrayList<AgenceForm> l = new  ArrayList<AgenceForm>();
		   
			String sql = " SELECT * FROM agence";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new AgenceForm(rs.getString("decagenc"),rs.getString("delagenc"),rs.getString("deccent"),""));
 
   String sql1 = " SELECT * FROM centre where deccent='"+rs.getString("deccent")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("delcent");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_centre(lib);
	}
		
				}
				
				
		
			
				
			}
			catch (Exception e) 
			{l=new  ArrayList<AgenceForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM  agence where  decagenc='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(AgenceForm frm)
	 {boolean res=true;String sql="",clé=frm.getId_centre().replace("'", "''");

	 sql = "INSERT INTO agence(decagenc,delagenc,deccent) values ('"+frm.getId_agence().replace("'", "''")+"','"+frm.getLibelle_agence().replace("'", "''")+"','"+clé+"')" ;
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
	 
	 
	 public AgenceForm recup (String id)
	   {
		 AgenceForm aux=new AgenceForm();;
		   
			String sql = "SELECT * FROM agence where decagenc='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	aux=new AgenceForm(rs.getString("decagenc"),rs.getString("delagenc"),rs.getString("deccent"),"");				
	   String sql1 = " SELECT * FROM centre where deccent='"+rs.getString("deccent")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("delcent");
			  if(lib!=null)
				 aux.setLibelle_centre(lib);
		}				
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(AgenceForm frm)
	 {boolean res=true;String clé=frm.getId_centre().replace("'", "''");

	 	 
	 
	 String sql=" UPDATE agence SET decagenc='"+frm.getId_agence().replace("'", "''")+"', delagenc='"+frm.getLibelle_agence().replace("'", "''")+"', ";
	 sql=  sql+"  deccent='"+clé+"'";
	 sql=  sql+" WHERE decagenc='"+frm.getId_agence().replace("'", "''")+"'";

	 
	 
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
	 
	 public ArrayList<AgenceForm> select (String id)
 {
		 ArrayList<AgenceForm> l = new  ArrayList<AgenceForm>();
		   
			String sql = " SELECT * FROM agence where  deccent='"+id+"'";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new AgenceForm(rs.getString("decagenc"),rs.getString("delagenc"),rs.getString("deccent"),""));
 
   String sql1 = " SELECT * FROM centre where deccent='"+rs.getString("deccent")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("delcent");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_centre(lib);
	}
		
				}
				
			}
			catch (Exception e) 
			{l=new  ArrayList<AgenceForm>();
			logger.error(e+"requete =  "+sql);
			}
		   if(!id.equals("xxxxxx"))
		   return inverse(l) ;
		   else return all();
		   
	   }
	 
	 public ArrayList<AgenceForm> inverse(ArrayList<AgenceForm> l)
	 {
		 ArrayList<AgenceForm> res=new ArrayList<AgenceForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
