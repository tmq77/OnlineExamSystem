<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<meta name="renderer" content="webkit">
<title>Insert title here</title>
<link  href="CSS/index2.css"  type="text/css" rel="stylesheet">
 <link href="CSS/jquery.selectlist.css" type="text/css" rel="stylesheet">
     <script type="Text/JavaScript" src="JS/jquery.min.js"></script>
   <script type="Text/JavaScript" src="JS/jquery.selectlist.js"></script>
  <script type="Text/JavaScript" src="JS/base_Question.js"> </script>
</head>
<body>


<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">添加基础题到题库</a>
			</li>
		</ul>
		<form action="AddBase" method="post">
		<div class="Div">
			<select id="Qs_type" name="Qs_type">
				<option value="0">请选择题目类型</option>
				<option value="1">情商题</option>
				<option value="2">逻辑单选题</option>
				<option value="3">逻辑问答题</option>
			</select>
			<div class="block" id="EQ_single">
				<div class="aline">
					<span class="normal_one">题目</span>
					<input type="text" class="one_line" id="EQ_single_title" name="eq_Title"></input>
				</div>
				<div class="aline">
					<span class="normal_one">A</span>
					<input type="text" class="one_line" id="EQ_single_A" name="eq_Single_A"></input>
				</div>
				<div class="aline">
					<span class="normal_one">B</span>
					<input type="text" class="one_line" id="EQ_single_B" name="eq_Single_B"></input>
				</div>
				<div class="aline">
					<span class="normal_one">C</span>
					<input type="text" class="one_line" id="EQ_single_C"  name="eq_Single_C"></input>
				</div>
				<div class="aline">
					<button type="submit" class="submit_button"  id="EQ_single_submit">提交</button>
				</div>
			</div>
			
			<div class="block" id="single">
				<div class="aline">
					<span class="normal_one">题目</span>
					<input type="text" class="one_line" id="single_title" name="BaseSingleTitle"></input>
				</div>
				<div class="aline">
					<span class="normal_one">A</span>
					<input type="text" class="one_line" id="single_A"  name="BaseSingleA"></input>
				</div>
				<div class="aline">
					<span class="normal_one">B</span>
					<input type="text" class="one_line" id="single_B" name="BaseSingleB"></input>
				</div>
				<div class="aline">
					<span class="normal_one">C</span>
					<input type="text" class="one_line" id="single_C" name="BaseSingleC"></input>
				</div>
				<div class="aline">
					<span class="normal_one">D</span>
					<input type="text" class="one_line" id="single_D" name="BaseSingleD"></input>
				</div>
				<div class="aline">
					<span class="specail_line_one">
						<select id="single_right" name="BasesingleAS">
							<option value="0">请选择正确答案</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
						</select> 
					</span>
					<button type="submit" class="submit_button"  id="single_submit">提交</button>
				</div>
			</div>
			
			
			<div class="block" id="essay">
				<div class="aline">
					<div class="normal_three">题目</div>
					<textarea class="many_lines" id="essay_title" name="essayTitle"></textarea>
				</div>
				<div class="aline">
					<div class="normal_three">答案</div>
					<textarea class="many_lines" id="essay_right" name="essayRight"></textarea>
				</div>
				<div class="aline">
					<button type="submit" class="submit_button" id="essay_submit">提交</button>
				</div>
			</div>
		</div>
		</form>
	</div>
	
</body>
</html>