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

	<h1>��¼�ɹ���<%=user.getUsername()%>����ӭ����</h1>

</body>
</html>