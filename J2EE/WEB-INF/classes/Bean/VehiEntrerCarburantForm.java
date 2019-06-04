package Bean;

import org.apache.struts.action.ActionForm;

public class VehiEntrerCarburantForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
private String id_exercice;
private String libelle_exercice;
private String id_bon;
private String date_entrer;
private String id_type_bon;
private String libelle_type_bon;
private String id_magasin;
private String libelle_magasin;
private String id_agent;
private String libelle_agent;
private String vld;
private String debut_bon;
private String fin_bon;
private String reference;
public VehiEntrerCarburantForm(String id_exercice, String libelle_exercice,
		String id_bon, String date_entrer, String id_type_bon,
		String libelle_type_bon, String id_magasin, String libelle_magasin,
		String id_agent, String libelle_agent, String vld, String debut_bon,
		String fin_bon,String reference) {
	super();
	this.id_exercice = id_exercice;
	this.libelle_exercice = libelle_exercice;
	this.id_bon = id_bon;
	this.date_entrer = date_entrer;
	this.id_type_bon = id_type_bon;
	this.libelle_type_bon = libelle_type_bon;
	this.id_magasin = id_magasin;
	this.libelle_magasin = libelle_magasin;
	this.id_agent = id_agent;
	this.libelle_agent = libelle_agent;
	this.vld = vld;
	this.debut_bon = debut_bon;
	this.fin_bon = fin_bon;
	this.reference=reference;
}
public VehiEntrerCarburantForm() {
	super();
	// TODO Auto-generated constructor stub
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
public String getId_bon() {
	return id_bon;
}
public void setId_bon(String id_bon) {
	this.id_bon = id_bon;
}
public String getDate_entrer() {
	return date_entrer;
}
public void setDate_entrer(String date_entrer) {
	this.date_entrer = date_entrer;
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
public String getVld() {
	return vld;
}
public void setVld(String vld) {
	this.vld = vld;
}
public String getDebut_bon() {
	return debut_bon;
}
public void setDebut_bon(String debut_bon) {
	this.debut_bon = debut_bon;
}
public String getFin_bon() {
	return fin_bon;
}
public void setFin_bon(String fin_bon) {
	this.fin_bon = fin_bon;
}

public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
	

}
