<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息列表</title>
</head>
<body>
	
	<table border="1px">
		<caption>用户信息列表</caption>
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.age }</td>
			</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>