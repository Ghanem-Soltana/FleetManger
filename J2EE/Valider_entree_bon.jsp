<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>





<lay:html locale="true">
<head>
<title>Validation entrée bons carburtant</title>
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
<b>Validation entrée bons carburtant</b>
<br/>
<br/>



<html:hidden name="entree_bon" property="id_bon" styleId="id1" ></html:hidden>
<html:hidden name="entree_bon" property="id_exercice" styleId="id2" ></html:hidden>
<html:hidden name="entree_bon" property="id_magasin" styleId="id3" ></html:hidden>

<html:form action="valider_entree_bon.do?action=valider" styleId="form">
	<lay:panel align="center" key="valider_entree_bon" styleClass="FORM">

		


                    <tr>
                    <td align="left"><html:button property="" styleId="b1" indexed="b3" onclick="if(document.getElementById('id1').value!='')document.location.href='valider_entree_bon.do?action=pred&id='+document.getElementById('id1').value+'&id_exercice='+document.getElementById('id2').value+'&id_magasin='+document.getElementById('id3').value ;else vide() " ><bean:message key="pred"/>  </html:button></td>
                    <td align="center" colspan="2" ><bean:define id="pos" name="pos" /><bean:define id="total" name="total" />      
                 <b>  <bean:message key="articles_pos"/> <%=pos %>/<%=total %></b>
                    </td>
                    <td align="right"><html:button property="" styleId="b1" indexed="b4" onclick="if(document.getElementById('id1').value!='')document.location.href='valider_entree_bon.do?action=sui&id='+document.getElementById('id1').value+'&id_exercice='+document.getElementById('id2').value+'&id_magasin='+document.getElementById('id3').value ;else vide()  " ><bean:message key="sui"/> </html:button></td>   
                    </tr>
				
	
		<html:hidden name="entree_bon" property="id_exercice"  ></html:hidden>
		<html:hidden name="entree_bon" property="id_magasin"  ></html:hidden>


			<tr>
				<td align="left"> <bean:message key="id_entrer_carb"/>  </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="id_bon" size="20" maxlength="20" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
					
			</tr>
			
					<tr>
			    <td align="left"> <bean:message key="liste_annee_entrer_carb"/> </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="libelle_exercice" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
				<td align="left"> <bean:message key="liste_mag_entrer_carb"/> </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="libelle_magasin" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
				<td align="left">  <bean:message key="date_entrer_carb"/> </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="date_entrer" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
					<td align="left"> <bean:message key="liste_agent_entrer_carb"/> </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="libelle_agent" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
				<td align="left"> <bean:message key="liste_typebon_entrer_carb"/> </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="libelle_type_bon" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
				<td align="left"> <bean:message key="reference_entrer_carb"/>  </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="reference" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
							<td align="left"> <bean:message key="debut_bon"/>  </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="debut_bon" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			
					<tr>
				<td align="left"> <bean:message key="fin_bon"/>  </td>
				<td align="left"><html:text readonly="true" name="entree_bon" property="fin_bon" size="20" maxlength="20"  ></html:text></td>
					
			</tr>
			


				

		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			
      </tr>


			<tr></tr>
			

			<tr>
		      
				<td> <html:submit  styleId="b1"  onclick="if(document.getElementById('id').value!=''){ return valider()} else return vide()" > <bean:message key="valider"/></html:submit></td>
			    <td></td>
			    <td></td>
			     <td><html:submit styleId="b1"   onclick="if(document.getElementById('id').value!=''){return refuser()}else  return vide();"> <bean:message key="refuser"/></html:submit></td>
			</tr>

	
	
		
	
	
	</lay:panel>
</html:form>




<br/>
<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_entree_bon" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_entree_bon" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_entree_bon_aff">
<lay:collectionItem  property="id_bon"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="ex_entree_bon_aff">
<lay:collectionItem    property="libelle_exercice" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="date_entree_bon_aff">
<lay:collectionItem    property="libelle_magasin" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="vehicule_entree_bon_aff">
<lay:collectionItem    property="libelle_agent" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="agent_entree_bon_aff">
<lay:collectionItem    property="libelle_type_bon" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="valide_entree_bon_aff">
<lay:collectionItem    property="vld" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_bon"></bean:define>
<bean:define id="temp1" name="ji" property="id_exercice"></bean:define>
<bean:define id="temp2" name="ji" property="id_magasin"></bean:define>
<img src="images/add.png" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>
</center>



















<logic:present name="erreur">
<div class="containerPlus draggable" width="250"  style="top:205px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
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
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}



try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}

lien=SortUtil.getURLForCollection("id_bon",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_exercice",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("libelle_magasin",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("libelle_agent",request);
lien3=lien3.replace("amp;","")+nb_page;
lien4=SortUtil.getURLForCollection("libelle_type_bon",request);
lien4=lien4.replace("amp;","")+nb_page;
lien5=SortUtil.getURLForCollection("vld",request);
lien5=lien5.replace("amp;","")+nb_page;







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
if(id=='etat_lien1')
document.location.href='<%=lien%>'
if(id=='etat_lien2')
document.location.href='<%=lien1%>'
if(id=='etat_lien3')
document.location.href='<%=lien2%>'
if(id=='etat_lien4')
document.location.href='<%=lien3%>'
if(id=='etat_lien5')
document.location.href='<%=lien4%>'
if(id=='etat_lien6')
document.location.href='<%=lien5%>'

}




function modifier(cd,cd1)
{window.location.href='valider_entree_bon.do?action=modif&id='+cd+'&annee='+cd1}


function vide()
{image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
$.jGrowl(image+'<bean:message key="vide_entree_bon.java.vide"/>'+fin);
return false
}


function refuser()
{
document.getElementById('form').action='valider_entree_bon.do?action=refuser'
document.getElementById('form').submit()
return false
}

function valider()
{
document.getElementById('form').action='valider_entree_bon.do?action=valider'
document.getElementById('form').submit()
return false
}

function modifier(cd1,cd2,cd3)
{window.location.href='valider_entree_bon.do?action=modif&id='+cd1+'&id_exercice='+cd2+'&id_magasin='+cd3
}


</script>


</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


