$(function(){
	
	
	$("#postrequired").on("change",function(){
		if($(this).val()=="0"){
			$("#content").html("");
		}else if($(this).val()=="软件工程师"){
			$.ajax({
				type:"post",
				url:"GetAllRequiredQs",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
		}else if($(this).val()=="硬件工程师"){
			$.ajax({
				type:"post",
				url:"GetAllRequiredQs",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
			
		}else if($(this).val()=="网络工程师"){
			$.ajax({
				type:"post",
				url:"GetAllRequiredQs",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
			
		}else if($(this).val()=="机械工程师"){
			$.ajax({
				type:"post",
				url:"GetAllRequiredQs",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
		}else if($(this).val()=="电气工程师"){
			$.ajax({
				type:"post",
				url:"GetAllRequiredQs",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
		}
	})
	
	//点击综合题出现的效果
	$("#required").on("click",function(){
		$("#type").val("required");
		setTimeout(function(){
			$("#postrequired").val(0);
			$("#postrequired").slideDown(300);
			$("#content").html("");
		}, 300)
		$("#postselect").slideUp(300);
		$("#postselect").val(0);
		
	})
	

	
	
	
	$("#postselect").on("change",function(){
		if($(this).val()=="0"){
			$("#content").html("");
		}else if($(this).val()=="软件工程师"){
			$.ajax({
				type:"post",
				url:"GetAllProEssay",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
		}else if($(this).val()=="硬件工程师"){
			$.ajax({
				type:"post",
				url:"GetAllProEssay",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
			
		}else if($(this).val()=="网络工程师"){
			$.ajax({
				type:"post",
				url:"GetAllProEssay",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
			
		}else if($(this).val()=="机械工程师"){
			$.ajax({
				type:"post",
				url:"GetAllProEssay",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
		}else if($(this).val()=="电气工程师"){
			$.ajax({
				type:"post",
				url:"GetAllProEssay",
				data:"post="+$(this).val(),
				cache:false,
				success:function(data){
					$("#content").html(data);
					$("#content").slideDown(500);
				},
				error:function(){
					toastr.error("服务器异常");
				}
			})
		}
	})
	
	
	//点击专业题出现的效果
	$("#choice").on("click",function(){
		$("#type").val("choice");
		setTimeout(function(){
			$("#postselect").slideDown(300);
			$("#postselect").val(0);
		}, 300)
		$("#postrequired").slideUp(300);
		$("#postrequired").val(0);
		$("#content").html("");
		
	})
	
	$("#single").on("click",function(){
		$("#postselect").slideUp(400);
		$("#type").val("single");
		$.ajax({
			type:"post",
			url:"GetAllSingleQs",
			cache:false,
			success:function(data){
				$("#content").html(data);
				$("#content").slideDown(500);
			},
			error:function(){
				toastr.error("服务器异常");
			}
		})
	})
	
	$("#baseEssay").on("click",function(){
		$("#postselect").slideUp(400);
		$("#type").val("baseEssay");
		$.ajax({
			type:"post",
			url:"GetAllBaseEssay",
			cache:false,
			success:function(data){
				$("#content").html(data);
				$("#content").slideDown(500);
			},
			error:function(){
				toastr.error("服务器异常");
			}
		})
	})
	
})