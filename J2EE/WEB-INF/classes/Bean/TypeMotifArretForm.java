package Bean;

import org.apache.struts.action.ActionForm;

public class TypeMotifArretForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_motif="";
	private String libelle_motif ="";
	public TypeMotifArretForm() {
		super();
	}
	public TypeMotifArretForm(String id_motif, String libelle_motif) {
		super();
		this.id_motif = id_motif;
		this.libelle_motif = libelle_motif;
	}
	public String getId_motif() {
		return id_motif;
	}
	public void setId_motif(String id_motif) {
		this.id_motif = id_motif;
	}
	public String getLibelle_motif() {
		return libelle_motif;
	}
	public void setLibelle_motif(String libelle_motif) {
		this.libelle_motif = libelle_motif;
	}

}