$(function(){

	setTimeout(function(){
		$("#modify").click();
		
	}, 500);
	//折叠按钮
	$(".navbtn").on("click",function(){
		$(".menu").slideToggle(500);
	})
	//人员信息
	$("#userinfo").on("click",function(){
		$("#modify").click();
	})
	//查看成绩
	$("#scoreinfo").on("click",function(){
		$("#score").click();
	})
	//查看通过人员
	$("#passinfo").on("click",function(){
		$("#pass").click();
	})
	//录入试题信息
	$("#questioninfo").on("click",function(){
		$("#question").click();
	})
	//修改试题信息
	$("#exameditinfo").on("click",function(){
		$("#examedit").click();
	})
	$(".navmodel").on("click",function(){
		$(".navmodel").parent().removeClass("white");
		$(this).parent().addClass("white");
		setTimeout(function(){
			$(".menu").slideToggle(500);
		}, 500);
		
	})
	
	//退出登录
	$(".exit").on("click",function(){
		 $.confirm({
			 icon:"	glyphicon glyphicon-log-out",
			 title:"确认退出",
			 content:"您将会退出登录",
			 type:"orange",
			 buttons:{
				 ok:{
					 text:"确定",
					 btnClass:"btn-warning",
					 action:function(){
						 $.ajax({
								type:"post",
								dataType:"text",
								url:"exit",
								cache:false,
								success:function(data){
									window.location="login";
								}
							})
					 }
				 },
				 cancel:{
					 text:"取消",
					 btnClass:"btn",
					 action:function(){
						 return;
					 }
				 }
			 }
		 });
		
	})
	
	//点击功能栏背景变色
	$(".aoption").on("click",function(){
		$(".leftmodel").removeClass("active");
		$(this).parent().parent().addClass("active");
	});
	
	//录入试题信息
	$("#question").on("click",function(){
		toastr.info("加载中，请稍后。。");
		$.ajax({
			type:"post",
			url:"addQuestion",
			dataType:"text",
			cache:false,
			success:function(data){
				$("#show").html(data);
				setTimeout(function(){
					$("#show").fadeIn(600);
					toastr.clear();
				}, 400)
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	
	//通过的人员信息
	$("#pass").on("click",function(){
		toastr.info("加载中，请稍后。。");
		$.ajax({
			type:"post",
			url:"ShowStaff",
			dataType:"text",
			cache:false,
			success:function(data){
				$("#show").html(data);
				setTimeout(function(){
					$("#show").fadeIn(600);
					toastr.clear();
				}, 400)
			},
		error:function(){
			toastr.error("服务器通信失败");
		}
		})
	})
	
	//查看试卷按钮点击事件
	$("#score").on("click",function(){
		toastr.info("加载中，请稍后。。");
		$.ajax({
			type:"post",
			url:"ShowScore",
			dataType:"text",
			cache:false,
			success:function(data){
				$("#show").html(data);
				setTimeout(function(){
					$("#show").fadeIn(600);
					toastr.clear();
				}, 400)
				
				
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	//修改试卷信息按钮点击事件
	$("#examedit").on("click",function(){
		toastr.info("加载中，请稍候。。");
		$.ajax({
			type:"post",
			url:"examedit",
			dataType:"text",
			cache:false,
			success:function(data){
				$("#show").html(data);
				setTimeout(function(){
					$("#show").fadeIn(600);
					toastr.clear();
				}, 400)

			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	//人员信息按钮点击事件
	$("#modify").on("click",function(){
		toastr.info("加载中，请稍候。。");
		$.ajax({
			type:"post",
			url:"view",
			dataType:"text",
			cache:false,
			success:function(data){
				$("#show").html(data);
				//数据填充完毕之后再次请求ajax验证人员的考试情况是中途退出还是正常考试或者未考试
				$.ajax({
					type:"POST",
					url:"ModifyStatus",
					dataType:"json",
					cache:false,
					success:function(obj){
						$.each(obj,function(i){
							$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
						})
					},
					error:function(){
						toastr.error("获取精确的考试状态失败");
					}
				})
						
				setTimeout(function(){
					$("#show").fadeIn(600);
					toastr.clear();
				}, 400)
				
				
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
})