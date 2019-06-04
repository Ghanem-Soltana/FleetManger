package Bean;



import org.apache.struts.action.ActionForm;

public class LaisserPasserForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_laisser_passer="";
    private String id_annee="";
    private String libelle_annee="";
    private String id_station="";
    private String libelle_station="";
    private String id_vehicule="";
    private String libelle_vehicule="";
    private String id_agent="";
    private String libelle_agent="";
    private String id_service="";
    private String libelle_service="";
    private String destination="";
    private String date_laisser_passer="";
    private String valide="n";
    private String marchandise_transporte="";
    private String objectif="";
    
    
	public LaisserPasserForm(String id_laisser_passer, String id_annee,
			String libelle_annee, String id_station, String libelle_station,
			String id_vehicule, String libelle_vehicule, String id_agent,
			String libelle_agent, String id_service, String libelle_service,
			String destination, String date_laisser_passer, String valide,
			String marchandise_transporte, String objectif) {
		super();
		this.id_laisser_passer = id_laisser_passer;
		this.id_annee = id_annee;
		this.libelle_annee = libelle_annee;
		this.id_station = id_station;
		this.libelle_station = libelle_station;
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_agent = id_agent;
		this.libelle_agent = libelle_agent;
		this.id_service = id_service;
		this.libelle_service = libelle_service;
		this.destination = destination;
		this.date_laisser_passer = date_laisser_passer;
		this.valide = valide;
		this.marchandise_transporte = marchandise_transporte;
		this.objectif = objectif;
	}
	public LaisserPasserForm() {
		super();
		this.valide = "n";
	}
	public String getId_laisser_passer() {
		return id_laisser_passer;
	}
	public void setId_laisser_passer(String id_laisser_passer) {
		this.id_laisser_passer = id_laisser_passer;
	}

	public String getId_annee() {
		return id_annee;
	}
	public void setId_annee(String id_annee) {
		this.id_annee = id_annee;
	}
	public String getLibelle_annee() {
		return libelle_annee;
	}
	public void setLibelle_annee(String libelle_annee) {
		this.libelle_annee = libelle_annee;
	}
	public String getId_station() {
		return id_station;
	}
	public void setId_station(String id_station) {
		this.id_station = id_station;
	}
	public String getLibelle_station() {
		return libelle_station;
	}
	public void setLibelle_station(String libelle_station) {
		this.libelle_station = libelle_station;
	}
	public String getId_vehicule() {
		return id_vehicule;
	}
	public void setId_vehicule(String id_vehicule) {
		this.id_vehicule = id_vehicule;
	}
	public String getLibelle_vehicule() {
		return libelle_vehicule;
	}
	public void setLibelle_vehicule(String libelle_vehicule) {
		this.libelle_vehicule = libelle_vehicule;
	}
	public String getId_agent() {
		return id_agent;
	}
	public void setId_agent(String id_agent) {
		this.id_agent = id_agent;
	}
	public String getLibelle_agent() {
		return libelle_agent;
	}
	public void setLibelle_agent(String libelle_agent) {
		this.libelle_agent = libelle_agent;
	}
	public String getId_service() {
		return id_service;
	}
	public void setId_service(String id_service) {
		this.id_service = id_service;
	}
	public String getLibelle_service() {
		return libelle_service;
	}
	public void setLibelle_service(String libelle_service) {
		this.libelle_service = libelle_service;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate_laisser_passer() {
		return date_laisser_passer;
	}
	public void setDate_laisser_passer(String date_laisser_passer) {
		this.date_laisser_passer = date_laisser_passer;
	}
	public String getValide() {
		return valide;
	}
	public void setValide(String valide) {
		this.valide = valide;
	}
	public String getMarchandise_transporte() {
		return marchandise_transporte;
	}
	public void setMarchandise_transporte(String marchandise_transporte) {
		this.marchandise_transporte = marchandise_transporte;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
    
   
}