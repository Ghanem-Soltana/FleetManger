package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.VehiEntrerCarburantForm;

public class VehiEntrerCarburantDao {

	private Logger logger ;
	private Connection con ;
	
	public VehiEntrerCarburantDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<VehiEntrerCarburantForm> all ()
	   {
		 ArrayList<VehiEntrerCarburantForm> l = new  ArrayList<VehiEntrerCarburantForm>();
		   
			String sql = "SELECT * FROM ent_bon" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					String date_entrer="";
					date_entrer=inverser(rs.getString("dat_ent").replace("-", "/"),"/");
					String valide=rs.getString("vld");
					if(valide.equals("n"))
					   valide="en attente";
					if(valide.equals("o"))
					   valide="validé";
					if(valide.equals("r"))
					   valide.equals("refusé");
					
						l.add(new VehiEntrerCarburantForm(rs.getString("cdexerc"),"",rs.getString("num_ent"),date_entrer,rs.getString("cdtypbon"),"",rs.getString("cdmag"),"",rs.getString("decagen"),"",valide,rs.getString("comm"),rs.getString("finiss"),rs.getString("serie")));
					
						
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
								  l.get(l.size()-1).setLibelle_agent(lib);
								
								
						}		
				
						String sql5 = "SELECT * FROM typ_bon where cdtypbon='"+rs.getString("cdtypbon")+"'" ;
						Statement instruction5 = con.createStatement();
						ResultSet rs5 = instruction5.executeQuery(sql5);
						while(rs5.next())
						{							
							  String lib=rs5.getString("lbtypbon");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_type_bon(lib);
								
								
						}		
						
						
						
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiEntrerCarburantForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id_bon,String id_exercice,String id_mag)
	 {boolean res=true;
	 

	 String sql = "delete FROM det_entbon where num_ent='"+id_bon.replace("'", "''")+"'and cdexerc='"+id_exercice.replace("'", "''")+"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 
	  sql = "delete FROM ent_bon where num_ent='"+id_bon.replace("'", "''")+"'and cdexerc='"+id_exercice.replace("'", "''")+"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
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
	 
	 public boolean add(VehiEntrerCarburantForm frm)
	 {boolean res=true;
	 
	 String sql = "insert into ent_bon (cdexerc,num_ent,cdmag,dat_ent,decagen,vld,cdtypbon,comm,finiss,serie) values ("+frm.getId_exercice().replace("'", "''")+
	 ","+frm.getId_bon()+
	 ",'"+frm.getId_magasin().replace("'", "''")+
	 "','"+inverser(frm.getDate_entrer().replace("/","-"),"-")+"','"+frm.getId_agent().replace("'", "''")+"','n','"+
	 frm.getId_type_bon().replace("'", "''")+
	 "',"+frm.getDebut_bon()+
	 ","+frm.getFin_bon()+
	 ",'"+frm.getReference().replace("'", "''")+"' )" ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 this.alerter();
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 //les details
	
	 
	 if(res)
	 {
		 int debut=Integer.parseInt(frm.getDebut_bon());
		 int fin=Integer.parseInt(frm.getFin_bon());
		 for(int i=debut;i<=fin;i++)
		 {
		  sql = "insert into det_entbon (cdexerc,num_ent,cdmag,num_bon) values ("+
		 frm.getId_exercice().replace("'", "''")+
		 ","+frm.getId_bon()+
		 ",'"+frm.getId_magasin().replace("'", "''")+
		 "',"+ i
		 
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
	 
	 public VehiEntrerCarburantForm recup (String id_bon,String id_exercice,String id_mag)
	   {
		 VehiEntrerCarburantForm aux= null ;
		  
			String sql = "SELECT * FROM ent_bon where num_ent='"+id_bon.replace("'", "''")+
			"'and cdexerc='"+id_exercice.replace("'", "''")+
			"'and cdmag='"+id_mag.replace("'", "''")+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
					
					
				{	String date_entrer="";
				date_entrer=inverser(rs.getString("dat_ent").replace("-", "/"),"/");

				String valide=rs.getString("vld");
				if(valide.equals("n"))
				   valide="en attente";
				if(valide.equals("o"))
				   valide="validé";
				if(valide.equals("r"))
				   valide.equals("refusé");
				
				aux=new VehiEntrerCarburantForm(rs.getString("cdexerc"),"",rs.getString("num_ent"),date_entrer,rs.getString("cdtypbon"),"",rs.getString("cdmag"),"",rs.getString("decagen"),"",valide,rs.getString("comm"),rs.getString("finiss"),rs.getString("serie"));
				
						
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
								  aux.setLibelle_agent(lib);
								
								
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
	 
	 
	 public boolean update(VehiEntrerCarburantForm frm)
	 {boolean res=true;
	 

		 String  valide=frm.getVld(),sql;

		 System.out.println("valide= "+frm.getVld());

	if(valide.equals("en attente"))

    sql = "update ent_bon set dat_ent='"
		 +inverser(frm.getDate_entrer().replace("/", "-"),"-")+
	 "',decagen="+frm.getId_agent()+
	 ",cdtypbon="+frm.getId_type_bon().replace("'", "''")+
	 ", comm="+frm.getDebut_bon()+", finiss="+frm.getFin_bon()+",serie='"+frm.getReference().replace("'", "''")+
	 "' where num_ent="+frm.getId_bon()+" and cdexerc="+frm.getId_exercice().replace("'", "''")+" and cdmag='"+frm.getId_magasin().replace("'", "''")+"'" ;
	
    
	
    else 
	
		 sql = "update ent_bon set dat_ent='"
			 +inverser(frm.getDate_entrer().replace("/", "-"),"-")+
		 "',decagen="+frm.getId_agent()+
		 ",cdtypbon="+frm.getId_type_bon().replace("'", "''")+
		 ", comm="+frm.getDebut_bon()+", finiss="+frm.getFin_bon()+",vld='n',serie='"+frm.getReference().replace("'", "''")+
		 "' where num_ent="+frm.getId_bon()+" and cdexerc="+frm.getId_exercice().replace("'", "''")+" and cdmag='"+frm.getId_magasin().replace("'", "''")+"'" ;
		
	try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql);
		if(!valide.equals("en attente"))
		 this.alerter();
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 
	 if(res)
	 { 

		 sql = "delete FROM det_entbon where num_ent='"+frm.getId_bon().replace("'", "''")+"'and cdexerc='"+frm.getId_exercice().replace("'", "''")+"'and cdmag='"+frm.getId_magasin().replace("'", "''")+"'" ;
		 try{
			 Statement instruction = con.createStatement();
			 instruction.executeUpdate(sql); 
		 }
		 catch(Exception e)
		 {
		 logger.error(e+"requete =  "+sql);
		 }
		 
		 int debut=Integer.parseInt(frm.getDebut_bon());
		 int fin=Integer.parseInt(frm.getFin_bon());
		 for(int i=debut;i<=fin;i++)
		 {
		  sql = "insert into det_entbon (cdexerc,num_ent,cdmag,num_bon) values ("+
		 frm.getId_exercice().replace("'", "''")+
		 ","+frm.getId_bon()+
		 ",'"+frm.getId_magasin().replace("'", "''")+
		 "',"+ i
		 
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
	 
	 
	 public ArrayList<VehiEntrerCarburantForm> inverse(ArrayList<VehiEntrerCarburantForm> l)
	 {
		 ArrayList<VehiEntrerCarburantForm> res=new ArrayList<VehiEntrerCarburantForm>();
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
	 
	 
	 
	 public boolean verfifer_validite_bon(VehiEntrerCarburantForm frm)
	 {
		 boolean res=true; 
	      
		 String sql="select count(*) from ent_bon "+
       " where serie='"+frm.getReference()+"' and ( "+frm.getDebut_bon()+"  between comm and finiss "+
       " or "+frm.getFin_bon()+" between comm and finiss )";
		 
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
				   
				 String sql1="select count(*) from ent_bon "+
		       " where serie='"+frm.getReference()+"' and (comm between "+frm.getDebut_bon()+" and "+frm.getFin_bon()+" "+
		       " or finiss between  "+frm.getDebut_bon()+" and "+frm.getFin_bon()+" )";
		
				 
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
	 
	 
	 public void valider(VehiEntrerCarburantForm frm)
	 {

		  String  sql = "update ent_bon set vld='o'"+
					 " where num_ent="+frm.getId_bon()+
					 " and cdexerc="+frm.getId_exercice().replace("'", "''")+
					 " and cdmag='"+frm.getId_magasin().replace("'", "''")+"'" ;
	
			 try{
				 Statement instruction = con.createStatement();
				 instruction.executeUpdate(sql); 
			 }
			 catch(Exception e)
			 { logger.error(e+"requete =  "+sql); }
	 }
	 
	 public void refuser(VehiEntrerCarburantForm frm)
	 {

		  String  sql = "update ent_bon set vld='r'"+
					 " where num_ent="+frm.getId_bon()+" and cdexerc="+frm.getId_exercice().replace("'", "''")+" and cdmag='"+frm.getId_magasin().replace("'", "''")+"'" ;
	
			 try{
				 Statement instruction = con.createStatement();
				 instruction.executeUpdate(sql); 
			 }
			 catch(Exception e)
			 { logger.error(e+"requete =  "+sql); }
	 }
	 
	 
	 public ArrayList<VehiEntrerCarburantForm> en_attente()
	   {
		 ArrayList<VehiEntrerCarburantForm> l = new  ArrayList<VehiEntrerCarburantForm>();
		   
			String sql = "SELECT * FROM ent_bon where vld='n' order by num_ent,cdexerc,cdmag" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					String date_entrer="";
					date_entrer=inverser(rs.getString("dat_ent").replace("-", "/"),"/");
					String valide=rs.getString("vld");
					if(valide.equals("n"))
					   valide="en attente";
					if(valide.equals("n"))
					   valide="validé";
					if(valide.equals("r"))
					   valide.equals("refusé");
					
						l.add(new VehiEntrerCarburantForm(rs.getString("cdexerc"),"",rs.getString("num_ent"),date_entrer,rs.getString("cdtypbon"),"",rs.getString("cdmag"),"",rs.getString("decagen"),"",valide,rs.getString("comm"),rs.getString("finiss"),rs.getString("serie")));
					
						
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
								  l.get(l.size()-1).setLibelle_agent(lib);
								
								
						}		
				
						String sql5 = "SELECT * FROM typ_bon where cdtypbon='"+rs.getString("cdtypbon")+"'" ;
						Statement instruction5 = con.createStatement();
						ResultSet rs5 = instruction5.executeQuery(sql5);
						while(rs5.next())
						{							
							  String lib=rs5.getString("lbtypbon");
							  if(lib!=null)
								  l.get(l.size()-1).setLibelle_type_bon(lib);
								
								
						}		
						
						
						
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<VehiEntrerCarburantForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 
	 public void annuler_alerte_entree_bon()
	 {
	 
	 
	
		String sql="UPDATE alerte_entree_bon SET alerte='false'";

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 }
	 
	 public void alerter()
	 {
	 
	 
	
		String sql="UPDATE alerte_entree_bon SET alerte='true'";

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 }
}
