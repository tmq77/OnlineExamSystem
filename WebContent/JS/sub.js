
$(function() {
	var full = sessionStorage.getItem("full"); // 切换全屏的次数
	full = parseInt(full);
	var initheight = $(window).height(); // 屏幕初始高度，整个屏幕的
	// test.jsp右半部分页面切换效果
	$("#baseSingle").on("click", function() {
		requestFullScreen();
		$(".rightmodel").hide();
		$(".tip").hide();
		/*
		 * $.ajax({ url: 'exam', cache: false, success: function (html) {
		 * $('#examBaseSingle').html(html); } });
		 */
		$("#examBaseSingle").show();
	});
	$("#baseEssay").on("click", function() {
		requestFullScreen();
		$(".rightmodel").hide();
		$(".tip").hide();
		$("#examEssay").show();

	});
	$("#proEssay").on("click", function() {
		requestFullScreen();
		$(".rightmodel").hide();
		$(".tip").hide();
		$("#examProEssay").show();
	});
	$("#requiredQs").on("click", function() {
		requestFullScreen();
		$(".rightmodel").hide();
		$(".tip").hide();
		$("#examRequiredQs").show();
	});
	$("#audio").on("click", function() {
		requestFullScreen();
		$(".rightmodel").hide();
		$(".tip").hide();
		$("#examAudio").show();
	});

	// 全屏
	function requestFullScreen() {
		var de = document.documentElement;
		if (de.requestFullscreen) {
			de.requestFullscreen();
		} else if (de.mozRequestFullScreen) { // moz webkit ms是考虑到的浏览器的兼容
			de.mozRequestFullScreen();
		} else if (de.webkitRequestFullScreen) {
			de.webkitRequestFullScreen();
		} else if (de.msRequestFullscreen) {
			de.msRequestFullscreen();
		}
	}

	window.onresize = function() { // 一旦调整了屏幕大小

		if ((window.screen.height - window.outerHeight) == 0) { // 全屏下不作操作

		} else {
			full = full + 1;
			sessionStorage.setItem("full", full);
			if (sessionStorage.getItem("full") == 5) {
				subPaper();
			}
			$(".tips").html("请点击左侧试卷栏返回全屏,如果仍不能点击，请再点一次试卷栏");
			$(".tip").show();
		}
	}

	$("#sub").on("click", function() {
		$.confirm({
			icon:"glyphicon glyphicon-question-sign",
			title : "确定提交?",
			content : "<font style='font-weight:800'>确定提交试卷吗？如果试题栏未全部变成绿色,则代表有试题未作答。</font>",
			type : "blue",
			buttons : {
				ok : {
					text : "确定",
					btnClass : "btn-info",
					action : function() {
						$(".mask").fadeIn(500);
						setTimeout(function() {
							$(".mask").fadeOut(600);
							getAnswer();
						}, 700);
					}
				},
				cancel : {
					text : "关闭",
					btnClass : "btn",
					action : function() {
						return;
					}
				}
			}
		})

	});

	// 提交试卷
	function getAnswer() {
		// 使用exam.jsp中的hidden input的值来判断是否重复提交，弃用---刷新后会失效
		/*
		 * var token = $("#token").val(); if(token=="t"){
		 * $("#sub").addClass("disabled"); $("#sub").html("已提交");
		 * alert("请勿重复提交"); return; }
		 */
		var token = sessionStorage.getItem("subtoken");
		if (token == "sub") {
			$("#sub").addClass("disabled");
			$("#sub").html("已提交");
			$.alert({
				button : {
					text : "关闭",
				},
				icon : "	glyphicon glyphicon-exclamation-sign",
				title : '重复提交！',
				content : '<font style="font-weight:800">请勿重复提交</font>',
				type : "red",
				confirm : function() {
				}
			})
			return;
		}
		var answer = document.getElementsByTagName("input");
		var result = "";
		var index = 0;
		for (var i = 0; i < 80; i++) { // 一共80个radio
			if (answer[i].checked) {// 选中的就计数加1，满20才能提交
				index++;
			}
		}
		if (index != 20) {
			$.alert({
				button : {
					text : "关闭",
				},
				icon : "	glyphicon glyphicon-exclamation-sign",
				title : '请完成作答！',
				content : '<font style="font-weight:800">请完成作答</font>',
				type : "red",
				confirm : function() {
				}
			})
			return;
		}

		for (var i = 0; i < 80; i++) { // 获取答案
			if (answer[i].checked) {
				result += answer[i].value + ",";
			}
		}
		/* $("#token").val("t"); */
		sessionStorage.setItem("subtoken", "sub");
		$("#result").val(result);
		$("#form").submit();

	}

	// 时间到，提交
	function subPaper() {
		/*
		 * var token = $("#token").val(); if(token=="t"){
		 * $("#sub").addClass("disabled"); return; }
		 */
		var token = sessionStorage.getItem("subtoken");
		if (token == "sub") {
			$("#sub").addClass("disabled");
			$("#sub").html("已提交");
			return;
		}

		var answer = document.getElementsByTagName("input");
		var result = "";
		for (var i = 0; i < 80; i += 4) {
			if (answer[i].checked || answer[i + 1].checked
					|| answer[i + 2].checked || answer[i + 3].checked) {
				for (j = i; j < i + 4; j++) {
					if (answer[j].checked) {
						result += answer[j].value + ",";
					}
				}
			} else {
				result += "n" + ",";
			}
		}
		/* $("#token").val("t"); */
		sessionStorage.setItem("subtoken", "sub");
		$("#result").val(result);
		$("#form").submit();
	}

})
