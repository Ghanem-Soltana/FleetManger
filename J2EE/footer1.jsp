
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>



  <script type="text/javascript">
  jQuery(function($){



    $('div.demo').each(function(i){ 
        var opts = { align:        [ 'bottom', 'right', 'top' , 'middle', 'left', 'center' ][i] || 'bottom' //default
                   , size:         [  48     ,  48    ,  48   ,  48     ,  36   ,  60      ][i] || 36       //default
                   , distance:     [  60     ,  60    ,  60   ,  60     ,  48   ,  80      ][i] || 54       //default
                   , coefficient : [  1.5    ,  1.5   ,  1.5  ,  1      ,  1.5  ,  1.5     ][i] || 1.5      //default
                   , labels:       [  true   ,  true  ,  true ,  true   ,  true ,  true   ][i] || false    //default
                   , duration:     500 //default
    
                   , source:       (i==0 || i==6) ? function(i){ return (this.alt) ? false : this.src.replace(/(jpg|gif)$/,'png'); } : false //default
                   };
        $(this).jqDock(opts);
      });
   

  });
  </script>


<div id="sboxbuttons">
<div id="page">

<div style="display: nome;" id="menu1" class="demo"><div><div class="jqDock" >
<img class="jqDockMouse0_6" style="background-color:transparent;border-style: none; border-width: 0pt; position: relative; vertical-align: bottom; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt;" src="images/footer/rien.gif" alt="">
<div class="jqDockLabel jqDockMouse0_00 jqDockLabelImage" style="margin: 0px; position: absolute; display: none; width: 39px; height: 16px; top: 0pt; left: 288px;">Trash</div></div></div></div>




<div style="display: nome;" id="menu2" class="demo"><div style="border: 0px none ; margin: 0px; padding: 0px; position: relative; background-color: transparent;"><div class="jqDock" style="margin: 0px 0px 0px 63px; padding: 0px; overflow: visible; position: absolute; top: 0px; left: 0px; height: 48px; width: 336px;">
<img class="jqDockMouse0_6"><div class="jqDockLabel jqDockMouse0_00 jqDockLabelImage" ></div></div></div></div>

<div style="display:nome;" id="menu3" class="demo"><div style="border: 0px none ; margin: 0px; padding: 0px; position: relative; background-color: transparent;"><div class="jqDock" style="margin: 0px 0px 0px 63px; padding: 0px; overflow: visible; position: absolute; top: 0px; left: 0px; height: 48px; width: 336px;">
<img class="jqDockMouse0_6" style="background-color:transparent;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt;"  alt=""><div class="jqDockLabel jqDockMouse0_00 jqDockLabelImage" style="margin: 0px; position: absolute; display: none; width: 39px; height: 16px; top: 0pt; left: 288px;"></div></div></div></div>




<div style="display: none;" id="menu4" class="demo"><div style="border: 0px none ; margin: 0px; padding: 0px; position: relative; background-color: transparent;"><div class="jqDock" style="margin: 0px 0px 0px 46px; padding: 0px; overflow: visible; position: absolute; top: 0px; left: 1px; height: 48px; width: 392px;">

<img class="jqDockMouse3_0" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/home.png"  alt="" onclick="document.location.href='Principale.jsp'"/>
<img class="jqDockMouse3_1" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/email.png" alt="" onclick="window.open('http://www.gmail.com/');return false;"/>
<a class="sboxbtn" title="<bean:message key="planing"/>" href="#jqdockintro" > <img class="jqDockMouse3_2" style="cursor:pointer;border-style: none; border-width: 0pt; position: absolute; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/calendar.png"/></a>




   
<logic:present name="connecte">
<logic:equal name="connecte" value="admin.">
<img class="jqDockMouse3_3" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative;align:middle; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/history.png" alt="" onclick="document.location.href='gestion_plan.do?action=all'"/>
<a class="sboxbtn" title="<bean:message key="choix_langue"/>" href="#jqdocklang" > <img class="jqDockMouse3_4" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/link.png" alt="" onclick=""/></a>
<a class="sboxbtn" title="<bean:message key="Déconnection"/>" href="#jqdockdecon" > <img class="jqDockMouse3_5" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/deconn.png" /></a>
</logic:equal>
</logic:present>

<script type="text/javascript">
reparation=0;
</script>

<logic:present name="connecte">
<logic:notEqual name="connecte" value="admin.">
<a class="sboxbtn" title="<bean:message key="choix_langue"/>" href="#jqdocklang" > <img class="jqDockMouse3_3" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/link.png" alt="" onclick=""/></a>
<a class="sboxbtn" title="<bean:message key="Déconnection"/>" href="#jqdockdecon" > <img class="jqDockMouse3_4" style="cursor:pointer;border-style: none; border-width: 0pt; position: relative; vertical-align: top; display: block; float: left; height: 48px; width: 48px; margin-top: 0pt; margin-bottom: 0pt;" src="images/deconn.png" /></a>

<script type="text/javascript">
reparation=23;
</script>

</logic:notEqual>
</logic:present>
<div class="jqDockLabel jqDockMouse3_00 jqDockLabelImage" style="margin: 0px; position: absolute; display: none;"></div></div></div></div>
</div>
</div>



<script type="text/javascript">
Nom = navigator.appName;
if (Nom != 'Microsoft Internet Explorer') {
ul=document.getElementById('menu4');
ul.style.left=document.documentElement.clientWidth /3.55+reparation+ 'px'

}
else 
{
if(reparation==23)
{
ul=document.getElementById('menu4');
ul.style.left=document.documentElement.clientWidth /3.55+reparation+ 'px'
}

}
</script>

