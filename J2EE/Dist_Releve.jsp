<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>
<%@ page import="java.text.DateFormat,java.text.SimpleDateFormat" %>

<lay:html locale="true" >
<head>
<title><bean:message key="releve_dist.type" /></title>
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
	
	
	

			<% java.util.Date l_date = new java.util.Date(System.currentTimeMillis());
   String l_stFormatDate = new String("dd/MM/yyyy");
   DateFormat l_formatDate = new SimpleDateFormat(l_stFormatDate, java.util.Locale.FRENCH);
   String date = l_formatDate.format(l_date);
 
%><input type="hidden" id="mnt" value="<%=date%>" ></input>
	



<br/>
<b><bean:message key="releve_dist.type1" /></b>
<br/>
<br/>



<logic:notPresent name="x"> 
<html:form action="releve_vehicule.do?action=ajout" styleId="form">
	<lay:panel align="center" key="ajout.relevé" styleClass="FORM" >
	
	
			<tr>
			  <td align="left"><bean:message key="releve_dist_vehi" /> </td>
				<td align="left" width="200px">
	                <html:select property="id_vehicule" name="releve"   styleId="select_vehicule" onchange="maj_vehicule()">
					<html:options collection="liste_vehicule" property="id_vehicule"  name="liste_vehicule" labelProperty="libelle_vehicule"/>
            		</html:select>
               </td>
               </tr>

			<tr>
				<td align="left"><bean:message key="releve_dist_rel" /> </td>
				<td align="left"><html:text readonly="true" name="releve" property="id_distance" size="10" maxlength="8" styleId="id_rel" ></html:text></td>

		
			</tr>
			
				
				<tr>
				<td align="left"> <bean:message key="releve_dist_ant" /></td>
				<td align="left"><html:text readonly="true"  name="releve" property="ancien_compteur" size="10" maxlength="9"  styleId="anterieur"></html:text></td>
			</tr>
			
			
					<tr>
				<td align="left"><bean:message key="releve_last_date" /> </td>
				<td align="left"><html:text readonly="true"  name="releve" property="ancienne_date" size="10" maxlength="9"  styleId="ancien_date"></html:text></td>
			</tr>
			
			
						
				<tr>
				<td align="left"><bean:message key="releve_dist_act" /></td>
				<td align="left"><html:text   name="releve" property="actuel_compteur" size="10" maxlength="9"  onkeyup="maj_rapport()" styleId="actuelle" onkeypress="return numeric(event,'actuelle')"></html:text></td>
			</tr>
			
			
		
			
					<tr>
				<td align="left"><bean:message key="releve_dist_dist_cpt" /> </td>
				<td align="left"><html:text readonly="true" name="releve" property="rapport_distance_compteur" size="10" maxlength="10"  styleId="rapport"></html:text> &nbsp;Km</td>
			</tr>
			
						<tr>
				<td align="left"><bean:message key="releve_dist_qte_util" />  </td>
				<td align="left"><html:text  name="releve" property="qté_combustible" size="10" maxlength="10"  styleId="qte_combustible" onkeypress="return numeric(event,'qte_combustible')"></html:text></td>
			</tr>
			
			
			<tr>
				<td align="left"><bean:message key="releve_dist_qte_date" />   </td>
				<td align="left"><html:text  name="releve" property="date" size="10" maxlength="10"  styleId="releve" onkeypress="return numeric_date(event,'releve')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c0" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "releve",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c0",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
	
			
			</tr>

			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide()&&verif_date('releve')&&supperieur('ancien_date','releve')&&supperieur('releve','mnt')"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>

	</lay:panel>



</html:form>
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
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide_dist"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_releve" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_releve" id="ji"  styleClass="FORM" styleClass2="FORM2" >


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

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_papier"/></td>
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
<div class="containerPlus draggable" width="250"  style="top:60px;left:10px" buttons="c"  icon="ok.png" skin="black" minimized="false">
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
window.document.getElementById('id_rel').style.background='#99FF80'
window.document.getElementById('anterieur').style.background='#99FF80'
window.document.getElementById('rapport').style.background='#99FF80'
window.document.getElementById('ancien_date').style.background='#99FF80'




function nonvide()
{
blond('select_vehicule')
blond('actuelle')
blond('releve')
blond('rapport')
blond('select_vehicule')
blond('select_vehicule')
blond('qte_combustible')
blond('ancien_date')

test=true
image='<table ><tr><td><img border="0" style="cursor: pointer;" src="images/attention.png" ></td><td align="center">'
fin='</td></tr></table></center>'
vehi=document.getElementById('select_vehicule').length
if(vehi==0)
{test=false
 $.jGrowl(image+'<bean:message key="java.releve.vehicule"  />'+fin);
 rouge('select_vehicule')
}
actuelle=document.getElementById('actuelle').value
if(actuelle=='')
{
$.jGrowl(image+'<bean:message key="java.releve.vehicule"  />'+fin);
window.document.getElementById('actuelle').focus()
rouge('actuelle')
test=false
}




actuelle=document.getElementById('qte_combustible').value
if(actuelle=='')
{
$.jGrowl(image+'<bean:message key="java.releve.qte_combustible"  />'+fin);
if(test)
window.document.getElementById('qte_combustible').focus()
rouge('qte_combustible')
test=false
}


actuelle=document.getElementById('releve').value
if(actuelle=='')
{
$.jGrowl(image+'<bean:message key="java.releve.date"  />'+fin);
if(test)
window.document.getElementById('releve').focus()
rouge('releve')
test=false
}


actuelle=document.getElementById('rapport').value
if(actuelle==''&&test==true)
{
$.jGrowl(image+'<bean:message key="java.releve.rapport"  />'+fin);
rouge('rapport')
test=false
}
return test

}

function supp(cd)
{
document.getElementById('aff').style.backgroundColor='#3366A3'
document.getElementById('aff').style.color='white'
document.getElementById('aff').style.fontWeight = 'bold'
openStrutsLayoutPopup('popup')
return false
}

function supp2()
{window.location.href='releve_vehicule.do?action=supp&id='+document.getElementById('cd').value}

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

function block()
{return false;}



function verif_date(id)
{blond(id)
ch=document.getElementById(id).value;
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
if(ch==''||ch=='on')return true;

tab=ch.split('/')
if(tab.length!=3)
{
 $.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
 rouge(id)
return false}
else 
{
if(!DateValide(tab[0],tab[1],tab[2]))
{ $.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
rouge(id)
return false;
}
else
return true;
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
{blond(id)
blond(id1)
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'
test=traitement(id,id1)

if(test==false)
{
if(id1!='mnt')
{$.jGrowl(image+'<bean:message key="snen"   />'+fin2);
 rouge(id)
 rouge(id1)
 
 }
 else 
 {$.jGrowl(image+'<bean:message key="depasse_po_aujourd"   />'+fin2);
  rouge(id)
 }
 }

 return test
 
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


function maj_vehicule()
{
if(document.getElementById('select_vehicule').length!=0)
{document.getElementById('form').action='releve_vehicule.do?action=maj_vehicule&id_vehi='+document.getElementById('select_vehicule').options[document.getElementById('select_vehicule').selectedIndex].value+'&id_rel='+document.getElementById('id_rel').value
document.getElementById('form').submit()
}

}


function maj_rapport()
{

anterieur=document.getElementById('anterieur').value
actuelle=document.getElementById('actuelle').value

test=anterieur!=''&&actuelle!=''
test=test&&parseInt(anterieur)<parseInt(actuelle)
tehorique=0;

if(test)
{
tehorique=parseInt(actuelle)-parseInt(anterieur)
test=test&&tehorique>0
if(test)
{document.getElementById('rapport').value=tehorique}
else
{document.getElementById('rapport').value=''}

}

}

</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


