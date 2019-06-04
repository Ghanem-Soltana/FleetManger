package Bean;

import org.apache.struts.action.ActionForm;

public class FamArticleSecForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String id_famille_sec;
	private String libelle_famille_sec;
	private String id_famille_princi="";
	private String libelle_famille_princi ="";
	public FamArticleSecForm() {
		super();
	}
	public FamArticleSecForm(String id_famille_sec, String libelle_famille_sec,
			String id_famille_princi, String libelle_famille_princi) {
		super();
		this.id_famille_sec = id_famille_sec;
		this.libelle_famille_sec = libelle_famille_sec;
		this.id_famille_princi = id_famille_princi;
		this.libelle_famille_princi = libelle_famille_princi;
	}
	public String getId_famille_sec() {
		return id_famille_sec;
	}
	public void setId_famille_sec(String id_famille_sec) {
		this.id_famille_sec = id_famille_sec;
	}
	public String getLibelle_famille_sec() {
		return libelle_famille_sec;
	}
	public void setLibelle_famille_sec(String libelle_famille_sec) {
		this.libelle_famille_sec = libelle_famille_sec;
	}
	public String getId_famille_princi() {
		return id_famille_princi;
	}
	public void setId_famille_princi(String id_famille_princi) {
		this.id_famille_princi = id_famille_princi;
	}
	public String getLibelle_famille_princi() {
		return libelle_famille_princi;
	}
	public void setLibelle_famille_princi(String libelle_famille_princi) {
		this.libelle_famille_princi = libelle_famille_princi;
	}

	
}
