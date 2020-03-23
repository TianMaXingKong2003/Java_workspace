<%@page import="cn.itcast.domain.User"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<title>Hello JSP</title>
</head>
<body>

<%
User user=(User) request.getSession().getAttribute("user");
%>

	<h1>登录成功，<%=user.getUsername()%>，欢迎您！</h1>

</body>
</html>