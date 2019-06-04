package Bean;



import org.apache.struts.action.ActionForm;

public class OrdreMissionForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_ordre_mission="";
    private String id_annee="";
    private String libelle_annee="";
    private String id_station="";
    private String libelle_station="";
    private String id_vehicule="";
    private String libelle_vehicule="";
    private String id_agent="";
    private String libelle_agent="";
    private String depart="";
    private String destination="";
    private String date_ordre_mission="";
    private String valide="n";
    private String marchandise_transporte="";
    private String objectif="";
    private String remarque="";
	private String accompagant="";
	public OrdreMissionForm() {
		super();
		valide="n";
	}
	public OrdreMissionForm(String id_ordre_mission, String id_annee,
			String libelle_annee, String id_station, String libelle_station,
			String id_vehicule, String libelle_vehicule, String id_agent,
			String libelle_agent, String depart, String destination,
			String date_ordre_mission, String valide,
			String marchandise_transporte, String objectif, String remarque) {
		super();
		this.id_ordre_mission = id_ordre_mission;
		this.id_annee = id_annee;
		this.libelle_annee = libelle_annee;
		this.id_station = id_station;
		this.libelle_station = libelle_station;
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_agent = id_agent;
		this.libelle_agent = libelle_agent;
		this.depart = depart;
		this.destination = destination;
		this.date_ordre_mission = date_ordre_mission;
		this.valide = valide;
		this.marchandise_transporte = marchandise_transporte;
		this.objectif = objectif;
		this.remarque = remarque;
	}
	public String getId_ordre_mission() {
		return id_ordre_mission;
	}
	public void setId_ordre_mission(String id_ordre_mission) {
		this.id_ordre_mission = id_ordre_mission;
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
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate_ordre_mission() {
		return date_ordre_mission;
	}
	public void setDate_ordre_mission(String date_ordre_mission) {
		this.date_ordre_mission = date_ordre_mission;
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
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public String getAccompagant() {
		return accompagant;
	}
	public void setAccompagant(String accompagant) {
		this.accompagant = accompagant;
	}
    
 
    
   
}