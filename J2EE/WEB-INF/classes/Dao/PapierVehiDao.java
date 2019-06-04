package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import Action.Dates;
import Bean.PapierVehiForm;
public class PapierVehiDao {
	
	private Logger logger ;
	private Connection con ;
	
	public PapierVehiDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<PapierVehiForm> all ()
	   {
		 ArrayList<PapierVehiForm> l = new  ArrayList<PapierVehiForm>();
		   
			String sql = "SELECT * FROM pce_mac";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{		  	
					
					String date="";
					String date1="";
					String date2="";
					try{date=inverser(rs.getString("datdebv").replace("-", "/"),"/");}catch(Exception e){date="";}
					try{date1=inverser(rs.getString("datfinv").replace("-", "/"),"/");}catch(Exception e){date1="";}
					try{date2=inverser(rs.getString("datsusp").replace("-", "/"),"/");}catch(Exception e){date2="";}
 l.add(new PapierVehiForm(rs.getString("cdmac"),"",rs.getString("cdtyppc"),"",inverser(rs.getString("datpce").replace("-", "/"),"/"),date,date1,date2));				
 String sql1 = " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);


	while(rs1.next())
	{
			
		  String lbmachine=rs1.getString("lbmac");
		  if(lbmachine!=null)
			  l.get(l.size()-1).setLibelle_vehicule(lbmachine);

	}		

	
	   String sql2 = " SELECT * FROM typ_pce where cdtyppc='"+rs.getString("cdtyppc")+"'";;
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
	

		while(rs2.next())
		{
				
			  String lb=rs2.getString("lbtyppc");
			  if(lb!=null)
				  l.get(l.size()-1).setLibelle_type_papier(lb);
	
		}		
				
				}
				
				
			}

 
				catch (Exception e) 
			{l=new  ArrayList<PapierVehiForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }

	 
	 
	 
	 public boolean add(PapierVehiForm frm)
	 {boolean res=true;	 
	 String date_debut="";
	 if(frm.getDate_debut_validation().length()>2)
		 date_debut="'"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"'";
	 else date_debut="null";

	 String date_fin="";
	 if(frm.getDate_fin_validation().length()>2)
		 date_fin="'"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"'";
	 else date_fin="null";
	 
	 String date_annulation="";
	 if(frm.getDate_annulation().length()>2)
		 date_annulation="'"+inverser(frm.getDate_annulation().replace("/", "-"),"-")+"'";
	 else date_annulation="null";
	
	 String sql = "INSERT INTO pce_mac(cdmac,cdtyppc,datpce,datdebv,datfinv,datsusp) values ('"+frm.getId_vehicule().replace("'", "''")+"','"+frm.getId_type_papier().replace("'", "''")+"','"+inverser(frm.getDate_papier().replace("/", "-"),"-")+"',"+date_debut+","+date_fin+","+date_annulation+")" ;
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
	 
	 
	 
	 
	 
	 public PapierVehiForm recup (String id, String id2, String id3)
	   {
		 PapierVehiForm aux=new PapierVehiForm();;
		   
			String sql = "SELECT * FROM pce_mac where cdmac='"+id+"'" +" and cdtyppc='"+id2+"'" +" and datpce='"+inverser(id3.replace("/", "-"),"-")+"'" ;
		
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
					
					
					String date="";
					String date1="";
					String date2="";
					try{date=inverser(rs.getString("datdebv").replace("-", "/"),"/");}catch(Exception e){date="";}
					try{date1=inverser(rs.getString("datfinv").replace("-", "/"),"/");}catch(Exception e){date1="";}
					try{date2=inverser(rs.getString("datsusp").replace("-", "/"),"/");}catch(Exception e){date2="";}
					
	aux=new PapierVehiForm(rs.getString("cdmac"),"",rs.getString("cdtyppc"),"",inverser(rs.getString("datpce").replace("-", "/"),"/"),date,date1,date2);
	
	
	   String sql1 = " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
	

		while(rs1.next())
		{
				
			  String lbvehicule=rs1.getString("lbmac");
			  if(lbvehicule!=null)
				  aux.setLibelle_vehicule(lbvehicule);
	
		}		

		
		   String sql2 = " SELECT * FROM typ_pce where cdtyppc='"+rs.getString("cdtyppc")+"'";;
			Statement instruction2 = con.createStatement();
			ResultSet rs2 = instruction2.executeQuery(sql2);
		

			while(rs2.next())
			{
					
				  String lb=rs2.getString("lbtyppc");
				  if(lb!=null)
					  aux.setLibelle_type_papier(lb);
		
			}		
				  
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
		
			}
		   return aux ;
		   
	   }
	 
	 
	 
	 
	 
	 
	 public boolean delete(String id,String id2, String id3)
	 {boolean res=true;
	 
	 String sql = "delete FROM  pce_mac where cdmac='"+id.replace("\"", "\"\"")+"'" +" and cdtyppc='"+id2.replace("\"", "\"\"")+"'" +" and datpce='"+inverser(id3.replace("/", "-"),"-")+"'" ;
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
	 
	 
	 
	 
	 
	 

	 public boolean update(PapierVehiForm frm)
	 {boolean res=true;
 
	 String date_debut="";
	 if(frm.getDate_debut_validation().length()>2)
		 date_debut="'"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"'";
	 else date_debut="null";

	 String date_fin="";
	 if(frm.getDate_fin_validation().length()>2)
		 date_fin="'"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"'";
	 else date_fin="null";
	 
	 String date_annulation="";
	 if(frm.getDate_annulation().length()>2)
		 date_annulation="'"+inverser(frm.getDate_annulation().replace("/", "-"),"-")+"'";
	 else date_annulation="null";
	

							

	 String sql=" UPDATE pce_mac SET ";
	 sql=  sql+" datdebv="+date_debut+", datfinv="+date_fin+", datsusp="+date_annulation;
	 sql=  sql+" WHERE cdmac='"+frm.getId_vehicule().replace("'", "''")+"' and cdtyppc='"+frm.getId_type_papier()+"' and datpce='"+inverser(frm.getDate_papier().replace("/", "-"),"-")+"'";

	 
	 
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


	 
	 
	 
	 
	 
	 
	 
	 public ArrayList<PapierVehiForm> inverse(ArrayList<PapierVehiForm> l)
	 {
		 ArrayList<PapierVehiForm> res=new ArrayList<PapierVehiForm>();
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
	 
	 
	 public boolean verfifer_validite_date(PapierVehiForm frm)
	 {
		 boolean res=true; 
	      
		 String sql="select count(*) from pce_mac "+
       " where  ('"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"' between datdebv and datfinv "+
       " or '"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"' between datdebv and datfinv )"+
       " and cdmac = '"+frm.getId_vehicule()+"' and cdtyppc='"+frm.getId_type_papier()+"'";
		 
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
			      
				 String sql1="select count(*) from pce_mac "+
			       " where  (datdebv  between '"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"' and  '"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"'"+
			       " or datfinv between '"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"' and  '"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"' )"+
			       " and cdmac = '"+frm.getId_vehicule()+"' and cdtyppc='"+frm.getId_type_papier()+"' ";
					 
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
		 
		 return res;
	 }
	 
	 
	 
	 public boolean verfifer_validite_date_update(PapierVehiForm frm)
	 {
		 boolean res=true; 
	      
		 String sql="select count(*) from pce_mac "+
       " where  ('"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"' between datdebv and datfinv "+
       " or '"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"' between datdebv and datfinv )"+
       " and cdmac = '"+frm.getId_vehicule()+"' and cdtyppc='"+frm.getId_type_papier()+"' and datpce<>'"+inverser(frm.getDate_papier().replace("/", "-"),"-")+"'";
		 
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
			 String sql1="select count(*) from pce_mac "+
		       " where (datdebv between  '"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"' and '"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"' "+
		       " or datfinv  between '"+inverser(frm.getDate_debut_validation().replace("/", "-"),"-")+"' and '"+inverser(frm.getDate_fin_validation().replace("/", "-"),"-")+"' )"+
		       " and cdmac = '"+frm.getId_vehicule()+"' and cdtyppc='"+frm.getId_type_papier()+"' and datpce<>'"+inverser(frm.getDate_papier().replace("/", "-"),"-")+"'";
				 
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
	
			
			
			
			
		 return res;
	 }
	 
	 
	 
	


	 public ArrayList<PapierVehiForm> papiersreccents ()
	   {
		 ArrayList<PapierVehiForm> l = new  ArrayList<PapierVehiForm>();
		   
			String sql = " select machine.cdmac,datpce,datdebv,datfinv,pce_mac.cdtyppc"+
	  " from machine,pce_mac ,typ_pce"+
	  " where "+
	  " pce_mac.cdmac=machine.cdmac"+
	  " and typ_pce.cdtyppc=pce_mac.cdtyppc"+
	  " and datfinv= (select max(datfinv)"+
	  "              from pce_mac x"+
	  "             where x.cdmac=machine.cdmac"+  
	  "             and typ_pce.cdtyppc=x.cdtyppc)" ;
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{		  	
					
					String date="";
					String date1="";
					String date2="";
					try{date=inverser(rs.getString("datdebv").replace("-", "/"),"/");}catch(Exception e){date="";}
					try{date1=inverser(rs.getString("datfinv").replace("-", "/"),"/");}catch(Exception e){date1="";}
					try{date2=inverser(rs.getString("datsusp").replace("-", "/"),"/");}catch(Exception e){date2="";}
l.add(new PapierVehiForm(rs.getString("cdmac"),"",rs.getString("cdtyppc"),"",inverser(rs.getString("datpce").replace("-", "/"),"/"),date,date1,date2));				
String sql1 = " SELECT * FROM machine where cdmac='"+rs.getString("cdmac")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);


	while(rs1.next())
	{
			
		  String lbmachine=rs1.getString("lbmac");
		  if(lbmachine!=null)
			  l.get(l.size()-1).setLibelle_vehicule(lbmachine);

	}		

	
	   String sql2 = " SELECT * FROM typ_pce where cdtyppc='"+rs.getString("cdtyppc")+"'";;
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
	

		while(rs2.next())
		{
				
			  String lb=rs2.getString("lbtyppc");
			  if(lb!=null)
				  l.get(l.size()-1).setLibelle_type_papier(lb);
	
		}		
				
				}
				
				
			}


				catch (Exception e) 
			{l=new  ArrayList<PapierVehiForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }




public boolean notifier()
	{boolean res=false;
	ArrayList<PapierVehiForm> l=new ArrayList<PapierVehiForm>();
	   l=papiersreccents();
	   java.util.Date l_date = new java.util.Date(System.currentTimeMillis());
	   String l_stFormatDate = new String("dd/MM/yyyy");
	   DateFormat l_formatDate = new SimpleDateFormat(l_stFormatDate, java.util.Locale.FRENCH);
	   Dates mnt=new Dates(l_formatDate.format(l_date));

	
	
	for(int i=0;i<l.size()&&res==false;i++)
	{
	Dates fin=new Dates(l.get(i).getDate_fin_validation());
	if(fin.diff(mnt)<=14 && fin.sup(mnt))
		res=true;
	}
	return res;
	}


}
