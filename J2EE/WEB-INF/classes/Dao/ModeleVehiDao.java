package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.ModeleVehiForm;

public class ModeleVehiDao {

	private Logger logger ;
	private Connection con ;
	
	public ModeleVehiDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<ModeleVehiForm> all ()
	   {
		 ArrayList<ModeleVehiForm> l = new  ArrayList<ModeleVehiForm>();
		   
			String sql = " SELECT * FROM mod_mac";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  				
 l.add(new ModeleVehiForm(rs.getString("cdmod"),rs.getString("lbmod"),rs.getString("qte_vidange"),rs.getString("taux_ap"),rs.getString("nb_jour"),rs.getString("releve"),rs.getString("cdener"),""));
 
   String sql1 = " SELECT * FROM energi where cdener='"+rs.getString("cdener")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbener");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_energie(lib);
	}
		
				}
				
				
		
			
				
			}
			catch (Exception e) 
			{l=new  ArrayList<ModeleVehiForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM  mod_mac where  cdmod='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(ModeleVehiForm frm)
	 {boolean res=true;String sql="",clé=frm.getLibelle_energie().replace("'", "''");
       
	 String qtevidange=frm.getQte_vidange();
	 String tappoint=frm.getTx_appoint();
	 String nb_jour=frm.getNb_jour();
	 String releve=frm.getReleve();
	 
	 if(qtevidange.equals(""))
      qtevidange="null";	 
	
	 
	 if(tappoint.equals(""))
		 tappoint="null";	 
	 
	 
	 if(nb_jour.equals(""))
		 nb_jour="null";	 
	 
	 
	 if(releve.equals(""))
		 releve="null";	 
	 
	 
	 if(frm.getLibelle_energie().equals("")||frm.getLibelle_energie()==null||frm.getLibelle_energie().equals("xxxxx"))
	 clé="null";
	 else clé="'"+clé+"'";

	 sql = "INSERT INTO mod_mac(cdmod, lbmod, qte_vidange, taux_ap, nb_jour, releve, cdener) values ('"+frm.getId_modelevehi().replace("'", "''")+"','"+frm.getLibelle_modelevehi().replace("'", "''")+"',"+qtevidange+","+tappoint+","+nb_jour+","+releve+","+clé+")" ;
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
	 
	 
	 public ModeleVehiForm recup (String id)
	   {
		 ModeleVehiForm aux=new ModeleVehiForm();;
		   
			String sql = "SELECT * FROM mod_mac where cdmod='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	aux=new ModeleVehiForm(rs.getString("cdmod"),rs.getString("lbmod"),rs.getString("qte_vidange"),rs.getString("taux_ap"),rs.getString("nb_jour"),rs.getString("releve"),rs.getString("cdener"),"");				
	   String sql1 = " SELECT * FROM energi where cdener='"+rs.getString("cdener")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("lbener");
			  if(lib!=null)
				 aux.setLibelle_energie(lib);
		}				
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(ModeleVehiForm frm)
	 {boolean res=true;String clé=frm.getId_energie().replace("'", "''");
	 if(frm.getId_energie().equals("")||frm.getId_energie()==null||frm.getId_energie().equals("xxxxx"))
	 clé="null";
	 else clé="'"+clé+"'";
	 
	 String qtevidange=frm.getQte_vidange();
	 String tappoint=frm.getTx_appoint();
	 String nb_jour=frm.getNb_jour();
	 String releve=frm.getReleve();
	 
	 if(qtevidange.equals(""))
      qtevidange="null";	 
	
	 
	 if(tappoint.equals(""))
		 tappoint="null";	 
	 
	 
	 if(nb_jour.equals(""))
		 nb_jour="null";	 
	 
	 
	 if(releve.equals(""))
		 releve="null";	 
	 	 
	 
	 String sql=" UPDATE mod_mac SET cdmod='"+frm.getId_modelevehi().replace("'", "''")+"', lbmod='"+frm.getLibelle_modelevehi().replace("'", "''")+"', qte_vidange="+qtevidange;
	 sql=  sql+", taux_ap="+tappoint+", nb_jour="+nb_jour+", releve="+releve+", cdener="+clé;
	 sql=  sql+" WHERE cdmod='"+frm.getId_modelevehi().replace("'", "''")+"'";

	 
	 
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
	 
	 
	 public ArrayList<ModeleVehiForm> inverse(ArrayList<ModeleVehiForm> l)
	 {
		 ArrayList<ModeleVehiForm> res=new ArrayList<ModeleVehiForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
