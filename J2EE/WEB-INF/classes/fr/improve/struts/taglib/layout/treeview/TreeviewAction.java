package fr.improve.struts.taglib.layout.treeview;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.improve.struts.taglib.layout.menu.MenuComponent;
import fr.improve.struts.taglib.layout.menu.MenuRepository;

/**
 * Print in the output stream the content of the treeview node specified by the request parameters.
 * 
 * @author jnribette
 */
public class TreeviewAction extends Action {
	public ActionForward execute(ActionMapping mapping,
	                 ActionForm form,
	                 HttpServletRequest request,
	                 HttpServletResponse response)
	    throws IOException, ServletException {

			if (request.getParameter("iframe")!=null) {
				response.getOutputStream().print("<html><boby></body></html>");
				return null;
			}
		
	    	String lc_name = request.getParameter("name");	    	
	    	StringBuffer lc_buffer = new StringBuffer();
	    	String lc_path = request.getParameter("open");
	    	String lc_bundle = request.getParameter("bundle");
	    	String lc_styleClass = request.getParameter("class");	    	
	    	
	    	// Find the menu
	    	MenuRepository lc_repository = (MenuRepository) request.getSession().getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
	    	MenuComponent lc_menu = null;
	    	
	    	if (lc_repository!=null) {
	    		lc_menu = lc_repository.getMenu(lc_name);
	    	}
	    	if (lc_menu==null) {
	    		lc_repository = (MenuRepository) getServlet().getServletContext().getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
	    		lc_menu = lc_repository.getMenu(lc_name);
	    	}	    	
	    	
	    	// Find the node
	    	String lc_childPath = lc_path.substring(lc_path.indexOf('*')+1);
	    	MenuComponent lc_childMenu = TreeViewReconciler.getComponentWithPath(lc_menu, lc_childPath);
	    	/*
	    	StringTokenizer lc_tokenizer = new StringTokenizer(lc_path, "*");
	    	lc_tokenizer.nextToken();
	    	while (lc_tokenizer.hasMoreTokens()) {
	    		String lc_token = lc_tokenizer.nextToken();
	    		lc_menus = lc_menus[Integer.parseInt(lc_token)].getMenuComponents();
	    	}
	    	*/
	    	// Generate the node content.
    		try {
		    	TreeViewTag.doPrintMenu(lc_buffer, lc_childMenu.getMenuComponents(), request, getServlet().getServletContext(), lc_bundle, lc_path, lc_name, lc_styleClass==null ? "" : lc_styleClass);
    		} catch (JspException e) {
    			throw new ServletException(e.getMessage());
    		}
			
			
			// Replace all " by \"
			for (int i = 0; i < lc_buffer.length(); i++) {
				if (lc_buffer.charAt(i)=='"') {
					lc_buffer.insert(i, "\\");
					i += 1;
				}
			}
				    	
	    	// Print the code.
	    	response.getOutputStream().println("<script type=\"text/javascript\">");
	    	response.getOutputStream().print("window.parent.loadTree(\"");
	    	response.getOutputStream().print(lc_path);
	    	response.getOutputStream().print("\", \"");
	    	response.getOutputStream().print("<table border=\\\"0\\\" cellspacing=\\\"0\\\" cellpadding=\\\"0\\\">");
	    	response.getOutputStream().print(lc_buffer.toString());
	    	response.getOutputStream().print("</table>");
	    	response.getOutputStream().print("\");");
			response.getOutputStream().println("</script>");
	    	return null;
    }

}
