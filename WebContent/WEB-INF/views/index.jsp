<!doctype html>
<html lang="en">
  <head>
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
										<form class="form-horizontal  col-md-12">
												<div class="form-group">
														<label for="inputEmail3" class="col-sm-3 control-label">邮箱</label>
														<div class="col-sm-7">
															<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword3" class="col-sm-3 control-label">密码</label>
														<div class="col-sm-7">
															<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
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
										<form class="form-horizontal  col-md-12">
												<div class="form-group">
														<label for="inputEmail3" class="col-sm-3 control-label">邮箱</label>
														<div class="col-sm-7">
															<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword3" class="col-sm-3 control-label">密码</label>
														<div class="col-sm-7">
															<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
														</div>
												</div>
												<div class="form-group">
														<label for="inputPassword3" class="col-sm-3 control-label">确认密码</label>
														<div class="col-sm-7">
															<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
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
			</div>
			<div class="blank"></div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark radius">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="#">首页</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item">
							 <a class="nav-link" href="#">讨论 <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							 <a class="nav-link" href="#">资源</a>
						</li>
						
					</ul>
					
					<ul class="navbar-nav ml-md-auto">
						<!--搜索表单-->
						<form class="form-inline">
							<input class="form-control mr-sm-2" type="text" /> 
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
		<div class="col-md-11 passage">
			<h2 class="passage">
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				<a class="btn btn-primary radius" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-11 passage">
			<h2 class="passage">
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				<a class="btn btn-primary radius" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-11 passage">
			<h2 class="passage">
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				<a class="btn btn-primary radius" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-11 passage">
			<h2 class="passage">
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				<a class="btn btn-primary radius" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-11 passage">
			<h2 class="passage">
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				<a class="btn btn-primary radius" href="#">View details »</a>
			</p>
		</div>
		
	</div>
	<!--分页器,jsp根据数据库动态生成,显示5个页数摁钮、快速前进后退摁钮、前进后退摁钮-->
	<div class="col-md-12 pagenav">
					<nav>
						<ul class="pagination">
							<!--普通按钮，点击一次到达相应页-->
							<li class="page-item">
								<a class="page-link" href="#">Previous</a>
							</li>
							<!--快速跳过按钮，点击一次后退5页-->
							<li class="page-item">
								<a class="page-link" href="#">...</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">14</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">15</a>
							</li>
							<!--当前页-->
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">16 <span class="sr-only">(current)</span></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">17</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">18</a>
							</li>
							<!--快速跳过按钮，点击一次5前进页-->
							<li class="page-item">
								<a class="page-link" href="#">...</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">Next</a>
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