package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.AgentForm;
import Bean.OrdreMissionForm;;

public class OrdreMissionDao {

	private Logger logger ;
	private Connection con ;
	
	public OrdreMissionDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<OrdreMissionForm> all ()
	   {
		 ArrayList<OrdreMissionForm> l = new  ArrayList<OrdreMissionForm>();
		    
			String sql = "SELECT * FROM ord_miss order by  num_ord,dat_miss" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	
					 String id_ordre_mission=rs.getString("num_ord");
				     String id_annee=rs.getString("cdexerc");
				     String libelle_annee="";
				     String id_station=rs.getString("codstat");
				     String libelle_station="";
				     String id_vehicule=rs.getString("cdmac");
				     String libelle_vehicule="";
				     String id_agent=rs.getString("decagen");
				     String libelle_agent="";
				     String depart=rs.getString("lieu_dep");
				     String destination=rs.getString("lieu_miss");
				     String date_ordre_mission=inverser(rs.getString("dat_miss").replace("-", "/"),"/");
				     
				     String valide=rs.getString("vld");
				     if(valide.equals("n"))
				     valide="en attente";
				     if(valide.equals("r"))
					     valide="refusé";
				     if(valide.equals("o"))
					     valide="validé";
				     String marchandise_transporte=rs.getString("marchand");
				     String objectif=rs.getString("obj_miss");
				     String remarque=rs.getString("observ");
					
					 
 OrdreMissionForm	aux=new  OrdreMissionForm( id_ordre_mission,  id_annee,
			 libelle_annee,  id_station,libelle_station,
			 id_vehicule,  libelle_vehicule,  id_agent,
			 libelle_agent,  depart,  destination,
			 date_ordre_mission,  valide,
			 marchandise_transporte,  objectif,  remarque);

            lienagent(aux);


 			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="";
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


			


	              
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<OrdreMissionForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		   return l ;
		   
	   }
	 
	 public boolean delete(String id_ordre_mission,String id_exercice)
	 {boolean res=true;
	 String sql="";
	 
	 sql = "delete FROM accomp where  num_ord="+id_ordre_mission+" and cdexerc="+id_exercice ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
	 sql = "delete FROM ord_miss where  num_ord="+id_ordre_mission+" and cdexerc="+id_exercice ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
		 
	 return res;
	 
	 }
	 
	 public boolean add(OrdreMissionForm frm)
	 {boolean res=true;
	 
	 
	 

	 String id_ordre_mission=frm.getId_ordre_mission().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String id_station="'"+frm.getId_station().replace("'", "''")+"'";
     String id_vehicul="'"+frm.getId_vehicule().replace("'", "''")+"'";
     String id_agent=frm.getId_agent().replace("'", "''");
     String valide="'n'";
     String depart="'"+frm.getDepart().replace("'", "''")+"'";
     String destination="'"+frm.getDestination().replace("'", "''")+"'";
     String date_ordre_mission="'"+inverser(frm.getDate_ordre_mission().replace("-", "/"),"/")+"'";
     String marchandise_transporte="'"+frm.getMarchandise_transporte().replace("\n", " ")+"'";
     String objectif="'"+frm.getObjectif().replace("'", "''").replace("'", "''").replace("\n", " ")+"'";
     String remarque="'"+frm.getRemarque().replace("'", "''").replace("'", "''")+"'";
     if(id_station.equals("''"))
 		id_station="null";
	 
	 String sql = "	";			
	 sql= " INSERT INTO ord_miss(num_ord,cdexerc, codstat, cdmac,  decagen, vld, lieu_dep, lieu_miss, dat_miss, marchand, obj_miss, observ)";
	sql=sql+" values ("+id_ordre_mission+","+id_annee+","+id_station+","+id_vehicul+","+id_agent+",";
	sql=sql+valide+","+depart+","+destination+","+date_ordre_mission+","+marchandise_transporte+","+objectif+","+remarque;
	sql=sql+")";
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
		 String ch=frm.getAccompagant();
		 String tab[]=decouper(ch,'$');
		
	    
		 for(int i=0;i<tab.length;i++)
		 try{if(!tab[i].equals(frm.getId_agent()))
			 {sql="insert into accomp(cdexerc,num_ord,decagen) VALUES ("+frm.getId_annee()+","+frm.getId_ordre_mission()+","+tab[i]+")";
			 Statement instruction1 = con.createStatement();
			 instruction1.executeUpdate(sql); 
		 }}
		 catch(Exception e){System.out.println(e);}
	
		 
		 
		 
		 sql="UPDATE alert_ordre_mission SET alerte='true'";
		 
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql); 
		 
		 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 return res;
	 
	 }
	 
	 public OrdreMissionForm recup (String id_ordre_mission1,String id_annee1)
	   {
		 OrdreMissionForm aux=null;
		   
		 
			String sql = "SELECT * FROM ord_miss where num_ord='"+id_ordre_mission1+"' and cdexerc='"+id_annee1+"' order by  num_ord,dat_miss" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	
					 String id_ordre_mission=rs.getString("num_ord");
				     String id_annee=rs.getString("cdexerc");
				     String libelle_annee="";
				     String id_station=rs.getString("codstat");
				     String libelle_station="";
				     String id_vehicule=rs.getString("cdmac");
				     String libelle_vehicule="";
				     String id_agent=rs.getString("decagen");
				     String libelle_agent="";
				     String depart=rs.getString("lieu_dep");
				     String destination=rs.getString("lieu_miss");
				     String date_ordre_mission=inverser(rs.getString("dat_miss").replace("-", "/"),"/");
				     
				     String valide=rs.getString("vld");
				     if(valide.equals("n"))
				     valide="en attente";
				     if(valide.equals("r"))
					     valide="refusé";
				     if(valide.equals("o"))
					     valide="validé";
				     String marchandise_transporte=rs.getString("marchand");
				     String objectif=rs.getString("obj_miss");
				     String remarque=rs.getString("observ");
					
					 
          aux=new  OrdreMissionForm( id_ordre_mission,  id_annee,
			 libelle_annee,  id_station,libelle_station,
			 id_vehicule,  libelle_vehicule,  id_agent,
			 libelle_agent,  depart,  destination,
			 date_ordre_mission,  valide,
			 marchandise_transporte,  objectif,  remarque);



                 lienagent(aux);






	String sql1="",sql2="",sql3="",sql4="";
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


			


	              
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(OrdreMissionForm frm)
	 {boolean res=true;
	 boolean changer=false;
	 changer=!(recup(frm.getId_ordre_mission(),frm.getId_annee())).getValide().equals("en attente");
	 
	 String sql="";
	 String id_ordre_mission=frm.getId_ordre_mission().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String id_vehicul="'"+frm.getId_vehicule().replace("'", "''")+"'";
     String id_agent=frm.getId_agent().replace("'", "''");

     
     String depart="'"+frm.getDestination().replace("'", "''")+"'";
     String destination="'"+frm.getDestination().replace("'", "''")+"'";
     String date_ordre_mission="'"+inverser(frm.getDate_ordre_mission().replace("-", "/"),"/")+"'";

     String marchandise_transporte="'"+frm.getMarchandise_transporte().replace("\n", " ").replace("'", "''")+"'";
     String objectif="'"+frm.getMarchandise_transporte().replace("'", "''")+"'";
     String remarque="'"+frm.getMarchandise_transporte().replace("'", "''")+"'";


     
     
	 sql = "update ord_miss set ";
	sql=sql+" num_ord="+id_ordre_mission+", cdexerc="+id_annee+", cdmac="+id_vehicul+", decagen="+id_agent+",lieu_dep="+depart+", lieu_miss="+destination+",";
	sql=sql+" dat_miss="+date_ordre_mission+", marchand="+marchandise_transporte+",obj_miss="+objectif+",vld='n',observ="+remarque;
    sql=sql+" where  num_ord="+id_ordre_mission+" and cdexerc="+id_annee;
	 
	 
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 
		 if(changer)
		 {
		 sql="UPDATE alert_ordre_mission SET alerte='true'"; 
		 Statement instruction6 = con.createStatement();
		 instruction6.executeUpdate(sql); 
		 }
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql);
	 }
	 
	 
	 sql = "delete FROM accomp where  num_ord="+id_ordre_mission+" and cdexerc="+id_annee ;
	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}
	 
	 
	 
	 
	 
	 String ch=frm.getAccompagant();
	 String tab[]=decouper(ch,'$');
	 for(int i=0;i<tab.length;i++)
		 try{if(!tab[i].equals(frm.getId_agent()))
			 {sql="insert into accomp(cdexerc,num_ord,decagen) VALUES ("+frm.getId_annee()+","+frm.getId_ordre_mission()+","+tab[i]+")";
			 Statement instruction1 = con.createStatement();
			 instruction1.executeUpdate(sql); 
		 }}
		 catch(Exception e){System.out.println(e);}
	
	
	 return res;
	
	 }
	 
	 
	 
	 public boolean valider(OrdreMissionForm frm)
	 {boolean res=true;
	
	 String sql="";
	 String id_ordre_mission=frm.getId_ordre_mission().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String valide="'o'";
     
    
     if(  id_ordre_mission!=null)
       	if(!id_ordre_mission.equals("''"))
       		if(!id_ordre_mission.equals(""))
       		{
      
     
	 sql = "update ord_miss set ";
	sql=sql+"vld="+valide;
    sql=sql+" where  num_ord="+id_ordre_mission+" and cdexerc="+id_annee;
	 
	 
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
	 
	 
	 public boolean refuser(OrdreMissionForm frm)
	 {boolean res=true;
	
	 String sql="";
	 String id_ordre_mission=frm.getId_ordre_mission().replace("'", "''");
	 String id_annee=frm.getId_annee().replace("'", "''");
     String valide="'r'";
     
     if(  id_ordre_mission!=null)
      	if(!id_ordre_mission.equals("''"))
      		if(!id_ordre_mission.equals(""))
      		{
     
     
     
	 sql = "update ord_miss set ";
	sql=sql+"vld="+valide;
    sql=sql+" where  num_ord="+id_ordre_mission+" and cdexerc="+id_annee;
	 
	 
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

	 
	 public ArrayList<OrdreMissionForm>  en_attente()
	   {
		 ArrayList<OrdreMissionForm> l = new  ArrayList<OrdreMissionForm>();
		    
			String sql = "SELECT * FROM ord_miss where vld='n' order by  num_ord,dat_miss" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
	
					 String id_ordre_mission=rs.getString("num_ord");
				     String id_annee=rs.getString("cdexerc");
				     String libelle_annee="";
				     String id_station=rs.getString("codstat");
				     String libelle_station="";
				     String id_vehicule=rs.getString("cdmac");
				     String libelle_vehicule="";
				     String id_agent=rs.getString("decagen");
				     String libelle_agent="";
				     String depart=rs.getString("lieu_dep");
				     String destination=rs.getString("lieu_miss");
				     String date_ordre_mission=inverser(rs.getString("dat_miss").replace("-", "/"),"/");
				     
				     String valide=rs.getString("vld");
				     if(valide.equals("n"))
				     valide="en attente";
				     if(valide.equals("r"))
					     valide="refusé";
				     if(valide.equals("o"))
					     valide="validé";
				     String marchandise_transporte=rs.getString("marchand");
				     String objectif=rs.getString("obj_miss");
				     String remarque=rs.getString("observ");
					
					 
 OrdreMissionForm	aux=new  OrdreMissionForm( id_ordre_mission,  id_annee,
			 libelle_annee,  id_station,libelle_station,
			 id_vehicule,  libelle_vehicule,  id_agent,
			 libelle_agent,  depart,  destination,
			 date_ordre_mission,  valide,
			 marchandise_transporte,  objectif,  remarque);


  lienagent(aux);

 			l.add(aux);






	String sql1="",sql2="",sql3="",sql4="";
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


			


	              
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<OrdreMissionForm>();
			logger.error(e+"requete =  "+sql);
			}
		  
		  
		   return l ;
		   
	   }
	 
	 public void annuler_alerte_ordre_mission()
	 {
	 
	 
	
		String sql="UPDATE alert_ordre_mission SET alerte='false'";

	 try{
		 Statement instruction = con.createStatement();
		 instruction.executeUpdate(sql); 
		 
	 }
	 catch(Exception e)
	 {logger.error(e+"requete =  "+sql);}

	 
	 }
	 
	 public ArrayList<OrdreMissionForm> inverse(ArrayList<OrdreMissionForm> l)
	 {
		 ArrayList<OrdreMissionForm> res=new ArrayList<OrdreMissionForm>();
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
	 
	 
	 
	 
	 public String[] decouper(String ch,char op)
	 {   int nb=0,j=0;
		 for(int i=0;i<ch.length();i++)
		 if(ch.charAt(i)==op)
			 nb=nb+1;
		 
		 String tab[]=new String [nb];
		 String temp="";
		 
		 for(int i=0;i<ch.length();i++)
		 {if(ch.charAt(i)!=op)
			 temp=temp+ch.charAt(i);
		 else{
			 if(!temp.equals(""))
			 {tab[j]=temp;
			 temp="";
			 j++;}
		     }
			 
		 }
		 return tab;
	 }
	 
	 
	 
	 
	 
	 public ArrayList<AgentForm> getaccompagants (String aux)
	   {
		 ArrayList<AgentForm> l = new  ArrayList<AgentForm>();
		 ArrayList<AgentForm> l1 = new  ArrayList<AgentForm>();
		   
			String sql = "SELECT * FROM agent where destatu='o' order by decagen" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
	l.add(new AgentForm(rs.getString("decagen"),rs.getString("denagen"),"","","","",true));

	            }
				
				String tab[]=decouper(aux,'$');
				for(int i=0;i<l.size();i++)
				{boolean trouve=false;
					for(int j=0;j<tab.length;j++)
				    if(tab[j].equals(l.get(i).getId_agent()))
				    trouve=true;
				    
				   if(trouve)
				  l1.add(l.get(i));
	
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<AgentForm>();
		   	l1=new  ArrayList<AgentForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l1 ;
		   
	   }
	 
	 
	 public ArrayList<AgentForm> reste (String aux)
	   {
		 ArrayList<AgentForm> l = new  ArrayList<AgentForm>();
		 ArrayList<AgentForm> l1 = new  ArrayList<AgentForm>();
		   
			String sql = "SELECT * FROM agent where destatu='o' order by decagen" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
	l.add(new AgentForm(rs.getString("decagen"),rs.getString("denagen"),"","","","",true));

	            }
				
				String tab[]=decouper(aux,'$');
				for(int i=0;i<l.size();i++)
				{boolean trouve=false;
					for(int j=0;j<tab.length;j++)
				    if(tab[j].equals(l.get(i).getId_agent()))
				    trouve=true;
				    
				   if(!trouve)
				  l1.add(l.get(i));
	
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<AgentForm>();
		   	l1=new  ArrayList<AgentForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l1 ;
		   
	   }
	 
	 public void lienagent (OrdreMissionForm frm)	
	 {
		 ArrayList<AgentForm> l = new  ArrayList<AgentForm>();

		   
			String sql = "SELECT * FROM accomp where cdexerc='"+frm.getId_annee()+"' and num_ord='"+frm.getId_ordre_mission()+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
	l.add(new AgentForm(rs.getString("decagen"),"","","","","",true));

	            }}
				
				catch (Exception e) 
				{l=new  ArrayList<AgentForm>();
				logger.error(e+"requete =  "+sql);
				}
				
				
				String ch="",ch1="$";
				
				for(int i=0;i<l.size();i++)
				{
					ch=ch+l.get(i).getId_agent()+ch1;
				}
				System.out.println("ch= "+ch);
			   
		 frm.setAccompagant(ch);
	 }
	 
}
