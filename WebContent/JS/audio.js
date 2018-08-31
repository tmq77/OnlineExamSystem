$(function() {
		var myAuto = document.getElementById('myaudio');
	
		var start=0;
		myAuto.onplay= function(){
			$("#myaudio").hide();
			myAuto.addEventListener("ended",function() {
		        start++;
		    if (start<2) {
		        setTimeout(function(){myAuto.play();},6000);
		      }
		       });
		};
		//录音题完成后变色提醒
		$("#oiceanswer").on("change",function(){
			$("#audio").css("color","rgb(96, 249, 0)");
			$("#audio").css("font-weight","bolder");
		})
   });
