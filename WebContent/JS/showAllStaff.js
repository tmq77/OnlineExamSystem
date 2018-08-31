$(function() {
		if ($(".mytr").length >= 6) {
			$(".modifydiv").css("display", "block");
		} else if ($("#mypage").text() > 1) {
			$(".modifydiv").css("display", "block");
		}

		$(".maskback").on("click",function(){
			$(".tempmask").fadeOut(500);
		})
		
		//设置管理员邮箱
		$("#setMail").on("click",function(){
			$.confirm({
				 icon: '	glyphicon glyphicon-check',
			    title: '设置邮箱',
			    content: '<font style="font-family:YouYuan">提示:如果您需要更换邮箱,在此输入其他邮箱即可<br><label>输入账号</label><input type="text" placeholder="发送邮件的邮箱账号" class="mailaccount form-control" />'+
			    '<label>输入密码</label><input type="password" placeholder="您的密码" class="mailpassword form-control"/>'
			    +'<label>选择邮箱类型</label><select class="select form-control">'+
			    '<option value="smtp.163.com">163---输入您的授权码</option><option value="smtp.qq.com">QQ--输入您的授权码</option>'+
			    '<option value="smtp.mail.yahoo.com">雅虎---未测试</option><option value="smtp.sina.com">新浪---未测试</option>'+
			    '<option value="smtp.bingsoft.com">bingsoft---公司邮箱，暂时只能内部收发</option></select></font>',
			    type: 'blue',
			    buttons: {   
			        ok: {
			            text: "确定",
			            btnClass: 'btn-primary',
			            keys: ['enter'],
			            action: function(){
			            	$.ajax({
			    				type:"post",
			    				url:"SetMail",
			    				data:"mail="+this.$content.find('.mailaccount').val()+"&password="+this.$content.find('.mailpassword').val()+"&protocol="+this.$content.find('.select').val(),
			    				dataType:"text",
			    				cache:false,
			    				success:function(data){
			    					if(data=="error"){
			    						toastr.error("请输入正确的邮箱");
			    						return;
			    					}else{
			    						toastr.success("邮箱设置完成,在不禁用cookie且不更换浏览器的情况下,30天内该账号始终在线");
			    					}
			    				
			    				},
			    				error:function(){
			    					toastr.error("服务器错误");
			    				}
			    			})
			            }
			        },
			   
			        cancel: {
			        	text:"关闭",
			        	 btnClass: 'btn',
			        	action:function(){
			        		
				               return;
				        }
			        }
			    }
			});
			
		})
		
		
		//发送邮件
		$(".sendEmail").on("click",function(){
			var mail = $(this).attr("id");
			var name=$(this).parent().parent().find(".passName").text();
			var post = $(this).parent().parent().find(".passPost").text();
			$.confirm({
				 icon: 'glyphicon glyphicon-envelope',
			    title: '发送邮件',
			    content: '<label><font style="font-family:YouYuan">输入面试时间</font></label><input type="text" placeholder="输入时间(邮件中显示的内容将会与此一致)" class="time form-control" />',
			    type: 'blue',
			    buttons: {   
			        ok: {
			            text: "发送",
			            btnClass: 'btn-primary',
			            keys: ['enter'],
			            action: function(){
			            	if(this.$content.find('.time').val()==""){
			            		toastr.warning("请输入时间");	   
			            		return false;
			            	}
			            	$(".waitcircle").shCircleLoader();
			            	$(".waitcircle").show();
			         
			            		
			            	
			            	
			            		$.ajax({
				    				type:"post",
				    				url:"SendEmail",
				    				data:"mail="+mail+"&name="+name+"&post="+post+"&time="+this.$content.find('.time').val(),
				    				dataType:"text",
				    				cache:false,
				    				success:function(data){
				    					if(data=="error"){
				    						$(".waitcircle").fadeOut(100);
				    						$.alert({
				    							icon:"glyphicon glyphicon-remove",
				    							button:{
				    								text:"关闭"
				    							},
				    						    title: '错误！',
				    						    content: '发送失败！',
				    						    type:"red",
				    						    confirm: function(){
				    						    }
				    						});
				    					}else if(data=="none"){
				    						$(".waitcircle").fadeOut(100);
				    						$.alert({
				    							icon:"glyphicon glyphicon-remove",
				    							button:{
				    								text:"关闭"
				    							},
				    						    title: '错误！',
				    						    type:"red",
				    						    content: '<font style="font-family:YouYuan">请检查cookie设置，是否已经过期或者禁用，请重新设置邮箱</font>',
				    						    confirm: function(){
				    						    }
				    						});
				    					}else if(data=="success"){
				    						$(".waitcircle").fadeOut(100);
				    						$.alert({
				    							icon:"glyphicon glyphicon-ok",
				    							button:{
				    								text:"关闭"
				    							},
				    						    title: '反馈信息',
				    						    type:"green",
				    						    content: '<font style="font-family:YouYuan">邮件发送完成</font>',
				    						    confirm: function(){
				    						    }
				    						});
				    					}else if(data=="unhandle"){		  
				    						$(".waitcircle").fadeOut(100);
				    						$.alert({
				    							icon:"glyphicon glyphicon-remove",
				    							button:{
				    								text:"关闭"
				    							},
				    						    title: '错误！',
				    						    type:"red",
				    						    content: '<font style="font-family:YouYuan">请配置正确的邮箱账号密码</font>',
				    						    confirm: function(){
				    						    }
				    						});
				    					}else{
				    						$(".waitcircle").fadeOut(100);
				    				
				    						$.alert({
				    							icon:"glyphicon glyphicon-remove",
				    							button:{
				    								text:"关闭"
				    							},
				    						    title: '不可预料的异常！',
				    						    content: '请联系管理员',
				    						    type:"red",
				    						    confirm: function(){
				    						    }
				    						});
				    					}
				    				},
				    				error:function(){
				    					$(".waitcircle").fadeOut(100);
				    					toastr.error("服务器错误");
				    				}
				    			})
			            
			            	
			            }
			        },
			   
			        cancel: {
			        	text:"关闭",
			        	 btnClass: 'btn',
			        	action:function(){
				               return;
				        }
			        }
			    }
			});
			
			
			
		})
		
		//点击打印试卷
		$(".print").on("click",function(){
			var id = $(this).attr("id");
			var name=$(this).attr("name");
			$.confirm({
				icon:"glyphicon glyphicon-print",
				title:"<font style='font-family:YouYuan'>导出预览</font>",
				content:"<font style='font-family:YouYuan'>点击确定将会将试卷导出预览</font>",
				type:"blue",
				buttons:{
					ok:{
						text:"确定",
						btnClass:"btn-info",
						action:function(){
							$.ajax({
								type:"post",
								data:"username="+id+"&name="+name,
								dataType:"text",
								url:"PrintAllPaper",
								cache:false,
								success:function(data){
									toastr.info("导出预览中。。。");
									$(".printtemp").html(data);
								setTimeout(function(){
									$(".tempmask").fadeIn(500);
									toastr.clear();
								}, 400);
									
								},
								error:function(){
									toastr.error("系统异常,通信失败");
								}
							})
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
			})
		
		})
		
		//删除人员
		$(".deleteUser").on("click", function() {
			var string = $(this).attr("id");
			 $.confirm({
				 icon:"glyphicon glyphicon-warning-sign",
				 title:"<font style='font-family:YouYuan'>删除确认</font>",
				 content:"<font style='font-family:YouYuan'>请确认操作</font>",
				 type:"blue",
				 buttons:{
					 ok:{
						 text:"确认",
						 btnClass:"btn-info",
						 action:function(){
							 $(".mask").fadeIn(500);
								setTimeout(function(){
									$.ajax({
										type : "POST",
										url : "DeleteStaff?username=" + string,
										cache : false,
										async : true,
										success : function(data) {
											if(data=="error"){
											toastr.error("删除失败");
											$(".mask").fadeOut(700);
											}else{//后期关闭了开发模式，如果出错 则会返回代码500--会直接跳至error function
												toastr.success("删除成功");
												$("#show").html(data);
												$(".mask").fadeOut(700);
											}
										},
										error:function(){
											toastr.error("服务器通信失败");
											$(".mask").fadeOut(700);
										}
									});
									}, 1000);
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
			 })
		
		})
		
		/******分页******/
		$("#next").on("click",function(){
			var page=$(this).attr("name");
			$.ajax({
				type:"POST",
				url:"ShowStaff",
				data:"pageNo="+$(this).attr("name"),
				cache:false,
				dataType:"text",
				success:function(data){
					$("#show").html(data);
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
				url:"ShowStaff",
				data:"pageNo="+$(this).attr("name"),
				cache:false,
				dataType:"text",
				success:function(data){
					$("#show").html(data);
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
					url:"ShowStaff",
					data:"pageNo="+$("#textpageNo").val(),
					dataType:"text",
					success:function(data){
						$("#show").html(data);
					},
					error:function(){
						toastr.error("系统异常");
					}
					
				});
				
			});

	});