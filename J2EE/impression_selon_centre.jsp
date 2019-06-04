<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="Dao.Conn"%>
<%@page import="Dao.CentreDao"%>

<lay:html locale="true">
<head>
<title><bean:message key="choix_centre.type" /></title>
</head>

<jsp:include flush="true" page="Menu2.jsp"></jsp:include>
	    
	<script type="text/javascript">
		$(function(){
			$(".containerPlus").buildContainers({
				containment:"document",
				elementsPath:"images/elements/"
			});
		});
	</script>
	


<br/>
<b><bean:message key="choix_centre.type" /></b>
<br/>
<br/>

<%Conn cnx=new Conn();
  CentreDao centredao =new CentreDao(cnx.getcnx());
  session.setAttribute("liste_centre_imprime",centredao.all());


%>
<br/>
<br/>
<br/>
<br/>
<br/>


<logic:present name="liste_centre_imprime">
<html:form action="gestion_maint.do?action=all">
	<lay:panel align="center" key="edit.print" styleClass="FORM">
	
	       <tr>
	       <td>
	       </td>
	       </tr>
	
			<tr>
				<td align="center"> <bean:message key="liste_agence_imprime"/>  </td>
			</tr>
			
			<tr></tr>
			
			
			<tr>
			<td>
			
			<select id="select_centre">
			<logic:iterate id="i" name="liste_centre_imprime">
			<bean:define id="temp" name="i" property="id_centre"></bean:define>
			<bean:define id="temp1" name="i" property="libelle_centre"></bean:define>
			<option value="<%=temp %>"><%=temp1 %></option>
			</logic:iterate>
			</select>
			
			
	        </td>
			</tr>

	
          <tr></tr>
			
	
				
			  <tr>
				<td align="center" ><html:submit styleId="b1" onclick="return  nonvide();"  > <bean:message key="imprime_centre"/></html:submit></td>
			   
			   </tr>
			    
			    
			    
		
		
	</lay:panel>



</html:form>
</logic:present>








<script language="javascript" type="text/javascript">


function nonvide()
{
blond('select_centre')
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
nb=document.getElementById('select_centre').length

if(nb==0)
{
$.jGrowl(image+'<bean:message key="java.choix_centre_imp"  />'+fin);
rouge('select_centreS')
}
else 
window.open('gestion_maint.do?action=print1&id_centre='+document.getElementById('select_centre').options[document.getElementById('select_centre').selectedIndex].value);


return false;

}
</script>










</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>




<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


