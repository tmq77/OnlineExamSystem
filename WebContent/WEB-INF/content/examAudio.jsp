<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<script src="JS/audio.js"></script>
<title>考试页面</title>
</head>
<body>

	<div class="reessaycontent">
		<div class="requiredQs">

			<div class="panel panel-default requiredQspos">
				<div class="panel-body audiofont">
						录音是从电视广告中随机截取的一段关于“V&U 面膜”长约 1 分钟的广告。截取后的录音，没有完整主
						题和内容。但有一定的信息量。请认真听录音，然后用简短的语言，重新组织，将内容表述出来.
						（点击开始后自动播放两遍，请不要切换试题）
				</div>
				<div class="form-group">
					<audio controls id="myaudio"> <source src="record.mp3"
						type="audio/mpeg"></audio>
					<textarea class="form-control" rows="10" name="voiceanswer"
						style="font-size: 1em; resize: none" id="oiceanswer"></textarea>
				</div>
			</div>


		</div>


	</div>


</body>
</html>