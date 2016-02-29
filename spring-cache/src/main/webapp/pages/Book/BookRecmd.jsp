<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>新书推荐</title>
</head>
<body>
<div class="content">
    <div class="title"><span class="text">新书推荐</span></div>
	<div class="recommonded">
		<div class="index-title">已推荐书籍</div>
		<table id="table2" class="table table-striped table-bordered">
	        <tbody>
	        <tr>
	        <th>书籍名称</th><th>推荐人</th><th>支持次数</th><th>点赞</th>
	        </tr>
	        <td>算法导论</td><td>张三</td><td>15</td>
	        <td><input type="button" class="btn btn-success" id="" value="点赞" onclick=""></td>
	        </tbody>
	    </table>	
	</div>
	<div class="recommonding">
	      <form action=""  class="am-form am-form-horizontal">
			  <div class="index-title">推荐书籍</div>
			  <div class="am-form-group">
			    <label class="am-u-sm-2 am-form-label">书籍名称</label>
			    <div class="am-u-sm-10">
			      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
			    </div>
			  </div>		
			  <div class="am-form-group">
			    <label class="am-u-sm-2 am-form-label">作者</label>
			    <div class="am-u-sm-10">
			      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
			    </div>
			  </div>		
			  <div class="am-form-group">
			    <label class="am-u-sm-2 am-form-label">ISDN号</label>
			    <div class="am-u-sm-10">
			      <input type="text" id="am-form-field am-radius" placeholder="输入内容"/>
			    </div>
			  </div>
			    <div class="am-form-group">
			    <label class="am-u-sm-2 am-form-label">推荐理由</label>
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
    
</div>
</body>
</html>