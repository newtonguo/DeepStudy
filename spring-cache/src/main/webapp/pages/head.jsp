<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
String path=request.getContextPath();
%>
<link rel="icon" href="<%=path%>/resource/images/logos.png">
<link rel="stylesheet" href="<%=path%>/resource/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="<%=path%>/resource/css/content.css" type="text/css">
<link rel="stylesheet" href="<%=path%>/resource/css/amazeui.min.css" type="text/css">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
</head>
<body>
<div class="am-alert am-alert-danger" data-am-alert>
  <button type="button" class="am-close">&times;</button>
  <p></p>
</div>
<div class="am-alert am-alert-success" data-am-alert>
  <button type="button" class="am-close">&times;</button>
  <p></p>
</div>
<div class="head">
    <a class="logo" href="index.jsp"></a>
    <span class="modify" onclick="show(this)">修改密码</span>
    <span class="login" onclick="show(this)">登录</span>
</div>
<div class="mask">      
     <div class="mask-login">
        <span class="mask-close" onclick="closed(this)"></span>
        <div class="logo-title"></div>
         <form action="" name="login">
            <div class="frm_control_group">
				<label class="frm_label">工号</label>
				<div class="frm_controls">
					<input type="text" name="" placeholder="请在此键入用户名" class="frm_input userId" required>
				</div>
			</div>
			<div class="frm_control_group">
				<label class="frm_label">密码</label>
				<div class="frm_controls">
					<input type="password" name="" placeholder="请输入密码" class="frm_input password" required>
				</div>
			</div>
            <div><input type="submit" class="btn btn-success btn-submit" value="提交"/>
                 <input type="reset" class="btn btn-success btn-reset" value="重置"/>
                 <input type="button" class="btn btn-success btn-forget" value="忘记密码"/>
            </div>
         </form>
    </div>
    <div class="mask-modify">
        <span class="mask-close" onclick="closed(this)"></span>
        <div class="logo-title"></div>
        <form action="" name="modify">
            <div class="frm_control_group">
				<label class="frm_label">原密码</label>
				<div class="frm_controls">
					<input type="password" name="" class="frm_input pwd1">
				</div>
			</div>
			<div class="frm_control_group">
				<label class="frm_label">新密码</label>
				<div class="frm_controls">
					<input type="password" name="" class="frm_input pwd2">
				</div>
			</div>
			<div class="frm_control_group">
				<label class="frm_label">确认密码</label>
				<div class="frm_controls">
					<input type="password" name="" class="frm_input pwd3">
				</div>
			</div>
            <div><input type="submit" class="btn btn-success btn-submit" value="提交"/>
                 <input type="reset" class="btn btn-success btn-reset" value="重置"/>    
            </div>
        </form>
   </div>
    <div class="mask-addone" id="addone">
    	<span class="mask-close" onclick="closed(this)" style="margin-left:450px;" ></span>
    	<div class="logo-title"></div>
    	<form id ="addBook" action="" name="detail">
    	    <div class="frm_control_group">
				<label class="frm_label">图书类别</label>
				<div class="frm_controls">
					<input type="text" placeholder="请输入图书类别" name="bookclass" class="frm_input catagory">
				</div>
			</div>
			<div class="frm_control_group">
				<label class="frm_label">图书名称</label>
				<div class="frm_controls">
					<input type="text" name="bookname" placeholder="请输入图书名称" class="frm_input bookname" maxlength="32">
				</div>
			</div>
			<div class="frm_control_group">
				<label class="frm_label">图书编号</label>
				<div class="frm_controls">
					<input type="text" name="bookno"  placeholder="请输入图书编号" class="frm_input bookId">
				</div>
			</div>	
    		<div><input type="button" class="btn btn-success" id="sure" onclick="addbook()" value="提交"/><input type="reset" class="btn btn-success btn-submit" value="重置"/></div>
    	</form>
    </div>
    <div class="mask-file" id="file">
    	<span class="mask-close" onclick="closed(this)"></span>
    	<div class="logo-title"></div>
    	<form action="" name="file">
    		<div class="frm_control_group">
				<div class="frm_controls">
					<input type="text" class="filename" readonly/>
                    <input type="button" name="file" class="btn btn-success btn-file" value="浏览文件"/>
                    <input type="file" size="30"/>				
				</div>
    		</div>
    		<div><input type="button" class="btn btn-success" value="确定"/><input type="reset" class="btn btn-success btn-cancel" value="重置"/></div>
    	</form>
    </div> 
    <div class="mask-more" id="test1">
        <span class="mask-close" onclick="closed(this)"></span>
        <div class="logo-title"></div>
        <form action="" name="addCat">
            <div class="frm_control_group">
				<label class="frm_label">类别名称</label>
				<div class="frm_controls">
					<input type="text" name="" class="frm_input catagory" maxlength="32">
				</div>
			</div>
            <div><input type="button" class="btn btn-success btn-add" value="添加"/><input type="reset" class="btn btn-success btn-submit" value="重置"/></div>
        </form>
    </div>  
</div>
<script src="<%=path%>/resource/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/resource/js/common.js" type="text/javascript"></script>
<script src="<%=path%>/resource/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=path%>/resource/js/amazeui.min.js" type="text/javascript"></script>
<script src="<%=path%>/resource/js/pager.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
		$("input[type=file]").change(function(){
			$(this).parents(".frm_controls").find(".filename").val($(this).val());
		});		
		$("input[type=file]").each(function(){
			if($(this).val()==""){
				$(this).parents(".frm_controls").find(".filename").val("请选择文件...");
			}
		});
		
});	

$.fn.serializeJson=function(){
	var serializeObj={};
	$(this.serializeArray()).each(function(){
    if(this.name=="bookclass"){
		serializeObj[this.name]=parseInt(this.value);
	}else{
		serializeObj[this.name]=this.value;
	}
	});
	return serializeObj;
}; 


function addbook(){
	var tmp = JSON.stringify($('#addBook').serializeJson());	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url:"/family/book",
		data:tmp,	//要发送的是ajaxFrm表单中的数据
		error: function(e) {
			$(".am-alert-danger").css({display:"block"});
			$(".am-alert-danger p").text("提交失败！！！");
		},
		success: function(data) {
			$(".am-alert-success").css({display:"block"});
			$(".am-alert-success p").text("提交成功！！！");
		}
	});
}

</script>
</body>
</html>