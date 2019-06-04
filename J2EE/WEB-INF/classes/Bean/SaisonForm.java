package Bean;

import org.apache.struts.action.ActionForm;

public class SaisonForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_saison="";
	private String libelle_saison ="";
	private String date_debut="";
	private String date_fin="";
	private String remarque_saison="";
	private boolean cloture=false;

	public SaisonForm() {
		super();
	}
	public SaisonForm(String id_saison, String libelle_saison,
			String date_debut, String date_fin, String remarque_saison,
			boolean cloture) {
		super();
		this.id_saison = id_saison;
		this.libelle_saison = libelle_saison;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.remarque_saison = remarque_saison;
		this.cloture = cloture;

	}
	public String getId_saison() {
		return id_saison;
	}
	public void setId_saison(String id_saison) {
		this.id_saison = id_saison;
	}
	public String getLibelle_saison() {
		return libelle_saison;
	}
	public void setLibelle_saison(String libelle_saison) {
		this.libelle_saison = libelle_saison;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getRemarque_saison() {
		return remarque_saison;
	}
	public void setRemarque_saison(String remarque_saison) {
		this.remarque_saison = remarque_saison;
	}
	public boolean getCloture() {
		return cloture;
	}
	public void setCloture(boolean cloture) {
		this.cloture = cloture;
	}

	
}
