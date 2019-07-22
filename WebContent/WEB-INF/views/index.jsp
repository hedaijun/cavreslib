<%@ page language="java" import="com.cavlib.beans.Post,com.cavlib.beans.User ,java.util.List,java.util.Map"  pageEncoding="utf-8"%>
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
	
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="static/css/background.css" />
	<link rel="shortcut icon" href="static/resources/icon.ico">
	<link rel="bookmark" href="static/resources/icon.ico">
    <title>Cavlib</title>
  </head>
  <body>
   <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<!--标题-->
				<div class="col-md-11">
						<h2 class="font-weight-bold welcome">
							<img src="static/resources/icon.ico" class="img-fluid header">
							<img src="static/resources/head1.png" class="img-fluid header">
						</h2>

				</div>
			
				<%if(session.getAttribute("user")==null){ %>
				<div class="col-md-1 m-auto">
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
															<input type="text" class="form-control" id="registerUsername" name="registerUsername" required="required" pattern="[A-Za-z0-9]{6,30}" placeholder="Username" data-toggle="tooltip" title="输入不少于6位的数字与字母" data-placement="right" data-trigger="hover">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword3" class="col-sm-5 control-label">密码</label>
														<div class="col-sm-12">
															<input type="password" class="form-control" id="registerPassword1" name="registerPassword1" required="required" pattern="[A-Za-z0-9]{6,30}" placeholder="Password" data-toggle="tooltip" title="输入不少于6位的数字与字母" data-placement="right" data-trigger="hover">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword4" class="col-sm-5 control-label">确认密码</label>
														<div class="col-sm-12">
															<input type="password" class="form-control" id="registerPassword2" name="registerPassword2" placeholder="Confirm" required="required" pattern="[A-Za-z0-9]{6,30}" data-toggle="tooltip" title="输入不少于6位的数字与字母" data-placement="right" data-trigger="hover">
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
					<script>
						$(function(){
							$('[data-toggle="tooltip"]').tooltip();
						});
					</script>
					
				</div>
				<%}else{ %>
				<div class="col-md-1 m-auto">
					<div class="dropdown">
				 
						<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
							<%=((User)session.getAttribute("user")).getName() %>
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="<%=basePath %>getMyPosts">我的帖子</a> 
							<a class="dropdown-item" href="#">编写新帖子</a> 
							<%if(((User)session.getAttribute("user")).getIsManager()){ %>
							<a class="dropdown-item" href="<%=basePath %>logoff">管理帖子</a>
							<a class="dropdown-item" href="<%=basePath %>logoff">管理用户</a>
							<%} %>
							<a class="dropdown-item" href="<%=basePath %>logoff">注销</a>
						</div>
					</div>
				</div>
				<%} %>
			</div>
			<%if(session.getAttribute("user")==null){ 

			%>
				<%if(request.getAttribute("loginFail")!=null){ %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				用户名或密码错误！
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<%}else if(request.getAttribute("registerFail")!=null){ %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				注册失败！已有该用户
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<%} %>
			<%} else{%>
				<%if(request.getAttribute("loginSuccess")!=null){ %>
			<div class="alert alert-success alert-dismissible fade show" role="alert">
				登陆成功！
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<%}else if(request.getAttribute("registerSuccess")!=null){ %>
			<div class="alert alert-success alert-dismissible fade show" role="alert">
				注册成功！
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<%} %>
			<%} %>

			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark radius">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand col-2" href="getPosts?back=true">首页</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item">
						</li>
						
						
					</ul>
					
					<ul class="navbar-nav ml-md-auto">
						<!--搜索表单-->
						<form class="form-inline" method="post" action="<%=basePath %>getPosts">
							<select class="form-control" id="tag" name="tag">
								<option <%=session.getAttribute("tag").equals("全部")?"selected":"" %>>全部</option>
								<option <%=session.getAttribute("tag").equals("生活")?"selected":"" %>>生活</option>
								<option <%=session.getAttribute("tag").equals("资源")?"selected":"" %>>资源</option>
								<option <%=session.getAttribute("tag").equals("电影")?"selected":"" %>>电影</option>
								<option <%=session.getAttribute("tag").equals("讨论")?"selected":"" %>>讨论</option>
							</select>
							<input class="form-control mr-sm-2" id="keyword" name="keyword" type="text" <%=session.getAttribute("keyword")!=null?"value=\""+session.getAttribute("keyword")+"\"":"" %>/> 
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
	<% 
	List<Post> posts=(List<Post>) request.getAttribute("posts");
	Map<Integer,String> imgs=(Map<Integer,String>) request.getAttribute("imgs");
	%>
	<div class="col-md-3">
	<%
	for(int i=0;i<posts.size()/4&&i<posts.size();i++) {
		Post post=posts.get(i);
	%>
		<div class="row passage">
		<%if(imgs.get(post.getPostId())!=null){ %>
			<img class="img-responsive" src="static/resources/<%=imgs.get(post.getPostId()) %>">
		<%} %>
		<p class="passage">
				<strong><%=post.getTitle() %></strong>
			</p>
			
			<%if(session.getAttribute("user")!=null){%>
			<p>
				<a class="btn btn-primary radius" href="<%=basePath %>post?post_id=<%=post.getPostId()%>">View details »</a>
				<%if(((User)(session.getAttribute("user"))).getIsManager()||((User)(session.getAttribute("user"))).getUserId().equals(post.getUserId())){ %>	
				<a class="btn btn-danger radius" href="<%=basePath %>deleteSingleUser?post_id=<%=post.getPostId()%>">Delete</a>
				<%} %>
			</p>
				
			<%} %>
		</div>
		<%} %>
		</div>
		
		
		<div class="col-md-3">
	<%
	for(int i=posts.size()/4;i<posts.size()*2/4&&i<posts.size();i++) {
		Post post=posts.get(i);
	%>
		<div class="row passage">
		<%if(imgs.get(post.getPostId())!=null){ %>
			<img class="img-responsive" src="static/resources/<%=imgs.get(post.getPostId()) %>">
		<%} %>
		<p class="passage">
				<strong><%=post.getTitle() %></strong>
			</p>
			
			<%if(session.getAttribute("user")!=null){%>
			<p>
				<a class="btn btn-primary radius" href="<%=basePath %>post?post_id=<%=post.getPostId()%>">View details »</a>
				<%if(((User)(session.getAttribute("user"))).getIsManager()||((User)(session.getAttribute("user"))).getUserId().equals(post.getUserId())){ %>	
				<a class="btn btn-danger radius" href="<%=basePath %>deleteSingleUser?post_id=<%=post.getPostId()%>">Delete</a>
				<%} %>
			</p>
				
			<%} %>
		</div>
		<%} %>
		</div>
		
		
		
		<div class="col-md-3">
	<%
	for(int i=posts.size()*2/4;i<posts.size()*3/4&&i<posts.size();i++) {
		Post post=posts.get(i);
	%>
		<div class="row passage">
		<%if(imgs.get(post.getPostId())!=null){ %>
			<img class="img-responsive" src="static/resources/<%=imgs.get(post.getPostId()) %>">
		<%} %>
		<p class="passage">
				<strong><%=post.getTitle() %></strong>
			</p>

			<%if(session.getAttribute("user")!=null){%>
			<p>
				<a class="btn btn-primary radius" href="<%=basePath %>post?post_id=<%=post.getPostId()%>">View details »</a>
				<%if(((User)(session.getAttribute("user"))).getIsManager()||((User)(session.getAttribute("user"))).getUserId().equals(post.getUserId())){ %>	
				<a class="btn btn-danger radius" href="<%=basePath %>deleteSingleUser?post_id=<%=post.getPostId()%>">Delete</a>
				<%} %>
			</p>
				
			<%} %>
		</div>
		<%} %>
		</div>
		
		
		<div class="col-md-3">
	<%
	for(int i=posts.size()*3/4;i<posts.size();i++) {
		Post post=posts.get(i);
	%>
		<div class="row passage">
		<%if(imgs.get(post.getPostId())!=null){ %>
			<img class="img-responsive" src="static/resources/<%=imgs.get(post.getPostId()) %>">
		<%} %>
		<p class="passage">
				<strong><%=post.getTitle() %></strong>
			</p>
			
			<%if(session.getAttribute("user")!=null){%>
			<p>
				<a class="btn btn-primary radius" href="<%=basePath %>post?post_id=<%=post.getPostId()%>">View details »</a>
				<%if(((User)(session.getAttribute("user"))).getIsManager()||((User)(session.getAttribute("user"))).getUserId().equals(post.getUserId())){ %>	
				<a class="btn btn-danger radius" href="<%=basePath %>deleteSingleUser?post_id=<%=post.getPostId()%>">Delete</a>
				<%} %>
			</p>
				
			<%} %>
		</div>
		<%} %>
		</div>
		
		
		
		
		
		<%if(((List<Post>) request.getAttribute("posts")).size()==0){ %>
		<div class="col-md-11 passage">
			<h2 class="passage">
				已经没有帖子了哦！
			</h2>
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
							<%if(pageindex==1) {%>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=4">4</a>
							</li>
							<%} %>
							<%if(pageindex<=2) {%>
							<li class="page-item">
								<a class="page-link" href="<%=basePath %>getPosts?pageindex=5">5</a>
							</li>
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