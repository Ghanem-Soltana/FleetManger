package Bean;

import org.apache.struts.action.ActionForm;

public class TiersForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_tiers="";
	private String libelle_tiers ="";
	private String matricule_fiscale ="";
	private String tel_tiers ="";
	private String blockage_tiers ="";
	private String adresse_tiers ="";
	private String cp_tiers ="";
	private String fax_tiers ="";
	private String remarque_tiers ="";
	private String mail_tiers ="";
	private String contact_tiers ="";
	private String id_type_tiers="";
	private String libelle_type_tiers ="";
	
	public TiersForm() {
		super();
	}

	public TiersForm(String id_tiers, String libelle_tiers,
			String matricule_fiscale, String tel_tiers, String blockage_tiers,
			String adresse_tiers, String cp_tiers, String fax_tiers,
			String remarque_tiers, String mail_tiers, String contact_tiers,
			String id_type_tiers, String libelle_type_tiers) {
		super();
		this.id_tiers = id_tiers;
		this.libelle_tiers = libelle_tiers;
		this.matricule_fiscale = matricule_fiscale;
		this.tel_tiers = tel_tiers;
		this.blockage_tiers = blockage_tiers;
		this.adresse_tiers = adresse_tiers;
		this.cp_tiers = cp_tiers;
		this.fax_tiers = fax_tiers;
		this.remarque_tiers = remarque_tiers;
		this.mail_tiers = mail_tiers;
		this.contact_tiers = contact_tiers;
		this.id_type_tiers = id_type_tiers;
		this.libelle_type_tiers = libelle_type_tiers;
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

	public String getMatricule_fiscale() {
		return matricule_fiscale;
	}

	public void setMatricule_fiscale(String matricule_fiscale) {
		this.matricule_fiscale = matricule_fiscale;
	}

	public String getTel_tiers() {
		return tel_tiers;
	}

	public void setTel_tiers(String tel_tiers) {
		this.tel_tiers = tel_tiers;
	}

	public String getBlockage_tiers() {
		return blockage_tiers;
	}

	public void setBlockage_tiers(String blockage_tiers) {
		this.blockage_tiers = blockage_tiers;
	}

	public String getAdresse_tiers() {
		return adresse_tiers;
	}

	public void setAdresse_tiers(String adresse_tiers) {
		this.adresse_tiers = adresse_tiers;
	}

	public String getCp_tiers() {
		return cp_tiers;
	}

	public void setCp_tiers(String cp_tiers) {
		this.cp_tiers = cp_tiers;
	}

	public String getFax_tiers() {
		return fax_tiers;
	}

	public void setFax_tiers(String fax_tiers) {
		this.fax_tiers = fax_tiers;
	}

	public String getRemarque_tiers() {
		return remarque_tiers;
	}

	public void setRemarque_tiers(String remarque_tiers) {
		this.remarque_tiers = remarque_tiers;
	}

	public String getMail_tiers() {
		return mail_tiers;
	}

	public void setMail_tiers(String mail_tiers) {
		this.mail_tiers = mail_tiers;
	}

	public String getContact_tiers() {
		return contact_tiers;
	}

	public void setContact_tiers(String contact_tiers) {
		this.contact_tiers = contact_tiers;
	}

	public String getId_type_tiers() {
		return id_type_tiers;
	}

	public void setId_type_tiers(String id_type_tiers) {
		this.id_type_tiers = id_type_tiers;
	}

	public String getLibelle_type_tiers() {
		return libelle_type_tiers;
	}

	public void setLibelle_type_tiers(String libelle_type_tiers) {
		this.libelle_type_tiers = libelle_type_tiers;
	}
	
}
