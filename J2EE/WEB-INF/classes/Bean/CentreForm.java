package Bean;

import org.apache.struts.action.ActionForm;

public class CentreForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_centre="";
	private String libelle_centre ="";
	private String remarque_centre="";
	
	
	public CentreForm() {
		super();
	}
	public CentreForm(String id_centre, String libelle_centre,
			String remarque_centre) {
		super();
		this.id_centre = id_centre;
		this.libelle_centre = libelle_centre;
		this.remarque_centre = remarque_centre;
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
	public String getRemarque_centre() {
		return remarque_centre;
	}
	public void setRemarque_centre(String remarque_centre) {
		this.remarque_centre = remarque_centre;
	}
	
}
