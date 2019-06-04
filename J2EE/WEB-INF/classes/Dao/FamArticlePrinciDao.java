package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.FamArticlePrinciForm;

public class FamArticlePrinciDao {

	private Logger logger ;
	private Connection con ;
	
	public FamArticlePrinciDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<FamArticlePrinciForm> all ()
	   {
		 ArrayList<FamArticlePrinciForm> l = new  ArrayList<FamArticlePrinciForm>();
		   
			String sql = "SELECT * FROM fam_art" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
	l.add(new FamArticlePrinciForm(rs.getString("cdfamart"),rs.getString("lbfamart"),rs.getString("edit_invent").equals("o"),rs.getString("deccomp").equals("o")));
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<FamArticlePrinciForm>();
			
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l) ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM fam_art where  cdfamart='"+id.replace("\"", "\"\"")+"'" ;
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
	 
	 public boolean add(FamArticlePrinciForm frm)
	 {boolean res=true,imp=frm.isImpression(),stock=frm.isStocke();
	 char i='n',s='n';
	 if(imp)
	 i='o';
	 if(stock)
	 s='o';
	 
	 String sql = "insert into fam_art (cdfamart,lbfamart,edit_invent,deccomp) values ('"+frm.getId_famille_princi().replace("'", "''")+"','"+frm.getLibelle_famille_princi().replace("'", "''")+"','"+i+"','"+s+"')" ;
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
	 
	 public FamArticlePrinciForm recup (String id)
	   {
		 FamArticlePrinciForm aux=null;
		   
			String sql = "SELECT * FROM fam_art where cdfamart='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					
aux=new FamArticlePrinciForm(rs.getString("cdfamart"),rs.getString("lbfamart"),rs.getString("edit_invent").equals("o"),rs.getString("deccomp").equals("o"));
					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(FamArticlePrinciForm frm)
	 {
	 boolean res=true,imp=frm.isImpression(),stock=frm.isStocke();
	 char i='n',s='n';
	 if(imp)
	 i='o';
	 if(stock)
	s='o';
	 
	 String sql = "update fam_art set lbfamart='"+frm.getLibelle_famille_princi().replace("'", "''")+"', "  ;
	 sql=sql+" edit_invent='"+i+"' ,deccomp='"+s+"'"; 
	 sql=sql+" where cdfamart='"+frm.getId_famille_princi().replace("'", "''")+"'";
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

	 
	 
	 
	 public ArrayList<FamArticlePrinciForm> getfamille (String aux)
	   {
		 ArrayList<FamArticlePrinciForm> l = new  ArrayList<FamArticlePrinciForm>();
		 ArrayList<FamArticlePrinciForm> l1 = new  ArrayList<FamArticlePrinciForm>();
		   
			String sql = "SELECT * FROM fam_art" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
	l.add(new FamArticlePrinciForm(rs.getString("cdfamart"),rs.getString("lbfamart"),rs.getString("edit_invent").equals("o"),rs.getString("deccomp").equals("o")));

	            }
				
				String tab[]=decouper(aux,'$');
				for(int i=0;i<l.size();i++)
				{boolean trouve=false;
					for(int j=0;j<tab.length;j++)
				    if(tab[j].equals(l.get(i).getId_famille_princi()))
				    trouve=true;
				    
				   if(trouve)
				  l1.add(l.get(i));
	
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<FamArticlePrinciForm>();
		   	l1=new  ArrayList<FamArticlePrinciForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l1) ;
		   
	   }
	 
	 
	 public ArrayList<FamArticlePrinciForm> reste (String aux)
	   {
		 ArrayList<FamArticlePrinciForm> l = new  ArrayList<FamArticlePrinciForm>();
		 ArrayList<FamArticlePrinciForm> l1 = new  ArrayList<FamArticlePrinciForm>();
		   
			String sql = "SELECT * FROM fam_art" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					  
	l.add(new FamArticlePrinciForm(rs.getString("cdfamart"),rs.getString("lbfamart"),rs.getString("edit_invent").equals("o"),rs.getString("deccomp").equals("o")));
				}
				
				String tab[]=decouper(aux,'$');
				for(int i=0;i<l.size();i++)
				{boolean trouve=false;
					for(int j=0;j<tab.length;j++)
				    if(tab[j].equals(l.get(i).getId_famille_princi()))
				    trouve=true;
				    
				   if(!trouve)
				  l1.add(l.get(i));
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<FamArticlePrinciForm>();
		   	l1=new  ArrayList<FamArticlePrinciForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return inverse(l1) ;
		   
	   }
	 
	 
	 public ArrayList<FamArticlePrinciForm> lienmagasin(String id)
	 {
		 ArrayList<FamArticlePrinciForm> l = new  ArrayList<FamArticlePrinciForm>();

		   
			String sql = "SELECT * FROM fam_mag where cdmag='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{			  
					String temp="";
					
		String sql1 = "SELECT * FROM fam_art where cdfamart='"+rs.getString("cdfamart")+"'" ;
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		rs1.next();
		temp=rs1.getString("lbfamart");
	l.add(new FamArticlePrinciForm(rs.getString("cdfamart"),temp,false,false));
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<FamArticlePrinciForm>();
			}
		   
		   return inverse(l) ; 
	 }
	 
	 public ArrayList<FamArticlePrinciForm> inverse(ArrayList<FamArticlePrinciForm> l)
	 {
		 ArrayList<FamArticlePrinciForm> res=new ArrayList<FamArticlePrinciForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
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
}
