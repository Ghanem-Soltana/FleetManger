package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import org.apache.log4j.Logger;
import Bean.FicheSocieteForm;


public class FicheSocieteDao {

	private Logger logger ;
	private Connection con ;
	
	public FicheSocieteDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public FicheSocieteForm all ()
	   {
		 FicheSocieteForm l = new   FicheSocieteForm();
		   
			String sql = "SELECT * FROM drsocie" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					 String id_societe="";
					  String libelle_societe="";
					  String sigle="";
					  String conge="";
					  String forme_juridique="";
					  String matricule_fiscale="";
					  String remarque="";
					  String num_rc="";
					  String adresse_1="";
					  String adresse_2="";
					  String id_ville="";
					  String annee_reporte="";
					  String nb_jour="";
					  String cp="";
					  String ville="";
					  String capitale="";
					  
					  
					  
					  id_societe=rs.getString("cdsocie");
					  libelle_societe=rs.getString("lbsocie");
					  sigle=rs.getString("sigle");
					  conge=rs.getString("conge");
					  forme_juridique=rs.getString("formjur");
					  matricule_fiscale=rs.getString("matfisc");
					  remarque=rs.getString("activite");
					  num_rc=rs.getString("num_rc");
					  adresse_1=rs.getString("adress1");
					  adresse_2=rs.getString("adress2");
					  id_ville=rs.getString("cdville");
					  annee_reporte=rs.getString("report");
					  nb_jour=rs.getString("nbrjouv");
					  capitale=rs.getString("capital");
					
					
l=new FicheSocieteForm (id_societe, libelle_societe,sigle,nb_jour,conge,forme_juridique,capitale,matricule_fiscale,remarque,num_rc,adresse_1,adresse_2,id_ville,annee_reporte )	;				
					
sql="SELECT * FROM drville where cdville='"+id_ville+"'";
			Statement instruction1 = con.createStatement();
			ResultSet rs1 = instruction1.executeQuery(sql);
			while(rs1.next())
				{
				cp=rs1.getString("cdpostal");
				ville=rs1.getString("lbville");
				l.setCp(cp);
				l.setLibelle_ville(ville);
				}
				
				}
			}
			catch (Exception e) 
			{
			logger.error(e+"requete =  "+sql);
			}
			
			
			
		   
		   return l ;
		   
	   }
	 

	 

	 

	 
	 public boolean update(FicheSocieteForm  frm)
	 {boolean res=true;
	 String clé=frm.getId_ville();
	 if(frm.getId_ville()==null||frm.getId_ville().equals("")||frm.getId_ville().length()>3)
		 clé="null";
	 else
		 clé="'"+clé+"'";
   

   String sql = "UPDATE drsocie ";
   sql=sql+"SET lbsocie='"+frm.getLibelle_societe().replace("'", "''")+"', sigle='"+frm.getSigle().replace("'", "''")+"', nbrjouv="+frm.getNb_jour()+", conge='"+frm.getConge().replace("'", "''")+"', formjur='"+frm.getForme_juridique().replace("'", "''")+"', ";
   sql=sql+"capital="+frm.getCapitale()+", matfisc='"+frm.getMatricule_fiscale().replace("'", "''")+"', num_rc='"+frm.getNum_rc().replace("'", "''")+"', report="+frm.getAnnee_reporte()+", observa_soc='"+frm.getRemarque().replace("'", "''")+"', ";
   sql=sql+"adress1='"+frm.getAdresse_1().replace("'", "''")+"', adress2='"+frm.getAdresse_2().replace("'", "''")+"', cdville="+clé+",activite='"+frm.getRemarque().replace("'", "''")+"'";
   sql=sql+"WHERE cdsocie='001'";
 
	 
	 
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
	 

		public int getnb()
		{   int res=-1;
			String sql = "SELECT max(idimage) FROM image" ;
			
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
			    rs.next();
				res=rs.getInt(1);

			}catch(Exception e ){res=0;	logger.error(e+"requete =  "+sql);}
		   return res;
		}
		
		public void updatenb()
		{
			int tem=getnb();
			String sql = "insert into image(idimage) values ("+(tem+1)+")" ;
			 try{
				 Statement instruction = con.createStatement();
				 instruction.executeUpdate(sql); 
			 }
			 catch(Exception e)
			 {	logger.error(e+"requete =  "+sql);}
		}

}
