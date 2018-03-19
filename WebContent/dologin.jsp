<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"%>
<%@ page import= "JDBC.JDBC" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  String username ="";
  String password ="";
  request.setCharacterEncoding("utf-8");//防止中文乱码
  username = request.getParameter("username");
  password = request.getParameter("password");
  
  JDBC jdbc = new JDBC(); 
  boolean connflag = jdbc.getConnection();
  
   if(jdbc.LoginCheck(username,password) || jdbc.LoginCheckUser(username,password))
  {
	  String name = jdbc.getusername (username);
      session.setAttribute("loginName", name);
      session.setAttribute("loginId", username);
  %>
  <script type="text/javascript">
	  alert("登录成功");
      window.location.href="login_success.jsp";      <!--JavaScript代替response.sendRedirect做跳转-->
  </script>
  <% 
  }
  else
  {
	  %>
       <script type="text/javascript">
    	alert("登录失败！请检查用户或者密码!");
    	window.location.href="index.jsp";  
       </script>
     <% 
      session.setAttribute("loginId", username);
  } 
%>
