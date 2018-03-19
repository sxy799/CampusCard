<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理引导页面</title> 
<frameset rows="20%,*" >
      <frame  src="book/book_top.jsp" name="topFrame"frameborder="0" >
            <frameset cols="10%,*"frameborder="0" >       
                  <frame src="book/book_left.jsp" name="left"/>  
                  <frame src="book/book_right.jsp" name="right"/> 
       </frameset>             
</frameset>