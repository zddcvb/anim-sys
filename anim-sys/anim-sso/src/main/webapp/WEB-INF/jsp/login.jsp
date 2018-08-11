<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String baseUrl = "http://" + serverName + ":" + port + contextPath + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="<%=baseUrl%>css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
<script>
	var __links = document.querySelectorAll('a');
	function __linkClick(e) {
		parent.window.postMessage(this.href, '*');
	};
	for (var i = 0, l = __links.length; i < l; i++) {
		if (__links[i].getAttribute('data-t') == '_blank') {
			__links[i].addEventListener('click', __linkClick, false);
		}
	}
</script>
<script type="text/javascript">
	function clearName() {
		alert("text");
		alert($('.text').val());

	}
	function clearPwd() {
		$('#text').value = '';
	}
</script>
<style type="text/css">
</style>
</head>
<body>
	<!-- contact-form -->
	<div class="message warning">
		<div class="inset">
			<div class="login-head">
				<h1>用户登录</h1>
			</div>
			<form>
				<ul>
					<li><input type="text" class="text" name="username"
						value="用户名" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = '用户名';}"><a
						class=" icon user" onclick="clearName()"></a></li>
					<li><input type="password" value="密码" name="password"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = '密码';}"> <a
						class="icon lock" onclick="clearPwd()"></a></li>
				</ul>
				<div class="submit">
					<input type="submit" onclick="myFunction()" value="登 录">
					<h4>
						<a href="#">忘记密码 ?</a>
					</h4>
				</div>

			</form>
		</div>
	</div>

	<!--- footer --->
	<div class="footer">
		<p>Copyright &copy; 广东阳光视界教育科技有限公司-动画部 2018</p>
	</div>

</body>
</html>