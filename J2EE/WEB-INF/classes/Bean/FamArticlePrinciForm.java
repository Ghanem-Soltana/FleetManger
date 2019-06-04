package Bean;

import org.apache.struts.action.ActionForm;

public class FamArticlePrinciForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_famille_princi="";
	private String libelle_famille_princi ="";
	private boolean impression;
	private boolean stocke;
	public FamArticlePrinciForm() {
		super();
	}
	public FamArticlePrinciForm(String id_famille_princi,
			String libelle_famille_princi, boolean impression, boolean stocké) {
		super();
		this.id_famille_princi = id_famille_princi;
		this.libelle_famille_princi = libelle_famille_princi;
		this.impression = impression;
		this.stocke = stocké;
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
	public boolean isImpression() {
		return impression;
	}
	public void setImpression(boolean impression) {
		this.impression = impression;
	}
	public boolean isStocke() {
		return stocke;
	}
	public void setStocke(boolean stocké) {
		this.stocke = stocké;
	}



}
