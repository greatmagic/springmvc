<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>借阅提示信息设置</title>
  </head>  
  <body>
    <form action="/springmvc/springMvc/upload" enctype="multipart/form-data" method="post">    
    	借阅提醒信息：<input type="file" name="file" id="file"/>
    	<button type="submit" class="fileBtn">上传</button>
    </form>
  </body>
</html>
