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
<title>Insert title here</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
<style type="text/css">
.top {
	width: 100%;
	height: 5%;
	background-color: lime;
	/* position: fixed; */
}

.content {
	width: 100%;
	height: 90%;
	background-color: red;
}

.left {
	float: left;
	width: 15%;
	height: 100%;
	background-color: #f5f5f5;
	overflow: scroll;
}

.right {
	float: right;
	width: 85%;
	height: 100%;
	background-color: white;
}

.bottom {
	float: right;
	width: 100%;
	height: 5%;
	background-color: navy;
}

a {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		//alert('ok')
		loadMenu(null);
	})
	function loadMenu(resCatagortyName) {
		//alert(resCatagortyName)
		var serverName = "${pageContext.request.serverName}";
		var serverPort = "${pageContext.request.serverPort}";
		var contextPath = "${pageContext.request.contextPath }";
		var url = null;
		if (resCatagortyName == null) {
			url = "http://" + serverName + ":" + serverPort + contextPath
					+ "/res/list";
		} else {
			url = "http://" + serverName + ":" + serverPort + contextPath
					+ "/res/list?resCatagortyNameQuery=" + resCatagortyName;
		}
		//alert(url)
		$('#right').load(url);
	}
</script>
</head>
<body style="height: 1920px">
	<div class="top"></div>
	<div class="content">
		<div class="left" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne"> 素材分类 </a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in">
					<div class="panel-body">
						<c:forEach items="${ resCatas}" var="resCata">
							<a onclick="loadMenu('${resCata.resCatagortyName}')"
								target="right">${resCata.resCatagortyName }</a>
							<br>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="right" id="right"></div>
		<div class="bottom"></div>
	</div>
</body>
</html>