<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<div>
		<form action="${pageContext.request.contextPath }/res/save_res"
			class="form-horizontal " role="form">
			<input type="hidden" name="pageNum" value="${pageNum}"> <input
				type="hidden" name="resNameQuery" value="${resNameQuery}"> <input
				type="hidden" name="resCatagortyNameQuery"
				value="${resCatagortyNameQuery}">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 素材名称</label> <input
					type="text" name="resName">
			</div>
				<div class="form-group">
				<label for="review" class="col-sm-2 control-label"> 预览图地址</label> <input
					type="text" name="resName">
			</div>
			<div class="form-group">
				<label for="url" class="col-sm-2 control-label"> 素材下载地址</label> <input
					type="text" name="resUrl">
			</div>
			<div class="form-group">
				<label for="time" class="col-sm-2 control-label"> 素材创建时间</label> <input
					type="text" name="resCreatetime">
			</div>
			<div class="form-group">
				<label for="size" class="col-sm-2 control-label"> 素材大小</label> <input
					type="text" name="resSize">
			</div>
			<div class="form-group">
				<label for="parent" class="col-sm-2 control-label"> 所属分类</label> <select
					name="resCatagortyId">
					<option value="0">请选择部分类</option>
					<c:forEach items="${resCatagorties }" var="resCatagorty">
						<option value="${resCatagorty.resCatagortyId }">${resCatagorty.resCatagortyName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" name="submit" value="提交"
					class="btn btn-primary"> <a
					href="${pageContext.request.contextPath }/res/view/back?pageNum=${pageNum}&resNameQuery=${resNameQuery}&resCatagortyNameQuery=${resCatagortyNameQuery}"
					class="btn btn-primary">返回上一级</a>
			</div>
		</form>
	</div>
</body>
</html>