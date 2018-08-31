$(function(){
	
	//点击搜索按钮
	$("#subSearch").on("click",function(){
		if($("#search").val()==""){
			toastr.warning("请输入内容");
			$("#search").val("");
			return;
		}
		if($.trim($("#search").val()).length==0){
			toastr.warning("请输入内容");
			$("#search").val("");
			return;
		}
		var type = $("#type").val();
		$.ajax({
			url:"Search",
			data:"str="+$("#search").val()+"&type="+type,
			dataType:"text",
			cache:false,
			success:function(data){
				if(data=="error"){
					toastr.warning("搜索失败");
					return;
				}else if(data=="none"){
					toastr.warning("没有匹配的搜索结果");
					return;
				}
				$("#content").html(data);
			},
			error:function(){
				toastr.error("服务器通信失败");
			}
		})
	})
	
	
	
	
	
	$(".modifybase").on("click",function(){
		var id = $(this).attr("id").substring(2);
		var essayId = id;
		var essayRight = $("#base_"+id).val();
		var essayTitle = $("#title_"+id).val();
		
		$.confirm({
			icon:"glyphicon glyphicon-cog",
			title:"修改试题",
			type:"blue",
			content:"<label>基础简答</label>"+
			"<textarea class='form-control essayTitle' rows='4'>"+essayTitle+"</textarea>"+
			"<label>参考答案</label>"+
			"<textarea class='form-control essayRight' rows='4'>"+essayRight+"</textarea>",
			buttons:{
				ok:{
					text:"确认",
					btnClass:"btn btn-info",
					action:function(){
						if($.trim(this.$content.find(".essayTitle").val()).length==0||$.trim(this.$content.find(".essayRight").val()).length==0){
							$.alert("请输入内容");
							return;
						}
						$.ajax({
							type:"post",
							dataType:"text",
							cache:false,
							url:"ModifyBaseEssay",
							data:"essayId="+essayId+"&essayTitle="+this.$content.find(".essayTitle").val()+"&essayRight="+this.$content.find(".essayRight").val(),
							success:function(data){
								if(data=="none"){
									$.alert({
										icon:"glyphicon glyphicon-remove",
		    							button:{
		    								text:"关闭"
		    							},
		    						    title: '错误！',
		    						    content: '数据错误！',
		    						    type:"red",
		    						    confirm: function(){
		    						    }
		    						});
								}else if(data=="error"){
									$.alert({
										icon:"glyphicon glyphicon-remove",
		    							button:{
		    								text:"关闭"
		    							},
		    						    title: '错误！',
		    						    content: '系统异常',
		    						    type:"red",
		    						    confirm: function(){
		    						    }
		    						});
								}else{
									$.alert({
										icon:"glyphicon glyphicon-ok",
		    							button:{
		    								text:"关闭"
		    							},
		    						    title: '提示信息',
		    						    content: '更新完成',
		    						    type:"blue",
		    						    confirm: function(){
		    						    }
		    						});
									$("#content").html(data);
								}
							},
							error:function(){
								$.alert({
									icon:"glyphicon glyphicon-remove",
	    							button:{
	    								text:"关闭"
	    							},
	    						    title: '错误！',
	    						    content: '服务器通信失败',
	    						    type:"red",
	    						    confirm: function(){
	    						    }
	    						});
							}
						})
					}
				},
				cancel:{
					text:"取消",
					btnClass:"btn btn-default",
					action:function(){return},
				}
			}
		})


	})
	
	//删除基础简答
	$(".removebase").on("click",function(){
		var id = $(this).attr("id").substring(2);
		$.confirm({
			icon:"glyphicon glyphicon-floppy-remove",
			title:"删除确认",
			content:"您正在删除当前试题",
			type:"orange",
			buttons:{
				ok:{
					text:"确定",
					btnClass:"btn-warning",
					action:function(){
						$.ajax({
							type:"post",
							url:"DeleteBaseEssay",
							data:"essayId="+id,
							dataType:"text",
							cache:false,
							success:function(data){
								if(data=="none"){
									toastr.warning("数据异常,删除失败");
								}else if(data=="error"){
								toastr.error("服务器错误");	
								}else{
									toastr.success("删除成功");
									$("#content").html(data);
								}
							},
							error:function(){
								toastr.error("服务器异常");
							}
						})
					}
				},
				cancel:{
					text:"取消",
					btnClass:"btn",
					action:function(){
						return;
					}
				}
			}
		})
			
			
		
	})
	
	
	
	$("#before").on("click",function(){
		$.ajax({
			type:"POST",
			url:"GetAllBaseEssay",
			data:"pageNo="+$(this).attr("name"),
			cache:false,
			dataType:"text",
			success:function(data){
				$("#content").html(data);
			},
			error:function(){
				toastr.error("服务器异常");
			}
			
		});
		
	});
	
	$("#next").on("click",function(){
		$.ajax({
			type:"POST",
			url:"GetAllBaseEssay",
			data:"pageNo="+$(this).attr("name"),
			cache:false,
			dataType:"text",
			success:function(data){
				$("#content").html(data);
			},
			error:function(){
				toastr.error("服务器异常");
			}
			
		});
		
	});
	
	$("#subPage").on("click",function(){
	if(isNaN($("#textpageNo").val())){
		toastr.warning("请输入数字！");
		$("#textpageNo").val("");
		return;
	}
	if($.trim($("#textpageNo").val()).length==0){
		toastr.warning("请输入内容");
		$("#textpageNo").val("");
		return;
	}
		
		$.ajax({
			type:"POST",
			url:"GetAllBaseEssay",
			data:"pageNo="+$("#textpageNo").val(),
			dataType:"text",
			success:function(data){
				$("#content").html(data);
			},
			error:function(){
				toastr.error("服务器异常");
			}
		});
		
	});
})