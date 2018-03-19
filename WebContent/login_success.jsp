<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
          <% 
		     String loginName = "",loginId = "";
		     if(session.getAttribute("loginName")!=null)
		     {
		        loginName = session.getAttribute("loginName").toString();
		        loginId = session.getAttribute("loginId").toString();
		     }
		  %>
		 
		<%
		  // 判断身份是卡管理
		  if (loginId.substring(2,4).equals("01"))
		  {
			  session.setAttribute("loginName", loginName);
		      session.setAttribute("loginId", loginId);
			  request.getRequestDispatcher("card/card_control.jsp").forward(request, response); 
		  }
		  // 判断身份是图书管理
		  if (loginId.substring(2,4).equals("02"))
		  {
			  session.setAttribute("loginName", loginName);
		      session.setAttribute("loginId", loginId);
			  request.getRequestDispatcher("book/book_control.jsp").forward(request, response); 
		  }
		  // 判断身份是消费管理
		  if (loginId.substring(2,4).equals("03"))
		  {
			  System.out.println("zichuan***" + loginId.substring(2,4));
			  session.setAttribute("loginName", loginName);
		      session.setAttribute("loginId", loginId);
			  request.getRequestDispatcher("consu/consume_control.jsp").forward(request, response); 
		  }
		  // 判断身份是普通用户
		  if (loginId.substring(2,4).equals("22"))
		  {
			  session.setAttribute("loginName", loginName);
		      session.setAttribute("loginId", loginId);
			  request.getRequestDispatcher("user/user_control.jsp").forward(request, response); 
		  }
		%>