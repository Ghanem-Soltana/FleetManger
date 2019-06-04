package Bean;

import org.apache.struts.action.ActionForm;

public class TypeArticleForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_article="";
	private String libelle_article ="";
	
	
	
	public TypeArticleForm() {
		super();
	}
	
	public TypeArticleForm(String id, String libelle) {
		super();
		this.id_article = id;
		this.libelle_article = libelle;
	}

	public String getId_article() {
		return id_article;
	}

	public void setId_article(String id_article) {
		this.id_article = id_article;
	}

	public String getLibelle_article() {
		return libelle_article;
	}

	public void setLibelle_article(String libelle_article) {
		this.libelle_article = libelle_article;
	}
	
	

}
