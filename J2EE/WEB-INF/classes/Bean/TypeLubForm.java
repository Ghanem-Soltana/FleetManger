package Bean;



import org.apache.struts.action.ActionForm;

public class TypeLubForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_typelub="";
	private String libelle_typelub ="";
	private String libelle_famart="";
	private String libelle_sfamart="";
	private String libelle_article="";
	private String id_famart="";
	private String id_sfamart="";
	private String id_article="";


	public TypeLubForm(String id_typelub, String libelle_typelub,String id_famart,
			String libelle_famart, String id_sfamart,String libelle_sfamart,String id_article,
			String libelle_article
			) {
		super();
		this.id_typelub = id_typelub;
		this.libelle_typelub = libelle_typelub;
		this.libelle_famart = libelle_famart;
		this.libelle_sfamart = libelle_sfamart;
		this.libelle_article = libelle_article;
		this.id_famart = id_famart;
		this.id_sfamart = id_sfamart;
		this.id_article = id_article;
	}
	public TypeLubForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId_typelub() {
		return id_typelub;
	}
	public void setId_typelub(String id_typelub) {
		this.id_typelub = id_typelub;
	}
	public String getLibelle_typelub() {
		return libelle_typelub;
	}
	public void setLibelle_typelub(String libelle_typelub) {
		this.libelle_typelub = libelle_typelub;
	}
	public String getLibelle_famart() {
		return libelle_famart;
	}
	public void setLibelle_famart(String libelle_famart) {
		this.libelle_famart = libelle_famart;
	}
	public String getLibelle_sfamart() {
		return libelle_sfamart;
	}
	public void setLibelle_sfamart(String libelle_sfamart) {
		this.libelle_sfamart = libelle_sfamart;
	}
	public String getLibelle_article() {
		return libelle_article;
	}
	public void setLibelle_article(String libelle_article) {
		this.libelle_article = libelle_article;
	}
	public String getId_famart() {
		return id_famart;
	}
	public void setId_famart(String id_famart) {
		this.id_famart = id_famart;
	}
	public String getId_sfamart() {
		return id_sfamart;
	}
	public void setId_sfamart(String id_sfamart) {
		this.id_sfamart = id_sfamart;
	}
	public String getId_article() {
		return id_article;
	}
	public void setId_article(String id_article) {
		this.id_article = id_article;
	}




    

	
	
	
	
}