package Bean;



import org.apache.struts.action.ActionForm;

public class BonEssenceForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_bon="";
	private String libelle_bon ="";
    private String qte_bon="";
    private String valeur_bon="";
	public BonEssenceForm() {
		super();
	}
	public BonEssenceForm(String id_bon, String libelle_bon, String qte_bon,
			String valeur_bon) {
		super();
		this.id_bon = id_bon;
		this.libelle_bon = libelle_bon;
		this.qte_bon = qte_bon;
		this.valeur_bon = valeur_bon;
	}
	public String getId_bon() {
		return id_bon;
	}
	public void setId_bon(String id_bon) {
		this.id_bon = id_bon;
	}
	public String getLibelle_bon() {
		return libelle_bon;
	}
	public void setLibelle_bon(String libelle_bon) {
		this.libelle_bon = libelle_bon;
	}
	public String getQte_bon() {
		return qte_bon;
	}
	public void setQte_bon(String qte_bon) {
		this.qte_bon = qte_bon;
	}
	public String getValeur_bon() {
		return valeur_bon;
	}
	public void setValeur_bon(String valeur_bon) {
		this.valeur_bon = valeur_bon;
	}
   
	
}