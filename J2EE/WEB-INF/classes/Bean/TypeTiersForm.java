package Bean;

import org.apache.struts.action.ActionForm;

public class TypeTiersForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_tiers="";
	private String libelle_tiers ="";
	public TypeTiersForm() {
		super();
	}
	public TypeTiersForm(String id_tiers, String libelle_tiers) {
		super();
		this.id_tiers = id_tiers;
		this.libelle_tiers = libelle_tiers;
	}
	public String getId_tiers() {
		return id_tiers;
	}
	public void setId_tiers(String id_tiers) {
		this.id_tiers = id_tiers;
	}
	public String getLibelle_tiers() {
		return libelle_tiers;
	}
	public void setLibelle_tiers(String libelle_tiers) {
		this.libelle_tiers = libelle_tiers;
	}
	
}
