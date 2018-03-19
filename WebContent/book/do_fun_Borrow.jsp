<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理图书功能—借书</title>
</head>
<body>
   <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  String card_id = "";
  String book_id = "";
  String book_name = "";
  String borrowed = "";
  String deadline = "";
   
  request.setCharacterEncoding("utf-8");//防止中文乱码
  card_id = request.getParameter("card_id");
  book_id = request.getParameter("book_id");
  book_name = request.getParameter("book_name");
  borrowed = request.getParameter("borrowed");
  System.out.println("****" + card_id);
	
   book book = new book();
   Connection connection = book.getConnection();
   deadline = book.GetTime ();
   book.AddBookInfo(connection ,card_id,book_id,book_name,borrowed,deadline);
   book.ReleaseResource();
  %>
  <script lanuage="javascript">
      alert("借书信息办理成功！");
  </script>
</body>
</html>