package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.TiersForm;

public class TiersDao {

	private Logger logger ;
	private Connection con ;
	
	public TiersDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TiersForm> all ()
	   {
		 ArrayList<TiersForm> l = new  ArrayList<TiersForm>();
		   
			String sql = "SELECT * FROM tiers,type_tiers where tiers.cdtyptr=type_tiers.cdtyptr" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{String temp="";
					try{
				 temp=rs.getString("blocage");
					 }catch(Exception e1){}
					 
					 if(temp.equals("r")) temp=" ";
					 if(temp.equals("o")) temp="blocké";
					 if(temp.equals("n")) temp="non blocké";
					 
l.add(new TiersForm(rs.getString("cdtier"),rs.getString("lbtier"),rs.getString("mat_fistr"),rs.getString("tel_tier"),temp,rs.getString("adr_tr"),rs.getString("cdposte"),rs.getString("fax_tr"),rs.getString("obs_tier"),rs.getString("email_tr"),rs.getString("contact_tr"),rs.getString("cdtyptr"),rs.getString("lbtyptr")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TiersForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM tiers where  cdtier='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TiersForm frm)
	 {boolean res=true;String clé="";
	 if(frm.getBlockage_tiers().equals("o"))
		 clé ="o";
	 else { if(frm.getBlockage_tiers().equals("n"))
		    clé="n";
	          else  clé="r";
		 }
	 
	 String sql = "INSERT INTO tiers(cdtier,lbtier, adr_tr, cdposte, tel_tier, email_tr, contact_tr, mat_fistr, blocage, fax_tr, obs_tier,cdtyptr) values ('"+frm.getId_tiers().replace("'", "''")+"','"+frm.getLibelle_tiers().replace("'", "''")+"'," ;
	        sql=sql+"'"+frm.getAdresse_tiers().replace("'", "''")+"','"+frm.getCp_tiers().replace("'", "''")+"','"+frm.getTel_tiers().replace("'", "''")+"','"+frm.getMail_tiers().replace("'", "''")+"'";
	        sql=sql+",'"+frm.getContact_tiers().replace("'", "''")+"','"+frm.getMatricule_fiscale().replace("'", "''")+"','"+clé+"','"+frm.getFax_tiers().replace("'", "''")+"','"+frm.getRemarque_tiers().replace("'", "''")+"','"+frm.getId_type_tiers().replace("'", "''")+"')";
	 
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
	 
	 public TiersForm recup (String id)
	   {
		 TiersForm aux=null;
		   
			String sql = "SELECT * FROM tiers,type_tiers  where cdtier='"+id.replace("\"", "\"\"")+"' and tiers.cdtyptr=type_tiers.cdtyptr" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new TiersForm(rs.getString("cdtier"),rs.getString("lbtier"),rs.getString("mat_fistr"),rs.getString("tel_tier"),rs.getString("blocage"),rs.getString("adr_tr"),rs.getString("cdposte"),rs.getString("fax_tr"),rs.getString("obs_tier"),rs.getString("email_tr"),rs.getString("contact_tr"),rs.getString("cdtyptr"),rs.getString("lbtyptr"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TiersForm frm)
	 {boolean res=true;
	 String clé="";
	 if(frm.getBlockage_tiers().equals("o"))
		 clé ="o";
	 else { if(frm.getBlockage_tiers().equals("n"))
		    clé="n";
	          else  clé="r";
		 }
	 
	 String sql = "update tiers set lbtier='"+frm.getLibelle_tiers().replace("'", "''")+"', " ;
	 sql=sql+" adr_tr='"+frm.getAdresse_tiers().replace("'", "''")+"' , cdposte='"+frm.getCp_tiers().replace("'", "''")+"', tel_tier='"+frm.getTel_tiers().replace("'", "''")+"', email_tr='"+frm.getMail_tiers().replace("'", "''")+"', contact_tr='"+frm.getContact_tiers().replace("'", "''")+"', mat_fistr='"+frm.getMatricule_fiscale().replace("'", "''")+"', blocage='"+clé+"', fax_tr='"+frm.getFax_tiers().replace("'", "''")+"', obs_tier='"+frm.getRemarque_tiers().replace("'", "''")+"'";
     sql=sql+" ,cdtyptr='"+frm.getId_type_tiers().replace("'", "''")+"' where cdtier='"+frm.getId_tiers().replace("'", "''")+"'" ;
	
	 
	 
	 
	 
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
	 
	 
	 public ArrayList<TiersForm> inverse(ArrayList<TiersForm> l)
	 {
		 ArrayList<TiersForm> res=new ArrayList<TiersForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
