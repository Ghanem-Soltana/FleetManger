package Bean;

import org.apache.struts.action.ActionForm;

public class ServiceForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String id_service;
	private String libelle_service;
	private String id_centre="";
	private String libelle_centre ="";
	private String id_agence="";
	private String libelle_agence ="";
	public ServiceForm() {
		super();
	}
	public ServiceForm(String id_service, String libelle_service,
			String id_centre, String libelle_centre, String id_agence,
			String libelle_agence) {
		super();
		this.id_service = id_service;
		this.libelle_service = libelle_service;
		this.id_centre = id_centre;
		this.libelle_centre = libelle_centre;
		this.id_agence = id_agence;
		this.libelle_agence = libelle_agence;
	}
	public String getId_service() {
		return id_service;
	}
	public void setId_service(String id_service) {
		this.id_service = id_service;
	}
	public String getLibelle_service() {
		return libelle_service;
	}
	public void setLibelle_service(String libelle_service) {
		this.libelle_service = libelle_service;
	}
	public String getId_centre() {
		return id_centre;
	}
	public void setId_centre(String id_centre) {
		this.id_centre = id_centre;
	}
	public String getLibelle_centre() {
		return libelle_centre;
	}
	public void setLibelle_centre(String libelle_centre) {
		this.libelle_centre = libelle_centre;
	}
	public String getId_agence() {
		return id_agence;
	}
	public void setId_agence(String id_agence) {
		this.id_agence = id_agence;
	}
	public String getLibelle_agence() {
		return libelle_agence;
	}
	public void setLibelle_agence(String libelle_agence) {
		this.libelle_agence = libelle_agence;
	}
	
}
