<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="CSS/singleEdit.css" type="text/css">
<script src="JS/singleEdit.js"></script>
<title>修改单选题</title>
</head>
<body>
	<div>
		<c:forEach items="${singleQs}" var="Info" varStatus="vs">
			<div class="singleblock">
				<div style="width: 8%; float: right; font-size: 12px;">
					<a href="#" style="color: #4296E0" class="removesingle"
						id="r_${Info.eid}"> <span class="glyphicon glyphicon-remove"></span>
					</a>
				</div>
				<div style="width: 8%; float: right; font-size: 12px;">
					<a href="#" style="color: #4296E0" class="modifysingle"
						id="m_${Info.eid}"><span class="glyphicon glyphicon-cog"></span></a>
				</div>
				<div style="width: 100%; float: left; margin-top: 3%;"
					id="title_${Info.eid}">${Info.baseSingleTitle}</div>
				<input type="hidden" value="${Info.baseSingleA}"
					id="singleA_${Info.eid}"> <input type="hidden"
					value="${Info.baseSingleB}" id="singleB_${Info.eid}"> <input
					type="hidden" value="${Info.baseSingleC}" id="singleC_${Info.eid}">
				<input type="hidden" value="${Info.baseSingleD}"
					id="singleD_${Info.eid}"> <input type="hidden"
					value="${Info.baseSingleAS}" id="singleAs_${Info.eid}">
			</div>
		</c:forEach>
	</div>

	<!-- ***********分页*************** -->

	<div class="page">
	<div class="Right">
			<button class="btn btn-info btn-block" id="subSearch">搜索</button>
		</div>
		<div class="Right search">
			<input type="text" id="search" class="form-control"
				placeholder="搜索">
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