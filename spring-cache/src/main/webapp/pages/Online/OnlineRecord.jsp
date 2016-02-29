<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>上线列表</title>
<style type="text/css">
	.col-md-8{width: 20% ;margin-top: 30px;margin-bottom: 30px;margin-right: 20px;}
	.col-md-4{width: 100% ;margin-top: 30px;margin-bottom: 30px;}
	.col-md-12{width: 100% ;margin-bottom: 30px;}
	.form-control{width: 30%;display: inline-block;margin-right: 10px;}
	.dev_label{margin-right: 20px;margin-bottom: 20px;}
	.date_label{margin-right: 20px;margin-bottom: 20px;}
    .ole_label{margin-right: 20px}
    .am-btn am-btn-primary{margin-left: 20px;margin-right: 20px;margin-top: 20px;margin-bottom: 20px;}
    .am-g {margin-left: 0px;margin-bottom: 20px;width: 50%;}    
    .date{display: inline-block;width: 40%;}
    .condition{margin-top: 5%;margin-left:10px;}
    .pageInfo{width: 30%;margin-left: 60%;}                                            
</style>
</head>
<body>
<div class="content">
    <div class="title"><span class="text">上线列表</span></div>   		
    <div class="condition"> 
    	<div class="am-alert am-alert-danger" id="my-alert" style="display: none">
		  <p>开始日期应小于结束日期！</p>
		</div>
		<label class="date_label">上线日期</label>
		<div class="am-g">
		  <div class="date">
  				<input type="text" class="am-form-field" data-am-datepicker="data-am-datepicker={theme: 'success'}" placeholder="开始日期" data-am-datepicker readonly/>
		  </div>
		  <label class="date_label">至</label>
		  <div class="date">
		    	<input type="text" class="am-form-field" data-am-datepicker="data-am-datepicker={theme: 'success'}" placeholder="结束日期" data-am-datepicker readonly/>
		  </div>
		</div>
	  
		<label class="dev_label">开发人</label>	
		
		<!-- <input id="searchDep" type="text"></input> -->
		
		<select id='dev_selected' data-am-selected="{searchBox: 1}">
		  <option value="b">张宣亚</option>
		  <option value="o">张乐玫</option>
		  <option value="m">张士蒙</option>
		</select>
		<label class="ole_label">上线人</label>
		<!-- <input id="searchOnline" type="text"></input> -->
		<select id='exe_selected' data-am-selected="{searchBox: 1}">
		  <option value="b">张宣亚</option>
		  <option value="o">张乐玫</option>
		  <option value="m">张士蒙</option>
		</select>
		<button type="button" onclick="searchList()" class="am-btn am-btn-primary">查询</button>
		<button type="button" data-selected="add" class="am-btn am-btn-primary">添加选项</button>
   </div>
	 

    <table id="table" class="table table-striped table-bordered" style="text-align:center">
        <tbody>
           
        </tbody>
    </table>
    <div class="pageInfo">
	    <ul data-am-widget="pagination" class="am-pagination am-pagination-select">
		  <li class="am-pagination-prev ">
		    <a href="#" class="">上一页</a>
		  </li>
		  <li class="am-pagination-select">
		    <select>
		      <option value="#" class="">1/3</option>
		      <option value="#" class="">2/3</option>
		      <option value="#" class="">3/3</option>
		    </select>
		  </li>
		  <li class="am-pagination-next ">
		    <a href="#" class="">下一页</a>
		  </li>
		</ul>
	</div>
</div>
</body>
<script type="text/javascript">
		  
		   $(function() {
			   var $selectedDev = $('#dev_selected');
			   var $selectedExe = $('#exe_selected');
			   var i = 0;
			   
			   $('[data-selected]').on('click', function() {
				    var action = $(this).data('selected');
					//动态添加
				    if (action === 'add') {
				      $selectedDev.append('<option value="o' + i +'">动态插入的选项 ' + i + '</option>');
				      $selectedExe.append('<option value="o' + i +'">动态插入的选项 ' + i + '</option>');
				      i++;
			   }
		   });
			   
			   
		   $(".start_date").datepicker({
				format:"yyyy-mm-dd"
			}); 
			$(".end_date").datepicker({
				format:"yyyy-mm-dd"
			});  
			
			 $.ajax({ 
				url: "http://localhost:8080/family/onlineorder/p1",
		        contentType:"application/json",
		        dataType: "json",
		        timeout: 50000,
		        success: function(json){ 
		        	if(json){
		        		if(json.status=="1"){
		        			$("tbody").append(" <tr><th>上线内容简述</th><th>申请日期</th><th>上线日期</th><th>开发人</th><th>上线人</th><th>状态</th><th>操作</th></tr>  ")
		        			for(var i=0;i<json.result.list.length;i++){
		        				var result=json.result.list[i];
		        				$("tbody").append("<tr><td>"+result.content+"</td><td>"+result.modifytime
		        						+"</td><td>"+result.executtime+"</td><td>"+result.developername
		        						+"</td><td>"+result.executorname+"</td><td>"+result.status
		        						+"</td><td><button type='button' class='am-btn am-btn-danger'>删除</button></td></tr>");
	
		        			}
		        		}
		        	}
		        },
				error:function(message){
					 console.log(message);
				 }
			 });
				 
			    /* var startDate = new Date(2014, 11, 20);
			    var endDate = new Date(2014, 11, 25);
			    var $alert = $('#my-alert'); */
			    
		    $('#my-start').datepicker().
		      on('changeDate.datepicker.amui', function(event) {
		        if (event.date.valueOf() > endDate.valueOf()) {
		          $alert.find('p').text('开始日期应小于结束日期！').end().show();
		        } else {
		          $alert.hide();
		          startDate = new Date(event.date);
		          $('#my-startDate').text($('#my-start').data('date'));
		        }
		        $(this).datepicker('close');
		      });

		    $('#my-end').datepicker().
		      on('changeDate.datepicker.amui', function(event) {
		        if (event.date.valueOf() < startDate.valueOf()) {
		          $alert.find('p').text('结束日期应大于开始日期！').end().show();
		        } else {
		          $alert.hide();
		          endDate = new Date(event.date);
		          $('#my-endDate').text($('#my-end').data('date'));
		        }
		        $(this).datepicker('close');
		      });
			});
		   
		   function searchList(){
				console.log(typeof(JSON.stringify($('#searchList').serializeJson())));	
				var tmp = JSON.stringify($('#searchList').serializeJson());
				console.log(tmp);
				$.ajax({
					cache: false,
					type: "POST",
					contentType: "application/json",
					url:"http://localhost:8080/family/onlineorder/queryByCondition",
					data:tmp,	//要发送的是ajaxFrm表单中的数据
					error: function(e) {
						$(".am-alert-danger").css({display:"block"})
					},
					success: function(data) {
						$(".am-alert-success").css({display:"block"})
					}
			   });
		}
</script>
</html>