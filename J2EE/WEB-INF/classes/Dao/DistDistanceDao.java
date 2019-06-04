package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.DistDistanceForm;

public class DistDistanceDao {

	private Logger logger ;
	private Connection con ;
	
	public DistDistanceDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<DistDistanceForm> all ()
	   {
		 ArrayList<DistDistanceForm> l = new  ArrayList<DistDistanceForm>();
		   
			String sql = "SELECT * FROM releve_machine where vld<>'r' order by num_relj,cdmac,dat_rlvj" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					 String id_distance=rs.getString("num_relj");
					 String id_vehicule=rs.getString("cdmac");
					 String libelle_vehicule="";
					 String pourcentage_consommation="";
					 String date=inverser(rs.getString("dat_rlvj").replace("-", "/"),"/");
					 String ancien_compteur=rs.getString("index_ant");
					 String actuel_compteur=rs.getString("index_jr");
					 String qté_combustible=rs.getString("carb");
					 String rapport_distance_compteur=rs.getString("cpt_idx");
					 String valide=rs.getString("vld");
					 
					 if(valide.equals("n"))
						 valide="en attente";
					 if(valide.equals("o"))
						 valide="validé";
					 if(valide.equals("r"))
						 valide="refusé";
		
					  
	l.add(new DistDistanceForm( id_distance,  id_vehicule,
			 libelle_vehicule,  pourcentage_consommation,date,
			 ancien_compteur,  actuel_compteur,  qté_combustible,
			 rapport_distance_compteur,  "",  valide));
	


	String sql1="";
	try{

	 sql1= " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbmac");
		  String lib1=rs1.getString("taux");
		     if(lib!=null)
		 l.get(l.size()-1).setLibelle_vehicule(lib);
		     if(lib1!=null)
		 l.get(l.size()-1).setPourcentage_consommation(lib1);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<DistDistanceForm>();
			
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 
	 public ArrayList<DistDistanceForm> all (String date_debut,String date_fin)
	   {
		 ArrayList<DistDistanceForm> l = new  ArrayList<DistDistanceForm>();
		   
			String sql = "SELECT * FROM releve_machine where  vld<>'r' and dat_rlvj between '"+inverser(date_debut.replace("/", "-"),"-")+"' and '"+inverser(date_fin.replace("/", "-"),"-")+"'  order by num_relj,cdmac,dat_rlvj " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					 String id_distance=rs.getString("num_relj");
					 String id_vehicule=rs.getString("cdmac");
					 String libelle_vehicule="";
					 String pourcentage_consommation="";
					 String date=inverser(rs.getString("dat_rlvj").replace("-", "/"),"/");
					 String ancien_compteur=rs.getString("index_ant");
					 String actuel_compteur=rs.getString("index_jr");
					 String qté_combustible=rs.getString("carb");
					 String rapport_distance_compteur=rs.getString("cpt_idx");
					 String valide=rs.getString("vld");
		
					 if(valide.equals("n"))
						 valide="en attente";
					 if(valide.equals("o"))
						 valide="validé";
					 if(valide.equals("r"))
						 valide="refusé";
					  
	l.add(new DistDistanceForm( id_distance,  id_vehicule,
			 libelle_vehicule,  pourcentage_consommation,date,
			 ancien_compteur,  actuel_compteur,  qté_combustible,
			 rapport_distance_compteur,  "",  valide));
	


	String sql1="";
	try{

	 sql1= " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbmac");
		  String lib1=rs1.getString("taux");
		     if(lib!=null)
		 l.get(l.size()-1).setLibelle_vehicule(lib);
		     if(lib1!=null)
		 l.get(l.size()-1).setPourcentage_consommation(lib1);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<DistDistanceForm>();
			
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
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
