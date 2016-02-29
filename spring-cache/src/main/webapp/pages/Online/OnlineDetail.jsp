<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<!-- 引入进度条文件 -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/progress.css" type="text/css">
<style type="text/css">
.folder
{
	float:right;
	font-size:5px;
	font-weight:normal;
}
</style>
<title>上线详情</title>
</head>
<body>
<div class="content">
  <div class="title">
    	<span class="table_title">上线详情</span>
</div> 
<div class="am-g">
  <div class="am-u-md-12" style="padding-left: 0px;padding-right: 0px;">
  <div class="progress">
  <div class="circle done">
    <span class="label">1</span>
    <span class="title_bar">已提交</span>
  </div>
  <span class="bar done"></span>
  <div class="circle done">
    <span class="label">2</span>
    <span class="title_bar">待审批</span>
  </div>
  <span class="bar half"></span>
  <div class="circle active">
    <span class="label">3</span>
    <span class="title_bar">待选取</span>
  </div>
  <span class="bar"></span>
  <div class="circle">
    <span class="label">4</span>
    <span class="title_bar">待上线</span>
  </div>
  <span class="bar"></span>
  <div class="circle">
    <span class="label">5</span>
    <span class="title_bar">完成</span>
  </div>
</div>
  </div>
</div>
<div class="am-g">
  <div class="am-u-md-12" style="padding-left: 0px;padding-right: 0px;">
  <div class="am-panel-group" id="accordion">
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#panel1'}">
      	 	<span>上线申请</span><span class="folder">展开/折叠</span> 
      </h4>
      
    </div>
    <div id="panel1" class="am-panel-collapse am-collapse am-in">
      <div id="detail1" class="am-panel-bd">
        <ul>
			<li style="margin-bottom:5px;width:100%;overflow:auto;">
				生产服务器IP：
				<div id="producerip" style="float:right;text-align:left;width:60%;"></div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线工程名/SVN版本号：
				<div id="projectname" style="float:right;text-align:left;width:60%;"></div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线内容：
				<div id="content" style="float:right;text-align:left;width:60%;">
				</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">
				<div style="display:inline;">对系统的影响：
				<div id="effect" style="float:right;text-align:left;width:60%;">
				</div></div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">开发人：
				<div id="developername" style="float:right;;text-align:left;width:60%;">
				</div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">测试用例：
				<div id="testcase" style="float:right;text-align:left;width:60%;"></div>
			</li>
			<li style="margin-bottom: 5px;width:100%;overflow:auto;">上线后测试人员：
				<div id="testername" style="float:right;text-align:left;width:60%;"></div>
			</li>
		</ul>
      </div>
    </div>
  </div>
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#panel2'}">
        	<span>上线审批</span><span class="folder">展开/折叠</span>
      </h4>
    </div>
    <div id="panel2" class="am-panel-collapse am-collapse">
      <div id="detail2" class="am-panel-bd">
      <ul>
	      <li style="margin-bottom: 5px;width:100%;overflow:auto;">第一审批人：
					<div id="firstauditorname" style="float:right;text-align:left;width:60%;"></div>
		  </li>
		  <li style="margin-bottom: 5px;width:100%;overflow:auto;">第二审批人：
					<div id="secondauditorname" style="float:right;text-align:left;width:60%;"></div>
		  </li>
		  <li style="margin-bottom: 5px;width:100%;overflow:auto;">审核状态：
					<div id="status" style="float:right;text-align:left;width:60%;"></div>
		  </li>
	  </ul>
      </div>
    </div>
  </div>
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 id="" class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#panel3'}">
    	  <span>选取上线人</span><span class="folder">展开/折叠</span>
      </h4>
    </div>
    <div id="panel3" class="am-panel-collapse am-collapse">
      <div id="executorname" class="am-panel-bd">
        <!-- <button type="button" class="am-btn am-btn-primary" style="float:right;height: 33px">更改</button> -->
      </div>
    </div>
  </div>
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#panel4'}">
    	 <span>上线结果</span><span class="folder">展开/折叠</span>
      </h4>
    </div>
    <div id="panel4" class="am-panel-collapse am-collapse">
      <div id="detail4" class="am-panel-bd">
        	<div class="am-radio">
      <label>
        <input type="radio" id="radio1" name="doc-radio-1" value="option1" checked>
        	上线成功
      </label>
    </div>
    <div class="am-radio">
      <label>
        <input type="radio" id="radio2" name="doc-radio-1" value="option2">
        	上线失败
      </label>
    </div>
    <div class="am-form-group">
    <span>
    <input type="text" id="doc-ds-ipt-1" class="am-form-field" style="width:60%" placeholder="失败原因" disabled>
    <button type="submit" class="am-btn am-btn-primary">提交</button>
    </span>
    <!-- 
    	通过以下方法删除disable属性
    	$('#areaSelect').removeAttr("disabled");
     -->    
    </div>
    
      </div>
    </div>
  </div>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
//加载数据
/* function click(){
	if($('#radio1').)
	{
		
	}
	else if()
	{
		
	}
} */
$(function(){								
		 $.ajax({ 
			url: "http://127.0.0.1:8080/family/onlineorder/query/1",	
	        contentType: "application/json",
	        dataType: "json",
	        timeout: 50000,
	        data:{},
	        success: function(json){
	        	if(json.status==1)
	        	{
	        		$('#status').append("待审批");
	        		active2();
	        	}
	        	else if(json.status==2)
	        	{
	        		$('#status').append("审批通过");
	        		active3();
	        	}
	        	else if(json.status==3)
        		{
	        		$('#status').append("审批通过");
	        		active4();
        		}
	        	else if(json.status==4)
        		{
	        		$('#status').append("审批通过");
	        		all_done();
        		}
	        	else if(json.status==5)
        		{
	        		$('#status').append("审批通过");
	        		all_done();
        		}
	        	else if(json.status==6)
        		{
	        		$('#status').append("审批不通过");
        		}
	        	else if(json.status==7)
        		{
        			
        		}
	        	$('#producerip').append(json.result.result.producerip);
	        	$('#projectname').append(json.result.result.projectname);
	        	$('#content').append(json.result.result.content);
	        	$('#effect').append(json.result.result.effect);
	        	$('#developername').append(json.result.result.developername);
	        	$('#testcase').append(json.result.result.testcase);
	        	$('#testername').append(json.result.result.testername);
	        	$('#firstauditorname').append(json.result.result.firstauditorname);
	        	$('#secondauditorname').append(json.result.result.secondauditorname);
	        	$('#executorname').append(json.result.result.executorname);
	        	console.log();
	        },
			error:function(message){
				 console.log(message);
			 }
		 });
	 });
//展开所有列表
// $('#panel1').collapse('open');
$('#panel2').collapse('open');
$('#panel3').collapse('open');
$('#panel4').collapse('open');
//进度条控制
	var i = 1;
//进度条初始化
	$('.progress .circle').removeClass().addClass('circle');
	$('.progress .bar').removeClass().addClass('bar');
	$('.progress .circle:nth-of-type(1) .label').html('1'); 
	$('.progress .circle:nth-of-type(2) .label').html('2'); 
	$('.progress .circle:nth-of-type(3) .label').html('3'); 
	$('.progress .circle:nth-of-type(4) .label').html('4'); 
	$('.progress .circle:nth-of-type(5) .label').html('5'); 
	//激活
	function active1()
	{
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle:nth-of-type(1)').addClass('active');
	}
	function active2()
	{
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle:nth-of-type(1)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(1) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(2)').addClass('active');
	}
	function active3()
	{
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle:nth-of-type(1)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(1) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(2)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(2) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(3)').addClass('active');
	}
	function active4()
	{
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle:nth-of-type(1)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(1) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(2)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(2) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(3)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(3) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(4)').addClass('active');
	}
	function active5()
	{
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle:nth-of-type(1)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(1) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(2)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(2) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(3)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(3) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(4)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(4) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(5)').addClass('active');
	}
	function all_done()
	{
		$('.progress .circle').removeClass().addClass('circle');
		$('.progress .bar').removeClass().addClass('bar');
		$('.progress .circle:nth-of-type(1)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(1) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(2)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(2) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(3)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(3) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(4)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(4) .label').html('&#10003;'); 
		$('.progress .circle:nth-of-type(5)').removeClass('active').addClass('done');
		$('.progress .circle:nth-of-type(5) .label').html('&#10003;'); 
	}
</script>
</html>