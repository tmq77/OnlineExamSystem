$(function(){
	//必答题完成后变色提醒
	$("#reanswer").on("change",function(){
		$("#requiredQs").css("color","rgb(96, 249, 0)");
		$("#requiredQs").css("font-weight","bolder");
	})
})