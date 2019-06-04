package Bean;



import org.apache.struts.action.ActionForm;

public class AgentForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_agent="";
	private String libelle_agent ="";
    private String id_fonction="";
    private String libelle_fonction="";
    private String id_qualification="";
    private String libelle_qualification="";
    private boolean statut;

    
	public AgentForm() {
		super();
	
	}
	public AgentForm(String id_agent, String libelle_agent,
			String id_fonction, String libelle_fonction, String id_qualification, String libelle_qualification, boolean statut) {
		super();
		this.id_agent = id_agent;
		this.libelle_agent = libelle_agent;
		this.id_fonction = id_fonction;
		this.libelle_fonction = libelle_fonction;
		this.id_qualification=id_qualification;
		this.libelle_qualification=libelle_qualification;
		this.statut=statut;
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
	
	
	public String getId_qualification() {
		return id_qualification;
	}
	public void setId_qualification(String id_qualification) {
		this.id_qualification = id_qualification;
	}
	public String getLibelle_qualification() {
		return libelle_qualification;
	}
	public void setLibelle_qualification(String libelle_qualification) {
		this.libelle_qualification = libelle_qualification;
	}
	
	
	public String getId_fonction() {
		return id_fonction;
	}
	public void setId_fonction(String id_fonction) {
		this.id_fonction = id_fonction;
	}
	public String getLibelle_fonction() {
		return libelle_fonction;
	}
	public void setLibelle_fonction(String libelle_fonction) {
		this.libelle_fonction = libelle_fonction;
	}

	
		public boolean getStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	
}