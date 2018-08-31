<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<meta name="renderer" content="webkit">
<script src="JS/addQuestion.js"></script>
<title>录入试题信息</title>
</head>
<body>
<div class="main">

<div class="myClass">
<select class="form-control" id="myClass">
<option value="none">请选择题目类别</option>
<option value="base">逻辑题</option>
<option value="pro">专业题</option><!-- 专业题只有简答题 -->
<option value="all">综合题</option>
</select>
</div>
<div class="baseQs">
<select class="form-control" id="baseQs" name="Qs_type">
<option value="0">请选择题型</option>
<option value="2">单选题</option>
<option value="3">简答题</option>
</select>
</div>
<!-- 选择专业题或者综合题显示这个下拉菜单 -->
<div class="course">
<select id="course" name="course" class="form-control">
				<option value="0">请选择试题职位</option>
				<option value="硬件工程师">硬件工程师</option>
				<option value="软件工程师">软件工程师</option>
				<option value="网络工程师">网络工程师</option>
				<option value="机械工程师">机械工程师</option>
				<option value="电气工程师">电气工程师</option>
			</select>
</div>

<!-- 专业简答题的录入的div -->
<div class="proEssay">
		 <div class="form-group">
    		<label for="name" style="font-size:18px;font-family: YouYuan;color:rgba(0, 62, 239, 0.67);">专业简答</label>
    		<textarea class="form-control" rows="5" name="eTitle" id="eTitle"></textarea>
  		</div>
        <div class="form-group">
    		<label for="name" style="font-size:18px;font-family: YouYuan;color:rgba(0, 62, 239, 0.67);">参考答案</label>
    		<textarea class="form-control" rows="5" name="eRight" id="eRight"></textarea>
  		</div>
        <div style="margin-bottom: 18%;">
        <button class="btn btn-info Right" id="proSub">提交</button><!-- 专业简答对应专业简答的action -->
        </div>
</div>

<!-- 基础简答题的录入的div -->
<div class="baseEssay">
		 <div class="form-group">
    		<label for="name" style="font-size:18px;font-family: YouYuan;color:rgba(0, 62, 239, 0.67);">基础简答</label>
    		<textarea class="form-control" rows="5" name="essayTitle" id="essayTitle"></textarea>
  		</div>
        <div class="form-group">
    		<label for="name" style="font-size:18px;font-family: YouYuan;color:rgba(0, 62, 239, 0.67);">参考答案</label>
    		<textarea class="form-control" rows="5" name="essayRight" id="essayRight"></textarea>
  		</div>
        <div style="margin-bottom: 18%;">
        <button class="btn btn-info Right" id="baseSub">提交</button><!-- 基础简答对应基础简答的action -->
        </div>
</div>

<!-- 必答题的录入的div -->
<div class="allEssay">
		 <div class="form-group">
    		<label for="name" style="font-size:18px;font-family: YouYuan;color:rgba(0, 62, 239, 0.67);">基础简答</label>
    		<textarea class="form-control" rows="5" name="allTitle" id="allTitle"></textarea>
  		</div>
        <div class="form-group">
    		<label for="name" style="font-size:18px;font-family: YouYuan;color:rgba(0, 62, 239, 0.67);">参考答案</label>
    		<textarea class="form-control" rows="5" name="allRight" id="allRight"></textarea>
  		</div>
        <div style="margin-bottom: 18%;">
        <button class="btn btn-info Right" id="allSub">提交</button><!-- 必答题对应必答题的action -->
        </div>
</div>
<!-- 基础单选的录入div -->
<div class="single">

<div style="margin-bottom: 10%;">

<div class="Left">
<form enctype="multipart/form-data" id="uploadform" action="SingleUpload" method="post">
<input type="file" name="file" id="file" class="form-control"  accept="application/vnd.ms-excel">
</form>
</div>
<div class="Left">
<button class="btn btn-default" id="reset">重置</button>
<button class="btn btn-info" id="upload">上传</button>
<span><a href="ModelDownload">model.xls点击下载模板</a></span>
</div>
</div>
<br><br>

		<div class="input-group">
            <span class="input-group-addon" style="color:blue">Q</span>
            <input type="text" class="form-control" id="single_title" name="BaseSingleTitle" placeholder="输入题目">
        </div><br>
		<div class="input-group">
            <span class="input-group-addon" style="color:blue">A</span>
            <input type="text" class="form-control" id="single_A"  name="BaseSingleA" placeholder="输入A选项">
        </div><br>
        <div class="input-group">
            <span class="input-group-addon" style="color:blue">B</span>
            <input type="text" class="form-control" id="single_B"  name="BaseSingleB" placeholder="输入B选项">
        </div><br>
        <div class="input-group">
            <span class="input-group-addon" style="color:blue">C</span>
            <input type="text" class="form-control" id="single_C"  name="BaseSingleC" placeholder="输入C选项">
        </div><br>
        <div class="input-group">
            <span class="input-group-addon" style="color:blue">D</span>
            <input type="text" class="form-control" id="single_D"  name="BaseSingleD" placeholder="输入D选项">
        </div><br>
        	<div style="width: 35%;margin-bottom: 18%;" class="Right" >
						<select id="single_right" class="form-control" name="BasesingleAS">
							<option value="0">请选择正确答案</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
						</select> 
						<br>
					<button class="btn btn-info Right"  id="singleSub">提交</button>
				</div>

</div>

</div>
</body>
</html>