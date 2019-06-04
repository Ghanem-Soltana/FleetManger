package Bean;

import org.apache.struts.action.ActionForm;

public class TypeMatiereForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_matiere="";
	private String libelle_matiere ="";
	public TypeMatiereForm() {
		super();
	}
	public TypeMatiereForm(String id_matiere, String libelle_matiere) {
		super();
		this.id_matiere = id_matiere;
		this.libelle_matiere = libelle_matiere;
	}
	public String getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(String id_matiere) {
		this.id_matiere = id_matiere;
	}
	public String getLibelle_matiere() {
		return libelle_matiere;
	}
	public void setLibelle_matiere(String libelle_matiere) {
		this.libelle_matiere = libelle_matiere;
	}

	
}
