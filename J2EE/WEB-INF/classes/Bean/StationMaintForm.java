package Bean;

import org.apache.struts.action.ActionForm;

public class StationMaintForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String id_station="";
	private String libelle_station ="";
	public StationMaintForm() {
		super();
	}
	public StationMaintForm(String id_station, String libelle_station) {
		super();
		this.id_station = id_station;
		this.libelle_station = libelle_station;
	}
	public String getId_station() {
		return id_station;
	}
	public void setId_station(String id_station) {
		this.id_station = id_station;
	}
	public String getLibelle_station() {
		return libelle_station;
	}
	public void setLibelle_station(String libelle_station) {
		this.libelle_station = libelle_station;
	}
	
	
	


}
