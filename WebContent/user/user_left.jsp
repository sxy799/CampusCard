<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卡管理——左侧</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
  <% 
   String loginName = "",loginId = "";
	if(session.getAttribute("loginName")!=null)
   {
	loginName = session.getAttribute("loginName").toString();
	loginId = session.getAttribute("loginId").toString();
	}
	 System.out.println("name" + loginName);
	 System.out.println("id" + loginId);
  %>
  <table class = "table table-condensed table-hover" style = "text-align:center;font-size:16px; text-decoration:none;">
    <caption style = "text-align:center;font-size:20px;color:blue;">功能面板</caption>
    <tr >
        <td ><a href = "user_fun_card.jsp" target="right">查询卡信息</a></td>
    </tr>
    <tr>
        <td ><a href = "user_fun_book.jsp" target="right">查询图书信息</a></td>
    </tr>
    <tr>
        <td><a href = "user_fun_consume.jsp" target="right">查询消费信息</td>
    </tr>
  </table>
  <br><br>
  
</body>
</html>