<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>





<lay:html locale="true">
<head>
<title><bean:message key="valider_releve"/></title>
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
<b><bean:message key="valider_releve"/></b>
<br/>
<br/>



<html:hidden name="valider_releve" property="id_distance" styleId="id_rel" ></html:hidden>
<html:hidden name="valider_releve" property="id_vehicule" styleId="id_vehi" ></html:hidden>

<html:form action="/valider_laisser_passer.do?action=all" styleId="form">
	<lay:panel align="center" key="valider_releve" styleClass="FORM">
	
	              <tr>
                    <td align="left"><html:button property="" styleId="b1" indexed="b3" onclick="if(document.getElementById('id_rel').value!='')document.location.href='valider_releve.do?action=pred&id_rel='+document.getElementById('id_rel').value+'&id_vehi='+document.getElementById('id_vehi').value ;else vide() " ><bean:message key="pred"/>  </html:button></td>
                    <td align="left" colspan="2" ><bean:define id="pos" name="pos" /><bean:define id="total" name="total" />      
                 <b>  <bean:message key="articles_pos"/> <%=pos %>/<%=total %></b>
                    </td>
                    <td align="left"><html:button property="" styleId="b1" indexed="b4" onclick="if(document.getElementById('id_rel').value!='')document.location.href='valider_releve.do?action=sui&id_rel='+document.getElementById('id_rel').value+'&id_vehi='+document.getElementById('id_vehi').value ;else vide()  " ><bean:message key="sui"/> </html:button></td>   
                    </tr>
				
	
		
			

		<tr>
			  <td align="left"> <bean:message key="releve_dist_vehi" /> </td>
<td align="left"><html:text readonly="true"  name="valider_releve" property="libelle_vehicule" size="20" maxlength="20" styleId="lb_vehi" ></html:text></td>
<html:hidden  name="valider_releve" property="id_vehicule"  styleId="id_vehi" ></html:hidden>
               </tr>

			<tr>
				<td align="left"> <bean:message key="releve_dist_rel" /> </td>
				<td align="left"><html:text readonly="true" name="valider_releve" property="id_distance" size="10" maxlength="10" styleId="id_rel" ></html:text></td>

		
			</tr>
			
				
				<tr>
				<td align="left"> <bean:message key="releve_dist_ant" /> </td>
				<td align="left"><html:text readonly="true"  name="valider_releve" property="ancien_compteur" size="10" maxlength="10"  styleId="anterieur"></html:text></td>
			</tr>
			
			
						
				<tr>
				<td align="left"> <bean:message key="releve_dist_act" /></td>
				<td align="left"><html:text readonly="true"   name="valider_releve" property="actuel_compteur" size="10" maxlength="10"  onkeyup="maj_rapport()" styleId="actuelle" onkeypress="return numeric(event,'actuelle')"></html:text></td>
			</tr>
			
			
		
			
	
			
					<tr>
				<td align="left"> <bean:message key="releve_dist_dist_cpt" /></td>
				<td align="left"><html:text  readonly="true" name="valider_releve" property="rapport_distance_compteur" size="10" maxlength="10"  styleId="rapport"></html:text>&nbsp;km</td>
			</tr>
			
						<tr>
				<td align="left"> <bean:message key="releve_dist_qte_util" /> </td>
				<td align="left"><html:text readonly="true"  name="valider_releve" property="qté_combustible" size="10" maxlength="10"  styleId="qte_combustible" onkeypress="return numeric(event,'qte_combustible')"></html:text></td>
			</tr>
			
			
			<tr>
				<td align="left"> <bean:message key="releve_dist_qte_date" />  </td>
				<td align="left"><html:text readonly="true"  name="valider_releve" property="date" size="10" maxlength="10"  styleId="relevé" onkeypress="return numeric_date(event,'relevé')"></html:text></td>
			
	
			
			</tr>

		
		<tr>
			<td></td>
			<td></td>
				
      </tr>


			<tr></tr>
			

			<tr>
		
				<td> <html:submit  styleId="b1"  onclick="if(document.getElementById('id_rel').value!=''){return valider()}else  return vide();" > <bean:message key="valider"/></html:submit></td>
			    <td></td>
			    <td></td>
			    <td><html:submit styleId="b1"   onclick="if(document.getElementById('id_rel').value!=''){return refuser()}else  return vide();"> <bean:message key="refuser"/></html:submit></td>
			</tr>

	
	
		
	
	
	</lay:panel>
</html:form>




<br/>
<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide_dist"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_valider_releve" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_valider_releve" id="ji"  styleClass="FORM" styleClass2="FORM2" >


<lay:collectionTitle title="aff__id_distance_aff">
<lay:collectionItem  property="id_distance"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_vehi_distance_aff">
<lay:collectionItem    property="libelle_vehicule" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_taux_distance_aff">
<lay:collectionItem    property="pourcentage_consommation" ></lay:collectionItem>
</lay:collectionTitle>




<lay:collectionTitle title="aff_rel_antdistance_aff">
<lay:collectionItem    property="ancien_compteur" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_rek_act_distance_aff">
<lay:collectionItem    property="actuel_compteur" ></lay:collectionItem>
</lay:collectionTitle>






<lay:collectionTitle title="aff_rapp_distance_aff">
<lay:collectionItem    property="rapport_distance_compteur" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="aff_qte_combust_distance_aff">
<lay:collectionItem    property="qté_combustible" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_date_distance_aff">
<lay:collectionItem    property="date" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="etat_distance_aff">
<lay:collectionItem    property="valide" ></lay:collectionItem>
</lay:collectionTitle>


</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>




</center>











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
 







<input type="hidden" id='cd'></input>
<input type="hidden" id='cd1'></input>
</center>




<%
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",lien6="",lien7="",lien8="",lien9="",nb_page="",sms="";
session.removeAttribute("listevide");
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("id_distance",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_vehicule",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("pourcentage_consommation",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("date",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("ancien_compteur",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("actuel_compteur",request);
lien5=lien5.replace("amp;","")+nb_page;

lien6=SortUtil.getURLForCollection("qté_combustible",request);
lien6=lien6.replace("amp;","")+nb_page;

lien7=SortUtil.getURLForCollection("rapport_distance_compteur",request);
lien7=lien7.replace("amp;","")+nb_page;

lien8=SortUtil.getURLForCollection("distance_reel",request);
lien8=lien8.replace("amp;","")+nb_page;

lien9=SortUtil.getURLForCollection("valide",request);
lien9=lien9.replace("amp;","")+nb_page;
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

<script language="javascript" type="text/javascript">


function block()
{return false;}


function envoie(id)
{
if(id=='id_cpt_lien')
document.location.href='<%=lien%>'
if(id=='id_vehi_lien')
document.location.href='<%=lien1%>'
if(id=='id_taux_lien')
document.location.href='<%=lien2%>'
if(id=='date_lien')
document.location.href='<%=lien3%>'
if(id=='rel_ant_lien')
document.location.href='<%=lien4%>'
if(id=='rel_act_lien')
document.location.href='<%=lien5%>'
if(id=='qte_carb_lien')
document.location.href='<%=lien6%>'
if(id=='qte_carb_lien')
document.location.href='<%=lien7%>'
if(id=='dist_rel_lien')
document.location.href='<%=lien8%>'
if(id=='etat_lien')
document.location.href='<%=lien9%>'
}




function modifier(cd,cd1)
{window.location.href='valider_laisser_passer.do?action=modif&id='+cd+'&annee='+cd1}


function vide()
{image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
$.jGrowl(image+'<bean:message key="vide_laisser_passer.java.vide"/>'+fin);
return false
}


function refuser()
{
document.getElementById('form').action='valider_releve.do?action=refuser'
document.getElementById('form').submit()
return false
}

function valider()
{
document.getElementById('form').action='valider_releve.do?action=valider'
document.getElementById('form').submit()
return false
}


</script>


</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


