<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/baseEssayEdit.css" type="text/css" rel="stylesheet">
<script src="JS/baseEssayEdit.js"></script>
<title>基础简答修改</title>
</head>
<body>
	<div>
		<c:forEach items="${BaseEssay}" var="Info" varStatus="vs">
			<div class="baseEssayBlock">
				<div
					style="width: 8%; float: right; font-size: 12px; text-align: center;">
					<a href="#" style="color: #4296E0" class="removebase"
						id="r_${Info.essayId}"> <span
						class="glyphicon glyphicon-remove"></span>
					</a>
				</div>
				<div
					style="width: 8%; float: right; font-size: 12px; text-align: center;">
					<a href="#" style="color: #4296E0" class="modifybase"
						id="m_${Info.essayId}"><span class="glyphicon glyphicon-cog"></span></a>
				</div>
				<div style="width: 100%; float: left;">${Info.essayTitle}</div>
				<input type="hidden" value="${Info.essayRight}"
					id="base_${Info.essayId}"> <input type="hidden"
					value="${Info.essayTitle}" id="title_${Info.essayId}">
			</div>
		</c:forEach>
	</div>


	<!-- ***********分页*************** -->





	<div class="page">
		<div class="Right">
			<button class="btn btn-info btn-block" id="subSearch">搜索</button>
		</div>
		<div class="Right search">
			<input type="text" id="search" class="form-control" placeholder="搜索">
		</div>

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
		<div class="Right" style="margin-right: 1%; padding-top: 1%">共${pageSize}页</div>
		<div
			style="color: rgb(0, 160, 233); margin-right: 1%; padding-top: 1%"
			class="Right">
			第<span id="mypage">${page}</span>页
		</div>
	</div>
	<!-- ***********分页*************** -->

</body>
</html>