<%@ page language="java" contentType="text/html; charset=gbk"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<title>Hello JSP</title>
</head>
<body>
	<%
		System.out.println("你好 jsp");
	%>

	<%="你好 JSP" %>

	<%
		response.getWriter().write("response对象会先于request对象输出");
	%>

</body>
</html>