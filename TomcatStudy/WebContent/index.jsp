<%@ page language="java" contentType="text/html; charset=gbk"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<title>Hello JSP</title>
</head>
<body>
	<%
		System.out.println("��� jsp");
	%>

	<%="��� JSP" %>

	<%
		response.getWriter().write("response���������request�������");
	%>

</body>
</html>