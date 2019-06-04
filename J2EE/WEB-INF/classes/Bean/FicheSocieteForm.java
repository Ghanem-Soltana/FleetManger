package Bean;

import org.apache.struts.action.ActionForm;

public class FicheSocieteForm extends ActionForm  {

	private static final long serialVersionUID = 1L;
	private String id_societe;
	private String libelle_societe;
	private String sigle;
	private String nb_jour;
	private String conge;
	private String forme_juridique;
	private String capitale;
	private String matricule_fiscale;
	private String remarque;
	private String num_rc;
	private String adresse_1;
	private String adresse_2;
	private String id_ville;
	private String annee_reporte;
	private String cp;
	private String libelle_ville;
	
	
	public FicheSocieteForm(String id_societe, String libelle_societe,
			String sigle, String nb_jour, String conge, String forme_juridique,
			String capitale, String matricule_fiscale, String remarque,
			String num_rc, String adresse_1, String adresse_2, String id_ville, String annee_reporte, String cp, String ville) {
		super();
		this.id_societe = id_societe;
		this.libelle_societe = libelle_societe;
		this.sigle = sigle;
		this.nb_jour = nb_jour;
		this.conge = conge;
		this.forme_juridique = forme_juridique;
		this.capitale = capitale;
		this.matricule_fiscale = matricule_fiscale;
		this.remarque = remarque;
		this.num_rc = num_rc;
		this.adresse_1 = adresse_1;
		this.adresse_2 = adresse_2;
		this.id_ville = id_ville;
		this.annee_reporte = annee_reporte;
		this.cp = cp;
		this.libelle_ville = ville;
	}

	public FicheSocieteForm() {
		super();
	}

	public FicheSocieteForm(String id_societe, String libelle_societe,
			String sigle, String nb_jour, String conge, String forme_juridique,
			String capitale, String matricule_fiscale, String remarque,
			String num_rc, String adresse_1, String adresse_2, String id_ville, String annee_reporté) {
		super();
		this.id_societe = id_societe;
		this.libelle_societe = libelle_societe;
		this.sigle = sigle;
		this.nb_jour = nb_jour;
		this.conge = conge;
		this.forme_juridique = forme_juridique;
		this.capitale = capitale;
		this.matricule_fiscale = matricule_fiscale;
		this.remarque = remarque;
		this.num_rc = num_rc;
		this.adresse_1 = adresse_1;
		this.adresse_2 = adresse_2;
		this.id_ville = id_ville;
		this.annee_reporte = annee_reporté;
		this.cp = "";
		this.libelle_ville = "";
	}

	public String getId_societe() {
		return id_societe;
	}

	public void setId_societe(String id_societe) {
		this.id_societe = id_societe;
	}

	public String getLibelle_societe() {
		return libelle_societe;
	}

	public void setLibelle_societe(String libelle_societe) {
		this.libelle_societe = libelle_societe;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public String getNb_jour() {
		return nb_jour;
	}

	public void setNb_jour(String nb_jour) {
		this.nb_jour = nb_jour;
	}

	public String getConge() {
		return conge;
	}

	public void setConge(String conge) {
		this.conge = conge;
	}

	public String getForme_juridique() {
		return forme_juridique;
	}

	public void setForme_juridique(String forme_juridique) {
		this.forme_juridique = forme_juridique;
	}

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}

	public String getMatricule_fiscale() {
		return matricule_fiscale;
	}

	public void setMatricule_fiscale(String matricule_fiscale) {
		this.matricule_fiscale = matricule_fiscale;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public String getNum_rc() {
		return num_rc;
	}

	public void setNum_rc(String num_rc) {
		this.num_rc = num_rc;
	}

	public String getAdresse_1() {
		return adresse_1;
	}

	public void setAdresse_1(String adresse_1) {
		this.adresse_1 = adresse_1;
	}

	public String getAdresse_2() {
		return adresse_2;
	}

	public void setAdresse_2(String adresse_2) {
		this.adresse_2 = adresse_2;
	}

	public String getId_ville() {
		return id_ville;
	}

	public void setId_ville(String id_ville) {
		this.id_ville = id_ville;
	}



	public String getAnnee_reporte() {
		return annee_reporte;
	}

	public void setAnnee_reporte(String annee_reporté) {
		this.annee_reporte = annee_reporté;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLibelle_ville() {
		return libelle_ville;
	}

	public void setLibelle_ville(String ville) {
		this.libelle_ville = ville;
	}

}
