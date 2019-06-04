package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import Bean.LaisserPasserForm;;

public class LaisserPasserDao {

	private Logger logger ;
	private Connection con ;
	
	public LaisserPasserDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<LaisserPasserForm> all ()
	   {
		 ArrayList<LaisserPasserForm> l = new  ArrayList<LaisserPasserForm>();
		    
			String sql = "SELECT * FROM lpass order by  num_lp,dat_lp" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	
					 String id_laisser_passer=rs.getString("num_lp");
				     String id_annee=rs.getString("cdexerc");
				     String libelle_annee="";
				     String id_station=rs.getString("codstat");
				     String libelle_station="";
				     String id_vehicule=rs.getString("cdmac");
				     String libelle_vehicule="";
				     String id_agent=rs.getString("decagen");
				     String libelle_agent="";
				     String id_service=rs.getString("cdserv");
				     String libelle_service="";
				     String destination=rs.getString("dest");
				     String date_laisser_passer=inverser(rs.getString("dat_lp").replace("-", "/"),"/");
				     
				     String valide=rs.getString("vld");
				     if(valide.equals("n"))
				     valide="en attente";
				     if(valide.equals("r"))
					     valide="refusé";
				     if(valide.equals("o"))
					     valide="validé";
				     String marchandise_transporte=rs.getString("marchand");
				     String objectif=rs.getString("piece");
					
					 
 LaisserPasserForm	aux=new  LaisserPasserForm( id_laisser_passer,  id_annee,
			 libelle_annee,  id_station,  libelle_station,
			 id_vehicule,  libelle_vehicule,  id_agent,
			 libelle_agent,  id_service,  libelle_service,
			 destination,  date_laisser_passer,  valide,
			 marchandise_transporte,  objectif);




 			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="",sql5="";
	try{

	 sql1= " SELECT * FROM exercice where cdexerc="+id_annee;
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbexerc");
		     if(lib!=null)
		 aux.setLibelle_annee(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM stat_ent where codstat='"+id_station+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("libstat");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_station(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM machine where cdmac='"+id_vehicule+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbmac");
                    	  if(lib!=null)
                    		  l.get(l.size()-1).setLibelle_vehicule(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM agent where decagen="+id_agent;
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("denagen");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_agent(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}


				try{

					 sql5= " SELECT * FROM service where cdserv='"+id_service+"'";
					Statement instruction5 = con.createStatement();
					ResultSet rs5 = instruction5.executeQuery(sql5);
					while(rs5.next())
					{
						 String lib=rs5.getString("lbserv");
						  if(lib!=null)
							  l.get(l.size()-1).setLibelle_service(lib);
					}
					}catch(Exception e5){logger.error(e5+"requete =  "+sql5);}


	                   if(id_station==null)
	                l.get(l.size()-1).setId_service("");
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<LaisserPasserForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }
	 
	 public boolean delete(String id_laisser_passer,String id_exercice)
	 {boolean res=true;
	 String sql="";
	 
	 sql = "delete FROM lpass where  num_lp="+id_laisser_passer+" and cdexerc="+id_exercice ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
		 
	 return res;
	 
	 }
	 
	 public boolean add(LaisserPasserForm frm)
	 {boolean res=true;
	 
	 
	 

	 String id_laisser_passer=frm.getId_laisser_passer().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String id_station="'"+frm.getId_station().replace("'", "''")+"'";
     String id_vehicul="'"+frm.getId_vehicule().replace("'", "''")+"'";
     String id_agent=frm.getId_agent().replace("'", "''");
     String id_service="'"+frm.getId_service().replace("'", "''")+"'";
     String valide="'n'";
     
     
     String destination="'"+frm.getDestination().replace("'", "''")+"'";
     String date_laisser_passer="'"+inverser(frm.getDate_laisser_passer().replace("-", "/"),"/")+"'";

     String marchandise_transporte="'"+frm.getMarchandise_transporte().replace("\n", " ").replace("'", "''")+"'";
     String objectif="'"+frm.getObjectif().replace("'", "''").replace("'", "''").replace("\n", " ")+"'";

 	if(id_station.equals("''"))
		id_station="null";

	 
	 String sql = "	";			
	 sql= "  INSERT INTO lpass( num_lp,cdexerc, codstat, cdmac, decagen,cdserv, vld, dest, dat_lp, marchand, piece)";
	sql=sql+" values ("+id_laisser_passer+","+id_annee+","+id_station+","+id_vehicul+","+id_agent+","+id_service+",";
	sql=sql+valide+","+destination+","+date_laisser_passer+","+marchandise_transporte+","+objectif;
	sql=sql+")";
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
		 
		 
		 sql="UPDATE alert_laisser_passer SET alerte='true'";
		 
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql); 
		 
		 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 public LaisserPasserForm recup (String id_laisser_passer1,String id_annee1)
	   {
		 LaisserPasserForm aux=null;
		   
			String sql = "SELECT * FROM lpass where  num_lp="+id_laisser_passer1+" and cdexerc="+id_annee1;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{

					 String id_laisser_passer=rs.getString("num_lp");
				     String id_annee=rs.getString("cdexerc");
				     String libelle_annee="";
				     String id_station=rs.getString("codstat");
				     String libelle_station="";
				     String id_vehicule=rs.getString("cdmac");
				     String libelle_vehicule="";
				     String id_agent=rs.getString("decagen");
				     String libelle_agent="";
				     String id_service=rs.getString("cdserv");
				     String libelle_service="";
				     String destination=rs.getString("dest");
				     String date_laisser_passer=inverser(rs.getString("dat_lp").replace("-", "/"),"/");

				     String valide=rs.getString("vld");
				     if(valide.equals("n"))
				     valide="en attente";
				     if(valide.equals("r"))
					     valide="refusé";
				     if(valide.equals("o"))
					     valide="validé";
				     String marchandise_transporte=rs.getString("marchand");
				     String objectif=rs.getString("piece");
					
					
     	aux=new  LaisserPasserForm( id_laisser_passer,  id_annee,
			 libelle_annee,  id_station,  libelle_station,
			 id_vehicule,  libelle_vehicule,  id_agent,
			 libelle_agent,  id_service,  libelle_service,
			 destination,  date_laisser_passer,  valide,
			 marchandise_transporte,  objectif);




		






	String sql1="",sql2="",sql3="",sql4="",sql5="";
	try{

	 sql1= " SELECT * FROM exercice where cdexerc="+id_annee;
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbexerc");
		     if(lib!=null)
		 aux.setLibelle_annee(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM stat_ent where codstat='"+id_station+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("libstat");
			  if(lib!=null)
				  aux.setLibelle_station(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM machine where cdmac='"+id_vehicule+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbmac");
                   	  if(lib!=null)
                   		  aux.setLibelle_vehicule(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM agent where decagen="+id_agent;
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("denagen");
					  if(lib!=null)
						 aux.setLibelle_agent(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}


				try{

					 sql5= " SELECT * FROM service where cdserv='"+id_service+"'";
					Statement instruction5 = con.createStatement();
					ResultSet rs5 = instruction5.executeQuery(sql5);
					while(rs5.next())
					{
						 String lib=rs5.getString("lbserv");
						  if(lib!=null)
							  aux.setLibelle_service(lib);
					}
					}catch(Exception e5){logger.error(e5+"requete =  "+sql5);}

					

	                   if(id_station==null)
	                	aux.setId_service("");

					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		  		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(LaisserPasserForm frm)
	 {boolean res=true;
	
	 boolean changer=false;
	 changer=!(recup(frm.getId_laisser_passer(),frm.getId_annee())).getValide().equals("en attente");
	 
	 
	 String sql="";
	 String id_laisser_passer=frm.getId_laisser_passer().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String id_station="'"+frm.getId_station().replace("'", "''")+"'";
     String id_vehicul="'"+frm.getId_vehicule().replace("'", "''")+"'";
     String id_agent=frm.getId_agent().replace("'", "''");
     String id_service="'"+frm.getId_service().replace("'", "''")+"'";
     
     
     String destination="'"+frm.getDestination().replace("'", "''")+"'";
     String date_laisser_passer="'"+inverser(frm.getDate_laisser_passer().replace("-", "/"),"/")+"'";

     String marchandise_transporte="'"+frm.getMarchandise_transporte().replace("\n", " ").replace("'", "''")+"'";
     String objectif="'"+frm.getObjectif().replace("'", "''")+"'";

	if(id_station.equals("''"))
		id_station="null";

     
     
	 sql = "update lpass set ";
	sql=sql+" num_lp="+id_laisser_passer+", cdexerc="+id_annee+", codstat="+id_station+", cdmac="+id_vehicul+", decagen="+id_agent+",cdserv="+id_service+", dest="+destination+",";
	sql=sql+" dat_lp="+date_laisser_passer+", marchand="+marchandise_transporte+",vld='n',piece="+objectif;
    sql=sql+" where  num_lp="+id_laisser_passer+" and cdexerc="+id_annee;
	 
	 
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 if(changer)
		 {
		 sql="UPDATE alert_laisser_passer SET alerte='true'";
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql); 
		 }
		 
		 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
	
	 return res;
	
	 }
	 
	 
	 
	 public boolean valider(LaisserPasserForm frm)
	 {boolean res=true;
	
	 String sql="";
	 String id_laisser_passer=frm.getId_laisser_passer().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String valide="'o'";
     if(  id_laisser_passer!=null)
     	if(!id_laisser_passer.equals("''"))
     		if(!id_laisser_passer.equals(""))
     		{
    

     
	 sql = "update lpass set ";
	sql=sql+"vld="+valide;
    sql=sql+" where  num_lp="+id_laisser_passer+" and cdexerc="+id_annee;
	    System.out.println("lhlklkj"+sql);
	 
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
     		}
	 return res;
	
	 }
	 
	 
	 public boolean refuser(LaisserPasserForm frm)
	 {boolean res=true;
	
	 String sql="";
	 String id_laisser_passer=frm.getId_laisser_passer().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String valide="'r'";
     
    
     if(  id_laisser_passer!=null)
    	if(!id_laisser_passer.equals("''"))
    		if(!id_laisser_passer.equals(""))
    		{
    		
     
	 sql = "update lpass set ";
	sql=sql+"vld="+valide;
    sql=sql+" where  num_lp="+id_laisser_passer+" and cdexerc="+id_annee;
	 

    System.out.println("lhlklkj"+sql);
    
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
    		}
	
	 return res;
	
	 }

	 
	 public ArrayList<LaisserPasserForm>  en_attente()
	   {
		 ArrayList<LaisserPasserForm> l = new  ArrayList<LaisserPasserForm>();
		    
			String sql = "SELECT * FROM lpass where vld='n' order by  num_lp,dat_lp" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	
					 String id_laisser_passer=rs.getString("num_lp");
				     String id_annee=rs.getString("cdexerc");
				     String libelle_annee="";
				     String id_station=rs.getString("codstat");
				     String libelle_station="";
				     String id_vehicule=rs.getString("cdmac");
				     String libelle_vehicule="";
				     String id_agent=rs.getString("decagen");
				     String libelle_agent="";
				     String id_service=rs.getString("cdserv");
				     String libelle_service="";
				     String destination=rs.getString("dest");
				     String date_laisser_passer=inverser(rs.getString("dat_lp").replace("-", "/"),"/");
				     
				     String valide=rs.getString("vld");
				     if(valide.equals("n"))
				     valide="en attente";
				     if(valide.equals("r"))
					     valide="refusé";
				     if(valide.equals("o"))
					     valide="validé";
				     String marchandise_transporte=rs.getString("marchand");
				     String objectif=rs.getString("piece");
					
					 
LaisserPasserForm	aux=new  LaisserPasserForm( id_laisser_passer,  id_annee,
			 libelle_annee,  id_station,  libelle_station,
			 id_vehicule,  libelle_vehicule,  id_agent,
			 libelle_agent,  id_service,  libelle_service,
			 destination,  date_laisser_passer,  valide,
			 marchandise_transporte,  objectif);




			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="",sql5="";
	try{

	 sql1= " SELECT * FROM exercice where cdexerc="+id_annee;
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbexerc");
		     if(lib!=null)
		 aux.setLibelle_annee(lib);
	}
	}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


	try{

		 sql2= " SELECT * FROM stat_ent where codstat='"+id_station+"'";
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
		while(rs2.next())
		{
			  String lib=rs2.getString("libstat");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_station(lib);
		}
		}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





		try{

			 sql3= " SELECT * FROM machine where cdmac='"+id_vehicule+"'";
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
			while(rs3.next())
			{
				  String lib=rs3.getString("lbmac");
                  	  if(lib!=null)
                  		  l.get(l.size()-1).setLibelle_vehicule(lib);
			}
			}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


			try{

				 sql4= " SELECT * FROM agent where decagen="+id_agent;
				Statement instruction4 = con.createStatement();
				ResultSet rs4 = instruction4.executeQuery(sql4);
				while(rs4.next())
				{
					 String lib=rs4.getString("denagen");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_agent(lib);
				}
				}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}


				try{

					 sql5= " SELECT * FROM service where cdserv='"+id_service+"'";
					Statement instruction5 = con.createStatement();
					ResultSet rs5 = instruction5.executeQuery(sql5);
					while(rs5.next())
					{
						 String lib=rs5.getString("lbserv");
						  if(lib!=null)
							  l.get(l.size()-1).setLibelle_service(lib);
					}
					}catch(Exception e5){logger.error(e5+"requete =  "+sql5);}


	                   if(id_station==null)
	                l.get(l.size()-1).setId_service("");
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<LaisserPasserForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }
	 
	 public void annuler_alerte_laisser_passer()
	 {
	 
	 
	
		String sql="UPDATE alert_laisser_passer SET alerte='false'";

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}

	 
	 }
	 
	 public ArrayList<LaisserPasserForm> inverse(ArrayList<LaisserPasserForm> l)
	 {
		 ArrayList<LaisserPasserForm> res=new ArrayList<LaisserPasserForm>();
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
