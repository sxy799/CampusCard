<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理功能——借书</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h2 style = "text-align:center;" >借书信息登记表</h2>
  <form action="do_fun_Borrow.jsp" method="post" style = "padding-left:500px;">
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
	   <span class="input-group-addon">图书编号:</span>
	   <input  name="book_id" type="text" class="form-control" placeholder="输入图书编号" >
	 </div>
  </tr>
  <tr>
  <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">图书名字:</span>
	   <input   name="book_name"  type="text" class="form-control" placeholder="图书名字" >
	 </div>
  </tr>
  <tr>
    <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">是否归还</span>
	   <div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon">
						<input type="radio" value="0" name="borrowed" checked>否
					</span>
					<span class="input-group-addon">
						<input type="radio" value="1" name="borrowed" >是
					</span>
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 --><br>
		</div><!-- /.row -->
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