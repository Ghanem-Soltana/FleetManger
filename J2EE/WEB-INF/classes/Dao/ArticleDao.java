package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import Bean.ArticleForm;

public class ArticleDao {

	private Logger logger ;
	private Connection con ;
	
	public ArticleDao(Connection con) {
		super();
		this.con = con;
		this.logger = Logger.getLogger("Dao");
		
	}
	
	 public ArrayList<ArticleForm> all ()
	   {
		 ArrayList<ArticleForm> l = new  ArrayList<ArticleForm>();
		   
			String sql = "SELECT * FROM article order by cdartic " ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
				
     				String id_article=rs.getString("cdartic");
					String libelle_article=rs.getString("lbartic");
					String id_famille_principale=rs.getString("cdfamart"); 
					String libelle_famille_principale="";
					String id_famille_secondaire=rs.getString("cdsfart");
					String libelle_famille_secondaire="";
					String id_type_article=rs.getString("cdtypar"); 
					String libelle_type_article="";
					String id_categorie_article=rs.getString("cdnatar");
					String libelle_categorie_article="";
					String id_unite=rs.getString("cdunite"); 
					String libelle_unite="";
					String descreption=rs.getString("desc_art");
					String symbole_reference=rs.getString("reference"); 
					String prix_referenciel=rs.getString("prix_ref");
					String prix_avant_tax=rs.getString("prix_ht");
					String prix_achat=rs.getString("prix_ach");
					String moyenne_prix=rs.getString("pmp_art");
					String prix_limite_min=rs.getString("s_alerte"); 
					String limite_redistribution=rs.getString("s_reap");
					String symbole_poto=rs.getString("cdbar1"); 
					String desc_mois=rs.getString("norme_mois"); 
					String desc_qte=rs.getString("norme_km");
					String limite_min=rs.getString("s_max");
					String qte_min=rs.getString("qte_min"); 
					String depence_apprivois=rs.getString("frai_ap");
					String qte_economique=rs.getString("qte_eco");
					String qte_fabrique=rs.getString("qte_fab");
					String qte_stocke=rs.getString("qte_stock");
					String qte_embalage=rs.getString("qte_embl");
					boolean periode_validite=rs.getString("perissa").equals("o");
					boolean sortie_pour_vehicule=rs.getString("sort_mac").equals("o"); 
					boolean sortie_pour_service=rs.getString("sort_ser").equals("o");
					boolean stocke=rs.getString("art_stoc").equals("o");
					boolean premier=rs.getString("art_pri").equals("o");
					boolean boite=rs.getString("art_com").equals("o"); 
					boolean compose=rs.getString("art_compo").equals("o"); 
					boolean combustible=rs.getString("carburant").equals("o"); 
					boolean huile=rs.getString("lubrifiant").equals("o");
					boolean rechange=rs.getString("pieces").equals("o");
					boolean pneu=rs.getString("pneus").equals("o"); 
					boolean pneu1=rs.getString("pneusrechap").equals("o");
					boolean divers=rs.getString("autresart").equals("o");
					String poids_net=rs.getString("poid_net");
					String volume=rs.getString("volume"); 
					String superfici=rs.getString("surface"); 
					String longeure	=rs.getString("longueur");			
					
l.add(new ArticleForm( id_article,  libelle_article,
		 id_famille_principale,  libelle_famille_principale,
		 id_famille_secondaire,  libelle_famille_secondaire,
		 id_type_article,  libelle_type_article,
		 id_categorie_article,  libelle_categorie_article,
		 id_unite,  libelle_unite,  descreption,
		 symbole_reference,  prix_referenciel,
		 prix_avant_tax,  prix_achat,  moyenne_prix,
		 prix_limite_min,  limite_redistribution,
		 symbole_poto,  desc_mois,  desc_qte,
		 limite_min,  qte_min,  depence_apprivois,
		 qte_economique,  qte_fabrique,  qte_stocke,
		 qte_embalage,  periode_validite,
		 sortie_pour_vehicule,  sortie_pour_service,  stocke,  premier,
		 boite,  compose,  combustible,  huile,
		 rechange,  pneu,  pneu1,  divers,
		 poids_net,  volume,  superfici,  longeure) );














String sql1="",sql2="",sql3="",sql4="",sql5="";
try{

 sql1= " SELECT * FROM fam_art where cdfamart='"+id_famille_principale+"'";
Statement instruction1 = con.createStatement();
ResultSet rs1 = instruction1.executeQuery(sql1);
while(rs1.next())
{
	  String lib=rs1.getString("lbfamart");
	  if(lib!=null)
		  l.get(l.size()-1).setLibelle_famille_principale(lib);
}
}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


try{

	 sql2= " SELECT * FROM sfm_art where cdsfart='"+id_famille_secondaire+"'";
	Statement instruction2 = con.createStatement();
	ResultSet rs2 = instruction2.executeQuery(sql2);
	while(rs2.next())
	{
		  String lib=rs2.getString("lbsfart");
		  if(lib!=null)
			  l.get(l.size()-1).setLibelle_famille_secondaire(lib);
	}
	}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





	try{

		 sql3= " SELECT * FROM typ_art where cdtypar='"+id_type_article+"'";
		Statement instruction3 = con.createStatement();
		ResultSet rs3 = instruction3.executeQuery(sql3);
		while(rs3.next())
		{
			  String lib=rs3.getString("lbtypar");
			  if(lib!=null)
				  l.get(l.size()-1).setLibelle_type_article(lib);
		}
		}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


		try{

			 sql4= " SELECT * FROM nat_art where cdnatar='"+id_categorie_article+"'";
			Statement instruction4 = con.createStatement();
			ResultSet rs4 = instruction4.executeQuery(sql4);
			while(rs4.next())
			{
				  String lib=rs4.getString("lbnatar");
				  if(lib!=null)
					  l.get(l.size()-1).setLibelle_categorie_article(lib);
			}
			}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}




			try{

				 sql5= " SELECT * FROM unite where cdunite='"+id_unite+"'";
				Statement instruction5 = con.createStatement();
				ResultSet rs5 = instruction5.executeQuery(sql5);
				while(rs5.next())
				{
					  String lib=rs5.getString("lbunite");
					  if(lib!=null)
						  l.get(l.size()-1).setLibelle_unite(lib);
				}
				}catch(Exception e5){logger.error(e5+"requete =  "+sql5);}



					
				}
			}
			catch (Exception e) 
			{l=new  ArrayList<ArticleForm>();
			logger.error(e+"requete =  "+sql);
			}
		   
		   return l ;
		   
	   }
	 
	 public boolean delete(String id)
	 {boolean res=true;
	 
	 String sql = "delete FROM article where  cdartic='"+id+"'" ;
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
	 
	 public boolean add(ArticleForm frm)
	 {boolean res=true;
	 
	 
		String id_article=frm.getId_article().replace("'", "''");
		String libelle_article=frm.getLibelle_article().replace("'", "''");
		String id_famille_principale=frm.getId_famille_principale().replace("'", "''"); 
		String id_famille_secondaire=frm.getId_famille_secondaire().replace("'", "''");
		String id_type_article=(frm.getId_type_article()!=null)?"'"+frm.getId_type_article().replace("'", "''")+"'":"''";
		String id_categorie_article=frm.getId_categorie_article().replace("'", "''");
		String id_unite=(frm.getId_unite()!=null)?"'"+frm.getId_unite().replace("'", "''")+"'":"''";
		String descreption=frm.getDescreption().replace("'", "''");
		String symbole_reference=frm.getSymbole_reference().replace("'", "''"); 
		
		
		
		String prix_referenciel=(!frm.getPrix_referenciel().equals(""))?frm.getPrix_referenciel().replace("'", "''"):"null";
		String prix_avant_tax=(!frm.getPrix_avant_tax().equals(""))?frm.getPrix_avant_tax().replace("'", "''"):"null";
		String prix_achat=(!frm.getPrix_achat().equals(""))?frm.getPrix_achat().replace("'", "''"):"null";
		String moyenne_prix=(!frm.getMoyenne_prix().equals(""))?frm.getMoyenne_prix().replace("'", "''"):"null";
		String prix_limite_min=(!frm.getPrix_limite_min().equals(""))?frm.getPrix_limite_min().replace("'", "''"):"null";
		String limite_redistribution=(!frm.getLimite_redistribution().equals(""))?frm.getLimite_redistribution().replace("'", "''"):"null";
		String symbole_poto=frm.getSymbole_poto().replace("'", "''"); 
		String desc_mois=(!frm.getDesc_mois().equals(""))?frm.getDesc_mois().replace("'", "''"):"null";
		String desc_qte=(!frm.getDesc_qte().equals(""))?frm.getDesc_qte().replace("'", "''"):"null";
		String limite_min=(!frm.getLimite_min().equals(""))?frm.getLimite_min().replace("'", "''"):"null";
		String qte_min=(!frm.getQte_min().equals(""))?frm.getQte_min().replace("'", "''"):"null";
		String depence_apprivois=(!frm.getDepence_apprivois().equals(""))?frm.getDepence_apprivois().replace("'", "''"):"null";
		String qte_economique=(!frm.getQte_economique().equals(""))?frm.getQte_economique().replace("'", "''"):"null";
		String qte_fabrique=(!frm.getQte_fabrique().equals(""))?frm.getQte_fabrique().replace("'", "''"):"null";
		String qte_stocke=(!frm.getQte_stocke().equals(""))?frm.getQte_stocke().replace("'", "''"):"null";
		String qte_embalage=(!frm.getQte_embalage().equals(""))?frm.getQte_embalage().replace("'", "''"):"null";
		String poids_net=(!frm.getPoids_net().equals(""))?frm.getPoids_net().replace("'", "''"):"null";
		String volume=(!frm.getVolume().equals(""))?frm.getVolume().replace("'", "''") :"null";
		String superfici=(!frm.getSuperfici().equals(""))?frm.getSuperfici().replace("'", "''") :"null";
		String longeure	=(!frm.getLongeure().equals(""))?frm.getLongeure().replace("'", "''")	:"null";	
		
		
		
		
		
		
		String periode_validite=(frm.isPeriode_validite())?"o":"n";
		String sortie_pour_vehicule=(frm.isSortie_pour_vehicule())?"o":"n"; 
		String sortie_pour_service=(frm.isSortie_pour_service())?"o":"n";
		String stocke=(frm.isStocke())?"o":"n";
		String premier=(frm.isPremier())?"o":"n";
		String boite=(frm.isBoite())?"o":"n"; 
		String compose=(frm.isCompose())?"o":"n"; 
		String combustible=(frm.isCombustible())?"o":"n"; 
		String huile=(frm.isHuile())?"o":"n";
		String rechange=(frm.isRechange())?"o":"n";
		String pneu=(frm.isPneu())?"o":"n"; 
		String pneu1=(frm.isPneu1())?"o":"n";
		String divers=(frm.isDivers())?"o":"n";
			
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 String sql = "	";			
	 sql= "insert into article	(cdartic,lbartic,cdfamart,cdsfart,cdtypar,cdnatar,cdunite,desc_art,reference,prix_ref,prix_ht,prix_ach,pmp_art,s_alerte";
	sql=sql+",s_reap,cdbar1,norme_mois,norme_km,s_max,qte_min,frai_ap,qte_eco,qte_fab,qte_stock,qte_embl,perissa,sort_mac";
	sql=sql+",sort_ser,art_stoc,art_pri,art_com,art_compo,carburant,lubrifiant,pieces,pneus,pneusrechap,autresart,poid_net,volume,surface,longueur)	"	;
	sql=sql+" values ('"+id_article+"','"+libelle_article+"','"+id_famille_principale+"','"+id_famille_secondaire+"',"+id_type_article+",";
	sql=sql+"'"+id_categorie_article+"',"+id_unite+",'"+descreption+"','"+symbole_reference+"',"+prix_referenciel+","+prix_avant_tax+",";
	sql=sql+prix_achat+","+moyenne_prix+","+prix_limite_min+","+limite_redistribution+",'"+symbole_poto+"',"+desc_mois+","+desc_qte+",";
	sql=sql+limite_min+","+qte_min+","+depence_apprivois+","+qte_economique+","+qte_fabrique+","+qte_stocke+","+qte_embalage+",'"+periode_validite+"',";
	sql=sql+"'"+sortie_pour_vehicule+"','"+sortie_pour_service+"','"+stocke+"','"+premier+"','"+boite+"','"+compose+"','"+combustible+"','"+huile+"',";
	sql=sql+"'"+rechange+"','"+pneu+"','"+pneu1+"','"+divers+"',"+poids_net+","+volume+","+superfici+","+longeure;
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
	 
	 public ArticleForm recup (String id)
	   {
		 ArticleForm aux=null;
		   
			String sql = "SELECT * FROM article where cdartic='"+id+"'" ;
			try{
				Statement instruction = con.createStatement();
				ResultSet rs = instruction.executeQuery(sql);
				while(rs.next())
				{
					
					

					String id_article=rs.getString("cdartic");
					String libelle_article=rs.getString("lbartic");
					String id_famille_principale=rs.getString("cdfamart"); 
					String libelle_famille_principale="";
					String id_famille_secondaire=rs.getString("cdsfart");
					String libelle_famille_secondaire="";
					String id_type_article=rs.getString("cdtypar"); 
					String libelle_type_article="";
					String id_categorie_article=rs.getString("cdnatar");
					String libelle_categorie_article="";
					String id_unite=rs.getString("cdunite"); 
					String libelle_unite="";
					String descreption=rs.getString("desc_art");
					String symbole_reference=rs.getString("reference"); 
					String prix_referenciel=rs.getString("prix_ref");
					String prix_avant_tax=rs.getString("prix_ht");
					String prix_achat=rs.getString("prix_ach");
					String moyenne_prix=rs.getString("pmp_art");
					String prix_limite_min=rs.getString("s_alerte"); 
					String limite_redistribution=rs.getString("s_reap");
					String symbole_poto=rs.getString("cdbar1"); 
					String desc_mois=rs.getString("norme_mois"); 
					String desc_qte=rs.getString("norme_km");
					String limite_min=rs.getString("s_max");
					String qte_min=rs.getString("qte_min"); 
					String depence_apprivois=rs.getString("frai_ap");
					String qte_economique=rs.getString("qte_eco");
					String qte_fabrique=rs.getString("qte_fab");
					String qte_stocke=rs.getString("qte_stock");
					String qte_embalage=rs.getString("qte_embl");
					boolean periode_validite=rs.getString("perissa").equals("o");
					boolean sortie_pour_vehicule=rs.getString("sort_mac").equals("o"); 
					boolean sortie_pour_service=rs.getString("sort_ser").equals("o");
					boolean stocke=rs.getString("art_stoc").equals("o");
					boolean premier=rs.getString("art_pri").equals("o");
					boolean boite=rs.getString("art_com").equals("o"); 
					boolean compose=rs.getString("art_compo").equals("o"); 
					boolean combustible=rs.getString("carburant").equals("o"); 
					boolean huile=rs.getString("lubrifiant").equals("o");
					boolean rechange=rs.getString("pieces").equals("o");
					boolean pneu=rs.getString("pneus").equals("o"); 
					boolean pneu1=rs.getString("pneusrechap").equals("o");
					boolean divers=rs.getString("autresart").equals("o");
					String poids_net=rs.getString("poid_net");
					String volume=rs.getString("volume"); 
					String superfici=rs.getString("surface"); 
					String longeure	=rs.getString("longueur");		
	
					
					
					
					
					aux=new ArticleForm( id_article,  libelle_article,
							 id_famille_principale,  libelle_famille_principale,
							 id_famille_secondaire,  libelle_famille_secondaire,
							 id_type_article,  libelle_type_article,
							 id_categorie_article,  libelle_categorie_article,
							 id_unite,  libelle_unite,  descreption,
							 symbole_reference,  prix_referenciel,
							 prix_avant_tax,  prix_achat,  moyenne_prix,
							 prix_limite_min,  limite_redistribution,
							 symbole_poto,  desc_mois,  desc_qte,
							 limite_min,  qte_min,  depence_apprivois,
							 qte_economique,  qte_fabrique,  qte_stocke,
							 qte_embalage,  periode_validite,
							 sortie_pour_vehicule,  sortie_pour_service,  stocke,  premier,
							 boite,  compose,  combustible,  huile,
							 rechange,  pneu,  pneu1,  divers,
							 poids_net,  volume,  superfici,  longeure)		;
					
					
					

					String sql1="",sql2="",sql3="",sql4="",sql5="";
					try{

					 sql1= " SELECT * FROM fam_art where cdfamart='"+id_famille_principale+"'";
					Statement instruction1 = con.createStatement();
					ResultSet rs1 = instruction1.executeQuery(sql1);
					while(rs1.next())
					{
						  String lib=rs1.getString("lbfamart");
						  if(lib!=null)
							  aux.setLibelle_famille_principale(lib);
					}
					}catch(Exception e1){logger.error(e1+"requete =  "+sql1);}


					try{

						 sql2= " SELECT * FROM sfm_art where cdsfart='"+id_famille_secondaire+"'";
						Statement instruction2 = con.createStatement();
						ResultSet rs2 = instruction2.executeQuery(sql2);
						while(rs2.next())
						{
							  String lib=rs2.getString("lbsfart");
							  if(lib!=null)
								  aux.setLibelle_famille_secondaire(lib);
						}
						}catch(Exception e2){logger.error(e2+"requete =  "+sql2);}





						try{

							 sql3= " SELECT * FROM typ_art where cdtypar='"+id_type_article+"'";
							Statement instruction3 = con.createStatement();
							ResultSet rs3 = instruction3.executeQuery(sql3);
							while(rs3.next())
							{
								  String lib=rs3.getString("lbtypar");
								  if(lib!=null)
									  aux.setLibelle_type_article(lib);
							}
							}catch(Exception e3){logger.error(e3+"requete =  "+sql3);}


							try{

								 sql4= " SELECT * FROM nat_art where cdnatar='"+id_categorie_article+"'";
								Statement instruction4 = con.createStatement();
								ResultSet rs4 = instruction4.executeQuery(sql4);
								while(rs4.next())
								{
									  String lib=rs4.getString("lbnatar");
									  if(lib!=null)
										 aux.setLibelle_categorie_article(lib);
								}
								}catch(Exception e4){logger.error(e4+"requete =  "+sql4);}




								try{

									 sql5= " SELECT * FROM unite where cdunite='"+id_unite+"'";
									Statement instruction5 = con.createStatement();
									ResultSet rs5 = instruction5.executeQuery(sql5);
									while(rs5.next())
									{
										  String lib=rs5.getString("lbunite");
										  if(lib!=null)
											 aux.setLibelle_unite(lib);
									}
									}catch(Exception e5){logger.error(e5+"requete =  "+sql5);}

					
				}
			}
			catch (Exception e) 
			{aux=null;
			logger.error(e+"requete =  "+sql);
			}
		   
		   return aux ;
		   
	   }
	 
	 
	 public boolean update(ArticleForm frm)
	 {boolean res=true;

	 
		String id_article=frm.getId_article().replace("'", "''");
		String libelle_article=frm.getLibelle_article().replace("'", "''");
		String id_famille_principale=frm.getId_famille_principale().replace("'", "''"); 
		String id_famille_secondaire=frm.getId_famille_secondaire().replace("'", "''");
		String id_type_article=(frm.getId_type_article()!=null)?"'"+frm.getId_type_article().replace("'", "''")+"'":"''";
		String id_categorie_article=frm.getId_categorie_article().replace("'", "''");
		String id_unite=(frm.getId_unite()!=null)?"'"+frm.getId_unite().replace("'", "''")+"'":"''";
		String descreption=frm.getDescreption().replace("'", "''");
		String symbole_reference=frm.getSymbole_reference().replace("'", "''"); 
		String prix_referenciel=(!frm.getPrix_referenciel().equals(""))?frm.getPrix_referenciel().replace("'", "''"):"null";
		String prix_avant_tax=(!frm.getPrix_avant_tax().equals(""))?frm.getPrix_avant_tax().replace("'", "''"):"null";
		String prix_achat=(!frm.getPrix_achat().equals(""))?frm.getPrix_achat().replace("'", "''"):"null";
		String moyenne_prix=(!frm.getMoyenne_prix().equals(""))?frm.getMoyenne_prix().replace("'", "''"):"null";
		String prix_limite_min=(!frm.getPrix_limite_min().equals(""))?frm.getPrix_limite_min().replace("'", "''"):"null";
		String limite_redistribution=(!frm.getLimite_redistribution().equals(""))?frm.getLimite_redistribution().replace("'", "''"):"null";
		String symbole_poto=frm.getSymbole_poto().replace("'", "''"); 
		String desc_mois=(!frm.getDesc_mois().equals(""))?frm.getDesc_mois().replace("'", "''"):"null";
		String desc_qte=(!frm.getDesc_qte().equals(""))?frm.getDesc_qte().replace("'", "''"):"null";
		String limite_min=(!frm.getLimite_min().equals(""))?frm.getLimite_min().replace("'", "''"):"null";
		String qte_min=(!frm.getQte_min().equals(""))?frm.getQte_min().replace("'", "''"):"null";
		String depence_apprivois=(!frm.getDepence_apprivois().equals(""))?frm.getDepence_apprivois().replace("'", "''"):"null";
		String qte_economique=(!frm.getQte_economique().equals(""))?frm.getQte_economique().replace("'", "''"):"null";
		String qte_fabrique=(!frm.getQte_fabrique().equals(""))?frm.getQte_fabrique().replace("'", "''"):"null";
		String qte_stocke=(!frm.getQte_stocke().equals(""))?frm.getQte_stocke().replace("'", "''"):"null";
		String qte_embalage=(!frm.getQte_embalage().equals(""))?frm.getQte_embalage().replace("'", "''"):"null";
		String poids_net=(!frm.getPoids_net().equals(""))?frm.getPoids_net().replace("'", "''"):"null";
		String volume=(!frm.getVolume().equals(""))?frm.getVolume().replace("'", "''") :"null";
		String superfici=(!frm.getSuperfici().equals(""))?frm.getSuperfici().replace("'", "''") :"null";
		String longeure	=(!frm.getLongeure().equals(""))?frm.getLongeure().replace("'", "''")	:"null";	
		String periode_validite=(frm.isPeriode_validite())?"o":"n";
		String sortie_pour_vehicule=(frm.isSortie_pour_vehicule())?"o":"n"; 
		String sortie_pour_service=(frm.isSortie_pour_service())?"o":"n";
		String stocke=(frm.isStocke())?"o":"n";
		String premier=(frm.isPremier())?"o":"n";
		String boite=(frm.isBoite())?"o":"n"; 
		String compose=(frm.isCompose())?"o":"n"; 
		String combustible=(frm.isCombustible())?"o":"n"; 
		String huile=(frm.isHuile())?"o":"n";
		String rechange=(frm.isRechange())?"o":"n";
		String pneu=(frm.isPneu())?"o":"n"; 
		String pneu1=(frm.isPneu1())?"o":"n";
		String divers=(frm.isDivers())?"o":"n";
	
		
		 String sql ="";
		 
	 
	 sql = "update article set ";
		sql=sql+" cdartic='"+id_article+"',lbartic='"+libelle_article+"',cdfamart='"+id_famille_principale+"',cdsfart='"+id_famille_secondaire+"',cdtypar="+id_type_article+",";
		sql=sql+"cdnatar='"+id_categorie_article+"',cdunite="+id_unite+",desc_art='"+descreption+"',reference='"+symbole_reference+"',prix_ref="+prix_referenciel+",prix_ht="+prix_avant_tax+",prix_ach=";
		sql=sql+prix_achat+",pmp_art="+moyenne_prix+",s_alerte="+prix_limite_min+",s_reap="+limite_redistribution+",cdbar1='"+symbole_poto+"',norme_mois="+desc_mois+",norme_km="+desc_qte+",s_max=";
		sql=sql+limite_min+",qte_min="+qte_min+",frai_ap="+depence_apprivois+",qte_eco="+qte_economique+",qte_fab="+qte_fabrique+",qte_stock="+qte_stocke+",qte_embl="+qte_embalage+",perissa='"+periode_validite+"',sort_mac=";
		sql=sql+"'"+sortie_pour_vehicule+"',sort_ser='"+sortie_pour_service+"',art_stoc='"+stocke+"',art_pri='"+premier+"',art_com='"+boite+"',art_compo='"+compose+"',carburant='"+combustible+"',lubrifiant='"+huile+"',";
		sql=sql+"pieces='"+rechange+"',pneus='"+pneu+"',pneusrechap='"+pneu1+"',autresart='"+divers+"',poid_net="+poids_net+",volume="+volume+",surface="+superfici+",longueur="+longeure;
		sql=sql+" where cdartic='"+id_article+"'";
	 
	 
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
	 
	 
	 
	 public ArrayList<ArticleForm> select (String id_sec,String id_princi)
	 {String and="";
			 ArrayList<ArticleForm> l = new  ArrayList<ArticleForm>();
			   
			 if(id_sec.equals("xxxxxx")&&id_princi.equals("xxxxxx"))
				 return all();
			 else{
				 

				 if(!id_sec.equals("xxxxxx")&&!id_princi.equals("xxxxxx"))
					 and=" and ";
				 
				 if(id_sec.equals("xxxxxx"))
					 id_sec="";
				 else id_sec=" cdsfart='"+id_sec+"'";
				 
				 if(id_princi.equals("xxxxxx"))
					 id_princi="";
				 else id_princi=" cdfamart='"+id_princi+"'";
				 
			 
				String sql = " SELECT * FROM article where  "+id_sec+and+id_princi ;
			   

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
					
				}
				catch (Exception e) 
				{l=new  ArrayList<ArticleForm>();
				logger.error(e+"requete =  "+sql);
				}
			 }
			
			   return inverse(l) ;

			   
		   }
	 
	 public ArrayList<ArticleForm> inverse(ArrayList<ArticleForm> l)
	 {
		 ArrayList<ArticleForm> res=new ArrayList<ArticleForm>();
		 for(int i=l.size()-1;i>=0;i--)
			 res.add(l.get(i));
		 return res;
	 }
}
