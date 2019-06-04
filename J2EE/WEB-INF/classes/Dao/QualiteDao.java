package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.QualiteForm;

public class QualiteDao {

	private Logger logger ;
	private Connection con ;
	
	public QualiteDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<QualiteForm> all ()
	   {
		 ArrayList<QualiteForm> l = new  ArrayList<QualiteForm>();
		   
			String sql = "SELECT * FROM drquali" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
						
					  l.add(new QualiteForm(rs.getString("cdquali"),rs.getString("lbquali")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<QualiteForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM drquali where  cdquali='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(QualiteForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into drquali (cdquali,lbquali) values ('"+frm.getId_qualite().replace("'", "''")+"','"+frm.getLibelle_qualite().replace("'", "''")+"')" ;
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
	 
	 public QualiteForm recup (String id)
	   {
		 QualiteForm aux=null;
		   
			String sql = "SELECT * FROM drquali where cdquali='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new QualiteForm(rs.getString("cdquali"),rs.getString("lbquali"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(QualiteForm frm)
	 {boolean res=true;
	 
	 String sql = "update drquali set lbquali='"+frm.getLibelle_qualite().replace("'", "''")+"' where cdquali='"+frm.getId_qualite().replace("'", "''")+"'" ;
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
	 
	 
	 public ArrayList<QualiteForm> inverse(ArrayList<QualiteForm> l)
	 {
		 ArrayList<QualiteForm> res=new ArrayList<QualiteForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
