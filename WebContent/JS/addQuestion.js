$(function(){
	$("#reset").on("click",function(){
		$("#file").val("");
	})
	
	$("#upload").on("click",function(){
		if($("#file").val()==""){
			toastr.warning("请选择文件");
			return;
		}
		
		if($("#file").val().substring($("#file").val().length-4,$("#file").val().length)!=".xls"){
			toastr.warning("请上传指定文件");
			return;
		}
		var form1=$("#uploadform")[0];
		var formData = new FormData(form1);
		$.ajax({
			url:"SingleUpload",
			data:formData,  //使用HTML5的formdata不需要指定参数名了,因为name="file"已经包含在内
			type:"post",
			processData: false,
		    contentType: false,
		    success:function(data){
		    	if(data.substring(0,3)=="suc"){
		    	toastr.success("上传完成，试题正在自动解析到题库中，请勿关闭页面。。");
		    	$("#file").val("");
		    	var str = data.substring(3)+"model.xls";  //用于知道需要解析的文件的名字
		    	
		    	$.ajax({
		    		url:"ParseXls",
		    		type:"post",
		    		cache:false,
		    		data:"name="+str,
		    		success:function(data){
		    		if(data=="error"){
		    			toastr.error("格式不对或者未找到对应名为model.xls的文件,请检查");
		    		}else if(data[0]=="success"){
		    			
		    			setTimeout(function(){
		    				toastr.success("试题解析完成");
		    			}, 800)
		    			
		    			toastr.clear();
		    			setTimeout(function(){
		    				if(data[1]){
			    				$.each(data,function(i){
			    					if(i!=0){
			    						toastr.options={
			    								 timeOut: "10000", 
			    						},
			    						toastr.warning(data[i]);
			    					}
			    					
			    				})
			    			}
		    			}, 1000)
		    			
		    		}else{
		    			toastr.error("严重异常，不可预料的错误");
		    		}
		    			
		    		},
		    		error:function(){
		    			toastr.error("系统异常");
		    		}
		    	})
		    	
		    	
		    	
		    	
		    	}else if(data=="error"){
		    		toastr.error("严重错误，缓存目录已毁坏，请联系管理员");
		    	}
		    },
		    error:function(){
		    	toastr.error("服务器异常");
		    }
		})
	})
	
	//综合题的录入
	$("#allSub").on("click",function(){
		if($("#allTitle").val()==""||$.trim($("#allTitle").val())==""){
			toastr.warning("请输入题目");
			return;
		}
		if($("#allRight").val()==""||$.trim($("#allRight").val())==""){
			toastr.warning("请输入参考答案");
			return;
		}
		$.ajax({
			type:"post",
			dataType:"text",
			cache:false,
			url:"AddRequired",
			data:"course="+$("#course").val()+"&allTitle="+$("#allTitle").val()+"&allRight="+$("#allRight").val(),
			success:function(data){
				if(data=="error"){
					toastr.warning("录入出错,请刷新后重试");
					return;
				}
				if(data=="none"){
					toastr.error("系统异常");
					return;
				}
				toastr.success("录入完成,可继续录入下一题");
				//完成后清空数据
				$("#allTitle").val("");
				$("#allRight").val("");
				
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	//专业问答题的录入
	$("#proSub").on("click",function(){
		if($("#eTitle").val()==""||$.trim($("#eTitle").val())==""){
			toastr.warning("请输入题目");
			return;
		}
		if($("#eRight").val()==""||$.trim($("#eRight").val())==""){
			toastr.warning("请输入参考答案");
			return;
		}
		$.ajax({
			type:"post",
			dataType:"text",
			cache:false,
			url:"AddQs",
			data:"question_type=2&course="+$("#course").val()+"&eTitle="+$("#eTitle").val()+"&eRight="+$("#eRight").val(),
			success:function(data){
				if(data=="error"){
					toastr.warning("录入出错,请刷新后重试");
					return;
				}
				if(data=="none"){
					toastr.error("系统异常");
					return;
				}
				toastr.success("录入完成,可继续录入下一题");
				//完成后清空数据
				$("#eTitle").val("");
				$("#eRight").val("");
				
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	//基础问答录入
	$("#baseSub").on("click",function(){
		var v = $.trim($("#essayTitle").val());
		var a = $.trim($("#essayRight").val());
		if($("#essayTitle").val()==""||v==""){
			toastr.warning("请输入题目");
			return;
		}
		if($("#essayRight").val()==""||a==""){
			toastr.warning("请输入参考答案");
			return;
		}
		$.ajax({
			type:"post",
			url:"AddBase",
			dataType:"text",
			cache:false,
			data:"Qs_type="+$("#baseQs").val()+"&essayTitle="+$("#essayTitle").val()+"&essayRight="+$("#essayRight").val(),
			success:function(data){
				if(data=="error"){
					toastr.warning("录入出错,请刷新后重试");
					return;
				}
				if(data=="none"){
					toastr.error("系统异常");
					return;
				}
				toastr.success("录入完成,可继续录入下一题");
				//完成后清空数据
				$("#essayTitle").val("");
				$("#essayRight").val("");
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	//单选题录入
	$("#singleSub").on("click",function(){
		if($("#single_title").val()==""||$.trim($("#single_title").val())==""){
			toastr.warning("请输入题目");
			return;
		}
		if($("#single_A").val()==""||$.trim($("#single_A").val())==""){
			toastr.warning("请输入A选项");
			return;
		}
		if($("#single_B").val()==""||$.trim($("#single_B").val())==""){
			toastr.warning("请输入B选项");
			return;
		}
		if($("#single_C").val()==""||$.trim($("#single_C").val())==""){
			toastr.warning("请输入C选项");
			return;
		}
		if($("#single_D").val()==""||$.trim($("#single_D").val())==""){
			toastr.warning("请输入D选项");
			return;
		}
		if($("#single_right").val()==0){
			toastr.warning("请选择正确答案");
			return;
		}
		$.ajax({
			type:"post",
			url:"AddBase",
			dataType:"text",
			data:"Qs_type="+$("#baseQs").val()+"&BaseSingleTitle="+$("#single_title").val()+"&BaseSingleA="+$("#single_A").val()+"&BaseSingleB="+$("#single_B").val()+"&BaseSingleC="+$("#single_C").val()+"&BaseSingleD="+$("#single_D").val()+"&BasesingleAS="+$("#single_right").val(),
			cache:false,
			success:function(data){
				if(data=="error"){
					toastr.warning("录入出错,请刷新后重试");
					return;
				}
				if(data=="none"){
					toastr.error("系统异常");
					return;
				}
				toastr.success("录入完成,可继续录入下一题");
				//提交成功后清除数据
				$("#single_title").val("");
				$("#single_A").val("");
				$("#single_B").val("");
				$("#single_C").val("");
				$("#single_D").val("");
				$("#single_right").val(0);
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
			
		
	})
	
	//选择题型的下拉菜单
	$("#myClass").on("change",function(){
		if($(this).val()=="none"){
			$(".baseQs").fadeOut(300);
			$(".course").fadeOut(300);
			$(".proEssay").fadeOut(300);
			$(".baseEssay").fadeOut();
			$(".allEssay").fadeOut(300);
			$(".single").fadeOut(300);
			//清空数据
			$("#eTitle").val("");
			$("#eRight").val("");
			$("#essayTitle").val("");
			$("#essayRight").val("");
			$("#allTitle").val("");
			$("#allRight").val("");
			$("#single_title").val("");
			$("#single_A").val("");
			$("#single_B").val("");
			$("#single_C").val("");
			$("#single_D").val("");
			$("#single_right").val(0);
			$("#baseQs").val(0);
			$("#course").val(0);
		}
		if($(this).val()=="base"){ //选择了基础逻辑题
			$(".course").fadeOut(300);
			$(".proEssay").fadeOut(300);
			$(".allEssay").fadeOut(300);
			$(".single").fadeOut(300);
			//清空数据
			$("#eTitle").val("");
			$("#eRight").val("");
			$("#essayTitle").val("");
			$("#essayRight").val("");
			$("#single_title").val("");
			$("#single_A").val("");
			$("#single_B").val("");
			$("#single_C").val("");
			$("#single_D").val("");
			$("#single_right").val(0);
			setTimeout(function(){
				$(".baseQs").fadeIn(300);
			}, 300)
			
		}
		if($(this).val()=="pro"){//选择专业题
			$(".baseQs").fadeOut(300);
			$(".baseEssay").fadeOut();
			$(".allEssay").fadeOut(300);
			$(".single").fadeOut(300);
			//清空数据
			$("#eTitle").val("");
			$("#eRight").val("");
			$("#essayTitle").val("");
			$("#essayRight").val("");
			$("#allTitle").val("");
			$("#allRight").val("");
			$("#single_title").val("");
			$("#single_A").val("");
			$("#single_B").val("");
			$("#single_C").val("");
			$("#single_D").val("");
			$("#single_right").val(0);
			$("#baseQs").val(0);
			$("#course").val(0);
			setTimeout(function(){
				$(".course").fadeIn(300);	
			}, 300)
			
			
		}
		if($(this).val()=="all"){
			$(".proEssay").fadeOut(300);
			$(".baseQs").fadeOut(300);
			$(".baseEssay").fadeOut(300);
			$(".single").fadeOut(300);
			//清空数据
			$("#eTitle").val("");
			$("#eRight").val("");
			$("#essayTitle").val("");
			$("#essayRight").val("");
			$("#allTitle").val("");
			$("#allRight").val("");
			$("#single_title").val("");
			$("#single_A").val("");
			$("#single_B").val("");
			$("#single_C").val("");
			$("#single_D").val("");
			$("#single_right").val(0);
			$("#baseQs").val(0);
			$("#course").val(0);
			setTimeout(function(){
				$(".course").fadeIn(300);
			}, 300);
			
		}
	})
	
	//选择了职位,显示对应的题目录入框
	$("#course").on("change",function(){
		//清空数据
		$("#eTitle").val("");
		$("#eRight").val("");
		$("#essayTitle").val("");
		$("#essayRight").val("");
		$("#allTitle").val("");
		$("#allRight").val("");
		$("#single_title").val("");
		$("#single_A").val("");
		$("#single_B").val("");
		$("#single_C").val("");
		$("#single_D").val("");
		$("#single_right").val(0);
		$("#baseQs").val(0);
		if($("#myClass").val()=="pro"){
			$(".allEssay").fadeOut();
			$(".baseEssay").fadeOut();
			$(".single").fadeOut();
			$(".proEssay").fadeIn();
		}
		//选择了综合题,再选择了必答,显示录入题目的录入框
		if($("#myClass").val()=="all"){
			$(".baseEssay").fadeOut();
			$(".proEssay").fadeOut();
			$(".single").fadeOut();
			$(".allEssay").fadeIn();
	}
		if($(this).val()==0){
			$(".baseEssay").fadeOut();
			$(".proEssay").fadeOut();
			$(".allEssay").fadeOut();
			$(".single").fadeOut();
		}
		
		
	})
	
	//选择了逻辑题,再选择了简答题,显示录入题目的录入框
	$("#baseQs").on("change",function(){
		//清空数据
		$("#eTitle").val("");
		$("#eRight").val("");
		$("#essayTitle").val("");
		$("#essayRight").val("");
		$("#allTitle").val("");
		$("#allRight").val("");
		$("#single_title").val("");
		$("#single_A").val("");
		$("#single_B").val("");
		$("#single_C").val("");
		$("#single_D").val("");
		$("#single_right").val(0);
		if($(this).val()=="3"){//选择了essay---基础问答
			$(".allEssay").fadeOut();
			$(".proEssay").fadeOut();
			$(".single").fadeOut();
			$(".baseEssay").fadeIn();
		}
		if($(this).val()=="2"){//选择了基础单选题---single
			$(".allEssay").fadeOut();
			$(".proEssay").fadeOut();
			$(".baseEssay").fadeOut();
			$(".single").fadeIn();
		}
	})
	
	

	
})