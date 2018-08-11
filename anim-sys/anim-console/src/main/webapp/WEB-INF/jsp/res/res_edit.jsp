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
<title>编辑页面</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<div>
		<form action="${pageContext.request.contextPath }/res/edit_res"
			method="post" class="form-horizontal " role="form">
			<input type="hidden" name="pageNum" value="${pageNum }"> <input
				type="hidden" name="resId" value="${animRes.resId }"> <input
				type="hidden" name="resNameQuery" value="${resNameQuery}"> <input
				type="hidden" name="resCatagortyNameQuery"
				value="${resCatagortyNameQuery}">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 素材名称</label> <input
					type="text" name="resName" value="${animRes.resName }">
			</div>
			<%-- <div class="form-group">
				<label for="review" class="col-sm-2 control-label">预览图地址</label> <input
					type="text" name="resName" value="${animRes.resReviewUrl }">
			</div>
			<div class="form-group">
				<label for="url" class="col-sm-2 control-label"> 素材下载地址</label>
				<textarea rows="5" cols="20" name="resUrl">${animRes.resUrl }</textarea>
			</div> --%>
			<div class="form-group">
				<label for="parent" class="col-sm-2 control-label"> 所属分类</label> <select
					name="resCatagortyId">
					<option value="${animRes.resCatagortyId }">${animRes.animResCatagorty.resCatagortyName }</option>
					<c:forEach items="${resCatagorties }" var="resCatagorty">
						<c:if
							test="${animRes.resCatagortyId!=resCatagorty.resCatagortyId }">
							<option value="${resCatagorty.resCatagortyId }">${resCatagorty.resCatagortyName }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" name="submit" value="提交"
					class="btn btn-primary"> <a class="btn btn-primary"
					href="${pageContext.request.contextPath }/res/view/back?pageNum=${pageNum}&resNameQuery=${resNameQuery}&resCatagortyNameQuery=${resCatagortyNameQuery}">返回上一级</a>
			</div>
		</form>
	</div>
</body>
</html>