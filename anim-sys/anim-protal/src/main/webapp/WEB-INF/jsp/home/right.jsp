<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@include file="/WEB-INF/jsp/dept/dept_list_page.jsp"%> --%>
<html>
<%-- <%@include file="/WEB-INF/jsp/home/common.jsp"%> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				//alert("ok")
				var serverName = "${pageContext.request.serverName}";
				//alert(serverName)
				var serverPort = "${pageContext.request.serverPort}";
				var contextPath = "${pageContext.request.contextPath }";
				//alert(serverName + ":" + serverPort + ":" + contextPath)
				url = "http://" + serverName + ":" + serverPort + "/"
						+ contextPath + "/res/list";
				$("#body").load(url)

			})
</script>
</head>
<body id="body">

</body>
</html>