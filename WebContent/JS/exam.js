$(function(){
	
	//选中答案则题号变色
	$("input[type='radio']").on('click',function(){
		if($(this).prop("checked")){
			var id_no=$(this).attr("name");
			id_no=parseInt(id_no)+1;
		/*	alert("选中"+id_no);*/
			$("#single_" + id_no).parent().addClass("radioactive");
		}
		//判断是否完成20个单选
		var count = $(".radioactive").length;
		if(count==20){
		$("#baseSingle").css("color","rgb(96, 249, 0)");
		$("#baseSingle").css("font-weight","bolder");
		}
			});
	
	//单选题页面点击对应题号跳转
	$(".abcolor").on("click",function(){
		var id = $(this).attr("id").substring(7);
		$(".baseQs").hide();
		$("#base_"+id).show();
		});
	
	//单选题下一题
	$(".nextQs").on("click",function(){
		var next = $(this).attr("name").substring(5);
		if(parseInt(next)<20){
			$(".baseQs").hide();
			var n = parseInt(next)+1;
			$("#base_"+n).show();
		}else{
			$(this).html("没有了");
			return;
		}
	});
	//单选题上一题
	$(".beforeQs").on("click",function(){
		var before = $(this).attr("name").substring(5);
		if(parseInt(before)>1){
			$(".baseQs").hide();
			var n = parseInt(before)-1;
			$("#base_"+n).show();
		}else{
			$(this).html("没有了");
			return;
		}
		
	});
	
	
})