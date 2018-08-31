$(function(){
	
	$("#sub").on("click",function(){
		
		if($("#username").val()==""){
			toastr.warning('用户名不能为空');
			return false;
		}else if($("#password").val()==""){
			toastr.warning('密码不能为空');
			return false;
		}else{
			var password = $("#password").val();
			if($("#role").val()=="admin"){
				password = hex_md5($("#password").val());
			}
			
			$.ajax({
				type : "POST",
				url : "LoginAction",
				data : "username="+$("#username").val()+"&password="+password+"&role="+$("#role").val(),
				cache : false,
				dataType: "text",
				success : function(data) {
					if(data=="error"){
						toastr.error('密码错误');
						$("#password").val("");
						$("#password").focus();
						return false;
					}else if(data=="notadmin"){
						toastr.info('您不是管理员');
						$("#password").val("");
						$("#username").val("");
						return false;
					}else if(data=="noaccess"){
						toastr.info('您没有考试资格');
						$("#password").val("");
						$("#username").val("");
						return false;
					}else if(data=="wrong"){
						toastr.info('请勿重复考试');
						$("#password").val("");
						$("#username").val("");
						return false;
					}else{
						toastr.success('登录成功');
						if($("#role").val()=="admin"){
							$("#password").val(password);
						}
						setTimeout(function(){
							$("#form").submit();
						}, 700);
					}
					},
					error:function(){
						alert("通信失败");
					}
	
					
			});
		}
		
	})
	
})