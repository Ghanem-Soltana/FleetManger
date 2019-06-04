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
<title><bean:message key="vehi_motif_arret.type" /></title>
</head>


<jsp:include flush="true" page="Menu2.jsp"></jsp:include>

	
		<script type="text/javascript">
		$(function(){
			$(".containerPlus").buildContainers({
				containment:"document",
				elementsPath:"images/elements/"
			});
		});
	</script>
<center>

<br/>
<b><bean:message key="vehi_motif_arret.type" /></b>
<br/>
<br/>


			<% java.util.Date l_date = new java.util.Date(System.currentTimeMillis());
   String l_stFormatDate = new String("dd/MM/yyyy");
   DateFormat l_formatDate = new SimpleDateFormat(l_stFormatDate, java.util.Locale.FRENCH);
   String date = l_formatDate.format(l_date);
 
%><input type="hidden" id="mnt" value="<%=date%>" ></input>

<logic:notPresent name="x"> 
<html:form action="gestion_vehi_motif_arret.do?action=ajout">
	<lay:panel align="center" key="ajout.vehi_motif_arret" styleClass="FORM">
	
			<tr>

				<td align="left"> <bean:message key="vma_vehicule"/> </td>
					<td align="left" width="200px">
					<html:select property="id_vehicule" name="vehi_motif_arret" styleId="vehi">
					<html:options collection="liste1" property="id_vehicule"  name="liste1" labelProperty="libelle_vehicule"/>
            		</html:select>
				</td>
			</tr>
			
			 <tr>

				<td align="left"> <bean:message key="vma_type"/> </td>
					<td align="left">
					<html:select property="id_arret" name="vehi_motif_arret" styleId="type">
					<html:options collection="liste2" property="id_motif"  name="liste2" labelProperty="libelle_motif"/>
            		</html:select>
				</td>
			</tr>
			
			<tr>
						<td align="left"><bean:message key="vma_debut"/></td>
			<td align="left"><html:text  name="vehi_motif_arret" property="date_debut" size="10" maxlength="10"  styleId="debut" onkeypress="return numeric_date(event,'debut')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "debut",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
			</td>
			</tr>
				<tr>		<td align="left"><bean:message key="vma_fin"/></td>
			<td align="left"><html:text  name="vehi_motif_arret" property="date_fin" size="10" maxlength="10"  styleId="fin" onkeypress="return numeric_date(event,'fin')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c2" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "fin",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c2",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
			</td>
			</tr>
			
			
			
			
			
			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide() && supperieur('debut','fin')&& supperieur('debut','mnt')"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
	
	</lay:panel>



</html:form>
</logic:notPresent>





<logic:present name="motif_vehi_init">
<html:hidden property="id_vehicule" name="motif_vehi_init" styleId="id_vehi"/>
<html:hidden property="id_arret" name="motif_vehi_init" styleId="id_arret"/>
<html:hidden property="date_debut" name="motif_vehi_init" styleId="date"/>
</logic:present>



<logic:present name="x">
<html:form action="gestion_vehi_motif_arret.do?action=edit" styleId="form">
	<lay:panel align="center" key="edit.vehi_motif_arret" styleClass="FORM">
		
		
				<tr>

				<td align="left"> <bean:message key="vma_vehicule"/> </td>
					<td align="left">
<html:text readonly="true"  name="vehi_motif_arret" property="libelle_vehicule" size="10" maxlength="10"  styleId="id"></html:text>
		
				</td>
			</tr>
		
					
			
			 <tr>

				<td align="left"> <bean:message key="vma_type"/> </td>
					<td align="left">
					<html:select property="id_arret" name="vehi_motif_arret" styleId="type">
					<html:options collection="liste2" property="id_motif"  name="liste2" labelProperty="libelle_motif"/>
            		</html:select>
				</td>
			</tr>
			
			<tr>
						<td align="left"><bean:message key="vma_debut"/></td>
			<td align="left"><html:text  name="vehi_motif_arret" property="date_debut" size="10" maxlength="10"  styleId="debut" onkeypress="return numeric_date(event,'debut')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "debut",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
			</td>
			</tr>
			
				<tr>		<td align="left"><bean:message key="vma_fin"/></td>
			<td align="left"><html:text  name="vehi_motif_arret" property="date_fin" size="10" maxlength="10"  styleId="fin" onkeypress="return numeric_date(event,'fin')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c2" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "fin",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c2",  
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
				<html:submit styleId="b1" indexed="b1" onclick="return (editer()&&supperieur('debut','mnt'));"   > <bean:message key="modif"/></html:submit>
				</td><td>
				<html:button styleId="b1" onclick="document.location.href='gestion_vehi_motif_arret.do?action=all'" property="" > <bean:message key="annuler"/></html:button>
				</td>
				</tr>
				</table>
				</td>
			 
			</tr>
		
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
<logic:present name="liste_vehi_motif_arret" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_vehi_motif_arret" id="ji"  styleClass="FORM" styleClass2="FORM2" >
<lay:collectionTitle title="vehi_vehi_motif_arret">

<lay:collectionItem  property="libelle_vehicule"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="type_vehi_motif_arret">
<lay:collectionItem    property="libelle_arret" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="debut_vehi_motif_arret">
<lay:collectionItem    property="date_debut" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="fin_vehi_motif_arret">
<lay:collectionItem    property="date_fin" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<bean:define id="temp1" name="ji" property="id_arret"></bean:define>
<bean:define id="temp2" name="ji" property="date_debut"></bean:define>
<img src="config/modif.png" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<bean:define id="temp1" name="ji" property="id_arret"></bean:define>
<bean:define id="temp2" name="ji" property="date_debut"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>


</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_vehi_motif_arret"/></td>
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
<input type="hidden" id='cd1'></input>
<input type="hidden" id='cd2'></input>
</center>



<%
String lien="",lien1="",lien2="",lien3="",nb_page="",sms="";

session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("libelle_vehicule",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_arret",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("date_debut",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("date_fin",request);
lien3=lien3.replace("amp;","")+nb_page;
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
blond('vehi')
blond('type')
blond('debut')

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('vehi').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.vma_vehi"  />'+fin);
 rouge('vehi')
window.document.getElementById('vehi').focus()
}
lib=document.getElementById('type').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.vma_type"  />'+fin);
 rouge('type')
if(test==true)
window.document.getElementById('type').focus()
test=false
}
lib=document.getElementById('debut').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.vma_debut"  />'+fin);
 rouge('debut')
if(test==true)
window.document.getElementById('debut').focus()
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
{window.location.href='gestion_vehi_motif_arret.do?action=supp&id_vehi='+document.getElementById('cd').value+'&id_arret='+document.getElementById('cd1').value+'&date='+document.getElementById('cd2').value}

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
if(id=='vehi_vehi_motif_arret_lien')
document.location.href='<%=lien%>'
if(id=='type_vehi_motif_arret_lien')
document.location.href='<%=lien1%>'
if(id=='debut_vehi_motif_arret_lien')
document.location.href='<%=lien2%>'
if(id=='fin_vehi_motif_arret_lien')
document.location.href='<%=lien3%>'
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
{
blond(id)
blond(id1)

image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'
test=traitement(id,id1)
if(!test)
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


function modifier(cd,cd1,cd2)
{window.location.href='gestion_vehi_motif_arret.do?action=modif&id_vehi='+cd+'&id_arret='+cd1+'&date='+cd2}


function editer()
{

test = true
test=nonvide1()&&verif_date('debut')&&verif_date('fin')&& supperieur('debut','fin')
if(test)
{

id_vehicule=document.getElementById('id_vehi').value
id_arret=document.getElementById('id_arret').value
date=document.getElementById('date').value

document.getElementById('form').action='gestion_vehi_motif_arret.do?action=edit&id_vehi='+id_vehicule+'&id_arret='+id_arret+'&date='+date
document.getElementById('form').submit()
}
else return false;
}




function nonvide1()
{

blond('type')
blond('debut')

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'

lib=document.getElementById('type').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.vma_type"  />'+fin);
rouge('type')
window.document.getElementById('type').focus()
test=false
}
lib=document.getElementById('debut').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.vma_debut"  />'+fin);
if(test==true)
{window.document.getElementById('debut').focus()
rouge('debut')
}
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


