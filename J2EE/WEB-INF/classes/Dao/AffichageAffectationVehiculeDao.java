package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.AffectationVehiculeForm;

public class AffichageAffectationVehiculeDao {

	private Logger logger ;
	private Connection con ;
	
	public AffichageAffectationVehiculeDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	
	 public ArrayList<AffectationVehiculeForm> all ()
	   {
		 ArrayList<AffectationVehiculeForm> l = new  ArrayList<AffectationVehiculeForm>();
		   
			String sql = "SELECT * FROM affec_mac order by deccent,decagenc,cdserv,dat_aff,cdmac " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
								
		l.add(new AffectationVehiculeForm(rs.getString("cdmac"),"",rs.getString("deccent"),"",rs.getString("decagenc"),"",rs.getString("cdserv"),"",inverser(rs.getString("dat_aff").replace("-", "/"),"/")));
					
		
		
		String sql1="",sql2="",sql3="",sql4="";
		try{
		sql1 = " SELECT lbmac FROM machine where cdmac='"+rs.getString("cdmac")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);


		while(rs1.next())
		{
				
			  String lbmachine=rs1.getString("lbmac");
			  if(lbmachine!=null)
				  l.get(l.size()-1).setLibelle_vehicule(lbmachine);

		}		
		}catch(Exception e)
		{logger.error(e+"requete =  "+sql1);}
		
		
		try{
			sql2 = " SELECT delcent FROM centre where deccent='"+rs.getString("deccent")+"'";
			Statement instruction2 = con.createStatement();
			ResultSet rs2 = instruction2.executeQuery(sql2);


			while(rs2.next())
			{
					
				  String lbcentre=rs2.getString("delcent");
				  if(lbcentre!=null)
					  l.get(l.size()-1).setLibelle_centre(lbcentre);

			}		
			}catch(Exception e)
			{logger.error(e+"requete =  "+sql2);}
			
		
		
		
		
			
			try{
				sql3 = " SELECT delagenc FROM agence where deccent='"+rs.getString("deccent")+"' and decagenc='"+rs.getString("decagenc")+"'";
				Statement instruction3 = con.createStatement();
				ResultSet rs3 = instruction3.executeQuery(sql3);


				while(rs3.next())
				{
						
					  String lbagence=rs3.getString("delagenc");
					  if(lbagence!=null)
						  l.get(l.size()-1).setLibelle_agence(lbagence);

				}		
				}catch(Exception e)
				{logger.error(e+"requete =  "+sql3);}
		
		
		
		
		
				try{
					sql4 = " SELECT lbserv FROM service where deccent='"+rs.getString("deccent")+"' and decagenc='"+rs.getString("decagenc")+"' and cdserv='"+rs.getString("cdserv")+"'";
					Statement instruction4 = con.createStatement();
					ResultSet rs4 = instruction4.executeQuery(sql4);


					while(rs4.next())
					{
							
						  String lbservice=rs4.getString("lbserv");
						  if(lbservice!=null)
							  l.get(l.size()-1).setLibelle_service(lbservice);

					}		
					}catch(Exception e)
					{logger.error(e+"requete =  "+sql4);}
			
			
		
		
		
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<AffectationVehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	
	 
	 public ArrayList<AffectationVehiculeForm> select (AffectationVehiculeForm afficher)
	   {
		 ArrayList<AffectationVehiculeForm> l = new  ArrayList<AffectationVehiculeForm>();
		   
		 String and="";
		 String condition1="";
		 String condition2="";
		 
		 if(afficher.getId_agence().equals("xxxxxx")&&afficher.getId_centre().equals("xxxxxx"))
			 return all();
		 else{
		 
		 if(!afficher.getId_centre().equals("xxxxxx"))
			 condition1="deccent='"+afficher.getId_centre()+"'";
		 else condition1="";
		 
		 if(!afficher.getId_agence().equals("xxxxxx"))
			 condition2="decagenc='"+afficher.getId_agence()+"'";
		 else
			 condition2="";
		 
		 if(!afficher.getId_agence().equals("xxxxxx")&&!afficher.getId_centre().equals("xxxxxx"))
			 and=" and ";
		 else and="";
		 
		 
		 
		 
			String sql = "SELECT * FROM affec_mac where "+condition1+and+condition2+" order by deccent,decagenc,cdserv,dat_aff,cdmac  " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
								
		l.add(new AffectationVehiculeForm(rs.getString("cdmac"),"",rs.getString("deccent"),"",rs.getString("decagenc"),"",rs.getString("cdserv"),"",inverser(rs.getString("dat_aff").replace("-", "/"),"/")));
					
		
		
		String sql1="",sql2="",sql3="",sql4="";
		try{
		sql1 = " SELECT lbmac FROM machine where cdmac='"+rs.getString("cdmac")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);


		while(rs1.next())
		{
				
			  String lbmachine=rs1.getString("lbmac");
			  if(lbmachine!=null)
				  l.get(l.size()-1).setLibelle_vehicule(lbmachine);

		}		
		}catch(Exception e)
		{logger.error(e+"requete =  "+sql1);}
		
		
		try{
			sql2 = " SELECT delcent FROM centre where deccent='"+rs.getString("deccent")+"'";
			Statement instruction2 = con.createStatement();
			ResultSet rs2 = instruction2.executeQuery(sql2);


			while(rs2.next())
			{
					
				  String lbcentre=rs2.getString("delcent");
				  if(lbcentre!=null)
					  l.get(l.size()-1).setLibelle_centre(lbcentre);

			}		
			}catch(Exception e)
			{logger.error(e+"requete =  "+sql2);}
			
		
		
		
		
			
			try{
				sql3 = " SELECT delagenc FROM agence where deccent='"+rs.getString("deccent")+"' and decagenc='"+rs.getString("decagenc")+"'";
				Statement instruction3 = con.createStatement();
				ResultSet rs3 = instruction3.executeQuery(sql3);


				while(rs3.next())
				{
						
					  String lbagence=rs3.getString("delagenc");
					  if(lbagence!=null)
						  l.get(l.size()-1).setLibelle_agence(lbagence);

				}		
				}catch(Exception e)
				{logger.error(e+"requete =  "+sql3);}
		
		
		
		
		
				try{
					sql4 = " SELECT lbserv FROM service where deccent='"+rs.getString("deccent")+"' and decagenc='"+rs.getString("decagenc")+"' and cdserv='"+rs.getString("cdserv")+"'";
					Statement instruction4 = con.createStatement();
					ResultSet rs4 = instruction4.executeQuery(sql4);


					while(rs4.next())
					{
							
						  String lbservice=rs4.getString("lbserv");
						  if(lbservice!=null)
							  l.get(l.size()-1).setLibelle_service(lbservice);

					}		
					}catch(Exception e)
					{logger.error(e+"requete =  "+sql4);}
			
			
		
		
		
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<AffectationVehiculeForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;}
		   
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
