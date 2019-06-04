<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>




<head>
	<link rel="stylesheet" type="text/css" href="config/drop.css"/>
	<link rel="SHORTCUT ICON" href="images/os2000.ico" title="OS 2000"/>
	<link rel="stylesheet" type="text/css" href="config/ddsmoothmenu.css"/>
	<link rel="stylesheet" type="text/css" href="config/mbContainer.css"/>
	<link rel="stylesheet" type="text/css" href="config/spilter.css"/> 
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
	 	// In case you don't have firebug...
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

$(function () {
	$("body").FBBorderLayout({
		spacing: 5,
		north_resizable: true,
		north_max_height: 100,
		east_resizable: true,
		east_width: 300,
		east_min_width:200,
		east_max_width:400,
		south_resizable: true,
		south_max_height: 100,
		west_resizable: true,
		west_width: 300,
		west_min_width:200,
		west_max_width:400
	});
});


$(function(){
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	$(".drag")
		.bind( "dragstart", function( event ){
			// ref the "dragged" element, make a copy
			var $drag = $( this ), $proxy = $drag.clone();
			// modify the "dragged" source element
			$drag.addClass("outline");
			// insert and return the "proxy" element		
			return $proxy.appendTo( document.body ).addClass("ghost");
			})
		.bind( "drag", function( event ){
			// update the "proxy" element position
			$( event.dragProxy ).css({
				left: event.offsetX, 
				top: event.offsetY
				});
			})
		.bind( "dragend", function( event ){
			// remove the "proxy" element
			$( event.dragProxy ).fadeOut( "normal", function(){
				$( this ).remove();
				});
			// if there is no drop AND the target was previously dropped 
			if ( !event.dropTarget && $(this).parent().is(".drop") ){
				// output details of the action
				$('#log').append('<div>Removed <b>'+ this.title +'</b> from <b>'+ this.parentNode.title +'</b></div>');
				// put it in it's original <div>
				$('#nodrop').append( this );
				}
			// restore to a normal state
			$( this ).removeClass("outline");	
			
			});
	$('.drop')
		.bind( "dropstart", function( event ){
			// don't drop in itself
			if ( this == event.dragTarget.parentNode ) return false;
			// activate the "drop" target element
			$( this ).addClass("active");
			})
		.bind( "drop", function( event ){
			// if there was a drop, move some data...
			$( this ).append( event.dragTarget );

		if(this.title=='Target B')
		add(event.dragTarget.title)
		else
	    remove(event.dragTarget.title)
		


		})
		
		.bind( "dropend", function( event ){
			// deactivate the "drop" target element
			$( this ).removeClass("active");
			});
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	});


	</script>
		
    	 
    </head>
	









<a name="top"></a>
<center>
<div id="smoothmenu1" class="ddsmoothmenu">
<ul id="ul">



<li><a href="#" ><bean:message key="menu1" /></a>
   <ul>
    <li><a href="#"><bean:message key="menu1_1" /></a>
         <ul>
         <li><a href="gestion_maint.do?action=all"><bean:message key="menu1_1_1"/></a></li>
         <li><a href="gestion_specialite.do?action=all"><bean:message key="menu1_1_2"/></a></li>
         <li><a href="gestion_station_maint.do?action=all"><bean:message key="menu1_1_3"/></a></li>
         </ul></li>
    <li><a href="#"><bean:message key="menu1_2"/></a>
         <ul>
         <li><a href="gestion_marque.do?action=all"><bean:message key="menu1_2_1"/></a></li>
         <li><a href="gestion_catego_vehi.do?action=all"><bean:message key="menu1_2_2"/></a></li>
         <li><a href="gestion_modele_vehi.do?action=all"><bean:message key="menu1_2_3"/></a></li>
         <li><a href="gestion_papier.do?action=all"><bean:message key="menu1_2_4"/></a></li>
         <li><a href="gestion_motif.do?action=all"><bean:message key="menu1_2_5"/></a></li>
         </ul></li>
    <li><a href="#"><bean:message key="menu1_3"/></a>
    	 <ul>
         <li><a href="gestion_energie.do?action=all"><bean:message key="menu1_3_1"/></a></li>
         <li><a href="gestion_matiere.do?action=all"><bean:message key="menu1_3_2"/></a></li>
         </ul>
    </li>
    <li><a href="#"><bean:message key="menu1_4"/></a></li>
    <li><a href="fiche_societe.do?action=all"><bean:message key="menu1_5"/></a></li>
    
    <li><a href="#"><bean:message key="menu1_6"/></a>
    
    	<ul>
   		<li><a href="gestion_article.do?action=all"><bean:message key="menu1_6_1"/></a></li>
        <li><a href="type_article.do?action=all"><bean:message key="menu1_6_2"/></a></li>
        <li><a href="gestion_unite.do?action=all"><bean:message key="menu1_6_3"/></a></li>
        <li><a href="#"><bean:message key="menu1_6_4"/></a>
        		<ul>
        		  <li><a href="fam_article_1.do?action=all"><bean:message key="menu1_6_4_1"/></a>
        		  <li><a href="fam_article_2.do?action=all"><bean:message key="menu1_6_4_2"/></a>
        		</ul>
        </li>
        <li><a href="gestion_magasin.do?action=all"><bean:message key="menu1_6_5"/></a></li>
        <li><a href="#"><bean:message key="menu1_6_6"/></a></li>
        <li><a href="#"><bean:message key="menu1_6_7"/></a></li>
   		</ul> 
     
    
    </li>
   
   
    <li><a href="#"><bean:message key="menu1_7"/></a></li>
   	
  
   
   
    <li><a href="#"><bean:message key="menu1_8"/></a>
         <ul>
                 <li><a href="gestion_saison.do?action=all"><bean:message key="menu1_8_1"/></a></li>
                 <li><a href="#"><bean:message key="menu1_8_2"/></a>
                 		<ul>
                 			<li><a href="gestion_fonction.do?action=all"><bean:message key="menu1_8_2_1"/></a></li>
                 		    <li><a href="gestion_qualite.do?action=all"><bean:message key="menu1_8_2_2"/></a></li>
                 		</ul>
                 
                 </li>
                 <li><a href="gestion_agent.do?action=all"><bean:message key="menu1_8_3"/></a></li>
                 <li><a href="gestion_type_tiers.do?action=all"><bean:message key="menu1_8_4"/></a></li>
                 <li><a href="gestion_tiers.do?action=all"><bean:message key="menu1_8_5"/></a></li>
                 <li><a href="#"><bean:message key="menu1_8_6"/></a>
                 		<ul>
                 		                 <li><a href="gestion_centre.do?action=all"><bean:message key="menu1_8_6_1"/></a></li>
                 		                 <li><a href="gestion_agence.do?action=all"><bean:message key="menu1_8_6_2"/></a></li>
                 		                 <li><a href="gestion_service.do?action=all"><bean:message key="menu1_8_6_3"/></a></li>
                 		
                 		</ul>
                 </li>
                 <li><a href="gestion_ville.do?action=all"><bean:message key="menu1_8_7"/></a></li>
         </ul>
           
    </li>
    </ul></li>
<li><a href="#"><bean:message key="menu2"/></a>
  <ul>
    <li><a href=""><bean:message key="menu2_1"/></a></li>
    <li><a href=""><bean:message key="menu2_2"/></a></li>
    <li><a href=""><bean:message key="menu2_3"/></a></li>
    <li><a href=""><bean:message key="menu2_4"/></a></li>
    <li><a href=""><bean:message key="menu2_5"/></a></li>
    <li><a href=""><bean:message key="menu2_6"/></a></li>
   </ul>
</li>
<li><a href="#"><bean:message key="menu3"/></a>
  <ul>
    <li><a href=""><bean:message key="menu3_1"/></a></li>
    <li><a href=""><bean:message key="menu3_2"/></a></li>
    <li><a href=""><bean:message key="menu3_3"/></a></li>
    <li><a href=""><bean:message key="menu3_4"/></a></li>
   </ul>
</li>

<li><a href="#">menu4</a></li>

<li><a href="#"><bean:message key="menu6"/></a>
  <ul>
    <li><a href=""><bean:message key="menu6_1"/></a></li>
    <li><a href=""><bean:message key="menu6_2"/></a></li>
    <li><a href=""><bean:message key="menu6_3"/></a></li>
    <li><a href=""><bean:message key="menu6_4"/></a></li>
    <li><a href=""><bean:message key="menu6_5"/></a></li>
    <li><a href=""><bean:message key="menu6_6"/></a></li>
   </ul>
</li>



 
</ul>
<br style="clear: left" />
</div>

</center>

<script type="text/javascript">
Nom = navigator.appName;
if (Nom != 'Microsoft Internet Explorer') {
ul=document.getElementById('ul');
ul.style.left=document.documentElement.clientWidth /4+ 'px'
}
</script>

<script type="text/javascript">
function add(lib)
{aux=''
aux=document.getElementById('save').value
aux=aux+lib+'$'
document.getElementById('save').value=aux
}
function remove(lib)
{aux=document.getElementById('save').value
aux1=''
tab=aux.split('$')

for(i=0;i<tab.length-1;i++)
{
if(tab[i]!=lib)
aux1=aux1+tab[i]+'$'
}
document.getElementById('save').value=aux1
}
</script>


<lay:popup key="popup.message" styleClass="FORM" styleId="agaga">
	<lay:space/>
	<lay:message key="popup.question"/>
	<lay:space/>
	<lay:cell width="100%" align="center">
		<lay:button onclick="closeStrutsLayoutPopup('agaga');document.location='login.do?action=logout';"><lay:message key="popup.yes"/></lay:button>
		<lay:button onclick="closeStrutsLayoutPopup('agaga');"><lay:message key="popup.no"/></lay:button>
	</lay:cell>
	<lay:space/>
</lay:popup>




