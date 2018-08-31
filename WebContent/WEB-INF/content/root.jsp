<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="CSS/root.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.js"></script>
<link href="CSS/toastr.css" rel="stylesheet" />
<script src="JS/toastr.min.js"></script>
<script src="JS/md5.js"></script>
<script src="JS/root.js"></script>
<script>
<!--   
toastr.options.positionClass = 'toast-top-full-width';
//-->
</script>
<title>超级管理员页面</title>
</head>
<body>

<div class="rootback">
<div class="rootbody">

<div class="alert alert-info">
	<button type="button" class="btn btn-info addAdmin">
    <span class="glyphicon glyphicon-user"></span>
    添加新的管理员
</button>
</div>

<c:forEach var="Info" items="${admin}" varStatus="vs">
<div class="adminblock">
<div style="width: 10%;float: right;font-size: 14px;"><a href="#" style="color:#C0D9EF" class="removeUser" id="r_${Info.account}"> <span class="glyphicon glyphicon-remove"></span> </a></div>
<div style="width: 10%;float: right;font-size: 14px;"><a href="#" style="color:#C0D9EF" class="modifyUser" id="m_${Info.account}"><span class="glyphicon glyphicon-cog"></span></a></div>
<div style="float: left;width: 100%">管理员账号：</div>
<div style="float: left; width: 100%"><span style="color:#E1E5FD">${Info.account}</span></div>
</div>
</c:forEach>

<!-- 修改人员信息 -->
<div class="alertmodify">
<div style="text-align: center;font-size: 21px;color: #E7E7F5;font-weight: 900;border-bottom: 1px solid #3A80C6;">修改管理员	<div style="float: right"><a href="#" class="closemodify" style="text-decoration: none;color:#CFE3F5">&times;</a></div></div>
<div style="width: 90%;margin-left: 5%;margin-top: 12%;">
			<div class="input-group">
				<span class="input-group-addon" style="background-color: rgba(92, 169, 247, 0.48);border: blue;box-shadow:1px 3px 5px #3F5D79"><span class="glyphicon glyphicon-user"></span></span> <input type="text"
					class="form-control" id="modifyusername">
			</div>
			
			<div class="input-group" style="margin-top: 7%">
				<span class="input-group-addon" style="background-color: rgba(92, 169, 247, 0.48);border: blue;box-shadow:1px 3px 5px #3F5D79"><span class="glyphicon glyphicon-log-in"></span></span> <input type="password"
					class="form-control" placeholder="输入密码" id="modifypassword">
			</div>
			<div style="width: 70%;margin-left: 15%;margin-bottom: 5%;margin-top: 17%">
			<button class="btn btn-block btn-default" id="rootmodify">录入</button>
			</div>
			</div>
</div>




<!-- 录入人员信息 -->
<div class="alertAdd">
<div style="text-align: center;font-size: 21px;color: #E7E7F5;font-weight: 900;border-bottom: 1px solid #3A80C6;">新增管理员	<div style="float: right"><a href="#" class="closeAdd" style="text-decoration: none;color:#CFE3F5">&times;</a></div></div>
<div style="width: 90%;margin-left: 5%;margin-top: 12%;">
			<div class="input-group">
				<span class="input-group-addon" style="background-color: rgba(92, 169, 247, 0.48);border: blue;box-shadow:1px 3px 5px #3F5D79"><span class="glyphicon glyphicon-user"></span></span> <input type="text"
					class="form-control" placeholder="输入账号" id="username">
			</div>
			
			<div class="input-group" style="margin-top: 7%">
				<span class="input-group-addon" style="background-color: rgba(92, 169, 247, 0.48);border: blue;box-shadow:1px 3px 5px #3F5D79"><span class="glyphicon glyphicon-log-in"></span></span> <input type="password"
					class="form-control" placeholder="输入密码" id="password">
			</div>
			<div style="width: 70%;margin-left: 15%;margin-bottom: 5%;margin-top: 17%">
			<button class="btn btn-block btn-default" id="rootinsert">录入</button>
			</div>
			</div>
</div>

</div>



</div>

</body>
</html>