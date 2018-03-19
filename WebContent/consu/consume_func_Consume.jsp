<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卡管理功能——开户</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h2 style = "text-align:center;" >消费信息登记表</h2>
  <form action="do_func_Consume.jsp" method="post" style = "padding-left:500px;">
  <table style = "margin:0 auto;">
  <tbody>
   <tr>
    <div class="input-group" style = "width:300px;  margin-top:20px;">
	   <span class="input-group-addon">卡号</span>
	   <input  name="card_id" type="text" class="form-control" placeholder="输入卡号" >
	</div>
  </tr>
  <tr>
  <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">消费名称:</span>
	   <input name="consume_name" type="text" class="form-control" placeholder="输入消费名称" >
	 </div>
  </tr>
  <tr>
     <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">消费金额:</span>
	   <input  name="consume_how" type="text" class="form-control" placeholder="输入消费金额" >
	 </div>
  </tr>
   </tbody>
 </table>
<p >
 <button type="submit" class="btn btn-primary btn-lg" style = "margin-top:20px;"> 提 交 </button>
  <button type="reset" class="btn btn-primary btn-lg" style = "margin-left:20px; margin-top:20px;"> 重 置 </button>
</p>
</form>
</body>
</html>