<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String contextPath = request.getContextPath();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String baseUrl = "http://" + serverName + ":" + port + contextPath + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>动画部工作系统</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>

</head>
<frameset rows="50,*,50" framespacing="0" border="0" frameborder="0">
	<frame src="${pageContext.request.contextPath }/home_top"
		name="TopMenu" scrolling="no" noresize />
	<frameset cols="180,*" id="resize" framespacing="10" border="0"
		frameborder="0">
		<frame noresize name="menu"
			src="${pageContext.request.contextPath }/home_left" scrolling="yes" />
		<frame noresize name="right"
			src="${pageContext.request.contextPath }/home_right" scrolling="yes"
			style="margin-left: 10px; margin-top: 10px;" />
	</frameset>
	<frame noresize name="status_bar" scrolling="no"
		src="${pageContext.request.contextPath }/home_bottom" />
</frameset>
<body>


</body>

</html>