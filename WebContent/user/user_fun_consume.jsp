<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户消费信息查询</title>
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
      card_id = session.getAttribute("loginId").toString();
   %>
   <%  
        Consume consume = new Consume();
        Connection connection = consume.getConnection();
        ResultSet rs = consume.SelectCardInfoByCardId(connection ,card_id);
   %>
    <h4><p style = "text-align:center;">卡号  ：<font color="red"><%= card_id%></font>的卡信息如下：</p></h4>
      <table class="table table-striped table-bordered table-hover table-condensed" align="center"> 
        <tr> 
            <th> 
                <% 
                    out.print("卡号"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("消费时间"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("消费名称"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("消费金额"); 
                %> 
            </th> 
            <th> 
                <% 
                    out.print("剩余金额"); 
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
        consume.ReleaseResource();
    %>  
</body>
</html>