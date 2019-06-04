<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>



<%@page import="Dao.PapierVehiDao"%>
<%@page import="Dao.Conn"%>
<lay:html locale="true">

<head>
<title><bean:message key="accueil" /></title>
</head>

<jsp:include flush="true" page="Menu2.jsp"></jsp:include>


<logic:notPresent name="connecte">
<script type="text/javascript">
document.location.href='login.do?action=out'
</script>
</logic:notPresent>


<br/> <br/> <br/><br/><br/>
<table align="center" >
<tr><td align="center">

<img src="images/Logo OS2000.gif"/>
<br/><br/>
</td></tr>
<tr><td align="center">


<% 
String browser = request.getHeader("user-agent");

if(browser.indexOf("Firefox")>0)
{
%>
<object  style="overflow: hidden;background: transparent;z-index: -100;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="640" height="120" align="absmiddle" onclick="return false;">
  <param name="movie" value="images/intro.swf" />
  <param name="quality" value="high" />
  <embed src="images/intro.swf" width="750" height="100" align="absmiddle" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" ></embed> 
</object>        
   
<%} else { %>


<object  style="overflow: hidden;background: transparent;z-index: -100;" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="620" height="80" align="absmiddle" onclick="return false;">
  <param name="movie" value="images/intro.swf" />
  <param name="quality" value="high" />
  <embed src="images/intro.swf" width="750" height="20" align="absmiddle" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" ></embed> 
</object>    

<%} %>
</td></tr>

</table>






</lay:html>
<jsp:include flush="true" page="footer3.jsp"></jsp:include>
<script type="text/javascript">
DynarchMenu.setup('menu');
</script>



<%
PapierVehiDao papierdao =new PapierVehiDao(new Conn().getcnx());
boolean alert_papier=papierdao.notifier();

%>



 <script type="text/javascript">
  msg_alert_papier='gestion_papiervehi.do?action=all'
  image_alert_papier='<table><tr><td><img border="0" style="cursor: pointer;" src="images/attention.png" onclick="window.open(msg_alert_papier)"></td><td align="center">'
  fin_alert='</td></tr></table></center>'
   $(document).ready(function(){
                             x='<%=alert_papier %>'+'a'
                             if(x=='truea')
                             $.jGrowl(image_alert_papier+'Il existe un/des véhicule(s) dont les papiers expireront prochainement'+fin_alert,{sticky: true,theme:'flora'} );
                          
                          })
</script>
