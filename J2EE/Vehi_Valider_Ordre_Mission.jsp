<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="fr.improve.struts.taglib.layout.sort.SortUtil"%>





<lay:html locale="true">
<head>
<title><bean:message key="valider_ordre_mission"/></title>
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
<b><bean:message key="valider_ordre_mission"/></b>
<br/>
<br/>



<html:hidden name="ordre_mission" property="id_ordre_mission" styleId="id1" ></html:hidden>
<html:hidden name="ordre_mission" property="marchandise_transporte" styleId="length" ></html:hidden>

<html:form action="valider_ordre_mission.do?action=valider" styleId="form">
	<lay:panel align="center" key="valider_ordre_mission" styleClass="FORM">

		

                    <tr>
                    <td align="left"><html:button property="" styleId="b1" indexed="b3" onclick="if(document.getElementById('id1').value!='')document.location.href='valider_ordre_mission.do?action=pred&id='+document.getElementById('id1').value ;else vide() " ><bean:message key="pred"/>  </html:button></td>
                    <td align="center" colspan="2" ><bean:define id="pos" name="pos" /><bean:define id="total" name="total" />      
                 <b>  <bean:message key="articles_pos"/> <%=pos %>/<%=total %></b>
                    </td>
                    <td align="right"><html:button property="" styleId="b1" indexed="b4" onclick="if(document.getElementById('id1').value!='')document.location.href='valider_ordre_mission.do?action=sui&id='+document.getElementById('id1').value ;else vide()  " ><bean:message key="sui"/> </html:button></td>   
                    </tr>
				
	
			<tr>
			  
				<td align="left"><bean:message key="ordre_mission.id"/>  </td> 
				<td align="left"><html:text readonly="true" name="ordre_mission" property="id_ordre_mission" size="3" maxlength="3" styleId="id" ></html:text></td>
				
			

						<td align="left"><bean:message key="ordre_mission.ex"/></td>
				<td align="left">
				<html:text  property="libelle_annee" name="ordre_mission"  styleId="anneee" readonly="true"/>
					</td>

			</tr>
			
				
			


			<tr>
				<td align="left"> <bean:message key="ordre_mission.date"/> </td>
				<td align="left">	
				<html:text styleId="date" property="date_ordre_mission"  name="ordre_mission" size="10" maxlength="10" onkeypress="return block()"></html:text>			
				</td>
			
				<td align="left"><bean:message key="ordre_mission.station"/></td>
				<td align="left">
				<html:text styleId="station" property="libelle_station"  name="ordre_mission" size="30" maxlength="30" readonly="true"></html:text>
			   <html:hidden styleId="id_station" property="id_station" name="ordre_mission" />
				</td>
				
			</tr>
			
			
		

	

			<tr>
				<td align="left"><bean:message key="ordre_mission.vehicule"/></td>
				<td align="left">
			
					<html:text   name="ordre_mission"  property="libelle_vehicule" readonly="true" size="30"  maxlength="30"/>
            	    <html:hidden  name="ordre_mission" styleId="vehicule" property="id_vehicule"/>
            		
            		
            			
            		<logic:iterate id="i" name="liste_vehicule" >
            		<bean:define id="temp" name="i" property="id_vehicule" ></bean:define>
            		<%String temp1=String.valueOf(temp);%>
            		<html:hidden name="i" property="libelle_station" styleId="<%=temp1 %>"/>
            		</logic:iterate>
				
				</td>
				
				
		
				<td align="left"><bean:message key="ordre_mission.agent"/></td>
				<td align="left">
				
					<html:text  name="ordre_mission"  property="libelle_agent" readonly="true" size="50" maxlength="50"/>
            		<html:hidden  name="ordre_mission"  property="id_agent"/>
				</td>
				
				
			</tr>
			
			
				<tr>
			<td align="left" ><bean:message key="ordre_mission.objectif"/></td>
			<td align="left" colspan="2">
			
			<html:textarea readonly="true" name="ordre_mission" property="objectif"  styleId="objectif" cols="40" rows="2"></html:textarea>
			
			</td><td></td>
		</tr>


			<tr>
			<td align="left" ><bean:message key="ordre_mission.depart"/></td>
			<td align="left" colspan="2">
			
			<html:text readonly="true" name="ordre_mission" property="depart"  styleId="depart" size="60" maxlength="60"></html:text>
			
			</td>
		
			<td></td>
			</tr>
			
			
			<tr>
			<td align="left" ><bean:message key="ordre_mission.dest"/></td>
			<td align="left" colspan="2">
			
			<html:text readonly="true" name="ordre_mission" property="destination"  styleId="ddest" size="60" maxlength="60"></html:text>
			
			</td>
		
			<td></td>
			</tr>

	<tr>
			<td align="left" ><bean:message key="ordre_mission.march"/></td>
			<td align="left" colspan="2">
			
			<html:textarea readonly="true" name="ordre_mission" property="marchandise_transporte"  styleId="marchandise" cols="40" rows="2"></html:textarea>
			
			</td><td></td>
		</tr>
		
		
		       
			<logic:present name="liste_accompagnants"> 
       
       <tr>
       <td align="left" valign="top"> <bean:message key="ordre_mission.liste"/></td>
       <td align="left" valign="top" colspan="3">
      <table border="0">
                      
                      
                        					<logic:iterate id="j"  name="liste_accompagnants">
											<bean:define id="temp3"  property="libelle_agent" name="j"></bean:define>	   
                                      
                                      <tr>
                                      <td  align="left">
                                           <%=temp3 %>
                                      </td>
                                      </tr>
                                      
                                      
                                             </logic:iterate>
	
	
	
		</table>
		
		<html:hidden styleId="accompagant" name="ordre_mission" property="accompagant"/>
			
			</td>
			
			</tr>
			
			</logic:present>
			
		
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			
      </tr>


			<tr></tr>
			

			<tr>
		        <td></td>
				<td> <html:submit  styleId="b1"  onclick="if(document.getElementById('id').value=='') return vide()" > <bean:message key="valider"/></html:submit></td>
			    <td></td>
			     <td><html:submit styleId="b1"   onclick="if(document.getElementById('id').value!=''){return refuser()}else  return vide();"> <bean:message key="refuser"/></html:submit></td>
			</tr>

	
	
		
	
	
	</lay:panel>
</html:form>




<br/>
<center>
<logic:present name="listevide"><b><font color="red"><bean:message key="er_liste_vide"/></font></b></logic:present>

<logic:notPresent name="listevide">
<logic:present name="liste_ordre_mission" >
<lay:pager maxPageItems="20" > 
<lay:collection name="liste_ordre_mission" id="ji"  styleClass="FORM" styleClass2="FORM2" >

<lay:collectionTitle title="code_ordre_mission_aff">
<lay:collectionItem  property="id_ordre_mission"  ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="ex_ordre_mission_aff">
<lay:collectionItem    property="libelle_annee" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="date_ordre_mission_aff">
<lay:collectionItem    property="date_ordre_mission" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionTitle title="vehicule_ordre_mission_aff">
<lay:collectionItem    property="libelle_vehicule" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="agent_ordre_mission_aff">
<lay:collectionItem    property="libelle_agent" ></lay:collectionItem>
</lay:collectionTitle>


<lay:collectionTitle title="valide_ordre_mission_aff">
<lay:collectionItem    property="valide" ></lay:collectionItem>
</lay:collectionTitle>

<lay:collectionItem title=" ">
<bean:define id="temp" name="ji" property="id_ordre_mission"></bean:define>
<bean:define id="temp1" name="ji" property="id_annee"></bean:define>
<img src="images/add.png" height="20px" width="20px" style="cursor:pointer;"  onclick="return modifier('<%=temp %>','<%=temp1 %>')" />
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
 







<input type="hidden" id='cd'></input>
<input type="hidden" id='cd1'></input>
</center>





<%
String lien="",lien1="",lien2="",lien3="",lien6="",lien7="",nb_page="",sms="";
session.removeAttribute("erreur");
try{sms=String.valueOf(session.getAttribute("sms"));}catch(Exception e){}



try{if(request.getParameter("pagerPage")!=null)
	nb_page="&pagerPage="+request.getParameter("pagerPage");
else nb_page="";
}catch(Exception e){nb_page="";}

lien=SortUtil.getURLForCollection("id_ordre_mission",request);
lien=lien.replace("amp;","")+nb_page;
lien1=SortUtil.getURLForCollection("libelle_annee",request);
lien1=lien1.replace("amp;","")+nb_page;
lien2=SortUtil.getURLForCollection("date_ordre_mission",request);
lien2=lien2.replace("amp;","")+nb_page;
lien3=SortUtil.getURLForCollection("libelle_vehicule",request);
lien3=lien3.replace("amp;","")+nb_page;
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

if(document.getElementById('vehicule').value!='')
{
id_hidden=document.getElementById('vehicule').value
mot=window.document.getElementById(id_hidden).value
window.document.getElementById('station').value=mot
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
if(id=='agent_lpass_lien')
document.location.href='<%=lien6%>'

if(id=='valide_lpass_lien')
document.location.href='<%=lien7%>'

}




function modifier(cd,cd1)
{window.location.href='valider_ordre_mission.do?action=modif&id='+cd+'&annee='+cd1}


function vide()
{image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
$.jGrowl(image+'<bean:message key="vide_ordre_mission.java.vide"/>'+fin);
return false
}


function refuser()
{
document.getElementById('form').action='valider_ordre_mission.do?action=refuser'
document.getElementById('form').submit()
return false
}



</script>


</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>



<script type="text/javascript">
DynarchMenu.setup('menu');
</script>


