package Bean;


import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;


public class UploadForm extends ActionForm {
	

	private static final long serialVersionUID = 1L;
	protected FormFile file;


	public UploadForm() {
		super();
	}

	public UploadForm(FormFile file) {
		super();
		this.file = file;
	}

	public FormFile getfile() 
	   {   
	      return file;
	   }

	   public void setFile(FormFile file) 
	   {
	      this.file = file;
	   }


}

