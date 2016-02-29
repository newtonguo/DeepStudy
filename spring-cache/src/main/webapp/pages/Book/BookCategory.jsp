<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>类别管理</title>
</head>
<body>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<div class="content">
    <div class="title">
    	<span class="text">类别管理</span>
    	<span class="more" id="create" onclick="show(this)">新建</span>
    </div>
    <table id="table2" class="table table-striped table-bordered">
        <tbody>
        <!--  
		<tr>
		<th>类别编号</th><th>类别名称</th><th>书籍数量</th><th>操作</th>
		</tr>
		
        <tr>
            <td>1</td>
			<td><a href="#">网络编程</a></td>
			<td>30</td>
            <td><input type="button" class="btn btn-success btn-submit" id="test_id1" value="删除" onclick="del(this)"></td>
        </tr>
        <tr>
            <td>2</td>
			<td><a href="#">算法</a></td>
			<td>15</td>
            <td><input type="button" class="btn btn-success btn-submit" id="test_id2" value="删除" onclick="del(this)"></td>
        </tr>
		<tr>
            <td>3</td>
			<td><a href="#">移动开发</a></td>
			<td>10</td>
            <td><input type="button" class="btn btn-success btn-submit" id="test_id3" value="删除" onclick="del(this)"></td>
        </tr>
		<tr>
            <td>4</td>
			<td><a href="#">文学名著</a></td>
			<td>5</td>
            <td><input type="button" class="btn btn-success btn-submit" id="test_id4" value="删除" onclick="del(this)"></td>
        </tr>
        -->
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript">
	 $(function(){
		 $.ajax({ 
			url: "http://172.22.30.36:8080/family/bookcategory/p1",	
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
</html>