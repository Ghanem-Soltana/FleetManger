package Bean;



import org.apache.struts.action.ActionForm;

public class ModeleVehiForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_modelevehi="";
	private String libelle_modelevehi ="";
    private String qte_vidange="";
    private String tx_appoint="";
    private String nb_jour="";
    private String releve="";
    private String id_energie="";
    private String libelle_energie="";


    
	public ModeleVehiForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModeleVehiForm(String id_modelevehi, String libelle_modelevehi,
			String qte_vidange, String tx_appoint, String nb_jour, String releve,
			String id_energie, String libelle_energie) {
		super();
		this.id_modelevehi = id_modelevehi;
		this.libelle_modelevehi = libelle_modelevehi;
		this.qte_vidange = qte_vidange;
		this.tx_appoint = tx_appoint;
		this.nb_jour = nb_jour;
		this.releve = releve;
		this.id_energie = id_energie;
		this.libelle_energie = libelle_energie;

	}
	public String getId_modelevehi() {
		return id_modelevehi;
	}
	public void setId_modelevehi(String id_modelevehi) {
		this.id_modelevehi = id_modelevehi;
	}
	public String getLibelle_modelevehi() {
		return libelle_modelevehi;
	}
	public void setLibelle_modelevehi(String libelle_modelevehi) {
		this.libelle_modelevehi = libelle_modelevehi;
	}
	public String getQte_vidange() {
		return qte_vidange;
	}
	public void setQte_vidange(String qte_vidange) {
		this.qte_vidange = qte_vidange;
	}
	public String getTx_appoint() {
		return tx_appoint;
	}
	public void setTx_appoint(String tx_appoint) {
		this.tx_appoint = tx_appoint;
	}
	public String getNb_jour() {
		return nb_jour;
	}
	public void setNb_jour(String nb_jour) {
		this.nb_jour = nb_jour;
	}
	public String getReleve() {
		return releve;
	}
	public void setReleve(String releve) {
		this.releve = releve;
	}
	public String getId_energie() {
		return id_energie;
	}
	public void setId_energie(String id_energie) {
		this.id_energie = id_energie;
	}
	public String getLibelle_energie() {
		return libelle_energie;
	}
	public void setLibelle_energie(String libelle_energie) {
		this.libelle_energie = libelle_energie;
	}

	
	
	
	
}