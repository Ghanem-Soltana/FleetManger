package Bean;

import org.apache.struts.action.ActionForm;

public class TypeCompteurForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_compteur="";
	private String libelle_compteur ="";
	public TypeCompteurForm() {
		super();
	}
	public TypeCompteurForm(String id_compteur, String libelle_compteur) {
		super();
		this.id_compteur = id_compteur;
		this.libelle_compteur = libelle_compteur;
	}
	public String getId_compteur() {
		return id_compteur;
	}
	public void setId_compteur(String id_compteur) {
		this.id_compteur = id_compteur;
	}
	public String getLibelle_compteur() {
		return libelle_compteur;
	}
	public void setLibelle_compteur(String libelle_compteur) {
		this.libelle_compteur = libelle_compteur;
	}

	
}
