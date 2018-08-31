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
<script src="JS/jquery-ui.js"></script>
<script src="JS/modify.js"></script>
<link rel="stylesheet" href="CSS/jquery-ui.css" />
<script>
$(function() {
    $("td").tooltip();
  });
</script>
<title>信息查看</title>
</head>
<body>

	<!-- 遮罩层 -->
	<div class="mask">
		<div class="maskbg">
			<div class="maskimg">
				<img src="/OnlineExamSystem/images/loading.gif">
			</div>
		</div>
	</div>





	<div>
		<div class="alert alert-info alert-dismissable">
		<button type="button" class="btn btn-info addUser" style="font-family: 	YouYuan;">
    <span class="glyphicon glyphicon-user"></span>
    添加
</button>
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times</button>
			点击添加笔试人员信息
		</div>
		<table class="table table-striped" width="100%" id="mytable">
			<caption align="top">应试者信息</caption>
			<thead>
				<tr>
					<th  class="info" width="15%"><span class="glyphicon glyphicon-user"></span>姓名</th>
					<th  class="info" width="25%"><span class="glyphicon glyphicon-phone"></span>账号</th>
					<th class="info" width="15%"><span class="glyphicon glyphicon-lock"></span>密码</th>
					<th class="info" width="15%"><span class="glyphicon glyphicon-list-alt"></span>职位</th>
					<th class="info" width="15%"><span class="glyphicon glyphicon-flag"></span>状态</th>
					<th class="info" width="15%"><span class="glyphicon glyphicon-wrench"></span>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${info}" var="dataInfo" varStatus="vs">
					<tr class="mytr">
						<td title="录入时间:${dataInfo.time}">${dataInfo.name}</td>
						<td title="录入时间:${dataInfo.time}">${dataInfo.username}</td>
						<td title="录入时间:${dataInfo.time}">${dataInfo.password}</td>
						<td title="录入时间:${dataInfo.time}">${dataInfo.post}</td>
						<td class="info statusflag" id="e_${dataInfo.username}" title="录入时间:${dataInfo.time}">${dataInfo.status}</td>
						<td>
							<table>
								<tr>
									<td><button
										class="btn btn-default form-control deleteUser" id="${dataInfo.username}"  title="录入时间:${dataInfo.time}">删除</button></td>
									<td>
											<button class="btn btn-info form-control update" id="${dataInfo.username}" title="录入时间:${dataInfo.time}"> 修改</button>
									</td>
								</tr>
							</table>
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