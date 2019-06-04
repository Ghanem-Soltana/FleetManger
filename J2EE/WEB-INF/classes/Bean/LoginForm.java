package Bean;
import org.apache.struts.action.*;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm {
	
  private String login = "";
  private String mdp = "";
  boolean auto;
  boolean rapel;
  
public LoginForm() {
	super();
}
public LoginForm(boolean auto, boolean rapel) {
	super();
	this.auto = auto;
	this.rapel = rapel;
}
public LoginForm(String login, String mdp, boolean auto, boolean rapel) {
	super();
	this.login = login;
	this.mdp = mdp;
	this.auto = auto;
	this.rapel = rapel;
}

public LoginForm(String login, String mdp) {
	super();
	this.login = login;
	this.mdp = mdp;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public boolean isAuto() {
	return auto;
}
public void setAuto(boolean auto) {
	this.auto = auto;
}
public boolean isRapel() {
	return rapel;
}
public void setRapel(boolean rapel) {
	this.rapel = rapel;
}

	
}

