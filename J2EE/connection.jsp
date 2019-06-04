<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>

<lay:html onload="window.document.getElementById('log').focus()">

<head>

<title> <bean:message key="titre1"/> </title>
		<link rel="stylesheet" type="text/css" href="config/jquery.jgrowl2.css" />
	    <link rel="stylesheet" type="text/css" href="config/ddsmoothmenu.css"/>
	    <link rel="stylesheet" type="text/css" href="config/mbContainer.css"/>
		<link rel="stylesheet" href="config/jquery.jgrowl.css" type="text/css"/>
	    <link rel="SHORTCUT ICON" href="images/os2000.ico" title="OS 2000"/>
		<script type="text/javascript" src="js/jgrowl/jquery-1.2.6.js"></script>    
        <script type="text/javascript" src="js/inc/mbContainer.js"></script>
		<script type="text/javascript" src="js/jgrowl/jquery.ui.all.js"></script>
		<script type="text/javascript" src="js/jgrowl/jquery.jgrowl.js"></script>

	 <style type="text/css" media="screen, projection">

			#b1{
		display: block;
		background-color: transparent;
		background-image: url(images/cssButtonsFiles/buttonBackground.png);
		background-repeat: no-repeat;
		width: 132px;
		height: 28px;
		text-align: center;
	    border: none; 
	    color: black
		
		}
		
				#b1:hover {
		background-position: 0 -36px;
		color: black;
		}

	</style>




		
	<script type="text/javascript">
		function rouge(id)
{
    $('#'+id).css( {'border-color': 'red'});
 	$('#'+id).fadeOut("fast");
	$('#'+id).fadeIn("fast");
}

function blond(id)
{
    $('#'+id).css( {'border-color': ''});
}
agt=navigator.appName;
if(agt=='Microsoft Internet Explorer')
document.body.style.backgroundColor='#5191E3'
else 
document.body.style.backgroundColor='#4F9DE7'

		$(function(){
			$(".containerPlus").buildContainers({
				containment:"document",
				elementsPath:"images/elements/"
			});
		});
		
		
			if (!window.console || !console.firebug) {
			var names = ["log", "debug", "info", "warn", "error", "assert", "dir", "dirxml", "group", "groupEnd", "time", "timeEnd", "count", "trace", "profile", "profileEnd"];
			window.console = {};
			for (var i = 0; i < names.length; ++i) window.console[names[i]] = function() {};
		}

		(function($){

			$(document).ready(function(){

				// This value can be true, false or a function to be used as a callback when the closer is clciked
				$.jGrowl.defaults.closer = function() {
					console.log("Closing everything!", this);
				};

				
				$.jGrowl.defaults.closerTemplate = '<div><bean:message key="fermer_tout"  /></div>';
				
	
		
		
			
			});
		})(jQuery);
		
	</script>
</head>
<html:html lang="true">
<logic:notPresent name="info">
<br/>
<br/>
<br/>
</logic:notPresent>
<logic:notPresent name="out">
<br/>
<br/>
<br/>
</logic:notPresent>


<logic:present name="out">
<div class="containerPlus draggable" width="250"  style="top:20px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">
				<h3><bean:message key="out.echec"/></h3>
				<p><bean:message key="out.erreur"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
<br/>
<br/>
<br/>
</logic:present>

<logic:present name="info">
<div class="containerPlus draggable" width="250"  style="top:20px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
	<div class="no"><div class="ne"><div class="n"></div></div>
		<div class="o"><div class="e"><div class="c">
			<div class="content">
				<h3><bean:message key="login.echec"/></h3>
				<p><bean:message key="login.erreur"/></p>
			</div>
		</div></div></div>
		<div >
			<div class="so"><div class="se"><div class="s"></div></div></div>
		</div>
	</div>
</div>
<br/>
<br/>
<br/>
</logic:present>
<%request.getSession().removeAttribute("info");
request.getSession().removeAttribute("out");
%>

<logic:present name="logout">
	<lay:panel align="center" styleClass="FORM" key="Attention">
		<table>
			<tr>
				<td><bean:write name="logout" /></td>
			</tr>
		</table>
	</lay:panel>
</logic:present>




<div id="test">
<br/>
<br/>
<html:form action="login.do?action=connexion">
<table  border="0">

			<tr>
			<td align="center" colspan="3"><u><b><bean:message key="identification"/> </b> </u></td>
			</tr>

			<tr><td></td><td></td><td><br/><br/></td></tr>


			<tr>
				<td align="left"> <b><bean:message key="login"/> </b> </td>	
				<td align="left">
				<html:text name="login" property="login"  size="20" maxlength="20" styleId="log"></html:text></td>
			    <td align="left"> <img src="config/etoile.gif" border="0" />  </td>
			</tr>

			<tr>
				<td align="left"><b> <bean:message key="mot_de_passe"/></b>  </td>
				<td align="left"><html:password name="login" property="mdp" size="20" maxlength="20" styleId="pass" ></html:password></td>
			    <td align="left"> <img src="config/etoile.gif" border="0" />  </td>
			</tr>
			
		<tr><td align="left"> <b><bean:message key="memo"/></b> </td>
		<td align="left"><html:checkbox  name="login" property="rapel"></html:checkbox></td>
		</tr>


		<tr><td align="left"> <b><bean:message key="auto"/></b> </td>
		    <td align="left"><html:checkbox   name="login"  property="auto"></html:checkbox></td>
		</tr>
		    
		    
		

			<tr>
			<td></td><td></td><td><br/><br/></td>
			</tr>



			<tr>
				
				<td align="center" valign="middle" colspan="3"> <html:submit styleId="b1" indexed="b1" onclick="return nonvide();" > <bean:message key="connexion"/></html:submit></td>
	         
			</tr>




	</table>
	
		
</html:form>


</div>

<logic:present name="connecte">
<script type="text/javascript">
document.location.href='Principale.jsp'
</script>
</logic:present>


<script language="javascript" type="text/javascript">


function nonvide()
{
blond('log')
blond('pass')

test1=true
image='<table><tr><td><img border="0" src="images/attention.png"></td><td align="center">'
fin='</td></tr></table></center>'
id=document.getElementById('log').value

if(id=='')
{test1=false
window.document.getElementById('log').focus()
$.jGrowl(image+'<bean:message key="java.login"  />'+fin);
 	rouge('log')

}
lib=document.getElementById('pass').value
if(lib=='')
{$.jGrowl(image+'<bean:message key="java.pass"  />'+fin);
   rouge('pass')
     
if(test1==true)
window.document.getElementById('pass').focus()

test1=false
}


return test1

}




agt=navigator.appName;
if(agt=='Microsoft Internet Explorer')
document.body.style.backgroundColor='#5191E3'
else 
document.body.style.backgroundColor='#4F9DE7'
</script>



</html:html>
</lay:html>	
