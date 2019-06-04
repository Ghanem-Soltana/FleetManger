package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.BonDistributionForm;


public class BonDistributionDao {

	private Logger logger ;
	private Connection con ;
	
	public BonDistributionDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<BonDistributionForm> all ()
	   {
		 ArrayList<BonDistributionForm> l = new  ArrayList<BonDistributionForm>();
		   
			String sql = "SELECT * FROM sort_bon";
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
	
					
	
					
					 
					  String id_exercice=rs.getString("cdexerc");
					  String id_distribution=rs.getString("num_sort");
					  String date_distribution="";
					  try{ date_distribution=inverser(rs.getString("dat_sort").replace("-", "/"),"/");
					  }catch(Exception e ){}
					  
					  String id_magasin=rs.getString("cdmag");
					  String id_magasinier=rs.getString("decagen");
					  String id_vehicule=rs.getString("cdmac");
					  String id_centre=rs.getString("deccent");
					  String id_agence=rs.getString("decagenc");
					  String id_service=rs.getString("cdserv");
					  String id_recepteur=rs.getString("agen_recep");
					  String dernier_compteur=rs.getString("der_cpt_rlm");
					  String date_dernier_compteur="";
					  try{date_dernier_compteur=inverser(rs.getString("der_dat_rlvj").replace("-", "/"),"/");}catch(Exception e){}
					  String dernier_quantité=rs.getString("der_qte");
					  String distance_parcourus=rs.getString("cpt_j");
					  String taux=rs.getString("taux");
					  String valide=rs.getString("vld");
		
						 if(valide.equals("n"))
						 valide="en attente";
						 if(valide.equals("d"))
					    valide="distribué";
						 
						 
l.add(new  BonDistributionForm( id_exercice,  "",
		 id_distribution,  date_distribution,  id_magasin,
		 "",  id_magasinier,
		 "",  id_vehicule,  "",
		 id_centre,  "",  id_agence,
		 "",  id_service,  "",
		 id_recepteur,  "",
		 "",  "",
		 dernier_compteur,  date_dernier_compteur,
		 dernier_quantité,  distance_parcourus,  taux,
		 valide));
					

						String sql2 = "SELECT * FROM exercice where cdexerc='"+rs.getString("cdexerc")+"'" ;
						Statement instruction2 = con.createStatement();
						ResultSet rs2 = instruction2.executeQuery(sql2);
						while(rs2.next())
						{							
							  String lib=rs2.getString("lbexerc");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_exercice(lib);
								
								
								
								
						}
						
				
						String sql3 = "SELECT * FROM magasin where cdmag='"+rs.getString("cdmag")+"'" ;
						Statement instruction3 = con.createStatement();
						ResultSet rs3 = instruction3.executeQuery(sql3);
						while(rs3.next())
						{							
							  String lib=rs3.getString("lbmag");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_magasin(lib);
								
								
						}
					
						String sql4 = "SELECT * FROM agent where decagen='"+rs.getString("decagen")+"'" ;
						Statement instruction4 = con.createStatement();
						ResultSet rs4 = instruction4.executeQuery(sql4);
						while(rs4.next())
						{							
							  String lib=rs4.getString("denagen");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_magasinier(lib);
								
								
						}		
						
				
						
						String sql5 = "SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'" ;
						Statement instruction5 = con.createStatement();
						ResultSet rs5 = instruction5.executeQuery(sql5);
						while(rs5.next())
						{							
							  String lib=rs5.getString("lbmac");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_vehicule(lib);
								
								
						}		
						
					
						String sql6 = "SELECT * FROM centre where deccent='"+rs.getString("deccent")+"'" ;
						Statement instruction6 = con.createStatement();
						ResultSet rs6 = instruction6.executeQuery(sql6);
						while(rs6.next())
						{							
							  String lib=rs6.getString("delcent");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_centre(lib);
								
								
						}		
						
						String sql7 = "SELECT * FROM agence where decagenc='"+rs.getString("decagenc")+"'" ;
						Statement instruction7 = con.createStatement();
						ResultSet rs7 = instruction7.executeQuery(sql7);
						while(rs7.next())
						{							
							  String lib=rs7.getString("delagenc");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_agence(lib);
								
								
						}		
						
						String sql8 = "SELECT * FROM service where cdserv='"+rs.getString("cdserv")+"'" ;
						Statement instruction8 = con.createStatement();
						ResultSet rs8 = instruction8.executeQuery(sql8);
						while(rs8.next())
						{							
							  String lib=rs8.getString("lbserv");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_service(lib);
								
								
						}		
						
						String sql9 = "SELECT * FROM agent where decagen='"+rs.getString("agen_recep")+"'" ;
						Statement instruction9 = con.createStatement();
						ResultSet rs9 = instruction9.executeQuery(sql9);
						while(rs9.next())
						{							
							  String lib=rs9.getString("denagen");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_recepteur(lib);
								
								
						}	
						
	
						
						
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<BonDistributionForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 public boolean delete(String id_distribution,String id_exercice,String id_mag)
	 {boolean res=true;
	 
	 


	 String sql = "delete FROM det_sortbon where num_sort='"+id_distribution.replace("'", "''")+"'and cdexerc='"+id_exercice.replace("'", "''")+"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 
	  sql = "delete FROM sort_bon where num_sort='"+id_distribution.replace("'", "''")+"'and cdexerc='"+id_exercice.replace("'", "''")+"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
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
	 
	 public boolean add(BonDistributionForm frm)
	 {boolean res=true;


	  String id_exercice=frm.getId_exercice();
	  String id_distribution=frm.getId_distribution();
	  String date_distribution="null";
	  try{
	  date_distribution="'"+inverser(frm.getDate_distribution().replace("/", "-"),"-")+"'";
	  }catch(Exception e){}
	  String id_magasin="'"+frm.getId_magasin()+"'";
	  String id_magasinier=frm.getId_magasinier();
	  String id_vehicule="'"+frm.getId_vehicule()+"'";
	  String id_centre=frm.getId_centre();
	  String id_agence=frm.getId_agence();
	  String id_service=frm.getId_service();
	  String id_recepteur=frm.getId_recepteur();
	  String dernier_compteur=frm.getDernier_compteur();
	  if(dernier_compteur.equals(""))
		  dernier_compteur="0";

	  String date_dernier_compteur="null";
	  try{date_dernier_compteur="'"+inverser(frm.getDate_dernier_compteur().replace("/", "-"),"-")+"'";}catch(Exception e){}
	  
	  String dernier_quantité=frm.getDernier_quantité();
	  if(dernier_quantité.equals(""))
		  dernier_quantité="0";
	  
	  String distance_parcourus=frm.getDistance_parcourus();
	  if(distance_parcourus.equals(""))
		  distance_parcourus="0";
	  
	  String taux=frm.getTaux();
	  if(taux.equals(""))
		  taux="0";
	  String valide="'n'";


	 String sql = "	 INSERT INTO sort_bon(cdexerc, num_sort, dat_sort, cdmag, decagen, cdmac, deccent, decagenc, cdserv, agen_recep,der_cpt_rlm, der_dat_rlvj, der_qte, cpt_j, taux, vld) values ("+id_exercice+
	 ","+id_distribution+
	 ","+date_distribution+
	 ","+id_magasin+
	 ","+ id_magasinier+
	 ","+id_vehicule+
	 ","+id_centre+
	 ","+id_agence+
	 ","+id_service+
	 ","+id_recepteur+
	 ","+dernier_compteur+
	 ","+date_dernier_compteur+
	 ","+dernier_quantité+
	 ","+distance_parcourus+
	 ","+taux+
	 ","+valide
	 +" )" ;
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
	 
	 public BonDistributionForm recup (String id_distribution1,String id_exercice1,String id_mag1)
	   {
		 BonDistributionForm aux= null ;
		  
			String sql = "SELECT * FROM sort_bon where num_sort='"+id_distribution1.replace("'", "''")+"'and cdexerc='"+id_exercice1.replace("'", "''")+"'and cdmag='"+id_mag1.replace("'", "''")+"'" ;
			System.out.print(sql);
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
	
					
	
					
					 
					  String id_exercice=rs.getString("cdexerc");
					  String id_distribution=rs.getString("num_sort");
					  String date_distribution="";
					  try{ date_distribution=inverser(rs.getString("dat_sort").replace("-", "/"),"/");
					  }catch(Exception e ){}
					  
					  String id_magasin=rs.getString("cdmag");
					  String id_magasinier=rs.getString("decagen");
					  String id_vehicule=rs.getString("cdmac");
					  String id_centre=rs.getString("deccent");
					  String id_agence=rs.getString("decagenc");
					  String id_service=rs.getString("cdserv");
					  String id_recepteur=rs.getString("agen_recep");
					  String dernier_compteur=rs.getString("der_cpt_rlm");
					  String date_dernier_compteur="";
					  try{date_dernier_compteur=inverser(rs.getString("der_dat_rlvj").replace("-", "/"),"/");}catch(Exception e){}
					  String dernier_quantité=rs.getString("der_qte");
					  String distance_parcourus=rs.getString("cpt_j");
					  String taux=rs.getString("taux");
					  String valide=rs.getString("vld");
		
						 if(valide.equals("n"))
						 valide="en attente";
						 if(valide.equals("d"))
					    valide="distribué";
						 
						 
aux=new  BonDistributionForm( id_exercice,  "",
		 id_distribution,  date_distribution,  id_magasin,
		 "",  id_magasinier,
		 "",  id_vehicule,  "",
		 id_centre,  "",  id_agence,
		 "",  id_service,  "",
		 id_recepteur,  "",
		 "",  "",
		 dernier_compteur,  date_dernier_compteur,
		 dernier_quantité,  distance_parcourus,  taux,
		 valide);
					

						String sql2 = "SELECT * FROM exercice where cdexerc='"+rs.getString("cdexerc")+"'" ;
						Statement instruction2 = con.createStatement();
						ResultSet rs2 = instruction2.executeQuery(sql2);
						while(rs2.next())
						{							
							  String lib=rs2.getString("lbexerc");
							  if(lib!=null)
								  aux.setLibelle_exercice(lib);
								
								
								
								
						}
						
				
						String sql3 = "SELECT * FROM magasin where cdmag='"+rs.getString("cdmag")+"'" ;
						Statement instruction3 = con.createStatement();
						ResultSet rs3 = instruction3.executeQuery(sql3);
						while(rs3.next())
						{							
							  String lib=rs3.getString("lbmag");
							  if(lib!=null)
								  aux.setLibelle_magasin(lib);
								
								
						}
					
						String sql4 = "SELECT * FROM agent where decagen='"+rs.getString("decagen")+"'" ;
						Statement instruction4 = con.createStatement();
						ResultSet rs4 = instruction4.executeQuery(sql4);
						while(rs4.next())
						{							
							  String lib=rs4.getString("denagen");
							  if(lib!=null)
								  aux.setLibelle_magasinier(lib);
								
								
						}		
						
				
						
						String sql5 = "SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'" ;
						Statement instruction5 = con.createStatement();
						ResultSet rs5 = instruction5.executeQuery(sql5);
						while(rs5.next())
						{							
							  String lib=rs5.getString("lbmac");
							  if(lib!=null)
								  aux.setLibelle_vehicule(lib);
								
								
						}		
						
					
						String sql6 = "SELECT * FROM centre where deccent='"+rs.getString("deccent")+"'" ;
						Statement instruction6 = con.createStatement();
						ResultSet rs6 = instruction6.executeQuery(sql6);
						while(rs6.next())
						{							
							  String lib=rs6.getString("delcent");
							  if(lib!=null)
								  aux.setLibelle_centre(lib);
								
								
						}		
						
						String sql7 = "SELECT * FROM agence where decagenc='"+rs.getString("decagenc")+"'" ;
						Statement instruction7 = con.createStatement();
						ResultSet rs7 = instruction7.executeQuery(sql7);
						while(rs7.next())
						{							
							  String lib=rs7.getString("delagenc");
							  if(lib!=null)
								  aux.setLibelle_agence(lib);
								
								
						}		
						
						String sql8 = "SELECT * FROM service where cdserv='"+rs.getString("cdserv")+"'" ;
						Statement instruction8 = con.createStatement();
						ResultSet rs8 = instruction8.executeQuery(sql8);
						while(rs8.next())
						{							
							  String lib=rs8.getString("lbserv");
							  if(lib!=null)
								  aux.setLibelle_service(lib);
								
								
						}		
						
						String sql9 = "SELECT * FROM agent where decagen='"+rs.getString("agen_recep")+"'" ;
						Statement instruction9 = con.createStatement();
						ResultSet rs9 = instruction9.executeQuery(sql9);
						while(rs9.next())
						{							
							  String lib=rs9.getString("denagen");
							  if(lib!=null)
								  aux.setLibelle_recepteur(lib);
								
								
						}	
						
	
						
						
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux;
		   
	   }
	 
	 

	 
	 
	 public ArrayList<BonDistributionForm> inverse(ArrayList<BonDistributionForm> l)
	 {
		 ArrayList<BonDistributionForm> res=new ArrayList<BonDistributionForm>();
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
	 
	 
	 public void maj_distribution(BonDistributionForm frm)
	 {	 String id_vehicule=frm.getId_vehicule();
		 String date_dernier_compteur="";
		 String dernier_compteur="";
		 String carburant="";
		 String distance="";
		 
		 
	
			String sql =  "SELECT max(index_jr),max(dat_rlvj) FROM releve_machine where cdmac = '"+id_vehicule.replace("'", "''")+"' and vld='o' " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				rs.next();
				dernier_compteur=String.valueOf(rs.getInt(1));
				date_dernier_compteur=inverser(rs.getString(2).replace("-", "/"),"/");
				

			}catch(Exception e){	logger.error(e+"requete =  "+sql);}
			
		 sql =  "SELECT sum(carb) FROM releve_machine where cdmac = '"+id_vehicule.replace("'", "''")+"' and vld='o' " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				rs.next();
				carburant=String.valueOf(rs.getInt(1));

			}catch(Exception e){	logger.error(e+"requete =  "+sql);}
			
			 sql =  "SELECT sum(cpt_idx) FROM releve_machine where cdmac = '"+id_vehicule.replace("'", "''")+"'  and vld='o'" ;
				try{
					Statement instruction = con.createStatement();
					ResultSet rs = instruction.executeQuery(sql);
					rs.next();
					distance=String.valueOf(rs.getInt(1));

				}catch(Exception e){	logger.error(e+"requete =  "+sql);}
			
			frm.setDate_dernier_compteur(date_dernier_compteur);
			frm.setDernier_compteur(dernier_compteur);
			frm.setDernier_quantité(carburant);
			frm.setDistance_parcourus(distance);
			
			String taux="0";

			sql =  "SELECT taux FROM machine where cdmac = '"+id_vehicule.replace("'", "''")+"'  " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				rs.next();
				taux=String.valueOf(rs.getInt(1));

			}catch(Exception e){	logger.error(e+"requete =  "+sql);}
			
			frm.setTaux(taux);
			
			String libelle_agent="";
			String id_agent="";
			
			sql =  "SELECT agen_recep FROM sort_bon where cdmac = '"+id_vehicule.replace("'", "''")+"' and dat_sort=(select max(dat_sort)  FROM sort_bon where  cdmac = '"+id_vehicule.replace("'", "''")+"' )  " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				rs.next();
				id_agent=String.valueOf(rs.getInt(1));

				
				
				
				String sql1 =  "SELECT denagen FROM agent where decagen = '"+id_agent+"'" ;
				try{
					Statement instruction1 = con.createStatement();
					ResultSet rs1 = instruction1.executeQuery(sql1);
					rs1.next();
					libelle_agent=rs1.getString(1);

				}catch(Exception e){	logger.error(e+"requete =  "+sql1);}

				
			}catch(Exception e){	logger.error(e+"requete =  "+sql);}
			
			frm.setLibelle_dernier_recepteur(libelle_agent);
			
			
			
	 }



}
