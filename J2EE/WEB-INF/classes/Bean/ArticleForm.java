package Bean;

import org.apache.struts.action.ActionForm;

public class ArticleForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String id_article;
	private String libelle_article;
	private String id_famille_principale;
	private String libelle_famille_principale;
	private String id_famille_secondaire;
	private String libelle_famille_secondaire;
	private String id_type_article;
	private String libelle_type_article;
	private String id_categorie_article;
	private String libelle_categorie_article;
	private String id_unite;
	private String libelle_unite;
	private String descreption;
	private String symbole_reference;
	private String prix_referenciel;
	private String prix_avant_tax;
	private String prix_achat;
	private String moyenne_prix;
	private String prix_limite_min;
	private String limite_redistribution;
	private String symbole_poto;
	private String desc_mois;
	private String desc_qte;
	private String limite_min;
	private String qte_min;
	private String depence_apprivois;
	private String qte_economique;
	private String qte_fabrique;
	private String qte_stocke;
	private String qte_embalage;
	private boolean periode_validite;
	private boolean sortie_pour_vehicule;
	private boolean sortie_pour_service;
	private boolean stocke;
	private boolean premier;
	private boolean boite;
	private boolean compose;
	private boolean combustible;
	private boolean huile;
	private boolean rechange;
	private boolean pneu;
	private boolean pneu1;
	private boolean divers;
	private String poids_net;
	private String volume;
	private String superfici;
	private String longeure;

	
	public ArticleForm() {
		super();
	}
	public ArticleForm(String id_article, String libelle_article,
			String id_famille_principale, String libelle_famille_principale,
			String id_famille_secondaire, String libelle_famille_secondaire,
			String id_type_article, String libelle_type_article,
			String id_categorie_article, String libelle_categorie_article,
			String id_unite, String libelle_unite, String descreption,
			String symbole_reference, String prix_referenciel,
			String prix_avant_tax, String prix_achat, String moyenne_prix,
			String prix_limite_min, String limite_redistribution,
			String symbole_poto, String desc_mois, String desc_qte,
			String limite_min, String qte_min, String depence_apprivois,
			String qte_economique, String qte_fabrique, String qte_stocke,
			String qte_embalage, boolean periode_validite,
			boolean sortie_pour_vehicule, boolean sortie_pour_service, boolean stocke, boolean premier,
			boolean boite, boolean compose, boolean combustible, boolean huile,
			boolean rechange, boolean pneu, boolean pneu1, boolean divers,
			String poids_net, String volume, String superfici, String longeure) {
		super();
		this.id_article = id_article;
		this.libelle_article = libelle_article;
		this.id_famille_principale = id_famille_principale;
		this.libelle_famille_principale = libelle_famille_principale;
		this.id_famille_secondaire = id_famille_secondaire;
		this.libelle_famille_secondaire = libelle_famille_secondaire;
		this.id_type_article = id_type_article;
		this.libelle_type_article = libelle_type_article;
		this.id_categorie_article = id_categorie_article;
		this.libelle_categorie_article = libelle_categorie_article;
		this.id_unite = id_unite;
		this.libelle_unite = libelle_unite;
		this.descreption = descreption;
		this.symbole_reference = symbole_reference;
		this.prix_referenciel = prix_referenciel;
		this.prix_avant_tax = prix_avant_tax;
		this.prix_achat = prix_achat;
		this.moyenne_prix = moyenne_prix;
		this.prix_limite_min = prix_limite_min;
		this.limite_redistribution = limite_redistribution;
		this.symbole_poto = symbole_poto;
		this.desc_mois = desc_mois;
		this.desc_qte = desc_qte;
		this.limite_min = limite_min;
		this.qte_min = qte_min;
		this.depence_apprivois = depence_apprivois;
		this.qte_economique = qte_economique;
		this.qte_fabrique = qte_fabrique;
		this.qte_stocke = qte_stocke;
		this.qte_embalage = qte_embalage;
		this.periode_validite = periode_validite;
		this.sortie_pour_vehicule = sortie_pour_vehicule;
		this.sortie_pour_service = sortie_pour_service;
		this.stocke = stocke;
		this.premier = premier;
		this.boite = boite;
		this.compose = compose;
		this.combustible = combustible;
		this.huile = huile;
		this.rechange = rechange;
		this.pneu = pneu;
		this.pneu1 = pneu1;
		this.divers = divers;
		this.poids_net = poids_net;
		this.volume = volume;
		this.superfici = superfici;
		this.longeure = longeure;
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
	public String getId_famille_principale() {
		return id_famille_principale;
	}
	public void setId_famille_principale(String id_famille_principale) {
		this.id_famille_principale = id_famille_principale;
	}
	public String getLibelle_famille_principale() {
		return libelle_famille_principale;
	}
	public void setLibelle_famille_principale(String libelle_famille_principale) {
		this.libelle_famille_principale = libelle_famille_principale;
	}
	public String getId_famille_secondaire() {
		return id_famille_secondaire;
	}
	public void setId_famille_secondaire(String id_famille_secondaire) {
		this.id_famille_secondaire = id_famille_secondaire;
	}
	public String getLibelle_famille_secondaire() {
		return libelle_famille_secondaire;
	}
	public void setLibelle_famille_secondaire(String libelle_famille_secondaire) {
		this.libelle_famille_secondaire = libelle_famille_secondaire;
	}
	public String getId_type_article() {
		return id_type_article;
	}
	public void setId_type_article(String id_type_article) {
		this.id_type_article = id_type_article;
	}
	public String getLibelle_type_article() {
		return libelle_type_article;
	}
	public void setLibelle_type_article(String libelle_type_article) {
		this.libelle_type_article = libelle_type_article;
	}
	public String getId_categorie_article() {
		return id_categorie_article;
	}
	public void setId_categorie_article(String id_categorie_article) {
		this.id_categorie_article = id_categorie_article;
	}
	public String getLibelle_categorie_article() {
		return libelle_categorie_article;
	}
	public void setLibelle_categorie_article(String libelle_categorie_article) {
		this.libelle_categorie_article = libelle_categorie_article;
	}
	public String getId_unite() {
		return id_unite;
	}
	public void setId_unite(String id_unite) {
		this.id_unite = id_unite;
	}
	public String getLibelle_unite() {
		return libelle_unite;
	}
	public void setLibelle_unite(String libelle_unite) {
		this.libelle_unite = libelle_unite;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public String getSymbole_reference() {
		return symbole_reference;
	}
	public void setSymbole_reference(String symbole_reference) {
		this.symbole_reference = symbole_reference;
	}
	public String getPrix_referenciel() {
		return prix_referenciel;
	}
	public void setPrix_referenciel(String prix_referenciel) {
		this.prix_referenciel = prix_referenciel;
	}
	public String getPrix_avant_tax() {
		return prix_avant_tax;
	}
	public void setPrix_avant_tax(String prix_avant_tax) {
		this.prix_avant_tax = prix_avant_tax;
	}
	public String getPrix_achat() {
		return prix_achat;
	}
	public void setPrix_achat(String prix_achat) {
		this.prix_achat = prix_achat;
	}
	public String getMoyenne_prix() {
		return moyenne_prix;
	}
	public void setMoyenne_prix(String moyenne_prix) {
		this.moyenne_prix = moyenne_prix;
	}
	public String getPrix_limite_min() {
		return prix_limite_min;
	}
	public void setPrix_limite_min(String prix_limite_min) {
		this.prix_limite_min = prix_limite_min;
	}
	public String getLimite_redistribution() {
		return limite_redistribution;
	}
	public void setLimite_redistribution(String limite_redistribution) {
		this.limite_redistribution = limite_redistribution;
	}
	public String getSymbole_poto() {
		return symbole_poto;
	}
	public void setSymbole_poto(String symbole_poto) {
		this.symbole_poto = symbole_poto;
	}
	public String getDesc_mois() {
		return desc_mois;
	}
	public void setDesc_mois(String desc_mois) {
		this.desc_mois = desc_mois;
	}
	public String getDesc_qte() {
		return desc_qte;
	}
	public void setDesc_qte(String desc_qte) {
		this.desc_qte = desc_qte;
	}
	public String getLimite_min() {
		return limite_min;
	}
	public void setLimite_min(String limite_min) {
		this.limite_min = limite_min;
	}
	public String getQte_min() {
		return qte_min;
	}
	public void setQte_min(String qte_min) {
		this.qte_min = qte_min;
	}
	public String getDepence_apprivois() {
		return depence_apprivois;
	}
	public void setDepence_apprivois(String depence_apprivois) {
		this.depence_apprivois = depence_apprivois;
	}
	public String getQte_economique() {
		return qte_economique;
	}
	public void setQte_economique(String qte_economique) {
		this.qte_economique = qte_economique;
	}
	public String getQte_fabrique() {
		return qte_fabrique;
	}
	public void setQte_fabrique(String qte_fabrique) {
		this.qte_fabrique = qte_fabrique;
	}
	public String getQte_stocke() {
		return qte_stocke;
	}
	public void setQte_stocke(String qte_stocke) {
		this.qte_stocke = qte_stocke;
	}
	public String getQte_embalage() {
		return qte_embalage;
	}
	public void setQte_embalage(String qte_embalage) {
		this.qte_embalage = qte_embalage;
	}
	public boolean isPeriode_validite() {
		return periode_validite;
	}
	public void setPeriode_validite(boolean periode_validite) {
		this.periode_validite = periode_validite;
	}
	public boolean isSortie_pour_vehicule() {
		return sortie_pour_vehicule;
	}
	public void setSortie_pour_vehicule(boolean sortie_pour_vehicule) {
		this.sortie_pour_vehicule = sortie_pour_vehicule;
	}
	public boolean isSortie_pour_service() {
		return sortie_pour_service;
	}
	public void setSortie_pour_service(boolean sortie_pour_service) {
		this.sortie_pour_service = sortie_pour_service;
	}
	public boolean isStocke() {
		return stocke;
	}
	public void setStocke(boolean stocke) {
		this.stocke = stocke;
	}
	public boolean isPremier() {
		return premier;
	}
	public void setPremier(boolean premier) {
		this.premier = premier;
	}
	public boolean isBoite() {
		return boite;
	}
	public void setBoite(boolean boite) {
		this.boite = boite;
	}
	public boolean isCompose() {
		return compose;
	}
	public void setCompose(boolean compose) {
		this.compose = compose;
	}
	public boolean isCombustible() {
		return combustible;
	}
	public void setCombustible(boolean combustible) {
		this.combustible = combustible;
	}
	public boolean isHuile() {
		return huile;
	}
	public void setHuile(boolean huile) {
		this.huile = huile;
	}
	public boolean isRechange() {
		return rechange;
	}
	public void setRechange(boolean rechange) {
		this.rechange = rechange;
	}
	public boolean isPneu() {
		return pneu;
	}
	public void setPneu(boolean pneu) {
		this.pneu = pneu;
	}
	public boolean isPneu1() {
		return pneu1;
	}
	public void setPneu1(boolean pneu1) {
		this.pneu1 = pneu1;
	}
	public boolean isDivers() {
		return divers;
	}
	public void setDivers(boolean divers) {
		this.divers = divers;
	}
	public String getPoids_net() {
		return poids_net;
	}
	public void setPoids_net(String poids_net) {
		this.poids_net = poids_net;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getSuperfici() {
		return superfici;
	}
	public void setSuperfici(String superfici) {
		this.superfici = superfici;
	}
	public String getLongeure() {
		return longeure;
	}
	public void setLongeure(String longeure) {
		this.longeure = longeure;
	}
	
	
}
