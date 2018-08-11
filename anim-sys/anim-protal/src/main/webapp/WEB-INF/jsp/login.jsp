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
	var LOGIN = {
		checkData : function() {
			//alert("checkData start");
			if ($('#loginName').val() == '用户名') {
				alert("用户名不能为空");

				return false;
			}
			if ($('#loginPwd').val() == '密码') {
				alert("密码不能为空")
				return false;
			}
			return true;
		},
		doLogin : function() {
			//alert("doLogin start");
			$.post("${pageContext.request.contextPath}/login", $('#formlogin').serialize(), function(data) {
				//alert(data.username);
				if (data.accoutType == 0) {
					location.href = "http://172.16.2.9:8080/anim-console/index";
				} else {
					location.href = "${pageContext.request.contextPath}/";
				}
			});
		},
		login : function() {
			if (this.checkData()) {
				this.doLogin();
			}
		}
	}
	$(function() {
		$('#loginsubmit').click(function() {
			//alert("start login");
			LOGIN.login();
		})
	})
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
			<form id="formlogin" method="post" onsubmit="return false;">
				<ul>
					<li><input type="text" class="text" name="username"
						id="loginName" value="用户名" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = '用户名';}"><a
						class=" icon user" onclick="clearName()"></a></li>
					<li><input type="password" value="*******" name="password"
						id="loginPwd" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = '';}"> <a
						class="icon lock" onclick="clearPwd()"></a></li>
				</ul>
				<div class="submit">
					<a class="btn btn-default btn-md" id="loginsubmit"><span
						style="font-size: 20px">登 录</span></a>
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