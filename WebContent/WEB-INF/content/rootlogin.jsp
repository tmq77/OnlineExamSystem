<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="CSS/rootlogin.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.js"></script>
<link href="CSS/toastr.css" rel="stylesheet" />
<script src="JS/toastr.min.js"></script>
<script src="JS/md5.js"></script>
<script src="JS/rootlogin.js"></script>
<script>
<!--   
toastr.options.positionClass = 'toast-top-full-width';
//-->
</script>
<title>超级管理员登录界面</title>
</head>
<body>
	<div class="rootback">
	<div class="roottitle">超级管理员登录</div>
		<div class="loginDiv">
<div style="margin-top: 12%">
<form action="RootLogin" method="post" id="loginForm">
			<div style="width: 90%;margin-left: 5%;">
			<div class="input-group">
				<span class="input-group-addon" style="background-color: rgba(92, 169, 247, 0.48);border: blue;box-shadow:1px 3px 5px #3F5D79"><span class="glyphicon glyphicon-user"></span></span> <input type="text"
					class="form-control" placeholder="输入账号" id="username" name="username">
			</div>
			
			<div class="input-group" style="margin-top: 7%">
				<span class="input-group-addon" style="background-color: rgba(92, 169, 247, 0.48);border: blue;box-shadow:1px 3px 5px #3F5D79"><span class="glyphicon glyphicon-log-in"></span></span> <input type="password"
					class="form-control" placeholder="输入密码" id="password" name="password">
			</div>
			</div>
	</form>	
			<div style="width: 70%;margin-left: 15%;margin-bottom: 5%;margin-top: 17%">
			<button class="btn btn-block btn-default" id="rootloginin">登录</button>
			</div>
</div>
		</div>
	</div>
</body>
</html>