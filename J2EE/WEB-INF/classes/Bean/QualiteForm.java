package Bean;

import org.apache.struts.action.ActionForm;

public class QualiteForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_qualite="";
	private String libelle_qualite ="";
	public QualiteForm() {
		super();
	}
	public QualiteForm(String id_qualite, String libelle_qualite) {
		super();
		this.id_qualite = id_qualite;
		this.libelle_qualite = libelle_qualite;
	}
	public String getId_qualite() {
		return id_qualite;
	}
	public void setId_qualite(String id_qualite) {
		this.id_qualite = id_qualite;
	}
	public String getLibelle_qualite() {
		return libelle_qualite;
	}
	public void setLibelle_qualite(String libelle_qualite) {
		this.libelle_qualite = libelle_qualite;
	}



}
