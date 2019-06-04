<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>

<lay:html locale="true" >
<head>
<title><bean:message key="affect_vehi.type" /></title>
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
<b><bean:message key="affect_vehi.type" /></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<html:form action="affectaion_vehicule.do?action=ajout" styleId="form" >
	<lay:panel align="center" key="ajout.affect_vehi" styleClass="FORM">
	
					<tr>
		
				<td align="left"> <bean:message key="lib_vehi_affectation"/> </td>
					<td align="left" width="300px">
					<html:select styleId="select_vehicule" property="id_vehicule" name="affect_vehi" onchange="agaga()">
					<html:options collection="liste_vehicule" property="id_vehicule"  name="liste_vehicule" labelProperty="libelle_vehicule"/>
            		</html:select>
				</td>
			</tr>
			
			
			
		<tr>
		
				<td align="left"> <bean:message key="lib_centre_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_centre" property="id_centre" name="affect_vehi" onchange="hiearchi_centre()">
					<html:options collection="liste_centre" property="id_centre"  name="liste_centre" labelProperty="libelle_centre"/>
            		</html:select>
				</td>
			</tr>
			
			
			
			<tr>
		
				<td align="left"> <bean:message key="lib_agence_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_agence" property="id_agence" name="affect_vehi" onchange="hiearchi_agence()">
					<html:options collection="liste_agence" property="id_agence"  name="liste_agence" labelProperty="libelle_agence"/>
            		</html:select>
				</td>
			</tr>


			<tr>
		
				<td align="left"> <bean:message key="lib_service_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_service" property="id_service" name="affect_vehi">
					<html:options collection="liste_service" property="id_service"  name="liste_service" labelProperty="libelle_service"/>
            		</html:select>
				</td>
			</tr>

			
				<tr>
				<td align="left">  <bean:message key="lib_date_affectation"/> </td>
				<td align="left"><html:text  name="affect_vehi" property="date_affectation" size="10" maxlength="10"  styleId="affectation" onkeypress="return numeric_date(event,'affectation')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "affectation",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			
			</tr>
			<tr>
				<td></td>
				<td > <html:submit styleId="b1" indexed="b1" onclick="return (nonvide()&& verif_date('affectation'))"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
		
	</lay:panel>



</html:form>
</logic:notPresent>

<logic:present name="affect_vehi_init">
<html:hidden property="id_vehicule" name="affect_vehi_init" styleId="id_vehi"/>
<html:hidden property="id_service" name="affect_vehi_init" styleId="id_serv"/>
<html:hidden property="date_affectation" name="affect_vehi_init" styleId="date"/>
</logic:present>

<logic:present name="x"> 
<html:form action="affectaion_vehicule.do?action=edit" styleId="form" >
	<lay:panel align="center" key="ajout.affect_vehi" styleClass="FORM">
	
					<tr>
		
				<td align="left"> <bean:message key="lib_vehi_affectation"/> </td>
					<td align="left">
				<html:text readonly="true"  name="affect_vehi" property="libelle_vehicule" size="10" maxlength="10"  styleId="id" ></html:text>
				</td>
			</tr>
			
			
			
		<tr>
		
				<td align="left"> <bean:message key="lib_centre_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_centre" property="id_centre" name="affect_vehi" onchange="hiearchi_centre()">
					<html:options collection="liste_centre" property="id_centre"  name="liste_centre" labelProperty="libelle_centre"/>
            		</html:select>
				</td>
			</tr>
			
			
			
			<tr>
		
				<td align="left"> <bean:message key="lib_agence_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_agence" property="id_agence" name="affect_vehi" onchange="hiearchi_agence()">
					<html:options collection="liste_agence" property="id_agence"  name="liste_agence" labelProperty="libelle_agence"/>
            		</html:select>
				</td>
			</tr>


			<tr>
		
				<td align="left"> <bean:message key="lib_service_affectation"/> </td>
					<td align="left">
					<html:select styleId="select_service" property="id_service" name="affect_vehi">
					<html:options collection="liste_service" property="id_service"  name="liste_service" labelProperty="libelle_service"/>
            		</html:select>
				</td>
			</tr>

			
				<tr>
				<td align="left">  <bean:message key="lib_date_affectation"/> </td>
				<td align="left"><html:text  name="affect_vehi" property="date_affectation" size="10" maxlength="10"  styleId="affectation" onkeypress="return numeric_date(event,'affectation')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "affectation",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			
			</tr>
			<tr>
	<td></td>
				<td>
				
				<table border="0">
				<tr>
				<td>
				 <html:submit styleId="b1" indexed="b1" onclick="return (editer());"  > <bean:message key="modif"/></html:submit>
				 </td><td>
				<html:button styleId="b1"  onclick="document.location.href='affectaion_vehicule.do?action=all'" property="" >  <bean:message key="annuler"/></html:button></td>
			  </tr>
			   </table>
			   </td>
			</tr>
		
	</lay:panel>



</html:form>

</logic:present>

<logic:present name="x">
<script language="javascript" type="text/javascript"> window.document.getElementById('affectation').focus()</script>
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
<logic:present name="liste_affect_vehi" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_affect_vehi" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="libelle_affect_vehicule_aff">
<lay:collectionItem  property="libelle_vehicule"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_affect_centre_aff">
<lay:collectionItem    property="libelle_centre" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_affect_agence_aff">
<lay:collectionItem    property="libelle_agence" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="libelle_affect_service_aff">
<lay:collectionItem    property="libelle_service" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_affect_date_aff">
<lay:collectionItem    property="date_affectation" ></lay:collectionItem>

</lay:collectionTitle>



<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<bean:define id="temp1" name="ji" property="id_service"></bean:define>
<bean:define id="temp2" name="ji" property="date_affectation"></bean:define>
<img src="config/modif.png" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>



<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<bean:define id="temp1" name="ji" property="id_service"></bean:define>
<bean:define id="temp2" name="ji" property="date_affectation"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>
</center>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_affect_vehi"/></td>
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
</lay:popup>




<%
String lien="",lien1="",lien2="",lien3="",lien4="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("libelle_vehicule",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_centre",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_agence",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_service",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("date_affectation",request);
lien4=lien4.replace("amp;","")+nb_page;
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
<input type="hidden" id='cd'></input>
<input type="hidden" id='cd1'></input>
<input type="hidden" id='cd2'></input>
<% session.removeAttribute("sms");%>

<script language="javascript" type="text/javascript">


function nonvide()
{
blond('select_vehicule')
blond('select_centre')
blond('select_agence')
blond('select_service')
blond('affectation')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('select_vehicule').length
if(id==0)
{test=false
 $.jGrowl(image+'<bean:message key="java.affecation_vehi_vehi"  />'+fin);
 rouge('select_vehicule') 
}
lib=document.getElementById('select_centre').length
if(lib==0)
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_centre"  />'+fin);
rouge('select_centre')
test=false
}
x=document.getElementById('select_agence').length
if(x==0)
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_agence"  />'+fin);
rouge('select_agence')
test=false
}

x=document.getElementById('select_service').length
if(x==0)
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_service"  />'+fin);
rouge('select_service')
test=false
}

x=document.getElementById('affectation').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_date"  />'+fin);
rouge('affectation')
window.document.getElementById('affectation').focus()
test=false
}
return test

}

function supp(cd,cd1,cd2)
{
document.getElementById('cd').value=cd
document.getElementById('cd1').value=cd1
document.getElementById('cd2').value=cd2
document.getElementById('aff').style.backgroundColor='#3366A3'
document.getElementById('aff').style.color='white'
document.getElementById('aff').style.fontWeight = 'bold'
openStrutsLayoutPopup('popup')
return false
}

function supp2()
{window.location.href='affectaion_vehicule.do?action=supp&id_vehi='+document.getElementById('cd').value+'&id_serv='+document.getElementById('cd1').value+'&dat_aff='+document.getElementById('cd2').value}

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
if(id=='affectation_vehicule_lien')
document.location.href='<%=lien%>'
if(id=='affectation_centre_lien')
document.location.href='<%=lien1%>'
if(id=='affectation_agence_lien')
document.location.href='<%=lien2%>'
if(id=='affectation_service_lien')
document.location.href='<%=lien3%>'
if(id=='affectation_date_lien')
document.location.href='<%=lien4%>'
}

function numeric(evt)
{

var keyCode = evt.which ? evt.which : evt.keyCode;
if(keyCode==48&&document.getElementById('id').value=='')
return false
if(keyCode==17||keyCode==16||keyCode==9||keyCode==8||keyCode==20||keyCode==13)
return true;   
else{
  if(keyCode>=48&&keyCode<=57)
   {return true;}
   else return false;
   }

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
{if(!DateValide(tab[0],tab[1],tab[2]))
 {$.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
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
{$.jGrowl(image+'<bean:message key="snen"   />'+fin2);
rouge(id)
rouge(id)
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

function hiearchi_centre()
{
id_centre=document.getElementById('select_centre').options[document.getElementById('select_centre').selectedIndex].value
document.getElementById('form').action='affectaion_vehicule.do?action=changement_centre&id_centre='+id_centre
document.getElementById('form').submit()
}

function hiearchi_agence()
{
id_agence=document.getElementById('select_agence').options[document.getElementById('select_agence').selectedIndex].value
document.getElementById('form').action='affectaion_vehicule.do?action=changement_agence&id_agence='+id_agence
document.getElementById('form').submit()
}


function modifier(cd,cd1,cd2)
{window.location.href='affectaion_vehicule.do?action=modif&id_vehi='+cd+'&id_serv='+cd1+'&dat_aff='+cd2
}

function editer()
{

test = true
test=nonvide1()&&verif_date('affectation')
if(test)
{

id_vehicule=document.getElementById('id_vehi').value
id_service=document.getElementById('id_serv').value
date_affect=document.getElementById('date').value

document.getElementById('form').action='affectaion_vehicule.do?action=edit&id_vehi='+id_vehicule+'&id_serv='+id_service+'&dat_aff='+date_affect
document.getElementById('form').submit()
}
else return false;
}





function nonvide1()
{
blond('select_centre')
blond('select_agence')
blond('select_service')
blond('affectation')

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'

lib=document.getElementById('select_centre').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_centre"  />'+fin);
rouge('select_centre')
test=false
}
x=document.getElementById('select_agence').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_agence"  />'+fin);
rouge('select_agence')
test=false
}

x=document.getElementById('select_service').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_service"  />'+fin);
rouge('select_service')
test=false
}

x=document.getElementById('affectation').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.affectation_vehi_date"  />'+fin);
rouge('affectation')
test=false
}
return test

}
</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>

