package Bean;

import org.apache.struts.action.ActionForm;

public class AgenceForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String id_agence;
	private String libelle_agence;
	private String id_centre="";
	private String libelle_centre ="";
	public AgenceForm() {
		super();
	}
	public AgenceForm(String id_agence, String libelle_agence,
			String id_centre, String libelle_centre) {
		super();
		this.id_agence = id_agence;
		this.libelle_agence = libelle_agence;
		this.id_centre = id_centre;
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
	
	
}
