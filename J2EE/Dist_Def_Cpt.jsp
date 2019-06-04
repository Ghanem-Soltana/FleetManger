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
<title><bean:message key="rel.type" /></title>
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
<b><bean:message key="rel.type" /></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<html:form action="init_cpt.do?action=ajout">
	<lay:panel align="center" key="ajout.rel" styleClass="FORM">
		
	
	
		
			<tr>

				<td align="left"> <bean:message key="cpt.type_cpt" /></td>
					<td align="left" width="200px">
					<html:select property="id_type_cpt" name="init_cpt" styleId="select_cpt">
					<html:options collection="liste_type_compteur" property="id_compteur"  name="liste_type_compteur" labelProperty="libelle_compteur"/>
            		</html:select>
				</td>
			</tr>
			
				<tr>

				<td align="left"> <bean:message key="cpt.type_vehi" /></td>
					<td align="left">
					<html:select property="id_vehicue" name="init_cpt" styleId="select_vehicule">
					<html:options collection="liste_vehicule" property="id_vehicule"  name="liste_vehicule" labelProperty="libelle_vehicule"/>
            		</html:select>
				</td>
			</tr>
			
			
					<tr>
				<td align="left"> <bean:message key="cpt.type_date" /> </td>
				<td align="left"><html:text name="init_cpt" property="date" size="10" maxlength="10" styleId="releve"  onkeypress="return numeric_date(event,'releve')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "releve",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				</td>
			</tr>


				<tr>
				<td align="left"> <bean:message key="cpt.type_val_cpt" /> </td>
				<td align="left"><html:text name="init_cpt" property="cpt_inital" size="10" maxlength="10" styleId="cpt" onkeypress="return numeric(event,'cpt')"></html:text></td>
			</tr>
	
			

			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide()&&verif_date('releve')"  > <bean:message key="ajout"/></html:submit></td>
		
			</tr>
		
	</lay:panel>



</html:form>
</logic:notPresent>

<logic:present name="x">
<html:form action="init_cpt.do?action=edit">
	<lay:panel align="center" key="edit.rel" styleClass="FORM">
		
			
		
			<tr>

				<td align="left"> <bean:message key="cpt.type_cpt" /></td>
					<td align="left">
					<html:text property="id_type_cpt" name="init_cpt" size="30"  maxlength="30" readonly="true"></html:text>
				</td>
				
			</tr>
			
				<tr>

				<td align="left"> <bean:message key="cpt.type_vehi" /></td>
					<td align="left">
						<html:text property="id_vehicue" name="init_cpt" size="30"  maxlength="30" readonly="true"></html:text>

				</td>
			</tr>
			
			
					<tr>
				<td align="left"><bean:message key="cpt.type_date" /></td>
				<td align="left"><html:text name="init_cpt" property="date" size="10" maxlength="10" styleId="releve"  onkeypress="return numeric_date(event,'releve')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "releve",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				</td>
			</tr>


				<tr>
				<td align="left"> <bean:message key="cpt.type_val_cpt" /> </td>
				<td align="left"><html:text name="init_cpt" property="cpt_inital" size="10" maxlength="10" styleId="cpt" onkeypress="return numeric(event,'cpt')"></html:text></td>
			</tr>
	
			





			<tr>
				<td></td>
				<td> 
				
				<table>
				<tr>
				<td>
			
				<html:submit styleId="b1" indexed="b1" onclick="return nonvide1()&&verif_date('releve');"  > <bean:message key="modif"/></html:submit>
				</td><td>
				<html:button styleId="b1" onclick="document.location.href='init_cpt.do?action=all'" property="id_modelevehi" > <bean:message key="annuler"/></html:button>
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
<logic:present name="liste_init_cpt" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_init_cpt" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="aff_type_cpt_distance_aff">
<lay:collectionItem  property="libelle_type_cpt"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_vefi_cpt_aff">
<lay:collectionItem  property="libelle_vehicue"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_date_cpt_aff">
<lay:collectionItem    property="date" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="aff_cpt_cpt_aff">
<lay:collectionItem    property="cpt_inital" ></lay:collectionItem>
</lay:collectionTitle>




<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicue"></bean:define>
<bean:define id="temp1" name="ji" property="id_type_cpt"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_cpt"/></td>
    <td align="center"><input type="text" id="aff"  maxlength="5" style="border-width:0px;height:20px;width:40px;" onkeypress="return block()"></input></td></tr>
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
</center>



<%
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",lien6="",lien7="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("libelle_type_cpt",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_vehicue",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("date",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("cpt_inital",request);
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

blond('cpt')
blond('releve')
blond('select_cpt')
blond('select_vehicule')



test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'

id=document.getElementById('releve').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.cpt_date"  />'+fin);
window.document.getElementById('releve').focus()
rouge('releve')
}
lib=document.getElementById('cpt').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.cpt_cpt"  />'+fin);
rouge('cpt')
if(test==true)
window.document.getElementById('cpt').focus()
test=false
}

type=document.getElementById('select_cpt').options.length
vehi=document.getElementById('select_vehicule').options.length

if(type==0)
{
$.jGrowl(image+'<bean:message key="java.cpt_type"  />'+fin);
rouge('select_cpt')
test=false
}

if(vehi==0)
{
$.jGrowl(image+'<bean:message key="java.cpt_vehi"  />'+fin);
rouge('select_vehicule')
test=false
}
return test

}



function nonvide1()
{
blond('releve')
blond('cpt')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('releve').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.cpt_date"  />'+fin);
window.document.getElementById('releve').focus()
rouge('releve')
}
lib=document.getElementById('cpt').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.cpt_cpt"  />'+fin);
rouge('cpt')
if(test==true)
window.document.getElementById('cpt').focus()
test=false
}

return test

}

function supp(cd,cd1)
{
document.getElementById('cd').value=cd
document.getElementById('cd1').value=cd1
document.getElementById('aff').style.backgroundColor='#3366A3'
document.getElementById('aff').style.color='white'
document.getElementById('aff').style.fontWeight = 'bold'
openStrutsLayoutPopup('popup')
return false
}

function supp2()
{window.location.href='init_cpt.do?action=supp&id_mac='+document.getElementById('cd').value+'&id_rel='+document.getElementById('cd1').value}

function modifier(cd,cd1)
{window.location.href='init_cpt.do?action=modif&id_mac='+cd+'&id_rel='+cd1}



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
if(id=='typr_cpt_lien')
document.location.href='<%=lien%>'
if(id=='vehi_cpt_lien')
document.location.href='<%=lien1%>'
if(id=='date_cpt_lien')
document.location.href='<%=lien2%>'
if(id=='cpt_cpt_lien')
document.location.href='<%=lien3%>'


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
if(!DateValide(tab[0],tab[1],tab[2])||supperieur('mnt',id))
 {$.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
 rouge(id)
 }
return (DateValide(tab[0],tab[1],tab[2])&&!supperieur('mnt',id))
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
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin2='</td></tr></table></center>'
test=traitement(id,id1)

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
</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


