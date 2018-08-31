<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css" type="text/css">
<script src="JS/jquery-3.1.1.min.js"></script>
<script src="JS/bootstrap.js"></script>
<link href="CSS/toastr.css" rel="stylesheet" />
<script src="JS/toastr.min.js"></script>
<title>分页插件</title>
<!-- 此处css需要复制到你需要的页面上 -->
<style type="text/css">
.page{
/* display:none; */   
float:right;    /* 工具栏靠右下 */
margin-top:3%;
width:40%;
}
</style>

<script type="text/javascript">
<!--     
toastr.options.positionClass = 'toast-top-full-width';
/* 提示框的显示位置需要引入toastr的相关文件 */
//-->
     /*    $(function(){           <!-- 此处是用于当每页上记录数较少时，隐藏工具栏，需要将.page的div的样式中的display:none的注释去掉 -->
        	if ($(".class").length >= 6) {     //----此处的.class是你表格行的tr的类名，使用ul亦可
    			$(".page").css("display", "block");
    		} else if ($("#mypage").text() > 1) {
    			$(".page").css("display", "block");
    		}
        }) */
        
   <!--     //分页的按钮操作
        $(function(){
        	$("#before").on("click",function(){
        		$.ajax({
        			type:"POST",
        			url:"你的servlet或者action或者页面",
        			data:"pageNo="+$(this).attr("name"),
        			cache:false,
        			dataType:"text",
        			success:function(data){
        				$("#...").html("");  //你要填充的DOM元素
        				$("#...").html(data);
        			},
        			error:function(){
        				
        			}
        			
        		});
        		
        	});
        	
        	$("#next").on("click",function(){
        		$.ajax({
        			type:"POST",
        			url:"你的servlet或者action或者页面",
        			data:"pageNo="+$(this).attr("name"),
        			cache:false,
        			dataType:"text",
        			success:function(data){
        				$("#...").html("");
        				$("#...").html(data);
        			},
        			error:function(){
        				
        			}
        			
        		});
        		
        	});
        	
        	$("#subPage").on("click",function(){
        	if(isNaN($("#textpageNo").val())){
        		toastr.warning("请输入数字！");
        	}
        		
        		$.ajax({
        			type:"POST",
        			url:"你的servlet或者action或者页面",
        			data:"pageNo="+$("#textpageNo").val(),
        			dataType:"text",
        			success:function(data){
        				$("#...").html("");
        				$("#...").html(data);
        			},
        			error:function(){
        				
        			}
        		});
        		
        	});
        })
//-->
 </script>

</head>
<body>
<!-- ***********分页*************** -->
	
		<div class="page">
				<table>
					<tr>
						<td width="8%" style="color: rgb(130, 185, 130);">第<span
							id="mypage">${page}</span>页
						</td>
						<td width="8%">共${pageSize}页</td>
						<td width="20%"><button class="btn btn-default" id="before" name="${page-1}">上一页</button>
						<button class="btn btn-default" id="next" name="${page+1}">下一页</button>
						</td>
						
						<td colspan="2" width="10%"><input type="text"
							class="form-control" id="textpageNo" placeholder="跳转"></td>
						<td width="5%"><input type="button" class="btn btn-default" value=提交 id="subPage"></td>
					</tr>
				</table>
		</div>
<!-- ***********分页*************** -->


</body>
</html>