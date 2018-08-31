<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<title>信息确认</title>

<!-- Bootstrap -->

<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="CSS/index.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.js"></script>

<script>

$(function(){
	$("#alt").on("click",function(){
		$("#myModal").modal("show");
	});
	
	$("#confirm").on("click",function(){
		sessionStorage.setItem("time", 60);
		sessionStorage.setItem("full", 0);
		sessionStorage.setItem("subtoken", "wait");
		document.getElementById("form").submit();
	});
});
</script>
<style type="text/css">
.backbefore {
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	width: 100%;
	height: 100%;
	position: fixed;
	-webkit-filter: blur(8px);
	-moz-filter: blur(8px);
	-o-filter: blur(8px);
	-ms-filter: blur(8px);
	filter: blur(8px);
	background: rgba(48, 159, 224, 0.62);
}
.info{
border-radius:20px;
position:absolute;
top:15%;
width: 60%; 
margin-left: 20%;
z-index:1000;
background-color: rgba(249, 249, 249, 0.12);
-webkit-box-shadow:0 0 10px rgba(0, 204, 204, .5);  
  -moz-box-shadow:0 0 10px rgba(0, 204, 204, .5);  
  box-shadow:0 0 45px white; 
}
</style>
</head>
<body style="font-family: Microsoft Yahei; font: bolder;">
<div>
	<div class="backbefore"></div>
	<div class="info">
		<div>
			<table class="table">
				<tbody>
					<tr style="font-family: YouYuan; font: bold; font-size: 25px">
						<td>姓名</td>
						<td>账号</td>
						<td>职位</td>
					</tr>
					<tr>
						<td>${sessionScope.name}</td>
						<td>${sessionScope.account}</td>
						<td>${sessionScope.postc}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="width: 70%; margin-left: 42%; margin-top: 15%;margin-bottom: 3%;">
			<form action="/OnlineExamSystem/GetExamQs" method="post" id="form">
			</form>
			<button id="alt" class="btn" style="background-color: rgba(97, 153, 202, 0.64)">确认并考试</button>
		</div>

	</div>
	
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static" data-show="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel"
						style="font-family: Microsoft Yahei">注意事项</h4>
				</div>
				<div class="modal-body">
					<div style="font-size: 16px; font-family: Microsoft Yahei">
						<font style="font-size: 28px">注意事项：</font>
						<p>①:考试过程中不要退出，否则将会没有成绩</p>
						<p>②:考试总时间60分钟</p>
						<p>③:试题分为:逻辑单选20题、专业简答3题、逻辑简答3题、听力1题和必答1题</p>
						<p>④:考试过程中遇到问题请联系管理员</p>
						<p class="warn">⑤:点击试卷会进入全屏,不要刷新浏览器,否则已完成的试题将会被清空</p>
						<p class="warn">⑥:三次切出全屏系统会自动帮你提交试卷</p>
						<p class="warn">⑦:开始考试前请关闭其他浏览器网页标签,保证当前只有一个页面</p>
						<p class="warn">⑧:本系统需要在1024*768分辨率以上的设备上运行,1440以上宽屏效果最佳</p>
						<p class="warn">⑨:点击确认后如果退出考试则视为放弃,无法再次考试。</p>
					</div>
				</div>
				<div class="modal-footer">
					<button id="confirm" class="btn btn-info">确定</button>
					<button class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	
	
</div>




	






</body>
</html>