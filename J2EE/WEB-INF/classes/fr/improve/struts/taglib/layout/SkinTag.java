package fr.improve.struts.taglib.layout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import fr.improve.struts.taglib.layout.skin.Skin;
import fr.improve.struts.taglib.layout.util.HTMLUtils;
import fr.improve.struts.taglib.layout.util.LayoutUtils;
import fr.improve.struts.taglib.layout.util.TagUtils;

/**
 * Struts-Layout skin tag (&lt;layout:skin&gt;).<br>
 * This tag generates in the JSP code to : 
 * <ul>
 *  <li>Load the current Skin CSS</li>
 *  <li>Define global Javascript variables (
 *  imgsrc : server root relative skin image directory,
 *  scriptsrc : server root relatrive config directory,
 *  langue : Struts locale,
 *  contextPath : application context path)
 *  </li>
 *  <li>Load Struts-Layout Javascript (the file named javascript.js in the skin config directory); if includeScript is set to true.</li>
 * </ul>
 * 
 * Creation date: (17/06/2001 18:01:46)
 * @author: Jean-Noël Ribette
 */
public class SkinTag extends javax.servlet.jsp.tagext.TagSupport {
	/**
	 * Should we include Struts-Layout Javascript ?
	 * Default is false for background compatibility. 
	 */
	private boolean include = false;

	/**
	 * End tag callback.
	 */
	public int doEndTag() throws JspException {
		// Get the current skin.
		Skin lc_skin = LayoutUtils.getSkin(pageContext.getSession());
		
		// Load the CSS skin.
		String cssLocation = lc_skin.getCssDirectory(pageContext.getRequest())+"/"+lc_skin.getCssFileName(); 
		HTMLUtils.generateTag(pageContext, "link", new String[][]{{"rel", "stylesheet"}, {"href", cssLocation}, {"type", "text/css"}});
		
		// Generate various Javascript variables.
		HTMLUtils.openTag(pageContext, "script", new String[][]{{"type", "text/javascript"}});
		StringBuffer sb = new StringBuffer();
		sb.append("var imgsrc=\"");
		sb.append(lc_skin.getImageDirectory(pageContext.getRequest()));
		if (!lc_skin.getImageDirectory(pageContext.getRequest()).endsWith("/")) sb.append("/");
		sb.append("\"; var scriptsrc=\"");
		sb.append(lc_skin.getConfigDirectory(pageContext.getRequest()));
		if (!lc_skin.getConfigDirectory(pageContext.getRequest()).endsWith("/")) sb.append("/");		
		sb.append("\"; var langue=\"");
		sb.append(LayoutUtils.getLocale(pageContext).getLanguage());
		sb.append("\"; var contextPath=\"");
		sb.append(((HttpServletRequest)pageContext.getRequest()).getContextPath());
		sb.append("\";");
		TagUtils.write(pageContext, sb.toString());
		HTMLUtils.closeTag(pageContext, "script");
		
		// Load Struts-Layout Javascript code if configured to do so.
		if (include) {
			sb = new StringBuffer(lc_skin.getConfigDirectory(pageContext.getRequest()));
			if (!lc_skin.getConfigDirectory(pageContext.getRequest()).endsWith("/")) sb.append("/");
			sb.append("javascript.js");
			HTMLUtils.openTag(pageContext, "script", new String[][]{{"type", "text/javascript"}, {"src", sb.toString()}});
			HTMLUtils.closeTag(pageContext, "script");
		}
		
		// Go on evaluating the page. 
		return EVAL_PAGE;
	}
	
	/**
	 * Release the tag.
	 */
	public void release() {
		include = false;	
	}
	
	/**
	 * Setter for setting the includeScript boolean variable.
	 * @param in_include include Struts-Layout Javascript loading code
	 */
	public void setIncludeScript(boolean in_include) {
		include = in_include;	
	}
}
