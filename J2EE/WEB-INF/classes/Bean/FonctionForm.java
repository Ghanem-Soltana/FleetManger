package Bean;

import org.apache.struts.action.ActionForm;

public class FonctionForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_fonction="";
	private String libelle_fonction ="";
	
	
	
	public FonctionForm() {
		super();
	}
	
	public FonctionForm(String id, String libelle) {
		super();
		this.id_fonction = id;
		this.libelle_fonction = libelle;
	}

	public String getId_fonction() {
		return id_fonction;
	}

	public void setId_fonction(String id_fonction) {
		this.id_fonction = id_fonction;
	}

	public String getLibelle_fonction() {
		return libelle_fonction;
	}

	public void setLibelle_fonction(String libelle_fonction) {
		this.libelle_fonction = libelle_fonction;
	}
	
	

}
