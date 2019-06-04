<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>

<lay:html locale="true">
<head>
<title><bean:message key="carb_article.type" /></title>
</head>

<jsp:include flush="true" page="Menu2.jsp"></jsp:include>

<center>
	<script type="text/javascript">
		$(function(){
			$(".containerPlus").buildContainers({
				containment:"document",
				elementsPath:"images/elements/"
			});
		});
	</script>
	



<br/>
<b><bean:message key="carb_article.type" /></b>
<br/>
<br/>

<logic:notPresent name="affichage">
<html:form action="gestion_carb_article.do?action=edit">
	<lay:panel align="center" key="ajout.carb_article" styleClass="FORM">
	
			<tr>
				<td align="left" > <bean:message key="id_carb_article"/>  </td>
				<td align="left"><html:text readonly="true" name="carb_article" property="id_carburant" size="3" maxlength="3" styleId="id" onkeypress="return alphanum(event)"></html:text></td>

		
			</tr>

			<tr>
				<td align="left"> <bean:message key="lib_carb_article"/>  </td>
				<td align="left"><html:text readonly="true" name="carb_article" property="libelle_carburant" size="50" maxlength="50"  styleId="lib"></html:text></td>
		
			</tr>
			
	
			

             	<tr>
				<td align="left"><div class="drop" title="Target B">
									<b><bean:message key="ex_carb_article"/></b>
  									<logic:iterate id="j"  name="liste_article">
										    <bean:define id="temp2"  property="id_article" name="j"></bean:define>
											<bean:define id="temp3"  property="libelle_article" name="j"></bean:define>	      
	    							     <div class="drag" title="<%=temp2 %>">
      <table border="0" align="center">
	         <tr>
	         <td align="left">
	          <img src="images/article1.png" width="30" height="30" />
	         </td>
	         <td align="center">
	          <b><%=temp3 %></b>
	         </td>
	         </tr>
	         </table>


</div>
	    						    </logic:iterate>
								</div>
				</td>
				
				<td align="left">
				
	<div class="drop" title="Target A">
	    <b><bean:message key="liste_carb_article"/></b>
	         <logic:iterate id="i"  name="liste_article1">
				<bean:define id="temp"  property="id_article" name="i"></bean:define>
				<bean:define id="temp1"  property="libelle_article" name="i"></bean:define>	      
	         <div class="drag" title="<%=temp %>">    <table border="0" align="center">
	         <tr>
	         <td align="left">
	          <img src="images/article1.png" width="30" height="30" />
	         </td>
	         <td align="center">
	          <b><%=temp1 %></b>
	         </td>
	         </tr>
	         </table>
</div>
	         </logic:iterate>
    </div>
</td>
		
			</tr>
			
			<tr>
				<td align="left">  </td>
				<td align="left">
				
				<table border="0"><tr><td>
				<html:submit styleId="b1" ><bean:message key="enregistrer"/></html:submit>
				</td><td>
				<html:button  styleId="b1"  property="" onclick="document.location.href='gestion_carburant.do?action=all'"><bean:message key="retour"/></html:button>
				
				</td></tr></table>
				
				</td>
		
			</tr>



			
	
	</lay:panel>


<html:hidden property="liste_article" name="carb_article" styleId="save" onkeypress="return block()"/>

</html:form>
</logic:notPresent>





<logic:present name="erreur">
<div class="containerPlus draggable" width="250"  style="top:65px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">

<% String typerreur=""; 
try{typerreur=String.valueOf(session.getAttribute("erreur"));}catch(Exception e){}%>
				<h3><bean:message key="er_titre"/></h3>
				<p> <bean:message key="<%=typerreur%>"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
 </logic:present>
 



<%
String sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
%>

<logic:present name="sms">
<div class="containerPlus draggable" width="250"  style="top:55px;left:10px" buttons="c"  icon="ok.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">

				<p><bean:message key="<%=sms%>"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
 </logic:present>

<% session.removeAttribute("sms");%>


</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


