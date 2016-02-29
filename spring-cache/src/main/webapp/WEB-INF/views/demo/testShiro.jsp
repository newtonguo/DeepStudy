<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>权限测试界面</title>
  </head>
  <body>
	
	${BASE_PATH }
   	<a href="logout">退出登录</a>    <br>
    <h2>权限测试列表</h2>
    <shiro:authenticated>用户已经登录显示此内容<br/></shiro:authenticated>
    <shiro:hasRole name="manager">manager角色登录显示此内容<br/> </shiro:hasRole>
    <shiro:hasRole name="admin">admin角色登录显示此内容<br/></shiro:hasRole>
    <shiro:hasRole name="normal">normal角色登录显示此内容<br/></shiro:hasRole>
    
    <shiro:hasAnyRoles name="manager,admin">**manager or admin 角色用户登录显示此内容**</shiro:hasAnyRoles>
    <shiro:principal/> - 当前登录用户名<br/>
    <shiro:hasPermission name="add">add权限用户显示此内容</shiro:hasPermission>
    <shiro:hasPermission name="test_query">test_query权限用户显示此内容<shiro:principal/></shiro:hasPermission>
    <shiro:lacksPermission name="user:del"> 不具有user:del权限的用户显示此内容 </shiro:lacksPermission>
    <ul>
    	<c:forEach items="${userList }" var="user">
    		<li>用户名：${user.username }----密码：${user.password }----<a href="/user/edit/${user.id}">修改用户</a>----<a href="javascript:;" class="del" ref="${user.id }">删除用户</a></li>
    	</c:forEach>
    </ul>


  <a class="link" hotrep="hp.header.bookstore.3" href="pages/BookStatic.jsp">数据统计</a>
  
 
    <script type="text/javascript" src="${BASE_PATH}/resource/js/jquery-1.11.2.min.js"></script>

<script type="text/javascript">
	 $(function(){
		 $.ajax({ 
			url: "${BASE_PATH}/bookcategory/p1",	
	        contentType: "application/x-www-form-urlencoded",
	        dataType: "json",
	        timeout: 50000,
	        data:{},
	        success: function(json){
	        	$("tbody").append("<tr><th>类别编号</th><th>类别名称</th><th>操作</th></tr>")
	        	$.each(json.result.list,function(i,obj){
	        		$("tbody").append("<tr><td>"+obj.id+"</td><td>"+obj.name+"</td><td>编辑</td></tr>");
	        	})
	        },
			error:function(message){
				 console.log(message);
			 }
		 })
	 })
</script>


  </body>
</html>