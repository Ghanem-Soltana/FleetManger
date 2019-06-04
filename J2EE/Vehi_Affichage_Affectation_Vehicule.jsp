<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>

<lay:html locale="true" >
<head>
<title><bean:message key="aff_affect_vehi.type" /></title>
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
<br/>
<br/>





<html:form action="affichage_affectaion_vehicule.do?action=all" styleId="form" >
	<lay:panel align="center" key="aff_affect_vehi.type" styleClass="FORM">

		<tr>
		
				<td align="left"> <bean:message key="lib_centre_affectation"/> </td>
					<td align="left" width="250px">
					<html:select styleId="select_centre" property="id_centre" name="affect_vehi_aff" onchange="hiearchi_centre()">
					<html:options collection="liste_centre" property="id_centre"  name="liste_centre" labelProperty="libelle_centre"/>
            		</html:select>
				</td>
			</tr>
			
			
			
			<tr>
		
				<td align="left"> <bean:message key="lib_agence_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_agence" property="id_agence" name="affect_vehi_aff" onchange="hiearchi_agence()">
					<html:options collection="liste_agence" property="id_agence"  name="liste_agence" labelProperty="libelle_agence"/>
            		</html:select>
				</td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>


	<tr>
		
				
				<td align="center" colspan="2">
				<html:button styleId="b1"  property="" onclick="window.location.href='affichage_affectaion_vehicule.do?action=refresh'" > <bean:message key="refresh"/></html:button>
				</td>
			</tr>
			

</lay:panel>
</html:form>
<br/>
<br/>
<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_affect_vehi" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_affect_vehi" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="libelle_affect_vehicule_aff">
<lay:collectionItem  property="libelle_vehicule"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_affect_centre_aff">
<lay:collectionItem    property="libelle_centre" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_affect_agence_aff">
<lay:collectionItem    property="libelle_agence" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="libelle_affect_service_aff">
<lay:collectionItem    property="libelle_service" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_affect_date_aff">
<lay:collectionItem    property="date_affectation" ></lay:collectionItem>

</lay:collectionTitle>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<bean:define id="temp1" name="ji" property="id_service"></bean:define>
<bean:define id="temp2" name="ji" property="date_affectation"></bean:define>
<img src="config/modif.png" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<bean:define id="temp1" name="ji" property="id_service"></bean:define>
<bean:define id="temp2" name="ji" property="date_affectation"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>


</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>
</center>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_affect_vehi"/></td>
    <td align="center"><input type="text" id="aff"  maxlength="3" style="border-width:0px;height:20px;width:40px;" onkeypress="return block()"></input></td></tr>
	</table>
	<lay:cell width="100%" align="center">
	<table border="0">
	<tr>
	<td>
		<lay:button styleId="b1" onclick="closeStrutsLayoutPopup('popup');supp2();"><lay:message key="popup.yes"/></lay:button>
	</td><td>
		<lay:button styleId="b1" onclick="closeStrutsLayoutPopup('popup');"><lay:message key="popup.no"/></lay:button>
	</td>
	</tr>
	</table>
	</lay:cell>
</lay:popup>

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
String lien="",lien1="",lien2="",lien3="",lien4="",nb_page="",sms="";
session.removeAttribute("listevide");
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("libelle_vehicule",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_centre",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_agence",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_service",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("date_affectation",request);
lien4=lien4.replace("amp;","")+nb_page;
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

<input type="hidden" id='cd'></input>
<input type="hidden" id='cd1'></input>
<input type="hidden" id='cd2'></input>
<% session.removeAttribute("sms");%>

<script language="javascript" type="text/javascript">


function envoie(id)
{
if(id=='affectation_vehicule_lien')
document.location.href='<%=lien%>'
if(id=='affectation_centre_lien')
document.location.href='<%=lien1%>'
if(id=='affectation_agence_lien')
document.location.href='<%=lien2%>'
if(id=='affectation_service_lien')
document.location.href='<%=lien3%>'
if(id=='affectation_date_lien')
document.location.href='<%=lien4%>'
}


function hiearchi_centre()
{
id_centre=document.getElementById('select_centre').options[document.getElementById('select_centre').selectedIndex].value
document.getElementById('form').action='affichage_affectaion_vehicule.do?action=changement_centre&id_centre='+id_centre
document.getElementById('form').submit()
}

function hiearchi_agence()
{
id_agence=document.getElementById('select_agence').options[document.getElementById('select_agence').selectedIndex].value
document.getElementById('form').action='affichage_affectaion_vehicule.do?action=changement_agence&id_agence='+id_agence
document.getElementById('form').submit()
}




function supp(cd,cd1,cd2)
{
document.getElementById('cd').value=cd
document.getElementById('cd1').value=cd1
document.getElementById('cd2').value=cd2
document.getElementById('aff').style.backgroundColor='#3366A3'
document.getElementById('aff').style.color='white'
document.getElementById('aff').style.fontWeight = 'bold'
openStrutsLayoutPopup('popup')
return false
}

function supp2()
{window.location.href='affichage_affectaion_vehicule.do?action=supp&id_vehi='+document.getElementById('cd').value+'&id_serv='+document.getElementById('cd1').value+'&dat_aff='+document.getElementById('cd2').value}


function modifier(cd,cd1,cd2)
{window.open('affectaion_vehicule.do?action=modif&id_vehi='+cd+'&id_serv='+cd1+'&dat_aff='+cd2)
}


</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>

