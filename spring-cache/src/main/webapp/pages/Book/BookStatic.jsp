<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>数据统计</title>
</head>
<body>
<div class="content">
    <div class="title"><span class="text">统计查询</span></div>
    <div class="row-fluid">
	<div class="col-md-5">
		<div class="row-fluid">
	<br>
	</div>
	<div class="row-fluid">
	<div class="col-md-4">
	<select class="form-control">
	<option>书名</option>
	<option>类别名</option>
	</select>
	</div>
	<div class="col-md-5">
	<input class="form-control" type="text">	
	</div>
	<div class="col-md-3">
	<button class="btn btn-success" type="button">查询</button>
	</div>
	<div class="row-fluid">
	<div class="col-md-12">
	<table id="table2" class="table table-striped table-bordered">
        <tbody>
		
        </tbody>
    </table>
	</div>
	</div>
	</div>
	</div>
	<div class="col-md-7">
	<br>
	<%@ include file="BookChart.jsp"%>
	</div>
	</div>
</div>
</body>
<script type="text/javascript">
		 $.ajax({ 
			url: "bookcategory/stat/1",
			//url:"family/users/add",
	        //contentType: "application/x-www-form-urlencoded",
	        contentType:"application/json",
	        dataType: "json",
	        timeout: 50000,
	        //type:"POST",
	        //data:{"id":0,"userName":"test"},
	        success: function(json){        
	        	$("tbody").append("<tr><th>类别编号</th><th>类别名称</th><th>操作</th></tr>")
	        	$.each(json.result.list,function(i,obj){
	        		$("tbody").append("<tr><td>"+obj.id+"</td><td>"+obj.name+"</td><td>编辑</td></tr>");
	        	});
	        },
			error:function(message){
				 console.log(message);
			 }
		 });	 
</script>
</html>