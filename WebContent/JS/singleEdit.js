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
	
	
	
	
	//修改试题
	$(".modifysingle").on("click",function(){
		var id = $(this).attr("id").substring(2);
		var eid = id;
		var title = $("#title_"+id).text()
		var singleA = $("#singleA_"+id).val();
		var singleB = $("#singleB_"+id).val();
		var singleC = $("#singleC_"+id).val();
		var singleD = $("#singleD_"+id).val();
		var singleAs = $("#singleAs_"+id).val();
		$.confirm({
			icon:"glyphicon glyphicon-cog",
			title:"修改试题",
			type:"blue",
			content:"<script>$(function(){$('.BasesingleAS').val('"+singleAs+"')})</script>"+
						"<label>题目:</label>"+
						" <input type='text' class='form-control title'  placeholder='输入题目' value='"+title+"'>"+
						"<label>选项A:</label>"+
						"<input type='text' class='form-control singleA' placeholder='输入A选项' value='"+singleA+"'>"+
						"<label>选项B:</label>"+
						"<input type='text' class='form-control singleB'  placeholder='输入B选项' value='"+singleB+"'>"+
						"<label>选项C:</label>"+
						"<input type='text' class='form-control singleC'  placeholder='输入C选项' value='"+singleC+"'>"+
						"<label>选项D:</label>"+
						"<input type='text' class='form-control singleD'  placeholder='输入D选项' value='"+singleD+"'>"+
						"<label>参考答案:</label>"+
						"<select class='form-control BasesingleAS'>"+
						"<option value='A'>A</option>"+
						"<option value='B'>B</option>"+
						"<option value='C'>C</option>"+
						"<option value='D'>D</option>"+
						"</select>",
			buttons:{
				ok:{
					text:"确认",
					btnClass:"btn btn-info",
					action:function(){	
						if($.trim(this.$content.find(".title").val()).length==0||$.trim(this.$content.find(".singleA").val()).length==0||$.trim(this.$content.find(".singleB").val()).length==0||$.trim(this.$content.find(".singleC").val()).length==0||$.trim(this.$content.find(".singleD").val()).length==0){
							$.alert("请填写必填字段");
							return;
						}
						$.ajax({
							type:"post",
							url:"ModifySingle",
							data:"eid="+eid+"&title="+this.$content.find(".title").val()+"&singleA="+this.$content.find(".singleA").val()+"&singleB="+this.$content.find(".singleB").val()+"&singleC="+this.$content.find(".singleC").val()+"&singleD="+this.$content.find(".singleD").val()+"&singleAs="+this.$content.find(".BasesingleAS").val(),
							dataType:"text",
							cache:false,
							success:function(data){
								if(data=="error"){
									$.alert({
										icon:"glyphicon glyphicon-remove",
		    							button:{
		    								text:"关闭"
		    							},
		    						    title: '错误！',
		    						    content: '修改失败！',
		    						    type:"red",
		    						    confirm: function(){
		    						    }
		    						});
								}else if(data=="none"){
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
								}else{
									$.alert({
										icon:"glyphicon glyphicon-ok",
		    							button:{
		    								text:"关闭"
		    							},
		    						    title: '提示信息',
		    						    content: '修改完成',
		    						    type:"green",
		    						    confirm: function(){
		    						    }
		    						});
									$("#content").html(data);
								}
							},
							error:function(){
								$.alert({
									icon:"glyphicon glyphicon-ok",
	    							button:{
	    								text:"关闭"
	    							},
	    						    title: '提示信息',
	    						    content: '系统异常',
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
					action:function(){return;}
				}
				
			}
		})
	})
	
	
	//删除试题
	$(".removesingle").on("click",function(){
		var eid = $(this).attr("id").substring(2);
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
							url:"DeleteSingle",
							data:"eid="+eid,
							dataType:"text",
							cache:false,
							success:function(data){
								if(data=="error"){
									toastr.error("删除失败,系统异常");
								}else if(data=="none"){
									toastr.warning("删除失败,数据错误");
								}else{
									toastr.success("删除成功");
									$("#content").html(data);
								}
							},
							error:function(){
								toastr.error("系统异常");
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
			url:"GetAllSingleQs",
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
			url:"GetAllSingleQs",
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
			url:"GetAllSingleQs",
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