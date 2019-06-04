package Bean;



import org.apache.struts.action.ActionForm;

public class UtilisateurForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String login_utilisateur="";
	private String nom_utilisateur="";
	private String prenom_utilisateur="";
	private String date_naissance="";
	private String privilege="";
	private String mot_passe1="";
	private String mot_passe2="";
	public UtilisateurForm() {
		super();
		privilege="admin.";
	}
	public UtilisateurForm(String login_utilisateur, String nom_utilisateur,
			String prenom_utilisateur, String date_naissance, String privilege,
			String mot_passe1, String mot_passe2) {
		super();
		this.login_utilisateur = login_utilisateur;
		this.nom_utilisateur = nom_utilisateur;
		this.prenom_utilisateur = prenom_utilisateur;
		this.date_naissance = date_naissance;
		this.privilege = privilege;
		this.mot_passe1 = mot_passe1;
		this.mot_passe2 = mot_passe2;
	}
	public String getLogin_utilisateur() {
		return login_utilisateur;
	}
	public void setLogin_utilisateur(String login_utilisateur) {
		this.login_utilisateur = login_utilisateur;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}
	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getMot_passe1() {
		return mot_passe1;
	}
	public void setMot_passe1(String mot_passe1) {
		this.mot_passe1 = mot_passe1;
	}
	public String getMot_passe2() {
		return mot_passe2;
	}
	public void setMot_passe2(String mot_passe2) {
		this.mot_passe2 = mot_passe2;
	}
	

    
	
}