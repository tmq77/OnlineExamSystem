<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="renderer" content="webkit">
  <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, user-scalable=no">
 <meta  http-equiv="Pragma"  content="no-cache">  
 <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="CSS/login.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.js"></script>
<script src="JS/md5.js"></script>
<script src="JS/login.js"></script>
<link href="CSS/toastr.css" rel="stylesheet" />
<script src="JS/toastr.min.js"></script>
<title>登录</title>
<script type="text/javascript">
        toastr.options.positionClass = 'toast-top-right';
 </script>
</head>
<body>
<div class="back">
<div class="title">
企业在线<br>
&nbsp;&nbsp;&nbsp;&nbsp;笔试系统后台
</div>
<div class="center bg">

	<div class="box">
	<div class="index"></div>
	<div class="loginbox">
	<div class="margin">
<form action="LoginAction" method="post" id="form">
		<div class="input-group text">
            <span class="input-group-addon color"><font style="color: #2F465B;font-weight: bolder">账号</font></span>
            <input type="text" class="form-control" name="username" placeholder="用户名" required="required" id="username"/>
        </div>
        <div class="input-group text">
            <span class="input-group-addon color"><font style="color: #2F465B;font-weight: bolder">密码</font></span>
            <input type="password" class="form-control" name="password" placeholder="密码" required="required" id="password"/>
        </div>
        <div class="btn-group ah">
    		<a href="#" class="btn btn-default loginbutton" id="sub"><b>登&nbsp;&nbsp;录</b></a>
		</div>
		 <input type="hidden" name="role" value="admin" id="role">
</form>
</div>
	</div>
	
	</div>
</div>
</div>
</body>
</html>