<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="margin-left: 20px; margin-bottom: 5px; margin-top: 15px;">

		<div style="width: 98%;" align="left">
			<form class="form">
				<div>
					<div class="btn-group btn-group-sm" >

						<c:forEach items="${resCataLists }" var="resCata">
							<div style="margin-top: 10px;margin-bottom: 10px">
								<div>
									<span style="font-size: 25px">${resCatagorty.parent.resCatagortyName }公司形象</span>
								</div>
							</div>
							<div>
								<c:forEach items="${ resCata }" var="resCatagorty">
									<a href="/rescata/${resCatagorty.resCatagortyId}"
										class="btn btn-primary">${resCatagorty.resCatagortyName }</a>
								</c:forEach>
							</div>
							<hr>
						</c:forEach>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function changed() {

			var select = document.getElementById("page");
			var value = select.value;
			value.selected = true;
			var serverName = "${pageContext.request.serverName}";
			var serverPort = "${pageContext.request.serverPort}";
			var contextPath = "${pageContext.request.contextPath }";
			window.location.href = "http://"
					+ serverName
					+ ":"
					+ serverPort
					+ "/"
					+ contextPath
					+ "/res/list?pageNum="
					+ value
					+ "&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}";
		}
	</script>
</body>
</html>