<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <div id="main" style="height:400px"></div>
	<script src="<%=request.getContextPath()%>/resource/js/echarts-2.2.2/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
            	echarts: '<%=request.getContextPath()%>/resource/js/echarts-2.2.2/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                option = {
                	    title : {
                	        text: '图书类别统计图',
                	        x:'center'
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter: "{b} : {c} ({d}%)"
                	    },
                	    legend: {
                	        orient : 'vertical',
                	        x : 'left',
                	        data:['网络编程','算法','移动开发','文学名著']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            dataView : {show: true, readOnly: false},
                	            magicType : {
                	                show: true, 
                	                type: ['pie', 'funnel'],
                	                option: {
                	                    funnel: {
                	                        x: '25%',
                	                        width: '50%',
                	                        funnelAlign: 'left',
                	                    }
                	                }
                	            },
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    series : [
                	        {
                	            name:'图书类别统计信息',
                	            type:'pie',
                	            radius : '55%',
                	            center: ['50%', '60%'],
                	            data:[
                	                {value:33, name:'网络编程'},
                	                {value:20, name:'算法'},
                	                {value:10, name:'移动开发'},
                	                {value:3, name:'文学名著'}
                	            ]
                	        }
                	    ]
                	};
                	                    
                myChart.setOption(option); 
            }
        );
    </script>