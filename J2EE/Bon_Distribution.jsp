<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>
<%@ page import="java.text.DateFormat,java.text.SimpleDateFormat" %>

<lay:html locale="true">
<head>
<title><bean:message key="type.dist"/> </title>
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
<b><bean:message key="type.dist"/> </b>
<br/>
<br/>



<html:form action="distribution_bon.do?action=ajout" styleId="form">
	<lay:panel align="center" key="ajout.distribution_carb" styleClass="FORM">
		
			<tr>
				<td align="left" >  <bean:message key="dist_code"/> </td>
				
				<logic:notPresent name="x">
				<td align="left" width="300px"><html:text name="bon_distribution" property="id_distribution" size="6" maxlength="6" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
				</logic:notPresent>
					
					<logic:present name="x">
					<td align="left"  width="300px"><html:text readonly="true" name="bon_distribution" property="id_distribution" size="6" maxlength="6" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
					</logic:present>
			</tr>


				

				<tr>

				<td align="left"> <bean:message key="dist_exe"/>   </td>
					<td align="left">
					<html:select property="id_exercice" name="bon_distribution" styleId="liste_annee">
					<html:options collection="liste_annee" property="id_saison"  name="liste_annee" labelProperty="libelle_saison"/>
            		</html:select>
				</td>
			</tr>
			
					<tr>

				<td align="left">  <bean:message key="dist_mag"/>  </td>
					<td align="left">
					<html:select property="id_magasin" name="bon_distribution" styleId="liste_magasin">
					<html:options collection="liste_magasin" property="id_magasin"  name="liste_magasin" labelProperty="libelle_magasin"/>
            		</html:select>
				</td>
			</tr>
			
			<tr>
			<td align="left">  <bean:message key="dist_date"/></td>
			<td align="left">
						<% java.util.Date l_date = new java.util.Date(System.currentTimeMillis());
   String l_stFormatDate = new String("dd/MM/yyyy");
   DateFormat l_formatDate = new SimpleDateFormat(l_stFormatDate, java.util.Locale.FRENCH);
   String date = l_formatDate.format(l_date);
 
%><html:text styleId="date" property="date_distribution"  name="bon_distribution" size="10" maxlength="10" value="<%=date%>" onkeypress="return block()"></html:text>
			</td>
			</tr>

	<tr>
	<td align="left"> <bean:message key="dist_magasinier"/> </td>
					<td align="left">
					<html:select property="id_magasinier" name="bon_distribution" styleId="magasinier">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			

				<tr>
				    <td align="left"> <bean:message key="dist_veh"/>  </td>
					<td align="left">
					<html:select property="id_vehicule" name="bon_distribution" styleId="select_vehicule" onchange="hiearchi_vehicule()">
					<html:options collection="liste_vehicule" property="id_vehicule"  name="liste_vehicule" labelProperty="libelle_vehicule" />
            		</html:select>
				    </td>
			  </tr>
			  
			  <tr>
			  <td align="left"> <bean:message key="lib_centre_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_centre" property="id_centre" name="bon_distribution" onchange="hiearchi_centre()">
					<html:options collection="liste_centre" property="id_centre"  name="liste_centre" labelProperty="libelle_centre"/>
            		</html:select>
				</td>
			</tr>
			
			
			
			<tr>
		
				<td align="left"> <bean:message key="lib_agence_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_agence" property="id_agence" name="bon_distribution" onchange="hiearchi_agence()">
					<html:options collection="liste_agence" property="id_agence"  name="liste_agence" labelProperty="libelle_agence"/>
            		</html:select>
				</td>
			</tr>


			<tr>
		
				<td align="left"> <bean:message key="lib_service_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_service" property="id_service" name="bon_distribution">
					<html:options collection="liste_service" property="id_service"  name="liste_service" labelProperty="libelle_service"/>
            		</html:select>
				</td>
			</tr>
			
			
			<tr>
			 <td align="left"> <bean:message key="dist_recep"/>   </td>
					<td align="left">
					<html:select property="id_recepteur" name="bon_distribution" styleId="recepteur">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			
				<tr>
				<td align="left" > <bean:message key="dist_der_rec"/> </td>
				<td align="left" width="300px"><html:text readonly="true" name="bon_distribution" property="libelle_dernier_recepteur" size="20" maxlength="20" styleId="dernier_recepteur" ></html:text></td>
					
			</tr>
			  
			  	<tr>
				<td align="left" ><bean:message key="dist_der_dat_cpt"/>  </td>
				<td align="left" width="300px"><html:text readonly="true"  name="bon_distribution" property="date_dernier_compteur" size="20" maxlength="20" styleId="date_dernier_compteur" ></html:text></td>
					
			</tr>
			
		  
			  	<tr>
				<td align="left" > <bean:message key="dist_der_cpt"/> </td>
				<td align="left" width="300px"><html:text readonly="true" name="bon_distribution" property="dernier_compteur" size="20" maxlength="20" styleId="dernier_compteur" ></html:text></td>
					
			</tr>
				<tr>
				<td align="left" ><bean:message key="dist_der_qte"/>  </td>
				<td align="left" width="300px"><html:text readonly="true" name="bon_distribution" property="dernier_quantité" size="20" maxlength="20" styleId="dernier_quantité" ></html:text></td>
					
			</tr>
				<tr>
				<td align="left" ><bean:message key="dist_dist"/> </td>
				<td align="left" width="300px"><html:text readonly="true" name="bon_distribution" property="distance_parcourus" size="20" maxlength="20" styleId="distance_parcourus" ></html:text></td>
					
			</tr>
				<tr>
				<td align="left" ><bean:message key="dist_taux"/> </td>
				<td align="left" width="300px"><html:text readonly="true"  name="bon_distribution" property="taux" size="20" maxlength="20" styleId="taux" ></html:text></td>
					
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
		<logic:notPresent name="x">
			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1"  onclick="return nonvide();"> <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
		</logic:notPresent>
			
				<logic:present name="x">
		<tr>
				<td></td>
				<td> <html:button property="" styleId="b1" indexed="b1"  onclick="document.location.href='distribution_bon.do?action=all'"> <bean:message key="Retourner"/></html:button></td>
			    <td></td>
			</tr>			
				
				</logic:present>
	
	</lay:panel>
</html:form>


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
<logic:present name="liste_bon_distribution" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_bon_distribution" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="aff_dist_code">
<lay:collectionItem  property="id_distribution"  ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="aff_dist_ex">
<lay:collectionItem    property="libelle_exercice" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_dist_mag">
<lay:collectionItem    property="libelle_magasin" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="aff_dist_vehi">
<lay:collectionItem    property="libelle_vehicule" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_dist_rec">
<lay:collectionItem    property="libelle_recepteur" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_dist_etat">
<lay:collectionItem    property="valide" ></lay:collectionItem>
</lay:collectionTitle>




<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_exercice"></bean:define>
<bean:define id="temp1" name="ji" property="id_distribution"></bean:define>
<bean:define id="temp2" name="ji" property="id_magasin"></bean:define>
<img src="images/add.png" height="20px" width="20px" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>


<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_transfert_carb"/></td>
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
String lien="", lien1="", lien2="",lien3="",lien4="",lien5="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("id_distribution",request);
lien=lien.replace("amp;","")+nb_page;

lien1=SortUtil.getURLForCollection("libelle_exercice",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_magasin",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_vehicule",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("libelle_recepteur",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("valide",request);
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
window.document.getElementById('date').style.background='#99FF80'
window.document.getElementById('taux').style.background='#99FF80'
window.document.getElementById('distance_parcourus').style.background='#99FF80'
window.document.getElementById('dernier_quantité').style.background='#99FF80'
window.document.getElementById('dernier_compteur').style.background='#99FF80'
window.document.getElementById('date_dernier_compteur').style.background='#99FF80'
window.document.getElementById('dernier_recepteur').style.background='#99FF80'



function nonvide()
{
blond('id')
blond('liste_annee')
blond('liste_magasin')
blond('magasinier')
blond('select_vehicule')
blond('select_service')


test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'

id=document.getElementById('id').value
if(id=='')
{test=false
$.jGrowl(image+'<bean:message key="java.dist_carb"  />'+fin);
window.document.getElementById('id').focus()
rouge('id')
}

x=document.getElementById('liste_annee').options.length
if(x==0)
{
$.jGrowl(image+'<bean:message key="java.date_dis_carburant"  />'+fin);
rouge('liste_annee')
test=false
}


vehicule=document.getElementById('liste_magasin').options.length
if(vehicule==0)
{test=false
rouge('liste_magasin')
$.jGrowl(image+'<bean:message key="java.liste_annee_dist_carburant"/>'+fin);
}


vehicule=document.getElementById('magasinier').options.length
if(vehicule==0)
{rouge('magasinier')
test=false
$.jGrowl(image+'<bean:message key="java.agent_carburant"/>'+fin);
}

vehicule=document.getElementById('select_vehicule').options.length
if(vehicule==0)
{rouge('select_vehicule')
test=false
$.jGrowl(image+'<bean:message key="java.liste_vehi_dist_carburant"/>'+fin);
}

vehicule=document.getElementById('select_service').options.length
if(vehicule==0)
{rouge('select_service')
test=false
$.jGrowl(image+'<bean:message key="java.liste_serv_carburant1"/>'+fin);
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
{window.location.href='distribution_bon.do?action=modif&id='+cd1+'&annee='+cd2+'&mag='+cd3
}

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





function envoie(id)
{
if(id=='code_lien')
document.location.href='<%=lien%>'
if(id=='ex_lien')
document.location.href='<%=lien1%>'
if(id=='mag_lien')
document.location.href='<%=lien2%>'
if(id=='vehi_lien')
document.location.href='<%=lien3%>'
if(id=='rec_lien')
document.location.href='<%=lien4%>'
if(id=='etat_lien')
document.location.href='<%=lien5%>'


}
function block()
{return false;}





function hiearchi_centre()
{
id_centre=document.getElementById('select_centre').options[document.getElementById('select_centre').selectedIndex].value
document.getElementById('form').action='distribution_bon.do?action=changement_centre&id_centre='+id_centre
document.getElementById('form').submit()
}

function hiearchi_agence()
{
id_agence=document.getElementById('select_agence').options[document.getElementById('select_agence').selectedIndex].value
document.getElementById('form').action='distribution_bon.do?action=changement_agence&id_agence='+id_agence
document.getElementById('form').submit()
}



function hiearchi_vehicule()
{
id_vehicule=document.getElementById('select_vehicule').options[document.getElementById('select_vehicule').selectedIndex].value
document.getElementById('form').action='distribution_bon.do?action=changement_vehicule&id_vehicule='+id_vehicule
document.getElementById('form').submit()
}
</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>

