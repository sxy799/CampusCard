<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理卡功能—卡号挂失</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
   <%
      String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
      String card_id ="";
      request.setCharacterEncoding("utf-8");//防止中文乱码
      card_id = request.getParameter("CardId");
   %>
   <%  
        Card card = new Card();
        Connection connection = card.getConnection();
        card.UpdateCardInfoLosted(connection,card_id); 
        card.ReleaseResource();
   %> 
    
   <script lanuage="javascript">
      alert("挂失成功！");
   </script>
</body>
</html>