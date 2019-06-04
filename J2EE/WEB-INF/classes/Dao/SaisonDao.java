package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.SaisonForm;

public class SaisonDao {

	private Logger logger ;
	private Connection con ;
	
	public SaisonDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<SaisonForm> all ()
	   {
		 ArrayList<SaisonForm> l = new  ArrayList<SaisonForm>();
		   
			String sql = "SELECT * FROM exercice" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{

					
l.add(new SaisonForm(String.valueOf(rs.getInt("cdexerc")),rs.getString("lbexerc"),inverser(rs.getDate("date_d").toString()).replace("-", "/"),inverser(rs.getDate("date_f").toString()).replace("-", "/"),rs.getString("obs_exerc"),rs.getString("clo").equals("o")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<SaisonForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM exercice where  cdexerc='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(SaisonForm frm)
	 {boolean res=true;
	 String clé="";
	 if(frm.getCloture())
		 clé="o";
	 else clé="n";

	 
	 String sql = "INSERT INTO exercice(cdexerc, lbexerc, date_d, date_f, obs_exerc, clo) values ('"+frm.getId_saison().replace("'", "''")+"','"+frm.getLibelle_saison().replace("'", "''")+"','"+inverser(frm.getDate_debut().replace("/", "-"))+"'" ;
	 sql=sql+",'"+inverser(frm.getDate_fin().replace("/", "-"))+"','"+frm.getRemarque_saison().replace("'", "''")+"','"+clé+"')";
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
	 
	 public SaisonForm recup (String id)
	   {
		 SaisonForm aux=null;
		   
			String sql = "SELECT * FROM exercice where cdexerc='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
		
					
	aux=new SaisonForm(String.valueOf(rs.getInt("cdexerc")),rs.getString("lbexerc"),inverser(rs.getDate("date_d").toString()).replace("-", "/"),inverser(rs.getDate("date_f").toString()).replace("-", "/"),rs.getString("obs_exerc"),rs.getString("clo").equals("o"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(SaisonForm frm)
	 {boolean res=true;
	 String sql ="";
	 String clé="";
	 if(frm.getCloture())
		 clé="o";
	 else clé="n";
	 

	
	sql="UPDATE exercice SET cdexerc='"+frm.getId_saison().replace("'", "''")+"', lbexerc='"+frm.getLibelle_saison().replace("'", "''")+"', date_d='"+inverser(frm.getDate_debut().replace("/", "-"))+"', date_f='"+inverser(frm.getDate_fin().replace("/", "-"))+"', obs_exerc='"+frm.getRemarque_saison().replace("'", "''")+"', ";
	sql=sql+" 	clo='"+clé+"'";
	sql=sql+"	where cdexerc='"+frm.getId_saison().replace("'", "''")+"'";

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
	 
	 
	 public ArrayList<SaisonForm> noncloture ()
	   {
		 ArrayList<SaisonForm> l = new  ArrayList<SaisonForm>();
		   
			String sql = "SELECT * FROM exercice where clo='n'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
l.add(new SaisonForm(String.valueOf(rs.getInt("cdexerc")),rs.getString("lbexerc"),inverser(rs.getDate("date_d").toString()).replace("-", "/"),inverser(rs.getDate("date_f").toString()).replace("-", "/"),rs.getString("obs_exerc"),rs.getString("clo").equals("o")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<SaisonForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 
	 
	 public boolean verfifer_validite_date(SaisonForm frm)
	 {
		 boolean res=true; 
	      
		 String sql="select count(*) from exercice "+
       " where '"+inverser(frm.getDate_debut().replace("/", "-"))+"' between date_d and date_f "+
       " or '"+inverser(frm.getDate_fin().replace("/", "-"))+"' between date_d and date_f";
		 
		 try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					if (rs.getInt(1) != 0 )
					{
						res = false ;
					}
				}
			}
			catch (Exception e) 
			{res=false;
			logger.error(e+"requete =  "+sql);
			}
		   
			
			

			if(res)
			{
				   
				 String sql1="select count(*) from exercice "+
		       " where  (date_d between '"+inverser(frm.getDate_debut().replace("/", "-"))+"'and '"+inverser(frm.getDate_fin().replace("/", "-"))+"' "+
		       " or date_f between '"+inverser(frm.getDate_debut().replace("/", "-"))+"'and '"+inverser(frm.getDate_fin().replace("/", "-"))+"' )";
		
				 
				 try{
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							if (rs1.getInt(1) != 0 )
							{
								res = false ;
							}
						}
					}
					catch (Exception e) 
					{res=false;
					logger.error(e+"requete =  "+sql1);
					}
					
				
			}
		 
		 return res;
	 }
	 
	 
	 
	 public boolean verfifer_validite_date_update(SaisonForm frm)
	 {
		 boolean res=true; 
	      
		 String sql="select count(*) from exercice "+
       " where  ('"+inverser(frm.getDate_debut().replace("/", "-"))+"' between date_d and date_f "+
       " or '"+inverser(frm.getDate_fin().replace("/", "-"))+"' between date_d and date_f )"+
       " and cdexerc <> '"+frm.getId_saison()+"'";
		 
		 try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					if (rs.getInt(1) != 0 )
					{
						res = false ;
					}
				}
			}
			catch (Exception e) 
			{res=false;
			logger.error(e+"requete =  "+sql);
			}
			
			
			if(res)
			{
				   
				 String sql1="select count(*) from exercice "+
		       " where  (date_d between '"+inverser(frm.getDate_debut().replace("/", "-"))+"'and '"+inverser(frm.getDate_fin().replace("/", "-"))+"' "+
		       " or date_f between '"+inverser(frm.getDate_debut().replace("/", "-"))+"'and '"+inverser(frm.getDate_fin().replace("/", "-"))+"' )"+
		       " and cdexerc <> '"+frm.getId_saison()+"'";
				 
				 try{
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							if (rs1.getInt(1) != 0 )
							{
								res = false ;
							}
						}
					}
					catch (Exception e) 
					{res=false;
					logger.error(e+"requete =  "+sql1);
					}
					
				
			}
		   
		 
		 return res;
	 }
	 
	 
	 public ArrayList<SaisonForm> inverse(ArrayList<SaisonForm> l)
	 {
		 ArrayList<SaisonForm> res=new ArrayList<SaisonForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
	 
	 public String inverser(String ch)
	 {
		 String res="";
		 if(!ch.equals("null"))
		 {
			 String tab[]=ch.split("-");
			 res=tab[2]+"-"+tab[1]+"-"+tab[0];
		 }
		 else{return ch;}
		 return res;
	 }
	 

}
