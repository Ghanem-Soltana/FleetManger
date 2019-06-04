package fr.improve.struts.taglib.layout;

import javax.servlet.jsp.JspException;

import fr.improve.struts.taglib.layout.renderer.BasicPopupRenderer;
import fr.improve.struts.taglib.layout.util.LayoutUtils;
import fr.improve.struts.taglib.layout.util.PanelInterface;
import fr.improve.struts.taglib.layout.util.TagUtils;

public class PopupTag extends PanelTag {

	public static final String POPUP_KEY = "fr.improve.struts.taglib.layout.PopupTag.POPUP_KEY";
	

	private String styleId;
	
	public void doStartLayout() throws JspException {
		super.doStartLayout();
		
		loadScript();
		

		TagUtils.write(pageContext, "<div id=\"");
		TagUtils.write(pageContext, styleId);
		TagUtils.write(pageContext, "\" style=\"position:absolute; left:100px; top:100px; z-index:10; visibility:hidden;\">\n");
	}
	
	public void doEndLayout() throws JspException {
	
		TagUtils.write(pageContext, "</div>\n");
		
	
		super.doEndLayout();
	}
	

	protected void loadScript() throws JspException {
		pageContext.getRequest().removeAttribute(POPUP_KEY);
			TagUtils.write(pageContext, "<div id=\"slpdiv-"+styleId+"\" style=\"display:none;position:absolute;left:0px;top:0px; width:100%; height:100%; z-index:9;\"></div>");
	
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public void init() {		
		try {
			panel = (PanelInterface) getSkin().getPopupClass(model).newInstance();
		} catch (Exception e) {
			panel = new BasicPopupRenderer();
		}
	}
}
