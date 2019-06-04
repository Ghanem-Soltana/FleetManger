package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import Bean.ArticleForm;
import Bean.TypeCarburantForm;

public class TypeCarbArticleDao {

	private Logger logger ;
	private Connection con ;
	
	public TypeCarbArticleDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<ArticleForm> getArticles (String id)
	   {
		 ArrayList<ArticleForm> l = new  ArrayList<ArticleForm>();
		   
			String sql = "SELECT * FROM art_typ_carb where cdtypcarb='"+id+"' order by cdtypcarb " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
	ArticleForm temp=new ArticleForm();
	temp.setId_article(rs.getString("cdartic"));
	
	
	String sql1 = "SELECT lbartic FROM article where cdartic='"+rs.getString("cdartic")+"'" ;
	try{
		Statement instruction1 = con.createStatement();
		ResultSet rs1 = instruction1.executeQuery(sql1);
		while(rs1.next())
		{
			String lib="";
			lib=rs1.getString("lbartic");
			temp.setLibelle_article(lib);
		}}catch(Exception e){}
		
	
	l.add(temp);
					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<ArticleForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 
	 
	 

	 
	 
	 public ArrayList<ArticleForm> reste (String aux)
	   {
		 ArrayList<ArticleForm> l = new  ArrayList<ArticleForm>();
		 ArrayList<ArticleForm> l1 = new  ArrayList<ArticleForm>();
		   
			String sql = "SELECT * FROM article" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
		ArticleForm temp=new ArticleForm();
		temp.setId_article(rs.getString("cdartic"));
		temp.setLibelle_article(rs.getString("lbartic"));
	l.add(temp);
				}
				
				String tab[]=decouper(aux,'$');
				for(int i=0;i<l.size();i++)
				{boolean trouve=false;
					for(int j=0;j<tab.length;j++)
					{  if(tab[j].equals(l.get(i).getId_article()))
				    trouve=true;
	
					}
					
					if(!trouve)
				  l1.add(l.get(i));
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<ArticleForm>();
		   	l1=new  ArrayList<ArticleForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
			
		   return inverse(l1) ;
		   
	   }
	 

	 public boolean update(TypeCarburantForm frm)
	 {boolean res=true;
	 String sql2="";
	 try{
	
		 String sql1="delete from art_typ_carb where cdtypcarb='"+frm.getid_carburant().replace("\"", "\"\"")+"'";
		 Statement instruction1 = con.createStatement();
		 instruction1.executeUpdate(sql1);
		 
		
		 String ch=frm.getListe_article();
		 String tab[]=decouper(ch,'$');
		
	    
		 for(int i=0;i<tab.length;i++)
		 {  String id_princi="",id_sec="";
			 

			String sqltemp = "SELECT * FROM article where cdartic='"+tab[i]+"'" ;
			try{
				Statement instructiontemp = con.createStatement();
				ResultSet rstemp= instructiontemp.executeQuery(sqltemp);
				while(rstemp.next())
				{
					id_princi=rstemp.getString("cdfamart");
					id_sec=rstemp.getString("cdsfart");
				}}catch(Exception e){logger.error(e+"requete =  "+sqltemp);}
		 
		 
		 
		 
		 
		 
		 
		 sql2 ="insert into art_typ_carb(cdtypcarb, cdfamart, cdsfart, cdartic) VALUES ('"+frm.getid_carburant()+"','"+id_princi+"','"+id_sec+"','"+tab[i]+"')";
			 Statement instruction2 = con.createStatement();
			 instruction2.executeUpdate(sql2); 
		 }
	 
	 }
	 catch(Exception e)
	 {res=false;
	 logger.error(e+"requete =  "+sql2);
	 }
	 
	 
	 
	 
	 return res;
	 
	 }
	 
	 
	 public ArrayList<ArticleForm> inverse(ArrayList<ArticleForm> l)
	 {
		 ArrayList<ArticleForm> res=new ArrayList<ArticleForm>();
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
