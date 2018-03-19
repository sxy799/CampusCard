<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息头</title>
</head>
<body style = " background:url(top3.png) no-repeat  center; background-color:RGB(47,85,151);">
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
	  java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(    
	     "yyyy-MM-dd HH:mm:ss");    
	   java.util.Date currentTime = new java.util.Date();    
	   String time = simpleDateFormat.format(currentTime).toString();   
	%>
	<br><br>
    <p style = "color:white;font-size:14px;float:left;letter-spacing:1px;">您好！<%=loginName%>(<%=loginId%>), 欢迎登录！</p>
    <p style = "color:white;font-size:14px;float:right;letter-spacing:1px;">当前时间:<%=time%></p>
</body>
</html>