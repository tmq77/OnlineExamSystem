$(function(){
	time = holetime = sessionStorage.getItem("time");
	interval_id = window.setInterval("showtime()",60000);
	$("#time").html(time);
	$("#timetemp").html(time);
	window.showtime = function(){
		time -= 1;
		sessionStorage.setItem("time", time);
		$("#time").html(time);
		if (time <= parseInt(holetime/2)){
			$("#time").addClass("force_red");
			$("#timetemp").addClass("force_red");
		}
		if (time == 0){
			alert("考试结束！");
			sessionStorage.clear();
			subPaper();
			interval_id = window.clearInterval(interval_id);
		}
	}
	
	//时间到，提交
	function subPaper() {
		var token = $("#token").val();
		if(token=="t"){
			$("#sub").addClass("disabled");
			return;
		}
		
		var answer = document.getElementsByTagName("input");
		var result = "";
		for (var i = 0; i < 80; i+=4) {	
			if (answer[i].checked||answer[i+1].checked||answer[i+2].checked||answer[i+3].checked) {
				for(j=i;j<i+4;j++){
					if(answer[j].checked){
						result+=answer[j].value+",";
					}
				}
			}else{
				result+="n"+",";
			}
		}
		$("#token").val("t");
		$("#result").val(result);
		$("#form").submit();
	}
});