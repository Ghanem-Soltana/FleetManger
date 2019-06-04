package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.ServiceForm;

public class ServiceDao {

	private Logger logger ;
	private Connection con ;
	
	public ServiceDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<ServiceForm> all ()
	   {
		 ArrayList<ServiceForm> l = new  ArrayList<ServiceForm>();
		   
			String sql = " SELECT * FROM service";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new ServiceForm(rs.getString("cdserv"),rs.getString("lbserv"),String.valueOf(rs.getInt("deccent")),"",String.valueOf(rs.getInt("decagenc")),""));
 
   String sql1 = " SELECT * FROM agence,centre where agence.deccent=centre.deccent and  agence.decagenc='"+rs.getInt("decagenc")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("delcent");
		  String lib2=rs1.getString("delagenc");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_centre(lib);
		  if(lib2!=null)
		  l.get(l.size()-1).setLibelle_agence(lib2);
	}
		
				}
				
				
			}
			catch (Exception e) 
			{l=new  ArrayList<ServiceForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM  service where  cdserv='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(ServiceForm frm)
	 {boolean res=true;String sql="",clé=frm.getId_centre().replace("'", "''"),clé2=frm.getId_agence().replace("'", "''");
	

	 sql = "INSERT INTO service(cdserv, lbserv, deccent, decagenc) values ('"+frm.getId_service().replace("'", "''")+"','"+frm.getLibelle_service().replace("'", "''")+"','"+clé+"',"+clé2+")" ;
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
	 
	 
	 public ServiceForm recup (String id)
	   {
		 ServiceForm aux=new ServiceForm();;
		   
			String sql = "SELECT * FROM service where cdserv='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	aux=new ServiceForm(rs.getString("cdserv"),rs.getString("lbserv"),String.valueOf(rs.getInt("deccent")),"",String.valueOf(rs.getInt("decagenc")),"");		
	   String sql1 = " SELECT * FROM agence,centre where agence.deccent=centre.deccent and  agence.decagenc="+String.valueOf(rs.getInt("decagenc"));
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("delcent");
			  String lib2=rs1.getString("delagenc");
			  if(lib!=null)
				  aux.setLibelle_centre(lib);
			  if(lib2!=null)
			  aux.setLibelle_agence(lib2);
		}				
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(ServiceForm frm)
	 {boolean res=true;String clé=frm.getId_centre(),clé2=frm.getId_agence();


	 String sql=" UPDATE service SET cdserv='"+frm.getId_service().replace("'", "''")+"', lbserv='"+frm.getLibelle_service().replace("'", "''")+"', ";
	 sql=  sql+"  deccent="+clé+",decagenc="+clé2;
	 sql=  sql+" WHERE cdserv='"+frm.getId_service().replace("'", "''")+"'";

	 
	 
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
	 
	 public ArrayList<ServiceForm> select (String id)
 {
		 ArrayList<ServiceForm> l = new  ArrayList<ServiceForm>();
		   
			String sql = " SELECT * FROM service where  decagenc='"+id+"'";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new ServiceForm(rs.getString("cdserv"),rs.getString("lbserv"),rs.getString("deccent"),"",id,""));
 
 String sql1 = " SELECT * FROM agence,centre where agence.deccent=centre.deccent and  agence.decagenc='"+rs.getString("decagenc")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("delcent");
		  String lib2=rs1.getString("delagenc");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_centre(lib);
		  if(lib2!=null)
			  l.get(l.size()-1).setLibelle_centre(lib2);
	}				
	
		
				}
				
			}
			catch (Exception e) 
			{l=new  ArrayList<ServiceForm>();
			logger.error(e+"requete =  "+sql);
			}
		   if(!id.equals("xxxxxx"))
		   return inverse(l) ;
		   else return all();
		   
	   }
	 
	 public ArrayList<ServiceForm> select(ServiceForm vider)
	 {
		 ArrayList<ServiceForm> res=new ArrayList<ServiceForm>();
		 String id_centre=vider.getId_centre(),id_agence=vider.getId_agence(),and="";
		 
		 if(id_centre.equals("xxxxxx")&&id_agence.equals("xxxxxx"))
			 return all();
		 else {
			 
			 if(!id_centre.equals("xxxxxx")&&!id_agence.equals("xxxxxx"))
				 and=" and ";
		 
			 if(id_centre.equals("xxxxxx"))
				 id_centre="";
			 else id_centre=" deccent="+id_centre;
			 
			 if(id_agence.equals("xxxxxx"))
				 id_agence="";
			 else id_agence=" decagenc="+id_agence;
			 
			
			String sql = " SELECT * FROM service where "+id_centre+and+id_agence ;
	

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 res.add(new ServiceForm(rs.getString("cdserv"),rs.getString("lbserv"),String.valueOf(rs.getInt("deccent")),"",String.valueOf(rs.getInt("decagenc")),""));
 
   String sql1 = " SELECT * FROM agence,centre where agence.deccent=centre.deccent and  agence.decagenc='"+rs.getInt("decagenc")+"'";
	
   Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("delcent");
		  String lib2=rs1.getString("delagenc");
		  if(lib!=null)
			  res.get(res.size()-1).setLibelle_centre(lib);
		  if(lib2!=null)
		  res.get(res.size()-1).setLibelle_agence(lib2);
	}
		
				}
				
				
			}
			catch (Exception e) 
			{res=new  ArrayList<ServiceForm>();
			logger.error(e+"requete =  "+sql);
			}
	
		 
	
		 
		 
		 return inverse(res);
		 }
	 }
	 
	 
	 
	 public ArrayList<ServiceForm> select (String id_centre,String id_agence)
	 {
			 ArrayList<ServiceForm> l = new  ArrayList<ServiceForm>();
			   
				String sql = " SELECT * FROM service where  deccent='"+id_centre+"' and decagenc='"+id_agence+"'";
			   

				try{
					Statement instruction = con.createStatement();
					ResultSet rs = instruction.executeQuery(sql);
					while(rs.next())
					{
						  				
	 l.add(new ServiceForm(rs.getString("cdserv"),rs.getString("lbserv"),id_centre,"",id_agence,""));
	 
	 String sql1 = " SELECT * FROM agence,centre where agence.deccent=centre.deccent and  agence.decagenc='"+id_agence+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("delcent");
			  String lib2=rs1.getString("delagenc");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_centre(lib);
			  if(lib2!=null)
				  l.get(l.size()-1).setLibelle_centre(lib2);
		}				
		
			
					}
					
				}
				catch (Exception e) 
				{l=new  ArrayList<ServiceForm>();
				logger.error(e+"requete =  "+sql);
				}

			   return l ;

			   
		   }
	 
	 public ArrayList<ServiceForm> inverse(ArrayList<ServiceForm> l)
	 {
		 ArrayList<ServiceForm> res=new ArrayList<ServiceForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
