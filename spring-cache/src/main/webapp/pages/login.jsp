<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/amazeui.min.css" type="text/css"/>
</head>
<body>
 <div class="Login">
        <div class="logo-title"></div>
		<form action=""  class="am-form am-form-horizontal">
		  <div class="login-title">登录</div>
		  <div class="am-form-group">
		    <label for="am-form-field" class="am-u-sm-2 am-form-label">工号</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入你的工号"/>
		    </div>
		  </div>
		
		  <div class="am-form-group">
		    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">密码</label>
		    <div class="am-u-sm-10">
		      <input type="password" id="doc-ipt-pwd-2" placeholder="请输入密码"/>
		    </div>
		  </div>
		
		  <div class="am-form-group">
		    <div class="am-u-sm-offset-2 am-u-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox"/> 记住密码
		        </label>
		      </div>
		    </div>
		  </div>
		
		  <div class="am-form-group controller">
		    <div class="buttons ">
		      <button type="submit" class="am-btn am-btn-success">提交</button>
		      <button type="reset" class="am-btn am-btn-default">重置</button>
		    </div>
		  </div>	
		</form>
	 </div>
</body>
</html>