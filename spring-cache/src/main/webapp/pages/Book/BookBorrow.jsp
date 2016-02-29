<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>图书借阅</title>
</head>
<body>
<div class="content">
    <div class="title">
    	<span class="table_title">图书信息管理</span>
    	<span class="operation">
	    	<span class="addone" id="add_one" onclick="show(this)">添加</span>
	    	<span class="file" id="add_file" onclick="show(this)">导入文件</span>
    	</span>
    </div>
    <table id="table" class="table table-striped table-bordered" style="text-align:center">
        <tbody>
		
        </tbody>
    </table>
    <div id="pages" ></div>
</div>

</body>
<script type="text/javascript">
   //删除图书
	function deleteRow(obj){
		$.ajax({
			cache: false,
			type: "POST",
			contentType: "application/json",
			url:"/family/book/6",
			data:{},	//要发送的是ajaxFrm表单中的数据
			error: function(e) {
				$(".am-alert-danger").css({display:"block"})
			},
			success: function(data) {
				$(".am-alert-success").css({display:"block"})
			}
		});
	};
	
	//编辑图书
	function edit(obj){
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url:"/family/bookedit/{id}",
			data:{},	//要发送的是ajaxFrm表单中的数据
			error: function(e) {
				$(".am-alert-danger").css({display:"block"});
				$(".am-alert-danger p").text("编辑提交失败");
			},
			success: function(data) {
				$(".am-alert-success").css({display:"block"});
				$(".am-alert-success p").text("编辑提交成功");
			}
		});
	}
	
	//预约
	function renew(obj){
		console.log($(obj));
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url:"/family/book/renew/{id}",
			data:{},	//要发送的是ajaxFrm表单中的数据
			error: function(e) {
				$(".am-alert-danger").css({display:"block"});
				$(".am-alert-danger p").text("续借失败");
			},
			success: function(data) {
				$(".am-alert-success").css({display:"block"});
				$(".am-alert-success p").text("续借成功");
			}
		});
	}
	
	//借书
	function book(obj) {		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url:"/family/book/6",
			data:{},	//要发送的是ajaxFrm表单中的数据
			error: function(e) {
				$(".am-alert-danger").css({display:"block"});
				$(".am-alert-danger p").text("预约失败");
			},
			success: function(data) {
				$(".am-alert-success").css({display:"block"});
				$(".am-alert-success p").text("预约成功");
			}
		});
	}
	var pagemove=function(pageclicknumber){
		$.ajax({ 
			type:"POST",
			url: "/family/book/p"+pageclicknumber,	
	        contentType: "application/json",
	        dataType: "json",
	        timeout: 50000,	       
	        data:"{}",
	        success: function(json){
	        	if(json){
	        		if(json.status=="1"){
	        			var pageclickednumber=json.result.pageNum;
	        			var pagecount=json.result.pages;
	        			$("#pages").pager({pagenumber: pageclickednumber, pagecount:pagecount,buttonClickCallback: pagemove});
	        			$("tbody").html("");
	        			$("tbody").append("<tr><th>图书类别</th><th>图书名称</th><th>图书编号</th><th>借阅状态</th><th>借阅人</th><th>借出日期</th><th>应还日期</th><th>续借/预约</th><th>编辑</th></tr>")
	        			for(var i=0;i<json.result.list.length;i++){
	        				var result=json.result.list[i];
	        				if(result.borrowstatus==1){
	        					$("tbody").append("<tr><td>"+result.bookclass+"</td><td>"+result.bookname+"</td><td>"+result.bookno+
	        						"</td><td>可借</td><td>--</td><td>"+result.borrowdate+"</td><td>"+result.returndate+
	        						"</td><td><button class='book am-btn am-btn-success am-btn-sm' value='借阅' onclick='book(this)'>借阅</button></td>"+
	        						"<td><button class='renew am-btn am-btn-success am-btn-sm' value='编辑' onclick='edit(this)'>编辑</button>"+
	                                "<button class='book am-btn am-btn-default am-btn-sm' value='删除' onclick='delete(this)'>删除</button></td></tr>");
	        				}else{
	        					$("tbody").append("<tr><td>"+result.bookclass+"</td><td>"+result.bookname+"</td><td>"+result.bookno+
		        						"</td><td>不可借</td><td>"+result.borrowername+"</td><td>"+result.borrowdate+"</td><td>"+result.returndate+
		        						"</td><td><button class='renew am-btn am-btn-success am-btn-sm'  value='续借' onclick='renew(this)'>续借</button>"+
		        		            	"<button class='book am-btn am-btn-success am-btn-sm'  value='预约' onclick='book(this)'>预约</button></td>"+
		        		            	"<td><button class='renew am-btn am-btn-success am-btn-sm' value='编辑' onclick='edit(this)'>编辑</button>"+
     	                                "<button class='book am-btn am-btn-default am-btn-sm' value='删除' onclick='delete(this)'>删除</button></td></tr>");
	        				}
	        			}
	        		}
	        	}
	        },
			error:function(message){
				 console.log(message);
			 }
		 });
	};
	
	$(function(){						
		 $.ajax({ 
			type:"POST",
			url: "/family/book/p1",	
	        contentType: "application/json",
	        dataType: "json",
	        timeout: 50000,	       
	        data:"{}",
	        success: function(json){
	        	if(json){
	        		if(json.status=="1"){
	        			var pageclickednumber=json.result.pageNum;
	        			var pagecount=json.result.pages;
	        			$("#pages").pager({pagenumber: pageclickednumber, pagecount:pagecount,buttonClickCallback: pagemove});
	        			$("tbody").append("<tr><th>图书类别</th><th>图书名称</th><th>图书编号</th><th>借阅状态</th><th>借阅人</th><th>借出日期</th><th>应还日期</th><th>续借/预约</th><th>编辑</th></tr>")
	        			for(var i=0;i<json.result.list.length;i++){
	        				var result=json.result.list[i];
	        				if(result.borrowstatus==1){
	        					$("tbody").append("<tr><td>"+result.bookclass+"</td><td>"+result.bookname+"</td><td>"+result.bookno+
	        						"</td><td>可借</td><td>--</td><td>"+result.borrowdate+"</td><td>"+result.returndate+
	        						"</td><td><button class='book am-btn am-btn-success am-btn-sm' value='借阅' onclick='book(this)'>借阅</button></td>"+
	        		            	"<td><button class='renew am-btn am-btn-success am-btn-sm' value='编辑' onclick='edit(this)'>编辑</button>"+
 	                                "<button class='book am-btn am-btn-default am-btn-sm' value='删除' onclick='delete(this)'>删除</button></td></tr>");
	        				}else{
	        					$("tbody").append("<tr><td>"+result.bookclass+"</td><td>"+result.bookname+"</td><td>"+result.bookno+
		        						"</td><td>不可借</td><td>"+result.borrowername+"</td><td>"+result.borrowdate+"</td><td>"+result.returndate+
		        						"</td><td><button class='renew am-btn am-btn-success am-btn-sm'  value='续借' onclick='renew(this)'>续借</button>"+
		        		            	"<button class='book am-btn am-btn-success am-btn-sm'  value='预约' onclick='book(this)'>预约</button></td>"+
		        		            	"<td><button class='renew am-btn am-btn-success am-btn-sm' value='编辑' onclick='edit(this)'>编辑</button>"+
     	                                "<button class='book am-btn am-btn-default am-btn-sm' value='删除' onclick='delete(this)'>删除</button></td></tr>");
	        				}
	        			}
	        		}
	        	}
	        },
			error:function(message){
				 console.log(message);
			 }
		 });
	 });
</script>
</html>