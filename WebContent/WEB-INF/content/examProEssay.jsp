<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<title>专业简答题</title>
<script src="JS/examPro.js"></script>
</head>
<body>
	<div class="header">
		<ul class="proessaycheck">
			<li class="procheckfont">
				<a href="#" class="proabcolor" id="pro_1">第一题</a>
			</li>
			<li class="procheckfont">
				<a href="#" class="proabcolor" id="pro_2">第二题</a>
			</li>
			<li class="procheckfont">
				<a href="#" class="proabcolor" id="pro_3">第三题</a>
			</li>
		</ul>
	</div>

	<div class="essaycontent">



		<c:forEach items="${proEssay}" var="QsInfo" varStatus="vs">
			<input type="hidden" name="proid${vs.count}"
				value="${QsInfo.essayId}" />
			<div class="proessay" id="proessay_${vs.count}">
				<div class="panel panel-default">
					<div class="panel-body">
						<font>第${vs.count}题：</font>
						<font class="basefont">${QsInfo.eTitle}</font>
					</div>
					<div class="form-group">
						<textarea class="form-control proinput" id="proinput_${vs.count}"
							rows="9" name="proans${vs.count}"
							style="font-size: 3em; resize: none"></textarea>
					</div>
				</div>

				<div class="nextutil">
					<div class="left">
						<button type="button" class="btn btn-primary beforePro"
							name="psoessay_${vs.count}">上一题</button>
					</div>
					<div class="left margleft">
						<button type="button" class="btn btn-primary nextPro"
							name="proessay_${vs.count}">下一题</button>
					</div>
				</div>
			</div>
		</c:forEach>





	</div>

</body>
</html>