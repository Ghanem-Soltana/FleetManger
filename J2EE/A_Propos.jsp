<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>



<lay:html locale="true">

<head>
<title><bean:message key="menu_a" /></title>
<link rel="stylesheet" type="text/css" href="fichiers/main.css"/>
</head>


        <script type="text/javascript" src="fichiers/jquery.js" ></script>
		<script type="text/javascript" src="fichiers/jquery-ui-personalized-1.js"></script>
		<script type="text/javascript" src="fichiers/jquery_002.js"></script>
		<script type="text/javascript" src="fichiers/jquery_img.js" ></script>
		<script type="text/javascript">
			$(document).ready(function(){
			
			
agt=navigator.appName;
if(agt=='Microsoft Internet Explorer')
document.body.style.backgroundColor='#5191E3'
else 
document.body.style.backgroundColor='#4F9DE7'

    
				
 $('div.thumb img').hoverpulse();
				
				$("#flipBT").click(function(){
					$("#flipBox").flip({
						direction: 'bt',
						color: '#83870E',
						speed: 400,
						content: "<div class='demo_one'><br/>C'est notre environnement de développement.<br/> Il est intégré libre extensible, universel <br/> et polyvalent.<br/>  </div>"
					});
				});
				$("#flipTB").click(function(){
					$("#flipBox").flip({
						direction: 'tb',
						color: '#B34212',
						speed: 600,
						content: "<div class='demo_two'><br/><br/>C'est notre serveur Web. <br/>Il gère les servlets et les JSP.<br/> </div>"
					});
				});
				$("#flipLR").click(function(){
					$("#flipBox").flip({
						direction: 'lr',
						color: '#341405',
						content: "<div class='demo_three'><br/><br/>C'est notre serveur de base de données. <br/> Il est libre et assez fiable.<br/> </div>"
					});
				});
				$("#flipRL").click(function(){
					$("#flipBox").flip({
						direction: 'rl',
						color: '#166665',
						speed: 550,
						content: "<div class='demo_four'><br/><br/>C'est notre générateur de rapports.<br> Il est libre.</div>"
					});
				});
				
																
			});
			

		</script>
		<!--[if lte IE 6]>
		<link rel="stylesheet" type="text/css" media="screen" href="ie.css" />    
		<![endif]-->
<br/>
<b><u>A propos</u></b>
<br/>
<br/>

		
<table border="0" align="center" >

<tr>
<td colspan="2" align="center">

<table border="0" align="center" >

<tr>

<td>

<b>
Gestion parc automobile <br/>
Version 1.0 ( le 28/05/2009 )<br/>
Description :
</b>
<ul>
<li>Gestion véhicules</li> 
<li>Gestion bons carburants</li> 
<li>Gestion distances parcourues</li> 
<li>Multilingue</li> 
<li>Multi platforme</li> 
<li>Système de notification</li> 
<li>Compatible : FireFox, Internet Explorer ( 7+ ), Google Chrome,...</li> 
</ul>



</td>


</tr>
</table>

</td>
</tr>




<tr>
<td align="center">
			
	
			
					<div id="flipBox">
						<br/><br/><br/><b>Les Outils Utilisés</b>
					</div>
					
					<br/><br/>
					
					<div id="buttons">
						<a id="flipBT" title=" " href="#"><img alt="Eclipse" src="fichiers/outils/eclipse.png" width="50px" height="50px"/></a>&nbsp;&nbsp;&nbsp;
						<a id="flipTB" title=" " href="#"><img alt="Apache Tomcat" src="fichiers/outils/tomcat.png" width="50px" height="50px"/></a>&nbsp;&nbsp;&nbsp;
						<a id="flipLR" title=" " href="#"><img alt="Postgres" src="fichiers/outils/postgres.png" width="50px" height="50px"/></a>&nbsp;&nbsp;&nbsp;
						<a id="flipRL" title=" " href="#"><img alt="Ireport" src="fichiers/outils/ireport.jpg" width="50px" height="50px"/></a>&nbsp;&nbsp;&nbsp;
					</div>
					
				
	</td>				
	<td align="right" width="300px">			
				       <div id="thumbs">
            <div style="position: relative; z-index: 1;" class="thumb"><img style="overflow: hidden; position: absolute; top: 0px; left: 0px; height: 64px; display: block; width: 64px;" src="fichiers/beach1.jpg" width="64" height="64"/></div>
            <div style="position: relative; z-index: 1;" class="thumb"><img style="position: absolute; top: 0px; left: 0px; height: 64px; display: block; width: 64px;" src="fichiers/beach2.jpg" width="64" height="64"/></div>
            <div style="position: relative; z-index: 1;" class="thumb"><img style="overflow: hidden; position: absolute; top: 0px; left: 0px; height: 64px; display: block; width: 64px;" src="fichiers/beach3.jpg" width="64" height="64"/></div>
            <div style="position: relative; z-index: 1;" class="thumb"><img style="overflow: hidden; position: absolute; top: 0px; left: 0px; height: 64px; display: block; width: 64px;" src="fichiers/beach4.jpg" width="64" height="64"/></div>
            <div style="position: relative; z-index: 1;" class="thumb"><img style="overflow: hidden; position: absolute; top: 0px; left: 0px; height: 64px; display: block; width: 64px;" src="fichiers/beach5.jpg" width="64" height="64"/></div>
            <div style="position: relative; z-index: 1;" class="thumb"><img style="overflow: hidden; position: absolute; top: 0px; left: 0px; height: 64px; display: block; width: 64px;" src="fichiers/beach6.jpg" width="64" height="64"/></div>
            <div style="position: relative;" class="thumb"><img style="position: absolute; top: 0px; left: 0px;" src="fichiers/beach7.jpg" width="64" height="64"/></div>
            <div style="position: relative;" class="thumb"><img style="position: absolute; top: 0px; left: 0px;" src="fichiers/beach8.jpg" width="64" height="64"/></div>
            <div style="position: relative;" class="thumb"><img style="position: absolute; top: 0px; left: 0px;" src="fichiers/beach9.jpg" width="64" height="64"/></div>
        </div>
    
		
		
	</td>
	</tr>
	</table>


</lay:html>







