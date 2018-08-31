<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="CSS/modify.css" type="text/css">
<link rel="stylesheet" href="CSS/mask.css" type="text/css">
<script src="JS/jquery.shCircleLoader-min.js"></script>
<script src="JS/showAllStaff.js"></script>
<title>信息查看</title>
</head>
<body>

<div class="waitcircle"></div>

	<!-- 遮罩层 -->
	<div class="mask">
		<div class="maskbg">
			<div class="maskimg">
				<img src="/OnlineExamSystem/images/loading.gif">
			</div>
		</div>
	</div>
<div class="tempmask">
<div class="maskback"></div>
<div class="printtemp"></div>
</div>
	<div>
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times</button>
				<button type="button" class="btn btn-info" id="setMail">
          <span class="glyphicon glyphicon-pencil"></span>设置管理员邮箱
        </button>
			点击查看试卷可以查看整张试卷并且可以选择导出到本地，点击邮箱可以发送邮件到对应账号;
		</div>
		<table class="table table-striped" width="100%" id="mytable">
			<caption align="top">应试者信息</caption>
			<thead>
				<tr>
					<th class="info"><span class="glyphicon glyphicon-user"></span>姓名</th>
					<th class="info" ><span class="glyphicon glyphicon-phone"></span>手机号</th>
					<th class="info"><span class="glyphicon glyphicon-envelope" ></span>邮箱</th>
					<th class="info"><span class="glyphicon glyphicon-list-alt"></span>职位</th>
					<th class="info"><span class="glyphicon glyphicon-wrench"></span>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${staff}" var="dataInfo" varStatus="vs">
					<tr class="mytr">
						<td class="passName">${dataInfo.name}</td>
						<td class="info">${dataInfo.phone}</td>
						<td><a href="#" id="${dataInfo.email}" class="sendEmail">${dataInfo.email}</a></td>
						<td class="passPost">${dataInfo.post}</td>
						<td>
							<button class="btn btn-default deleteUser"  id="${dataInfo.phone}">删除</button>
							<button class="btn btn-info print"  id="${dataInfo.phone}" name="${dataInfo.name}">查看试卷</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<div class="modifydiv" style="display: none;">
		<div class="Right">
			<input type="button" class="btn btn-default" value=提交 id="subPage">
		</div>
		<div class="Right textpageNo">
			<input type="text" class="form-control" id="textpageNo"
				placeholder="跳转">
		</div>
		<div class="Right" style="margin-right: 1%;">
			<button class="btn btn-default " id="next" name="${page+1}">下一页</button>
		</div>
		<div class="Right" style="margin-right: 1%;">
			<button class="btn btn-default" id="before" name="${page-1}">上一页</button>
		</div>
		<div class="Right" style="margin-right: 1%; padding-top: 2%">共${pageSize}页</div>
		<div
			style="color: rgb(0, 160, 233); margin-right: 1%; padding-top: 2%"
			class="Right">
			第<span id="mypage">${page}</span>页
		</div>
				

		</div>
	</div>



</body>
</html>