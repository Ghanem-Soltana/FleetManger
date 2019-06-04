package Bean;

import org.apache.struts.action.ActionForm;

public class DistInitCptForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
private String id_type_cpt="";
private String libelle_type_cpt="";
private String id_vehicue="";
private String libelle_vehicue="";
private String date="";
private String cpt_inital="";
public DistInitCptForm() {
	super();
}
public DistInitCptForm(String id_type_cpt, String libelle_type_cpt,
		String id_vehicue, String libelle_vehicue, String date,
		String cpt_inital) {
	super();
	this.id_type_cpt = id_type_cpt;
	this.libelle_type_cpt = libelle_type_cpt;
	this.id_vehicue = id_vehicue;
	this.libelle_vehicue = libelle_vehicue;
	this.date = date;
	this.cpt_inital = cpt_inital;
}
public String getId_type_cpt() {
	return id_type_cpt;
}
public void setId_type_cpt(String id_type_cpt) {
	this.id_type_cpt = id_type_cpt;
}
public String getLibelle_type_cpt() {
	return libelle_type_cpt;
}
public void setLibelle_type_cpt(String libelle_type_cpt) {
	this.libelle_type_cpt = libelle_type_cpt;
}
public String getId_vehicue() {
	return id_vehicue;
}
public void setId_vehicue(String id_vehicue) {
	this.id_vehicue = id_vehicue;
}
public String getLibelle_vehicue() {
	return libelle_vehicue;
}
public void setLibelle_vehicue(String libelle_vehicue) {
	this.libelle_vehicue = libelle_vehicue;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getCpt_inital() {
	return cpt_inital;
}
public void setCpt_inital(String cpt_inital) {
	this.cpt_inital = cpt_inital;
}


}
