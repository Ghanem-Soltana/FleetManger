<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="lay" %>
<%@page import="Action.Utilitaire"%>
<%@page import="Dao.LaisserPasserDao"%>
<%@ page import="org.ajaxanywhere.AAUtils" %>
<%@ taglib  uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%@page import="Dao.OrdreMissionDao"%>
<head>
	<link rel="stylesheet" type="text/css" href="config/drop.css"/>
	<link rel="SHORTCUT ICON" href="images/os2000.ico" title="OS 2000"/>
	<link rel="stylesheet" type="text/css" href="config/mbContainer.css"/>
	<link rel="stylesheet" type="text/css" href="config/spilter.css"/> 
    <link rel="stylesheet" type="text/css" href="config/footer1.css"/>
    <link rel="stylesheet" type="text/css" href="config/style.css"/>
    <link rel="stylesheet" type="text/css" href="config/shadowbox.css"/>
	<link rel="stylesheet" type="text/css" href="config/jquery.jgrowl.css" />
	<link rel="stylesheet" type="text/css" href="config/jquery.jgrowl2.css" />
	 <link rel="stylesheet" type="text/css" href="config/calendar-blue.css" />
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
	    : black
		
		}

		
				#b1:hover {
		background-position: 0 -36px;
		color: black;
		}

		
	
			#b2{
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
	</style>
	 
	 
	 
	 
	 
	 
	 
	 		<script type="text/javascript" src="js/jgrowl/jquery-1.2.6.js"></script>    
        <script type="text/javascript" src="js/inc/mbContainer.min.js"></script>
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
		<% 
		boolean fr=false;
		if(!Action.Utilitaire.present(request,"lng"))
		fr=true;
		if(!fr)
		if(session.getAttribute("lng").equals("fr"))
			fr=true;
		
		%>
		
		<%if(fr){ %>
		<script type="text/javascript" src="js/calendrier/calendar-.js"></script>
		<%}else{ %>
		<script type="text/javascript" src="js/calendrier/calendar-en.js"></script>
		<%} %>
		<script type="text/javascript" src="js/calendrier/calendar-setup.js"></script>
	 
<style type="text/css">@import url("css/skin-modern.css"); </style>  
    <script type="text/javascript">
    agt=navigator.appName;
if(agt=='Microsoft Internet Explorer')
{
document.getElementById('fbbl_center').style.backgroundColor='#5191E3'
document.body.style.backgroundColor='#5191E3'
}
    
    
    
    
      _dynarch_menu_url = "js/";

      function changeBG(bg) {
        if (typeof bg == "undefined") bg = "#fff";
        document.body.style.backgroundColor = bg;
      }

      var ps_visible = true;
      function togglePVisibility() {
        var ps = document.getElementsByTagName("p");
        ps_visible = !ps_visible;
        for (var i = 0; i < ps.length; ++i) {
          ps[i].style.visibility = ps_visible ? "visible" : "hidden";
        }
        return true;
      }
      
      
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
		south_resizable: true,
		south_max_height: 100
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
    
    </script>
    <script type="text/javascript" src="js/hmenu.js"></script>
    </head>
<center>
<ul id="menu"  compact="compact" style="display:none;">



   
   <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">

<li><bean:message key="menu1" /><img alt="down" src="css/img/downarrow-hover.gif" />
   <ul>
    <li><bean:message key="menu1_1" />
         <ul>
         <li><a href="gestion_maint.do?action=all"><bean:message key="menu1_1_1"/></a></li>
         <li><a href="gestion_specialite.do?action=all"><bean:message key="menu1_1_2"/></a></li>
         <li><a href="gestion_station_maint.do?action=all"><bean:message key="menu1_1_3"/></a></li>
         </ul></li>
    <li><bean:message key="menu1_2"/>
         <ul>
         <li><a href="gestion_marque.do?action=all"><bean:message key="menu1_2_1"/></a></li>
         <li><a href="gestion_catego_vehi.do?action=all"><bean:message key="menu1_2_2"/></a></li>
         <li><a href="gestion_modele_vehi.do?action=all"><bean:message key="menu1_2_3"/></a></li>
         <li><a href="gestion_papier.do?action=all"><bean:message key="menu1_2_4"/></a></li>
         <li><a href="gestion_motif.do?action=all"><bean:message key="menu1_2_5"/></a></li>
         </ul></li>
    <li><bean:message key="menu1_3"/>
    	 <ul>
         <li><a href="gestion_energie.do?action=all"><bean:message key="menu1_3_1"/></a></li>
         <li><a href="gestion_matiere.do?action=all"><bean:message key="menu1_3_2"/></a></li>
         </ul>
    </li>

    
    <li><bean:message key="menu1_6"/>
    
    	<ul>
   		<li><a href="gestion_article.do?action=all"><bean:message key="menu1_6_1"/></a></li>
        <li><a href="type_article.do?action=all"><bean:message key="menu1_6_2"/></a></li>
        <li><a href="gestion_unite.do?action=all"><bean:message key="menu1_6_3"/></a></li>
        <li><bean:message key="menu1_6_4"/>
        		<ul>
        		  <li><a href="fam_article_1.do?action=all"><bean:message key="menu1_6_4_1"/></a>
        		  <li><a href="fam_article_2.do?action=all"><bean:message key="menu1_6_4_2"/></a>
        		</ul>
        </li>
        <li><bean:message key="menu1_6_5"/>
           <ul>
        
       <li> <a href="gestion_magasin.do?action=all"><bean:message key="menu1_6_5_1"/></a></li>
       <li><a href="gestion_magasin.do?action=aff"><bean:message key="menu1_6_5_2"/></a></li>
        
           </ul>
        </li>
        <li><a href="gestion_typelub.do?action=all"><bean:message key="menu1_6_6"/></a></li>
        <li> <a href="gestion_carburant.do?action=all"><bean:message key="menu1_6_7"/></a></li>
   		</ul> 
     
    
    </li>
   
   
    <li><a href="gestion_articles.do?action=all"><bean:message key="menu1_7"/></a></li>
   	
  
       <li><a href="fiche_societe.do?action=all"><bean:message key="menu1_5"/></a></li>
       <li><a href="gestion_utilisateur.do?action=all"><bean:message key="menu1_9"/></a></li>
       
    <li><bean:message key="menu1_8"/>
         <ul>
                 <li><a href="gestion_saison.do?action=all"><bean:message key="menu1_8_1"/></a></li>
                 <li><bean:message key="menu1_8_2"/>
                 		<ul>
                 			<li><a href="gestion_fonction.do?action=all"><bean:message key="menu1_8_2_1"/></a></li>
                 		    <li><a href="gestion_qualite.do?action=all"><bean:message key="menu1_8_2_2"/></a></li>
                 		</ul>
                 
                 </li>
                 <li><a href="gestion_agent.do?action=all"><bean:message key="menu1_8_3"/></a></li>
                 <li><a href="gestion_type_tiers.do?action=all"><bean:message key="menu1_8_4"/></a></li>
                 <li><a href="gestion_tiers.do?action=all"><bean:message key="menu1_8_5"/></a></li>
                 <li><bean:message key="menu1_8_6"/>
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
    
  </logic:equal>
  </logic:present>  
    
    
    
    
<li><bean:message key="menu2"/> <img alt="down" src="css/img/downarrow-hover.gif" />
  <ul>
    <li><a href="gestion_vehicule.do?action=all"><bean:message key="menu2_1"/></a></li>
  
  
    <li><bean:message key="menu2_2"/>
    
    
    					<ul>
                 		                 <li><a href="gestion_papiervehi.do?action=all"><bean:message key="menu2_2_1"/></a></li>
                 		                 <li><a href="gestion_vehi_motif_arret.do?action=all"><bean:message key="menu2_2_2"/></a></li>
                 		                 <li><a href="affectaion_vehicule.do?action=all"><bean:message key="menu2_2_3"/></a></li>
                 		
                 		</ul>
    
    
    
    </li>
    
    
    
    
    
    <li><a href="affichage_affectaion_vehicule.do?action=all"><bean:message key="menu2_3"/></a></li>
    
    
        <li><a href="ordre_mission.do?action=all"><bean:message key="menu2_4"/></a></li>
   

   <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">
      <li><a href="valider_ordre_mission.do?action=all"><bean:message key="menu2_8"/></a></li>
  </logic:equal>
  </logic:present>
  
    <li><a href="laisser_passer.do?action=all"><bean:message key="menu2_5"/></a></li>
    
   <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">
      <li><a href="valider_laisser_passer.do?action=all"><bean:message key="menu2_7"/></a></li>
  </logic:equal>
  </logic:present>
  
  
   </ul>
   
</li>




<li><bean:message key="menu3"/><img alt="down" src="css/img/downarrow-hover.gif" />
  <ul>
    <li><a href="gestion_type_bon.do?action=all"><bean:message key="menu3_1"/></a></li>
    <li><a href="gestion_entrer_carburant.do?action=all"><bean:message key="menu3_2"/></a></li>
    
    
    <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">
    <li><a href="valider_entree_bon.do?action=all"><bean:message key="menu3_2_1"/></a></li>
    </logic:equal>
    </logic:present>
    
    
    
    <li><a href="distribution_bon.do?action=all"><bean:message key="menu3_3"/></a></li>
    <li><a href="transfert_bon.do?action=all"><bean:message key="menu3_4"/></a></li>
   </ul>
</li>

<li><bean:message key="menu4"/><img alt="down" src="css/img/downarrow-hover.gif" />
  <ul>
       
   <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">
    <li><a href="init_cpt.do?action=all"><bean:message key="menu4_2"/></a></li>
    </logic:equal>
    </logic:present>
    
    
    
    
    <li><a href="releve_vehicule.do?action=all"><bean:message key="menu4_10"/></a></li>
    
       <logic:present name="connecte">
	<logic:equal name="connecte" value="admin.">
      <li><a href="valider_releve.do?action=all"><bean:message key="menu555"/></a></li>
  </logic:equal>
  </logic:present>
  
    
    
    
    <li><a href="aff_distance.do?action=all"><bean:message key="menu4_1"/></a></li>


   </ul>

</li>

<li><bean:message key="menu6"/><img alt="down" src="css/img/downarrow-hover.gif" />
  <ul>
    <li><a target="_blank"  href="gestion_maint.do?action=print"><bean:message key="menu6_1"/></a></li>
    <li><a target="_blank"  href="gestion_maint.do?action=print4"><bean:message key="menu6_5"/></a></li>
    <li><a target="_blank"  href="impression_selon_centre.jsp"><bean:message key="menu6_2"/></a></li>
    <li><a target="_blank"  href="gestion_maint.do?action=print2"><bean:message key="menu6_3"/></a></li>
    <li><a target="_blank" href="gestion_maint.do?action=print3"><bean:message key="menu6_4"/></a></li>
   </ul>
</li>

<li></li>
<li onclick="return ouvrir()"><a onclick="return ouvrir()"><u><bean:message key="a_propos"/></u></a></li>

 
</ul>
</center>
<hr>


<script type="text/javascript">


function ouvrir()
{    agt=navigator.appName;
if(agt!='Microsoft Internet Explorer')
window.open('A_Propos.jsp','A propos', config='height=650, width=850, toolbar=no, menubar=no, scrollbars=no, resizable=no, left=250, top=90, directories=no, status=no')
else 
window.open('A_Propos.jsp')
}






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

<logic:present name="connecte">
<logic:equal name="connecte" value="admin.">

<%
String affichage="none";    
if(Utilitaire.alerter())
{affichage="block";
	AAUtils.addZonesToRefresh(request, "zone1");
	Dao.Conn cnx=new Dao.Conn();
	LaisserPasserDao ldao =new LaisserPasserDao(cnx.getcnx());
	ldao.annuler_alerte_laisser_passer();
	cnx.closecnx();

}

if (AAUtils.isAjaxRequest(request)) 
    	if(Utilitaire.alerter())
    	{affichage="block";
    		AAUtils.addZonesToRefresh(request, "zone1");
    		Dao.Conn cnx=new Dao.Conn();
    		LaisserPasserDao ldao =new LaisserPasserDao(cnx.getcnx());
    		ldao.annuler_alerte_laisser_passer();
    		cnx.closecnx();
    
    	}


String affichage1="none";    
if(Utilitaire.alerter1())
{affichage1="block";
	AAUtils.addZonesToRefresh(request, "zone4");
	Dao.Conn cnx=new Dao.Conn();
	OrdreMissionDao ldao =new OrdreMissionDao(cnx.getcnx());
	ldao.annuler_alerte_ordre_mission();
	cnx.closecnx();

}

if (AAUtils.isAjaxRequest(request)) 
    	if(Utilitaire.alerter1())
    	{affichage1="block";
    		AAUtils.addZonesToRefresh(request, "zone4");
    		Dao.Conn cnx=new Dao.Conn();
    		OrdreMissionDao ldao =new OrdreMissionDao(cnx.getcnx());
    		ldao.annuler_alerte_ordre_mission();
    		cnx.closecnx();
    
    	}



String affichage2="none";    
if(Utilitaire.alerter2())
{affichage2="block";
	AAUtils.addZonesToRefresh(request, "zone6");
	Dao.Conn cnx=new Dao.Conn();
	Dao.DistReleveDao ldao =new Dao.DistReleveDao(cnx.getcnx());
	ldao.annuler_alerte_releve();
	cnx.closecnx();

}

if (AAUtils.isAjaxRequest(request)) 
	if(Utilitaire.alerter2())
	{affichage2="block";
		AAUtils.addZonesToRefresh(request, "zone6");
		Dao.Conn cnx=new Dao.Conn();
		Dao.DistReleveDao ldao =new Dao.DistReleveDao(cnx.getcnx());
		ldao.annuler_alerte_releve();
		cnx.closecnx();

	}





String affichage3="none";    
if(Utilitaire.alerter3())
{affichage3="block";
	AAUtils.addZonesToRefresh(request, "zone8");
	Dao.Conn cnx=new Dao.Conn();
	Dao.VehiEntrerCarburantDao ldao =new Dao.VehiEntrerCarburantDao(cnx.getcnx());
	ldao.annuler_alerte_entree_bon();
	cnx.closecnx();

}

if (AAUtils.isAjaxRequest(request)) 
	if(Utilitaire.alerter3())
	{affichage3="block";
	AAUtils.addZonesToRefresh(request, "zone8");
	Dao.Conn cnx=new Dao.Conn();
	Dao.VehiEntrerCarburantDao ldao =new Dao.VehiEntrerCarburantDao(cnx.getcnx());
	ldao.annuler_alerte_entree_bon();
	cnx.closecnx();

	}

%>
 <script type="text/javascript">
 msg_alert='valider_laisser_passer.do?action=all'
 image_alert='<table><tr><td><img border="0" height="60px" width="80px" style="cursor: pointer;" src="images/mail.gif" onclick="window.open(msg_alert)"></td><td align="center">'
 msg_alert1='valider_ordre_mission.do?action=all'
 image_alert1='<table><tr><td><img border="0" height="60px" width="80px" style="cursor: pointer;" src="images/mail.gif" onclick="window.open(msg_alert1)"></td><td align="center">'
  msg_alert2='valider_releve.do?action=all' 
  image_alert2='<table><tr><td><img border="0" height="60px" width="80px" style="cursor: pointer;" src="images/mail.gif" onclick="window.open(msg_alert2)"></td><td align="center">'
   msg_alert3='valider_entree_bon.do?action=all' 
  image_alert3='<table><tr><td><img border="0" height="60px" width="80px" style="cursor: pointer;" src="images/mail.gif" onclick="window.open(msg_alert3)"></td><td align="center">'
 
 
 fin_alert='</td></tr></table></center>'
</script>
<script src="js/aa.js"></script>

<form action="Menu2.jsp" name="main" method="post">


                <aa:zone name="zone1" skipIfNotIncluded="true">               

                             <div id="zone2" style="display:<%=affichage %>;">
                         
                         
                             <script type="text/javascript">
                          
                            $(document).ready(function(){
                             x='<%=affichage %>'+'a'
                             if(x=='blocka')
                             $.jGrowl(image_alert+'Il existe une/des demande(s) de laisser passer à valider'+fin_alert,{sticky: true,theme:'flora'} );
                          
                          })
                            </script>               
                          </div>    
                          
                          
                </aa:zone>
                
                
                   <aa:zone name="zone4" skipIfNotIncluded="true">               

                             <div id="zone5" style="display:<%=affichage1 %>;">
                         
                         
                             <script type="text/javascript">
                          	$(document).ready(function(){
                         
                             x='<%=affichage1 %>'+'a'
                             if(x=='blocka')
                             $.jGrowl(image_alert1+'Il existe une/des demande(s) d\'ordre de mission à valider'+fin_alert,{sticky: true,theme:'flora'} );
                        });
                        
                            </script>               
                          </div>    
                          
                          
                </aa:zone>
                
                
                
                     <aa:zone name="zone6" skipIfNotIncluded="true">               

                             <div id="zone7" style="display:<%=affichage2 %>;">
                         
                         
                             <script type="text/javascript">
                          
                         $(document).ready(function(){
                             x='<%=affichage2 %>'+'a'
                             if(x=='blocka')
                             $.jGrowl(image_alert2+'Il existe une/des relevé(s) à valider'+fin_alert,{sticky: true,theme:'flora'} );
                          }); 
                          </script>               
                          </div>    
                          
                          
                </aa:zone>
             
             
                         <aa:zone name="zone8" skipIfNotIncluded="true">               

                             <div id="zone9" style="display:<%=affichage3 %>;">
                         
                         
                             <script type="text/javascript">
                          
                         $(document).ready(function(){
                             x='<%=affichage3 %>'+'a'
                             if(x=='blocka')
                             $.jGrowl(image_alert3+'Il existe une/des entrées de bons carburant à valider'+fin_alert,{sticky: true,theme:'flora'} );
                          }); 
                          </script>               
                          </div>    
                          
                          
                </aa:zone>
             
                
                <script type="text/javascript">

$(document).ready(function(){
			return agaga_alert();
				});

function agaga_alert()
{

setTimeout("ajaxAnywhere.submitAJAX()",10000)
setTimeout("agaga_alert()",10000)
}



</script>
           

</form>
</logic:equal>
</logic:present>

