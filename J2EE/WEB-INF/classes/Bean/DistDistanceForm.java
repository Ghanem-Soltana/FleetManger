package Bean;

import org.apache.struts.action.ActionForm;

public class DistDistanceForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
private String id_distance="";
private String id_vehicule="";
private String libelle_vehicule="";
private String pourcentage_consommation="";
private String date="";
private String ancien_compteur="";
private String actuel_compteur="";
private String qté_combustible="";
private String rapport_distance_compteur="";
private String distance_reel="";
private String valide="";
private String ancienne_date="";


public DistDistanceForm(String id_distance, String id_vehicule,
		String libelle_vehicule, String pourcentage_consommation,String date,
		String ancien_compteur, String actuel_compteur, String qté_combustible,
		String rapport_distance_compteur, String distance_reel, String valide) {
	super();
	this.id_distance = id_distance;
	this.id_vehicule = id_vehicule;
	this.libelle_vehicule = libelle_vehicule;
	this.pourcentage_consommation = pourcentage_consommation;
	this.date=date;
	this.ancien_compteur = ancien_compteur;
	this.actuel_compteur = actuel_compteur;
	this.qté_combustible = qté_combustible;
	this.rapport_distance_compteur = rapport_distance_compteur;
	this.distance_reel = distance_reel;
	this.valide = valide;
}
public DistDistanceForm() {
	super();
	valide="n";
}
public String getId_distance() {
	return id_distance;
}
public void setId_distance(String id_distance) {
	this.id_distance = id_distance;
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
public String getPourcentage_consommation() {
	return pourcentage_consommation;
}
public void setPourcentage_consommation(String pourcentage_consommation) {
	this.pourcentage_consommation = pourcentage_consommation;
}
public String getAncien_compteur() {
	return ancien_compteur;
}
public void setAncien_compteur(String ancien_compteur) {
	this.ancien_compteur = ancien_compteur;
}
public String getActuel_compteur() {
	return actuel_compteur;
}
public void setActuel_compteur(String actuel_compteur) {
	this.actuel_compteur = actuel_compteur;
}
public String getQté_combustible() {
	return qté_combustible;
}
public void setQté_combustible(String qté_combustible) {
	this.qté_combustible = qté_combustible;
}
public String getRapport_distance_compteur() {
	return rapport_distance_compteur;
}
public void setRapport_distance_compteur(String rapport_distance_compteur) {
	this.rapport_distance_compteur = rapport_distance_compteur;
}
public String getDistance_reel() {
	return distance_reel;
}
public void setDistance_reel(String distance_reel) {
	this.distance_reel = distance_reel;
}
public String getValide() {
	return valide;
}
public void setValide(String valide) {
	this.valide = valide;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getAncienne_date() {
	return ancienne_date;
}
public void setAncienne_date(String ancienne_date) {
	this.ancienne_date = ancienne_date;
}


}
