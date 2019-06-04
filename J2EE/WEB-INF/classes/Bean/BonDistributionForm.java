package Bean;

import org.apache.struts.action.ActionForm;

public class BonDistributionForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
private String id_exercice="";
private String libelle_exercice="";
private String id_distribution="";
private String date_distribution="";
private String id_magasin="";
private String libelle_magasin="";
private String id_magasinier="";
private String libelle_magasinier="";
private String id_vehicule="";
private String libelle_vehicule="";
private String id_centre="";
private String libelle_centre="";
private String id_agence="";
private String libelle_agence="";
private String id_service="";
private String libelle_service="";
private String id_recepteur="";
private String libelle_recepteur="";
private String id_dernier_recepteur="";
private String libelle_dernier_recepteur="";
private String dernier_compteur="";
private String date_dernier_compteur="";
private String dernier_quantité="";
private String distance_parcourus="";
private String taux="";
private String valide="";
public BonDistributionForm() {
	super();
}
public BonDistributionForm(String id_exercice, String libelle_exercice,
		String id_distribution, String date_distribution, String id_magasin,
		String libelle_magasin, String id_magasinier,
		String libelle_magasinier, String id_vehicule, String libelle_vehicule,
		String id_centre, String libelle_centre, String id_agence,
		String libelle_agence, String id_service, String libelle_service,
		String id_recepteur, String libelle_recepteur,
		String id_dernier_recepteur, String libelle_dernier_recepteur,
		String dernier_compteur, String date_dernier_compteur,
		String dernier_quantité, String distance_parcourus, String taux,
		String valide) {
	super();
	this.id_exercice = id_exercice;
	this.libelle_exercice = libelle_exercice;
	this.id_distribution = id_distribution;
	this.date_distribution = date_distribution;
	this.id_magasin = id_magasin;
	this.libelle_magasin = libelle_magasin;
	this.id_magasinier = id_magasinier;
	this.libelle_magasinier = libelle_magasinier;
	this.id_vehicule = id_vehicule;
	this.libelle_vehicule = libelle_vehicule;
	this.id_centre = id_centre;
	this.libelle_centre = libelle_centre;
	this.id_agence = id_agence;
	this.libelle_agence = libelle_agence;
	this.id_service = id_service;
	this.libelle_service = libelle_service;
	this.id_recepteur = id_recepteur;
	this.libelle_recepteur = libelle_recepteur;
	this.id_dernier_recepteur = id_dernier_recepteur;
	this.libelle_dernier_recepteur = libelle_dernier_recepteur;
	this.dernier_compteur = dernier_compteur;
	this.date_dernier_compteur = date_dernier_compteur;
	this.dernier_quantité = dernier_quantité;
	this.distance_parcourus = distance_parcourus;
	this.taux = taux;
	this.valide = valide;
}
public String getId_exercice() {
	return id_exercice;
}
public void setId_exercice(String id_exercice) {
	this.id_exercice = id_exercice;
}
public String getLibelle_exercice() {
	return libelle_exercice;
}
public void setLibelle_exercice(String libelle_exercice) {
	this.libelle_exercice = libelle_exercice;
}
public String getId_distribution() {
	return id_distribution;
}
public void setId_distribution(String id_distribution) {
	this.id_distribution = id_distribution;
}
public String getDate_distribution() {
	return date_distribution;
}
public void setDate_distribution(String date_distribution) {
	this.date_distribution = date_distribution;
}
public String getId_magasin() {
	return id_magasin;
}
public void setId_magasin(String id_magasin) {
	this.id_magasin = id_magasin;
}
public String getLibelle_magasin() {
	return libelle_magasin;
}
public void setLibelle_magasin(String libelle_magasin) {
	this.libelle_magasin = libelle_magasin;
}
public String getId_magasinier() {
	return id_magasinier;
}
public void setId_magasinier(String id_magasinier) {
	this.id_magasinier = id_magasinier;
}
public String getLibelle_magasinier() {
	return libelle_magasinier;
}
public void setLibelle_magasinier(String libelle_magasinier) {
	this.libelle_magasinier = libelle_magasinier;
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
public String getId_centre() {
	return id_centre;
}
public void setId_centre(String id_centre) {
	this.id_centre = id_centre;
}
public String getLibelle_centre() {
	return libelle_centre;
}
public void setLibelle_centre(String libelle_centre) {
	this.libelle_centre = libelle_centre;
}
public String getId_agence() {
	return id_agence;
}
public void setId_agence(String id_agence) {
	this.id_agence = id_agence;
}
public String getLibelle_agence() {
	return libelle_agence;
}
public void setLibelle_agence(String libelle_agence) {
	this.libelle_agence = libelle_agence;
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
public String getId_recepteur() {
	return id_recepteur;
}
public void setId_recepteur(String id_recepteur) {
	this.id_recepteur = id_recepteur;
}
public String getLibelle_recepteur() {
	return libelle_recepteur;
}
public void setLibelle_recepteur(String libelle_recepteur) {
	this.libelle_recepteur = libelle_recepteur;
}
public String getId_dernier_recepteur() {
	return id_dernier_recepteur;
}
public void setId_dernier_recepteur(String id_dernier_recepteur) {
	this.id_dernier_recepteur = id_dernier_recepteur;
}
public String getLibelle_dernier_recepteur() {
	return libelle_dernier_recepteur;
}
public void setLibelle_dernier_recepteur(String libelle_dernier_recepteur) {
	this.libelle_dernier_recepteur = libelle_dernier_recepteur;
}
public String getDernier_compteur() {
	return dernier_compteur;
}
public void setDernier_compteur(String dernier_compteur) {
	this.dernier_compteur = dernier_compteur;
}
public String getDate_dernier_compteur() {
	return date_dernier_compteur;
}
public void setDate_dernier_compteur(String date_dernier_compteur) {
	this.date_dernier_compteur = date_dernier_compteur;
}
public String getDernier_quantité() {
	return dernier_quantité;
}
public void setDernier_quantité(String dernier_quantité) {
	this.dernier_quantité = dernier_quantité;
}
public String getDistance_parcourus() {
	return distance_parcourus;
}
public void setDistance_parcourus(String distance_parcourus) {
	this.distance_parcourus = distance_parcourus;
}
public String getTaux() {
	return taux;
}
public void setTaux(String taux) {
	this.taux = taux;
}
public String getValide() {
	return valide;
}
public void setValide(String valide) {
	this.valide = valide;
}
}
