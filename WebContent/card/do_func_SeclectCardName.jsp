<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理卡功能—姓名查询</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%
      String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
      String card_name ="";
      request.setCharacterEncoding("utf-8");//防止中文乱码
      card_name = request.getParameter("CardName");
      System.out.println("姓名" + card_name);
   %>
   <%  
        Card card = new Card();
        Connection connection = card.getConnection();
        ResultSet rs = card.SelectCardInfoByCardName(connection ,card_name);
   %>
    <h4><p style = "text-align:center;">姓名  ：<font color="red"><%= card_name%></font>的卡信息如下：</p></h4>
      <table class="table table-striped table-bordered table-hover table-condensed" align="center"> 
        <tr> 
            <th> 
                <% 
                    out.print("卡号"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("密码"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("用户名"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("是否挂失"); 
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
        </tr> 
        <% 
            } 
        %> 
    </table> 
    <% 
        card.ReleaseResource();
    %>  
</body>
</html>