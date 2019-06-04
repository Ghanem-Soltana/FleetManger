<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<html:html lang="true">
<lay:html locale="true">



<head>

 <link rel="SHORTCUT ICON" href="images/os2000.ico" title="OS 2000" />
	<link rel="stylesheet" type="text/css" href="config/drop.css"/>
	<link rel="stylesheet" type="text/css" href="config/ddsmoothmenu.css"/>
	<link rel="stylesheet" type="text/css" href="config/mbContainer.css"/>
    <link rel="stylesheet" type="text/css" href="config/footer1.css"/>
    <link rel="stylesheet" type="text/css" href="config/style.css"/>
    <link rel="stylesheet" type="text/css" href="config/shadowbox.css"/>
	<link rel="stylesheet" type="text/css" href="config/jquery.jgrowl.css" />
	<link rel="stylesheet" type="text/css" href="config/jquery.jgrowl2.css" />
	 <link rel="stylesheet" type="text/css" href="config/calendar-blue.css" />



		<script type="text/javascript" src="js/jgrowl/jquery-1.2.6.js"></script>    
        <script type="text/javascript" src="js/menu/ddsmoothmenu.js"></script>
        <script type="text/javascript" src="js/inc/mbContainer.js"></script>
		<script type="text/javascript" src="js/jgrowl/jquery.ui.all.js"></script>
		<script type="text/javascript" src="js/jgrowl/jquery.jgrowl.js"></script>
       	<script type="text/javascript" src="config/popup.js"></script>
	    <script type="text/javascript" src="js/spilter/fbborderlayout.js"></script>
        <script type="text/javascript" src="js/footer1/jquery_002.js"></script> 
        <script type="text/javascript" src="js/jdock/jquery.js"></script>
        <script type="text/javascript" src="js/jdock/demo.js"></script>
        <script src="js/drop/jquery_002.js" type="text/javascript"></script>
		<script src="js/drop/jquery.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/calendrier/calendar.js"></script>
		<!-- a changer selon le language -->
		<script type="text/javascript" src="js/calendrier/calendar-.js"></script>
		<script type="text/javascript" src="js/calendrier/calendar-setup.js"></script>

<script type="text/javascript">
agt=navigator.appName;
if(agt=='Microsoft Internet Explorer')
document.body.style.backgroundColor='#5191E3'
else 
document.body.style.backgroundColor='#4F9DE7'
</script>
</head>

<br/> <br/> <br/><br/><br/><br/><br/><br/><br/>
<table align="center" >
<tr><td align="center">


<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="640" height="120" align="absmiddle" title="Loading">
  <param name="movie" value="images/fead.swf" />
  <param name="quality" value="high" />
  <embed src="images/fead.swf" width="591" height="122" align="absmiddle" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash"></embed> 
</object>        
   

</td></tr>
<tr><td align="center">
<img src="images/loading2.gif"/>
</td></tr>
</table>







<lay:popup key="java_confirm_titre" styleClass="FORM3" styleId="popup">


<jsp:include flush="true" page="footer3.jsp"></jsp:include>
<jsp:include flush="true" page="footer1.jsp"></jsp:include>
<img border="0" src="images/attention.png"/>
<img border="0" src="config/modif.png"/>
<img border="0" src="config/supp.gif.png"/>
<img src="images/sorts.jpg" style="cursor:pointer;" alt="trier" id="id_categovehi_lien" onclick="envoie('id_categovehi_lien')"></img>
	<script type="text/javascript">
		$(function(){
			$(".containerPlus").buildContainers({
				containment:"document",
				elementsPath:"images/elements/"
			});
		});
</script>
<div class="containerPlus draggable" width="250"  style="top:60px;left:10px" buttons="c"  icon="alert.png" skin="black" minimized="false">
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

<img src="images/article.png" width="30" height="30" />
<img src="images/article1.png" width="30" height="30" />

<div class="containerPlus draggable" width="250"  style="top:60px;left:10px" buttons="c"  icon="ok.png" skin="black" minimized="false">
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


<img src="image/loading.gif"/>


<table align="center" >
<tr><td align="center">


<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="640" height="120" align="absmiddle" title="Loading">
  <param name="movie" value="images/intro.swf" />
  <param name="quality" value="high" />
  <embed src="images/intro.swf"  align="absmiddle" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" ></embed> 
</object>        
   

</td></tr>

</table>

</lay:popup>

<script type="text/javascript">
var d=new Date();
var dlpasfini=true;
setTimeout("update()",500)

function update() {
  if (dlpasfini) {
    n=new Date()
    diff=n-d
    dlpasfini=diff <1000
    setTimeout("update()", 1000)
    
  }
  else{document.location.href='login.do?action=init'}
}


</script>

</lay:html>
</html:html>


