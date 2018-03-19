<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书功能——借出查询</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
   <%  
        book book = new book();
        Connection connection = book.getConnection();
        ResultSet rs = book.SelectBookInfoByBorrowed(connection); 
   %>  
      <br> 
    <br>
     <h2 style = "text-align:center;">借出图书表格</h2>
      <table class="table table-striped table-bordered table-hover table-condensed" align="center"> 
        <tr> 
            <th> 
                <% 
                    out.print("卡号"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("图书编号"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("图书名字"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("是否归还"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("归还期限"); 
                %> 
            </th> 
        </tr> 
 
        <% 
            while (rs.next()) { 
        %> 
        <tr> 
            <td> 
                <% 
                    out.print(rs.getString(1)); 
                %> 
            </td> 
            <td> 
                <% 
                    out.print(rs.getString(2)); 
                %> 
            </td> 
            <td> 
                <% 
                    out.print(rs.getString(3)); 
                %> 
            </td> 
            <td> 
                <% 
                    out.print(rs.getString(4)); 
                %> 
            </td> 
            <td> 
                <% 
                    out.print(rs.getString(5)); 
                %> 
            </td> 
        </tr> 
        <% 
            } 
        %> 
    </table> 
    <% 
        book.ReleaseResource();
    %>
</body>
</html>