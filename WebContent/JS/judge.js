	$(function() {

		
			if(window.outerWidth<880){
				$(".deleteUser").addClass("btn-xs");
				$(".passUser").addClass("btn-xs");
			}else{
				$(".deleteUser").removeClass("btn-xs");
				$(".passUser").removeClass("btn-xs");
			}
			window.onresize = function(){
				if(window.outerWidth<880){
					$(".deleteUser").addClass("btn-xs");
					$(".passUser").addClass("btn-xs");
				}else{
					$(".deleteUser").removeClass("btn-xs");
					$(".passUser").removeClass("btn-xs");
				}
			}
		
		
		//大于六条信息则分页工具显示
		if ($(".mytr").length >= 6) {
			$(".modifydiv").css("display", "block");
		} else if ($("#mypage").text() > 1) {
			$(".modifydiv").css("display", "block");
		}
		
		//点击基础简答触发事件
		$(".base").on("click",function(){
			$.ajax({
				type:"post",
				url:"ShowBaseAnswer",
				data:"account="+$(this).attr("name"),
				dataType:"text",
				cache:false,
				success:function(data){
					$("#showContent").html(data);
					toastr.info("请稍后。。。");
					setTimeout(function(){
						$("#myModal").modal("show");
						toastr.clear();
					}, 600);
					
				},
				error:function(){
					toastr.error("系统异常");
				}
			})
		})
		//点击专业简答触发事件
		$(".pro").on("click",function(){
			$.ajax({
				type:"post",
				url:"ShowProAnswer",
				data:"account="+$(this).attr("name"),
				dataType:"text",
				cache:false,
				success:function(data){
					$("#showContent").html(data);
					toastr.info("请稍后。。。");
					setTimeout(function(){
						$("#myModal").modal("show");
						toastr.clear();
					}, 600);
					
				},
				error:function(){
					toastr.error("系统异常");
				}
			})
		})
		//综合题
		$(".all").on("click",function(){
			$.ajax({
				type:"post",
				url:"ShowRequiredAnswer",
				data:"account="+$(this).attr("name"),
				dataType:"text",
				cache:false,
				success:function(data){
					$("#showContent").html(data);
					toastr.info("请稍后。。。");
					setTimeout(function(){
						$("#myModal").modal("show");
						toastr.clear();
					}, 600);
					
				},
				error:function(){
					toastr.error("系统异常");
				}
			})
		})
	
		//通过考试
		$(".passUser").on("click",function(){
			var post = $(this).val();
			var username=$(this).attr("id");
			var name = $(this).attr("name");
			var mail = $(this).attr("title");
			$.confirm({
				icon:"glyphicon glyphicon-ok",
				title:"确认操作",
				content:"是否确认操作？",
				type:"blue",
				buttons:{
					ok:{
						text:"确定",
						btnClass:"btn-info",
						action:function(){
							$(".mask").fadeIn(500);
							setTimeout(function(){
								$.ajax({
									type:"post",
									url:"PrintPaper",
									data:"username="+username,
									dataType:"text",
									cache:false,
									success:function(data){
										if(data=="success"){//数据转移完成后才能删除旧表信息
											$.ajax({
												type : "POST",
												url : "GetStaff",
												data : "username="+username+"&name="+name+"&post="+post+"&mail="+mail,
												cache : false,
												async : true,
												success : function(data) {
													if(data=="none"){
														toastr.warning("已经录入通过人员信息");
														$(".mask").fadeOut(700);
														return;
													}
													if(data=="error"){
														toastr.error("录入失败");
														$(".mask").fadeOut(700);
														return;
													}
													toastr.success("完成");
													$("#show").html(data);
													$(".mask").fadeOut(700);
												},
												error:function(){
													toastr.error("服务器通信失败");
													$(".mask").fadeOut(700);
												}
											});
										}else if(data=="error"){
												toastr.clear();
												toastr.warning("人员重复了！该人员已经通过了考试！请注意手机号码是否在录入时误将之前的人员录入！");
												$(".mask").fadeOut(700);
										}else{
											toastr.error("数据迁移失败,操作无法完成");
											$(".mask").fadeOut(700);
											return;
										}
									},
									error:function(){
										toastr.error("服务器通信失败,操作未完成,错误代码500");
										$(".mask").fadeOut(700);
									}
								})
								}, 800);
						}
					},
					cancel:{
						text:"关闭",
						btnClass:"btn",
						action:function(){
							return;
						}
					}
				}
			})
			
			
		})
		//点击不通过按钮
		$(".deleteUser").on("click", function() {
			var string = $(this).attr("id");
			$.confirm({
				icon:"glyphicon glyphicon-exclamation-sign",
				title:"操作确认",
				content:"点击确定将会删除对应人员",
				type:"orange",
				buttons:{
					ok:{
						text:"确定",
						btnClass:"btn-warning",
						action:function(){
							$(".mask").fadeIn(500);
							setTimeout(function(){
								$.ajax({
									type : "POST",
									url : "Delete",
									data : "username="+string+"&judge=judge",
									cache : false,
									async : true,
									success : function(data) {
										if(data=="error"){
											toastr.error("系统异常,删除失败");
											$(".mask").fadeOut(700);
											return;
										}
										$("#show").html(data);
										$(".mask").fadeOut(700);
										toastr.success("操作完成");
									},
									error:function(){
										toastr.error("服务器通信失败,操作无法完成");
										$(".mask").fadeOut(700);
									}
								});
								}, 800);
						}
					},
					cancel:{
						text:"关闭",
						btnClass:"btn",
						action:function(){
							return;
						}
					}
				}
			})
		})
		
		/******分页******/
		$("#next").on("click",function(){
			var page=$(this).attr("name");
			$.ajax({
				type:"POST",
				url:"ShowScore",
				data:"pageNo="+$(this).attr("name"),
				cache:false,
				dataType:"text",
				success:function(data){
					$("#show").html(data);
				},
				error:function(){
					toastr.error("系统异常");
				}
				
			});
			
		});
		
		$("#before").on("click",function(){
			var page=$(this).attr("name");
			$.ajax({
				type:"POST",
				url:"ShowScore",
				data:"pageNo="+$(this).attr("name"),
				cache:false,
				dataType:"text",
				success:function(data){
					$("#show").html(data);
				},
				error:function(){
					toastr.error("系统异常");
				}
				
			});
			
		});
		
		$("#subPage").on("click",function(){
			if(isNaN($("#textpageNo").val())){
				toastr.warning("请输入数字！");
				$("#textpageNo").val("");
				return;
			}
			if($.trim($("#textpageNo").val()).length==0){
				toastr.warning("请输入数字！");
				$("#textpageNo").val("");
				return;
			}
			var page=$("#textpageNo").val();
				$.ajax({
					type:"POST",
					url:"ShowScore",
					data:"pageNo="+$("#textpageNo").val(),
					dataType:"text",
					success:function(data){
						$("#show").html(data);
					},
					error:function(){
						toastr.error("系统异常");
					}
					
				});
				
			});

	});