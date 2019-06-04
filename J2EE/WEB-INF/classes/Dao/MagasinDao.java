package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import Action.Utilitaire;
import Bean.MagasinForm;

public class MagasinDao {

	private Logger logger ;
	private Connection con ;
	
	public MagasinDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<MagasinForm> all ()
	   {
		 ArrayList<MagasinForm> l = new  ArrayList<MagasinForm>();
		   
			String sql = "SELECT * FROM magasin" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new MagasinForm(rs.getString("cdmag"),rs.getString("lbmag"),rs.getString("adr_mag"),rs.getString("tel_mag"),rs.getString("fax_mag"),rs.getString("nom_res"),rs.getString("obs_mag"),""));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<MagasinForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM magasin where  cdmag='"+id.replace("\"", "\"\"")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 

		 String sql1="delete from fam_mag where cdmag='"+id.replace("\"", "\"\"")+"'";
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql1);
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 public boolean add(MagasinForm frm)
	 {boolean res=true;
	 String sql1="";
	 String sql = "INSERT INTO magasin(cdmag, lbmag, adr_mag, tel_mag, fax_mag, nom_res, obs_mag)VALUES ('"+frm.getId_magasin().replace("'", "''")+"','"+frm.getLibelle_magasin().replace("'", "''")+"'" ;
	 sql=sql+" ,'"+frm.getAdresse_magasin().replace("'", "''")+"','"+frm.getTel_magasin().replace("'", "''")+"','"+frm.getFax_magasin().replace("'", "''")+"','"+frm.getNom_res().replace("'", "''")+"','"+frm.getRemarque_magasin().replace("'", "''")+"')";
	 
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	     String ch=frm.getListe_famille();
		 String tab[]=decouper(ch,'$');
		
	    
		 for(int i=0;i<tab.length;i++)
		 try{
			sql1 ="insert into fam_mag(cdmag,cdfamart) VALUES ('"+frm.getId_magasin()+"','"+tab[i]+"')";
			 Statement instruction1 = con.createStatement();
			 instruction1.executeUpdate(sql1); 
		 } catch(Exception e){System.out.println(e);}
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 logger.error(e+"requete =  "+sql1);
	 }
	 return res;
	 
	 }
	 
	 public MagasinForm recup (String id)
	   {
		 MagasinForm aux=null;
		   
			String sql = "SELECT * FROM magasin where cdmag='"+id.replace("\"", "\"\"")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					aux=new MagasinForm(rs.getString("cdmag"),rs.getString("lbmag"),rs.getString("adr_mag"),rs.getString("tel_mag"),rs.getString("fax_mag"),rs.getString("nom_res"),rs.getString("obs_mag"),Utilitaire.creListefamille(id));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(MagasinForm frm)
	 {boolean res=true;
	 
	 String sql = "update magasin set lbmag='"+frm.getLibelle_magasin().replace("'", "''")+"',cdmag='"+frm.getId_magasin().replace("'", "''")+"'" ;
	 sql=sql+", adr_mag='"+frm.getAdresse_magasin().replace("'", "''")+"', tel_mag='"+frm.getTel_magasin().replace("'", "''")+"', fax_mag='"+frm.getFax_magasin().replace("'", "''")+"', nom_res='"+frm.getNom_res().replace("'", "''")+"', obs_mag='"+frm.getRemarque_magasin().replace("'", "''")+"'";
	 sql=sql+"  where cdmag='"+frm.getId_magasin().replace("\"", "\"\"")+"'";
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql);
		 
		 String sql1="delete from fam_mag where cdmag='"+frm.getId_magasin().replace("\"", "\"\"")+"'";
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql1);
		 
		 String sql2="";
		 String ch=frm.getListe_famille();
		 String tab[]=decouper(ch,'$');
		
	    
		 for(int i=0;i<tab.length;i++)
		 {
			sql2 ="insert into fam_mag(cdmag,cdfamart) VALUES ('"+frm.getId_magasin()+"','"+tab[i]+"')";
			 Statement instruction2 = con.createStatement();
			 instruction2.executeUpdate(sql2); 
		 }
	 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 
	 
	 return res;
	 
	 }
	 
	 
	 public ArrayList<MagasinForm> inverse(ArrayList<MagasinForm> l)
	 {
		 ArrayList<MagasinForm> res=new ArrayList<MagasinForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
	 
	 public String[] decouper(String ch,char op)
	 {   int nb=0,j=0;
		 for(int i=0;i<ch.length();i++)
		 if(ch.charAt(i)==op)
			 nb=nb+1;
		 
		 String tab[]=new String [nb];
		 String temp="";
		 
		 for(int i=0;i<ch.length();i++)
		 {if(ch.charAt(i)!=op)
			 temp=temp+ch.charAt(i);
		 else{
			 if(!temp.equals(""))
			 {tab[j]=temp;
			 temp="";
			 j++;}
		     }
			 
		 }
		 return tab;
	 }
}
