<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="renderer" content="webkit">
 <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, user-scalable=no">
<title>考试页面</title>
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="CSS/jquery-confirm.min.css">
<link rel="stylesheet" href="CSS/mask.css" type="text/css">
<link rel="stylesheet" href="CSS/test.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.min.js"></script>
<script src="JS/jquery-confirm.min.js"></script>
<script src="JS/test.js"></script>
<script src="JS/time.js"></script>
<script src="JS/sub.js"></script>
</head>
<body>
<nav>
<div class="left">
<div style="padding:1px">
<button type="button" class="btn btn-lg navbtn">
          <span class="glyphicon glyphicon-align-justify"></span>
        </button>   
         <ul class="menu">
     <li><a href="#"  id="audioinfo" class="navmodel">录音总结</a></li>
     <li><a href="#"  id="singleinfo" class="navmodel">逻辑单选</a></li>
     <li><a href="#"  id="baseinfo" class="navmodel">逻辑简答</a></li>
     <li><a href="#" id="proinfo" class="navmodel">专业简答</a></li>
     <li><a href="#" id="reinfo" class="navmodel">必答题</a></li>
     </ul></div></div>  
      
   <div class="right"><div style="padding:16%;"><button class="btn btn-xs subthepaper" style="background:rgb(156, 184, 214);">提交试卷</button></div></div>
    <div class="right" style="margin-left: 10px;font-size:1.2em;font-weight: 600"><span>姓名:</span><span id="nameinfo">${sessionScope.name}</span></div>
	<div class="right" style="font-size:1.2em;color:green;font-weight: 600"><span>剩余时间:</span><span id="timetemp"></span></div>
</nav><!-- 小于810px宽度则显示导航条 -->

<div class="leftmodel">
<div class="leftmodelleft center"><a href="#" class="acolor" id="audio">录音总结</a></div>
<div class="leftmodelleft center"><a href="#" class="acolor" id="baseSingle">逻辑单选</a></div>
<div class="leftmodelleft center"><a href="#" class="acolor" id="baseEssay">逻辑简答</a></div>
<div class="leftmodelleft center"><a href="#" class="acolor" id="proEssay">专业简答</a></div>
<div class="leftmodelleft center"><a href="#" class="acolor" id="requiredQs">必答题</a></div>
<div class="info">
<div class="userinfo">姓名:<div id="name">${sessionScope.name}</div></div>
<div class="timeinfo">剩余时间：<div id="time"></div></div>
</div>
</div>
<form action="GetExamAnswer" method="post" id="form">
<div class="rightmodel" id="examAudio"><%@ include file="examAudio.jsp" %></div>
<div class="rightmodel" id="examBaseSingle"><%@ include file="exam.jsp" %></div>
<div class="rightmodel" id="examEssay"><%@ include file="examEssay.jsp" %></div>
<div class="rightmodel" id="examProEssay"><%@ include file="examProEssay.jsp" %></div>
<div class="rightmodel" id="examRequiredQs"><%@ include file="examRequired.jsp" %></div>
<div class="tip">
<div class="tips">考试已开始<br>请点击左侧边栏选择试题考试。</div>
</div>
</form>


	<!-- 遮罩层 -->
	<div class="mask">
		<div class="maskbg">
			<div class="maskimg">
				<img src="/OnlineExamSystem/images/loading.gif">
			</div>
		</div>
	</div>



<div class="foot"><div class="left footleft"><img src="/OnlineExamSystem/images/logo.png" width="100%" height="100%"></div>
<div class="size left">企业在线笔试系统</div>
<div class="mysub right"><button type="button" class="btn btn-primary btn-lg" id="sub">提交试卷</button></div>

</div>

</body>
</html>