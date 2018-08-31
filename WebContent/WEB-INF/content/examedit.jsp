<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="CSS/examedit.css" type="text/css">
<script src="JS/examedit.js"></script>
<title>修改试题</title>
</head>
<body>
	<div class="alert alert-info">
		请选择题目类型:
		<div>
		<input type="hidden" id="type" value="">
		<button type="button" class="btn btn-info" id="single">
			<span class="glyphicon glyphicon-edit"></span>单选题
		</button>
		<button type="button" class="btn btn-info" id="baseEssay">
			<span class="glyphicon glyphicon-edit"></span>逻辑简答
		</button>
			<button type="button" class="btn btn-info" id="choice">
				<span class="glyphicon glyphicon-edit"></span>专业题
			</button>
			<button type="button" class="btn btn-info" id="required">
				<span class="glyphicon glyphicon-edit"></span>综合题
			</button>
			<select id="postselect">
			<option value="0">选择职位</option>
			<option value="软件工程师">软件工程师</option>
			<option value="硬件工程师">硬件工程师</option>
			<option value="网络工程师">网络工程师</option>
			<option value="机械工程师">机械工程师</option>
			<option value="电气工程师">电气工程师</option>
			</select>
			<select id="postrequired">
			<option value="0">选择职位</option>
			<option value="软件工程师">软件工程师</option>
			<option value="硬件工程师">硬件工程师</option>
			<option value="网络工程师">网络工程师</option>
			<option value="机械工程师">机械工程师</option>
			<option value="电气工程师">电气工程师</option>
			</select>
		</div>
		
	</div>


	<div class="content" id="content">
	
	</div>

</body>
</html>