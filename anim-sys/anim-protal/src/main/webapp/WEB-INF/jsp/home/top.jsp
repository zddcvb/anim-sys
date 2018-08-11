<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/WEB-INF/jsp/home/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background-color: #36A9E1">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><span style="color: white">动画部工作系统</span></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span style="color: white">${animAccout.username }</span></a></li>
				<li><a href="${pageContext.request.contextPath }/logout" target="_top"><span style="color: white">退出系统</span></a></li>
			</ul>
		</div>
	</div>
	</nav>
</body>
</html>