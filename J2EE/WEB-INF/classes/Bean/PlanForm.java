package Bean;

import org.apache.struts.action.ActionForm;

public class PlanForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_plan;
	private String libelle_plan ="";

	public PlanForm() {
		super();

	}
	public PlanForm(String id_plan, String libelle_plan) {
		super();
		this.id_plan = id_plan;
		this.libelle_plan = libelle_plan;
	}
	public String getId_plan() {
		return id_plan;
	}
	public void setId_plan(String id_plan) {
		this.id_plan = id_plan;
	}
	public String getLibelle_plan() {
		return libelle_plan;
	}
	public void setLibelle_plan(String libelle_plan) {
		this.libelle_plan = libelle_plan;
	}

}
