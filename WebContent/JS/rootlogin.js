$(function(){
	
	$("#rootloginin").on("click",function(){
		if($("#username").val()==""){
			toastr.warning("请输入账号");
			return;
		}
		if($("#password").val()==""){
			toastr.warning("请输入密码");
			return;
		}
		var hash = hex_md5($("#password").val());
		$("#password").val(hash);
		$.ajax({
			type:"post",
			cache:false,
			url:"RootLogin",
			data:"username="+$("#username").val()+"&password="+hash,
			dataType:"text",
			success:function(data){
				if(data=="none"){
					toastr.warning("没有此用户!");
					$("#username").val("");
					$("#password").val("");
				}else if(data=="error"){
					toastr.error("不可预料的错误");
					$("#username").val("");
					$("#password").val("");
				}else if(data=="input"){
					toastr.warning("密码错误");
					$("#password").val("");
				}else{
					toastr.info("登录成功");
					setTimeout(function(){
						$("#loginForm").submit();
					}, 200);
				}
				
			},
			error:function(){
				toastr.error("系统通信失败");
			}
		})
	})
	
	
})