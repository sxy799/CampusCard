<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理卡功能—销户</title>
</head>
<body>
  <%
      String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
      String card_id ="";
      request.setCharacterEncoding("utf-8");//防止中文乱码
      card_id = request.getParameter("CardId");
      System.out.println("销户card_id"+card_id);
   %>
   <%  
        Card card = new Card();
        Connection connection = card.getConnection();
        card.DelCardInfo(connection,card_id);
        card.ReleaseResource();
   %>
   <script lanuage="javascript">
       alert("销户成功！");
   </script>
</body>
</html>