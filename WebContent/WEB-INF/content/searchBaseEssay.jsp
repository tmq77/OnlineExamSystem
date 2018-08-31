<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/baseEssayEdit.css" type="text/css" rel="stylesheet">
<script src="JS/baseEssayEdit.js"></script>
<title>基础简答搜索</title>
</head>
<body>
<div>
<c:forEach items="${baseEssay}" var="Info" varStatus="vs">
<div class="baseEssayBlock">
<div style="width: 8%;float: right;font-size: 12px;text-align: center;"><a href="#" style="color:#4296E0" class="removebase" 
id="r_${Info.essayId}"> <span class="glyphicon glyphicon-remove"></span> </a></div>
<div style="width: 8%;float: right;font-size: 12px;text-align: center;"><a href="#" style="color:#4296E0" class="modifybase" 
id="m_${Info.essayId}"><span class="glyphicon glyphicon-cog"></span></a></div>
<div style="width: 100%;float: left;">
${Info.essayTitle}
</div>
<input type="hidden" value="${Info.essayRight}" id="base_${Info.essayId}">
<input type="hidden" value="${Info.essayTitle}" id="title_${Info.essayId}">
</div>
</c:forEach>
</div>



</body>
</html>