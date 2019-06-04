package fr.improve.struts.taglib.layout.pager;

import javax.servlet.jsp.JspException;


public interface PagerStatusListener {
	public Object processPagerStatusEvent(PagerStatusEvent in_event) throws JspException;
}
