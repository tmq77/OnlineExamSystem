$(function(){
	
	//修改信息按钮
	$("#rootmodify").on("click",function(){
		var username=$("#modifyusername").val();
		var password=$("#modifypassword").val();
		if(username==""){
			toastr.warning("请输入账号");
			return;
		}
		if(password==""){
			toastr.warning("请输入密码");
			return;
		}
		
		var usernameold = $("#modifyusername").attr("placeholder");
		$.ajax({
			type:"post",
			url:"ModifyAdmin",
			data:"username="+username+"&password="+hex_md5(password)+"&usernameold="+usernameold,
			cache:false,
			dataType:"text",
			success:function(data){
				if(data=="none"){
					toastr.error("修改失败");
				}else if(data=="error"){
					toastr.warning("修改失败,数据未更新");
				}else{
					toastr.success("修改完成");
					$("body").html(data);
				}
			},
			error:function(){
				toastr.error("修改失败");
			}
		})
	})
	
	//删除管理员
	$(".removeUser").on("click",function(){
		var r = confirm("确定删除吗?")
		if(r==true){
			var username=$(this).attr("id").substring(2);
			$.ajax({
				url:"DeleteAdmin",
				dataType:"text",
				data:"username="+username,
				cache:false,
				type:"post",
				success:function(data){
					if(data=="error"){//录入失败
						toastr.error("删除失败");
					}else if(data=="none"){//后台代码异常
						toastr.warning("服务器异常");
					}else{
						toastr.success("删除完成");
						$("body").html(data);
					}
				},
				error:function(){//返回500状态或者服务器通信失败
					toastr.error("系统异常");
				}
			})
			
		}else{
			return false;
		}
	})
	
	//修改管理员
	$(".modifyUser").on("click",function(){
		var username=$(this).attr("id").substring(2);
		$("#modifyusername").val(username);
		$("#modifyusername").attr("placeholder",username);
		$("#modifypassword").val("");
		$(".alertmodify").slideDown(500);
	})
	
	$(".closemodify").on("click",function(){
		$(".alertmodify").slideUp(500);
		$("#modifyusername").val("");
		$("#modifypassword").val("");
	})
	
	//添加管理员
	$(".addAdmin").on("click",function(){
		$(".alertAdd").slideDown(500);
	})
	
	$(".closeAdd").on("click",function(){
		$("#username").val("");
		$("#password").val("");
		$(".alertAdd").slideUp(500);
	})
	
	$("#rootinsert").on("click",function(){
		var hash = hex_md5($("#password").val());
		$.ajax({
			type:"post",
			url:"AddAdmin",
			cache:false,
			data:"username="+$("#username").val()+"&password="+hash,
			dataType:"text",
			success:function(data){
				if(data=="error"){
					toastr.warning("录入失败");
				}else if(data=="none"){
					toastr.warning("人员重复");
				}else{
						toastr.success("录入完成");
						$(".alertAdd").slideUp(500);
						$("#username").val("");
						$("#password").val("");
						$("body").html(data);
				}
			},
			error:function(){
				toastr.error("系统异常");
			}
		})
	})
})