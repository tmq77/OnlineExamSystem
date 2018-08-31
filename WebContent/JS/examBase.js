$(function(){
	//基础题简答题作答题号变色
	$(".baseinput").on("change",function(){
		var id = $(this).attr("id").substring(10);
		id=parseInt(id);
		$("#bas_" + id).parent().addClass("baseactive");
		var count = $(".baseactive").length;
		if(count==3){
			$("#baseEssay").css("color","rgb(96, 249, 0)");
			$("#baseEssay").css("font-weight","bolder");
		}
		})
		//逻辑简答题页面点击对应题号跳转
	$(".baseabcolor").on("click",function(){
		var id = $(this).attr("id").substring(4);
		$(".baseessay").hide();
		$("#baseessay_"+id).show();
		});
	
	//基础简答上一题
	$(".beforeEssay").on("click",function(){
		var before = $(this).attr("name").substring(10);
		var n =parseInt(before)-1;
		if(n>0){
			$(".baseessay").hide();
			$("#baseessay_"+n).show();	
		}else{
			$(this).html("没有了");
		}
	})
	
		//基础简答下一题
	$(".nextEssay").on("click",function(){
		var next = $(this).attr("name").substring(10);
		var n =parseInt(next)+1;
		if(n<=3){
			$(".baseessay").hide();
			$("#baseessay_"+n).show();	
		}else{
			$(this).html("没有了");
		}
	})
})