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
<script type="text/javascript">
	$(document).ready(
			function($) {
				$('#selectFile').on(
						'change',
						function() {
							var filePath = $(this).val();
							text = filePath.substring(
									filePath.lastIndexOf("\\") + 1,
									filePath.lastIndexOf(".")).toLowerCase();
							fileFormat = filePath.substring(
									filePath.lastIndexOf(".")).toLowerCase();
							if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
								error_prompt_alert("图片格式不对");
								return;
							}
							src = window.URL.createObjectURL(this.files[0]);
							$('#resName').attr('value', text);
							$('#viewImg').attr('src', src);
						});
			});
</script>
</head>
<body>
	<br>
	<div>
		<form action="${pageContext.request.contextPath }/res/save_res"
			class="form-horizontal " role="form" enctype="multipart/form-data"
			method="post">
			<input type="hidden" name="pageNum" value="${pageNum}"> <input
				type="hidden" name="resNameQuery" value="${query.resNameQuery}"> <input
				type="hidden" name="resCatagortyNameQuery"
				value="${query.resCatagortyNameQuery}">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 素材名称</label> <input
					type="text" name="resName" id="resName">
			</div>
			<div class="form-group">
				<label for="review" class="col-sm-2 control-label"> 预览图地址</label> <input
					type="file" name="upload" id="selectFile"><img alt=""
					id="viewImg">
			</div>
			<div class="form-group">
				<label for="url" class="col-sm-2 control-label"> 素材下载地址</label> <input
					type="file" name="upload1">
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
					href="${pageContext.request.contextPath }/res/view/back?pageNum=${pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}"
					class="btn btn-primary">返回上一级</a>
			</div>
		</form>
	</div>
</body>
</html>