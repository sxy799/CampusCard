<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "JDBC.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消费功能——查询所有</title>
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
   <%  
        Consume consume = new  Consume();
        Connection connection = consume.getConnection();
        ResultSet rs = consume.SelectConsumeInfo(connection); 
   %>  
      <br> 
    <br>
     <h2 style = "text-align:center;"text>消费管理表格</h2>
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
                    out.print("消费种类"); 
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