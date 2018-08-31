<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="renderer" content="webkit">
 <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, user-scalable=no">
 <meta  http-equiv="Pragma"  content="no-cache">  
 <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/jquery-confirm.min.js"></script>
<script src="JS/bootstrap.js"></script>
<script src="JS/toastr.min.js"></script>
<script src="JS/admin.js"></script>
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<link href="CSS/toastr.css" rel="stylesheet" />
<link rel="stylesheet" href="CSS/jquery-confirm.min.css">
<link rel="stylesheet" href="CSS/admin.css" type="text/css">
<title>后台管理页面</title>
<script type="text/javascript">
<!--   
toastr.options.positionClass = 'toast-top-full-width';
//-->
 </script>
</head>
<body>
<div class="backpage"></div>
<nav>
<div class="Left">
<div style="padding:1px">
<button type="button" class="btn btn-lg navbtn">
          <span class="glyphicon glyphicon-align-justify"></span>
        </button>   
         <ul class="menu">
     <li><a href="#"  id="userinfo" class="navmodel">笔试人员信息</a></li>
     <li><a href="#"  id="scoreinfo" class="navmodel">查看笔试成绩</a></li>
     <li><a href="#"  id="passinfo" class="navmodel">通过人员信息</a></li>
     <li><a href="#" id="questioninfo" class="navmodel">录入试题信息</a></li>
     <li><a href="#" id="exameditinfo" class="navmodel">修改试题信息</a></li>
     </ul></div></div>  
      
   <div class="Right"><div style="padding:16%;"><button class="btn btn-xs exit" style="background:rgb(156, 184, 214);">退出登录</button></div></div>
    

</nav><!-- 小于810px宽度则显示导航条 -->

<div class="top">
<div class="Left" style="margin-left: 10%;color:#DBEFF7;font-weight: 700;"><h4>企业在线笔试系统</h4></div>
<div class="Right" style="margin-right: 11%"><div style="padding:16%;"><button class="btn btn-xs exit" style="background:rgb(156, 184, 214);">退出登录</button></div></div>
</div>

<div class="left">
<div style="width: 94%;margin-left:6%;height: 30%;padding: 8%;"><div class="imgstyle"><img src="/OnlineExamSystem/images/binglogo.png" width="100%" height="100%"></div></div>
<div class="leftmodel" style="border-top: 1px #00A0E9 solid;"><div class="acolor"><a href="#" class="aoption" id="modify">笔试人员信息</a></div></div>
<div class="leftmodel"><div class="acolor"><a href="#" class="aoption" id="score">查看笔试成绩</a></div></div>
<div class="leftmodel"><div class="acolor"><a href="#" class="aoption" id="pass">通过人员信息</a></div></div>
<div class="leftmodel"><div class="acolor"><a href="#" class="aoption" id="question">录入试题信息</a></div></div>
<div class="leftmodel"><div class="acolor"><a href="#" class="aoption" id="examedit">修改试题信息</a></div></div>
</div>

<div class="right">
<div id="show"></div>
</div>

</body>
</html>