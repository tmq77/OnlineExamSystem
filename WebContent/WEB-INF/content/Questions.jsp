<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<meta name="renderer" content="webkit">
<title>Insert title here</title>
<!-- Bootstrap -->
      <link  href="CSS/index2.css"  type="text/css" rel="stylesheet">
      <link  href="CSS/index.css"  type="text/css" rel="stylesheet">
  <link href="CSS/jquery.selectlist.css" type="text/css" rel="stylesheet">
     <script type="Text/JavaScript" src="JS/jquery.min.js"></script>
   <script type="Text/JavaScript" src="JS/jquery.selectlist.js"></script>
  <script type="Text/JavaScript" src="JS/Questions.js"></script>
</head>
<body>

<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">添加专业题到题库</a>
			</li>
		</ul>
		<form action="AddQs" method="post">
		<div class="Div">
			<select id="course" name="course">
				<option value="0">请选择试题职位</option>
				<option value="硬件工程师">硬件工程师</option>
				<option value="软件工程师">软件工程师</option>
				<option value="网络工程师">网络工程师</option>
			</select>
			<select id="question_type" name="question_type">
				<option value="0">请选择题目类型</option>
				<option value="1">单项选择</option>
				<option value="2">问答题</option>
			</select>
			<div class="block" id="single">
				<div class="aline">
					<span class="normal_one">题目</span>
					<input type="text" class="one_line" id="single_title" name="sTitle"></input>
				</div>
				<div class="aline">
					<span class="normal_one">A</span>
					<input type="text" class="one_line" id="single_A" name="sOptionA"></input>
				</div>
				<div class="aline">
					<span class="normal_one">B</span>
					<input type="text" class="one_line" id="single_B"  name="sOptionB"></input>
				</div>
				<div class="aline">
					<span class="normal_one">C</span>
					<input type="text" class="one_line" id="single_C"  name="sOptionC"></input>
				</div>
				<div class="aline">
					<span class="normal_one">D</span>
					<input type="text" class="one_line" id="single_D"  name="sOptionD"></input>
				</div>
				<div class="aline">
					<span class="specail_line_one">
						<select id="single_right"  name="single_right">
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
					<textarea type="text" class="many_lines" id="essay_title" name="eTitle"></textarea>
				</div>
				<div class="aline">
					<div class="normal_three">答案</div>
					<textarea type="text" class="many_lines" id="essay_right" name="eRight"></textarea>
				</div>
				<div class="aline">
					<span class="specail_line_three">
					</span>
					<button type="submit" class="submit_button" id="essay_submit">提交</button>
				</div>
			</div>
		</div>
		</form>
	</div>
	
</body>
</html>