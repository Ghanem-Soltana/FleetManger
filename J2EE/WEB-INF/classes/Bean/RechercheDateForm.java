package Bean;

import org.apache.struts.action.ActionForm;

public class RechercheDateForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String debut ;
	private String fin;
	
	


	public RechercheDateForm() {
		super();
	}



	public RechercheDateForm(String debut, String fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}





	public String getDebut() {
		return debut;
	}



	public void setDebut(String debut) {
		this.debut = debut;
	}



	public String getFin() {
		return fin;
	}



	public void setFin(String fin) {
		this.fin = fin;
	}

}
