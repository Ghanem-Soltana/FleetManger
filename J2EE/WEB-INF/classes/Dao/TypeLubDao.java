package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import Bean.TypeLubForm;

public class TypeLubDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeLubDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<TypeLubForm> all ()
	   {
		 ArrayList<TypeLubForm> l = new  ArrayList<TypeLubForm>();
		   
			String sql = " SELECT * FROM typ_lub";
		   

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{		  				
 l.add(new TypeLubForm(rs.getString("cdtyplb"),rs.getString("lbtyplb"),rs.getString("cdfamart"),"",rs.getString("cdsfart"),"",rs.getString("cdartic"),""));
 String sql1 = " SELECT * FROM fam_art where cdfamart='"+rs.getString("cdfamart")+"'";
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);


	while(rs1.next())
	{
			
		  String lbfamart=rs1.getString("lbfamart");
		  if(lbfamart!=null)
			  l.get(l.size()-1).setLibelle_famart(lbfamart);

	}		

	
	   String sql2 = " SELECT * FROM sfm_art where cdsfart='"+rs.getString("cdsfart")+"'";;
		Statement instruction2 = con.createStatement();
		ResultSet rs2 = instruction2.executeQuery(sql2);
	

		while(rs2.next())
		{
				
			  String lb=rs2.getString("lbsfart");
			  if(lb!=null)
				  l.get(l.size()-1).setLibelle_sfamart(lb);
	
		}		
	
	

		   String sql3 = " SELECT * FROM article where cdartic='"+rs.getString("cdartic")+"'";;
			Statement instruction3 = con.createStatement();
			ResultSet rs3 = instruction3.executeQuery(sql3);
		

			while(rs3.next())
			{
					
				  String lb=rs3.getString("lbartic");
				  if(lb!=null)
					  l.get(l.size()-1).setLibelle_article(lb);
		
			}		
				
				}
				
				
			}

 
				catch (Exception e) 
			{l=new  ArrayList<TypeLubForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM  typ_lub where cdtyplb='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(TypeLubForm frm)
	 {boolean res=true;
	 String sql="",clé1=frm.getId_famart().replace("'", "''"),clé2=frm.getId_sfamart().replace("'", "''"),clé3=frm.getId_article().replace("'", "''");
	 
	 
		
	 System.out.println("clé1"+clé1);
		System.out.println("clé2"+clé2);
		System.out.println("clé3"+clé3); 
	 
	 if(frm.getId_famart().equals("")||frm.getId_famart()==null||frm.getId_famart().equals("xxxxx"))
		 clé1="null";
		 else clé1="'"+clé1+"'";

	 
	 if(frm.getId_sfamart().equals("")||frm.getId_sfamart()==null||frm.getId_sfamart().equals("xxxxx"))
		 clé2="null";
		 else clé2="'"+clé2+"'";
	 if(frm.getId_article().equals("")||frm.getId_article()==null||frm.getId_article().equals("xxxxx"))
		 clé3="null";
		 else clé3="'"+clé3+"'";
	
	 if(clé1!="null"||clé2!="null"||clé3!="null")
	 {
	 sql = "INSERT INTO typ_lub(cdtyplb,lbtyplb,cdfamart,cdsfart,cdartic) values ('"+frm.getId_typelub().replace("'", "''")+"','"+frm.getLibelle_typelub().replace("'", "''")+"',"+clé1+","+clé2+","+clé3+")" ;
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
	 
	 
	 public TypeLubForm recup (String id)
	   {
		 TypeLubForm aux=new TypeLubForm();;
		   
			String sql = "SELECT * FROM typ_lub where cdtyplb='"+id+"'" ;
		
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	aux=new TypeLubForm(rs.getString("cdtyplb"),rs.getString("lbtyplb"),rs.getString("cdfamart"),"",rs.getString("cdsfart"),"",rs.getString("cdartic"),"");				
	
	
	   String sql1 = " SELECT * FROM fam_art where cdfamart='"+rs.getString("cdfamart")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
	

		while(rs1.next())
		{
				
			  String lbfamart=rs1.getString("lbfamart");
			  if(lbfamart!=null)
				  aux.setLibelle_famart(lbfamart);
	
		}		

		
		   String sql2 = " SELECT * FROM sfm_art where cdsfart='"+rs.getString("cdsfart")+"'";
			Statement instruction2 = con.createStatement();
			ResultSet rs2 = instruction2.executeQuery(sql2);
		

			while(rs2.next())
			{
					
				  String lb=rs2.getString("lbsfart");
				  if(lb!=null)
					  aux.setLibelle_sfamart(lb);
		
			}		
		
		

			   String sql3 = " SELECT * FROM article where cdartic='"+rs.getString("cdartic")+"'";
				Statement instruction3 = con.createStatement();
				ResultSet rs3 = instruction3.executeQuery(sql3);
			

				while(rs3.next())
				{
						
					  String lb=rs3.getString("lbartic");
		
					  if(lb!=null)
						  aux.setLibelle_article(lb);
			
				}		
				  
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
			System.out.println("wa3333333333"+aux.getId_article());
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(TypeLubForm frm)
	 {boolean res=true;
	 String clé1=frm.getId_famart().replace("'", "''");
	 String clé2=frm.getId_sfamart().replace("'", "''");
	 String clé3=frm.getId_article().replace("'", "''");
	 if(frm.getId_famart().equals("")||frm.getId_famart()==null||frm.getId_famart().equals("xxxxx"))
	 clé1="null";
	 else clé1="'"+clé1+"'";
	 if(frm.getId_sfamart().equals("")||frm.getId_sfamart()==null||frm.getId_sfamart().equals("xxxxx"))
	 clé2="null";
	 else clé2="'"+clé2+"'";
	 if(frm.getId_article().equals("")||frm.getId_article()==null||frm.getId_article().equals("xxxxx"))
		 clé3="null";
		 else clé3="'"+clé3+"'"; 	 

							

	 String sql=" UPDATE typ_lub SET cdtyplb='"+frm.getId_typelub().replace("'", "''")+"',lbtyplb='"+frm.getLibelle_typelub().replace("'", "''")+"', cdfamart="+clé1+",cdsfart="+clé2;
	 sql=  sql+", cdartic="+clé3;
	 sql=  sql+" WHERE cdtyplb='"+frm.getId_typelub().replace("'", "''")+"'";

	 
	 
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

	 
	 public ArrayList<TypeLubForm> select (String id)
	 {
			 ArrayList<TypeLubForm> l = new  ArrayList<TypeLubForm>();
			   
				String sql = " SELECT * FROM typ_lub where cdarticle='"+id+"'";
			   

				try{
					Statement instruction = con.createStatement();
					ResultSet rs = instruction.executeQuery(sql);
					while(rs.next())
					{
						  				
	 l.add(new TypeLubForm(rs.getString("cdtyplub"),rs.getString("lbtyplub"),rs.getString("cdfamart"),"",rs.getString("cdsfart"),"",id,""));
	 
	 String sql1 = " SELECT * FROM fam_art,sfm_art where fam_art.id_famille_princi=sfm_art.id_famille_princi and  sfm_art.id_famille_princi='"+rs.getString("cdfamart")+"'";
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			  String lib=rs1.getString("lbfamart");
			  String lib2=rs1.getString("lbsfart");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_famart(lib);
			  if(lib2!=null)
				  l.get(l.size()-1).setLibelle_sfamart(lib2);
		}				
		
			
					}
					
				}
				catch (Exception e) 
				{l=new  ArrayList<TypeLubForm>();
				logger.error(e+"requete =  "+sql);
				}if(!id.equals("xxxxxx"))
			   return inverse(l) ;
			   else return all();
			   
		   }
		 	 
	 public ArrayList<TypeLubForm> select(TypeLubForm afficher)
	 {
		 ArrayList<TypeLubForm> res=new ArrayList<TypeLubForm>();
		 String idp=afficher.getId_famart(),ids=afficher.getId_sfamart(),and="",and1="",ida=afficher.getId_article();
			System.out.println("idp =  "+idp); 
			System.out.println("ids =  "+ids); 
			System.out.println("ida =  "+ida); 
			
		 if(idp.equals("xxxxxx")&&ids.equals("xxxxxx"))
			 return all();
		 else {
			 
			 if(!idp.equals("xxxxxx")&&!ids.equals("xxxxxx"))
				 and=" and ";
			 if(!ida.equals("xxxxxx"))
			 and1=" and ";

			 if(idp.equals("xxxxxx")&&ids.equals("xxxxxx"))
				 and1="";
			  
			 if(idp.equals("xxxxxx"))
				 idp="";
			 else idp="cdfamart='"+idp+"'";
			 
			 if(ids.equals("xxxxxx"))
				 ids="";
			 else ids="cdsfart='"+ids+"'";
	
			 if(ida.equals("xxxxxx"))
				 ida="";
			 else ida="cdartic='"+ida+"'";
			 
		
			 
			 
			  
			
			String sql = " SELECT * FROM typ_lub where "+idp+and+ids+and1+ida;
			System.out.println("requete =  "+sql); 
		

			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					res.add(new TypeLubForm(rs.getString("cdtyplb"),rs.getString("lbtyplb"),rs.getString("cdfamart"),"",rs.getString("cdsfart"),"",rs.getString("cdartic"),""));
					 
					 String sql1 = " SELECT * FROM fam_art,sfm_art,article where fam_art.cdfamart=sfm_art.cdfamart and sfm_art.cdfamart='"+rs.getString("cdfamart")+"'";
									  				 
	Statement instruction1 = con.createStatement();
	ResultSet rs1 = instruction1.executeQuery(sql1);
	while(rs1.next())
	{
		  String lib=rs1.getString("lbfamart");
		  String lib2=rs1.getString("lbsfart");
		  String lib3=rs1.getString("cdnatar");
		  if(lib!=null)
			  res.get(res.size()-1).setLibelle_famart(lib);
		  if(lib2!=null)
		  res.get(res.size()-1).setLibelle_sfamart(lib2);
		  if(lib3!=null)
			  res.get(res.size()-1).setLibelle_article(lib3);
	}
		
				}
				
				
			}
			catch (Exception e) 
			{res=new  ArrayList<TypeLubForm>();
			logger.error(e+"requete =  "+sql);
			}
	
		 
		 
		 
		 
		 return inverse(res);
		 }
	 }
	 
	 
	 
	 
	 

	 
	 
	 
	 public ArrayList<TypeLubForm> inverse(ArrayList<TypeLubForm> l)
	 {
		 ArrayList<TypeLubForm> res=new ArrayList<TypeLubForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
