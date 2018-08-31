<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="renderer" content="webkit">
<title>客观单选</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<script src="JS/index.js"></script>
<script src="JS/prefixfree.min.js"></script>
<script src="JS/exam.js"></script>
</head>
<body>
	<div class="header">
		<ul class="check">
			<li class="checkfont">
				<a href="#base_1" class="abcolor" id="single_1">1</a>
			</li>
			<li class="checkfont">
				<a href="#base_2" class="abcolor" id="single_2">2</a>
			</li>
			<li class="checkfont">
				<a href="#base_3" class="abcolor" id="single_3">3</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_4">4</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_5">5</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_6">6</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_7">7</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_8">8</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_9">9</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_10">10</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_11">11</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_12">12</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_13">13</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_14">14</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_15">15</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_16">16</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_17">17</a>
			</li>
			<li class="checkfont" >
				<a href="#" class="abcolor" id="single_18">18</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_19">19</a>
			</li>
			<li class="checkfont">
				<a href="#" class="abcolor" id="single_20">20</a>
			</li>
		</ul>
	</div>


	<div class="content">

		<c:forEach items="${baseQs}" var="QsInfo" varStatus="vs">

			<div class="baseQs" id="base_${vs.count}">
				<div class="question">
					<div class="questionpos">

						<div class="qsIndex">第${vs.count}题：</div>
						<div class="examfont">${QsInfo.baseSingleTitle}</div>
						<!-- 题干 -->
					</div>
				</div>
				<!-- end of question -->

				<div class="option">
					<!-- 选项 -->
					<div class="examoption">
						<div class="martop">
							<div class="left">
									<input type="radio" value="A" name="${vs.index}"
										class="inputmarg">
								</div>
								<div class="left leftfont">A:</div>
								<div class="left marg">${QsInfo.baseSingleA}</div> 
						</div>
						<div class="martop">
							<div class="left">
									<input type="radio" value="B" name="${vs.index}"
										class="inputmarg">
								</div>
								<div class="left leftfont">B:</div>
								<div class="left marg">${QsInfo.baseSingleB}</div> 
						</div>
						<div class="martop">
							<div style="float: left;">
									<input type="radio" value="C" name="${vs.index}"
										class="inputmarg">
								</div>
								<div class="left leftfont">C:</div>
								<div class="left marg">${QsInfo.baseSingleC}</div>
						</div>
						<div class="martop">
							<div style="float: left;">
									<input type="radio" value="D" name="${vs.index}"
										class="inputmarg">
								</div>
								<div class="left leftfont">D:</div>
								<div class="left marg">${QsInfo.baseSingleD}</div> 
						</div>
					</div>
					<div class="next">
						<div class="left">
							<button type="button" class="btn btn-primary  beforeQs"
								name="base_${vs.count}">上一题</button>
						</div>
						<div class="left margleft">
							<button type="button" class="btn btn-primary nextQs"
								name="base_${vs.count}">下一题</button>
						</div>
					</div>
				</div>
				<!-- end of option -->

			</div>
			<!-- end of baseQs -->
		</c:forEach>

	</div>
	<!-- end of content -->

	<input type="hidden" name="result" value="" id="result">
	<!-- <input type="hidden" id="token" value="f" /> -->  <!-- 注释之前使用这个隐藏的元素判断是否重复提交，但是刷新后会失效弃用 -->

</body>
</html>