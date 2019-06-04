package Bean;

import org.apache.struts.action.ActionForm;

public class TypeEnergieForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_energie="";
	private String libelle_energie ="";
	public TypeEnergieForm() {
		super();
	}
	public TypeEnergieForm(String id_energie, String libelle_energie) {
		super();
		this.id_energie = id_energie;
		this.libelle_energie = libelle_energie;
	}
	public String getId_energie() {
		return id_energie;
	}
	public void setId_energie(String id_energie) {
		this.id_energie = id_energie;
	}
	public String getLibelle_energie() {
		return libelle_energie;
	}
	public void setLibelle_energie(String libelle_energie) {
		this.libelle_energie = libelle_energie;
	}

	
}
