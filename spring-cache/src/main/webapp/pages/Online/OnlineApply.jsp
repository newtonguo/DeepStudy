<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>提交申请单</title>
</head>
<body>
<div class="OnlineForm">
        <span class="mask-close" onclick="closed(this)"></span>
        <div class="apply-logo-title"></div>
		<form action=""  class="am-form am-form-horizontal">
		  <div class="apply-title">申请单</div>
		  <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">生产服务器IP</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
		    </div>
		  </div>		
		  <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">上线工程名</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
		    </div>
		  </div>		
		  <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">上线内容</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
		    </div>
		  </div>
		    <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">对系统影响</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
		    </div>
		  </div>
		    <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">开发人</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
		    </div>
		  </div>
		    <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">测试用例</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
		    </div>
		  </div>
		    <div class="am-form-group">
		    <label class="am-u-sm-2 am-form-label">测试人员</label>
		    <div class="am-u-sm-10">
		      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
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