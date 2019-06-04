<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>



 
<lay:html locale="true" >
<head>
<title><bean:message key="titre_societe"/></title>
 <meta http-equiv="Pragma" content="no-cache" />
  <meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
  <meta http-equiv="Expires" content="0" />
  
  
  <style type="text/css">
div.fileinputs {
	position: relative;
	cursor: pointer;
}

div.fakefile {
	position: absolute;
	top: -4px;
	left: 25px;
	z-index: 1;
	cursor: pointer;
}

input.file {
	position: relative;
	text-align: center;
	-moz-opacity:0 ;
	filter:alpha(opacity: 0);
	opacity: 0;
	z-index: 2;
	cursor: pointer;
}
</style>
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
<table border="0" align="center" >
<tr>
<td>
<html:form action="fiche_societe.do?action=edit" styleId="form">
<lay:panel align="center" key="titre_societe" styleClass="FORM">
<tr> 
     <td align="left"><bean:message key="id_soc"/></td>
     <td align="left"><html:text name="societe" readonly="true"  property="id_societe" size="4" maxlength="3" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
</tr>
<tr> 
     <td align="left"><bean:message key="nom_soc"/></td>
     <td align="left"><html:text name="societe" property="libelle_societe" size="50" maxlength="50" styleId="lib" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="sigle_soc"/></td>
     <td align="left"><html:text name="societe" property="sigle" size="20" maxlength="20" styleId="sigle" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="juridique_soc"/></td>
     <td align="left"><html:text name="societe" property="forme_juridique" size="10" maxlength="10" styleId="jur" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="capital_soc"/></td>
     <td align="left"><html:text name="societe" property="capitale" size="15" maxlength="15" styleId="capital" onkeypress="return numeric1(event,'capital')"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="mat_soc"/></td>
     <td align="left"><html:text name="societe" property="matricule_fiscale" size="15" maxlength="15" styleId="mat" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="registe_comm_soc"/></td>
     <td align="left"><html:text name="societe" property="num_rc" size="15" maxlength="15" styleId="registre" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="adess1_soc"/></td>
     <td align="left"><html:text name="societe" property="adresse_1" size="50" maxlength="50" styleId="adress1" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="adress2_soc"/></td>
     <td align="left"><html:text name="societe" property="adresse_2" size="50" maxlength="50" styleId="adress2" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="ville_soc"/></td>
    
     <td align="left">

     	          	<html:select property="id_ville" name="societe" onchange="agaga()" styleId="select">
					<html:options collection="liste2" property="id_ville"  name="liste2" labelProperty="libelle_ville"/>
            		</html:select>
            		
            		<logic:iterate id="i" name="liste2" >
            		<bean:define id="temp" name="i" property="id_ville" ></bean:define>
            		<%String temp1=String.valueOf(temp);%>
            		<html:hidden name="i" property="cp" styleId="<%=temp1 %>"/>
            		</logic:iterate>
   </td>
</tr>

<tr> 
     <td align="left"><bean:message key="cp_soc"/></td>
     <td align="left"><html:text name="societe" readonly="true" property="cp" size="6" maxlength="6" styleId="cpppp" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="jour_soc"/></td>
     <td align="left"><html:text name="societe" property="nb_jour" size="1" maxlength="1" styleId="jour" onkeypress="return numeric(event,'jour')"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="conge_soc"/></td>
     <td align="left"><html:text name="societe" property="conge" size="1" maxlength="1" styleId="conge" onkeypress="return numeric(event,'conge')"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="report_soc"/></td>
     <td align="left"><html:text name="societe" property="annee_reporte" size="1" maxlength="1" styleId="report" onkeypress="return numeric1(event,'report')"></html:text></td>
</tr><tr> 
     <td align="left"><bean:message key="remarque_soc"/></td>
     <td align="left"><html:text name="societe" property="remarque" size="50" maxlength="50" styleId="remarque" onkeypress="return alphanum(event)"></html:text></td>
</tr><tr> 
     <td align="left"></td>
     <td align="left"><html:submit  styleId="b1" onclick="return nonvide()"> <bean:message key="enregistrer"/></html:submit></td>
</tr>

</lay:panel>












</html:form>
</td>
<td align="center">
<table border="3" style="margin-left: 30px;"><tr><td>
<table border="0" align="center" width="400px">
<tr><td align="center"><b><bean:message key="logo"/></b></td></tr>
<tr><td align="center">
<%
String temp4="images/societe/logo";
try{temp4=temp4+session.getAttribute("nb").toString();}catch(Exception e){}
temp4=temp4+".gif";
if(temp4.equals("images/societe/logo.gif"))
	temp4="images/societe/logo0.gif";
if(!new java.io.File(temp4).exists())
temp4=	"images/societe/logo0.gif";

%>

<lay:img src="<%=temp4 %>"    />
</td></tr>
<tr><td align="center">
<html:form action="/upload.do" method="post"  enctype="multipart/form-data">

<table border="0" width="400px">
<tr style="height=38px;">
<td align="center" valign="middle" style="margin-top:0;">

	<div class="fileinputs" style="margin-top:0;">
  <html:file  name="file" styleClass="file"  size="3"  property="file" styleId="imagess"/> 
	<div class="fakefile" style="margin-top:0;"> 

		  <html:button styleId="b2" property=""  ><bean:message key="parcourir_image" /></html:button>

	</div>
</div>




</td>
<td valign="middle" align="center">
<div>
  <html:submit styleId="b1" onclick="return test()" ><bean:message key="modifier" /></html:submit>
</div>
</td>
</tr>
</table>


</html:form>
</td></tr>
</table>
</td></tr></table>
</td>
</tr>
</table>


<logic:present name="sms">
<div class="containerPlus draggable" width="250"  style="top:55px;left:10px" buttons="c"  icon="ok.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">

				<p><bean:message key="enregistrement_ok"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
 </logic:present>

<logic:present name="erreur">
<div class="containerPlus draggable" width="250"  style="top:65px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">
				<h3><bean:message key="er_titre"/></h3>
				<p><bean:message key="er_base"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
 </logic:present>
 
 
 <logic:present name="erreur1">
<div class="containerPlus draggable" width="250"  style="top:65px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">
				<h3><bean:message key="er_titre"/></h3>
				<p><bean:message key="er_soci_image_taille"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
 </logic:present>
<%request.getSession().removeAttribute("erreur1"); %>
 
<script language="javascript" type="text/javascript"> window.document.getElementById('lib').focus();
 window.document.getElementById('id').style.background='#99FF80'
 window.document.getElementById('cpppp').style.background='#99FF80'
 document.getElementById('lib').focus
</script>


	
<script language="javascript" type="text/javascript">
function nonvide()
{
blond('id')
blond('lib')
blond('sigle')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.idsoci"  />'+fin);
window.document.getElementById('id').focus()
rouge('id')
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libsoci"  />'+fin);
if(test==true)
window.document.getElementById('lib').focus()
rouge('lib')
test=false
}

sigle=document.getElementById('sigle').value
if(sigle=='')
{
$.jGrowl(image+'<bean:message key="java.siglesoci"  />'+fin);
rouge('sigle')
if(test==true)
window.document.getElementById('sigle').focus()
test=false
}
return test

}




function alphanum(evt)
{
var keyCode = evt.which ? evt.which : evt.keyCode;

if(keyCode==32||keyCode==46||keyCode==45||keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
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

function numeric(evt,id)
{

var keyCode = evt.which ? evt.which : evt.keyCode;
if(keyCode==48&&document.getElementById(id).value=='')
return false
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;   
else{
  if(keyCode>=48&&keyCode<=55)
   {return true;}
   else return false;
   }

}

function numeric1(evt,id)
{

var keyCode = evt.which ? evt.which : evt.keyCode;
if(keyCode==48&&document.getElementById(id).value=='')
return false
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;   
else{
  if(keyCode>=48&&keyCode<=57)
   {return true;}
   else return false;
   }

}



function agaga()
{
id=document.getElementById('select').options[document.getElementById('select').selectedIndex].value
if(id==null||id=='')
id='xxxxx'
val=document.getElementById(id).value
if(val=='0')
document.getElementById('cpppp').value=''
else
document.getElementById('cpppp').value=val
}

function block()
{return false;}

function test()
{image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
lien=document.getElementById('imagess').value
if(lien=='')
{$.jGrowl(image+'<bean:message key="java.imgsoci"  />'+fin);
return false;}

ext=lien.charAt(lien.length-3);
ext=ext+lien.charAt(lien.length-2);
ext=ext+lien.charAt(lien.length-1);
if(ext!='gif'&&ext!='jpg'&&ext!='jpeg')
{$.jGrowl(image+'<bean:message key="java.extsoci"  />'+fin);
return false;}
}




</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


