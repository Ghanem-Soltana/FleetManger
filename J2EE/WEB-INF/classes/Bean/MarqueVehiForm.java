package Bean;

import org.apache.struts.action.ActionForm;

public class MarqueVehiForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_marque="";
	private String libelle_marque ="";
	public MarqueVehiForm() {
		super();
	}
	public MarqueVehiForm(String id_marque, String libelle_marque) {
		super();
		this.id_marque = id_marque;
		this.libelle_marque = libelle_marque;
	}
	public String getId_marque() {
		return id_marque;
	}
	public void setId_marque(String id_marque) {
		this.id_marque = id_marque;
	}
	public String getLibelle_marque() {
		return libelle_marque;
	}
	public void setLibelle_marque(String libelle_marque) {
		this.libelle_marque = libelle_marque;
	}



}
