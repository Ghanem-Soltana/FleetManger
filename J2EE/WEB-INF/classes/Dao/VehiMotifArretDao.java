package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.VehiMotifArretForm;

public class VehiMotifArretDao {

	private Logger logger ;
	private Connection con ;
	
	public VehiMotifArretDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<VehiMotifArretForm> all ()
	   {
		 ArrayList<VehiMotifArretForm> l = new  ArrayList<VehiMotifArretForm>();
		   
			String sql = "SELECT * FROM depot_vehic " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					String date_fin="";
					try{date_fin=inverser(rs.getString("dat_fin").replace("-", "/"),"/");}catch(Exception e){date_fin="";}

l.add(new VehiMotifArretForm(rs.getString("cdmac"),"",rs.getString("cddepot"),"",inverser(rs.getString("dat_deb").replace("-", "/"),"/"),date_fin));
					
						
						String sql2 = "SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'" ;
						Statement instruction2 = con.createStatement();
						ResultSet rs2 = instruction2.executeQuery(sql2);
						while(rs2.next())
						{							
							  String lib=rs2.getString("lbmac");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_vehicule(lib);
								
								
						}
						
						
						String sql3 = "SELECT * FROM motif_depot where cddepot='"+rs.getString("cddepot")+"'" ;
						Statement instruction3 = con.createStatement();
						ResultSet rs3 = instruction3.executeQuery(sql3);
						while(rs3.next())
						{							
							  String lib=rs3.getString("lbdepot");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_arret(lib);
								
								
						}
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiMotifArretForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id_vehicule,String id_arret,String date)
	 {boolean res=true;
	 
	 String sql = "delete FROM depot_vehic where cdmac='"+id_vehicule+"' and cddepot='"+id_arret+"' and dat_deb='"+inverser(date.replace("/", "-"),"-")+"'" ;
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
	 
	 public boolean add(VehiMotifArretForm frm)
	 
	 {boolean res=true;
	 
	 String date_fin="";
	 if(frm.getDate_fin().length()>2)
		 date_fin="'"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"'";
	 else date_fin="null";
	 String sql = "insert into depot_vehic (cdmac,cddepot,dat_deb,dat_fin) values ('"+frm.getId_vehicule().replace("'", "''")+"','"+frm.getId_arret().replace("'", "''")+"','"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"',"+date_fin+")" ;
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
	 
	 public VehiMotifArretForm recup (String id_vehicule,String id_arret,String date)
	   {

		 VehiMotifArretForm  aux= new  VehiMotifArretForm();
		    
			String sql = "SELECT * FROM depot_vehic where cdmac='"+id_vehicule+"' and cddepot='"+id_arret+"' and dat_deb='"+inverser(date.replace("/", "-"),"-")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					String date_fin="";
					try{date_fin=inverser(rs.getString("dat_fin").replace("-", "/"),"/");}catch(Exception e){date_fin="";}

aux=new VehiMotifArretForm(rs.getString("cdmac"),"",rs.getString("cddepot"),"",inverser(rs.getString("dat_deb").replace("-", "/"),"/"),date_fin);
					
						
						String sql2 = "SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'" ;
						Statement instruction2 = con.createStatement();
						ResultSet rs2 = instruction2.executeQuery(sql2);
						while(rs2.next())
						{							
							  String lib=rs2.getString("lbmac");
							  if(lib!=null)
								  aux.setLibelle_vehicule(lib);
								
								
						}
						
						
						String sql3 = "SELECT * FROM motif_depot where cddepot='"+rs.getString("cddepot")+"'" ;
						Statement instruction3 = con.createStatement();
						ResultSet rs3 = instruction3.executeQuery(sql3);
						while(rs3.next())
						{							
							  String lib=rs3.getString("lbdepot");
							  if(lib!=null)
								  aux.setLibelle_arret(lib);
								
								
						}
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		  
	   }
	 
	 
	 public boolean update(String id_vehicule,String id_arret,String date,VehiMotifArretForm frm)
	 {boolean res=true;
	 
	 String date_fin="";
	 if(frm.getDate_fin().length()>2)
		 date_fin="'"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"'";
	 else date_fin="null";
	 
	 String sql = "update depot_vehic set cddepot='"+frm.getId_arret().replace("'", "''")+"',dat_deb='"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"',dat_fin="+date_fin;
	
	 sql=sql+" where cdmac='"+id_vehicule+"' and cddepot='"+id_arret+"' and dat_deb='"+inverser(date.replace("/", "-"),"-")+"'" ;
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
	 
	 
	 public ArrayList<VehiMotifArretForm> inverse(ArrayList<VehiMotifArretForm> l)
	 {
		 ArrayList<VehiMotifArretForm> res=new ArrayList<VehiMotifArretForm>();
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
	 
	 
	 public boolean verfifer_validite_date(VehiMotifArretForm frm)
	 {
		 boolean res=true; 
	      
		 if(!frm.getDate_fin().equals(""))
		 { 
		String sql="select count(*) from depot_vehic "+
       " where  ('"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' between dat_deb and dat_fin "+
       " or '"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"' between dat_deb and dat_fin )"+
       " and cdmac = '"+frm.getId_vehicule()+"'";
		 
		 try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					if (rs.getInt(1) != 0 )
					{
						res = false ;
					}
				}
			}
			catch (Exception e) 
			{res=false;
			logger.error(e+"requete =  "+sql);
			}
		   
			if(res)
			{
			      
				 String sql1="select count(*) from depot_vehic "+
			       " where  (dat_deb  between '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' and  '"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"'"+
			       " or dat_fin between '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' and  '"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"' )"+
			       " and cdmac = '"+frm.getId_vehicule()+"'";
					 
				 try{
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							if (rs1.getInt(1) != 0 )
							{
								res = false ;
							}
						}
					}
					catch (Exception e) 
					{res=false;
					logger.error(e+"requete =  "+sql1);
					}
				   	
				
			}
			
			if(res)
			{
			      
				 String sql1="select count(*) from depot_vehic "+
			       " where  dat_fin is null and dat_deb < '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"'"+ 
			       " and cdmac = '"+frm.getId_vehicule()+"'";
				 
				
					 
				 try{
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							if (rs1.getInt(1) != 0 )
							{
								res = false ;
							}
						}
					}
					catch (Exception e) 
					{res=false;
					logger.error(e+"requete =  "+sql1);
					}
				   	
				
			}
			
			
			
			
			
			}
		 
		 else{
			 
			 String sql1="select count(*) from depot_vehic "+
		       " where dat_fin is null"+
		        " and cdmac = '"+frm.getId_vehicule()+"'";
				 
			 try{
					Statement instruction1 = con.createStatement();
					ResultSet rs1 = instruction1.executeQuery(sql1);
					while(rs1.next())
					{
						if (rs1.getInt(1) != 0 )
						{
							res = false ;
						}
					}
				}
				catch (Exception e) 
				{res=false;
				logger.error(e+"requete =  "+sql1);
				}
			
				
				if(res)
				{
				String sql="select count(*) from depot_vehic "+
			       " where   dat_deb > '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' or dat_fin > '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"'"+
			       " and cdmac = '"+frm.getId_vehicule()+"'";
				
					 try{
							Statement instruction = con.createStatement();
							ResultSet rs = instruction.executeQuery(sql);
							while(rs.next())
							{
								if (rs.getInt(1) != 0 )
								{
									res = false ;
								}
							}
						}
						catch (Exception e) 
						{res=false;
						logger.error(e+"requete =  "+sql);
						}
				}
				
			 
		 }
		 
		 return res;
	 }
	 
	 
	 
	 public boolean verfifer_validite_date_update(VehiMotifArretForm frm,String cdmac,String ancienne_date)
	 {
		 boolean res=true; 
	  
		 if(!frm.getDate_fin().equals(""))
		 { 
		String sql="select count(*) from depot_vehic "+
       " where  ('"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' between dat_deb and dat_fin "+
       " or '"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"' between dat_deb and dat_fin )"+
       " and cdmac = '"+cdmac+"' and dat_deb<>'"+inverser(ancienne_date.replace("/", "-"),"-")+"'";
		 
		 try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					if (rs.getInt(1) != 0 )
					{
						res = false ;
					}
				}
			}
			catch (Exception e) 
			{res=false;
			logger.error(e+"requete =  "+sql);
			}
		   
			if(res)
			{
			      
				 String sql1="select count(*) from depot_vehic "+
			       " where  (dat_deb  between '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' and  '"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"'"+
			       " or dat_fin between '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' and  '"+inverser(frm.getDate_fin().replace("/", "-"),"-")+"' )"+
			       " and cdmac = '"+cdmac+"' and dat_deb<>'"+inverser(ancienne_date.replace("/", "-"),"-")+"'";
					 
				 try{
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							if (rs1.getInt(1) != 0 )
							{
								res = false ;
							}
						}
					}
					catch (Exception e) 
					{res=false;
					logger.error(e+"requete =  "+sql1);
					}
				   	
				
			}
			
			if(res)
			{
			      
				 String sql1="select count(*) from depot_vehic "+
			       " where  dat_fin is null and dat_deb < '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"'"+ 
			       " and cdmac = '"+cdmac+"' and dat_deb<>'"+inverser(ancienne_date.replace("/", "-"),"-")+"'";
				 
				
					 
				 try{
						Statement instruction1 = con.createStatement();
						ResultSet rs1 = instruction1.executeQuery(sql1);
						while(rs1.next())
						{
							if (rs1.getInt(1) != 0 )
							{
								res = false ;
							}
						}
					}
					catch (Exception e) 
					{res=false;
					logger.error(e+"requete =  "+sql1);
					}
				   	
				
			}
			
			
			
			
			
			}
		 
		 else{
			 
			 String sql1="select count(*) from depot_vehic "+
		       " where dat_fin is null"+
		        " and cdmac = '"+cdmac+"' and dat_deb<>'"+inverser(ancienne_date.replace("/", "-"),"-")+"'";
				 
			 try{
					Statement instruction1 = con.createStatement();
					ResultSet rs1 = instruction1.executeQuery(sql1);
					while(rs1.next())
					{
						if (rs1.getInt(1) != 0 )
						{
							res = false ;
						}
					}
				}
				catch (Exception e) 
				{res=false;
				logger.error(e+"requete =  "+sql1);
				}
			
				
				if(res)
				{
				String sql="select count(*) from depot_vehic "+
			       " where   dat_deb > '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"' or dat_fin > '"+inverser(frm.getDate_debut().replace("/", "-"),"-")+"'"+
			       " and cdmac = '"+cdmac+"' and dat_deb<>'"+inverser(ancienne_date.replace("/", "-"),"-")+"'";
				
					 try{
							Statement instruction = con.createStatement();
							ResultSet rs = instruction.executeQuery(sql);
							while(rs.next())
							{
								if (rs.getInt(1) != 0 )
								{
									res = false ;
								}
							}
						}
						catch (Exception e) 
						{res=false;
						logger.error(e+"requete =  "+sql);
						}
				}
				
			 
		 }
		 
		 return res;
	 }
	 
	 
}
