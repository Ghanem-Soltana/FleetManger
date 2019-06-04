(function($){$.fn.wTooltip=function(o,callback){o=$.extend({content:null,ajax:null,follow:true,auto:true,fadeIn:0,fadeOut:0,appendTip:"body",degrade:false,offsetY:10,offsetX:1,style:{},className:null,id:null,callBefore:function(tooltip,node,settings){},callAfter:function(tooltip,node,settings){},clickAction:function(tooltip,node){$(tooltip).hide()},delay:0,timeout:0,cloneable:false},o||{});if(!o.style&&typeof o.style!="object"){o.style={};o.style.zIndex="1000"}else{o.style=$.extend({border:"1px solid gray",background:"#edeef0",color:"#000",padding:"10px",zIndex:"1000",textAlign:"left"},o.style||{})}if(typeof callback=="function")o.callAfter=callback||o.callAfter;o.style.display="none",o.style.position="absolute";var title,timeout,timeout2,iId,over={},firstMove=true,hovered=false,maxed=false,tooltip=document.createElement('div'),html=document.getElementsByTagName("html")[0],ie6=(typeof document.body.style.maxWidth=="undefined")?true:false,talk=(typeof $.talk=="function"&&typeof $.listen=="function")?true:false;if(o.id)tooltip.id=o.id;if(o.className)tooltip.className=o.className;o.degrade=(o.degrade&&ie6)?true:false;for(var p in o.style)tooltip.style[p]=o.style[p];function fillTooltip(condition){if(condition){if(o.degrade)$(tooltip).html(o.content.replace(/<\/?[^>]+>/gi,''));else $(tooltip).html(o.content)}}if(o.ajax){$.get(o.ajax,function(data){if(data)o.content=data;fillTooltip(o.content)})}function offConditions(that){function _offActions(that){if(title&&!o.content){that.title=title;title=null}}function _execute(){if(!hovered&&o.auto){clearInterval(iId);if(o.fadeOut){$(tooltip).fadeOut(o.fadeOut,function(){_offActions(that)})}else{_offActions(that);tooltip.style.display="none"}}if(typeof o.callAfter=="function")o.callAfter(tooltip,that,o);if(talk)o=$.listen(o)}if(o.timeout>0){timeout2=setTimeout(function(){_execute()},o.timeout)}else{_execute()}}$(tooltip).hover(function(){hovered=true},function(){hovered=false;offConditions(over)});if(talk){o.key=tooltip;o.plugin="wTooltip";o.channel="wayfarer";$.talk(o)}fillTooltip(o.content&&!o.ajax);$(tooltip).appendTo(o.appendTip);return this.each(function(){this.onmouseover=function(ev){var that=this;clearTimeout(timeout2);if(this.title&&!o.degrade&&!o.content){title=this.title;this.title=""}if(o.content&&o.degrade)this.title=tooltip.innerHTML;function _execute(){if(typeof o.callBefore=="function")o.callBefore(tooltip,that,o);if(talk)o=$.listen(o);if(o.auto){var display;if(o.content){if(!o.degrade)display="block"}else if(title&&!o.degrade){$(tooltip).html(title);display="block"}else{display="none"}if(display=="block"&&o.fadeIn)$(tooltip).fadeIn(o.fadeIn);else tooltip.style.display=display}}if(o.delay>0){timeout=setTimeout(function(){_execute()},o.delay)}else{_execute()}}this.onmousemove=function(ev){var e=(ev)?ev:window.event,that=this;over=this;if(o.follow||firstMove){var scrollY=html.scrollTop;var scrollX=html.scrollLeft;var top=e.clientY+scrollY+o.offsetY;var left=e.clientX+scrollX+o.offsetX;var maxLeft=$(window).width()+scrollX-$(tooltip).outerWidth();var maxTop=$(window).height()+scrollY-$(tooltip).outerHeight();maxed=(top>maxTop||left>maxLeft)?true:false;if(left-scrollX<=0&&o.offsetX<0)left=scrollX;else if(left>maxLeft)left=maxLeft;if(top-scrollY<=0&&o.offsetY<0)top=scrollY;else if(top>maxTop)top=maxTop;tooltip.style.top=top+"px";tooltip.style.left=left+"px";firstMove=false}}this.onmouseout=function(){clearTimeout(timeout);var that=this;firstMove=true;if(!o.follow||maxed||(o.offsetX<0&&o.offsetY<0)){setTimeout(function(){iId=setInterval(function(){offConditions(that)},1)},1)}else{offConditions(this)}}if(typeof o.clickAction=="function"){this.onclick=function(){o.clickAction(tooltip,this)}}})}})(jQuery);