<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>

<lay:html locale="true">
<head>
<title><bean:message key="magasin.type" /></title>
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
<b><bean:message key="magasin.type" /></b>
<br/>
<br/>

<logic:notPresent name="affichage">
<logic:notPresent name="x"> 
<html:form action="gestion_magasin.do?action=ajout">
	<lay:panel align="center" key="ajout.magasin" styleClass="FORM">
	
			<tr>
				<td align="left"> <bean:message key="id_magasin"/>  </td>
				<td align="left"><html:text name="magasin" property="id_magasin" size="3" maxlength="3" styleId="id" onkeypress="return alphanum(event)"></html:text></td>

		
			</tr>

			<tr>
				<td align="left"> <bean:message key="lib_magasin"/>  </td>
				<td align="left"><html:text  name="magasin" property="libelle_magasin" size="30" maxlength="30"  styleId="lib"></html:text></td>
		
			</tr>
			
			<tr>
				<td align="left"> <bean:message key="adr_magasin"/> </td>
				<td align="left"><html:text  name="magasin" property="adresse_magasin" size="50" maxlength="50"  styleId="adr"></html:text></td>
		
			</tr>
			
				<tr>
				<td align="left"> <bean:message key="tel_magasin"/></td>
				<td align="left"><html:text  name="magasin" property="tel_magasin" size="20" maxlength="20"  styleId="tel"></html:text></td>
		
			</tr>
			
				<tr>
				<td align="left"> <bean:message key="fax_magasin"/></td>
				<td align="left"><html:text  name="magasin" property="fax_magasin" size="20" maxlength="20"  styleId="fax"></html:text></td>
		
			</tr>
			
				<tr>
				<td align="left">  <bean:message key="res_magasin"/></td>
				<td align="left"><html:text  name="magasin" property="nom_res" size="30" maxlength="30"  styleId="res"></html:text></td>
		
			</tr>
			
			<tr>
				<td align="left"> <bean:message key="remarque_magasin"/> </td>
				<td align="left"><html:text  name="magasin" property="remarque_magasin" size="50" maxlength="50"  styleId="rem"></html:text></td>
		
			</tr>

             	<tr>
				<td align="left"><div class="drop" title="Target B">
									<b><bean:message key="ex_magasin"/></b>
  									<logic:iterate id="j"  name="liste_famille1">
										    <bean:define id="temp2"  property="id_famille_princi" name="j"></bean:define>
											<bean:define id="temp3"  property="libelle_famille_princi" name="j"></bean:define>	      
	    							     <div class="drag" title="<%=temp2 %>">
         <table border="0" align="center">
	         <tr>
	         <td align="left">
	          <img src="images/article.png" width="30" height="30" />
	         </td>
	         <td align="center">
	          <b><%=temp3 %></b>
	         </td>
	         </tr>
	         </table></div>
	    						    </logic:iterate>
								</div>
				</td>
				
				<td align="left">
				
	<div class="drop" title="Target A">
	    <b><bean:message key="liste_magasin"/></b>
	         <logic:iterate id="i"  name="liste_famille">
				<bean:define id="temp"  property="id_famille_princi" name="i"></bean:define>
				<bean:define id="temp1"  property="libelle_famille_princi" name="i"></bean:define>	      
	         <div class="drag" title="<%=temp %>">
	         <table border="0" align="center">
	         <tr>
	         <td align="left">
	          <img src="images/article.png" width="30" height="30" />
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
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide()"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
	
	</lay:panel>


<html:hidden property="liste_famille" name="magasin" styleId="save" onkeypress="return block()"/>

</html:form>
</logic:notPresent>

<logic:present name="x">
<html:form action="gestion_magasin.do?action=edit">
	<lay:panel align="center" key="edit.magasin" styleClass="FORM">
		
			<tr>
				<td align="left"> <bean:message key="id_magasin"/>  </td>
				<td align="left"><html:text name="magasin" property="id_magasin" readonly="true" size="3" maxlength="3"  styleId="id"></html:text></td>

		
			</tr>

			<tr>
				<td align="left"> <bean:message key="lib_magasin"/>  </td>
				<td align="left"><html:text name="magasin"  property="libelle_magasin" size="30" maxlength="30"  styleId="lib"></html:text></td>
			
	
			
			</tr>
			
			
			<tr>
				<td align="left"> <bean:message key="adr_magasin"/> </td>
				<td align="left"><html:text  name="magasin" property="adresse_magasin" size="50" maxlength="50"  styleId="adr"></html:text></td>
		
			</tr>
			
				<tr>
				<td align="left"> <bean:message key="tel_magasin"/></td>
				<td align="left"><html:text  name="magasin" property="tel_magasin" size="20" maxlength="20"  styleId="tel"></html:text></td>
		
			</tr>
			
				<tr>
				<td align="left"> <bean:message key="fax_magasin"/></td>
				<td align="left"><html:text  name="magasin" property="fax_magasin" size="20" maxlength="20"  styleId="fax"></html:text></td>
		
			</tr>
			
				<tr>
				<td align="left">  <bean:message key="res_magasin"/></td>
				<td align="left"><html:text  name="magasin" property="nom_res" size="30" maxlength="30"  styleId="res"></html:text></td>
		
			</tr>
			
			<tr>
				<td align="left"> <bean:message key="remarque_magasin"/> </td>
				<td align="left"><html:text  name="magasin" property="remarque_magasin" size="50" maxlength="50"  styleId="rem"></html:text></td>
		
			</tr>

             	<tr>
						<td align="left"><div class="drop" title="Target B">
									<b><bean:message key="ex_magasin"/></b>
  									<logic:iterate id="j"  name="liste_famille1">
										    <bean:define id="temp2"  property="id_famille_princi" name="j"></bean:define>
											<bean:define id="temp3"  property="libelle_famille_princi" name="j"></bean:define>	      
	    							     <div class="drag" title="<%=temp2 %>">         <table border="0" align="center">
	         <tr>
	         <td align="left">
	          <img src="images/article.png" width="30" height="30" />
	         </td>
	         <td align="center">
	          <b><%=temp3 %></b>
	         </td>
	         </tr>
	         </table></div>
	    						    </logic:iterate>
								</div>
				</td>
				
				
				<td align="left">
				
	<div class="drop" title="Target A">
	    <b><bean:message key="liste_magasin"/></b>
	         <logic:iterate id="i"  name="liste_famille">
				<bean:define id="temp"  property="id_famille_princi" name="i"></bean:define>
				<bean:define id="temp1"  property="libelle_famille_princi" name="i"></bean:define>	      
	         <div class="drag" title="<%=temp %>">         <table border="0" align="center">
	         <tr>
	         <td align="left">
	          <img src="images/article.png" width="30" height="30" />
	         </td>
	         <td align="center">
	          <b><%=temp1 %></b>
	         </td>
	         </tr>
	         </table></div>
	         </logic:iterate>
    </div>
</td>
		
			</tr>

			
			<tr>
				<td></td>
				<td>
				<table border="0">
				<tr>
				<td>
				 <html:submit styleId="b1"  indexed="b1" onclick="return nonvide();"  > <bean:message key="modif"/></html:submit>
				 </td><td>
				 <html:button styleId="b1"  onclick="document.location.href='gestion_magasin.do?action=aff'" property="" > <bean:message key="annuler"/></html:button>
				 </td>
				 </tr>
				 </table>
				 </td>
			  
			</tr>
		
	</lay:panel>

<html:hidden property="liste_famille" name="magasin" styleId="save" onkeypress="return block()"/>

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
 

<center>
<logic:present name="affichage">

<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>
<logic:notPresent name="listevide">

<logic:present name="liste_magasin" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_magasin" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_magasin">
<lay:collectionItem  property="id_magasin"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_magasin">
<lay:collectionItem    property="libelle_magasin" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="adrr_magasin">
<lay:collectionItem    property="adresse_magasin" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="tell_magasin">
<lay:collectionItem    property="tel_magasin" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="faxx_magasin">
<lay:collectionItem    property="fax_magasin" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="nom_ress">
<lay:collectionItem    property="nom_res" ></lay:collectionItem>
</lay:collectionTitle>



<lay:collectionTitle title="remarque_magasin1">
<lay:collectionItem    property="remarque_magasin" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="fam_magasin">
<lay:collectionItem   >
<lay:collection id="i" name="ji" property="liste">
<lay:collectionItem    property="libelle_famille_princi"  ></lay:collectionItem>
</lay:collection>
</lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" " href="gestion_magasin.do?action=modif&id=" paramId="id" param="id_magasin"><img src="config/modif.png" alt="modifier" border="0" /></lay:collectionItem>
<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_magasin"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>
</logic:present>
<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_magasin"/></td>
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
lien=SortUtil.getURLForCollection("id_magasin",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_magasin",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("adresse_magasin",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("tel_magasin",request);
lien3=lien3.replace("amp;","")+nb_page;
lien4=SortUtil.getURLForCollection("fax_magasin",request);
lien4=lien4.replace("amp;","")+nb_page;
lien5=SortUtil.getURLForCollection("nom_res",request);
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
 $.jGrowl(image+'<bean:message key="java.typmagasin"  />'+fin);
 rouge('id')
window.document.getElementById('id').focus()
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libmagasin"  />'+fin);
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
{window.location.href='gestion_magasin.do?action=supp&id='+document.getElementById('cd').value}

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

function numeric(evt)
{

var keyCode = evt.which ? evt.which : evt.keyCode;
if(document.getElementById('id').value=='0')
return false
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;   
else{
  if(keyCode>=48&&keyCode<=55)
   {return true;}
   else return false;
   }

}

function envoie(id)
{
if(id=='id_magasin_lien')
document.location.href='<%=lien%>'
if(id=='lib_magasin_lien')
document.location.href='<%=lien1%>'
if(id=='adr_magasin_lien')
document.location.href='<%=lien2%>'
if(id=='tel_magasin_lien')
document.location.href='<%=lien3%>'
if(id=='fax_magasin_lien')
document.location.href='<%=lien4%>'
if(id=='res_magasin_lien')
document.location.href='<%=lien5%>'



}
function block()
{return false;}
</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


