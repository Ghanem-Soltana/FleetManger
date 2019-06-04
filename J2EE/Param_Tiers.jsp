<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>


<lay:html locale="true">
<head>
<title><bean:message key="tiersss.type" /></title>
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
<b><bean:message key="tiersss.type" /></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<logic:notPresent name="pas_de_type"> 
<html:form action="gestion_tiers.do?action=ajout">
	<lay:panel align="center" key="ajout.tiersss" styleClass="FORM">
	
		<tr>

				<td align="left"> <bean:message key="tiers.type"/></td>
			    <td align="left">
					<html:select property="id_type_tiers" name="tiersss">
					<html:options collection="liste_type_tiers" property="id_tiers"  name="liste_type_tiers" labelProperty="libelle_tiers"/>
            		</html:select>
				</td>
	  </tr>
			
	
			<tr>
				<td align="left"> <bean:message key="id_tiersss"/>  </td>
				<td align="left"><html:text name="tiersss" property="id_tiers" size="12" maxlength="12" styleId="id" onkeypress="return alphanum(event)"></html:text></td>

		
			</tr>

			<tr>
				<td align="left"> <bean:message key="lib_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="libelle_tiers" size="50" maxlength="50"  styleId="lib"></html:text></td>
			
			</tr>
			
			<tr>
				<td align="left"><bean:message key="mat_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="matricule_fiscale" size="15" maxlength="15"  styleId="mat"></html:text></td>
			
			</tr>


			<tr>
				<td align="left"><bean:message key="tel_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="tel_tiers" size="20" maxlength="20"  styleId="tel"></html:text></td>
			
			</tr>
				<tr>
				<td align="left"><bean:message key="fax_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="fax_tiers" size="20" maxlength="20"  styleId="fax"></html:text></td>
			
			</tr>
			
				
		
				<tr>
				<td align="left"><bean:message key="adr_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="adresse_tiers" size="50" maxlength="50"  styleId="adresse"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="cp_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="cp_tiers" size="7" maxlength="7"  styleId="cp" onkeypress="return numeric(event)"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="contact_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="contact_tiers" size="30" maxlength="30"  styleId="contacte"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="mail_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="mail_tiers" size="20" maxlength="20"  styleId="mail" ></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="remarque_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="remarque_tiers" size="50" maxlength="50"  styleId="remarque"></html:text></td>
			
			</tr>
			<tr>

				<td align="left"> <bean:message key="blockage_tiers"/></td>
			    <td align="left">
					<html:select property="blockage_tiers" name="tiersss">
					<html:options collection="liste_blocker" property="id_blocker"  name="liste_blocker" labelProperty="libelle_blocker"/>
            		</html:select>
				</td>
	  </tr>
			
			
			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return (nonvide()&&verifierMail('mail'))"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
	
	</lay:panel>



</html:form>
</logic:notPresent>
</logic:notPresent>
<logic:present name="pas_de_type"><b><font color="red"><bean:message key="er_type_vide"/></font></b><br/><br/></logic:present>


<logic:present name="x">
<html:form action="gestion_tiers.do?action=edit">
	<lay:panel align="center" key="edit.tiersss" styleClass="FORM">
	
	
		<tr>

				<td align="left"> <bean:message key="tiers.type"/></td>
			    <td align="left">
					<html:select property="id_type_tiers" name="tiersss">
					<html:options collection="liste_type_tiers" property="id_tiers"  name="liste_type_tiers" labelProperty="libelle_tiers"/>
            		</html:select>
				</td>
	  </tr>
		
			<tr>
				<td align="left"> <bean:message key="id_tiersss"/>  </td>
				<td align="left"><html:text name="tiersss" property="id_tiers" readonly="true" size="12" maxlength="12"  styleId="id"></html:text></td>

		
			</tr>

			<tr>
				<td align="left"> <bean:message key="lib_tiersss"/>  </td>
				<td align="left"><html:text name="tiersss"  property="libelle_tiers" size="50" maxlength="50"  styleId="lib"></html:text></td>
			
	
			
			</tr>
			
			
			
						<tr>
				<td align="left"><bean:message key="mat_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="matricule_fiscale" size="15" maxlength="15"  styleId="mat"></html:text></td>
			
			</tr>


			<tr>
				<td align="left"><bean:message key="tel_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="tel_tiers" size="20" maxlength="20"  styleId="tel"></html:text></td>
			
			</tr>
				<tr>
				<td align="left"><bean:message key="fax_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="fax_tiers" size="20" maxlength="20"  styleId="fax"></html:text></td>
			
			</tr>
			
				
		
				<tr>
				<td align="left"><bean:message key="adr_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="adresse_tiers" size="50" maxlength="50"  styleId="adresse"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="cp_tiersss"/>  </td>
				<td align="left"><html:text  name="tiersss" property="cp_tiers" size="7" maxlength="7"  styleId="cp" onkeypress="return numeric(event)"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="contact_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="contact_tiers" size="30" maxlength="30"  styleId="contacte"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="mail_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="mail_tiers" size="20" maxlength="20"  styleId="mail"></html:text></td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="remarque_tiersss"/> </td>
				<td align="left"><html:text  name="tiersss" property="remarque_tiers" size="50" maxlength="50"  styleId="remarque"></html:text></td>
			
			</tr>
			
					<tr>

				<td align="left"> <bean:message key="blockage_tiers"/></td>
			    <td align="left">
					<html:select property="blockage_tiers" name="tiersss">
					<html:options collection="liste_blocker" property="id_blocker"  name="liste_blocker" labelProperty="libelle_blocker"/>
            		</html:select>
				</td>
	  </tr>
			

			<tr>
				<td></td>
				<td>
				<table border="0">
				<tr>
				<td>
				 <html:submit styleId="b1" indexed="b1" onclick="return (nonvide()&&verifierMail('mail'))"  > <bean:message key="modif"/></html:submit>
				 </td><td>
				 <html:button styleId="b1" onclick="document.location.href='gestion_tiers.do?action=all'" property="" > <bean:message key="annuler"/></html:button>
				 </td>
				 </tr>
				 </table>
				 </td>
			  
			</tr>
		
	</lay:panel>



</html:form>
</logic:present>


<logic:notPresent name="x">
<script language="javascript" type="text/javascript"> window.document.getElementById('id').focus()</script>
</logic:notPresent>

<logic:present name="x">
<script language="javascript" type="text/javascript"> window.document.getElementById('lib').focus();
window.document.getElementById('lib').select();
 window.document.getElementById('id').style.color='gray'
</script>
</logic:present>



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
 

<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_tiersss" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_tiersss" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="type_tiersss1">
<lay:collectionItem    property="libelle_type_tiers" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="code_tiersss">
<lay:collectionItem  property="id_tiers"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_tiersss">
<lay:collectionItem    property="libelle_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="mat_tiersss1">
<lay:collectionItem    property="matricule_fiscale" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="tel_tiersss1">
<lay:collectionItem    property="tel_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="fax_tiersss1">
<lay:collectionItem    property="fax_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="adr_tiersss1">
<lay:collectionItem    property="adresse_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="cp_tiersss1">
<lay:collectionItem    property="cp_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="contact_tiersss1">
<lay:collectionItem    property="contact_tiers" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="mail_tiersss1">
<lay:collectionItem    property="mail_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="remarque_tiersss1">
<lay:collectionItem    property="remarque_tiers" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="bloc_tiersss1">
<lay:collectionItem    property="blockage_tiers" ></lay:collectionItem>
</lay:collectionTitle>



<lay:collectionItem title=" " href="gestion_tiers.do?action=modif&id=" paramId="id" param="id_tiers"><img src="config/modif.png" alt="modifier" border="0" /></lay:collectionItem>
<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_tiers"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_tiersss"/></td>
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
	<lay:space/>
</lay:popup>


<input type="hidden" id='cd'></input>
</center>



<%
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("id_tiers",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_tiers",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("libelle_type_tiers",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("blockage_tiers",request);
lien3=lien3.replace("amp;","")+nb_page;
lien4=SortUtil.getURLForCollection("cp_tiers",request);
lien4=lien4.replace("amp;","")+nb_page;
lien5=SortUtil.getURLForCollection("contact_tiers",request);
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
function nonvide()
{
blond('id')
blond('lib')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.typtiersss"  />'+fin);
 rouge('id')
window.document.getElementById('id').focus()
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libtiersss"  />'+fin);
rouge('lib')
if(test==true)
window.document.getElementById('lib').focus()
test=false
}
return test

}

function supp(cd)
{
document.getElementById('cd').value=cd
document.getElementById('aff').value=' '+cd
document.getElementById('aff').style.backgroundColor='#3366A3'
document.getElementById('aff').style.color='white'
document.getElementById('aff').style.fontWeight = 'bold'
openStrutsLayoutPopup('popup')
return false
}

function supp2()
{window.location.href='gestion_tiers.do?action=supp&id='+document.getElementById('cd').value}

 function alphanum(evt)
{
var keyCode = evt.which ? evt.which : evt.keyCode;
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;
else{
if(keyCode >= 112&& keyCode <=  123 )
return true;        
else{
if(keyCode>=65&&keyCode<=90)
return true;
else
{if(keyCode>=97&&keyCode<=122)
  {return true;}
  else
  {if(keyCode>=48&&keyCode<=57)
   return true;
   else
  return false;}
}}
}
}

function envoie(id)
{
if(id=='id_tiersss_lien')
document.location.href='<%=lien%>'
if(id=='lib_tiersss_lien')
document.location.href='<%=lien1%>'
if(id=='typ_tiersss_lien')
document.location.href='<%=lien2%>'
if(id=='bloc_tiersss_lien')
document.location.href='<%=lien3%>'
if(id=='cp_tiersss_lien')
document.location.href='<%=lien4%>'
if(id=='con_tiersss_lien')
document.location.href='<%=lien5%>'

}
function block()
{return false;}

function numeric(evt)
{

var keyCode = evt.which ? evt.which : evt.keyCode;
if(keyCode==48&&document.getElementById('cp').value=='')
return false
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;   
else{
  if(keyCode>=48&&keyCode<=55)
   {return true;}
   else return false;
   }

}



function verifierMail(id) {
blond(id)
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
champ=document.getElementById(id)
var str = champ.value;
var regexp = new RegExp("^[a-zA-Z0-9_\\-\\.]{3,}@[a-zA-Z0-9\\-_]{2,}\\.[a-zA-Z]{2,4}$", "g");

if
(!regexp.test(str)&&str!='') {
 $.jGrowl(image+'<bean:message key="java.mail_invalide"  />'+fin);
 rouge(id)
champ.focus();
return false;
}
return true;
}
</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


