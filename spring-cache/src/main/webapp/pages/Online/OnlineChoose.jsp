<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<jsp:include page="/pages/navigation.jsp"></jsp:include>
<title>选择上线人</title>
</head>
<body>
	<!-- <div class="mask"> -->
     <div class="mask-selectPerson selected" style="display:block">
        <span class="mask-close" onclick="closed(this)"></span>
        <div class="logo-title"></div>
         <form action="" name="login" class="am-form am-form-horizontal">
            <div class="am-form-group" style="text-align:center">
				<label for="am-form-select" class="Person">选择上线人</label>
				<div class="am-form-select">
				    <select class="">
				       <option value="">王庆辉</option>
				       <option value="">张宣亚</option>
				       <option value="">赵晓杰</option>
				    </select>
				</div>
			</div>
		    <div class="am-form-group controller">
			    <div class="buttons ">
			      <button type="submit" class="am-btn am-btn-success">提交</button>
			    </div>
		  </div>	
         </form>
    </div>
 <!-- </div> -->
</body>
</html>