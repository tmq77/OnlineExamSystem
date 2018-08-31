<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="renderer" content="webkit">
<title>在线考试系统</title>
<script>
<!--
$(function(){	
	$(".view").on("click",function(){
		$(this).next().slideToggle(600);
	})
	
	
})
//-->
</script>
<style type="text/css">
.view{
cursor: pointer;
}
</style>
</head>
<body>
	<!-- ----------------------------头部模块------------------------------------- -->
		<div class="block" >

						<div class="panel panel-info">
							<div class="panel-heading view">
								<h2 class="panel-title">录音总结题(点击展开):</h2>
							</div>
							<div class="panel-body" style="display: none">
							<label>参考答案</label>
							<div style="overflow-y: auto; width: 80%;max-height: 80px;word-wrap:break-word;">${ga.vright}</div>
							<label>考生答案</label>
							<div  style="color:blue;resize:none;font-weight: bold;overflow-y: auto; width: 80%;max-height:90px; word-wrap:break-word; ">${ga.vanswer}</div>
							</div>		
						</div>	
				
				<!--———————————————————————————————————————————————————————— -->
			</div>
	
	
			<div class="block" >

						<div class="panel panel-info">
							<div class="panel-heading view">
								<h2 class="panel-title">必答题(点击展开):</h2>
							</div>
							<div class="panel-body" style="display: none">
							<div><h4>${ga.title}</h4></div>
							<label>参考答案</label>
							<div style="overflow-y: auto; width: 80%;max-height: 80px;word-wrap:break-word;">${ga.rright}</div>
							<label>考生答案</label>
							<div style="color:blue;resize:none;font-weight: bold;overflow-y: auto; width: 80%;max-height: 90px;word-wrap:break-word; ">${ga.ranswer}</div>
						</div>
						</div>	
				<!--———————————————————————————————————————————————————————— -->
			</div>
</body>
</html>