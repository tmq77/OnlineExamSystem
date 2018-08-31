<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="CSS/singleEdit.css" type="text/css">
<script src="JS/singleEdit.js"></script>
<title>搜索单选题</title>
</head>
<body>
<div>
<c:forEach items="${single}" var="Info" varStatus="vs">
<div class="singleblock">
<div style="width: 8%;float: right;font-size: 12px;"><a href="#" style="color:#4296E0" class="removesingle" 
id="r_${Info.eid}"> <span class="glyphicon glyphicon-remove"></span> </a></div>
<div style="width: 8%;float: right;font-size: 12px;"><a href="#" style="color:#4296E0" class="modifysingle" 
id="m_${Info.eid}"><span class="glyphicon glyphicon-cog"></span></a></div>
<div style="width: 100%; float: left;margin-top: 3%; "id="title_${Info.eid}">${Info.baseSingleTitle}</div>
<input type="hidden" value="${Info.baseSingleA}" id="singleA_${Info.eid}" >
<input type="hidden" value="${Info.baseSingleB}" id="singleB_${Info.eid}" >
<input type="hidden" value="${Info.baseSingleC}" id="singleC_${Info.eid}" >
<input type="hidden" value="${Info.baseSingleD}" id="singleD_${Info.eid}" >
<input type="hidden" value="${Info.baseSingleAS}" id="singleAs_${Info.eid}" >
</div>
</c:forEach>
</div>




</body>
</html>