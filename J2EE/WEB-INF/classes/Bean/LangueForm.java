package Bean;

import org.apache.struts.action.ActionForm;

public class LangueForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String langue="";
	private String libelle_langue="";
	private String page="";
	public LangueForm(String langue, String libelle_langue, String page) {
		super();
		this.langue = langue;
		this.libelle_langue = libelle_langue;
		this.page = page;
	}
	public LangueForm() {
		super();
		this.langue="fr";
	}
	public LangueForm(String langue, String page) {
		super();
		this.langue = langue;
		this.page = page;
	
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getLibelle_langue() {
		return libelle_langue;
	}
	public void setLibelle_langue(String libelle_langue) {
		this.libelle_langue = libelle_langue;
	}

}
