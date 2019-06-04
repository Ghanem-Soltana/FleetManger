package Bean;

import org.apache.struts.action.ActionForm;

public class TypeUniteForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_unite="";
	private String libelle_unite ="";
	private String decimale="";
	public TypeUniteForm() {
		super();
	
	}
	public TypeUniteForm(String id_unite, String libelle_unite, String decimale) {
		super();
		this.id_unite = id_unite;
		this.libelle_unite = libelle_unite;
		this.decimale = decimale;
	}
	public String getId_unite() {
		return id_unite;
	}
	public void setId_unite(String id_unite) {
		this.id_unite = id_unite;
	}
	public String getLibelle_unite() {
		return libelle_unite;
	}
	public void setLibelle_unite(String libelle_unite) {
		this.libelle_unite = libelle_unite;
	}
	public String getDecimale() {
		return decimale;
	}
	public void setDecimale(String decimale) {
		this.decimale = decimale;
	}



	
}
