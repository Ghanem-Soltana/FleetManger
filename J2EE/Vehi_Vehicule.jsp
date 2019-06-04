<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>


<lay:html locale="true">
<head>
<title><bean:message key="vehicule.type" /></title>
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
<b><bean:message key="vehicule.type" /></b>
<br/>
<br/>



<html:form action="gestion_vehicule.do?action=ajout" styleId="form">
<%String titre="ajout.vehicule"; %>
<logic:present name="x">
<%titre="edit.vehicule"; %>
</logic:present>
	<lay:panel align="center" key="<%=titre %>" styleClass="FORM">

	
		<logic:present name="x">
                    <tr>
                    <html:hidden property="id_vehicule" name="vehicule" styleId="id1" ></html:hidden>	
                    <td align="left"><html:button property="" styleId="b1" indexed="b3" onclick="if(document.getElementById('id1').value!='')document.location.href='gestion_vehicule.do?action=pred&id='+document.getElementById('id1').value ;else vide() " ><bean:message key="pred"/>  </html:button></td>
                    <td align="left"></td>
					
					 
                    <td align="center" colspan="2" ><bean:define id="pos" name="pos" /><bean:define id="total" name="total" />
              
                 <b>  <bean:message key="articles_pos"/> <%=pos %>/<%=total %></b>
                    </td>
                    <td align="left"></td>
                   <td align="left"></td>
                    <td align="right"><html:button property="" styleId="b1" indexed="b4" onclick="if(document.getElementById('id1').value!='')document.location.href='gestion_vehicule.do?action=sui&id='+document.getElementById('id1').value ;else vide()  " ><bean:message key="sui"/> </html:button></td>
                    
                    </tr>
				</logic:present>
	
			<tr>
			  
				<td align="left"> <bean:message key="id_vehicule"/>  </td>
				
				
				
				 <logic:notPresent name="x">
				<td align="left"><html:text name="vehicule" property="id_vehicule" size="10" maxlength="10" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
				</logic:notPresent>
				
				 <logic:present name="x">
				<td align="left"><html:text readonly="true" name="vehicule" property="id_vehicule" size="10" maxlength="10" styleId="id" onkeypress="return alphanum(event)"></html:text></td>
				</logic:present>
				
				<td align="left"> <bean:message key="lib_vehicule"/>  </td>
				<td align="left"><html:text  name="vehicule" property="libelle_vehicule" size="30" maxlength="30"  styleId="lib"></html:text></td>
				<td></td>
				<td></td>
			</tr>



	<tr>
				<td align="left"> <bean:message key="vehicule.modele"/></td>
				<td align="left">
	                <html:select property="id_modele" name="vehicule" styleId="select_modele">
					<html:options collection="liste_modele" property="id_modelevehi"  name="liste_modele" labelProperty="libelle_modelevehi"/>
            		</html:select>

               </td>
               
			
				<td align="left"> <bean:message key="vehicule.marque"/></td>
				<td align="left">
				 <html:select property="id_marque" name="vehicule" styleId="select_marque">
					<html:options collection="liste_marque" property="id_marque"  name="liste_marque" labelProperty="libelle_marque"/>
            		</html:select>
				
				</td>
				<td></td>
				<td></td>
			</tr>


			<tr>
				<td align="left"> <bean:message key="vehicule.categorie"/></td>
				<td align="left">
				 <html:select property="id_categorie" name="vehicule" styleId="select_categorie">
					<html:options collection="liste_categorie" property="id_categovehi"  name="liste_categorie" labelProperty="libelle_categovehi"/>
            		</html:select>
				
				</td>
			
				<td align="left"><bean:message key="vehicule.station"/></td>
				<td align="left">
					 <html:select property="id_station" name="vehicule" styleId="select_station">
					<html:options collection="liste_station" property="id_station"  name="liste_station" labelProperty="libelle_station"/>
            		</html:select>
				</td>
				<td></td>
				<td></td>
				
			</tr>
			
			<tr>
			<td align="left" ><bean:message key="vehicule.reference"/></td>
			<td align="left" ><html:text  name="vehicule" property="referrence" size="20" maxlength="20"  styleId="referrence"></html:text></td>
		
			<td align="left"><bean:message key="vehicule.serie"/></td>
			<td align="left" colspan="1"><html:text  name="vehicule" property="serie" size="20" maxlength="20"  styleId="serie"></html:text></td>
			<td align="left"></td>
			<td align="left"></td>
			</tr>


		<tr>
			<td align="left"><bean:message key="vehicule.datef"/></td>
			<td align="left"><html:text  name="vehicule" property="date_fabrication" size="10" maxlength="10"  styleId="fabrication" onkeypress="return numeric_date(event,'fabrication')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c0" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "fabrication",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c0",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
			
			</td>
			<td align="left"><bean:message key="vehicule.datea"/></td>
			<td align="left"><html:text  name="vehicule" property="date_achat" size="10" maxlength="10"  styleId="achat" onkeypress="return numeric_date(event,'achat')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c1" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "achat",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c1",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
			</td>
			<td align="left"><bean:message key="vehicule.dateacqui"/></td>
			<td align="left"><html:text  name="vehicule" property="date_utilisation" size="10" maxlength="10"  styleId="acquisition" onkeypress="return numeric_date(event,'acquisition')"></html:text>
					<img src="images/calendrier.gif" id="f_trigger_c2" style="cursor: pointer;" title="Calendrier"/>
				<script  type="text/javascript" >
  			  		Calendar.setup({
        			inputField     :    "acquisition",     
        			ifFormat       :    "%d/%m/%Y",      
        			button         :    "f_trigger_c2",  
        			align          :    "Br",           
        			singleClick    :   false
    				});
				</script>
			</td>
			</tr>

		<tr>
			<td align="left"><bean:message key="vehicule.prixachat"/></td>
			<td align="left"><html:text name="vehicule" property="prix_achat" size="15" maxlength="15" styleId="prix_achat" onkeypress="return numeric(event,'prix_achat')"></html:text></td>
			<td align="left"><bean:message key="vehicule.montantassu"/></td>
			<td align="left"><html:text name="vehicule" property="prix_assurance" size="15" maxlength="15" styleId="montant assurance" onkeypress="return numeric(event,'montant assurance')"></html:text></td>
			<td align="left"><bean:message key="vehicule.montantappro"/></td>
			<td align="left"><html:text name="vehicule" property="prix_consommation" size="15" maxlength="15" styleId="montant approvisonnement" onkeypress="return numeric(event,'montant approvisonnement')"></html:text></td>
			</tr>




		<tr>
			<td align="left"><bean:message key="vehicule.plannum"/></td>
			<td align="left"><html:text name="vehicule" property="moukhatit" size="20" maxlength="20" styleId="num plan" onkeypress="return numeric(event,'num plan')"></html:text></td>
			<td align="left"><bean:message key="vehicule.nbrplaceassis"/></td>
			<td align="left"><html:text name="vehicule" property="nb_place_assi" size="10" maxlength="3" styleId="assis" onkeypress="return numeric(event,'nb_place_assi')"></html:text></td>
			<td align="left"><bean:message key="vehicule.nbrplacedebout"/></td>
			<td align="left"><html:text name="vehicule" property="nb_place_debout" size="10" maxlength="3" styleId="deboud" onkeypress="return numeric(event,'nb_place_debout')"></html:text></td>
			</tr>


		<tr>
			<td align="left"><bean:message key="vehicule.puissance"/></td>
			<td align="left"><html:text name="vehicule" property="puissance_vapeur" size="10" maxlength="4" styleId="puissance" onkeypress="return numeric(event,'puissance_vapeur')"></html:text></td>
			<td align="left"><bean:message key="vehicule.cylindre"/></td>
			<td align="left"><html:text name="vehicule" property="nb_cylindre" size="6" maxlength="6" styleId="cylindre" onkeypress="return numeric(event,'nb_cylindre')"></html:text></td>
			<td align="left"><bean:message key="vehicule.poidsvide"/></td>
			<td align="left"><html:text name="vehicule" property="poids_vide" size="6" maxlength="6" styleId="poids vide" onkeypress="return numeric(event,'poids_vid')"></html:text></td>
			</tr>
			
			
					<tr>
			<td align="left"><bean:message key="vehicule.chargemax"/></td>
			<td align="left"><html:text name="vehicule" property="poids_supporte" size="6" maxlength="6" styleId="poids_supporte" onkeypress="return numeric(event,'poids_supporte')"></html:text></td>
			<td align="left"><bean:message key="vehicule.compteur"/></td>
			<td align="left"><html:text name="vehicule" property="compteur" size="20" maxlength="20" styleId="compteur" onkeypress="return numeric(event,'compteur')"></html:text></td>
			<td align="left"><bean:message key="vehicule.mouennekm"/></td>
			<td align="left"><html:text name="vehicule" property="myenne_kilometrage" size="10" maxlength="10" styleId="myenne_kilometrage" onkeypress="return numeric(event,'myenne_kilometrage')"></html:text></td>
			</tr>
			
							<tr>
			<td align="left"><bean:message key="vehicule.consomoyenne"/></td>
			<td align="left"><html:text name="vehicule" property="moyenne_consommation" size="10" maxlength="10" styleId="moyenne_consommation" onkeypress="return numeric(event,'moyenne_consommation')"></html:text></td>
			<td align="left"><bean:message key="vehicule.remarque"/></td>
			<td align="left"><html:text name="vehicule" property="remarque" size="30" maxlength="30" styleId="remarque" ></html:text></td>
			
			
			
			
			
			
			   <logic:present name="connecte">
			   <logic:equal name="connecte" value="admin.">
			<td align="left"><bean:message key="vehicule.imprimable"/></td>
			<td align="left"><html:checkbox  name="vehicule" property="imprime"  styleId="imp"></html:checkbox></td>
		       </logic:equal>
		        </logic:present>
		       
		       
		         <logic:present name="connecte">
			   <logic:notEqual name="connecte" value="admin.">

			<td align="left"><html:checkbox style="display:none;"  name="vehicule" property="imprime"  styleId="imp"></html:checkbox></td>
		       </logic:notEqual>
		       </logic:present>
		      
		  	</tr>
			<tr></tr>
			
<logic:notPresent name="x"> 
			<tr>
			    <td></td>
			    <td></td>
		    	<td></td>
				<td></td>
				<td> <html:submit styleId="b1" indexed="b1" onclick="return (nonvide()&&verif_date('fabrication')&&verif_date('achat')&&verif_date('acquisition')&& supperieur('fabrication','achat')&&supperieur('achat','acquisition'))"  > <bean:message key="ajout"/></html:submit></td>
				<td><html:reset  styleId="b1"  > <bean:message key="vider_champs"/></html:reset></td>
			</tr>
	</logic:notPresent>
	
	
			<logic:present name="x"> 
			<tr>
				
				<logic:present name="connecte">
             	<logic:equal name="connecte" value="admin.">
				<td><html:button styleId="b1" property="" indexed="b2" onclick="if(document.getElementById('id').value!=''){supp(document.getElementById('id').value) ;}else vide(); " >   <bean:message key="mode_ajout_supp"/> </html:button></td>
			</logic:equal>
			</logic:present>
				<td align="center"><html:button styleId="b1" property="" indexed="b1" onclick="return nonvide()&&verif_date('fabrication')&&verif_date('achat')&&verif_date('acquisition')&& supperieur('fabrication','achat')&&supperieur('achat','acquisition')&& modifier();" >  <bean:message key="mode_ajout_modif"/></html:button> </td>
				<td></td>
				<td align="center" ><html:button styleId="b1" property="" onclick="window.open('gestion_vehicule.do?action=print&id_vehicule='+document.getElementById('id').value)"  > <bean:message key="imprime_centre"/></html:button></td>
				
				<td align="center" colspan="2"><html:reset styleId="b1"   > <bean:message key="vider_champs"/></html:reset></td>
				
				<td align="center"><html:button styleId="b1" property="" onclick="document.location.href='gestion_vehicule.do?action=all'"  > <bean:message key="mode_ajout_articles"/></html:button> </td>
			</tr>
			</logic:present>
	
	
	</lay:panel>
</html:form>




<logic:present name="x">
<script language="javascript" type="text/javascript"> window.document.getElementById('lib').focus();
window.document.getElementById('lib').select();
 window.document.getElementById('id').style.color='gray'
</script>
</logic:present>



<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_vehicule" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_vehicule" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_vehicule_aff">
<lay:collectionItem  property="id_vehicule"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_vehicule_aff">
<lay:collectionItem    property="libelle_vehicule" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_modele_vehicule_aff">
<lay:collectionItem    property="libelle_modele" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_marque_vehicule_aff">
<lay:collectionItem    property="libelle_marque" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_categorie_vehicule_aff">
<lay:collectionItem    property="libelle_categorie" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="libelle_station_vehicule_aff">
<lay:collectionItem    property="libelle_station" ></lay:collectionItem>
</lay:collectionTitle>





<lay:collectionItem title=" " href="gestion_vehicule.do?action=modif&id=" paramId="id" param="id_vehicule"><img src="images/add.png" alt="details" border="0"  /></lay:collectionItem>



   <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">
<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_vehicule"></bean:define>
<img src="config/supp.gif" style="cursor:pointer;"  onclick="return supp('<%=temp %>')" />
</lay:collectionItem>
</logic:equal>
</logic:present>


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

	<table border="0" ><tr><td><lay:message key="java_supp_confirm_vehicule"/></td>
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
</center>





<%
String lien="",lien1="",lien2="",lien3="",lien4="",lien5="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}



try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}

lien=SortUtil.getURLForCollection("id_vehicule",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_vehicule",request);
lien1=lien1.replace("amp;","")+nb_page;

lien2=SortUtil.getURLForCollection("libelle_modele",request);
lien2=lien2.replace("amp;","")+nb_page;

lien3=SortUtil.getURLForCollection("libelle_marque",request);
lien3=lien3.replace("amp;","")+nb_page;

lien4=SortUtil.getURLForCollection("libelle_categorie",request);
lien4=lien4.replace("amp;","")+nb_page;

lien5=SortUtil.getURLForCollection("libelle_station",request);
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
function nonvide()
{
blond('id')
blond('lib')
blond('select_marque')
blond('select_modele')
blond('select_categorie')

test=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('id').value
if(id=='')
{test=false
 $.jGrowl(image+'<bean:message key="java.typvehicule"  />'+fin);
 rouge('id')
window.document.getElementById('id').focus()
}
lib=document.getElementById('lib').value
if(lib=='')
{
$.jGrowl(image+'<bean:message key="java.libvehicule"  />'+fin);
rouge('lib')
if(test==true)
window.document.getElementById('lib').focus()
test=false
}


marque=document.getElementById('select_marque').options.length
if(marque==0)
{
$.jGrowl(image+'<bean:message key="java.marquevehicule"  />'+fin);
rouge('select_marque')
test=false
}

modele=document.getElementById('select_modele').options.length
if(modele==0)
{
$.jGrowl(image+'<bean:message key="java.modelevehicule"  />'+fin);
rouge('select_modele')
test=false
}

categorie=document.getElementById('select_categorie').options.length
if(categorie==0)
{
$.jGrowl(image+'<bean:message key="java.categorievehicule"  />'+fin);
rouge('select_categorie')
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
{window.location.href='gestion_vehicule.do?action=supp&id='+document.getElementById('cd').value}

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
{
blond(id)
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
$.jGrowl(image+'<bean:message key="java.videvehicule"  />'+fin);
}


function block()
{return false;}


function envoie(id)
{
if(id=='id_vehicule_lien')
document.location.href='<%=lien%>'
if(id=='libelle_vehicule_lien')
document.location.href='<%=lien1%>'
if(id=='modele_vehicule_lien')
document.location.href='<%=lien2%>'
if(id=='marque_vehicule_lien')
document.location.href='<%=lien3%>'
if(id=='categorie_vehicule_lien')
document.location.href='<%=lien4%>'
if(id=='station_vehicule_lien')
document.location.href='<%=lien5%>'



}


function modifier()
{
document.getElementById('form').action='gestion_vehicule.do?action=edit&id='+document.getElementById('id').value+'&i='+document.URL.split('i=')[1] ;
document.getElementById('form').submit()
return true;
}
</script>


</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


