package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.DistDistanceForm;

public class DistReleveDao {

	private Logger logger ;
	private Connection con ;
	
	public DistReleveDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<DistDistanceForm> all ()
	   {
		 ArrayList<DistDistanceForm> l = new  ArrayList<DistDistanceForm>();
		   
			String sql = "SELECT * FROM releve_machine order by num_relj,cdmac,dat_rlvj" ;
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
					 String distance_reel=rs.getString("cpt_j");
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
			 rapport_distance_compteur,  distance_reel,  valide));
	


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
	 
	
	 
	 public ArrayList<DistDistanceForm> en_attente()
	   {
		 ArrayList<DistDistanceForm> l = new  ArrayList<DistDistanceForm>();
		   
			String sql = "SELECT * FROM releve_machine where vld='n' order by num_relj,cdmac,dat_rlvj" ;
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
					 String distance_reel=rs.getString("cpt_j");
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
			 rapport_distance_compteur,  distance_reel,  valide));
	


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
	 
 
	 public boolean delete(String id_rel,String id_vehicule)
	 {boolean res=true;
	 
	 String sql = "delete FROM releve_machine where  num_relj='"+id_rel+"' and cdmac='"+id_vehicule.replace("'", "''")+"'" ;
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
	 
	 public boolean add(DistDistanceForm frm)
	 {boolean res=true;
	 
	 String rapp="";
	 System.out.print(frm.getRapport_distance_compteur());
	 if(frm.getRapport_distance_compteur()==null)
		 rapp="null";
		 else
		 rapp=frm.getRapport_distance_compteur();
	 

	 String sql = "INSERT INTO releve_machine(cdmac, num_relj, dat_rlvj, carb, index_ant, index_jr, cpt_idx, vld) values ('"
		 +frm.getId_vehicule().replace("'", "''")+"',"
		 +frm.getId_distance().replace("'", "''")+",'"
		 +inverser(frm.getDate().replace("/", "-"),"-")+"',"
		 +frm.getQté_combustible()+","
		 +frm.getAncien_compteur()+","
		 +frm.getActuel_compteur()+","
		 +rapp+","
		 +"'n'"
		 +")" ;
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
	 
	 public DistDistanceForm recup (String id_rel,String id_vehicule1)
	   {
		 DistDistanceForm aux=null;
		   
			String sql = "SELECT * FROM releve_machine where  num_relj='"+id_rel+"' and cdmac='"+id_vehicule1.replace("'", "''")+"'" ;

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
					 String distance_reel=rs.getString("cpt_j");
					 String valide=rs.getString("vld");
					 if(valide.equals("n"))
						 valide="en attente";
					 if(valide.equals("o"))
						 valide="validé";
					 if(valide.equals("r"))
						 valide="refusé";
		
					  
	aux=new DistDistanceForm( id_distance,  id_vehicule,
			 libelle_vehicule,  pourcentage_consommation,date,
			 ancien_compteur,  actuel_compteur,  qté_combustible,
			 rapport_distance_compteur,  distance_reel,  valide);
	


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
		aux.setLibelle_vehicule(lib);
		     if(lib1!=null)
		 aux.setPourcentage_consommation(lib1);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}
					
				}
			}
			catch (Exception e) 
			{aux=null;		
			logger.error(e+"requete =  "+sql);
			}
		   
		   
		   return aux ;
		   
	   }
	 
	 
	 public void valider(DistDistanceForm frm)
	 {
		 String sql="update releve_machine set vld='o' where cdmac='"+frm.getId_vehicule()+"' and num_relj='"+frm.getId_distance()+"'";
		 try{
			 Statement instruction = con.createStatement();
			 instruction.executeUpdate(sql); 
		 }
		 catch(Exception e)
		 {logger.error(e+"requete =  "+sql);}
	 }
	 
	 
	 public void refuser(DistDistanceForm frm)
	 {
		 String sql="update releve_machine set vld='r' where cdmac='"+frm.getId_vehicule()+"' and num_relj='"+frm.getId_distance()+"'";
		System.out.println(sql);
		 try{
			 Statement instruction = con.createStatement();
			 instruction.executeUpdate(sql); 
		 }
		 catch(Exception e)
		 {logger.error(e+"requete =  "+sql);}
	 }
	 
	 
	 
	 public void annuler_alerte_releve()
	 {
	 
	 
	
		String sql="UPDATE alert_releve SET alerte='false'";

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}

	 
	 }
	 
	 public void alerte()
	 {
	 
	 
	
		String sql="UPDATE alert_releve SET alerte='true'";

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}

	 
	 }
	 
	 
	 public DistDistanceForm ajuster(DistDistanceForm releve)
	 {  
		 

		 //obtenir code releve
			String sql = "SELECT count(*) FROM releve_machine where cdmac = '"+releve.getId_vehicule().replace("'", "''")+"' " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
					if (rs.getInt(1) > 0 )
						releve.setId_distance(String.valueOf(rs.getInt(1)+1));
					
					else
						releve.setId_distance("1");

			}
			catch (Exception e) 
			{logger.error(e+"requete =  "+sql);
			releve.setId_distance("1");
			}
			
			 //obtenir code Cpt
			if(!releve.getId_distance().equals("1"))
			{ sql = "SELECT max(index_jr),max(dat_rlvj) FROM releve_machine where cdmac = '"+releve.getId_vehicule().replace("'", "''")+"' " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				rs.next();
				releve.setAncien_compteur(String.valueOf(rs.getInt(1)));
				releve.setAncienne_date(inverser(rs.getString(2).replace("-", "/"),"/"));
			}
			catch (Exception e) 
			{logger.error(e+"requete =  "+sql);}}
			else
			{
				 sql = "SELECT rlv_mac,dat_rlv_mac FROM rlv_mac where cdmac = '"+releve.getId_vehicule().replace("'", "''")+"' " ;
					try{
						Statement instruction = con.createStatement();
						ResultSet rs = instruction.executeQuery(sql);
						rs.next();
						releve.setAncien_compteur(String.valueOf(rs.getInt(1)));
						releve.setAncienne_date(inverser(rs.getString(2).replace("-", "/"),"/"));

					}
					catch (Exception e) 
					{logger.error(e+"requete =  "+sql);
					releve.setAncien_compteur("0");
					}
				
			}
		 
		 
		 
		 
		 
		 
		 return releve;
	 }
	 
	 

	 
	 
	 public ArrayList<DistDistanceForm> inverse(ArrayList<DistDistanceForm> l)
	 {
		 ArrayList<DistDistanceForm> res=new ArrayList<DistDistanceForm>();
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
