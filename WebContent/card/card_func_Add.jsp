
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卡管理功能——开户</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h2 style = "text-align:center;" >开户信息登记表</h2>
  <form action="do_func_Add.jsp" method="post" style = "padding-left:500px;">
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
	   <span class="input-group-addon">密 码:</span>
	   <input  name="card_password" type="password" class="form-control" placeholder="输入密码" >
	 </div>
  </tr>
  <tr>
  <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">重复密码:</span>
	   <input  type="password" class="form-control" placeholder="重复密码" >
	 </div>
  </tr>
  <tr>
     <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">用户名:</span>
	   <input  name="card_name" type="text" class="form-control" placeholder="输入用户名" >
	 </div>
  </tr>
  <tr>
    <div class="input-group" style = "width:300px; margin-top:20px;">
	   <span class="input-group-addon">是否挂失</span>
	   <div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon">
						<input type="radio" value="0" name="card_losted" checked>否
					</span>
					<span class="input-group-addon">
						<input type="radio" value="1" name="card_losted" >是
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