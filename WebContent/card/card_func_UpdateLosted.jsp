<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卡功能——挂失</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
  <h2 style = "text-align:center;" >卡号挂失</h2>
<form action="do_func_UpdateLosted.jsp" method="post">
	<div   class="row">
              <div  class="col-lg-6">
                <p> 输入要挂失的卡号:</p>
                  <div  class="input-group">
                       <input name="CardId" type="text" class="form-control">
                       <span class="input-group-btn">
                            <button class="btn btn-default"  type = "submit">
                                                                                确定
                            </button>
                       </span>
                  </div><!-- /input-group -->
              </div><!-- /.col-lg-6 -->
   </div><!-- /.row -->
</form>
</body>
</html>