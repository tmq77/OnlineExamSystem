	$(function() {
		//人员信息大于6条，则显示分页工具栏
		if ($(".mytr").length >= 6) {
			$(".modifydiv").css("display", "block");
		} else if ($("#mypage").text() > 1) {
			$(".modifydiv").css("display", "block");
		}
		
		var arr = $(".statusflag");  //替换 已考试 的颜色
		$.each(arr,function(i){
			if(arr[i].innerText=="已考试"){
				this.setAttribute("style","color:#0192BD");
			}
		})
		
		//添加人员信息
		$(".addUser").on("click",function(){
		
			$.confirm({
				icon:"glyphicon glyphicon-user",
				title:"添加新的应试者信息",
				type:"blue",
				content:"<label><span class='glyphicon glyphicon-user'></span>姓名</label><input type='text' placeholder='输入考生的姓名' class='form-control name'>"+
							"<label><span class='glyphicon glyphicon-phone'></span>账号</label><input type='text' placeholder='账号为考生手机号'  class='form-control username'>"+
							"<label><span class='glyphicon glyphicon-envelope'></span>邮箱</label><input type='text' placeholder='邮箱(推荐填写,可不填)' class='form-control email'>"+
							"<label><span class='glyphicon glyphicon-tags'></span>职位</label><select class='form-control post'>"+
							"<option value='disabled'>请选择职位</option><option value='软件工程师'>软件工程师</option>"+
							"<option value='网络工程师'>网络工程师</option><option value='硬件工程师'>硬件工程师</option>"+
							"<option value='机械工程师'>机械工程师</option><option value='电气工程师'>电气工程师</option>"+
							"</select>",
				buttons:{
					ok:{
						text:"确认",
						btnClass:"btn btn-info",
						action:function(){
							if($.trim(this.$content.find(".name").val()).length==0||this.$content.find(".name").val()==""){
								$.alert({
									icon:"glyphicon glyphicon-comment",
									type:"red",
									title:"提示信息",
									content:"请输入姓名",
									button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
								})
								return false;
							}
						if($.trim(this.$content.find(".username").val()).length==0||this.$content.find(".username").val()==""){
							$.alert({
								icon:"glyphicon glyphicon-comment",
								type:"red",
								title:"提示信息",
								content:"请输入账号",
								button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
							})
							return false;
						}
						if(this.$content.find(".post").val()=="disabled"){
							$.alert({
								icon:"glyphicon glyphicon-comment",
								type:"red",
								title:"提示信息",
								content:"请选择职位",
								button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
							})
							return false;
						}
						
						var name=this.$content.find(".name").val();
						var username=this.$content.find(".username").val();
						var post = this.$content.find(".post").val();
						var mail=this.$content.find(".email").val();
						$.alert({
							icon:"glyphicon glyphicon-question-sign",
							type:"orange",
							title:"确认信息",
							content:"<font style='font-weight:800'>姓名:"+name+"<br><br>账号:"+username+"<br><br>职位:"+post+"<br><br>邮箱:"+mail+"</font>",
							buttons:{
								ok:{text:"确认",btnClass:"btn btn-default",action:function(){
									$.ajax({
										type:"post",
										url:"Add",
										data:{"name":name,"username":username,"post":post,"mail":mail},
										dataType:"text",
										success:function(data){
											if(data=="error"){
												$.alert({
													icon:"glyphicon glyphicon-comment",
													title:"提示信息",
													content:"人员重复",
													type:"orange",
													button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
												})
												return false;
											}
											if(data=="select"){
												$.alert({
													icon:"glyphicon glyphicon-comment",
													type:"red",
													title:"提示信息",
													content:"请选择职位",
													button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
												})							
												return false;
											}
											if(data=="phone"){
												$.alert({
													icon:"glyphicon glyphicon-comment",
													type:"red",
													title:"提示信息",
													content:"请输入正确的手机号",
													button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
												})									
												return false;
											}
											if(data=="mail"){
												$.alert({
													icon:"glyphicon glyphicon-comment",
													type:"red",
													title:"提示信息",
													content:"请输入合法的邮箱",
													button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
												})							
												return false;
											}
											toastr.success("录入完成");
											$("#show").html(data);		
											//数据填充完毕之后再次请求ajax验证人员的考试情况是中途退出还是正常考试或者未考试
											setTimeout(function(){
												$.ajax({
													type:"POST",
													url:"ModifyStatus",
													dataType:"json",
													cache:false,
													success:function(obj){
														$.each(obj,function(i){
															$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
														})
													},
													error:function(){
														toastr.error("获取精确的考试状态失败");
													}
												})
											}, 400)
					
										},
										error:function(){
											toastr.error("服务器通信失败");
											return;
										}
									})
								}},
								cancel:{text:"取消",btnClass:"btn btn-default",action:function(){}}
							}
						})					
							
						}
		
					},
					cancel:{
						text:"取消",
						btnClass:"btn btn-default",
						action:function(){
							return;
						}
					}
				}
			})
		})
		
		
		//修改人员信息
		$(".update").on("click",function(){
			$.ajax({
				type:"post",
				url:"UpdateTemp",
				data:"username="+$(this).attr("id"),
				dataType:"json",
				cache:false,
				success:function(data){
					
					$.confirm({
						icon:"glyphicon glyphicon-repeat",
						title:"修改应试者信息",
						type:"blue",
						content:"<script>$(function(){$('#mypost').val('"+data.post+"')})</script>" +
									"<label><span class='glyphicon glyphicon-user'></span>姓名</label><input type='text' placeholder='输入考生的姓名' value='"+data.name+"' class='form-control name'>"+
									"<label><span class='glyphicon glyphicon-phone'></span>账号</label><input type='text' placeholder='账号为考生手机号' value='"+data.account+"' class='form-control username'>"+
									"<label><span class='glyphicon glyphicon-envelope'></span>邮箱</label><input type='text' placeholder='邮箱(推荐填写,可不填)' value='"+data.email+"' class='form-control email'>"+
									"<label><span class='glyphicon glyphicon-tags'></span>职位</label><select class='form-control post' id='mypost'>"+
									"<option value='软件工程师'>软件工程师</option>"+
									"<option value='网络工程师'>网络工程师</option><option value='硬件工程师'>硬件工程师</option>"+
									"<option value='机械工程师'>机械工程师</option><option value='电气工程师'>电气工程师</option>"+
									"</select>",
						buttons:{
							ok:{
								text:"确认",
								btnClass:"btn btn-info",
								action:function(){
									if($.trim(this.$content.find(".name").val()).length==0||this.$content.find(".name").val()==""){
										$.alert({
											icon:"glyphicon glyphicon-comment",
											type:"red",
											title:"提示信息",
											content:"请输入姓名",
											button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
										})
										return false;
									}
								if($.trim(this.$content.find(".username").val()).length==0||this.$content.find(".username").val()==""){
									$.alert({
										icon:"glyphicon glyphicon-comment",
										type:"red",
										title:"提示信息",
										content:"请输入账号",
										button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
									})
									return false;
								}
								
								var name=this.$content.find(".name").val();
								var username=this.$content.find(".username").val();
								var post = this.$content.find(".post").val();
								var mail=this.$content.find(".email").val();
									
								$.alert({
									icon:"glyphicon glyphicon-question-sign",
									type:"orange",
									title:"确认信息",
									content:"<font style='font-weight:800'>姓名:"+name+"<br><br>账号:"+username+"<br><br>职位:"+post+"<br><br>邮箱:"+mail+"</font>",
									buttons:{
										ok:{
											text:"确认",
											btnClass:"btn btn-info",
											action:function(){
												$.ajax({
													type:"post",
													url:"Update",
													data:"name="+name+"&username="+username+"&post="+post+"&mail="+mail,
													dataType:"text",
													success:function(data){
														if(data=="error"){
															$.alert({
																icon:"glyphicon glyphicon-comment",
																title:"提示信息",
																content:"账号重复",
																button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
															})
															return false;
														}
														if(data=="phone"){
															$.alert({
																icon:"glyphicon glyphicon-comment",
																type:"red",
																title:"提示信息",
																content:"请输入合法的手机号",
																button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
															})
															return false;
														}
														if(data=="mail"){
															$.alert({
																icon:"glyphicon glyphicon-comment",
																type:"red",
																title:"提示信息",
																content:"请输入合法的邮箱",
																button:{text:"确认",btnClass:"btn btn-default",action:function(){}}
															})
															return false;
														}
														toastr.success("修改完成");
														$("#show").html(data);
														setTimeout(function(){
															$.ajax({
																type:"POST",
																url:"ModifyStatus",
																dataType:"json",
																cache:false,
																success:function(obj){
																	$.each(obj,function(i){
																		$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
																	})
																},
																error:function(){
																	toastr.error("获取精确的考试状态失败");
																}
															})
														}, 400)
													},
													error:function(){
														toastr.error("服务器通信失败");
													}
												})
											}
										},
										cancel:{
											text:"取消",
											btnClass:"btn btn-default",
											action:function(){}
										}
									}
								})
									
								}
							},
							cancel:{
								text:"取消",
								btnClass:"btn btn-default",
								action:function(){
									return;
								}
							}
						}
					})
						
						
						
						
						
						
						
				},
				error:function(){
					toastr.error("服务器通信失败");
				}
			})
		})
		
	
		
		
		//删除人员信息
		$(".deleteUser").on("click", function() {
			var string = $(this).attr("id");
			$.confirm({
				icon:"glyphicon glyphicon-remove",
				title:"操作确认",
				content:"点击确认将会删除对应的人员",
				type:"orange",
				buttons:{
					ok:{
						text:"确定",
						btnClass:"btn-warning",
						action:function(){
							$(".mask").fadeIn(500);
							setTimeout(function(){
								$.ajax({
									type : "POST",
									url : "Delete",
									data:"username="+string,
									cache : false,
									async : true,
									success : function(data) {
										$("#show").html(data);
										
										setTimeout(function(){
											$.ajax({
												type:"POST",
												url:"ModifyStatus",
												dataType:"json",
												cache:false,
												success:function(obj){
													$.each(obj,function(i){
														$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
													})
												},
												error:function(){
													toastr.error("获取精确的考试状态失败");
												}
											})
										}, 400)
										
										$(".mask").fadeOut(650);
									},
									error:function(){
										toastr.error("服务器通信失败");
										$(".mask").fadeOut(650);
									}
								});
								}, 800);
						}
					},
					cancel:{
						text:"关闭",
						btnClass:"btn",
						action:function(){
							return;
						}
					}
				}
			});
			
		})
		
		/******分页******/
		$("#next").on("click",function(){
			var page=$(this).attr("name");
			$.ajax({
				type:"POST",
				url:"view",
				data:"pageNo="+$(this).attr("name"),
				cache:false,
				dataType:"text",
				success:function(data){
					$("#show").html(data);
					setTimeout(function(){
						$.ajax({
							type:"POST",
							url:"ModifyStatus",
							data:"pageNo="+page,
							dataType:"json",
							cache:false,
							success:function(obj){
								$.each(obj,function(i){
									$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
								})
							},
							error:function(){
								toastr.error("获取精确的考试状态失败");
							}
						})
					}, 400)
				},
				error:function(){
					toastr.error("系统异常");
				}
				
			});
			
		});
		
		$("#before").on("click",function(){
			var page=$(this).attr("name");
			$.ajax({
				type:"POST",
				url:"view",
				data:"pageNo="+$(this).attr("name"),
				cache:false,
				dataType:"text",
				success:function(data){
					$("#show").html(data);
					//数据填充完毕之后再次请求ajax验证人员的考试情况是中途退出还是正常考试或者未考试
				setTimeout(function(){
					$.ajax({
						type:"POST",
						url:"ModifyStatus",
						data:"pageNo="+page,
						dataType:"json",
						cache:false,
						success:function(obj){
							$.each(obj,function(i){
								$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
							})
						},
						error:function(){
							toastr.error("获取精确的考试状态失败");
						}
					})
				}, 400)
				},
				error:function(){
					toastr.error("系统异常");
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
				toastr.warning("请输入数字！");
				$("#textpageNo").val("");
				return;
			}
			var page=$("#textpageNo").val();
				$.ajax({
					type:"POST",
					url:"view",
					data:"pageNo="+$("#textpageNo").val(),
					dataType:"text",
					success:function(data){
						$("#show").html(data);
						setTimeout(function(){
							$.ajax({
								type:"POST",
								url:"ModifyStatus",
								data:"pageNo="+page,
								dataType:"json",
								cache:false,
								success:function(obj){
									$.each(obj,function(i){
										$("#e_"+obj[i]).html("<font style='color:red'>中途退出</font>");
									})
								},
								error:function(){
									toastr.error("获取精确的考试状态失败");
								}
							})
						}, 400)
					},
					error:function(){
						toastr.error("系统异常");
					}
					
				});
				
			});

	});