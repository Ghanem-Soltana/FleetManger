package Bean;

import org.apache.struts.action.ActionForm;

public class TypeSpecialiteForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_specialite="";
	private String libelle_specialite ="";
	
	
	
	public TypeSpecialiteForm() {
		super();
	}
	
	public TypeSpecialiteForm(String id, String libelle) {
		super();
		this.id_specialite = id;
		this.libelle_specialite = libelle;
	}

	public String getId_specialite() {
		return id_specialite;
	}

	public void setId_specialite(String id_specialite) {
		this.id_specialite = id_specialite;
	}

	public String getLibelle_specialite() {
		return libelle_specialite;
	}

	public void setLibelle_specialite(String libelle_specialite) {
		this.libelle_specialite = libelle_specialite;
	}
	
	

}
