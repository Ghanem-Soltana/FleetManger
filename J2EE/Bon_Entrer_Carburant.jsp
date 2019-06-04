<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>


<lay:html locale="true">
<head>
<title><bean:message key="entrer_carb.type" /></title>
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
<b><bean:message key="entrer_carb.type" /></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<html:form action="gestion_entrer_carburant.do?action=ajout">
	<lay:panel align="center" key="ajout.entrer_carb" styleClass="FORM">
		
			<tr>
				<td align="left"> <bean:message key="id_entrer_carb"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="id_bon" size="6" maxlength="6" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
					
			</tr>


				

				<tr>

				<td align="left"> <bean:message key="liste_annee_entrer_carb"/> </td>
					<td align="left">
					<html:select property="id_exercice" name="entrer_carburant" styleId="liste_annee">
					<html:options collection="liste_annee" property="id_saison"  name="liste_annee" labelProperty="libelle_saison"/>
            		</html:select>
				</td>
			</tr>
			
					<tr>

				<td align="left"> <bean:message key="liste_mag_entrer_carb"/> </td>
					<td align="left">
					<html:select property="id_magasin" name="entrer_carburant" styleId="liste_magasin">
					<html:options collection="liste_magasin" property="id_magasin"  name="liste_magasin" labelProperty="libelle_magasin"/>
            		</html:select>
				</td>
			</tr>
			
			
			<tr>
				<td align="left">  <bean:message key="date_entrer_carb"/> </td>
				<td align="left"><html:text  name="entrer_carburant" property="date_entrer" size="10" maxlength="10"  styleId="entrer" onkeypress="return numeric_date(event,'entrer')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "entrer",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			
			</tr>
			
					<tr>

				<td align="left"> <bean:message key="liste_agent_entrer_carb"/> </td>
					<td align="left">
					<html:select property="id_agent" name="entrer_carburant" styleId="liste_agent">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			
			
						<tr>

				<td align="left"> <bean:message key="liste_typebon_entrer_carb"/> </td>
					<td align="left">
					<html:select property="id_type_bon" name="entrer_carburant" styleId="liste_typebon">
					<html:options collection="liste_typebon" property="id_bon"  name="liste_typebon" labelProperty="libelle_bon"/>
            		</html:select>
				</td>
			</tr>

				<tr>
				<td align="left"> <bean:message key="reference_entrer_carb"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="reference" size="10" maxlength="10" styleId="reference" ></html:text></td>
					
			</tr>
		
				<tr>
				<td align="left"> <bean:message key="debut_bon"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="debut_bon" size="15" maxlength="15" styleId="debut"  onkeypress="return numeric(event,'debut')"></html:text></td>
					
			</tr>
					<tr>
				<td align="left"> <bean:message key="fin_bon"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="fin_bon" size="15" maxlength="15" styleId="fin"  onkeypress="return numeric(event,'fin')"></html:text></td>
					
			</tr>	
			
			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide()&&verif_date('entrer')"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
	
	</lay:panel>



</html:form>
</logic:notPresent>

<logic:present name="x">
<html:form action="gestion_entrer_carburant.do?action=edit">
	<lay:panel align="center" key="edit.entrer_carb" styleClass="FORM">
		
				<tr>
				<td align="left"> <bean:message key="id_entrer_carb"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="id_bon" size="6" maxlength="6" styleId="id" readonly="true" onkeypress="return alphanum(event)"></html:text></td>
					
			</tr>

				<tr>

				<td align="left"> <bean:message key="liste_annee_entrer_carb"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="libelle_exercice" size="4" maxlength="4" styleId="id" readonly="true" onkeypress="return alphanum(event)"></html:text>			
				<html:hidden name="entrer_carburant" property="id_exercice"/>
				</td>
					
		</tr>
			
					<tr>

				<td align="left"> <bean:message key="liste_mag_entrer_carb"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="libelle_magasin" size="30" maxlength="30" styleId="id" readonly="true" onkeypress="return alphanum(event)"></html:text></td>
				<html:hidden name="entrer_carburant" property="id_magasin"/>
					
			</tr>
			
					<tr>
				<td align="left">  <bean:message key="date_entrer_carb"/> </td>
				<td align="left"><html:text  name="entrer_carburant" property="date_entrer" size="10" maxlength="10"  styleId="entrer" onkeypress="return numeric_date(event,'date_entrer')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "entrer",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			
			</tr>
			
					<tr>
		
				<td align="left"> <bean:message key="liste_agent_entrer_carb"/> </td>
					<td align="left">
					<html:select property="id_agent" name="entrer_carburant" styleId="liste_agent">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			
			
						<tr>

				<td align="left"> <bean:message key="liste_typebon_entrer_carb"/> </td>
					<td align="left">
					<html:select property="id_type_bon" name="entrer_carburant" styleId="liste_typebon">
					<html:options collection="liste_typebon" property="id_bon"  name="liste_typebon" labelProperty="libelle_bon"/>
            		</html:select>
				</td>
			</tr>
			
				<tr>
				<td align="left"> <bean:message key="reference_entrer_carb"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="reference" size="10" maxlength="10" styleId="reference"  ></html:text></td>
					
			</tr>
			
			<tr>
				<td align="left"> <bean:message key="debut_bon"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="debut_bon" size="15" maxlength="15" styleId="debut"  onkeypress="return numeric(event,'debut')"></html:text></td>
					
			</tr>
			<tr>
				<td align="left"> <bean:message key="fin_bon"/>  </td>
				<td align="left"><html:text name="entrer_carburant" property="fin_bon" size="15" maxlength="15" styleId="fin"  onkeypress="return numeric(event,'fin')"></html:text></td>
					
			</tr>	
			
						<tr>
				<td></td>
				
				<td> 
				<table border="0">
				<tr>
				<td>
				<html:submit styleId="b1" indexed="b1" onclick="return ((nonvide1()&&verif_date('entrer')));"   > <bean:message key="modif"/></html:submit>
				</td><td>
				<html:button styleId="b1" onclick="document.location.href='gestion_entrer_carburant.do?action=all'" property="" > <bean:message key="annuler"/></html:button>
				</td>
				</tr>
				</table>
				</td>
			 
			</tr>
		
		<html:hidden name="entrer_carburant" property="vld"/>
		
	</lay:panel>



</html:form>
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
<logic:present name="liste_entrer_carburant" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_entrer_carburant" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="id_bon_affichage">
<lay:collectionItem  property="id_bon"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_date_entrer">
<lay:collectionItem    property="date_entrer" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_exercice_affichage">
<lay:collectionItem    property="libelle_exercice" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_magasin_affichage">
<lay:collectionItem    property="libelle_magasin" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_agent_affichage">
<lay:collectionItem    property="libelle_agent" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_typebon_affichage">
<lay:collectionItem    property="libelle_type_bon" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_reference_affichage">
<lay:collectionItem    property="reference" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_debut_bon_affichage">
<lay:collectionItem    property="debut_bon" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_fin_bon_affichage">
<lay:collectionItem    property="fin_bon" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_vld_affichage">
<lay:collectionItem    property="vld" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_bon"></bean:define>
<bean:define id="temp1" name="ji" property="id_exercice"></bean:define>
<bean:define id="temp2" name="ji" property="id_magasin"></bean:define>
<img src="config/modif.png" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>

<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_bon"></bean:define>
<bean:define id="temp1" name="ji" property="id_exercice"></bean:define>
<bean:define id="temp2" name="ji" property="id_magasin"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>



</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>


<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_entrer_carb"/></td>
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



<input type="hidden" id='cd1'></input>
<input type="hidden" id='cd2'></input>
<input type="hidden" id='cd3'></input>

</center>



<%
String lien="", lien1="", lien2="",lien3="",lien4="",lien5="",lien6="",lien7="",lien8="",lien9="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("id_bon",request);
lien=lien.replace("amp;","")+nb_page;

lien1=SortUtil.getURLForCollection("date_entrer",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_exercice",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_magasin",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("libelle_agent",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("libelle_type_bon",request);
lien5=lien5.replace("amp;","")+nb_page;

lien6=SortUtil.getURLForCollection("debut_bon",request);
lien6=lien6.replace("amp;","")+nb_page;

lien7=SortUtil.getURLForCollection("fin_bon",request);
lien7=lien7.replace("amp;","")+nb_page;

lien8=SortUtil.getURLForCollection("reference",request);
lien8=lien8.replace("amp;","")+nb_page;

lien9=SortUtil.getURLForCollection("reference",request);
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

function nonvide()
{

$('#id').css( {'border-color': ''});
$('#entrer').css( {'border-color': ''});
$('#liste_annee').css( {'border-color': ''});
$('#liste_magasin').css( {'border-color': ''});
$('#liste_agent').css( {'border-color': ''});
$('#liste_typebon').css( {'border-color': ''});
$('#reference').css( {'border-color': ''});
$('#debut').css( {'border-color': ''});
$('#fin').css( {'border-color': ''});

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.typentrer_carb"  />'+fin);
    $('#id').css( {'border-color': 'red'});
 	$('#id').fadeOut("fast");
	$('#id').fadeIn("fast");
window.document.getElementById('id').focus()
}
x=document.getElementById('entrer').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.date_entrer_entrer_carburant"  />'+fin);
    $('#entrer').css( {'border-color': 'red'});
 	$('#entrer').fadeOut("fast");
	$('#entrer').fadeIn("fast");
if(test==true)
window.document.getElementById('entrer').focus()
test=false
}


vehicule=document.getElementById('liste_annee').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_annee_entrer_carburant"/>'+fin);
    $('#liste_annee').css( {'border-color': 'red'});
 	$('#liste_annee').fadeOut("fast");
	$('#liste_annee').fadeIn("fast");
}


vehicule=document.getElementById('liste_magasin').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_magasin_entrer_carburant"/>'+fin);
    $('#liste_magasin').css( {'border-color': 'red'});
 	$('#liste_magasin').fadeOut("fast");
	$('#liste_magasin').fadeIn("fast");
}

vehicule=document.getElementById('liste_agent').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_entrer_carburant"/>'+fin);
    $('#liste_agent').css( {'border-color': 'red'});
 	$('#liste_agent').fadeOut("fast");
	$('#liste_agent').fadeIn("fast");
}

vehicule=document.getElementById('liste_typebon').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_typebon_entrer_carburant"/>'+fin);
    $('#liste_typebon').css( {'border-color': 'red'});
 	$('#liste_typebon').fadeOut("fast");
	$('#liste_typebon').fadeIn("fast");
}

reference=document.getElementById('reference').value
if(reference=='')
{
 $.jGrowl(image+'<bean:message key="java.reference_entrer_carburant"  />'+fin);
    $('#reference').css( {'border-color': 'red'});
 	$('#reference').fadeOut("fast");
	$('#reference').fadeIn("fast");
 if(test)
window.document.getElementById('reference').focus()
test=false
}

debut=document.getElementById('debut').value
if(debut=='')
{
 $.jGrowl(image+'<bean:message key="java.debut_entrer_carburant"  />'+fin);
    $('#debut').css( {'border-color': 'red'});
 	$('#debut').fadeOut("fast");
	$('#debut').fadeIn("fast");
 if(test)
window.document.getElementById('debut').focus()
test=false
}

fin1=document.getElementById('fin').value
if(fin1=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.fin_entrer_carburant"  />'+fin);
    $('#fin').css( {'border-color': 'red'});
 	$('#fin').fadeOut("fast");
	$('#fin').fadeIn("fast");
 if(test)
window.document.getElementById('fin').focus()
test=false
}

if(parseInt(debut)>parseInt(fin1))
{
test=false
 $.jGrowl(image+'<bean:message key="java.plus_grand_entrer_carburant"  />'+fin);
   $('#fin').css( {'border-color': 'red'});
 	$('#fin').fadeOut("fast");
	$('#fin').fadeIn("fast");
    $('#debut').css( {'border-color': 'red'});
 	$('#debut').fadeOut("fast");
	$('#debut').fadeIn("fast");
}
return test

}


function nonvide1()
{

$('#entrer').css( {'border-color': ''});
$('#liste_annee').css( {'border-color': ''});
$('#liste_agent').css( {'border-color': ''});
$('#liste_typebon').css( {'border-color': ''});
$('#reference').css( {'border-color': ''});
$('#debut').css( {'border-color': ''});
$('#fin').css( {'border-color': ''});

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'


x=document.getElementById('entrer').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.date_entrer_entrer_carburant"  />'+fin);
if(test==true)
window.document.getElementById('entrer').focus()
    $('#entrer').css( {'border-color': 'red'});
 	$('#entrer').fadeOut("fast");
	$('#entrer').fadeIn("fast");
test=false
}



vehicule=document.getElementById('liste_agent').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_entrer_carburant"/>'+fin);
    $('#liste_agent').css( {'border-color': 'red'});
 	$('#liste_agent').fadeOut("fast");
	$('#liste_agent').fadeIn("fast");
}

vehicule=document.getElementById('liste_typebon').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_typebon_entrer_carburant"/>'+fin);
    $('#liste_typebon').css( {'border-color': 'red'});
 	$('#liste_typebon').fadeOut("fast");
	$('#liste_typebon').fadeIn("fast");

}

reference=document.getElementById('reference').value
if(reference=='')
{
 $.jGrowl(image+'<bean:message key="java.reference_entrer_carburant"  />'+fin);
    $('#reference').css( {'border-color': 'red'});
 	$('#reference').fadeOut("fast");
	$('#reference').fadeIn("fast");
 if(test)
window.document.getElementById('reference').focus()
test=false
}

debut=document.getElementById('debut').value
if(debut=='')
{
 $.jGrowl(image+'<bean:message key="java.debut_entrer_carburant"  />'+fin);
    $('#debut').css( {'border-color': 'red'});
 	$('#debut').fadeOut("fast");
	$('#debut').fadeIn("fast");
 if(test)
window.document.getElementById('debut').focus()
test=false
}

fin1=document.getElementById('fin').value
if(fin1=='')
{
 $.jGrowl(image+'<bean:message key="java.fin_entrer_carburant"  />'+fin);
    $('#fin').css( {'border-color': 'red'});
 	$('#fin').fadeOut("fast");
	$('#fin').fadeIn("fast");
	if(test)
window.document.getElementById('fin').focus()
test=false
}

if(parseInt(debut)>parseInt(fin1))
{
test=false
 $.jGrowl(image+'<bean:message key="java.plus_grand_entrer_carburant"  />'+fin);
    $('#debut').css( {'border-color': 'red'});
 	$('#debut').fadeOut("fast");
	$('#debut').fadeIn("fast");
	$('#fin').css( {'border-color': 'red'});
 	$('#fin').fadeOut("fast");
	$('#fin').fadeIn("fast");
}
return test

}

function supp(cd1,cd2,cd3)
{
document.getElementById('cd1').value=cd1
document.getElementById('cd2').value=cd2
document.getElementById('cd3').value=cd3
document.getElementById('aff').style.backgroundColor='#3366A3'
document.getElementById('aff').style.color='white'
document.getElementById('aff').style.fontWeight = 'bold'
openStrutsLayoutPopup('popup')
return false
}

function modifier(cd1,cd2,cd3)
{window.location.href='gestion_entrer_carburant.do?action=modif&id='+cd1+'&annee='+cd2+'&mag='+cd3
}

function supp2()
{window.location.href='gestion_entrer_carburant.do?action=supp&id='+document.getElementById('cd1').value+'&annee='+document.getElementById('cd2').value+'&mag='+document.getElementById('cd3').value}

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




function verif_date(id)
{
$('#'+id).css( {'border-color': ''});
ch=document.getElementById(id).value;
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
if(ch==''||ch=='on')return true;

tab=ch.split('/')
if(tab.length!=3)
{
 $.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
 	$('#'+id).css( {'border-color': 'red'});
 	$('#'+id).fadeOut("fast");
	$('#'+id).fadeIn("fast");
return false}
else 
{if(!DateValide(tab[0],tab[1],tab[2]))
    {$.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
 	$('#'+id).css( {'border-color': 'red'});
 	$('#'+id).fadeOut("fast");
	$('#'+id).fadeIn("fast");}
return DateValide(tab[0],tab[1],tab[2])
}

}


function DateValide(j,m,a)
{return ((j>0)&&(j<=nbjours(m,a))&&(m>0)&&(m<=12));}

function bissextile (a)
{return (a %4==0&&a%100!=0||a%400==0);}

function nbjours(m,a)
{switch(m)
 {case 1 :case 3: case 5 :case 7: case 8:case 10 :case 12 :return 31;
  case 2 :if (bissextile(a) ) return 29 ;
  else return 28;
 }
 return 31;
}


function numeric_date(evt,id)
{

var keyCode = evt.which ? evt.which : evt.keyCode;
if(keyCode==48&&document.getElementById(id).value=='')
return false
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;   
else{
  if(keyCode>=47&&keyCode<=57)
   {return true;}
   else return false;
   }

}

function supperieur(id,id1)
{$('#'+id).css( {'border-color': ''});
$('#'+id1).css( {'border-color': ''});
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'
test=traitement(id,id1)
if(!test)
{
$.jGrowl(image+'<bean:message key="snen"   />'+fin2);
	$('#'+id).css( {'border-color': 'red'});
 	$('#'+id).fadeOut("fast");
	$('#'+id).fadeIn("fast");
	$('#'+id1).css( {'border-color': 'red'});
 	$('#'+id1).fadeOut("fast");
	$('#'+id1).fadeIn("fast");
}
 return test
 
}
 
 
 
 function editer()
{

test = true
test=nonvide1()&&verif_date('debut_bon')&&verif_date('fin_bon')&& supperieur('debut_bon','fin_bon')
if(test)
{

id_bon=document.getElementById('id_bon').value
id_exercice=document.getElementById('id_exercice').value
id_magasin=document.getElementById('id_magasin').value

document.getElementById('form').action='gestion_entrer_carburant.do?action=edit&id='+id_bon+'&annee='+id_exercice+'&mag='+id_magasin
document.getElementById('form').submit()
}
else return false;
}
 

 function traitement(id,id1)
 {
 
debut=document.getElementById(id).value
fin=document.getElementById(id1).value
if(debut!=''&&fin!='')
{
tab=debut.split('/')
tab1=fin.split('/')

if(tab1[2]>tab[2])
return true;
else{if(tab1[1]>tab[1]&&tab1[2]==tab[2])
     return true;
     else
     {if(tab1[0]>tab[0]&&tab1[1]==tab[1]&&tab1[2]==tab[2])
       return true
       else return false
     }
	}

}
else return true;

}


function envoie(id)
{
if(id=='id_entrer_carb_lien')
document.location.href='<%=lien%>'
if(id=='date_entrer_carb_lien')
document.location.href='<%=lien1%>'
if(id=='exercice_entrer_carb_lien')
document.location.href='<%=lien2%>'
if(id=='magasin_entrer_carb_lien')
document.location.href='<%=lien3%>'
if(id=='agent_entrer_carb_lien')
document.location.href='<%=lien4%>'
if(id=='typebon_entrer_carb_lien')
document.location.href='<%=lien5%>'
if(id=='debut_bon_entrer_carb_lien')
document.location.href='<%=lien6%>'
if(id=='fin_bon_entrer_carb_lien')
document.location.href='<%=lien7%>'
if(id=='reference_entrer_carb_lien')
document.location.href='<%=lien8%>'
if(id=='etat_lien')
document.location.href='<%=lien9%>'
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

