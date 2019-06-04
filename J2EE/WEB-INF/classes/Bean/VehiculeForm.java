package Bean;

import org.apache.struts.action.ActionForm;

public class VehiculeForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String id_vehicule="";
	private String libelle_vehicule="";
	private String id_modele="";
	private String libelle_modele="";
	private String id_marque="";
	private String libelle_marque="";
	private String id_categorie="";
	private String libelle_categorie="";
	private String id_station="";
	private String libelle_station="";
	private String referrence="";
	private String serie="";
	private String date_fabrication="";
	private String date_achat="";
	private String date_utilisation="";
	private String prix_achat="";
	private String prix_assurance="";
	private String prix_consommation="";
	private String moukhatit="";
	private String num_manjami="";
	private String nb_place_assi="";
	private String nb_place_debout="";
	private String puissance_vapeur="";
	private String nb_cylindre="";
	private String poids_vide="";
	private String poids_supporte="";
	private String compteur="";
	private String myenne_kilometrage="";
	private String moyenne_consommation="";
	private String remarque="";
	private boolean imprime=false;
	private boolean arret=false;
	private String date_arret="";

	public VehiculeForm(String id_vehicule, String libelle_vehicule,
			String id_modele, String libelle_modele, String id_marque,
			String libelle_marque, String id_categorie, String libelle_categorie) {
		super();
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_modele = id_modele;
		this.libelle_modele = libelle_modele;
		this.id_marque = id_marque;
		this.libelle_marque = libelle_marque;
		this.id_categorie = id_categorie;
		this.libelle_categorie = libelle_categorie;
	}
	public VehiculeForm() {
		super();

	}
	public VehiculeForm(String id_vehicule, String libelle_vehicule,
			String id_modele, String libelle_modele, String id_marque,
			String libelle_marque, String id_categorie,
			String libelle_categorie, String id_station,
			String libelle_station, String referrence, String serie,
			String date_fabrication, String date_achat,
			String date_utilisation, String prix_achat, String prix_assurance,
			String prix_consommation, String moukhatit, String num_manjami,
			String nb_place_assi, String nb_place_debout,
			String puissance_vapeur, String nb_cylindre, String poids_vide,
			String poids_supporte, String compteur, String myenne_kilometrage,
			String moyenne_consommation, String remarque, boolean imprime,
			boolean arret, String date_arret) {
		super();
		this.id_vehicule = id_vehicule;
		this.libelle_vehicule = libelle_vehicule;
		this.id_modele = id_modele;
		this.libelle_modele = libelle_modele;
		this.id_marque = id_marque;
		this.libelle_marque = libelle_marque;
		this.id_categorie = id_categorie;
		this.libelle_categorie = libelle_categorie;
		this.id_station = id_station;
		this.libelle_station = libelle_station;
		this.referrence = referrence;
		this.serie = serie;
		this.date_fabrication = date_fabrication;
		this.date_achat = date_achat;
		this.date_utilisation = date_utilisation;
		this.prix_achat = prix_achat;
		this.prix_assurance = prix_assurance;
		this.prix_consommation = prix_consommation;
		this.moukhatit = moukhatit;
		this.num_manjami = num_manjami;
		this.nb_place_assi = nb_place_assi;
		this.nb_place_debout = nb_place_debout;
		this.puissance_vapeur = puissance_vapeur;
		this.nb_cylindre = nb_cylindre;
		this.poids_vide = poids_vide;
		this.poids_supporte = poids_supporte;
		this.compteur = compteur;
		this.myenne_kilometrage = myenne_kilometrage;
		this.moyenne_consommation = moyenne_consommation;
		this.remarque = remarque;
		this.imprime = imprime;
		this.arret = arret;
		this.date_arret = date_arret;
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
	public String getId_modele() {
		return id_modele;
	}
	public void setId_modele(String id_modele) {
		this.id_modele = id_modele;
	}
	public String getLibelle_modele() {
		return libelle_modele;
	}
	public void setLibelle_modele(String libelle_modele) {
		this.libelle_modele = libelle_modele;
	}
	public String getId_marque() {
		return id_marque;
	}
	public void setId_marque(String id_marque) {
		this.id_marque = id_marque;
	}
	public String getLibelle_marque() {
		return libelle_marque;
	}
	public void setLibelle_marque(String libelle_marque) {
		this.libelle_marque = libelle_marque;
	}
	public String getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(String id_categorie) {
		this.id_categorie = id_categorie;
	}
	public String getLibelle_categorie() {
		return libelle_categorie;
	}
	public void setLibelle_categorie(String libelle_categorie) {
		this.libelle_categorie = libelle_categorie;
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
	public String getReferrence() {
		return referrence;
	}
	public void setReferrence(String referrence) {
		this.referrence = referrence;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getDate_fabrication() {
		return date_fabrication;
	}
	public void setDate_fabrication(String date_fabrication) {
		this.date_fabrication = date_fabrication;
	}
	public String getDate_achat() {
		return date_achat;
	}
	public void setDate_achat(String date_achat) {
		this.date_achat = date_achat;
	}
	public String getDate_utilisation() {
		return date_utilisation;
	}
	public void setDate_utilisation(String date_utilisation) {
		this.date_utilisation = date_utilisation;
	}
	public String getPrix_achat() {
		return prix_achat;
	}
	public void setPrix_achat(String prix_achat) {
		this.prix_achat = prix_achat;
	}
	public String getPrix_assurance() {
		return prix_assurance;
	}
	public void setPrix_assurance(String prix_assurance) {
		this.prix_assurance = prix_assurance;
	}
	public String getPrix_consommation() {
		return prix_consommation;
	}
	public void setPrix_consommation(String prix_consommation) {
		this.prix_consommation = prix_consommation;
	}
	public String getMoukhatit() {
		return moukhatit;
	}
	public void setMoukhatit(String moukhatit) {
		this.moukhatit = moukhatit;
	}
	public String getNum_manjami() {
		return num_manjami;
	}
	public void setNum_manjami(String num_manjami) {
		this.num_manjami = num_manjami;
	}
	public String getNb_place_assi() {
		return nb_place_assi;
	}
	public void setNb_place_assi(String nb_place_assi) {
		this.nb_place_assi = nb_place_assi;
	}
	public String getNb_place_debout() {
		return nb_place_debout;
	}
	public void setNb_place_debout(String nb_place_debout) {
		this.nb_place_debout = nb_place_debout;
	}
	public String getPuissance_vapeur() {
		return puissance_vapeur;
	}
	public void setPuissance_vapeur(String puissance_vapeur) {
		this.puissance_vapeur = puissance_vapeur;
	}
	public String getNb_cylindre() {
		return nb_cylindre;
	}
	public void setNb_cylindre(String nb_cylindre) {
		this.nb_cylindre = nb_cylindre;
	}
	public String getPoids_vide() {
		return poids_vide;
	}
	public void setPoids_vide(String poids_vide) {
		this.poids_vide = poids_vide;
	}
	public String getPoids_supporte() {
		return poids_supporte;
	}
	public void setPoids_supporte(String poids_supporte) {
		this.poids_supporte = poids_supporte;
	}
	public String getCompteur() {
		return compteur;
	}
	public void setCompteur(String compteur) {
		this.compteur = compteur;
	}
	public String getMyenne_kilometrage() {
		return myenne_kilometrage;
	}
	public void setMyenne_kilometrage(String myenne_kilometrage) {
		this.myenne_kilometrage = myenne_kilometrage;
	}
	public String getMoyenne_consommation() {
		return moyenne_consommation;
	}
	public void setMoyenne_consommation(String moyenne_consommation) {
		this.moyenne_consommation = moyenne_consommation;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public boolean isImprime() {
		return imprime;
	}
	public void setImprime(boolean imprime) {
		this.imprime = imprime;
	}
	public boolean isArret() {
		return arret;
	}
	public void setArret(boolean arret) {
		this.arret = arret;
	}
	public String getDate_arret() {
		return date_arret;
	}
	public void setDate_arret(String date_arret) {
		this.date_arret = date_arret;
	}


	
	
}
