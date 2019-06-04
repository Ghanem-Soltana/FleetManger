<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>


<lay:html locale="true">
<head>
<title><bean:message key="articless.type" /></title>
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
<b><bean:message key="articless.type" /></b>
<br/>
<br/>

<logic:notPresent name="liste_famille_principale_vide">
<logic:notPresent name="liste_nature_article_vide">

<%String titre="ajout.articles"; %>
<logic:present name="x1">
<%titre="edit.articles"; %>
</logic:present>

<html:form action="gestion_articles.do?action=ajout" styleId="form">
	<lay:panel align="center" key="<%=titre %>" styleClass="FORM" >
	
				<logic:present name="x1">
                    <tr>
                    <html:hidden property="id_article" name="articles" styleId="id1" ></html:hidden>
                    <td align="left"><html:button  styleId="b1" property="" indexed="b3" onclick="if(document.getElementById('id1').value!='')document.location.href='gestion_articles.do?action=pred&id='+document.getElementById('id1').value ;else vide() " ><bean:message key="pred"/>  </html:button></td>
                    <td align="left"></td>

                    <td align="left"><bean:define id="pos" name="pos" /><bean:define id="total" name="total" />
                 <b>  <bean:message key="articles_pos"/> <%=pos %>/<%=total %></b>
                    </td>
                    <td align="left"></td>
                    <td align="left"></td>
                    <td align="right"><html:button property=""  styleId="b1" indexed="b4" onclick="if(document.getElementById('id1').value!='')document.location.href='gestion_articles.do?action=sui&id='+document.getElementById('id1').value ;else vide()  " ><bean:message key="sui"/> </html:button></td>
                    
                    </tr>
				</logic:present>

		<tr>

				<td align="left"> <bean:message key="lib_fam_princ1" /> </td>
					<td align="left">
					<html:select property="id_famille_principale" name="articles" styleId="select" onchange="agaga()">
					<html:options collection="liste_famille_principale" property="id_famille_princi"  name="liste_famille_principale" labelProperty="libelle_famille_princi"/>
            		</html:select>
				</td>
			
			
			
			
			

				<td align="left" > <bean:message key="lib_fam_sec"/> </td>
					<td align="left" width="190px">
					<html:select property="id_famille_secondaire" name="articles" styleId="selectfam2">
					<html:options collection="liste_famille_secondaire" property="id_famille_sec"  name="liste_famille_secondaire" labelProperty="libelle_famille_sec"/>
            		</html:select>
				</td>
				<td></td>
				<td></td>
				
		</tr>
			
			
				<tr>

		    	<td align="left"><bean:message key="articles_nature_article"/> </td>
					<td align="left">
					<html:select property="id_categorie_article" name="articles">
					<html:options collection="liste_nature_article" property="id_article"  name="liste_nature_article" labelProperty="libelle_article"/>
            		</html:select>
				</td>
				
				
				
				<td align="left"> <bean:message key="articles_type_article"/></td>
				<td align="left">
					<html:select property="id_type_article" name="articles">
					<html:options collection="liste_type_article" property="id_natarticle"  name="liste_type_article" labelProperty="libelle_natarticle"/>
            		</html:select>
				</td>
				
				
				
				<td align="left"><bean:message key="articles_unite"/></td>
				<td align="left">
					<html:select property="id_unite" name="articles">
					<html:options collection="liste_unite" property="id_unite"  name="liste_unite" labelProperty="libelle_unite"/>
            		</html:select>
				</td>

			</tr>
			
			<tr>
				<td align="left"> <bean:message key="id_articless"/>  </td>
				
			<logic:notPresent name="x1">
				<td align="left"><html:text name="articles" property="id_article" size="15" maxlength="15" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
			</logic:notPresent>
		
				<logic:present name="x1">
				<td align="left"><html:text name="articles" readonly="true" property="id_article" size="15" maxlength="15" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
			</logic:present>
		
		
		
		
		
				<td align="left"> <bean:message key="lib_articles"/>  </td>
				<td align="left" colspan="3"><html:text  name="articles" property="libelle_article" size="50" maxlength="50"  styleId="lib"></html:text></td>
			<td></td>
			<td></td>
			</tr>
			
			<tr>
			<td align="left"><bean:message key="desc_articles"/> </td>
			<td align="left" colspan="3"><html:text name="articles" property="descreption" size="50" maxlength="50" styleId="desc" onkeypress="return alphanum(event)"></html:text></td>
		
			

			<td align="left"><bean:message key="ref_articles"/> </td>
			<td align="left"><html:text name="articles" property="symbole_reference" size="20" maxlength="20" styleId="referance" onkeypress="return alphanum(event)"></html:text></td>

			</tr>
			
			
			<tr>
			<td align="left"><bean:message key="prix_ref_articles"/></td>
			<td align="left"><html:text name="articles" property="prix_referenciel" size="15" maxlength="15" styleId="prix_referenciel" onkeypress="return numeric(event,'prix_referenciel')"></html:text></td>
			<td align="left"><bean:message key="seuil_max_articles"/></td>
			<td align="left"><html:text name="articles" property="limite_min" size="15" maxlength="15" styleId="limite_min" onkeypress="return numeric(event,'limite_min')"></html:text></td>
			<td align="left"><bean:message key="stock_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="stocke"  styleId="stock"></html:checkbox></td>
			</tr>
			
			
			
			<tr>
			<td align="left"><bean:message key="prix_ht_articles"/></td>
			<td align="left"><html:text name="articles" property="prix_avant_tax" size="15" maxlength="15" styleId="prix_avant_tax" onkeypress="return numeric(event,'prix_avant_tax')"></html:text></td>
			<td align="left"><bean:message key="qte_min_articles"/></td>
			<td align="left"><html:text name="articles" property="qte_min" size="15" maxlength="15" styleId="qte_min" onkeypress="return numeric(event,'qte_min')"></html:text></td>
			<td align="left"><bean:message key="m_premiere_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="premier"  styleId="premier"></html:checkbox></td>
			</tr>
			
			
			
			<tr>
			<td align="left"><bean:message key="prix_achat_articles"/></td>
			<td align="left"><html:text name="articles" property="prix_achat" size="15" maxlength="15" styleId="prix_achat" onkeypress="return numeric(event,'prix_achat')"></html:text></td>
			<td align="left"><bean:message key="frais_app_articles"/></td>
			<td align="left"><html:text name="articles" property="depence_apprivois" size="15" maxlength="15" styleId="depence_apprivois" onkeypress="return numeric(event,'depence_apprivois')"></html:text></td>
			<td align="left"><bean:message key="boite_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="boite"  styleId="boite"></html:checkbox></td>
			</tr>
			
				<tr>
			<td align="left"><bean:message key="pmp_articles"/></td>
			<td align="left"><html:text name="articles" property="moyenne_prix" size="15" maxlength="15" styleId="moyenne_prix" onkeypress="return numeric(event,'moyenne_prix')"></html:text></td>
			<td align="left"><bean:message key="qte_economique_articles"/></td>
			<td align="left"><html:text name="articles" property="qte_economique" size="15" maxlength="15" styleId="qte_economique" onkeypress="return numeric(event,'qte_economique')"></html:text></td>
			<td align="left"><bean:message key="compose_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="compose"  styleId="compose"></html:checkbox></td>
			</tr>
			
			
			
				
				<tr>
			<td align="left"><bean:message key="seuil_alerte_articles"/></td>
			<td align="left"><html:text name="articles" property="prix_limite_min" size="15" maxlength="15" styleId="prix_limite_min" onkeypress="return numeric(event,'prix_limite_min')"></html:text></td>
			<td align="left"><bean:message key="qte_fab_articles"/></td>
			<td align="left"><html:text name="articles" property="qte_fabrique" size="15" maxlength="15" styleId="qte_fabrique" onkeypress="return numeric(event,'qte_fabrique')"></html:text></td>
			<td align="left"><bean:message key="combustible_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="combustible"  styleId="combustible"></html:checkbox></td>
			</tr>
			
					<tr>
			<td align="left"><bean:message key="seuil_reapp_articles"/></td>
			<td align="left"><html:text name="articles" property="limite_redistribution" size="15" maxlength="15" styleId="limite_redistribution" onkeypress="return numeric(event,'limite_redistribution')"></html:text></td>
			<td align="left"><bean:message key="poids_net_articles"/></td>
			<td align="left"><html:text name="articles" property="poids_net" size="15" maxlength="15" styleId="poids_net" onkeypress="return numeric(event,'poids_net')"></html:text></td>
			<td align="left"><bean:message key="huile_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="huile"  styleId="huile"></html:checkbox></td>
			</tr>
			
				<tr>
			<td align="left"><bean:message key="code_bar_articles"/></td>
			<td align="left"><html:text name="articles" property="symbole_poto" size="24" maxlength="24" styleId="symbole_poto" onkeypress="return numeric(event,'symbole_poto')"></html:text></td>
			<td align="left"><bean:message key="volume_articles"/></td>
			<td align="left"><html:text name="articles" property="volume" size="15" maxlength="15" styleId="volume" onkeypress="return numeric(event,'v')"></html:text></td>
			<td align="left"><bean:message key="rechange_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="rechange"  styleId="rechange"></html:checkbox></td>
			</tr>
			
					<tr>
			<td align="left"><bean:message key="norme_mois_articles"/></td>
			<td align="left"><html:text name="articles" property="desc_mois" size="4" maxlength="4" styleId="desc_mois" onkeypress="return numeric(event,'desc_mois')"></html:text></td>
			<td align="left"><bean:message key="surface_articles"/></td>
			<td align="left"><html:text name="articles" property="superfici" size="15" maxlength="15" styleId="superfici" onkeypress="return numeric(event,'superfici')"></html:text></td>
			<td align="left"><bean:message key="pneu_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="pneu"  styleId="pneu"></html:checkbox></td>
			</tr>
			
			
					<tr>
			<td align="left"><bean:message key="norme_km_articles"/></td>
			<td align="left"><html:text name="articles" property="desc_qte" size="10" maxlength="10" styleId="desc_qte" onkeypress="return numeric(event,'desc_qte')"></html:text></td>
			<td align="left"><bean:message key="longeur_articles"/></td>
			<td align="left"><html:text name="articles" property="longeure" size="15" maxlength="15" styleId="longeure" onkeypress="return numeric(event,'longeure')"></html:text></td>
			<td align="left"><bean:message key="roue_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="pneu1"  styleId="pneu1"></html:checkbox></td>
			</tr>
			
						<tr>
			<td align="left"><bean:message key="qte_stock_articles"/></td>
			<td align="left"><html:text name="articles" property="qte_stocke" size="15" maxlength="15" styleId="qte_stocke" onkeypress="return numeric(event,'qte_stocke')"></html:text></td>
			<td align="left"><bean:message key="qte_embale_articles"/></td>
			<td align="left"><html:text name="articles" property="qte_embalage" size="15" maxlength="15" styleId="qte_embalage" onkeypress="return numeric(event,'qte_embalage')"></html:text></td>
			<td align="left"><bean:message key="autre_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="divers"  styleId="divers"></html:checkbox></td>
			</tr>
			
				
						<tr>
			<td align="left"><bean:message key="perm_sor_vehi_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="sortie_pour_vehicule"  styleId="sortie_pour_vehicule"></html:checkbox></td>
			<td align="left"><bean:message key="perm_sor_service_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="sortie_pour_service"  styleId="sortie_pour_service"></html:checkbox></td>
			<td align="left"><bean:message key="perissable_articles"/></td>
			<td align="left"><html:checkbox  name="articles" property="periode_validite"  styleId="periode_validite"></html:checkbox></td>
			</tr>
			
			<logic:notPresent name="x1"> 
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td> <html:submit indexed="b1" styleId="b1" onclick="return nonvide()"  > <bean:message key="ajout"/></html:submit></td>
				<td> <html:reset  styleId="b1"  > <bean:message key="vider_champs"/></html:reset> </td>
			</tr>
			</logic:notPresent>
			
				<logic:present name="x1"> 
			<tr>
				<td></td>
				<td></td>
				<td><html:button styleId="b1" property="" indexed="b2" onclick="if(document.getElementById('id').value!=''){supp(document.getElementById('id').value) ;}else vide(); " >   <bean:message key="mode_ajout_supp"/> </html:button></td>
				<td> <html:button styleId="b1" property=""  onclick="document.getElementById('form').action='gestion_articles.do?action=edit&id='+document.getElementById('id').value+'&i='+document.URL.split('i=')[1] ;if(nonvide())document.getElementById('form').submit();" >  <bean:message key="mode_ajout_modif"/></html:button></td>
				<td><html:reset   styleId="b1" > <bean:message  key="vider_champs"/></html:reset> </td>
				<td> <html:button styleId="b1" indexed="b1" property="" onclick="document.location.href='gestion_articles.do?action=all'"  > <bean:message key="mode_ajout_articles"/></html:button> </td>
			</tr>
			</logic:present>
	</lay:panel>



</html:form>





<logic:notPresent name="x1">
<script language="javascript" type="text/javascript"> window.document.getElementById('id').focus()</script>
</logic:notPresent>

<logic:present name="x1">
<script language="javascript" type="text/javascript"> window.document.getElementById('lib').focus();
window.document.getElementById('lib').select();
 window.document.getElementById('id').style.color='gray'
</script>
</logic:present>


</logic:notPresent>
</logic:notPresent>
<logic:present name="liste_nature_article_vide"><b><font color="red"><bean:message key="liste_nature_article_vide"/></font></b><br/><br/></logic:present>
<%session.removeAttribute("liste_nature_article_vide"); %>
<logic:present name="liste_famille_principale_vide"><b><font color="red"><bean:message key="liste_famille_principale_vide"/></font></b><br/><br/></logic:present>
<%session.removeAttribute("liste_famille_principale_vide"); %>



<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_articles" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_articles" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_article_aff">
<lay:collectionItem  property="id_article"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_article_aff">
<lay:collectionItem    property="libelle_article" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_fam1_article_aff">
<lay:collectionItem    property="libelle_famille_principale" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_fam2_article_aff">
<lay:collectionItem    property="libelle_famille_secondaire" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_nature_article_aff">
<lay:collectionItem    property="libelle_categorie_article" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_type_article_aff">
<lay:collectionItem    property="libelle_type_article" ></lay:collectionItem>
</lay:collectionTitle>



<lay:collectionTitle title="libelle_unite_article_aff">
<lay:collectionItem    property="libelle_unite" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionItem title=" " href="gestion_articles.do?action=modif&id=" paramId="id" param="id_article"><img src="images/add.png" alt="details" border="0" height="16" width="16" /></lay:collectionItem>
<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_article"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>')" />
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

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_articles"/></td>
    <td align="center"><input type="text" id="aff"  maxlength="5" style="border-width:0px;height:20px;width:100px;text-align: left;" onkeypress="return block()"></input></td></tr>
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



<input type="hidden" id='cd'></input>
</center>
<%
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",lien6="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}



try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}

lien=SortUtil.getURLForCollection("id_article",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_article",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_famille_principale",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_famille_secondaire",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("libelle_categorie_article",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("libelle_type_article",request);
lien5=lien5.replace("amp;","")+nb_page;

lien6=SortUtil.getURLForCollection("libelle_unite",request);
lien6=lien6.replace("amp;","")+nb_page;







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
blond('lib')
blond('selectfam2')
test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.typarticles"  />'+fin);
rouge('id')
window.document.getElementById('id').focus()
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libarticles"  />'+fin);
rouge('lib')
if(test==true)
window.document.getElementById('lib').focus()
test=false
}

fam2=document.getElementById('selectfam2').options.length
if(fam2==0)
{
$.jGrowl(image+'<bean:message key="java.fam2articles"  />'+fin);
rouge('selectfam2')
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
{window.location.href='gestion_articles.do?action=supp&id='+document.getElementById('cd').value+'&i=0'}

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


function agaga()
{
id=document.getElementById('select').options[document.getElementById('select').selectedIndex].value
document.getElementById('form').action='gestion_articles.do?action=select&id='+id
document.getElementById('form').submit()

}

function block()
{return false;}

function vide()
{image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
$.jGrowl(image+'<bean:message key="java.videarticles"  />'+fin);
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
if(id=='id_article_lien')
document.location.href='<%=lien%>'
if(id=='libelle_article_lien')
document.location.href='<%=lien1%>'
if(id=='fam1_article_lien')
document.location.href='<%=lien2%>'
if(id=='fam2_article_lien')
document.location.href='<%=lien3%>'
if(id=='nature_article_lien')
document.location.href='<%=lien4%>'
if(id=='type_article_lien')
document.location.href='<%=lien5%>'
if(id=='unite_article_lien')
document.location.href='<%=lien6%>'


}
</script>


</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>


<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


