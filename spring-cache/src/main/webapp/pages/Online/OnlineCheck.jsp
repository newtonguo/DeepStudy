<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>上线审批</title>
</head>
<body>
<div class="content">
    <div class="title"><span class="text">上线申请审批</span></div>
    <div class="row-fluid">
	<form class="am-form">
	<fieldset>
	<div style="display: inline-block; width:100%;">
	<div style="display: inline-block; width:60%;border:1px solid #e5e5e5;">
		<legend style="font-size:1.2em;">上线申请1</legend>
		<ul>
			<li style="margin-bottom:5px;width:100%;overflow:auto;">
				生产服务器IP：
				<div style="float:right;text-align:left;width:60%;">10.6.155.205-206</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线工程名/SVN版本号：
				<div style="float:right;text-align:left;width:60%;">UmeServerCore-3.1.7.war</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线内容：
				<div style="float:right;text-align:left;width:60%;">
				<ul><li style="list-style-type:decimal;">预测模型参数调整，bug修复</li><li style="list-style-type:decimal;">取消校验逻辑修改</li>
				</ul>
				</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">
				<div style="display:inline;">对系统的影响：
				<div style="float:right;text-align:left;width:60%;">
				<ul><li style="list-style-type:decimal;">暂无</li><li style="list-style-type:decimal;">减少取消误报</li>
				</ul>
				</div></div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">开发人：
				<div style="float:right;;text-align:left;width:60%;">
				<ul><li style="list-style-type:decimal;">李梓平</li><li style="list-style-type:decimal;">李玉童</li>
				</ul>
				</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">测试用例：
				<div style="float:right;text-align:left;width:60%;">已上36</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线后测试人员：
				<div style="float:right;text-align:left;width:60%;">李梓平， 李玉童</div>
			</li>
		</ul>
	</div>
	<div style="position:relative;float:right;width:40%;margin-top:20%;padding-left:20px;">
		<div class="am-radio am-form-group" style="">
      	<label>
        <input type="radio" name="doc-radio-1" value="option1" checked>
        	同意
        	<input type="text" class="am-form-field" placeholder="请选择上线日期：YYYY-MM-DD" data-am-datepicker readonly/>
      	</label>
    	</div>

    	<div class="am-radio">
      	<label>
        <input type="radio" name="doc-radio-1" value="option2">
       		 不同意
      	</label>
      	<input type="text" class="js-sync-validate" id="doc-vld-sync"
             placeholder="请输入不同意的原因"/>
   		</div>
	</div>
	</div>
	</fieldset>
	</form>
	
	
	<form class="am-form">
	<fieldset>
	<div style="display: inline-block; width:100%;">
	<div style="display: inline-block; width:60%;border:1px solid #e5e5e5;">
		<legend style="font-size:1.2em;">上线申请2</legend>
		<ul>
			<li style="margin-bottom:5px;width:100%;overflow:auto;">
				生产服务器IP：
				<div style="float:right;text-align:left;width:60%;">10.6.155.205-206</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线工程名/SVN版本号：
				<div style="float:right;text-align:left;width:60%;">UmeServerCore-3.1.7.war</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线内容：
				<div style="float:right;text-align:left;width:60%;">
				<ul><li style="list-style-type:decimal;">预测模型参数调整，bug修复</li><li style="list-style-type:decimal;">取消校验逻辑修改</li>
				</ul>
				</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">
				<div style="display:inline;">对系统的影响：
				<div style="float:right;text-align:left;width:60%;">
				<ul><li style="list-style-type:decimal;">暂无</li><li style="list-style-type:decimal;">减少取消误报</li>
				</ul>
				</div></div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">开发人：
				<div style="float:right;;text-align:left;width:60%;">
				<ul><li style="list-style-type:decimal;">李梓平</li><li style="list-style-type:decimal;">李玉童</li>
				</ul>
				</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">测试用例：
				<div style="float:right;text-align:left;width:60%;">已上36</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线后测试人员：
				<div style="float:right;text-align:left;width:60%;">李梓平， 李玉童</div>
			</li>
		</ul>
	</div>
	<div style="position:relative;float:right;width:40%;margin-top:20%;padding-left:20px;">
		<div class="am-radio am-form-group">
      	<label>
        <input type="radio" name="doc-radio-1" value="option1" checked>
        	同意
        	<input type="text" class="am-form-field" placeholder="请选择上线日期：YYYY-MM-DD" data-am-datepicker readonly/>
      	</label>
    	</div>

    	<div class="am-radio">
      	<label>
        <input type="radio" name="doc-radio-1" value="option2">
       		 不同意
      	</label>
      	<input type="text" class="js-sync-validate" id="doc-vld-sync"
             placeholder="请输入不同意的原因"/>
   		</div>
	</div>
	</div>
	</fieldset>
	</form>
	<div style="text-align:center;">
		<button type="button" class="am-btn am-btn-primary" style="width:100px;">提交</button>
	</div>
	</div>
	
	
	
	</div>
    
<%-- <%@ include file="foot.jsp"%> --%>
</body>

</html>