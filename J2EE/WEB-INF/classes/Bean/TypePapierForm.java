package Bean;

import org.apache.struts.action.ActionForm;

public class TypePapierForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_papier="";
	private String libelle_papier ="";
	public TypePapierForm() {
		super();
	}
	public TypePapierForm(String id_papier, String libelle_papier) {
		super();
		this.id_papier = id_papier;
		this.libelle_papier = libelle_papier;
	}
	public String getId_papier() {
		return id_papier;
	}
	public void setId_papier(String id_papier) {
		this.id_papier = id_papier;
	}
	public String getLibelle_papier() {
		return libelle_papier;
	}
	public void setLibelle_papier(String libelle_papier) {
		this.libelle_papier = libelle_papier;
	}
	
}
