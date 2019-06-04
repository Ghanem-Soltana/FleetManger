package Bean;

import org.apache.struts.action.ActionForm;

public class VilleForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_ville="";
	private String libelle_ville ="";
	private String cp;
	public VilleForm() {
		super();
	}
	public VilleForm(String id_ville, String libelle_ville, String cp) {
		super();
		this.id_ville = id_ville;
		this.libelle_ville = libelle_ville;
		this.cp = cp;
	}
	public String getId_ville() {
		return id_ville;
	}
	public void setId_ville(String id_ville) {
		this.id_ville = id_ville;
	}
	public String getLibelle_ville() {
		return libelle_ville;
	}
	public void setLibelle_ville(String libelle_ville) {
		this.libelle_ville = libelle_ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}

}
