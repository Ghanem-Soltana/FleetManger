package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.BonTransfertForm;


public class BonTransfertDao {

	private Logger logger ;
	private Connection con ;
	
	public BonTransfertDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<BonTransfertForm> all ()
	   {
		 ArrayList<BonTransfertForm> l = new  ArrayList<BonTransfertForm>();
		   
			String sql = "SELECT * FROM trans_bon";
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
	
					
					 String id_exercice=rs.getString("cdexerc");
					 String id_transfert=rs.getString("num_trans");
					 String	date_transfert=inverser(rs.getString("dat_trans").replace("-", "/"),"/");
					 String id_magasin_depart=rs.getString("cdmag");
					 String id_magasinier_donneur=rs.getString("decagen");
					 String id_magasin_arrive=rs.getString("cdmag_trans");
					 String id_magasinier_recepteur=rs.getString("decagen_trans");
					 String id_type_bon="";
					 String numero="";
					 String serie="";
					 String de="";
					 String a="";
					 String quantite_transfere="";
					 String valeur_transfere="";
					 String valide=rs.getString("vld");
					 
					 if(valide.equals("n"))
						 valide="en attente";

					
l.add(new  BonTransfertForm( id_exercice,  "",
		 id_transfert,  date_transfert,  id_magasin_depart,
		 "",  id_magasinier_donneur,
		 "",  id_magasin_arrive,
		 "",  id_magasinier_recepteur,
		 "",  id_type_bon,
		"",  "",  numero,
		 serie,  de,  a,  quantite_transfere,
		 valeur_transfere, valide) );
					

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
								  l.get(l.size()-1).setLibelle_magasin_depart(lib);
								
								
						}
					
						String sql4 = "SELECT * FROM agent where decagen='"+rs.getString("decagen")+"'" ;
						Statement instruction4 = con.createStatement();
						ResultSet rs4 = instruction4.executeQuery(sql4);
						while(rs4.next())
						{							
							  String lib=rs4.getString("denagen");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_magasinier_donneur(lib);
								
								
						}		
						
				
						
						String sql31 = "SELECT * FROM magasin where cdmag='"+rs.getString("cdmag_trans")+"'" ;
						Statement instruction31 = con.createStatement();
						ResultSet rs31 = instruction31.executeQuery(sql31);
						while(rs31.next())
						{							
							  String lib=rs31.getString("lbmag");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_magasin_arrive(lib);
								
								
						}
						
						
					
						String sql41 = "SELECT * FROM agent where decagen='"+rs.getString("decagen_trans")+"'" ;
						Statement instruction41 = con.createStatement();
						ResultSet rs41 = instruction41.executeQuery(sql41);
						while(rs41.next())
						{							
							  String lib=rs41.getString("denagen");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_magasinier_recepteur(lib);
								
								
						}		
						
						
	
						
						
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<BonTransfertForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id_transfert,String id_exercice,String id_mag)
	 {boolean res=true;
	 
	 


	 String sql = "delete FROM det_trans_bon where num_trans='"+id_transfert.replace("'", "''")+"'and cdexerc='"+id_exercice.replace("'", "''")+"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 
	  sql = "delete FROM trans_bon where num_trans='"+id_transfert.replace("'", "''")+"'and cdexerc='"+id_exercice.replace("'", "''")+"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
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
	 
	 public boolean add(BonTransfertForm frm)
	 {boolean res=true;


	 String id_exercice=frm.getId_exercice();
	 String id_transfert=frm.getId_transfert();
	 String	date_transfert="'"+inverser(frm.getDate_transfert().replace("/", "-"),"-")+"'";
	 String id_magasin_depart="'"+frm.getId_magasin_depart().replace("'", "''")+"'";
	 String id_magasinier_donneur=frm.getId_magasinier_donneur();
	 String id_magasin_arrive="'"+frm.getId_magasin_arrive().replace("'", "''")+"'";
	 String id_magasinier_recepteur=frm.getId_magasinier_recepteur();
	 String valide="'n'";

	 String sql = "	 INSERT INTO trans_bon(cdexerc, num_trans, dat_trans, cdmag, decagen, cdmag_trans, decagen_trans, vld) values ("+id_exercice+
	 ","+id_transfert+
	 ","+date_transfert+
	 ","+id_magasin_depart+
	 ","+ id_magasinier_donneur+
	 ","+id_magasin_arrive+
	 ","+id_magasinier_recepteur+
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
	 
	 
	 
	 
	 
	 if(res)
	 {
		 int debut=Integer.parseInt(frm.getDe());
		 int fin=Integer.parseInt(frm.getA());
		 for(int i=debut;i<=fin;i++)
		 {
		  sql = "INSERT INTO det_trans_bon(cdexerc, num_trans, num_lig, cdmag, cdtypbon, serie, bon_du, bon_au, valeur, qte) values ("+
		   id_exercice+
		 ","+id_transfert+
		 ","+i+
		 ","+id_magasin_depart+
		 ","+frm.getId_type_bon()+
		 ",'"+frm.getSerie().replace("'", "''")+
		 "',"+frm.getDe()+
		 ","+frm.getA()+
		 ","+frm.getValeur_transfere()+
		 ","+frm.getQuantite_transfere()
		 +" )" ;
		 try{
			 Statement instruction = con.createStatement();
			 instruction.executeUpdate(sql); 
		 }
		 catch(Exception e)
		 {res=false;
			 logger.error(e+"requete =  "+sql);}
		 }
		 
		 
     }
	 
		 
	 
	 

	
	 return res;
	 
	 }
	 
	 public BonTransfertForm recup (String id_transfert1,String id_exercice1,String id_mag)
	   {
		 BonTransfertForm aux= null ;

			String sql = "SELECT * FROM trans_bon,det_trans_bon where trans_bon.cdexerc=det_trans_bon.cdexerc and trans_bon.num_trans=det_trans_bon.num_trans and trans_bon.cdmag=det_trans_bon.cdmag and "+
			"  trans_bon.cdexerc="+id_exercice1+" and trans_bon.num_trans="+id_transfert1+" and trans_bon.cdmag='"+id_mag+"'";
			;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
	
					
					 String id_exercice=rs.getString("cdexerc");
					 String id_transfert=rs.getString("num_trans");
					 String	date_transfert=inverser(rs.getString("dat_trans").replace("-", "/"),"/");
					 String id_magasin_depart=rs.getString("cdmag");
					 String id_magasinier_donneur=rs.getString("decagen");
					 String id_magasin_arrive=rs.getString("cdmag_trans");
					 String id_magasinier_recepteur=rs.getString("decagen_trans");
					 String id_type_bon=rs.getString("cdtypbon");
					 String numero=rs.getString("nbre_sort");
					 String serie=rs.getString("serie");
					 String de=rs.getString("bon_du");
					 String a=rs.getString("bon_au");
					 String quantite_transfere=rs.getString("qte");
					 String valeur_transfere=rs.getString("valeur");
					 String valide=rs.getString("vld");
					 
					 if(valide.equals("n"))
						 valide="en attente";

					
aux=new  BonTransfertForm( id_exercice,  "",
		 id_transfert,  date_transfert,  id_magasin_depart,
		 "",  id_magasinier_donneur,
		 "",  id_magasin_arrive,
		 "",  id_magasinier_recepteur,
		 "",  id_type_bon,
		"",  "",  numero,
		 serie,  de,  a,  quantite_transfere,
		 valeur_transfere, valide) ;
					

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
								 aux.setLibelle_magasin_depart(lib);
								
								
						}
					
						String sql4 = "SELECT * FROM agent where decagen='"+rs.getString("decagen")+"'" ;
						Statement instruction4 = con.createStatement();
						ResultSet rs4 = instruction4.executeQuery(sql4);
						while(rs4.next())
						{							
							  String lib=rs4.getString("denagen");
							  if(lib!=null)
								  aux.setLibelle_magasinier_donneur(lib);
								
								
						}		
						
				
						
						String sql31 = "SELECT * FROM magasin where cdmag='"+rs.getString("cdmag_trans")+"'" ;
						Statement instruction31 = con.createStatement();
						ResultSet rs31 = instruction31.executeQuery(sql31);
						while(rs31.next())
						{							
							  String lib=rs31.getString("lbmag");
							  if(lib!=null)
								  aux.setLibelle_magasin_arrive(lib);
								
								
						}
						
						
					
						String sql41 = "SELECT * FROM agent where decagen='"+rs.getString("decagen_trans")+"'" ;
						Statement instruction41 = con.createStatement();
						ResultSet rs41 = instruction41.executeQuery(sql41);
						while(rs41.next())
						{							
							  String lib=rs41.getString("denagen");
							  if(lib!=null)
								  aux.setLibelle_magasinier_recepteur(lib);
								
								
						}		
						
						
	
				
						String sql5 = "SELECT * FROM typ_bon where cdtypbon='"+rs.getString("cdtypbon")+"'" ;
						Statement instruction5 = con.createStatement();
						ResultSet rs5 = instruction5.executeQuery(sql5);
						while(rs5.next())
						{							
							  String lib=rs5.getString("lbtypbon");
							  if(lib!=null)
								 aux.setLibelle_type_bon(lib);
								
								
						}	
						
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   

		   return aux ;
		   
	   }
	 
	 
	 public boolean update(BonTransfertForm frm)
	 {boolean res=true;

	 String sql = "delete FROM det_trans_bon where num_trans='"+frm.getId_transfert().replace("'", "''")+"'and cdexerc='"+frm.getId_exercice().replace("'", "''")+"'and cdmag='"+frm.getId_magasin_depart().replace("'", "''")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {
	 logger.error(e+"requete =  "+sql);
	 }
	 

	 String id_exercice=frm.getId_exercice();
	 String id_transfert=frm.getId_transfert();
	 String id_magasin_depart="'"+frm.getId_magasin_depart().replace("'", "''")+"'";
	 String	date_transfert="'"+inverser(frm.getDate_transfert().replace("/", "-"),"-")+"'";
	 String id_magasinier_donneur=frm.getId_magasinier_donneur();
	 String id_magasin_arrive="'"+frm.getId_magasin_arrive().replace("'", "''")+"'";
	 String id_magasinier_recepteur=frm.getId_magasinier_recepteur();

	 
	 sql="UPDATE trans_bon SET   dat_trans="+date_transfert+" ,decagen="+id_magasinier_donneur+", cdmag_trans="+id_magasin_arrive+", decagen_trans="+id_magasinier_recepteur
	 +" where  trans_bon.cdexerc="+id_exercice+" and trans_bon.num_trans="+id_transfert+" and trans_bon.cdmag="+id_magasin_depart;

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 
	 if(res)
	 {
		 int debut=Integer.parseInt(frm.getDe());
		 int fin=Integer.parseInt(frm.getA());
		 for(int i=debut;i<=fin;i++)
		 {
		  sql = "INSERT INTO det_trans_bon(cdexerc, num_trans, num_lig, cdmag, cdtypbon, serie, bon_du, bon_au, valeur, qte) values ("+
		   id_exercice+
		 ","+id_transfert+
		 ","+i+
		 ","+id_magasin_depart+
		 ","+frm.getId_type_bon()+
		 ",'"+frm.getSerie().replace("'", "''")+
		 "',"+frm.getDe()+
		 ","+frm.getA()+
		 ","+frm.getValeur_transfere()+
		 ","+frm.getQuantite_transfere()
		 +" )" ;
		 try{
			 Statement instruction = con.createStatement();
			 instruction.executeUpdate(sql); 
		 }
		 catch(Exception e)
		 {res=false;
			 logger.error(e+"requete =  "+sql);}
		 }
		 
		 
     }

	 return res;
	 
	 }
	 
	 
	 public ArrayList<BonTransfertForm> inverse(ArrayList<BonTransfertForm> l)
	 {
		 ArrayList<BonTransfertForm> res=new ArrayList<BonTransfertForm>();
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
