<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>在线笔试系统首页</title>

<!-- Bootstrap -->

<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="CSS/index.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.js">
</script>
<script src="JS/login.js"></script>
<link href="CSS/toastr.css" rel="stylesheet" />
<script src="JS/toastr.min.js"></script>
<script type="text/javascript">
        toastr.options.positionClass = 'toast-top-full-width';
 </script>
</head>
<body style="background-color: rgb(249, 249, 249);">
	<div>
		<nav class="navbar navbar-default">
		<div class="container-fluid" style="margin: auto; padding: 15px 50px">
			<div class=" ">
				<a id="top_nav" style="text-decoration: none;"><h1 class="title">企业在线笔试系统</h1></a>
			</div>
		</div>
		</nav>
		<br>
		<br>
		<br>
		<div class="container-fluid  test" id="mid">
			<div class="panel panel-default">
				<div class="panel-heading" Style="font-weight: bold;text-align: center;">考生登录</div>
				<div class="panel-body">
					 <font color="red" style="font-weight: bold;"><h3>${tip}</h3></font>
					<!-- 登录提示信息 -->
					<form method="post" action="LoginAction" id="form">

						<div class="input-group">
							<span class="input-group-addon">账号</span> <input type="text"
								class="form-control" placeholder="输入账号(必填)" required="required"
								name="username" id="username">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">密码</span> <input type="password"
								class="form-control" placeholder="输入密码(必填)" required="required"
								name="password" id="password">
						</div>
						<br>
					
								<input type="hidden" name="role" value="employee" id="role">

				<div class="pad">
						
						<button type="button"  id="sub" class="btn btn-default btn-block">进入考试</button>
						
						
						</div>
						</form>
						</div>
						
					
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom"
			role="navigation">
		<div class="container">
			<ul class="list-inline text-right">
				<li>联系我们</li>
				<li>|</li>
				<li>电话：12345678</li>
				<li>|</li>
				<li>邮箱：xyz@abc.com</li>
				<li>|</li>
				<li>地址：address</li>
			</ul>

		</div>
		</nav>



</body>
</html>