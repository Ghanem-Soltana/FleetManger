
<html >
<head>

<script type="text/javascript" src="js/footer2/interface.js"></script>
<link href="config/footer.css" rel="stylesheet" type="text/css" />

<!--[if lt IE 7]>
 <style type="text/css">
 .dock img { behavior: url(js/iepngfix.htc) }
 </style>
<![endif]-->
<script type="text/javascript">
	
	
	$(document).ready(
		function()
		{
			$('#dock2').Fisheye(
				{
					maxWidth: 60,
					items: 'label',
					itemsText: 'span',
					container: '.dock-container2',
					itemWidth: 40,
					proximity: 80,
					alignment : 'left',
					valign: 'bottom',
					halign : 'center'
				}
			)
		}
	);
</script>
</head>
<body>


<center>
<div class="dock" id="dock2" >
  <div class="dock-container2">

  <label class="dock-item2" onclick="document.location.href='Principale.jsp'"><span>Home</span><img src="images/home.png" /></label> 
  <label class="dock-item2" onclick="window.open('http://www.gmail.com/');return false;"><span>Gmail</span><img src="images/email.png"/></label> 
  <label class="dock-item2" ><span>Portfolio</span><img src="images/portfolio.png"  /></label> 
  <label class="dock-item2" ><span>Music</span><img src="images/music.png" /></label> 
  <label class="dock-item2" ><span>Video</span><img src="images/video.png"  /></label> 
  <label class="dock-item2"  ><span>History</span><img src="images/history.png"  /></label> 
  <label class="dock-item2"  ><span>Calendar</span><img src="images/calendar.png" /></label> 
  <label class="dock-item2"  ><span>Links</span><img src="images/link.png" /></label> 
  <label class="dock-item2"  ><span>RSS</span><img src="images/rss.png"  /></label> 
  <label class="dock-item2"  ><span>RSS2</span><img src="images/rss2.png" /></label>  
  </div>
</div>
</center>


</body>
</html>
