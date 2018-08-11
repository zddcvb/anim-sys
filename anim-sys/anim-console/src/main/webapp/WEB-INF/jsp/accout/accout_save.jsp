<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String contextPath = request.getContextPath();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String baseUrl = "http://" + serverName + ":" + port + "/" + contextPath + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<div style="align-items: center;">
		<form
			action="${pageContext.request.contextPath }/accout/save_data?pageNum=${pageNum }&nameQuery=${query.nameQuery }"
			class="form-horizontal " role="form">
			<input type="hidden" name="pageNum" value="${pageNum}"> <input
				type="hidden" name="nameQuery" value="${query.nameQuery}">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">用戶名</label>
				<div class="col-sm-10">
					<input type="text" name="username" placeholder="请输入用戶名">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" name="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<label for="deptDesc" class="col-sm-2 control-label">账户类型</label>
				<div class="col-sm-10">
					<select name="accoutType">
						<c:forEach begin="0" end="3" step="1" var="type">
							<option value="${type }">${type }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" name="submit" value="提交"
					class="btn btn-primary"> <input type="button"
					class="btn btn-primary" onclick="window.history.back(-1);"
					value="返回">
			</div>

		</form>
	</div>
</body>
</html>