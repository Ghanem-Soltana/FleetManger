package Bean;

import org.apache.struts.action.ActionForm;

public class BonTransfertForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
private String id_exercice="";
private String libelle_exercice="";
private String id_transfert="";
private String date_transfert="";
private String id_magasin_depart="";
private String libelle_magasin_depart="";
private String id_magasinier_donneur="";
private String libelle_magasinier_donneur="";
private String id_magasin_arrive="";
private String libelle_magasin_arrive="";
private String id_magasinier_recepteur="";
private String libelle_magasinier_recepteur="";
private String id_type_bon="";
private String libelle_type_bon="";
private String stock_type_bon="";
private String numero="";
private String serie="";
private String de="";
private String a="";
private String quantite_transfere="";
private String valeur_transfere="";
private String valide="";
public BonTransfertForm() {
	super();
	valide="n";
}

public BonTransfertForm(String id_exercice, String libelle_exercice,
		String id_transfert, String date_transfert, String id_magasin_depart,
		String libelle_magasin_depart, String id_magasinier_donneur,
		String libelle_magasinier_donneur, String id_magasin_arrive,
		String libelle_magasin_arrive, String id_magasinier_recepteur,
		String libelle_magasinier_recepteur, String id_type_bon,
		String libelle_type_bon, String stock_type_bon, String numero,
		String serie, String de, String a, String quantite_transfere,
		String valeur_transfere,String valide) {
	super();
	this.id_exercice = id_exercice;
	this.libelle_exercice = libelle_exercice;
	this.id_transfert = id_transfert;
	this.date_transfert = date_transfert;
	this.id_magasin_depart = id_magasin_depart;
	this.libelle_magasin_depart = libelle_magasin_depart;
	this.id_magasinier_donneur = id_magasinier_donneur;
	this.libelle_magasinier_donneur = libelle_magasinier_donneur;
	this.id_magasin_arrive = id_magasin_arrive;
	this.libelle_magasin_arrive = libelle_magasin_arrive;
	this.id_magasinier_recepteur = id_magasinier_recepteur;
	this.libelle_magasinier_recepteur = libelle_magasinier_recepteur;
	this.id_type_bon = id_type_bon;
	this.libelle_type_bon = libelle_type_bon;
	this.stock_type_bon = stock_type_bon;
	this.numero = numero;
	this.serie = serie;
	this.de = de;
	this.a = a;
	this.quantite_transfere = quantite_transfere;
	this.valeur_transfere = valeur_transfere;
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
public String getId_transfert() {
	return id_transfert;
}
public void setId_transfert(String id_transfert) {
	this.id_transfert = id_transfert;
}
public String getDate_transfert() {
	return date_transfert;
}
public void setDate_transfert(String date_transfert) {
	this.date_transfert = date_transfert;
}
public String getId_magasin_depart() {
	return id_magasin_depart;
}
public void setId_magasin_depart(String id_magasin_depart) {
	this.id_magasin_depart = id_magasin_depart;
}
public String getLibelle_magasin_depart() {
	return libelle_magasin_depart;
}
public void setLibelle_magasin_depart(String libelle_magasin_depart) {
	this.libelle_magasin_depart = libelle_magasin_depart;
}
public String getId_magasinier_donneur() {
	return id_magasinier_donneur;
}
public void setId_magasinier_donneur(String id_magasinier_donneur) {
	this.id_magasinier_donneur = id_magasinier_donneur;
}
public String getLibelle_magasinier_donneur() {
	return libelle_magasinier_donneur;
}
public void setLibelle_magasinier_donneur(String libelle_magasinier_donneur) {
	this.libelle_magasinier_donneur = libelle_magasinier_donneur;
}
public String getId_magasin_arrive() {
	return id_magasin_arrive;
}
public void setId_magasin_arrive(String id_magasin_arrive) {
	this.id_magasin_arrive = id_magasin_arrive;
}
public String getLibelle_magasin_arrive() {
	return libelle_magasin_arrive;
}
public void setLibelle_magasin_arrive(String libelle_magasin_arrive) {
	this.libelle_magasin_arrive = libelle_magasin_arrive;
}
public String getId_magasinier_recepteur() {
	return id_magasinier_recepteur;
}
public void setId_magasinier_recepteur(String id_magasinier_recepteur) {
	this.id_magasinier_recepteur = id_magasinier_recepteur;
}
public String getLibelle_magasinier_recepteur() {
	return libelle_magasinier_recepteur;
}
public void setLibelle_magasinier_recepteur(String libelle_magasinier_recepteur) {
	this.libelle_magasinier_recepteur = libelle_magasinier_recepteur;
}
public String getId_type_bon() {
	return id_type_bon;
}
public void setId_type_bon(String id_type_bon) {
	this.id_type_bon = id_type_bon;
}
public String getLibelle_type_bon() {
	return libelle_type_bon;
}
public void setLibelle_type_bon(String libelle_type_bon) {
	this.libelle_type_bon = libelle_type_bon;
}
public String getStock_type_bon() {
	return stock_type_bon;
}
public void setStock_type_bon(String stock_type_bon) {
	this.stock_type_bon = stock_type_bon;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getSerie() {
	return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public String getDe() {
	return de;
}
public void setDe(String de) {
	this.de = de;
}
public String getA() {
	return a;
}
public void setA(String a) {
	this.a = a;
}
public String getQuantite_transfere() {
	return quantite_transfere;
}
public void setQuantite_transfere(String quantite_transfere) {
	this.quantite_transfere = quantite_transfere;
}
public String getValeur_transfere() {
	return valeur_transfere;
}
public void setValeur_transfere(String valeur_transfere) {
	this.valeur_transfere = valeur_transfere;
}

public String getValide() {
	return valide;
}

public void setValide(String valide) {
	this.valide = valide;
}

}
