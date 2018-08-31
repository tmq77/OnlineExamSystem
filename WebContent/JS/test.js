$(function(){
	
	//禁止F5刷新
	document.onkeydown = function (e) {
	    var ev = window.event || e;
	    var code = ev.keyCode || ev.which;
	    if (code == 116) {
	        ev.keyCode ? ev.keyCode = 0 : ev.which = 0;
	        cancelBubble = true;
	        return false;
	    }
	    if (event.keyCode==122){event.keyCode=0;event.returnValue=false;}  //屏蔽F11 
	} 
	document.oncontextmenu=function(){return false};//禁止右键刷新	

	//左侧工具栏变色切换效果
	$(".acolor").on("click",function(){
		$(".leftmodelleft").removeClass("active");
		$(this).parent().addClass("active");
	});
	
	$(".subthepaper").on("click",function(){
		$("#sub").click();
	})
	
	$(".navbtn").on("click",function(){
		$(".menu").slideToggle(500);
	})
	//录音题
	$("#audioinfo").on("click",function(){
		$("#audio").click();
	})
	//单选
	$("#singleinfo").on("click",function(){
		$("#baseSingle").click();
	})
	//基础简答
	$("#baseinfo").on("click",function(){
		$("#baseEssay").click();
	})
	//专业简答
	$("#proinfo").on("click",function(){
		$("#proEssay").click();
	})
	//修改试题信息
	$("#reinfo").on("click",function(){
		$("#requiredQs").click();
	})
	$(".navmodel").on("click",function(){
		$(".navmodel").parent().removeClass("white");
		$(this).parent().addClass("white");
		setTimeout(function(){
			$(".menu").slideToggle(300);
		}, 300);
		
	})
		
	
});

