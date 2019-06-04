<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>


<lay:html locale="true">
<head>
<title><bean:message key="transfert.type"/></title>
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
<b><bean:message key="transfert.type"/></b>
<br/>
<br/>


<logic:notPresent name="x"> 
<html:form action="transfert_bon.do?action=ajout">
	<lay:panel align="center" key="ajout.transfert_carb" styleClass="FORM">
		
			<tr>
				<td align="left" width="200px">  <bean:message key="transfert.code"/></td>
				<td align="left"><html:text name="bon_transfert" property="id_transfert" size="6" maxlength="6" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
					
			</tr>


				

				<tr>

				<td align="left">   <bean:message key="transfert.exer"/></td>
					<td align="left">
					<html:select property="id_exercice" name="bon_transfert" styleId="liste_annee">
					<html:options collection="liste_annee" property="id_saison"  name="liste_annee" labelProperty="libelle_saison"/>
            		</html:select>
				</td>
			</tr>
			
					<tr>

				<td align="left">  <bean:message key="transfert.mag_dep"/></td>
					<td align="left">
					<html:select property="id_magasin_depart" name="bon_transfert" styleId="liste_magasin_depart">
					<html:options collection="liste_magasin" property="id_magasin"  name="liste_magasin" labelProperty="libelle_magasin"/>
            		</html:select>
				</td>
			</tr>
			
					<tr>

				<td align="left"> <bean:message key="transfert.agent_dep"/></td>
					<td align="left">
					<html:select property="id_magasinier_donneur" name="bon_transfert" styleId="liste_agent_donneur">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			<tr>
					<td align="left"><bean:message key="transfert.mag_arv"/>  </td>
					<td align="left">
					<html:select property="id_magasin_arrive" name="bon_transfert" styleId="liste_magasin_recepteur">
					<html:options collection="liste_magasin" property="id_magasin"  name="liste_magasin" labelProperty="libelle_magasin"/>
            		</html:select>
				</td>
			</tr>
			
					<tr>

				<td align="left"><bean:message key="transfert.mag_rec"/>  </td>
					<td align="left">
					<html:select property="id_magasinier_recepteur" name="bon_transfert" styleId="liste_agent_recepteur">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			
			
			<tr>
				<td align="left"> <bean:message key="transfert.date"/> </td>
				<td align="left"><html:text  name="bon_transfert" property="date_transfert" size="10" maxlength="10"  styleId="transfert" onkeypress="return numeric_date(event,'transfert')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "transfert",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			
			</tr>
			



<tr>
<td colspan="4">
<table border="3">


<tr>

<td align="left"> <bean:message key="transfert.type_bon"/>  </td>
<td align="left"><html:select property="id_type_bon" name="bon_transfert" styleId="liste_type_bon" onchange="maj_qte();maj_val()">
					<html:options collection="liste_typebon" property="id_bon"  name="liste_typebon" labelProperty="libelle_bon"/>
            		</html:select></td>
            		
            		
            		<logic:iterate id="i" name="liste_typebon">
            		<bean:define id="temp" name="i" property="id_bon"></bean:define>
            		<bean:define id="temp1" name="i" property="qte_bon"></bean:define>
            		<bean:define id="temp2" name="i" property="valeur_bon"></bean:define>
  					 <%String id_qte=String.valueOf(temp)+"_qte_cache";
  					   String id_val=String.valueOf(temp)+"_valeur_cache";
  					   String qte=String.valueOf(temp1);
  					   String val=String.valueOf(temp2);
  					 %>
            		<html:hidden property="" styleId="<%=id_qte %>" value="<%=qte %>"/>
            		<html:hidden property="" styleId="<%=id_val %>" value="<%=val %>"/>
            		
            		</logic:iterate>

<td align="left"> <bean:message key="transfert.sserie"/>  </td>
<td align="left"><html:text name="bon_transfert" property="serie" size="10" maxlength="10" styleId="serie" ></html:text></td>


</tr>




<tr>

<td align="left"> <bean:message key="transfert.num_debut"/>  </td>
<td align="left"><html:text name="bon_transfert" property="de" size="15" maxlength="15" styleId="num_debut" onkeypress="return numeric(event,'num_debut')" onkeyup="maj_qte();maj_val()" ></html:text></td>



<td align="left"><bean:message key="transfert.num_fin"/></td>
<td align="left"><html:text name="bon_transfert" property="a" size="15" maxlength="15" styleId="num_fin" onkeypress="return numeric(event,'num_fin')" onkeyup="maj_qte();maj_val()"></html:text></td>
				

</tr>


<tr>

<td align="left">  <bean:message key="transfert.qte_t"/></td>
<td align="left"><html:text readonly="true" name="bon_transfert" property="quantite_transfere"  styleId="qte" ></html:text></td>



<td align="left"> <bean:message key="transfert.valeur"/></td>
<td align="left"><html:text readonly="true" name="bon_transfert" property="valeur_transfere"  styleId="valeur" ></html:text></td>
				

</tr>
</table>
</td>
</tr>



			
			<tr>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1"  onclick="return ((nonvide()&&verif_date('transfert')));"> <bean:message key="ajout"/></html:submit></td>
			    <td></td>
			</tr>
	
	</lay:panel>



</html:form>
</logic:notPresent>

<logic:present name="x">
<html:form action="transfert_bon.do?action=edit">
	<lay:panel align="center" key="modif.transfert_carb" styleClass="FORM">
		
			<tr>
				<td align="left">  <bean:message key="transfert.code"/></td>
				<td align="left"><html:text readonly="true" name="bon_transfert" property="id_transfert" size="6" maxlength="6" styleId="id" onkeypress="return numeric(event,'id')"></html:text></td>
					
			</tr>


				

				<tr>

				<td align="left">   <bean:message key="transfert.exer"/></td>
					<td align="left">
					
				<html:text readonly="true" size="15" maxlength="15" name="bon_transfert" property="libelle_exercice"   />	
				<html:hidden name="bon_transfert" property="id_exercice"   />
				</td>
			</tr>
			
					<tr>

				<td align="left">  <bean:message key="transfert.mag_dep"/></td>
				<td  align="left">
				<html:text readonly="true"  size="30" maxlength="30" name="bon_transfert" property="libelle_magasin_depart"   />	
				<html:hidden name="bon_transfert" property="id_magasin_depart"  styleId="mag_dep"  />
				
				</td>
			</tr>
			
					<tr>

				<td align="left"> <bean:message key="transfert.agent_dep"/></td>
					<td align="left">
					<html:select property="id_magasinier_donneur" name="bon_transfert" styleId="liste_agent_donneur">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			<tr>
					<td align="left"><bean:message key="transfert.mag_arv"/>  </td>
					<td align="left">
					<html:select property="id_magasin_arrive" name="bon_transfert" styleId="liste_magasin_recepteur">
					<html:options collection="liste_magasin" property="id_magasin"  name="liste_magasin" labelProperty="libelle_magasin"/>
            		</html:select>
				</td>
			</tr>
			
					<tr>

				<td align="left"><bean:message key="transfert.mag_rec"/>  </td>
					<td align="left">
					<html:select property="id_magasinier_recepteur" name="bon_transfert" styleId="liste_agent_recepteur">
					<html:options collection="liste_agent" property="id_agent"  name="liste_agent" labelProperty="libelle_agent"/>
            		</html:select>
				</td>
			</tr>
			
			
			<tr>
				<td align="left"> <bean:message key="transfert.date"/> </td>
				<td align="left"><html:text  name="bon_transfert" property="date_transfert" size="10" maxlength="10"  styleId="transfert" onkeypress="return numeric_date(event,'transfert')"></html:text>
				<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "transfert",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
				
				
				</td>
			
			
			</tr>
			
			
			
			<tr>
<td colspan="2">
<table border="0">


<tr>

<td align="left">   <bean:message key="transfert.typ"/></td>
<td align="left"><html:select property="id_type_bon" name="bon_transfert" styleId="liste_type_bon" onchange="maj_qte();maj_val()">
					<html:options collection="liste_typebon" property="id_bon"  name="liste_typebon" labelProperty="libelle_bon"/>
            		</html:select></td>
            		
            		
            		<logic:iterate id="i" name="liste_typebon">
            		<bean:define id="temp" name="i" property="id_bon"></bean:define>
            		<bean:define id="temp1" name="i" property="qte_bon"></bean:define>
            		<bean:define id="temp2" name="i" property="valeur_bon"></bean:define>
  					 <%String id_qte=String.valueOf(temp)+"_qte_cache";
  					   String id_val=String.valueOf(temp)+"_valeur_cache";
  					   String qte=String.valueOf(temp1);
  					   String val=String.valueOf(temp2);
  					 %>
            		<html:hidden property="" styleId="<%=id_qte %>" value="<%=qte %>"/>
            		<html:hidden property="" styleId="<%=id_val %>" value="<%=val %>"/>
            		
            		</logic:iterate>

<td align="left">  <bean:message key="transfert.sserie"/></td>
<td align="left"><html:text name="bon_transfert" property="serie" size="10" maxlength="10" styleId="serie" ></html:text></td>


</tr>




<tr>

<td align="left"> <bean:message key="transfert.num_debut"/></td>
<td align="left"><html:text name="bon_transfert" property="de" size="15" maxlength="15" styleId="num_debut" onkeypress="return numeric(event,'num_debut')" onkeyup="maj_qte();maj_val()" ></html:text></td>



<td align="left"><bean:message key="transfert.num_fin"/> </td>
<td align="left"><html:text name="bon_transfert" property="a" size="15" maxlength="15" styleId="num_fin" onkeypress="return numeric(event,'num_fin')" onkeyup="maj_qte();maj_val()"></html:text></td>
				

</tr>


<tr>

<td align="left">   <bean:message key="transfert.qte_t"/></td>
<td align="left"><html:text readonly="true" name="bon_transfert" property="quantite_transfere"  styleId="qte" ></html:text></td>



<td align="left"><bean:message key="transfert.valeur"/> </td>
<td align="left"><html:text readonly="true" name="bon_transfert" property="valeur_transfere"  styleId="valeur" ></html:text></td>
				

</tr>
</table>
</td>
</tr>
			
	
						<tr>
				<td></td>
				
				<td> 
				<table border="0">
				<tr>
				<td>
				<html:submit styleId="b1" indexed="b1" onclick="return ((nonvide1()&&verif_date('transfert')));"   > <bean:message key="modif"/></html:submit>
				</td><td>
				<html:button styleId="b1" onclick="document.location.href='transfert_bon.do?action=all'" property="" > <bean:message key="annuler"/></html:button>
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
<logic:present name="liste_bon_transfert" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_bon_transfert" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_transfert_aff">
<lay:collectionItem  property="id_transfert"  ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="exer_transfert_aff">
<lay:collectionItem    property="libelle_exercice" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="mag_dep_transfert_aff">
<lay:collectionItem    property="libelle_magasin_depart" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="agent_dep_transfert_aff">
<lay:collectionItem    property="libelle_magasinier_donneur" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="mag_arriv_transfert_aff">
<lay:collectionItem    property="libelle_magasin_arrive" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="agent_arriv_transfert_aff">
<lay:collectionItem    property="libelle_magasinier_recepteur" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="date_transfert_aff">
<lay:collectionItem    property="date_transfert" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="etat_transfert_aff">
<lay:collectionItem    property="valide" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_transfert"></bean:define>
<bean:define id="temp1" name="ji" property="id_exercice"></bean:define>
<bean:define id="temp2" name="ji" property="id_magasin_depart"></bean:define>
<img src="config/modif.png" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
</lay:collectionItem>

<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_transfert"></bean:define>
<bean:define id="temp1" name="ji" property="id_exercice"></bean:define>
<bean:define id="temp2" name="ji" property="id_magasin_depart"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>','<%=temp1 %>','<%=temp2 %>')" />
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
String lien="", lien1="", lien2="",lien3="",lien4="",lien5="",lien6="",lien7="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}
try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}
lien=SortUtil.getURLForCollection("id_transfert",request);
lien=lien.replace("amp;","")+nb_page;

lien1=SortUtil.getURLForCollection("libelle_exercice",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_magasin_depart",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_magasinier_donneur",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("libelle_magasin_arrive",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("libelle_magasinier_recepteur",request);
lien5=lien5.replace("amp;","")+nb_page;

lien6=SortUtil.getURLForCollection("date_transfert",request);
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
window.document.getElementById('qte').style.background='#99FF80'
window.document.getElementById('valeur').style.background='#99FF80'


function nonvide()
{
blond('id')
blond('transfert')
blond('liste_annee')
blond('liste_magasin_depart')
blond('liste_magasin_depart')
blond('liste_agent_donneur')
blond('liste_magasin_recepteur')
blond('liste_agent_recepteur')
blond('liste_type_bon')
blond('num_debut')
blond('num_fin')
blond('serie')

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'

id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.transfert_carb"  />'+fin);
window.document.getElementById('id').focus()
rouge('id')
}

x=document.getElementById('transfert').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.date_transfert_carburant"  />'+fin);
rouge('transfert')
if(test==true)
window.document.getElementById('transfert').focus()
test=false
}


vehicule=document.getElementById('liste_annee').options.length
if(vehicule==0)
{test=false
rouge('liste_annee')
$.jGrowl(image+'<bean:message key="java.liste_annee_transfert_carburant"/>'+fin);
}


vehicule=document.getElementById('liste_magasin_depart').options.length
if(vehicule==0)
{rouge('liste_magasin_depart')
test=false
$.jGrowl(image+'<bean:message key="java.liste_magasin_transfert_carburant"/>'+fin);
}

vehicule=document.getElementById('liste_agent_donneur').options.length
if(vehicule==0)
{rouge('liste_agent_donneur')
test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_transfert_carburant"/>'+fin);
}

vehicule=document.getElementById('liste_magasin_recepteur').options.length
if(vehicule==0)
{rouge('liste_magasin_recepteur')
test=false
$.jGrowl(image+'<bean:message key="java.liste_magasin_transfert_carburant1"/>'+fin);
}

vehicule=document.getElementById('liste_agent_recepteur').options.length
if(vehicule==0)
{
rouge('liste_agent_recepteur')
test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_transfert_carburant1"/>'+fin);
}




if(test){
mag1=document.getElementById('liste_magasin_depart').selectedIndex
mag2=document.getElementById('liste_magasin_recepteur').selectedIndex
if(mag1==mag2)
{$.jGrowl(image+'<bean:message key="java.mag_egaux_transfert_carburant"/>'+fin);
rouge('liste_magasin_depart')
rouge('liste_magasin_recepteur')
test=false
}
}

if(test){
mag1=document.getElementById('liste_agent_donneur').selectedIndex
mag2=document.getElementById('liste_agent_recepteur').selectedIndex
if(mag1==mag2)
{
$.jGrowl(image+'<bean:message key="java.agent_egaux_transfert_carburant"/>'+fin);
rouge('liste_agent_donneur')
rouge('liste_agent_recepteur')
test=false;
}
}


type_bon=document.getElementById('liste_type_bon').options.length
if(type_bon==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_transfert_liste_type_bon"/>'+fin);
rouge('liste_type_bon')
}

num_debut=document.getElementById('num_debut').value
if(num_debut=='')
{
$.jGrowl(image+'<bean:message key="java.detransfert_carburant"  />'+fin);
rouge('num_debut')
if(test==true)
window.document.getElementById('num_debut').focus()
test=false
}


num_fin=document.getElementById('num_fin').value
if(num_fin=='')
{
$.jGrowl(image+'<bean:message key="java.a_transfert_carburant"  />'+fin);
rouge('num_fin')
if(test==true)
window.document.getElementById('num_fin').focus()
test=false
}

if(parseInt(num_debut)>parseInt(num_fin))
{
$.jGrowl(image+'<bean:message key="java.logique_carburant"  />'+fin);
rouge('num_debut')
rouge('num_fin')
test=false
}

x=document.getElementById('serie').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.serie_transfert_carburant"  />'+fin);
rouge('serie')
if(test==true)
window.document.getElementById('serie').focus()
test=false
}



return test

}




function nonvide1()
{

blond('transfert')
blond('liste_agent_donneur')
blond('liste_magasin_recepteur')
blond('liste_agent_recepteur')
blond('liste_magasin_recepteur')
blond('mag_dep')
blond('liste_type_bon')
blond('num_debut')
blond('num_fin')
blond('serie')

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'


x=document.getElementById('transfert').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.date_transfert_carburant"  />'+fin);
if(test==true)
window.document.getElementById('transfert').focus()
test=false
rouge('transfert')
}


vehicule=document.getElementById('liste_agent_donneur').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_transfert_carburant"/>'+fin);
rouge('liste_agent_donneur')
}

vehicule=document.getElementById('liste_magasin_recepteur').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_magasin_transfert_carburant1"/>'+fin);
rouge('liste_magasin_recepteur')
}

vehicule=document.getElementById('liste_agent_recepteur').options.length
if(vehicule==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_transfert_carburant1"/>'+fin);
rouge('liste_agent_recepteur')
}




if(test){
mag1=document.getElementById('mag_dep').value
mag2=document.getElementById('liste_magasin_recepteur').options[document.getElementById('liste_magasin_recepteur').selectedIndex].value
if(mag1==mag2)
{$.jGrowl(image+'<bean:message key="java.mag_egaux_transfert_carburant"/>'+fin);
rouge('mag_dep')
rouge('liste_magasin_recepteur')
test=false
}
}

if(test){
mag1=document.getElementById('liste_agent_donneur').selectedIndex
mag2=document.getElementById('liste_agent_recepteur').selectedIndex
if(mag1==mag2)
{
rouge('liste_agent_donneur')
rouge('liste_agent_recepteur')
$.jGrowl(image+'<bean:message key="java.agent_egaux_transfert_carburant"/>'+fin);
test=false;
}
}


type_bon=document.getElementById('liste_type_bon').options.length
if(type_bon==0)
{test=false
$.jGrowl(image+'<bean:message key="java.liste_agent_transfert_liste_type_bon"/>'+fin);
rouge('liste_type_bon')
}


num_debut=document.getElementById('num_debut').value
if(num_debut=='')
{
$.jGrowl(image+'<bean:message key="java.detransfert_carburant"  />'+fin);
rouge('num_debut')
if(test==true)
window.document.getElementById('num_debut').focus()
test=false
}


num_fin=document.getElementById('num_fin').value
if(num_fin=='')
{
$.jGrowl(image+'<bean:message key="java.a_transfert_carburant"  />'+fin);
rouge('num_fin')
if(test==true)
window.document.getElementById('num_fin').focus()
test=false
}

if(parseInt(num_debut)>parseInt(num_fin))
{
$.jGrowl(image+'<bean:message key="java.logique_carburant"  />'+fin);
rouge('num_fin')
rouge('num_debut')
test=false
}


x=document.getElementById('serie').value
if(x=='')
{
$.jGrowl(image+'<bean:message key="java.serie_transfert_carburant"  />'+fin);
rouge('serie')
if(test==true)
window.document.getElementById('serie').focus()
test=false
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
{window.location.href='transfert_bon.do?action=modif&id='+cd1+'&annee='+cd2+'&mag='+cd3
}

function supp2()
{window.location.href='transfert_bon.do?action=supp&id='+document.getElementById('cd1').value+'&annee='+document.getElementById('cd2').value+'&mag='+document.getElementById('cd3').value}

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


function envoie(id)
{
if(id=='id_transfert_lien')
document.location.href='<%=lien%>'
if(id=='ex_transfert_lien')
document.location.href='<%=lien1%>'
if(id=='mag_d_transfert_lien')
document.location.href='<%=lien2%>'
if(id=='agent_d_transfert_lien')
document.location.href='<%=lien3%>'
if(id=='mag_a_transfert_lien')
document.location.href='<%=lien4%>'
if(id=='agent_a_transfert_lien')
document.location.href='<%=lien5%>'
if(id=='date_transfert_lien')
document.location.href='<%=lien6%>'
if(id=='etat_transfert_lien')
document.location.href='<%=lien7%>'

}
function block()
{return false;}



function maj_qte()
{
try{
debut=document.getElementById('num_debut').value
fin=document.getElementById('num_fin').value
ok=vehicule=document.getElementById('liste_type_bon').options.length!=0
ok=ok&&debut!=''&&fin!=''
ok=ok&&parseInt(debut)<=parseInt(fin)

if(ok)
{
id_qte=document.getElementById('liste_type_bon').options[document.getElementById('liste_type_bon').selectedIndex].value
id_qte=id_qte+'_qte_cache'
i=(fin-debut+1)*document.getElementById(id_qte).value
if(i<0)
i=''
document.getElementById('qte').value=i
}
else{
document.getElementById('qte').value=''
}
}catch(e){}

}

function maj_val()
{try{
debut=document.getElementById('num_debut').value
fin=document.getElementById('num_fin').value
ok=vehicule=document.getElementById('liste_type_bon').options.length!=0
ok=ok&&debut!=''&&fin!=''
ok=ok&&parseInt(debut)<=parseInt(fin)

if(ok)
{
id_qte=document.getElementById('liste_type_bon').options[document.getElementById('liste_type_bon').selectedIndex].value
id_qte=id_qte+'_valeur_cache'
i=(fin-debut+1)*document.getElementById(id_qte).value
if(i<0)
i=''
document.getElementById('valeur').value=i
}
else{
document.getElementById('valeur').value=''
}
}catch(e){}
}
</script>

</center>
</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>

