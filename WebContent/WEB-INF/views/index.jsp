<%@ page language="java" import="com.cavlib.beans.Post,com.cavlib.beans.User ,java.util.List"  pageEncoding="utf-8"%>
<%  
 String path = request.getContextPath();  
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <base href="<%=basePath%>">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="static/css/background.css" />
    <title>Hello, world!</title>
  </head>
  <body>
   <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<!--标题-->
				<div class="col-md-12">
						<h2 class="font-weight-bold welcome">
							欢迎来到CAVLIB
						</h2>

				</div>
			</div>
			<div class="row">
				<%if(session.getAttribute("user")==null){ %>
				<div class="col-md-11">
				</div>
				<div class="col-md-1 ">
					<!--登陆注册组件，jsp动态选择登陆组件还是用户名组件-->
					<div class="btn-group btn-group-sm lgin" role="group">
						 
						<button class="btn btn-secondary" type="button" data-toggle="modal" data-target="#loginModal">
							登陆
						</button> 
						<button class="btn btn-secondary" type="button" data-toggle="modal" data-target="#registerModal">
							注册
						</button>
					</div>
					<!--登陆弹出组件-->
					<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
									<div class="modal-header">
											<h4 class="modal-title" id="myModalLabel">登陆</h4>
									</div>
									<div class="modal-body">
										<form class="form-horizontal  col-md-12" method="post" action="<%=basePath %>login">
												<div class="form-group">
														<label for="inputEmail3" class="col-sm-3 control-label">用户名</label>
														<div class="col-sm-7">
															<input type="text" class="form-control" id="loginUsername" name="loginUsername" placeholder="Username">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword3" class="col-sm-3 control-label">密码</label>
														<div class="col-sm-7">
															<input type="password" class="form-control" id="loginPassword" name="loginPassword" placeholder="Password">
														</div>
												</div>
										            
												<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-primary ">登录</button>
														</div>
												</div>
										</form>
									</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</div>
					
					<!--注册弹出组件-->
					<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
									<div class="modal-header">
											<h4 class="modal-title" id="myModalLabel">注册</h4>
									</div>
									<div class="modal-body">
										<form class="form-horizontal  col-md-12" id="registerForm" name="registerForm" method="post" action="<%=basePath %>register">
												<div class="form-group">
														<label for="inputEmail3" class="col-sm-5 control-label">用户名</label>
														<div class="col-sm-12">
															<input type="text" class="form-control" id="reisterUsername" name="reisterUsername" required="required" pattern="[A-Za-z0-9]{6,30}" placeholder="Username">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword3" class="col-sm-5 control-label">密码</label>
														<div class="col-sm-12">
															<input type="password" class="form-control" id="reisterPassword1" name="reisterPassword1" required="required" pattern="[A-Za-z0-9]{6,30}" placeholder="Password">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword4" class="col-sm-5 control-label">确认密码</label>
														<div class="col-sm-12">
															<input type="password" class="form-control" id="reisterPassword2" name="reisterPassword2" placeholder="Confirm" required="required" pattern="[A-Za-z0-9]{6,30}">
														</div>
												</div>
												<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="submit" class="btn btn-primary ">注册</button>
														</div>
												</div>
										</form>
									</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</div>
					
					
				</div>
				<%}else{ %>
				<div class="col-md-11">
				</div>
				<div class="col-md-1">
					<div class="dropdown">
				 
						<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
							<%=((User)session.getAttribute("user")).getName() %>
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#">我的帖子</a> 
							<a class="dropdown-item" href="#">编写新帖子</a> 
							<a class="dropdown-item" href="#">注销</a>
						</div>
					</div>
				</div>
				<%} %>
			</div>
			<div class="blank"></div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark radius">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="getPosts?back=true">首页</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item">
							 <a class="nav-link" href="getPosts?tag=">讨论 <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							 <a class="nav-link" href="getPosts?tag=">资源</a>
						</li>
						
					</ul>
					
					<ul class="navbar-nav ml-md-auto">
						<!--搜索表单-->
						<form class="form-inline" method="post" action="<%=basePath %>getPosts">
							<input class="form-control mr-sm-2" id="keyword" type="text" /> 
							<button class="btn btn-primary my-2 my-sm-0" type="submit">
								Search
							</button>
						</form>
					</ul>
				</div>
			</nav>
			
		</div>
	</div>
	<!-- =================================================================以上逻辑复制index.jsp========================================================================= -->>
	<!--文章容器div，jsp动态加入文章-->
	<div class="row ">
		<!--标准文章div-->
		<%for(Post post:(List<Post>) session.getAttribute("posts")) {%>
		<div class="col-md-11 passage">
			<h2 class="passage">
				<%=post.getTitle() %>
			</h2>
			<%if(post.getContent().length()>20){ %>
			<p>
				<%=post.getContent().substring(0, 20) %>
			</p>
			<%} else{%>
			<p>
				<%=post.getContent() %>
			</p>
			<%} %>
			<%if(session.getAttribute("user")!=null){ %>
			<p>
				<a class="btn btn-primary radius" href="#">View details »</a>
			</p>
				<%if(((User)(session.getAttribute("user"))).getIsManager()||post.getUser_id()==((User)(session.getAttribute("user"))).getId()){ %>
			<p>
				<a class="btn btn-danger radius" href="#">Delete</a>
			</p>
				<%} %>
			<%} %>
			
			
		</div>
		<%} %>
	</div>
	<!--分页器,jsp根据数据库动态生成,显示5个页数摁钮、快速前进后退摁钮、前进后退摁钮-->
	<%Integer pageindex=(Integer)(session.getAttribute("pageindex")); %>
	<div class="col-md-12 pagenav">
					<nav>
						<ul class="pagination">
							<!--普通按钮，点击一次到达相应页-->
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex-1 %>">Previous</a>
							</li>
							<!--快速跳过按钮，点击一次后退5页-->
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex-5 %>">...</a>
							</li>
							<%if(pageindex>=3) {%>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex-2 %>"><%=pageindex-2 %></a>
							</li>
							<%} %>
							<%if(pageindex>=2) {%>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex-1 %>"><%=pageindex-1 %></a>
							</li>
							<%} %>
							<!--当前页-->
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex %>"><%=pageindex %> <span class="sr-only">(current)</span></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex+1 %>"><%=pageindex+1 %></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex+2 %>"><%=pageindex+2 %></a>
							</li>
							<%if(pageindex<=2) {%>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=4">4</a>
							</li>
							<%if(pageindex==1) {%>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=5">5</a>
							</li>
							<%} %>
							<%} %>
							<!--快速跳过按钮，点击一次5前进页-->
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex+5 %>">...</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=<%=pageindex+1 %>">Next</a>
							</li>
						</ul>
					</nav>
				</div>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>