package Bean;
import org.apache.struts.action.ActionForm;

public class BlockerForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_blocker="";
	private String libelle_blocker ="";
	public BlockerForm() {
		super();
	}
	public BlockerForm(String id_blocker, String libelle_blocker) {
		super();
		this.id_blocker = id_blocker;
		this.libelle_blocker = libelle_blocker;
	}
	public String getId_blocker() {
		return id_blocker;
	}
	public void setId_blocker(String id_blocker) {
		this.id_blocker = id_blocker;
	}
	public String getLibelle_blocker() {
		return libelle_blocker;
	}
	public void setLibelle_blocker(String libelle_blocker) {
		this.libelle_blocker = libelle_blocker;
	}
	
}
