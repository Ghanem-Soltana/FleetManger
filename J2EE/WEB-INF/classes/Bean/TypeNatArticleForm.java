package Bean;

import org.apache.struts.action.ActionForm;

public class TypeNatArticleForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_natarticle="";
	private String libelle_natarticle ="";
	
	
	
	public TypeNatArticleForm() {
		super();
	}
	
	public TypeNatArticleForm(String id, String libelle) {
		super();
		this.id_natarticle = id;
		this.libelle_natarticle = libelle;
	}

	public String getId_natarticle() {
		return id_natarticle;
	}

	public void setId_natarticle(String id_natarticle) {
		this.id_natarticle = id_natarticle;
	}

	public String getLibelle_natarticle() {
		return libelle_natarticle;
	}

	public void setLibelle_natarticle(String libelle_natarticle) {
		this.libelle_natarticle = libelle_natarticle;
	}
	
	

}
