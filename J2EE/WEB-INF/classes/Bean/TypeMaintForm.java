package Bean;

import org.apache.struts.action.ActionForm;

public class TypeMaintForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_maint="";
	private String libelle_maint ="";
	
	
	
	public TypeMaintForm() {
		super();
	}
	
	public TypeMaintForm(String id, String libelle) {
		super();
		this.id_maint = id;
		this.libelle_maint = libelle;
	}

	public String getId_maint() {
		return id_maint;
	}

	public void setId_maint(String id_maint) {
		this.id_maint = id_maint;
	}

	public String getLibelle_maint() {
		return libelle_maint;
	}

	public void setLibelle_maint(String libelle_maint) {
		this.libelle_maint = libelle_maint;
	}
	
	

}
