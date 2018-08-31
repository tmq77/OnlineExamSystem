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
<script src="JS/judge.js"></script>
<title>批改试卷</title>
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
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times</button>
			查看考试信息，点击对应试题可以查看答题情况。
		</div>
		<table class="table table-striped" width="100%">
			<caption align="top">考试信息</caption>
			<thead>
				<tr>
					<th class="info"><span class="glyphicon glyphicon-user"></span>姓名</th>
					<th class="info"><span class="glyphicon glyphicon-list-alt"></span>职位</th>
					<th class="info"><span class="glyphicon glyphicon-font"></span>逻辑单选</th>
					<th class="info"><span class="glyphicon glyphicon-align-left"></span>逻辑简答</th>
					<th class="info"><span
						class="glyphicon glyphicon-align-center"></span>专业简答</th>
					<th class="info"><span class="glyphicon glyphicon-align-right"></span>综合题</th>
					<th class="info" width="20%"><span
						class="glyphicon glyphicon-wrench"></span>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${exam}" var="examInfo" varStatus="vs">
					<tr class="mytr">
						<td>${examInfo.name}</td>
						<td class="info">${examInfo.post}</td>
						<td>${examInfo.baseSingle}分</td>
						<td><a name="${examInfo.account}" href="#"
							style="color: #40B4D7;" class="base">逻辑简答</a></td>
						<td><a href="#" name="${examInfo.account}"
							style="color: #40B4D7;" class="pro">专业简答</a></td>
						<td><a href="#" name="${examInfo.account}"
							style="color: #40B4D7;" class="all">综合题</a></td>
						<td>
							<button class="btn btn-default deleteUser"
								id="${examInfo.account}">删除</button>
							<button class="btn btn-info passUser" id="${examInfo.account}"
								name="${examInfo.name}" value="${examInfo.post}"
								title="${examInfo.email}">通过</button>

						</td>
					</tr>


				</c:forEach>
				<!-- --------------------------------------------------------------- -->
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


	<div class="modal" id="myModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header"></div>
				<div class="modal-body" id="showContent"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

</body>
</html>