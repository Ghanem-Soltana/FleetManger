package Bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import Dao.Conn;

public class MagasinForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_magasin="";
	private String libelle_magasin ="";
	private String adresse_magasin="";
	private String tel_magasin="";
	private String fax_magasin="";
	private String nom_res="";
	private String remarque_magasin="";
	private String liste_famille="";
	private ArrayList<FamArticlePrinciForm> liste;

	public MagasinForm() {
		super();
	}
	public MagasinForm(String id_magasin, String libelle_magasin,
			String adresse_magasin, String tel_magasin, String fax_magasin,
			String nom_res, String remarque_magasin, String liste_famille) {
		super();
		this.id_magasin = id_magasin;
		this.libelle_magasin = libelle_magasin;
		this.adresse_magasin = adresse_magasin;
		this.tel_magasin = tel_magasin;
		this.fax_magasin = fax_magasin;
		this.nom_res = nom_res;
		this.remarque_magasin = remarque_magasin;
		this.liste_famille = liste_famille;
		Conn cnx=new Conn();
		Dao.FamArticlePrinciDao fdao=new Dao.FamArticlePrinciDao(cnx.getcnx());
		this.liste=fdao.lienmagasin(id_magasin);
		cnx.closecnx();
	}
	public String getId_magasin() {
		return id_magasin;
	}
	public void setId_magasin(String id_magasin) {
		this.id_magasin = id_magasin;
	}
	public String getLibelle_magasin() {
		return libelle_magasin;
	}
	public void setLibelle_magasin(String libelle_magasin) {
		this.libelle_magasin = libelle_magasin;
	}
	public String getAdresse_magasin() {
		return adresse_magasin;
	}
	public void setAdresse_magasin(String adresse_magasin) {
		this.adresse_magasin = adresse_magasin;
	}
	public String getTel_magasin() {
		return tel_magasin;
	}
	public void setTel_magasin(String tel_magasin) {
		this.tel_magasin = tel_magasin;
	}
	public String getFax_magasin() {
		return fax_magasin;
	}
	public void setFax_magasin(String fax_magasin) {
		this.fax_magasin = fax_magasin;
	}
	public String getNom_res() {
		return nom_res;
	}
	public void setNom_res(String nom_res) {
		this.nom_res = nom_res;
	}
	public String getRemarque_magasin() {
		return remarque_magasin;
	}
	public void setRemarque_magasin(String remarque_magasin) {
		this.remarque_magasin = remarque_magasin;
	}
	public String getListe_famille() {
		return liste_famille;
	}
	public void setListe_famille(String liste_famille) {
		this.liste_famille = liste_famille;
	}
	public ArrayList<FamArticlePrinciForm>  getListe() {
		return liste;
	}
	public void setListe(ArrayList<FamArticlePrinciForm> liste) {
		this.liste = liste;
	}
	
	

}
