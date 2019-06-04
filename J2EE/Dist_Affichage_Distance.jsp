<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>

<lay:html locale="true" >
<head>
<title><bean:message key="aff_distance.type" /></title>
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



	<lay:panel align="center" key="aff_distance.type" styleClass="FORM">


		<tr>
		
				<td align="left"><bean:message key="aff_distance.du" />  </td>
		  		<td align="left"><html:text name="ladate" property="debut"  size="10" maxlength="10"  styleId="debut"  onkeypress="return numeric_date(event,'debut')"></</html:text>
				<img src="images/calendrier.gif" id="f_trigger_c0" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "debut",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c0",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
	
		</td>
		
		<td></td>
		<td></td>
		<td></td>
		<td></td>
				<td align="left"><bean:message key="aff_distance.au" />  </td>
					<td align="left"><html:text name="ladate" property="fin" size="10" maxlength="10"  styleId="fin" onkeypress="return numeric_date(event,'fin')" ></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "fin",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				</td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
			<td colspan="4" align="center">
<html:button styleId="b1"  property="" onclick="return verifier_envoie()" > <bean:message key="afficher_dist"/></html:button>
			
			</td>
			
    <td colspan="4" align="center">
<html:button styleId="b1"  property="" onclick="return verifier()" > <bean:message key="imprime_centre"/></html:button>	
			</td>
			</tr>
		


		</lay:panel>	

<br/>
<br/>
<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_distance" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_distance" id="ji"  styleClass="FORM" styleClass2="FORM2" >

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
{if(!DateValide(tab[0],tab[1],tab[2]))
{ $.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
rouge(id)
}
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
{blond(id)
blond(id1)
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'
test=traitement(id,id1)
if(!test)
{
$.jGrowl(image+'<bean:message key="snen"   />'+fin2);
rouge(id)
rouge(id1)
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


function verifier_envoie()
{
blond('debut')
blond('fin')
debut=document.getElementById('debut').value
fin=document.getElementById('fin').value
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'
if(debut=='')
{$.jGrowl(image+'<bean:message key="dist_vide_debut"   />'+fin2);
rouge('debut')
return false;}


if(fin=='')
{$.jGrowl(image+'<bean:message key="dist_vide_fin"   />'+fin2);
rouge('fin')
return false;}

if(!verif_date('debut')||!verif_date('fin'))
return false;

test=supperieur('debut','fin')
if(!test)
{
return false
rouge('debut')
rouge('fin')
}
else
{
document.location.href='aff_distance.do?action=rechercher&date_debut='+debut+'&date_fin='+fin
return true;
}

}


function verifier()
{
blond('debut')
blond('fin')
debut=document.getElementById('debut').value
fin=document.getElementById('fin').value
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'


if(fin==''&&debut=='')
{
window.open('aff_distance.do?action=imprimer_tous')
return true;
}

if(debut=='')
{$.jGrowl(image+'<bean:message key="dist_vide_debut"   />'+fin2);
rouge('debut')
return false;}


if(fin=='')
{$.jGrowl(image+'<bean:message key="dist_vide_fin"   />'+fin2);
rouge('fin')
return false;}

if(!verif_date('debut')||!verif_date('fin'))
return false;

test=supperieur('debut','fin')
if(!test)
{
return false
rouge('debut')
rouge('fin')
}
else
{
window.open('aff_distance.do?action=imprimer&date_debut='+debut+'&date_fin='+fin)
return true;
}

}

</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>

