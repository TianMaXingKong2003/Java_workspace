<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.js"></script>
<style type="text/css">
#tableAll {
	margin-top: 30px;
	margin-left: 40px;
	margin-right: 20px;
}

table td {
	text-align: center;
}
</style>
</head>
<body>
	<div id="tableAll">
		<table class="table table-hover table-bordered" border="1">
			<tr class="info">
				<td colspan="10" align="center"><h3>企业信息</h3></td>
			</tr>
			<tr>
				<td>企业名称</td>
				<td>企业地址</td>
				<td>薪资</td>
				<td>发布时间</td>
				
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${companyList}" var="company">
				<tr class="table table-hover">
					<td>${company.name}</td>
					<td>${company.location }</td>
					<td>${company.salary}</td>
					<td>${company.pubtime}</td>
					<td>
						<a href="updateOneServlet?cid=${company.id }&cz=update"
						class="btn btn-default" onclick="return confirm('确定要修改吗？');">修改</a> 
						<a href="updateOneServlet?cid=${company.id }&cz=delete"
						class="btn btn-default" onclick="return confirm('确定删除吗？');">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>