$(function(){
	
	//专业简答题页面点击对应题号跳转
	$(".proabcolor").on("click",function(){
		var id = $(this).attr("id").substring(4);
		$(".proessay").hide();
		$("#proessay_"+id).show();
		});
	
	//专业简答题作答题号变色
	$(".proinput").on("change",function(){
		var id = $(this).attr("id").substring(9);
		id=parseInt(id);
		$("#pro_" + id).parent().addClass("proactive");
		var count = $(".proactive").length;
		if(count==3){
			$("#proEssay").css("color","rgb(96, 249, 0)");
			$("#proEssay").css("font-weight","bolder");
		}
		})
		
		//专业简答上一题
	$(".beforePro").on("click",function(){
		var before = $(this).attr("name").substring(9);
		var n =parseInt(before)-1;
		if(n>0){
			$(".proessay").hide();
			$("#proessay_"+n).show();	
		}else{
			$(this).html("没有了");
		}
	})
	
		//专业简答下一题
	$(".nextPro").on("click",function(){
		var next = $(this).attr("name").substring(9);
		var n =parseInt(next)+1;
		if(n<=3){
			$(".proessay").hide();
			$("#proessay_"+n).show();	
		}else{
			$(this).html("没有了");
		}
	})
	
})