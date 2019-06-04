<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>
<lay:html locale="true">
<head>
<title><bean:message key="typelub.type" /></title>
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
<b><bean:message key="typelub.type" /></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<html:form action="gestion_typelub.do?action=ajout" styleId="form">
	<lay:panel align="center" key="ajout.typelub" styleClass="FORM">
		
		
		
		
			<tr>
				<td align="left"> <bean:message key="id_typelub"/>  </td>
				<td align="left"><html:text name="typelub" property="id_typelub" size="2" maxlength="2" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
			</tr>


			<tr>
				<td align="left"> <bean:message key="lib_typelub"/>  </td>
				<td align="left"><html:text  name="typelub" property="libelle_typelub" size="50" maxlength="50"  styleId="lib"></html:text></td>
			</tr>



	<tr>

				<td align="left"> <bean:message key="article_prin_typelub"/> </td>
					<td align="left">
					<html:select  style="width=800px;" property="id_famart" name="typelub" styleId="select1" onchange="return selection()">
					<html:options collection="liste_fam_princi" property="id_famille_princi"   name="liste_fam_princi" labelProperty="libelle_famille_princi"/>
            		</html:select>
				</td>
			</tr>
						<tr>

				<td align="left"> <bean:message key="article_secon_typelub"/> </td>
					<td align="left">
					<html:select property="id_sfamart" name="typelub" styleId="select2" onchange="return selection2()">
					<html:options collection="liste_fam_sec" property="id_famille_sec"  name="liste_fam_sec" labelProperty="libelle_famille_sec"/>
            		</html:select>
				</td>
			</tr>
			
			
			<tr>

				<td align="left"> <bean:message key="article_typelub"/> </td>
					<td align="left">
					<html:select property="id_article" name="typelub" styleId="select3"  >
					<html:options collection="liste_article" property="id_article"  name="liste_article" labelProperty="libelle_article"/>
            		</html:select>
				</td>
			</tr>

			<tr>
				<td align="left"></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide()"  > <bean:message key="ajout"/></html:submit></td>
			    <td align="left"></td>
			</tr>
	
	</lay:panel>



</html:form>
</logic:notPresent>

<logic:present name="x">
<html:form action="gestion_typelub.do?action=edit" styleId="form">
	<lay:panel align="center" key="edit.typelub" styleClass="FORM">
	
					
					<tr>
				<td align="left"> <bean:message key="id_typelub"/>  </td>
				<td align="left"><html:text name="typelub" property="id_typelub" size="2" readonly="true" maxlength="2" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
			</tr>


			<tr>
				<td align="left"> <bean:message key="lib_typelub"/>  </td>
				<td align="left"><html:text  name="typelub" property="libelle_typelub" size="50" maxlength="50"  styleId="lib"></html:text></td>
			</tr>


	<tr>

				<td align="left"> <bean:message key="article_prin_typelub"/> </td>
					<td align="left">
					<html:select property="id_famart" name="typelub"  styleId="select1"  onchange="selection()">
					<html:options collection="liste_fam_princi" property="id_famille_princi"  name="liste_fam_princi" labelProperty="libelle_famille_princi"/>
            		</html:select>
				</td>
			</tr>
			
						<tr>

				<td align="left"> <bean:message key="article_secon_typelub"/> </td>
					<td align="left">
					<html:select property="id_sfamart" name="typelub"  styleId="select2" onchange="selection2()">
					<html:options collection="liste_fam_sec" property="id_famille_sec"  name="liste_fam_sec" labelProperty="libelle_famille_sec"/>
            		</html:select>
				</td>
			</tr>
			
			
			<tr>

				<td align="left"> <bean:message key="article_typelub"/> </td>
					<td align="left">
					<html:select property="id_article" name="typelub" styleId="select3">
					<html:options collection="liste_article" property="id_article"  name="liste_article" labelProperty="libelle_article"/>
            		</html:select>
				</td>
			</tr>

			<tr>
				<td align="left"></td>
				<td >
				<table border="0"><tr><td>
				<html:submit styleId="b1" indexed="b1" onclick="return nonvide();"  > <bean:message key="modif"/></html:submit>
			</td><td>
				<html:button styleId="b1" onclick="document.location.href='gestion_typelub.do?action=annul'" property="id_typelubvehi" > <bean:message key="annuler"/></html:button>
				</td>
				</tr></table>
				</td>
			    <td  align="left"></td>
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
<div class="containerPlus draggable" width="250"  style="top:55px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
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


	<html:form action="gestion_typelub.do?action=zut" styleId="form2">	
	<table border="0"><tr>
				<td><bean:message key="msg"/></td>
				<td><bean:message key="msg1"/></td>
		        <td width="190px">
					<html:select property="id_famart" name="afficher" onchange="selection3()" styleId="select4">
					<html:options collection="liste_fam_princi_afficher" property="id_famille_princi"  name="liste_fam_princi_afficher" labelProperty="libelle_famille_princi"/>
            		</html:select>
			   </td>
			</tr>
			<tr>
			<td></td>
			<td><bean:message key="msg2"/></td>
			 <td>
					<html:select property="id_sfamart" name="afficher" onchange="selection4()" styleId="select5">
					<html:options collection="liste_fam_sec_afficher" property="id_famille_sec"  name="liste_fam_sec_afficher" labelProperty="libelle_famille_sec"/>
            		</html:select>
			   </td>
			</tr>
						<tr>
			<td></td>
			<td><bean:message key="msg3"/></td>
			 <td>
					<html:select property="id_article" name="afficher" onchange="selection5()" styleId="select6">
					<html:options collection="liste_article_afficher" property="id_article"  name="liste_article_afficher" labelProperty="libelle_article"/>
            		</html:select>
			   </td>
			</tr>
			
			
</table></html:form>




 


<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_typelub" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_typelub" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_typelubvehi_lien">
<lay:collectionItem  property="id_typelub"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_typelubvehi_lien">
<lay:collectionItem  property="libelle_typelub"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="idartp_typelubvehi_lien">
<lay:collectionItem    property="id_famart" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="libartp_typelubvehi_lien">
<lay:collectionItem    property="libelle_famart" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="idarts_typelubvehi_lien">
<lay:collectionItem    property="id_sfamart" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="libarts_typelubvehi_lien">
<lay:collectionItem    property="libelle_sfamart" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="idart_typelubvehi_lien">
<lay:collectionItem    property="id_article" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="libart_typelubvehi_lien">
<lay:collectionItem    property="libelle_article" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" " href="gestion_typelub.do?action=modif&id=" paramId="id" param="id_typelub"><img src="config/modif.png" alt="modifier" border="0" /></lay:collectionItem>
<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_typelub"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_typelub"/></td>
    <td align="center"><input type="text" id="aff"  maxlength="3" style="border-width:0px;height:20px;width:40px;" onkeydown="retrun false;" onkeypress="return false;"></input></td></tr>
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
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",lien6="",lien7="",nb_page="",sms="";

session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("id_typelub",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_typelub",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("id_famart",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_famart",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("id_sfamart",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("libelle_sfamart",request);
lien5=lien3.replace("amp;","")+nb_page;

lien6=SortUtil.getURLForCollection("id_article",request);
lien6=lien4.replace("amp;","")+nb_page;

lien7=SortUtil.getURLForCollection("libelle_article",request);
lien7=lien3.replace("amp;","")+nb_page;


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
blond('select1')
blond('select2')
blond('select3')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.typtypelub"  />'+fin);
window.document.getElementById('id').focus()
rouge('id')
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libtypelub"  />'+fin);
if(test==true)
window.document.getElementById('lib').focus()
rouge('lib')
test=false
}

s1=document.getElementById('select1').options[document.getElementById('select1').selectedIndex].value
if(s1=='xxxxxx')
{
$.jGrowl(image+'<bean:message key="java.s1typelub"  />'+fin);
rouge('select1')
test=false
}

s2=document.getElementById('select2').options[document.getElementById('select2').selectedIndex].value
if(s2=='xxxxxx')
{
$.jGrowl(image+'<bean:message key="java.s2typelub"  />'+fin);
rouge('select2')
test=false
}

s3=document.getElementById('select3').options[document.getElementById('select3').selectedIndex].value
if(s3=='xxxxxx')
{
$.jGrowl(image+'<bean:message key="java.s3typelub"  />'+fin);
rouge('select3')
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
{window.location.href='gestion_typelub.do?action=supp&id='+document.getElementById('cd').value}

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
if(id=='code_typelubvehi_lien')
document.location.href='<%=lien%>'
if(id=='libelle_typelubvehi_lien')
document.location.href='<%=lien1%>'
if(id=='idartp_typelubvehi_lien')
document.location.href='<%=lien2%>'
if(id=='libartp_typelubvehi_lien')
document.location.href='<%=lien3%>'
if(id=='idarts_typelubvehi_lien')
document.location.href='<%=lien4%>'
if(id=='libarts_typelubvehi_lien')
document.location.href='<%=lien5%>'
if(id=='idart_typelubvehi_lien')
document.location.href='<%=lien6%>'
if(id=='libart_typelubvehi_lien')
document.location.href='<%=lien7%>'

}

function supprimer()
{

id=document.getElementById('select1').options[document.getElementById('select1').selectedIndex].value
if(id==null||id=='')
id='xxxxx'
val=document.getElementById(id).value
if(val=='0')
document.getElementById('cpppp').value=''
else
document.getElementById('cpppp').value=val
}



function selection()
{
id=document.getElementById('select1').options[document.getElementById('select1').selectedIndex].value
if(id==null||id=='')
id='xxxxxx'
document.getElementById('form').action='gestion_typelub.do?action=select&id='+id
document.getElementById('form').submit()
}



function selection2()
{
id=document.getElementById('select2').options[document.getElementById('select2').selectedIndex].value
if(id==null||id=='')
id='xxxxxx'
document.getElementById('form').action='gestion_typelub.do?action=select2&id='+id
document.getElementById('form').submit()
}



function selection3()
{
id=document.getElementById('select4').options[document.getElementById('select4').selectedIndex].value
if(id==null||id=='')
id='xxxxxx'
document.getElementById('form2').action='gestion_typelub.do?action=select4&id='+id
document.getElementById('form2').submit()

}

function selection4()
{
id=document.getElementById('select5').options[document.getElementById('select5').selectedIndex].value
if(id==null||id=='')
id='xxxxxx'
document.getElementById('form2').action='gestion_typelub.do?action=select5&id='+id
document.getElementById('form2').submit()

}

function selection5()
{
id=document.getElementById('select6').options[document.getElementById('select6').selectedIndex].value
if(id==null||id=='')
id='xxxxxx'
document.getElementById('form2').action='gestion_typelub.do?action=select6&id='+id
document.getElementById('form2').submit()

}


function numeric(evt,id)
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

</script>
</center>
</lay:html>


<jsp:include flush="true" page="footer3.jsp"></jsp:include>

<script type="text/javascript">
DynarchMenu.setup('menu');
</script>