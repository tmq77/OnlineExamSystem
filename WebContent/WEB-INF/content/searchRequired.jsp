<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/requiredEdit.css" type="text/css" rel="stylesheet">
<script src="JS/requiredEdit.js"></script>
<title>综合题修改</title>
</head>
<body>
<div>
<c:forEach items="${required}" var="Info" varStatus="vs">
<div class="requiredBlock">
<div style="width: 8%;float: right;font-size: 12px;text-align: center;"><a href="#" style="color:#4296E0" class="removerequired" 
id="r_${Info.rid}"> <span class="glyphicon glyphicon-remove"></span> </a></div>
<div style="width: 8%;float: right;font-size: 12px;text-align: center;"><a href="#" style="color:#4296E0" class="modifyrequired" 
id="c_${Info.rid}"><span class="glyphicon glyphicon-cog"></span></a></div>
<div style="width: 100%;float: left;" >
${Info.title}
</div>
<input type="hidden" value="${Info.rright}" id="re_${Info.rid}">
<input type="hidden" value="${Info.title}" id="title_${Info.rid}">
</div>
</c:forEach>
</div>




</body>
</html>