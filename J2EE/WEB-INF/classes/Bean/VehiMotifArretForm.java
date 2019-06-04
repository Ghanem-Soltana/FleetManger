package Bean;


import org.apache.struts.action.ActionForm;



public class VehiMotifArretForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_vehicule;
	private String libelle_vehicule;
	private String id_arret;
	private String libelle_arret;
	private String date_debut;
	private String date_fin;
	public VehiMotifArretForm() {
		super();

	}
	public VehiMotifArretForm(String id_vehicule, String libelle_vehicule,
			String id_arret, String libelle_arret, String date_debut,
			String date_fin) {
		super();
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_arret = id_arret;
		this.libelle_arret = libelle_arret;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public String getId_vehicule() {
		return id_vehicule;
	}
	public void setId_vehicule(String id_vehicule) {
		this.id_vehicule = id_vehicule;
	}
	public String getLibelle_vehicule() {
		return libelle_vehicule;
	}
	public void setLibelle_vehicule(String libelle_vehicule) {
		this.libelle_vehicule = libelle_vehicule;
	}
	public String getId_arret() {
		return id_arret;
	}
	public void setId_arret(String id_arret) {
		this.id_arret = id_arret;
	}
	public String getLibelle_arret() {
		return libelle_arret;
	}
	public void setLibelle_arret(String libelle_arret) {
		this.libelle_arret = libelle_arret;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}


}




