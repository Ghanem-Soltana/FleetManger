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
<title><bean:message key="laisser_passer.type"/></title>
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
<b><bean:message key="laisser_passer.type"/></b>
<br/>
<br/>

<%String titre="ajout.laisser_passer"; %>
<logic:present name="x">
<%titre="edit.laisser_passer"; %>
</logic:present>

<html:hidden name="laisser_passer" property="id_laisser_passer" styleId="id1" ></html:hidden>
<html:hidden name="laisser_passer" property="marchandise_transporte" styleId="length" ></html:hidden>

<html:form action="laisser_passer.do?action=ajout" styleId="form">
	<lay:panel align="center" key="<%=titre %>" styleClass="FORM">

		<logic:present name="x">

                    <tr>
                    <td align="left"><html:button property="" styleId="b1" indexed="b3" onclick="if(document.getElementById('id1').value!='')document.location.href='laisser_passer.do?action=pred&id='+document.getElementById('id1').value ;else vide() " ><bean:message key="pred"/>  </html:button></td>
                   
					
					 
                    <td align="center" colspan="2" ><bean:define id="pos" name="pos" /><bean:define id="total" name="total" />
              
                 <b>  <bean:message key="articles_pos"/> <%=pos %>/<%=total %></b>
                    </td>

                    <td align="right"><html:button property="" styleId="b1" indexed="b4" onclick="if(document.getElementById('id1').value!='')document.location.href='laisser_passer.do?action=sui&id='+document.getElementById('id1').value ;else vide()  " ><bean:message key="sui"/> </html:button></td>
                    
                    </tr>
				</logic:present>
	
			<tr>
			  
				<td align="left"><bean:message key="laisser_passer.id"/>  </td>
				
				
				
				 <logic:notPresent name="x">
				<td align="left"><html:text name="laisser_passer" property="id_laisser_passer" size="6" maxlength="6" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
				</logic:notPresent>
				
				 <logic:present name="x">
				<td align="left"><html:text readonly="true" name="laisser_passer" property="id_laisser_passer" size="6" maxlength="6" styleId="id" ></html:text></td>
				</logic:present>
			
			
			
					<logic:notPresent name="x">
						
						
						<td align="left"> <bean:message key="laisser_passer.ex"/></td>
				<td align="left">
	                <html:select property="id_annee" name="laisser_passer" styleId="select_annee">
					<html:options collection="liste_annee"  name="liste_annee"  property="id_saison" labelProperty="libelle_saison"/>
            		</html:select>
							</td>
						</logic:notPresent>
						
						
					<logic:present name="x">
						
						
						<td align="left"><bean:message key="laisser_passer.ex"/></td>
				<td align="left">
				<html:text  property="libelle_annee" name="laisser_passer"  styleId="anneee" readonly="true"/>
            
							</td>
						</logic:present>
			
		    	

           
		
			</tr>
			
				
			


			<tr>
				<td align="left"> <bean:message key="laisser_passer.date"/> </td>
				<td align="left">
				
			
			<logic:notPresent name="x">
			<% java.util.Date l_date = new java.util.Date(System.currentTimeMillis());
   String l_stFormatDate = new String("dd/MM/yyyy");
   DateFormat l_formatDate = new SimpleDateFormat(l_stFormatDate, java.util.Locale.FRENCH);
   String date = l_formatDate.format(l_date);
 
%><html:text styleId="date" property="date_laisser_passer"  name="laisser_passer" size="10" maxlength="10" value="<%=date%>" onkeypress="return block()"></html:text>
				</logic:notPresent  >
				
				<logic:present name="x">
				<html:text styleId="date" property="date_laisser_passer"  name="laisser_passer" size="10" maxlength="10" onkeypress="return block()"></html:text>
				</logic:present  >
				
				
				
				</td>
			
				<td align="left"><bean:message key="laisser_passer.station"/></td>
				<td align="left">
				<html:text styleId="station" property="libelle_station"  name="laisser_passer" size="30" maxlength="30" onkeypress="return block()"></html:text>
			<html:hidden styleId="id_station" property="id_station" name="laisser_passer" />
				</td>
				
			</tr>
			
			
		

	

			<tr>
				<td align="left"><bean:message key="laisser_passer.vehicule"/></td>
				<td align="left">
				     <html:select property="id_vehicule" name="laisser_passer" styleId="select_vehicule" onchange="metre_a_jour_station()">
					<html:options collection="liste_vehicule"  name="liste_vehicule"  property="id_vehicule" labelProperty="libelle_vehicule"/>
            		</html:select>
            		
            		
            		<logic:iterate id="i" name="liste_vehicule" >
            		<bean:define id="temp" name="i" property="id_vehicule" ></bean:define>
            		<%String temp1=String.valueOf(temp);%>
            		<html:hidden name="i" property="libelle_station" styleId="<%=temp1 %>"/>
            		</logic:iterate>
				
				</td>
				
				
					<td align="left"><bean:message key="laisser_passer.obj"/></td>
				<td align="left">
				<html:text styleId="objectif" property="objectif"  name="laisser_passer" size="10" maxlength="10" ></html:text>
				</td>
			
				
				
			</tr>


			<tr>
				<td align="left"><bean:message key="laisser_passer.service"/> </td>
				<td align="left">
				  <html:select property="id_service" name="laisser_passer" styleId="select_service">
					<html:options collection="liste_service"  name="liste_sevice"  property="id_service" labelProperty="libelle_service"/>
            		</html:select>
				
				</td>
			
			<td align="left"><bean:message key="laisser_passer.agent"/></td>
				<td align="left">
				   <html:select property="id_agent" name="laisser_passer" styleId="select_agent">
					<html:options collection="liste_agent"  name="liste_agent"  property="id_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
				
			</tr>
			
			
			<tr>
			<td align="left" ><bean:message key="laisser_passer.dest"/></td>
			<td align="left" colspan="2">
			
			<html:text name="laisser_passer" property="destination"  styleId="ddest" size="60" maxlength="60"></html:text>
			
			</td>
		
			<td></td>
			</tr>

	<tr>
			<td align="left" ><bean:message key="laisser_passer.march"/></td>
			<td align="left" colspan="2">
			
			<html:textarea name="laisser_passer" property="marchandise_transporte"  styleId="marchandise" onkeyup="fupdCompteur1(event) " onkeydown="comp()" cols="40" rows="2"></html:textarea>
			
			</td><td></td>
		</tr>
		
		<tr>
		<td></td>
			<td align="left"><input type="text" id="cpt"  maxlength="5" style="border-width:0px;height:20px;width:40px;background: transparent;" value="200" onkeypress="return block()"></input><bean:message key="caractere_restant"/></td>
			<td></td>
			<td></td>
			

      </tr>
			<tr></tr>
			
<logic:notPresent name="x"> 
			<tr>
		        <td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return (nonvide())"  > <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			     <td></td>
			</tr>
	</logic:notPresent>
	
	
			<logic:present name="x"> 
				<%String etat="";
			try{
			Bean.LaisserPasserForm laisser=(Bean.LaisserPasserForm)request.getSession().getAttribute("laisser_passer");
			etat=laisser.getValide();
			if(etat.equals("en attente"))
				etat="images/attente.gif";
			
			else
			{
			if(etat.equals("validé"))
				{etat="images/valide.png";}	
			else etat="images/refuse.png";
			}
			}catch(Exception e){}
		
			%>
			
			<tr>
			<td align="left"><bean:message key="etat"/></td>
			<td align="left"><img border="0" src="<%=etat %>"/></td>
			</tr>
			
			<tr>
				<td align="center"><html:button styleId="b1" property="" indexed="b2" onclick="if(document.getElementById('id').value!=''){window.open('laisser_passer.do?action=print&id_laisser_passer='+document.getElementById('id').value+'&id_exercice='+document.getElementById('anneee').value) ;}else vide(); " >   <bean:message key="imprime_centre"/> </html:button></td>	
				<td align="center"><html:button styleId="b1" property="" indexed="b2" onclick="if(document.getElementById('id').value!=''){supp(document.getElementById('id').value,document.getElementById('anneee').value) ;}else vide(); " >   <bean:message key="mode_ajout_supp"/> </html:button></td>
				<td align="center"><html:button styleId="b1" property="" indexed="b1" onclick="document.getElementById('form').action='laisser_passer.do?action=edit&id='+document.getElementById('id').value+'annee='+document.getElementById('anneee').value+'&i='+document.URL.split('i=')[1] ;if(nonvide())document.getElementById('form').submit();" >  <bean:message key="mode_ajout_modif"/></html:button> </td>
				<td align="center"><html:button styleId="b1" property="" onclick="document.location.href='laisser_passer.do?action=all'"  > <bean:message key="mode_ajout_articles"/></html:button> </td>
			</tr>
			</logic:present>
	
	
	</lay:panel>
</html:form>

<script language="javascript" type="text/javascript"> 
document.getElementById('cpt').value=document.getElementById('cpt').value-document.getElementById('length').value.length
document.getElementById('cpt').style.color='white'
document.getElementById('cpt').style.fontWeight = 'bold'
 window.document.getElementById('date').style.background='#99FF80'
 window.document.getElementById('station').style.background='#99FF80'
length_select_vehicule=document.getElementById('select_vehicule').options.length
if(length_select_vehicule!=0)
{
id_hidden=document.getElementById('select_vehicule').options[document.getElementById('select_vehicule').selectedIndex].value
mot=window.document.getElementById(id_hidden).value
window.document.getElementById('station').value=mot
}
</script>


<logic:present name="x">
<script language="javascript" type="text/javascript"> 
 window.document.getElementById('id').style.color='gray'
 window.document.getElementById('date').style.background='#99FF80'
 
 
</script>
</logic:present>


<br/>
<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_laisser_passer" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_laisser_passer" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_laisser_passer_aff">
<lay:collectionItem  property="id_laisser_passer"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="ex_laisser_passer_aff">
<lay:collectionItem    property="libelle_annee" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="date_laisser_passer_aff">
<lay:collectionItem    property="date_laisser_passer" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="vehicule_laisser_passer_aff">
<lay:collectionItem    property="libelle_vehicule" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="objectif_laisser_passer_aff">
<lay:collectionItem    property="objectif" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="service_laisser_passer_aff">
<lay:collectionItem    property="libelle_service" ></lay:collectionItem>
</lay:collectionTitle>



<lay:collectionTitle title="agent_laisser_passer_aff">
<lay:collectionItem    property="libelle_agent" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="valide_laisser_passer_aff">
<lay:collectionItem    property="valide" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_laisser_passer"></bean:define>
<bean:define id="temp1" name="ji" property="id_annee"></bean:define>
<img src="images/add.png" height="20px" width="20px" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>')" />
</lay:collectionItem>

<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_laisser_passer"></bean:define>
<bean:define id="temp1" name="ji" property="id_annee"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>')" />
</lay:collectionItem>

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
 



<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_laisser_passer"/></td>
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

lien=SortUtil.getURLForCollection("id_laisser_passer",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_annee",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("date_laisser_passer",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("libelle_vehicule",request);
lien3=lien3.replace("amp;","")+nb_page;
lien4=SortUtil.getURLForCollection("objectif",request);
lien4=lien4.replace("amp;","")+nb_page;
lien5=SortUtil.getURLForCollection("libelle_service",request);
lien5=lien5.replace("amp;","")+nb_page;
lien6=SortUtil.getURLForCollection("libelle_agent",request);
lien6=lien6.replace("amp;","")+nb_page;
lien7=SortUtil.getURLForCollection("valide",request);
lien7=lien7.replace("amp;","")+nb_page;





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
blond('select_vehicule')
blond('select_service')
blond('select_agent')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
$.jGrowl(image+'<bean:message key="laisser_passer.java.id"/>'+fin);
rouge('id')
window.document.getElementById('id').focus()
}


vehicule=document.getElementById('select_vehicule').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="laisser_passer.java.vehi"/>'+fin);
rouge('select_vehicule')
}

vehicule=document.getElementById('select_service').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="laisser_passer.java.serv"/>'+fin);
rouge('select_service')
}

vehicule=document.getElementById('select_agent').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="laisser_passer.java.agent"/>'+fin);
rouge('select_agent')
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
{window.location.href='laisser_passer.do?action=supp&id='+document.getElementById('cd').value+'&annee='+document.getElementById('cd1').value}

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
blond(id)
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
{$.jGrowl(image+'<bean:message key="snen"   />'+fin2);
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


function vide()
{image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
$.jGrowl(image+'<bean:message key="laisser_passer.java.vide"/>'+fin);
}


function block()
{return false;}


function envoie(id)
{
if(id=='id_lpass_lien')
document.location.href='<%=lien%>'
if(id=='ex_lpass_lien')
document.location.href='<%=lien1%>'
if(id=='date_lpass_lien')
document.location.href='<%=lien2%>'
if(id=='vehi_lpass_lien')
document.location.href='<%=lien3%>'
if(id=='obj_lpass_lien')
document.location.href='<%=lien4%>'
if(id=='serv_lpass_lien')
document.location.href='<%=lien5%>'
if(id=='agent_lpass_lien')
document.location.href='<%=lien6%>'

if(id=='valide_lpass_lien')
document.location.href='<%=lien7%>'

}


function metre_a_jour_station()
{

length_select_vehicule=document.getElementById('select_vehicule').options.length
if(length_select_vehicule!=0)
{
id_hidden=document.getElementById('select_vehicule').options[document.getElementById('select_vehicule').selectedIndex].value
mot=window.document.getElementById(id_hidden).value
window.document.getElementById('station').value=mot
}

}


function modifier(cd,cd1)
{window.location.href='laisser_passer.do?action=modif&id='+cd+'&annee='+cd1}






var maximum = 200;

 function comp()
 {
var textbox = document.getElementById( 'cpt');
var textbox2 = document.getElementById( 'marchandise');
var contenu_txt2 = textbox2.value;


 var longueur= maximum -contenu_txt2.length;
 
 if(longueur<=0)
{longueur=0;
document.getElementById('marchandise').value=document.getElementById('marchandise').value.substring(0,199); 
}


	document.getElementById( 'cpt').value=longueur;
	if(	document.getElementById('cpt').value=='201')
	document.getElementById( 'cpt').value='200';


 }
 
 
function fupdCompteur1(e) 
{

if(document.getElementById( 'marchandise').length!=1)
	{var textbox = document.getElementById( 'cpt');
	var textbox2 = document.getElementById('marchandise');
    var contenu_txt2 = textbox2.value;
	if(e.keyCode!=8)
	var longueur = maximum - (1+parseInt(contenu_txt2.length));
   else longueur =  maximum - (parseInt(contenu_txt2.length)-1);

if(longueur<=0)
{longueur=0;

document.getElementById('marchandise').value=document.getElementById('marchandise').value.substring(0,199); 
}

	document.getElementById(  'cpt').value=longueur;
	if(	document.getElementById( 'cpt').value=='201')
	document.getElementById(  'cpt').value='200';
}
}

</script>


</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


