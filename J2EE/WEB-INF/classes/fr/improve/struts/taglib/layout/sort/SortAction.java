package fr.improve.struts.taglib.layout.sort;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SortAction extends org.apache.struts.action.Action {
	
	private static final String SORT_ERROR_URL = "sortError";
    protected static Log log = LogFactory.getLog(SortAction.class);
    protected SortUtil getSortUtil(HttpServletRequest in_request) {
	return (SortUtil) in_request.getSession().getAttribute(SortUtil.SORTUTIL_KEY);
}
public ActionForward execute(  
    ActionMapping in_mapping,
	ActionForm in_form,    
    HttpServletRequest in_request,
    HttpServletResponse in_response) {

	SortUtil lc_sortUtil = getSortUtil(in_request);
	String lc_url = SORT_ERROR_URL;
	
	if (lc_sortUtil!=null) {
		try {
			lc_url = lc_sortUtil.sort(in_request);
		} catch (SortException e) {
			log.error("Sort failed", e);
			lc_url = SORT_ERROR_URL;
		}	
	} else {
		log.error("Unable to sort : SortUtil is null, maybe because there has been a session timeout");
	}
	
	if (lc_url.startsWith(in_request.getContextPath() + '/')) {
		lc_url = lc_url.substring(in_request.getContextPath().length());
	}
	if (lc_url.indexOf('.')!=-1 && lc_url.indexOf('?')!=-1) {
		lc_url = lc_url.substring(0, lc_url.indexOf('?'));
	}
	
	ActionForward lc_forward = null;
	if (SORT_ERROR_URL.equals(lc_url)) {
		lc_forward = in_mapping.findForward(SORT_ERROR_URL);
		if (lc_forward==null) {
			log.error("Sort failed, but forward sortError is not defined, so no error page can be displayed");
		}
	} else {
		lc_forward = new ActionForward(lc_url);
	}
	
    return lc_forward;

}
}
