package fr.improve.struts.taglib.layout.pager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import fr.improve.struts.taglib.layout.LayoutTag;
import fr.improve.struts.taglib.layout.event.AbstractLayoutEvent;

/**
 * @author jnribette
 */
public class PagerStatusEvent extends AbstractLayoutEvent {
	public PagerStatusEvent(LayoutTag in_source, Object in_value) {
		super(in_source, in_value);	
	}

	public Object send() throws JspException {
		PagerStatusListener lc_listener = (PagerStatusListener) TagSupport.findAncestorWithClass(source, PagerStatusListener.class);
		if (lc_listener==null) {
			return null;	
		} else {
			return lc_listener.processPagerStatusEvent(this)	;
		}
	}

}
