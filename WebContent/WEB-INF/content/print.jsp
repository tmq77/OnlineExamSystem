<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <link rel="stylesheet" type="text/css" href="CSS/demo.css"> -->
<script type="text/javascript" src="JS/FileSaver.js"></script>
<script type="text/javascript" src="JS/jquery.wordexport.js"></script>
<script>
	$(function() {
		$("#printExam").on("click", function() {
			$("#export").wordExport($("#examName").text());
		});
		$("#printexit").on("click", function() {
			$(".tempmask").fadeOut(500);
		})

		var arrRans = $(".rightAns")
		var arrUans = $(".userAns")
		var count = 0;
		$.each(arrRans, function(i) {
			if (arrRans[i].innerText != arrUans[i].innerText) {
				arrUans[i].setAttribute("style", "color:red;font-weight:900;");
				arrUans[i].innerText += " 错误";
			} else {
				count += 5;
			}
		})

		$("#singlescore").html(
				"单选得分:<font style='color:red;font-weight:900;font-size:18px;'>"
						+ count + "</font>分");

	})
</script>
<title>打印预览</title>
</head>
<body>
	<div style="margin-left: 2%">
		<button class="btn btn-info btn-lg" id="printExam">
			<span class="glyphicon glyphicon-floppy-save"></span>导出word文档
		</button>
		<button class="btn btn-default" id="printexit">关闭</button>
	</div>
	<div id="export">
		<p id="examName" style="font-weight: 600; font-size: 19px;">${name}的笔试试卷</p>
		<hr>
		<p>
			<b>逻辑单选题</b><br>
			<span id="singlescore"></span>
		</p>
		<c:forEach items="${singleQs}" var="Info" varStatus="vs">
			<p>
				<b>&nbsp;${vs.count}:</b>${Info.singletitle}<br> <b>&nbsp;A:</b>${Info.singleA}<br>
				<b>&nbsp;B:</b>${Info.singleB}<br> <b>&nbsp;C:</b>${Info.singleC}<br>
				<b>&nbsp;D:</b>${Info.singleD}<br> <b style="font-size: 17px">参考答案:</b><span
					class="rightAns">${Info.singleAs}</span><br> <b
					style="font-size: 17px">考生答案:</b><span class="userAns">${Info.singleUs}</span>
			</p>
			<hr>
		</c:forEach>
		<p>
			<b style="font-weight: 600; font-size: 19px;">专业简答题</b>
		</p>
		<c:forEach items="${proExam}" var="Info" varStatus="vs">
			<p>
				<b style="font-size: 18px;color:gray">专业简答${vs.count}:</b><br>${Info.eTitle}<br> <b
					style="font-size: 17px">参考答案:</b><br>${Info.eRight}<br><br> <b
					style="font-size: 17px">考生答案:</b><br><font style="color:blue">${Info.answer}</font>
			</p>
			<hr>
		</c:forEach>

		<p>
			<b style="font-weight: 600; font-size: 19px;">逻辑简答题</b>
		</p>
		<c:forEach items="${baseExam}" var="Info" varStatus="vs">
			<p>
				<b style="font-size: 18px;color:gray">逻辑简答${vs.count}:</b><br>${Info.eTitle}<br><br> <b
					style="font-size: 17px">参考答案:</b><br>${Info.eRight}<br><br> <b
					style="font-size: 17px">考生答案:</b><br><font style="color:blue">${Info.answer}</font>
			</p>
			<hr>
		</c:forEach>

		<p>
			<b style="font-weight: 600; font-size: 19px;">录音以及必答题</b>
		</p>
		<br>
		<p>
			<b style="font-size: 17px">录音题参考答案:</b><br><br>${requiredExam.vright}<br><br>
			<b style="font-size: 17px">录音题考生答案:</b><br><br>${requiredExam.vanswer}<br>
			<b style="font-size: 17px">专业必答题:</b><br><br>${requiredExam.title}<br>
			<b style="font-size: 17px">参考答案:</b><br>${requiredExam.rright}<br><br>
			<b style="font-size: 17px">考生答案:</b><br><font style="color:blue">${requiredExam.ranswer}</font>
		</p>
		<hr>

	</div>
</body>
</html>