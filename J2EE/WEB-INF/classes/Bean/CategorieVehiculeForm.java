package Bean;

import org.apache.struts.action.ActionForm;

public class CategorieVehiculeForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_categovehi="";
	private String libelle_categovehi ="";
	private String nbr_place="";
	
	public CategorieVehiculeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieVehiculeForm(String id_categovehi,
			String libelle_categovehi, String nbr_place) {
		super();
		this.id_categovehi = id_categovehi;
		this.libelle_categovehi = libelle_categovehi;
		this.nbr_place = nbr_place;
	}
	public String getId_categovehi() {
		return id_categovehi;
	}
	public void setId_categovehi(String id_categovehi) {
		this.id_categovehi = id_categovehi;
	}
	public String getLibelle_categovehi() {
		return libelle_categovehi;
	}
	public void setLibelle_categovehi(String libelle_categovehi) {
		this.libelle_categovehi = libelle_categovehi;
	}
	public String getNbr_place() {
		return nbr_place;
	}
	public void setNbr_place(String nbr_place) {
		this.nbr_place = nbr_place;
	}
	

	
	
	
}