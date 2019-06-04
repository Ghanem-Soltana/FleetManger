package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.FamArticleSecForm;

public class FamArticleSecDao {

	private Logger logger ;
	private Connection con ;
	
	public FamArticleSecDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<FamArticleSecForm> all ()
	   {
		 ArrayList<FamArticleSecForm> l = new  ArrayList<FamArticleSecForm>();
		   
			String sql = " SELECT * FROM sfm_art";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new FamArticleSecForm(rs.getString("cdsfart"),rs.getString("lbsfart"),rs.getString("cdfamart"),""));
 
   String sql1 = " SELECT * FROM fam_art where cdfamart='"+rs.getString("cdfamart")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbfamart");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_famille_princi(lib);
	}
		
				}
				
				
		
			
				
			}
			catch (Exception e) 
			{l=new  ArrayList<FamArticleSecForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM  sfm_art where  cdsfart='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(FamArticleSecForm frm)
	 {boolean res=true;String sql="",clé=frm.getId_famille_princi().replace("'", "''");

	 sql = "INSERT INTO sfm_art(cdsfart,lbsfart,cdfamart) values ('"+frm.getId_famille_sec().replace("'", "''")+"','"+frm.getLibelle_famille_sec().replace("'", "''")+"','"+clé+"')" ;
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
	 
	 
	 public FamArticleSecForm recup (String id)
	   {
		 FamArticleSecForm aux=new FamArticleSecForm();;
		   
			String sql = "SELECT * FROM sfm_art where cdsfart='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	aux=new FamArticleSecForm(rs.getString("cdsfart"),rs.getString("lbsfart"),rs.getString("cdfamart"),"");				
	   String sql1 = " SELECT * FROM fam_art where cdfamart='"+rs.getString("cdfamart")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("lbfamart");
			  if(lib!=null)
				 aux.setLibelle_famille_princi(lib);
		}				
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(FamArticleSecForm frm)
	 {boolean res=true;String clé=frm.getId_famille_princi().replace("'", "''");

	 	 
	 
	 String sql=" UPDATE sfm_art SET cdsfart='"+frm.getId_famille_sec().replace("'", "''")+"', lbsfart='"+frm.getLibelle_famille_sec().replace("'", "''")+"', ";
	 sql=  sql+"  cdfamart='"+clé+"'";
	 sql=  sql+" WHERE cdsfart='"+frm.getId_famille_sec().replace("'", "''")+"'";

	 
	 
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
	 
	 public ArrayList<FamArticleSecForm> select (String id)
 {
		 ArrayList<FamArticleSecForm> l = new  ArrayList<FamArticleSecForm>();
		   
			String sql = " SELECT * FROM sfm_art where  cdfamart='"+id+"'";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new FamArticleSecForm(rs.getString("cdsfart"),rs.getString("lbsfart"),rs.getString("cdfamart"),""));
 
   String sql1 = " SELECT * FROM fam_art where cdfamart='"+rs.getString("cdfamart")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbfamart");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_famille_princi(lib);
	}
		
				}
				
			}
			catch (Exception e) 
			{l=new  ArrayList<FamArticleSecForm>();
			logger.error(e+"requete =  "+sql);
			}
		   if(!id.equals("xxxxxx"))
		   return inverse(l) ;
		   else return all();
		   
	   }
	 
	 public ArrayList<FamArticleSecForm> inverse(ArrayList<FamArticleSecForm> l)
	 {
		 ArrayList<FamArticleSecForm> res=new ArrayList<FamArticleSecForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
