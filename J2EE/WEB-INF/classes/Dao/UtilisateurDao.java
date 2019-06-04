package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.UtilisateurForm;

public class UtilisateurDao {

	private Logger logger ;
	private Connection con ;
	
	public UtilisateurDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	
	 public ArrayList<UtilisateurForm> all ()
	   {
		 ArrayList<UtilisateurForm> l = new  ArrayList<UtilisateurForm>();
		   
			String sql = "SELECT * FROM utilisateur" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
			
l.add(new UtilisateurForm(rs.getString("login"),rs.getString("nom"),rs.getString("prenom"),inverser(rs.getString("date_naissance").replace("-", "/"),"/"),rs.getString("privilege"),rs.getString("mot_passe"), ""));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<UtilisateurForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM utilisateur where  login='"+id.replace("\"", "\"\"").replace("'","''")+"'" ;
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
	 
	 public boolean add(UtilisateurForm frm)
	 {boolean res=true;
	 
	 String sql = "INSERT INTO utilisateur(\"login\", mot_passe, nom, prenom, privilege, date_naissance) values ('"+frm.getLogin_utilisateur().replace("'", "''")+"','"+frm.getMot_passe1()+"','"+frm.getNom_utilisateur().replace("'", "''")+"'";
	sql=sql+" , '"+frm.getPrenom_utilisateur().replace("'", "''")+"','"+frm.getPrivilege()+"','"+inverser(frm.getDate_naissance().replace("/", "-"),"-")+"'"; 
	 
	 sql=sql+")" ;
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
	 
	 public UtilisateurForm recup (String id)
	   {
		 UtilisateurForm aux=null;
		   
			String sql = "SELECT * FROM utilisateur where login='"+id.replace("'", "''")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
				aux=new UtilisateurForm(rs.getString("login"),rs.getString("nom"),rs.getString("prenom"),inverser(rs.getString("date_naissance").replace("-", "/"),"/"),rs.getString("privilege"),rs.getString("mot_passe"), "");	
					
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(UtilisateurForm frm)
	 {boolean res=true;
	 String sql="";
	 if(!frm.getMot_passe2().equals(""))
	  sql = "update utilisateur set mot_passe='"+frm.getMot_passe2().replace("'", "''")+"', nom='"+frm.getNom_utilisateur().replace("'", "''")+"' ,prenom='" +frm.getPrenom_utilisateur().replace("'", "''")+"',privilege='"+frm.getPrivilege()+"',date_naissance='"+inverser(frm.getDate_naissance().replace("/", "-"),"-")+"'"
	 		+" where login='"+frm.getLogin_utilisateur().replace("'", "''")+"'" ;
	 
	 else 
		  sql = "update utilisateur set  nom='"+frm.getNom_utilisateur().replace("'", "''")+"' ,prenom='" +frm.getPrenom_utilisateur().replace("'", "''")+"',privilege='"+frm.getPrivilege()+"',date_naissance='"+inverser(frm.getDate_naissance().replace("/", "-"),"-")+"'"
	 		+" where login='"+frm.getLogin_utilisateur().replace("'", "''")+"'" ;
	 
		 
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
	 
	 
	 public ArrayList<UtilisateurForm> inverse(ArrayList<UtilisateurForm> l)
	 {
		 ArrayList<UtilisateurForm> res=new ArrayList<UtilisateurForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
	 
	 public String inverser(String ch,String split)
	 {
		 String res="";

		 if(!ch.equals("null"))
		 {
			 String tab[]=ch.split(split);
			 res=tab[2]+split+tab[1]+split+tab[0];
		 }
		 else{return ch;}
		 return res;
	 }
}
