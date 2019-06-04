package Action;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;




import Bean.UploadForm;
import Dao.Conn;
import Dao.FicheSocieteDao;
public final class UploadAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {


	    	HttpSession session = req.getSession();
		   UploadForm theForm = (UploadForm) form;
		   FormFile file = theForm.getfile();
		   session.removeAttribute("erreur1");


		   	Conn cnx=new Conn();
		   	FicheSocieteDao fdao=new FicheSocieteDao(cnx.getcnx());
		   	int id=fdao.getnb();
	 if(file.getFileSize()<=(60000))
     {try{
		
	
    	 File supp=new File(req.getSession().getServletContext().getRealPath("/images/societe/logo"+(id-1)+".gif"));
    	if(supp.exists())
    	{
    		supp.delete();
    	}
    	
    	
		   OutputStream os = new FileOutputStream(req.getSession().getServletContext().getRealPath("/images/societe/logo"+id+".gif"));
		   InputStream is = new BufferedInputStream(file.getInputStream());
		   int count;
		   byte buf[] = new byte[4096];
		   while ((count = is.read(buf)) > -1) {
		     os.write(buf, 0, count);
		   }
		   is.close(); 
		   os.close();
        fdao.updatenb();
        session.setAttribute("nb", String.valueOf(id));
     }catch(Exception e){System.out.print(e);}
     }
	 else 
		 
		 {session.setAttribute("erreur1", "er_soci_image_taille"); }



		
		return mapping.findForward("ok");
	}

	
}

