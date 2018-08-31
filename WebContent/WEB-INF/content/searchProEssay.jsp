<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/proEssayEdit.css" type="text/css" rel="stylesheet">
<script src="JS/proEssayEdit.js"></script>
<title>专业简答修改</title>
</head>
<body>
<div>
<c:forEach items="${proEssay}" var="Info" varStatus="vs">
<div class="proEssayBlock">
<div style="width: 8%;float: right;font-size: 12px;text-align: center;"><a href="#" style="color:#4296E0" class="removepro" 
id="d_${Info.essayId}"> <span class="glyphicon glyphicon-remove"></span> </a></div>
<div style="width: 8%;float: right;font-size: 12px;text-align: center;"><a href="#" style="color:#4296E0" class="modifypro" 
id="u_${Info.essayId}"><span class="glyphicon glyphicon-cog"></span></a></div>
<div style="width: 100%;float: left;" >
${Info.etitle}
</div>
<input type="hidden" value="${Info.eright}" id="pro_${Info.essayId}">
<input type="hidden" value="${Info.etitle}" id="title_${Info.essayId}">
</div>
</c:forEach>
</div>




</body>
</html>