package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.AgentForm;

public class AgentDao {

	private Logger logger ;
	private Connection con ;
	
	public AgentDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<AgentForm> all ()
	   {
		   ArrayList<AgentForm> l = new  ArrayList<AgentForm>();
		   String sql2="" ,sql1="";
		String sql = " SELECT * FROM agent";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
	 				
 l.add(new AgentForm(String.valueOf(rs.getInt("decagen")),rs.getString("denagen"),rs.getString("cdfonc"),"",rs.getString("cdquali"),"",rs.getString("destatu").equals("o")));

sql1 = " SELECT * FROM drfonct where cdfonc='"+rs.getString("cdfonc")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
while(	rs1.next()){
	
		  String lib=rs1.getString("lbfonc");
	l.get(l.size()-1).setLibelle_fonction(lib);

}
	    sql2 = " SELECT * FROM drquali where cdquali='"+rs.getString("cdquali")+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
    while(rs2.next()){
			String lib1=rs2.getString("lbquali");
		  l.get(l.size()-1).setLibelle_qualification(lib1);
		
    }
	
				}		
			}
			catch (Exception e) 
			{l=new  ArrayList<AgentForm>();
			logger.error(e+"requete =  "+sql);
			logger.error(e+"requete =  "+sql1);
			logger.error(e+"requete =  "+sql2);
	
			}
		
			
		   
		   return inverse(l) ;
		   
	   }
	 
	 
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM agent where  decagen="+id.replace("\"", "\"\"");
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
	 
	 public boolean add(AgentForm frm)
	 {boolean res=true;String sql="",clé=frm.getId_fonction().replace("'", "''"),clé2=frm.getId_qualification().replace("'", "''");

	 
	clé="'"+clé+"'";
	clé2="'"+clé2+"'";
	
	

	 boolean stock=frm.getStatut();
	 char s='n';
	 if(stock)
	 s='o';
	 
	 sql = "INSERT INTO agent(decagen, denagen,cdfonc,cdquali,destatu) values ("+frm.getId_agent()+",'"+frm.getLibelle_agent().replace("'", "''")+"',"+clé+","+clé2+",'"+s+"')" ;
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
	 
	 
	 public AgentForm recup (String id)
	   {
		 AgentForm aux=new AgentForm();;
		   
			String sql = "SELECT * FROM agent where decagen="+id ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	aux=new AgentForm(String.valueOf(rs.getInt("decagen")),rs.getString("denagen"),rs.getString("cdfonc"),"",rs.getString("cdquali"),"",rs.getString("destatu").equals("o"));				
	   String sql1 = " SELECT * FROM drfonct where cdfonc='"+rs.getString("cdfonc")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("lbfonc");
			  if(lib!=null)
				 aux.setLibelle_fonction(lib);
		}				
					
				
				
		String sql2 = " SELECT * FROM drquali where cdquali='"+rs.getString("cdquali")+"'";
					Statement instruction2 = con.createStatement();
					ResultSet rs2 = instruction2.executeQuery(sql2);
					while(rs2.next())
					{
						  String lib=rs2.getString("lbquali");
						  if(lib!=null)
							 aux.setLibelle_qualification(lib);
					}				
								
							
				
			}}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(AgentForm frm)
	 {boolean res=true;String clé=frm.getLibelle_fonction().replace("'", "''");
	 String clé2=frm.getLibelle_qualification();
	 
	 
	clé="'"+clé+"'";
	clé2="'"+clé2+"'";
	 boolean stock=frm.getStatut();
	 char s='n';
	 if(stock)
	 s='o';
	 
	 
	 String sql=" UPDATE agent SET denagen='"+frm.getLibelle_agent().replace("'", "''")+"', cdfonc='"+frm.getId_fonction().replace("'", "''")+"', cdquali='"+frm.getId_qualification().replace("'", "''")+"', destatu='"+s+"'";
	 
	 sql=  sql+" WHERE decagen="+frm.getId_agent().replace("'", "''");

	 
	 
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
	 
	 
	 

	 
	 public ArrayList<AgentForm> operationelle ()
	   {
		   ArrayList<AgentForm> l = new  ArrayList<AgentForm>();
		   String sql2="" ,sql1="";
		String sql = " SELECT * FROM agent where destatu='o'";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
	 				
l.add(new AgentForm(String.valueOf(rs.getInt("decagen")),rs.getString("denagen"),rs.getString("cdfonc"),"",rs.getString("cdquali"),"",rs.getString("destatu").equals("o")));

sql1 = " SELECT * FROM drfonct where cdfonc='"+rs.getString("cdfonc")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
while(	rs1.next()){
	
		  String lib=rs1.getString("lbfonc");
	l.get(l.size()-1).setLibelle_fonction(lib);

}
	    sql2 = " SELECT * FROM drquali where cdquali='"+rs.getString("cdquali")+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
  while(rs2.next()){
			String lib1=rs2.getString("lbquali");
		  l.get(l.size()-1).setLibelle_qualification(lib1);
		
  }
	
				}		
			}
			catch (Exception e) 
			{l=new  ArrayList<AgentForm>();
			logger.error(e+"requete =  "+sql);
			logger.error(e+"requete =  "+sql1);
			logger.error(e+"requete =  "+sql2);
	
			}
		
			
		   
		   return inverse(l) ;
		   
	   }
	 
	 
	 public ArrayList<AgentForm> inverse(ArrayList<AgentForm> l)
	 {
		 ArrayList<AgentForm> res=new ArrayList<AgentForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
