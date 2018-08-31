<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<title>基础简答题</title>
<script src="JS/required.js"></script>
</head>
<body>

	<div class="reessaycontent">

		<div class="requiredQs">


<input type="hidden" name="rid" value="${requiredQs.rid}"/><!-- 隐藏题目ID传递给后台 -->
			<div class="panel panel-default requiredQspos">
				<div class="panel-body requiredfont">
					${requiredQs.title}
				</div>
				<div class="form-group">
					<textarea class="form-control" rows="12" name="reanswer"
						style="font-size: 1em;resize:none" id="reanswer"></textarea>
				</div>
			</div>



		</div>
	</div>
</body>
</html>