package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.VehiculeForm;

public class VehiculeDao {

	private Logger logger ;
	private Connection con ;
	
	public VehiculeDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<VehiculeForm> all ()
	   {
		 ArrayList<VehiculeForm> l = new  ArrayList<VehiculeForm>();
		    
			String sql = "SELECT * FROM machine order by cdmac " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	

					 //OBLIGATOIRE	
						 String id_vehicule=rs.getString("cdmac");
						 String libelle_vehicule=rs.getString("lbmac");
						 String id_modele=rs.getString("cdmod");
						 String id_marque=rs.getString("cdmarque");
						 String id_categorie=rs.getString("cdcatvh");
						 //optionnel
						 String id_station=rs.getString("codstat");
						 //String et date
						 String referrence=rs.getString("ref_mac");
						 String serie=rs.getString("serie");
						//solution temporaire
						 String date_fabrication="";
						 try{ date_fabrication=inverser( rs.getString("dat_fab").replace("-", "/"),"/");}catch(Exception e){}
						 String date_achat="";
						 try{date_achat=inverser( rs.getString("dat_acq").replace("-", "/"),"/");}catch(Exception e){}
						 String date_utilisation="";
						 try{date_utilisation=inverser( rs.getString("dat_mes").replace("-", "/"),"/");}catch(Exception e){}
						
						 //num
						 String prix_achat=rs.getString("val_acq");
						 String prix_assurance=rs.getString("val_assur");
						 String prix_consommation=rs.getString("val_amort");
						 String moukhatit=rs.getString("numplan");
						 String num_manjami=rs.getString("immat");
						 String nb_place_assi=rs.getString("plc_ass");
						 String nb_place_debout=rs.getString("plc_deb");
						 String puissance_vapeur=rs.getString("puiss");
						 String nb_cylindre=rs.getString("cylind");
						 String poids_vide=rs.getString("pds_vid");
						 String poids_supporte=rs.getString("charge");
						 String compteur=rs.getString("cpt");
						 String myenne_kilometrage=rs.getString("km_moy");
						 String moyenne_consommation=rs.getString("taux");
						 //string
						 String remarque=rs.getString("obs");
						//boolean
						
						 //String
						 String date_arret="";
						 try{ date_arret=inverser( rs.getString("dat_act").replace("-", "/"),"/");}catch(Exception e){}
						 String imprime=rs.getString("edition");
						 String arret=rs.getString("actif");
					
					
					
 VehiculeForm	aux=new VehiculeForm( id_vehicule,  libelle_vehicule,
						 id_modele,  "",  id_marque,
						 "",  id_categorie,
						 "",  id_station,
						 "",  referrence,  serie,
						 date_fabrication,  date_achat,
						 date_utilisation,  prix_achat,  prix_assurance,
						 prix_consommation,  moukhatit,  num_manjami,
						 nb_place_assi,  nb_place_debout,
						 puissance_vapeur,  nb_cylindre,  poids_vide,
						 poids_supporte,  compteur,  myenne_kilometrage,
						 moyenne_consommation,  remarque,  imprime.equals("o"),
						arret.equals("1"),  date_arret);





 			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="";
	try{

	 sql1= " SELECT * FROM mod_mac where cdmod='"+id_modele+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbmod");
		     if(lib!=null)
		 aux.setLibelle_modele(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM MARQUE where cdmarque='"+id_marque+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("lbmarque");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_marque(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM categorie where cdcatvh='"+id_categorie+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbcatvh");
                    	  if(lib!=null)
                    		  l.get(l.size()-1).setLibelle_categorie(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM STAT_ENT where CODSTAT='"+id_station+"'";
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("libstat");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_station(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}



					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 String sql="";
	 
	 sql = "delete FROM lpass where  cdmac='"+id+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
	 
	 
	 sql = "delete FROM ord_miss where  cdmac='"+id+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
	 
	 
	 sql = "delete FROM pce_mac where  cdmac='"+id+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
	 
	 sql = "delete FROM affec_mac where  cdmac='"+id+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
	 sql = "delete FROM depot_vehic where  cdmac='"+id+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	  sql = "delete FROM machine where  cdmac='"+id+"'" ;
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
	 
	 public boolean add(VehiculeForm frm)
	 {boolean res=true;

	 //OBLIGATOIRE	
		 String id_vehicule="'"+frm.getId_vehicule().replace("'", "''")+"'";
		 String libelle_vehicule="'"+frm.getLibelle_vehicule().replace("'", "''")+"'";
		 String id_modele="'"+frm.getId_modele().replace("'", "''")+"'";
		 String id_marque="'"+frm.getId_marque().replace("'", "''")+"'";
		 String id_categorie="'"+frm.getId_categorie().replace("'", "''")+"'";
		 //optionnel
		 String id_station=(!frm.getId_station().equals("xxxxxx"))?"'"+frm.getId_station().replace("'", "''")+"'":"null";
		 //String et date
		 String referrence="'"+frm.getReferrence().replace("'", "''")+"'";
		 String serie="'"+frm.getSerie().replace("'", "''")+"'";
		 String date_fabrication="null";
		 try{
		 date_fabrication="'"+inverser(frm.getDate_fabrication().replace("/", "-"),"-")+"'";
		 }catch(Exception e){}
		
		 String date_achat="null";
		 try{ date_achat ="'"+inverser(frm.getDate_achat().replace("/", "-"),"-")+"'";}catch(Exception e){}
		 String date_utilisation="null";
		 
		 try{ date_utilisation="'"+inverser(frm.getDate_utilisation().replace("/", "-"),"-")+"'";}catch(Exception e){}
		 
		
		 //num
		 String prix_achat=(!frm.getPrix_achat().equals(""))?frm.getPrix_achat().replace("'", "''"):"null";
		 String prix_assurance=(!frm.getPrix_assurance().equals(""))?frm.getPrix_assurance().replace("'", "''"):"null";;
		 String prix_consommation=(!frm.getPrix_consommation().equals(""))?frm.getPrix_consommation().replace("'", "''"):"null";;
		 String moukhatit=(!frm.getMoukhatit().equals(""))?frm.getMoukhatit().replace("'", "''"):"null";;
		 String num_manjami=(!frm.getNum_manjami().equals(""))?frm.getNum_manjami().replace("'", "''"):"null";;
		 String nb_place_assi=(!frm.getNb_place_assi().equals(""))?frm.getNb_place_assi().replace("'", "''"):"null";
		 String nb_place_debout=(!frm.getNb_place_debout().equals(""))?frm.getNb_place_debout().replace("'", "''"):"null";;
		 String puissance_vapeur=(!frm.getPuissance_vapeur().equals(""))?frm.getPuissance_vapeur().replace("'", "''"):"null";;
		 String nb_cylindre=(!frm.getNb_cylindre().equals(""))?frm.getNb_cylindre().replace("'", "''"):"null";;
		 String poids_vide=(!frm.getPoids_vide().equals(""))?frm.getPoids_vide().replace("'", "''"):"null";;
		 String poids_supporte=(!frm.getPoids_supporte().equals(""))?frm.getPoids_supporte().replace("'", "''"):"null";;
		 String compteur=(!frm.getCompteur().equals(""))?frm.getCompteur().replace("'", "''"):"null";;
		 String myenne_kilometrage=(!frm.getMyenne_kilometrage().equals(""))?frm.getMyenne_kilometrage().replace("'", "''"):"null";;
		 String moyenne_consommation=(!frm.getMoyenne_consommation().equals(""))?frm.getMoyenne_consommation().replace("'", "''"):"null";;
		 //string
		 String remarque="'"+frm.getRemarque().replace("'", "''")+"'";
		//boolean
		
		 //String
		 String date_arret="null";
		 String imprime=(frm.isImprime())?"'o'":"'n'" ;
		 String arret=(frm.isArret())?"1":"0" ;
	 
	if(compteur.equals("null"))
		compteur="'0'";
	 
	
	
	System.out.println(frm.isImprime());
	 String sql = "	";			
	 sql= "INSERT INTO machine(cdmac, lbmac, cdmod, cdmarque, cdcatvh,codstat, ref_mac, serie, dat_fab, dat_acq,dat_mes, ";
	sql=sql+"  val_acq, val_assur, val_amort, numplan, immat, plc_ass,plc_deb, puiss, cylind, pds_vid, charge,";
	sql=sql+"  cpt, km_moy,taux,obs, dat_act, edition,actif) "	;
	sql=sql+" values ("+id_vehicule+","+libelle_vehicule+","+id_modele+","+id_marque+","+id_categorie+","+id_station+",";
	sql=sql+referrence+","+serie+","+date_fabrication+","+date_achat+","+date_utilisation+","+prix_achat+","+prix_assurance+"," ;
	sql=sql+prix_consommation+","+moukhatit+","+num_manjami+","+nb_place_assi+","+nb_place_debout+","+puissance_vapeur+","+nb_cylindre+",";
	sql=sql+poids_vide+","+poids_supporte+","+compteur+","+myenne_kilometrage+","+moyenne_consommation+","+remarque+","+date_arret+","+imprime+","+arret;
	sql=sql+")";
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
	 
	 public VehiculeForm recup (String id)
	   {
		 VehiculeForm aux=null;
		   
			String sql = "SELECT * FROM machine where cdmac='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					


					 //OBLIGATOIRE	
						 String id_vehicule=rs.getString("cdmac");
						 String libelle_vehicule=rs.getString("lbmac");
						 String id_modele=rs.getString("cdmod");
						 String id_marque=rs.getString("cdmarque");
						 String id_categorie=rs.getString("cdcatvh");
						 //optionnel
						 String id_station=rs.getString("codstat");
						 //String et date
						 String referrence=rs.getString("ref_mac");
						 String serie=rs.getString("serie");
						//solution temporaire
						 String date_fabrication="";
						 try{ date_fabrication=inverser( rs.getString("dat_fab").replace("-", "/"), "/");}catch(Exception e){}
						 String date_achat="";
						 try{date_achat=inverser( rs.getString("dat_acq").replace("-", "/"), "/");}catch(Exception e){}
						 String date_utilisation="";
						 try{date_utilisation=inverser( rs.getString("dat_mes").replace("-", "/"), "/");}catch(Exception e){}
						
						 //num
						 String prix_achat=rs.getString("val_acq");
						 String prix_assurance=rs.getString("val_assur");
						 String prix_consommation=rs.getString("val_amort");
						 String moukhatit=rs.getString("numplan");
						 String num_manjami=rs.getString("immat");
						 String nb_place_assi=rs.getString("plc_ass");
						 String nb_place_debout=rs.getString("plc_deb");
						 String puissance_vapeur=rs.getString("puiss");
						 String nb_cylindre=rs.getString("cylind");
						 String poids_vide=rs.getString("pds_vid");
						 String poids_supporte=rs.getString("charge");
						 String compteur=rs.getString("cpt");
						 String myenne_kilometrage=rs.getString("km_moy");
						 String moyenne_consommation=rs.getString("taux");
						 //string
						 String remarque=rs.getString("obs");
						//boolean
						
						 //String
						 String date_arret="";
						 try{ date_arret=inverser( rs.getString("dat_act").replace("-", "/"), "/");}catch(Exception e){}
						 String imprime=rs.getString("edition");
						 String arret=rs.getString("actif");
					
					
					
				aux=new VehiculeForm( id_vehicule,  libelle_vehicule,
						 id_modele,  "",  id_marque,
						 "",  id_categorie,
						 "",  id_station,
						 "",  referrence,  serie,
						 date_fabrication,  date_achat,
						 date_utilisation,  prix_achat,  prix_assurance,
						 prix_consommation,  moukhatit,  num_manjami,
						 nb_place_assi,  nb_place_debout,
						 puissance_vapeur,  nb_cylindre,  poids_vide,
						 poids_supporte,  compteur,  myenne_kilometrage,
						 moyenne_consommation,  remarque,  imprime.equals("o"),
						arret.equals("1"),  date_arret);
					

					String sql1="",sql2="",sql3="",sql4="";
					try{

					 sql1= " SELECT * FROM mod_mac where cdmod='"+id_modele+"'";
					Statement instruction1 = con.createStatement();
					ResultSet rs1 = instruction1.executeQuery(sql1);
					while(rs1.next())
					{
						  String lib=rs1.getString("lbmod");
						     if(lib!=null)
						 aux.setLibelle_modele(lib);
					}
					}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


					try{

						 sql2= " SELECT * FROM MARQUE where cdmarque='"+id_marque+"'";
						Statement instruction2 = con.createStatement();
						ResultSet rs2 = instruction2.executeQuery(sql2);
						while(rs2.next())
						{
							  String lib=rs2.getString("lbmarque");
							  if(lib!=null)
							 aux.setLibelle_marque(lib);
						}
						}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





						try{

							 sql3= " SELECT * FROM categorie where cdcatvh='"+id_categorie+"'";
							Statement instruction3 = con.createStatement();
							ResultSet rs3 = instruction3.executeQuery(sql3);
							while(rs3.next())
							{
								  String lib=rs3.getString("lbcatvh");
                                    	  if(lib!=null)
									  aux.setLibelle_categorie(lib);
							}
							}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


							try{

								 sql4= " SELECT * FROM STAT_ENT where CODSTAT='"+id_station+"'";
								Statement instruction4 = con.createStatement();
								ResultSet rs4 = instruction4.executeQuery(sql4);
								while(rs4.next())
								{
									 String lib=rs4.getString("libstat");
									  if(lib!=null)
								 aux.setLibelle_station(lib);
								}
								}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}




							
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(VehiculeForm frm)
	 {boolean res=true;
	

	 //OBLIGATOIRE	
	 String id_vehicule="'"+frm.getId_vehicule().replace("'", "''")+"'";
	 String libelle_vehicule="'"+frm.getLibelle_vehicule().replace("'", "''")+"'";
	 String id_modele="'"+frm.getId_modele().replace("'", "''")+"'";
	 String id_marque="'"+frm.getId_marque().replace("'", "''")+"'";
	 String id_categorie="'"+frm.getId_categorie().replace("'", "''")+"'";
	 //optionnel
	 String id_station=(!frm.getId_station().equals("xxxxxx"))?"'"+frm.getId_station().replace("'", "''")+"'":"null";
	 //String et date
	 String referrence="'"+frm.getReferrence().replace("'", "''")+"'";
	 String serie="'"+frm.getSerie().replace("'", "''")+"'";
	 
	 String date_fabrication="null";
	 try{
	 date_fabrication="'"+inverser(frm.getDate_fabrication().replace("/", "-"),"-")+"'";
	 }catch(Exception e){}
	
	 String date_achat="null";
	 try{ date_achat ="'"+inverser(frm.getDate_achat().replace("/", "-"),"-")+"'";}catch(Exception e){}
	 String date_utilisation="null";
	 
	 try{ date_utilisation="'"+inverser(frm.getDate_utilisation().replace("/", "-"),"-")+"'";}catch(Exception e){}
	 
	 
	 //num
	 String prix_achat=(!frm.getPrix_achat().equals(""))?frm.getPrix_achat().replace("'", "''"):"null";
	 String prix_assurance=(!frm.getPrix_assurance().equals(""))?frm.getPrix_assurance().replace("'", "''"):"null";;
	 String prix_consommation=(!frm.getPrix_consommation().equals(""))?frm.getPrix_consommation().replace("'", "''"):"null";;
	 String moukhatit=(!frm.getMoukhatit().equals(""))?frm.getMoukhatit().replace("'", "''"):"null";;
	 String num_manjami=(!frm.getNum_manjami().equals(""))?frm.getNum_manjami().replace("'", "''"):"null";;
	 String nb_place_assi=(!frm.getNb_place_assi().equals(""))?frm.getNb_place_assi().replace("'", "''"):"null";
	 String nb_place_debout=(!frm.getNb_place_debout().equals(""))?frm.getNb_place_debout().replace("'", "''"):"null";;
	 String puissance_vapeur=(!frm.getPuissance_vapeur().equals(""))?frm.getPuissance_vapeur().replace("'", "''"):"null";;
	 String nb_cylindre=(!frm.getNb_cylindre().equals(""))?frm.getNb_cylindre().replace("'", "''"):"null";;
	 String poids_vide=(!frm.getPoids_vide().equals(""))?frm.getPoids_vide().replace("'", "''"):"null";;
	 String poids_supporte=(!frm.getPoids_supporte().equals(""))?frm.getPoids_supporte().replace("'", "''"):"null";;
	 String compteur=(!frm.getCompteur().equals(""))?frm.getCompteur().replace("'", "''"):"null";;
	 String myenne_kilometrage=(!frm.getMyenne_kilometrage().equals(""))?frm.getMyenne_kilometrage().replace("'", "''"):"null";;
	 String moyenne_consommation=(!frm.getMoyenne_consommation().equals(""))?frm.getMoyenne_consommation().replace("'", "''"):"null";;
	 //string
	 String remarque="'"+frm.getRemarque().replace("'", "''")+"'";
	//boolean
	
	 //String
	 String date_arret="null";
	 String imprime=(frm.isImprime())?"'o'":"'n'" ;
	 String arret=(frm.isArret())?"1":"0" ;
		
	 
	 if(compteur.equals("null"))
			compteur="'0'";
		 String sql ="";
		 

		 
	 
	 sql = "update machine set ";
	sql=sql+" cdmac="+id_vehicule+", lbmac="+libelle_vehicule+", cdmod="+id_modele+", cdmarque="+id_marque+", cdcatvh="+id_categorie+",codstat="+id_station+", ref_mac="+referrence+", serie="+serie+",";
	sql=sql+" dat_fab="+date_fabrication+", dat_acq="+date_achat+",dat_mes="+date_utilisation+",  val_acq="+prix_achat+", val_assur="+prix_assurance+", val_amort="+prix_consommation+", numplan="+moukhatit+",";
	sql=sql+"immat="+num_manjami+", plc_ass="+nb_place_assi+",plc_deb="+nb_place_debout+", puiss="+puissance_vapeur+", cylind="+nb_cylindre+", pds_vid="+poids_vide+", charge="+poids_supporte+", cpt="+compteur+", km_moy="+myenne_kilometrage+",taux="+moyenne_consommation+",obs="+remarque+", dat_act="+date_arret+", edition="+imprime+",actif="+arret ;
    sql=sql+" where cdmac="+id_vehicule;
	 
	 
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
	 
	 
	 public ArrayList<VehiculeForm> nonarrete ()
	   {
		 ArrayList<VehiculeForm> l = new  ArrayList<VehiculeForm>();
		    
			String sql = "SELECT * FROM machine order by cdmac " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	

					 //OBLIGATOIRE	
						 String id_vehicule=rs.getString("cdmac");
						 String libelle_vehicule=rs.getString("lbmac");
						 String id_modele=rs.getString("cdmod");
						 String id_marque=rs.getString("cdmarque");
						 String id_categorie=rs.getString("cdcatvh");
						 //optionnel
						 String id_station=rs.getString("codstat");
						 //String et date
						 String referrence=rs.getString("ref_mac");
						 String serie=rs.getString("serie");
						//solution temporaire
						 String date_fabrication="";
						 try{ date_fabrication=inverser( rs.getString("dat_fab").replace("-", "/"), "/");}catch(Exception e){}
						 String date_achat="";
						 try{date_achat=inverser( rs.getString("dat_acq").replace("-", "/"), "/");}catch(Exception e){}
						 String date_utilisation="";
						 try{date_utilisation=inverser( rs.getString("dat_mes").replace("-", "/"), "/");}catch(Exception e){}
						
						 //num
						 String prix_achat=rs.getString("val_acq");
						 String prix_assurance=rs.getString("val_assur");
						 String prix_consommation=rs.getString("val_amort");
						 String moukhatit=rs.getString("numplan");
						 String num_manjami=rs.getString("immat");
						 String nb_place_assi=rs.getString("plc_ass");
						 String nb_place_debout=rs.getString("plc_deb");
						 String puissance_vapeur=rs.getString("puiss");
						 String nb_cylindre=rs.getString("cylind");
						 String poids_vide=rs.getString("pds_vid");
						 String poids_supporte=rs.getString("charge");
						 String compteur=rs.getString("cpt");
						 String myenne_kilometrage=rs.getString("km_moy");
						 String moyenne_consommation=rs.getString("taux");
						 //string
						 String remarque=rs.getString("obs");
						//boolean
						
						 //String
						 String date_arret="";
						 try{ date_arret=inverser( rs.getString("dat_act").replace("-", "/"), "/");}catch(Exception e){}
						 String imprime=rs.getString("edition");
						 String arret=rs.getString("actif");
					
					
					
VehiculeForm	aux=new VehiculeForm( id_vehicule,  libelle_vehicule,
						 id_modele,  "",  id_marque,
						 "",  id_categorie,
						 "",  id_station,
						 "",  referrence,  serie,
						 date_fabrication,  date_achat,
						 date_utilisation,  prix_achat,  prix_assurance,
						 prix_consommation,  moukhatit,  num_manjami,
						 nb_place_assi,  nb_place_debout,
						 puissance_vapeur,  nb_cylindre,  poids_vide,
						 poids_supporte,  compteur,  myenne_kilometrage,
						 moyenne_consommation,  remarque,  imprime.equals("o"),
						arret.equals("1"),  date_arret);





			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="";
	try{

	 sql1= " SELECT * FROM mod_mac where cdmod='"+id_modele+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbmod");
		     if(lib!=null)
		 aux.setLibelle_modele(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM MARQUE where cdmarque='"+id_marque+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("lbmarque");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_marque(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM categorie where cdcatvh='"+id_categorie+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbcatvh");
                  	  if(lib!=null)
                  		  l.get(l.size()-1).setLibelle_categorie(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM STAT_ENT where CODSTAT='"+id_station+"'";
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("libstat");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_station(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}


	
				java.util.Date l_date = new java.util.Date(System.currentTimeMillis());
				   String l_stFormatDate = new String("dd/MM/yyyy");
				   DateFormat l_formatDate = new SimpleDateFormat(l_stFormatDate, java.util.Locale.FRENCH);
				   String date = l_formatDate.format(l_date);
				
				sql = "SELECT * FROM depot_vehic where (cdmac='"+id_vehicule+"' and dat_fin is null and dat_deb is not null) or (cdmac='"+id_vehicule+"' and dat_deb is not null and dat_fin is not null and dat_fin > '"+inverser(date.replace("/", "-"),"-")+"'  ) ";
				try{
					Statement instruction5 = con.createStatement();
					ResultSet rs5 = instruction5.executeQuery(sql);
					System.out.println(sql);
					while(rs5.next())
					{	
						l.remove(l.size()-1);
	
					}}
				catch (Exception e) 
				{
				logger.error(e+"requete =  "+sql);
				}		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }
	 
	 
	 


	 public ArrayList<VehiculeForm> ceux_qui_ont_ete_definit ()
	   {
		 ArrayList<VehiculeForm> l = new  ArrayList<VehiculeForm>();
		    
			String sql = "SELECT * FROM machine,rlv_mac where machine.cdmac=rlv_mac.cdmac  " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	

					 //OBLIGATOIRE	
						 String id_vehicule=rs.getString("cdmac");
						 String libelle_vehicule=rs.getString("lbmac");
						 String id_modele=rs.getString("cdmod");
						 String id_marque=rs.getString("cdmarque");
						 String id_categorie=rs.getString("cdcatvh");
						 //optionnel
						 String id_station=rs.getString("codstat");
						 //String et date
						 String referrence=rs.getString("ref_mac");
						 String serie=rs.getString("serie");
						//solution temporaire
						 String date_fabrication="";
						 try{ date_fabrication=inverser( rs.getString("dat_fab").replace("-", "/"), "/");}catch(Exception e){}
						 String date_achat="";
						 try{date_achat=inverser( rs.getString("dat_acq").replace("-", "/"), "/");}catch(Exception e){}
						 String date_utilisation="";
						 try{date_utilisation=inverser( rs.getString("dat_mes").replace("-", "/"), "/");}catch(Exception e){}
						
						 //num
						 String prix_achat=rs.getString("val_acq");
						 String prix_assurance=rs.getString("val_assur");
						 String prix_consommation=rs.getString("val_amort");
						 String moukhatit=rs.getString("numplan");
						 String num_manjami=rs.getString("immat");
						 String nb_place_assi=rs.getString("plc_ass");
						 String nb_place_debout=rs.getString("plc_deb");
						 String puissance_vapeur=rs.getString("puiss");
						 String nb_cylindre=rs.getString("cylind");
						 String poids_vide=rs.getString("pds_vid");
						 String poids_supporte=rs.getString("charge");
						 String compteur=rs.getString("cpt");
						 String myenne_kilometrage=rs.getString("km_moy");
						 String moyenne_consommation=rs.getString("taux");
						 //string
						 String remarque=rs.getString("obs");
						//boolean
						
						 //String
						 String date_arret="";
						 try{ date_arret=inverser( rs.getString("dat_act").replace("-", "/"), "/");}catch(Exception e){}
						 String imprime=rs.getString("edition");
						 String arret=rs.getString("actif");
					
					
					
 VehiculeForm	aux=new VehiculeForm( id_vehicule,  libelle_vehicule,
						 id_modele,  "",  id_marque,
						 "",  id_categorie,
						 "",  id_station,
						 "",  referrence,  serie,
						 date_fabrication,  date_achat,
						 date_utilisation,  prix_achat,  prix_assurance,
						 prix_consommation,  moukhatit,  num_manjami,
						 nb_place_assi,  nb_place_debout,
						 puissance_vapeur,  nb_cylindre,  poids_vide,
						 poids_supporte,  compteur,  myenne_kilometrage,
						 moyenne_consommation,  remarque,  imprime.equals("o"),
						arret.equals("1"),  date_arret);





 			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="";
	try{

	 sql1= " SELECT * FROM mod_mac where cdmod='"+id_modele+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbmod");
		     if(lib!=null)
		 aux.setLibelle_modele(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM MARQUE where cdmarque='"+id_marque+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("lbmarque");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_marque(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM categorie where cdcatvh='"+id_categorie+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbcatvh");
                    	  if(lib!=null)
                    		  l.get(l.size()-1).setLibelle_categorie(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM STAT_ENT where CODSTAT='"+id_station+"'";
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("libstat");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_station(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}



					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }

	 
	 public ArrayList<VehiculeForm> pas_encore_de_compteur()
	   {
		 ArrayList<VehiculeForm> l = new  ArrayList<VehiculeForm>();
		    
			String sql = "SELECT * FROM machine order by cdmac " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	

					 //OBLIGATOIRE	
						 String id_vehicule=rs.getString("cdmac");
						 String libelle_vehicule=rs.getString("lbmac");
						 String id_modele=rs.getString("cdmod");
						 String id_marque=rs.getString("cdmarque");
						 String id_categorie=rs.getString("cdcatvh");
						 //optionnel
						 String id_station=rs.getString("codstat");
						 //String et date
						 String referrence=rs.getString("ref_mac");
						 String serie=rs.getString("serie");
						//solution temporaire
						 String date_fabrication="";
						 try{ date_fabrication=inverser( rs.getString("dat_fab").replace("-", "/"), "/");}catch(Exception e){}
						 String date_achat="";
						 try{date_achat=inverser( rs.getString("dat_acq").replace("-", "/"), "/");}catch(Exception e){}
						 String date_utilisation="";
						 try{date_utilisation=inverser( rs.getString("dat_mes").replace("-", "/"), "/");}catch(Exception e){}
						
						 //num
						 String prix_achat=rs.getString("val_acq");
						 String prix_assurance=rs.getString("val_assur");
						 String prix_consommation=rs.getString("val_amort");
						 String moukhatit=rs.getString("numplan");
						 String num_manjami=rs.getString("immat");
						 String nb_place_assi=rs.getString("plc_ass");
						 String nb_place_debout=rs.getString("plc_deb");
						 String puissance_vapeur=rs.getString("puiss");
						 String nb_cylindre=rs.getString("cylind");
						 String poids_vide=rs.getString("pds_vid");
						 String poids_supporte=rs.getString("charge");
						 String compteur=rs.getString("cpt");
						 String myenne_kilometrage=rs.getString("km_moy");
						 String moyenne_consommation=rs.getString("taux");
						 //string
						 String remarque=rs.getString("obs");
						//boolean
						
						 //String
						 String date_arret="";
						 try{ date_arret=inverser( rs.getString("dat_act").replace("-", "/"), "/");}catch(Exception e){}
						 String imprime=rs.getString("edition");
						 String arret=rs.getString("actif");
					
					
					
VehiculeForm	aux=new VehiculeForm( id_vehicule,  libelle_vehicule,
						 id_modele,  "",  id_marque,
						 "",  id_categorie,
						 "",  id_station,
						 "",  referrence,  serie,
						 date_fabrication,  date_achat,
						 date_utilisation,  prix_achat,  prix_assurance,
						 prix_consommation,  moukhatit,  num_manjami,
						 nb_place_assi,  nb_place_debout,
						 puissance_vapeur,  nb_cylindre,  poids_vide,
						 poids_supporte,  compteur,  myenne_kilometrage,
						 moyenne_consommation,  remarque,  imprime.equals("o"),
						arret.equals("1"),  date_arret);





			l.add(aux);

			
			
			
			




    boolean test=false;
	String sql1="",sql2="",sql3="",sql4="",sql5="";
	
	try{

		 sql5= " SELECT * FROM rlv_mac where cdmac='"+id_vehicule+"'";
		Statement instruction5 = con.createStatement();
		ResultSet rs5 = instruction5.executeQuery(sql5);
		rs5.next();
		rs5.getInt(1);
		test=true;

		}catch(Exception e1){}

	if(!test)
	{
	
	try{

	 sql1= " SELECT * FROM mod_mac where cdmod='"+id_modele+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbmod");
		     if(lib!=null)
		 aux.setLibelle_modele(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM MARQUE where cdmarque='"+id_marque+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("lbmarque");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_marque(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM categorie where cdcatvh='"+id_categorie+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbcatvh");
                  	  if(lib!=null)
                  		  l.get(l.size()-1).setLibelle_categorie(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM STAT_ENT where CODSTAT='"+id_station+"'";
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("libstat");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_station(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}



					
				}
				else l.remove(l.size()-1);
				}
				
			
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }
	 
	 
	 public ArrayList<VehiculeForm> inverse(ArrayList<VehiculeForm> l)
	 {
		 ArrayList<VehiculeForm> res=new ArrayList<VehiculeForm>();
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
