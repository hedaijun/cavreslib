<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="static/css/background.css" />
<title>封号大魔王</title>
</head>
<body>
	<%-- 	<a href="<%=request.getContextPath()%>/insertone">插入</a>
	<a href="<%=request.getContextPath()%>/getone">get</a>
	<a href="<%=request.getContextPath()%>/setbane?is_baned=true&name=dd">set</a> --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<h2 class="font-weight-bold welcome">欢迎来到CAVLIB</h2>
					</div>
				</div>

				<div class="blank"></div>
				<div class="col-md-12">
					<div class="passage row">
						<div class="col-md-3">用户ID</div>
						<div class="col-md-3">用户账号</div>
						<div class="col-md-3">是否封禁</div>
					</div>
				</div>

			</div>
		</div>
		<div class="row ">
			<!-- 循环输出非管理员账号信息 -->
			<c:forEach items="${users}" var="user">
				<c:if test="${user.getIsBaned()==false}">
					<div class="col-md-9 tablerow">
						<div class="row">
							<div class="col-md-4">${user.getUserId()}</div>
							<div class="col-md-4">${user.name}</div>
							<div class="col-md-4">未封禁</div>
						</div>
					</div>
					<a
						href="<%=request.getContextPath()%>/setbane?is_baned=true&name=${user.name}">
						<button type="button" class="btn btn-primary">封禁</button>
					</a>
				</c:if>
				<c:if test="${user.getIsBaned()==true}">
					<div class="col-md-9 tablerow">
						<div class="row">
							<div class="col-md-4">${user.getUserId()}</div>
							<div class="col-md-4">${user.name}</div>
							<div class="col-md-4">已封禁</div>
						</div>
					</div>
					<a
						href="<%=request.getContextPath()%>/setbane?is_baned=false&name=${user.name}">
						<button type="button" class="btn btn-primary">解禁</button>
					</a>
				</c:if>
			</c:forEach>
		</div>
		<!--分页器,jsp根据数据库动态生成,显示5个页数摁钮、快速前进后退摁钮、前进后退摁钮-->
		<%
			Integer pageindex = (Integer) (session.getAttribute("pageindex"));
			//System.out.println(pageindex);
		%>
		<div class="col-md-12 pagenav">
			<nav>
				<ul class="pagination">
					<!--普通按钮，点击一次到达相应页-->
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex - 1%>">上一页</a></li>
					<!--快速跳过按钮，点击一次后退5页-->
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex - 5%>">...</a></li>
					<%
						if (pageindex >= 3) {
					%>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex - 2%>"><%=pageindex - 2%></a>
					</li>
					<%
						}
					%>
					<%
						if (pageindex >= 2) {
					%>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex - 1%>"><%=pageindex - 1%></a>
					</li>
					<%
						}
					%>
					<!--当前页-->
					<li class="page-item active" aria-current="page"><a
						class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex%>"><%=pageindex%>
							<span class="sr-only">(current)</span></a></li>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex + 1%>"><%=pageindex + 1%></a>
					</li>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex + 2%>"><%=pageindex + 2%></a>
					</li>
					<%
						if (pageindex == 1) {
					%>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=4">4</a></li>
					<%
						}
					%>
					<%
						if (pageindex <= 2) {
					%>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=5">5</a></li>
					<%
						}
					%>
					<!--快速跳过按钮，点击一次5前进页-->
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex + 5%>">...</a></li>
					<li class="page-item"><a class="page-link"
						href="<%=basePath%>getpage?pageindex=<%=pageindex + 1%>">下一页</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>