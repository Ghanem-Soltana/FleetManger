package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.DistInitCptForm;
import Bean.TypeCompteurForm;


public class DistInitCptDao {

	private Logger logger ;
	private Connection con ;
	
	public DistInitCptDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<DistInitCptForm> all ()
	   {
		 ArrayList<DistInitCptForm> l = new  ArrayList<DistInitCptForm>();
		   
			String sql = "SELECT * FROM rlv_mac order by cdcompt,cdmac" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					 String id_type_cpt=rs.getString("cdcompt");
					 String libelle_type_cpt="";
					 String id_vehicue=rs.getString("cdmac");
					 String libelle_vehicue="";
					 String date=inverser(rs.getString("dat_rlv_mac").replace("-", "/"),"/");
					 String cpt_inital=rs.getString("rlv_mac");
					
						l.add(new  DistInitCptForm( id_type_cpt,  libelle_type_cpt,
								 id_vehicue,  libelle_vehicue,  date,
								 cpt_inital) );
						
						

						String sql1="",sql2="";
						try{

						 sql1= " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							  String lib=rs1.getString("lbmac");
							     if(lib!=null)
							 l.get(l.size()-1).setLibelle_vehicue(lib);

						}
						}catch(Exception e1){logger.error(e1+"requete1 =  "+sql1);}
						
						try{

							 sql2= " SELECT * FROM compteur where cdcompt='"+rs.getString("cdcompt")+"'";
							Statement instruction2 = con.createStatement();
							ResultSet rs2 = instruction2.executeQuery(sql2);
							while(rs2.next())
							{
								  String lib=rs2.getString("lbcompt");
								     if(lib!=null)
								 l.get(l.size()-1).setLibelle_type_cpt(lib);

							}
							}catch(Exception e2){logger.error(e2+"requete2 =  "+sql2);}
										
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<DistInitCptForm>();
			logger.error(e+"requete0 =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 
	 public boolean peutetresupprimer(String id_mac,String id_rel)
	 {boolean res=false;
	 
	 String sql = "select count(*) FROM releve_machine where  cdmac='"+id_mac.replace("\"", "\"\"")+"'  " ;
	 try{
		 Statement instruction = con.createStatement();
			ResultSet rs = instruction.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getInt(1)==0)
					res=true;
			}
			
	 }
	 catch(Exception e)
	 {res=true;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 } 
	 
	 public boolean delete(String id_mac,String id_rel)
	 {boolean res=true;
	 
	 String sql = "delete FROM rlv_mac where  cdmac='"+id_mac.replace("\"", "\"\"")+"' and cdcompt='"+id_rel.replace("\"", "\"\"")+"' " ;
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
	 
	 public boolean add(DistInitCptForm frm)
	 {boolean res=true;

	 String sql = "	 INSERT INTO rlv_mac(cdcompt, cdmac, dat_rlv_mac, rlv_mac) values ('"+frm.getId_type_cpt().replace("'", "''")+"','"+frm.getId_vehicue().replace("'", "''")+"'"
	 
	 +",'"+inverser(frm.getDate().replace("/", "-"),"-")+"',"+frm.getCpt_inital()
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
	 
	 public DistInitCptForm recup (String id_mac,String id_rel)
	   {
		 DistInitCptForm aux=null;
		   
			String sql = "SELECT * FROM rlv_mac  where  cdmac='"+id_mac.replace("\"", "\"\"")+"' and cdcompt='"+id_rel.replace("\"", "\"\"")+"' order by cdcompt,cdmac" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					 String id_type_cpt=rs.getString("cdcompt");
					 String libelle_type_cpt="";
					 String id_vehicue=rs.getString("cdmac");
					 String libelle_vehicue="";
					 String date=inverser(rs.getString("dat_rlv_mac").replace("-", "/"),"/");
					 String cpt_inital=rs.getString("rlv_mac");
					
						aux=new  DistInitCptForm( id_type_cpt,  libelle_type_cpt,
								 id_vehicue,  libelle_vehicue,  date,
								 cpt_inital) ;
						
						

						String sql1="",sql2="";
						try{

						 sql1= " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							  String lib=rs1.getString("lbmac");
							     if(lib!=null)
							aux.setLibelle_vehicue(lib);

						}
						}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}
						
						try{

							 sql2= " SELECT * FROM compteur where cdcompt='"+rs.getString("cdcompt")+"'";
							Statement instruction2 = con.createStatement();
							ResultSet rs2 = instruction2.executeQuery(sql2);
							while(rs2.next())
							{
								  String lib=rs2.getString("lbcompt");
								     if(lib!=null)
								 aux.setLibelle_type_cpt(lib);

							}
							}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}
										
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(DistInitCptForm frm)
	 {boolean res=true;
	 
	 String sql = "UPDATE rlv_mac SET dat_rlv_mac='"+inverser(frm.getDate().replace("/", "-"),"-")+"', rlv_mac="+frm.getCpt_inital()	 
	 +" where  cdmac='"+frm.getId_vehicue().replace("\"", "\"\"")+"' and cdcompt='"+frm.getId_type_cpt().replace("\"", "\"\"")+"' " ;
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
	 
	 

	 public ArrayList<TypeCompteurForm> getTypeCpt ()
	   {
		 ArrayList<TypeCompteurForm> l = new  ArrayList<TypeCompteurForm>();
		   
			String sql = "SELECT * FROM compteur" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
						l.add(new TypeCompteurForm(rs.getString("cdcompt"),rs.getString("lbcompt")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<TypeCompteurForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 
	 public ArrayList<DistInitCptForm> inverse(ArrayList<DistInitCptForm> l)
	 {
		 ArrayList<DistInitCptForm> res=new ArrayList<DistInitCptForm>();
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
