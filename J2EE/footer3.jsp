<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="Dao.Conn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.PlanDao"%>
<%@page import="Bean.LangueForm"%>


<%@page import="Action.Utilitaire"%>
<div  class="fbbl_south ui-resizable" style="position: absolute; z-index: 0; top: auto; right: 0pt; bottom: 0pt; left: 0pt; width: auto;height:40px;">
<jsp:include flush="true" page="footer1.jsp"></jsp:include>
<div unselectable="on" class="ui-resizable-handle ui-resizable-s" style="border-bottom: 1px solid rgb(222, 222, 222); background: rgb(242, 242, 242) none repeat scroll 0% 0%; overflow: hidden; bottom: 0pt; width: 100%; position: absolute; cursor: s-resize; height: 4px; left: 0px; right: 0px; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial; font-size: 0.1px; opacity: 0; -moz-user-select: none;"></div></div>


<div id="ui-datepicker-div" style="display: none;"></div>
<div style="position: absolute; cursor: pointer; z-index: 0; font-size: 1px; width: 50px; height: 5px; top: 37px; left: 484.5px;" class="fbbl_north_collapser"></div>
<div class="fbbl_south_collapser"></div>



<%
ArrayList <Bean.PlanForm> liste=new ArrayList <Bean.PlanForm>();
Conn cnx=new Conn();
PlanDao pdao=new PlanDao(cnx.getcnx());
liste=pdao.all();
cnx.closecnx();
session.setAttribute("liste",liste);
%>

  <div id="jqdockintro" class="hideThis">
    <div class="sbox">


<table border="0" align="left">
<logic:iterate id="i" name="liste">
<tr>
 <bean:define id="temp1"  property="id_plan" name="i"></bean:define>
 <bean:define id="temp2"  property="libelle_plan" name="i"></bean:define>
<td align="left"><b><%=temp1 %></b></td>
<td align="left" style="font-size: 20px;font-style: italic;"><%=temp2 %></td>
</tr>
<BR/>
</logic:iterate>
</table>


<%
if(!Utilitaire.present(request,"lng"))
{session.setAttribute("lng",new LangueForm());}

%>


    </div>
  </div>
  
  
    <div id="jqdocklang" class="hideThis">
    <div class="sbox">


<html:form action="langue.do?action=changer">

<table border="0" align="center" class="agaga">
<tr >


<th colspan="2">  <bean:message key="Choix_langue"/>  </th><th></th>
</tr>
<tr>

<td colspan="2" align="center">

<div style="width: 150px">
<html:select property="langue" name="langue" styleId="select_langue">
<bean:define id="lng" name="lng"></bean:define>

<option value="fr"   id="fr"><bean:message key="frr"/></option>
<%if(lng.equals("en")){ %>
<option value="en" selected="selected" id="en"><bean:message key="enn"/></option>
<%} else { %>
<option value="en"  id="en"><bean:message key="enn"/></option>
<%} %>
</html:select>

</div>
</td>
<td></td>
</tr >
<tr>
<td align="center">

<html:submit styleId="b1" > <bean:message key="modifier"/> </html:submit>
</td>
<td align="center">

<html:submit styleId="b1" onclick="Shadowbox.close(); "> <bean:message key="Retourner"/> </html:submit>
</td>
</tr>
</table>
<html:hidden property="page" name="langue" styleId="kaffen"/>

<script type="text/javascript">
document.getElementById('kaffen').value=document.URL

</script>

</html:form>

    </div>
  </div>
  
  
  <div id="jqdockdecon" class="hideThis">
    <div class="sbox">

<center>
<div  style="display:block;position:absolute;left:0px;top:0px; width:100%; height:100%; z-index:9;"></div>
<div  style="position:absolute; left:250px; top:100px; z-index:10;">
<table cellspacing="0" cellpadding="0" border="0" class="FORM">
<tr><td valign="top"><table cellspacing="1" cellpadding="1" border="0" width="100%">
<tr>
<th align="center" class="FORM"><lay:message key="popup.message"/></th></tr>
<tr><td class="FORM"><table width="100%"	border="0">

	<tr><td colspan="2">&nbsp;</td></tr>

	<tr><th colspan="2"><lay:message key="popup.question"/></th></tr>

	<tr><td colspan="2">&nbsp;</td></tr>

	<tr><td colspan="2" width="100%" align="center">
	<table border="0"><tr><td>
		<html:button styleId="b1" property="" onclick="document.location='login.do?action=logout';"><lay:message key="popup.yes"/></html:button >
		</td><td>	
		<html:button styleId="b1" property=""  onclick="Shadowbox.close();"><lay:message key="popup.no"/></html:button >
	</td></tr></table>
	</td></tr>

	<tr><td colspan="2">&nbsp;</td></tr>

</table></td></tr>

</table></td></tr></table>
</div>

</center>
    </div>
  </div>
  
  

