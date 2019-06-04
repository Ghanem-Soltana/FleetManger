package Bean;

import org.apache.struts.action.ActionForm;

public class TypeCarburantForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_carburant="";
	private String libelle_carburant="";
	private String id_magasin="";
	private String id_article="";
	private String liste_article="";
	
	
	
	public TypeCarburantForm(String id_carburant, String libelle_carburant,
			String id_magasin, String id_article, String liste_article) {
		super();
		this.id_carburant = id_carburant;
		this.libelle_carburant = libelle_carburant;
		this.id_magasin = id_magasin;
		this.id_article = id_article;
		this.liste_article = liste_article;
	}

	public TypeCarburantForm(String id_carburant, String libelle_carburant) {
		super();
		this.id_carburant = id_carburant;
		this.libelle_carburant = libelle_carburant;
	}

	public TypeCarburantForm() {
		super();
	}
	
	public TypeCarburantForm(String id, String libelle, String magasin, String article) {
		super();
		this.id_carburant = id;
		this.libelle_carburant = libelle;
		this.id_magasin=magasin;
		this.id_article=article;
	}

	public String getid_carburant() {
		return id_carburant;
	}

	public void setid_carburant(String id_carburant) {
		this.id_carburant = id_carburant;
	}

	public String getlibelle_carburant() {
		return libelle_carburant;
	}

	public void setlibelle_carburant(String libelle_carburant) {
		this.libelle_carburant = libelle_carburant;
	}
	
	public String getid_magasin() {
		return id_magasin;
	}

	public void setid_magasint(String magasin) {
		this.id_magasin = magasin;
	}	
	
	public String getid_article() {
		return id_article;
	}

	public void setid_article(String article) {
		this.id_article = article;
	}

	public String getListe_article() {
		return liste_article;
	}

	public void setListe_article(String liste_article) {
		this.liste_article = liste_article;
	}	

}
