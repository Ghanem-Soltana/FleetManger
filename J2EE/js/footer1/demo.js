jQuery(function($){Shadowbox.init({skipSetup:true});var hasindx=/dt=\d+/.test(location.href);$('#pagebuttons input').each(function(){var n=this.id.charAt(this.id.length-1);if((!hasindx&&n=='0')||location.href.indexOf('dt='+n)>=0){this.disabled=true}else{$(this).click(function(){location.href='index.php?dt='+n;return false})}});var sboxopts={width:900,gallery:'sbox',counterType:'skip',onFinish:function(i){xferSboxBtns(i)}},sbxa=$('#sboxbuttons a.sboxbtn').shadowbox(sboxopts);function xferSboxBtns(i){var sti=$('#shadowbox_title_inner').append('<div id="shadowbox_other_pages"><div class="jqDkV" title="Current version">v'+$.jqDock('version')+'</div></div>').find('#shadowbox_other_pages'),ndx=sbxa.index(i.el);sbxa.not(i.el).clone().appendTo(sti).each(function(n){$(this).one('click',function(){Shadowbox.change(n<ndx?n:n+1);sti.remove();return false})});$('#shadowbox').find('.inPageLink').each(function(){var clk=$("[title='"+this.title+"']",sti);$(this).one('click',function(){clk.trigger('click');return false})})}$('a.targetBlank').attr({target:'_blank'});$('#jqDockVersion').text(' v'+$.jqDock('version'));var bv=' ( ';$.each(['opera','mozilla','msie','safari'],function(i,v){bv+=($.browser[v]?v:'')});bv+=' v.'+$.browser.version+' )';$('#eop').append('<span style="padding-left:12px;">'+bv+'</span>')});