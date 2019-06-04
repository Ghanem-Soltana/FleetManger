package Bean;

import org.apache.struts.action.ActionForm;

public class PapierVehiForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id_vehicule;
	private String libelle_vehicule;
	private String id_type_papier;
	private String libelle_type_papier;
	private String date_papier;
	private String date_debut_validation;
	private String date_fin_validation;
	private String date_annulation;
	public PapierVehiForm(String id_vehicule, String libelle_vehicule,
			String id_type_papier, String libelle_type_papier,
			String date_papier, String date_debut_validation,
			String date_fin_validation, String date_annulation) {
		super();
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_type_papier = id_type_papier;
		this.libelle_type_papier = libelle_type_papier;
		this.date_papier = date_papier;
		this.date_debut_validation = date_debut_validation;
		this.date_fin_validation = date_fin_validation;
		this.date_annulation = date_annulation;
	}
	public PapierVehiForm() {
		super();
	}
	public PapierVehiForm(String id_vehicule, String libelle_vehicule,
			String id_type_papier, String libelle_type_papier,
			String date_papier) {
		super();
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_type_papier = id_type_papier;
		this.libelle_type_papier = libelle_type_papier;
		this.date_papier = date_papier;
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
	public String getId_type_papier() {
		return id_type_papier;
	}
	public void setId_type_papier(String id_type_papier) {
		this.id_type_papier = id_type_papier;
	}
	public String getLibelle_type_papier() {
		return libelle_type_papier;
	}
	public void setLibelle_type_papier(String libelle_type_papier) {
		this.libelle_type_papier = libelle_type_papier;
	}
	public String getDate_papier() {
		return date_papier;
	}
	public void setDate_papier(String date_papier) {
		this.date_papier = date_papier;
	}
	public String getDate_debut_validation() {
		return date_debut_validation;
	}
	public void setDate_debut_validation(String date_debut_validation) {
		this.date_debut_validation = date_debut_validation;
	}
	public String getDate_fin_validation() {
		return date_fin_validation;
	}
	public void setDate_fin_validation(String date_fin_validation) {
		this.date_fin_validation = date_fin_validation;
	}
	public String getDate_annulation() {
		return date_annulation;
	}
	public void setDate_annulation(String date_annulation) {
		this.date_annulation = date_annulation;
	}
	
	
	
	
}
