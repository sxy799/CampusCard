<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理卡功能—开户</title>
</head>
<body>
   <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  String card_id = "";
  String card_password = "";
  String card_name = "";
  String card_losted = "";
  
  request.setCharacterEncoding("utf-8");//防止中文乱码
  card_id = request.getParameter("card_id");
  card_password = request.getParameter("card_password");
  card_name = request.getParameter("card_name");
  card_losted = request.getParameter("card_losted");
  
   Card card = new Card();
   Connection connection = card.getConnection();
   card.AddCardInfo(connection ,card_id,card_password,card_name,card_losted);
   card.ReleaseResource();
  %>
  <script lanuage="javascript">
      alert("开户成功！");
   </script>
</body>
</html>