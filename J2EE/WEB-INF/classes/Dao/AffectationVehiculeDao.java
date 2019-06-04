package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.AffectationVehiculeForm;

public class AffectationVehiculeDao {

	private Logger logger ;
	private Connection con ;
	
	public AffectationVehiculeDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	
	 public ArrayList<AffectationVehiculeForm> all ()
	   {
		 ArrayList<AffectationVehiculeForm> l = new  ArrayList<AffectationVehiculeForm>();
		   
			String sql = "SELECT * FROM affec_mac" ;
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
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id_vehicule,String id_service,String date_aff)
	 {boolean res=true;

	 String sql = "delete FROM affec_mac where   cdmac='"+id_vehicule.replace("\"", "\"\"")+"' and  cdserv='"+id_service.replace("\"", "\"\"")+"' and dat_aff='"+inverser(date_aff.replace("/", "-"),"-")+"'" ;
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
	 
	 public boolean add(AffectationVehiculeForm frm)
	 {boolean res=true;
	 String sql="";
	 
	 
sql = "INSERT INTO affec_mac(cdmac, deccent, decagenc, cdserv, dat_aff) values ('"+frm.getId_vehicule().replace("'", "''")+"','"+frm.getId_centre().replace("'", "''")+"'" ;
sql=sql+ ",'"+frm.getId_agence().replace("'", "''")+"','"+frm.getId_service().replace("'", "''")+"','"+inverser(frm.getDate_affectation().replace("/", "-"),"-")+"'";
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
	 
	 
	 public AffectationVehiculeForm recup (String id_vehicule,String id_service,String date_aff)
	   {
		 AffectationVehiculeForm aux=null;
		   

			String sql = "SELECT * FROM affec_mac where  cdmac='"+id_vehicule.replace("\"", "\"\"")+"' and  cdserv='"+id_service.replace("\"", "\"\"")+"' and dat_aff='"+inverser(date_aff.replace("/", "-"),"-")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
								
		aux=new AffectationVehiculeForm(rs.getString("cdmac"),"",rs.getString("deccent"),"",rs.getString("decagenc"),"",rs.getString("cdserv"),"",inverser(rs.getString("dat_aff").replace("-", "/"),"/"));
					
		
		
		String sql1="",sql2="",sql3="",sql4="";
		try{
		sql1 = " SELECT lbmac FROM machine where cdmac='"+rs.getString("cdmac")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);


		while(rs1.next())
		{
				
			  String lbmachine=rs1.getString("lbmac");
			  if(lbmachine!=null)
				  aux.setLibelle_vehicule(lbmachine);

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
					  aux.setLibelle_centre(lbcentre);

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
						  aux.setLibelle_agence(lbagence);

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
							  aux.setLibelle_service(lbservice);

					}		
					}catch(Exception e)
					{logger.error(e+"requete =  "+sql4);}
				
				}
				
			}
					catch (Exception e) 
					{aux=null;
					logger.error(e+"requete =  "+sql);
					}
		
		   
		   return aux ;
		   
	   }
	 
	 public boolean update(String id_vehicule,String id_service,String date_aff,AffectationVehiculeForm frm)
	 {
		 
		 boolean res=true;
		 
		  String sql = "update affec_mac set deccent='"+frm.getId_centre().replace("'", "''")+"'";
		 sql=sql+" ,decagenc='"+frm.getId_agence().replace("'", "''")+"',cdserv='"+frm.getId_service().replace("'", "''")+"',dat_aff='"+inverser(frm.getDate_affectation().replace("/", "-"),"-")+"'";
		 sql=sql+" where  cdmac='"+id_vehicule.replace("\"", "\"\"")+"' and  cdserv='"+id_service.replace("\"", "\"\"")+"' and dat_aff='"+inverser(date_aff.replace("/", "-"),"-")+"'" ;
		 
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
	 
	 

	 
	 
	 public ArrayList<AffectationVehiculeForm> inverse(ArrayList<AffectationVehiculeForm> l)
	 {
		 ArrayList<AffectationVehiculeForm> res=new ArrayList<AffectationVehiculeForm>();
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
