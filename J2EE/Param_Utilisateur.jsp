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
<title><bean:message key="utilisateur.type" /></title>
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
<b><bean:message key="utilisateur.type" /></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<html:form action="gestion_utilisateur.do?action=ajout">
	<lay:panel align="center" key="ajout.utilisateur" styleClass="FORM">

			<tr>
				<td align="left"> <bean:message key="id_utilisateur"/>  </td>
				<td align="left"><html:text name="utilisateur" property="login_utilisateur" size="20" maxlength="20" styleId="id" onkeypress="return alphanum(event)"></html:text></td>

		
			</tr>

			<tr>
				<td align="left"> <bean:message key="lib_utilisateur"/>  </td>
				<td align="left"><html:text  name="utilisateur" property="nom_utilisateur" size="20" maxlength="20"  styleId="lib"></html:text></td>

			</tr>


	<tr>
				<td align="left"> <bean:message key="prenom_utilisateur"/>  </td>
				<td align="left"><html:text  name="utilisateur" property="prenom_utilisateur" size="20" maxlength="20"  styleId="prenom"></html:text></td>

			</tr>
			
			
			<tr>
				<td align="left">  <bean:message key="naissance_utilisateur"/> </td>
				<td align="left"><html:text  name="utilisateur" property="date_naissance" size="10" maxlength="10"  styleId="naissance" onkeypress="return numeric_date(event,'naissance')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c0" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "naissance",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c0",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="priv_utilisateur"/>    </td>
				<td align="left">

<html:radio name="utilisateur" property="privilege" value="admin."><bean:message key="admin_utilisateur"/></html:radio>
<html:radio name="utilisateur" property="privilege" value="utilisateur"><bean:message key="utilisateur_utilisateur"/></html:radio>
	
				
				</td>




			</tr>
			
			
			
					<tr>
				<td align="left"><bean:message key="mdp_utilisateur"/>   </td>
				<td align="left"><html:password name="utilisateur" property="mot_passe1" size="20" maxlength="20" styleId="pass" ></html:password></td>
			</tr>
			
					<tr>
				<td align="left"><bean:message key="mdp1_utilisateur"/> </td>
				<td align="left"><html:password name="utilisateur" property="mot_passe2" size="20" maxlength="20" styleId="pass1" ></html:password></td>
			</tr>
			
			





			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return nonvide()&&verif_date('naissance')"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>

	</lay:panel>



</html:form>
</logic:notPresent>

<logic:present name="x">
<html:form action="gestion_utilisateur.do?action=edit">
	<lay:panel align="center" key="edit.utilisateur" styleClass="FORM">
	

<html:hidden name="utilisateur" property="login_utilisateur"  styleId="id" ></html:hidden>

		

			<tr>
				<td align="left"> <bean:message key="lib_utilisateur"/>  </td>
				<td align="left"><html:text  name="utilisateur" property="nom_utilisateur" size="20" maxlength="20"  styleId="lib"></html:text></td>

			</tr>


	<tr>
				<td align="left"> <bean:message key="prenom_utilisateur"/>  </td>
				<td align="left"><html:text  name="utilisateur" property="prenom_utilisateur" size="20" maxlength="20"  styleId="prenom"></html:text></td>

			</tr>
			
			
			<tr>
				<td align="left"> <bean:message key="naissance_utilisateur"/> </td>
				<td align="left"><html:text  name="utilisateur" property="date_naissance" size="10" maxlength="10"  styleId="naissance" onkeypress="return numeric_date(event,'naissance')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c0" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "naissance",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c0",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			</tr>
			
				<tr>
				<td align="left"><bean:message key="priv_utilisateur"/>   </td>
				<td align="left">

<html:radio name="utilisateur" property="privilege" value="admin."> <bean:message key="admin_utilisateur"/></html:radio>
<html:radio name="utilisateur" property="privilege" value="utilisateur"><bean:message key="utilisateur_utilisateur"/></html:radio>
	
				
				</td>




			</tr>
			
			
			
					<tr>
				<td align="left"><bean:message key="ancien_mdp_utilisateur"/>  </td>
				<td align="left"><html:password name="utilisateur" property="mot_passe1" size="20" maxlength="20" styleId="pass" ></html:password></td>
			</tr>
			
					<tr>
				<td align="left"><bean:message key="nv_mdp_utilisateur"/>   </td>
				<td align="left"><html:password name="utilisateur" property="mot_passe2" size="20" maxlength="20" styleId="pass1" ></html:password></td>
			</tr>
			
					<tr>
				<td align="left"><bean:message key="nv1_mdp_utilisateur"/> </td>
				<td align="left"><input type="password" size="20" maxlength="20" id="pass2" ></input></td>
			</tr>
			


			<tr>
				<td></td>
				<td>
				<table border="0"><tr>
				<td>
				 <html:submit styleId="b1" indexed="b1" onclick="return nonvide1()&&verif_date('naissance');"  > <bean:message key="modif"/></html:submit>
				 </td><td>
				 <html:button styleId="b1"  onclick="document.location.href='gestion_utilisateur.do?action=all'" property="" > <bean:message key="annuler"/></html:button>
				 </td>
				 </tr></table>
				 </td>
			 
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
<logic:present name="liste_utilisateur" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_utilisateur" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_utilisateur">
<lay:collectionItem  property="nom_utilisateur"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_utilisateur">
<lay:collectionItem    property="prenom_utilisateur" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="date_utilisateur_aff">
<lay:collectionItem    property="date_naissance" ></lay:collectionItem>
</lay:collectionTitle>



<lay:collectionTitle title="priv_utilisateur_aff">
<lay:collectionItem    property="privilege" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" " href="gestion_utilisateur.do?action=modif&id=" paramId="id" param="login_utilisateur"><img src="config/modif.png" alt="modifier" border="0"  /></lay:collectionItem>
<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="login_utilisateur"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>')" />
</lay:collectionItem>

</lay:collection>
</lay:pager>

</logic:present>
</logic:notPresent>

<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_utilisateur"/></td>
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
String lien="",lien1="",lien2="",lien3="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("nom_utilisateur",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("prenom_utilisateur",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("date_naissance",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("privilege",request);
lien3=lien3.replace("amp;","")+nb_page;


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
function nonvide()
{
blond('id')
blond('lib')
blond('prenom')
blond('naissance')
blond('pass')
blond('pass1')
test=true
image='<table ><tr><td><img border="0" style="cursor: pointer;" src="images/attention.png" ></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.typutilisateur"  />'+fin);
 rouge('id')
window.document.getElementById('id').focus()
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libutilisateur"  />'+fin);
rouge('lib')
if(test==true)
window.document.getElementById('lib').focus()
test=false
}


prenom=document.getElementById('prenom').value
if(prenom=='')
{
$.jGrowl(image+'<bean:message key="java.prenomutilisateur"  />'+fin);
rouge('prenom')
if(test==true)
window.document.getElementById('prenom').focus()
test=false
}

naissance=document.getElementById('naissance').value
if(naissance=='')
{
$.jGrowl(image+'<bean:message key="java.naisutilisateur"  />'+fin);
rouge('naissance')
if(test==true)
window.document.getElementById('naissance').focus()
test=false
}


pass=document.getElementById('pass').value
if(pass=='')
{
$.jGrowl(image+'<bean:message key="java.passutilisateur"  />'+fin);
rouge('pass')
if(test==true)
window.document.getElementById('pass').focus()
test=false
}

pass1=document.getElementById('pass1').value
if(pass1=='')
{
$.jGrowl(image+'<bean:message key="java.pass1utilisateur"  />'+fin);
rouge('pass1')
if(test==true)
window.document.getElementById('pass1').focus()
test=false
}


if(test&&pass1!=pass)
{
$.jGrowl(image+'<bean:message key="java.passdiffutilisateur"  />'+fin);
pass1=document.getElementById('pass1').value=''
pass1=document.getElementById('pass').value=''
rouge('pass')
rouge('pass1')
test=false
}
return test

}




function nonvide1()
{
blond('lib')
blond('prenom')
blond('naissance')
blond('pass1')
blond('pass2')
test=true
image='<table ><tr><td><img border="0" style="cursor: pointer;" src="images/attention.png" ></td><td align="center">'
fin='</td></tr></table></center>'

lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libutilisateur"  />'+fin);
rouge('lib')
window.document.getElementById('lib').focus()
test=false
}


prenom=document.getElementById('prenom').value
if(prenom=='')
{
$.jGrowl(image+'<bean:message key="java.prenomutilisateur"  />'+fin);
rouge('prenom')
if(test==true)
window.document.getElementById('prenom').focus()
test=false
}

naissance=document.getElementById('naissance').value
if(naissance=='')
{
$.jGrowl(image+'<bean:message key="java.naisutilisateur"  />'+fin);
rouge('naissance')
if(test==true)
window.document.getElementById('naissance').focus()
test=false
}


pass=document.getElementById('pass1').value
pass1=document.getElementById('pass2').value


if(test&&pass1!=pass)
{
$.jGrowl(image+'<bean:message key="java.passdiffutilisateur"  />'+fin);
rouge('pass1')
rouge('pass2')
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
{window.location.href='gestion_utilisateur.do?action=supp&id='+document.getElementById('cd').value}

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
if(id=='id_utilisateur_lien')
document.location.href='<%=lien%>'
if(id=='lib_utilisateur_lien')
document.location.href='<%=lien1%>'
if(id=='date_utilisateur_lien')
document.location.href='<%=lien2%>'
if(id=='priv_utilisateur_lien')
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
{rouge(id)
 $.jGrowl(image+'<bean:message key="java.erdate" arg0="'+id+'"  />'+fin);
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


