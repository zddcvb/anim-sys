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
	<div>
		<form
			action="${pageContext.request.contextPath }/res_catagorty/save_res_catagorty"
			class="form-horizontal " role="form">
			<input type="hidden" name="pageNum" value="${pageNum}"> <input
				type="hidden" name="resCatagortyNameQuery"
				value="${resCatagortyNameQuery}">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 素材分类名称</label> <input
					type="text" name="resCatagortyName">
			</div>
			<div class="form-group">
				<label for="time" class="col-sm-2 control-label"> 素材分类创建时间</label> <input
					type="text" name="resCatagortyCreatetime">
			</div>
			<div class="form-group">
				<label for="parent" class="col-sm-2 control-label"> 所属分类</label> <select
					name="parentId">
					<option value="0">请选择分类</option>
					<c:forEach items="${resCatagortyList }" var="resCatagorty">
						<option value="${resCatagorty.resCatagortyId }">${resCatagorty.resCatagortyName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" name="submit" value="提交"
					class="btn btn-primary"> <a
					href="${pageContext.request.contextPath }/res_catagorty/view/back?pageNum=${pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}"
					class="btn btn-primary">返回上一级</a>
			</div>
		</form>
		</dir>
</body>
</html>