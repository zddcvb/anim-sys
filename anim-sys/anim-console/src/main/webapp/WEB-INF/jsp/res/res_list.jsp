<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String contextPath = request.getContextPath();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String baseUrl = "http://" + serverName + ":" + port + "/" + contextPath + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dept_list_page</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<br />
	<div style="margin: 10px;">
		<form action="${pageContext.request.contextPath }/res/list"
			method="post" class="form-inline">
			<div class="form-group">
				<label for="res">素材查询：</label><input type="text" name="resNameQuery"
					placeholder="请输入素材名称" value="${query.resNameQuery }">
			</div>
			<div class="form-group">
				<label for="rescata">分类查询：</label><input type="text"
					name="resCatagortyNameQuery" placeholder="请输入分类名称"
					value="${query.resCatagortyNameQuery }">
			</div>
			<div class="form-group">
				<input type="submit" name="submit" value="查询">
			</div>
			<div class="form-group">
				<a
					href="${pageContext.request.contextPath }/res/save?pageNum=${pageInfo.pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}"
					class="btn btn-default btn-sm" role="button"><span>添加素材</span></a>
				<a href="${pageContext.request.contextPath }/res/deleteAll"
					class="btn btn-default btn-sm" role="button"><span>删除所有素材</span></a>
				<a href="${pageContext.request.contextPath }/res/batch/xls"
					class="btn btn-default btn-sm" role="button"><span>批量表格形式更新素材</span></a>
				<a href="${pageContext.request.contextPath }/res/batch/file"
					class="btn btn-default btn-sm" role="button"><span>批量文件夹更新素材</span></a>
					<a href="${pageContext.request.contextPath }/res/batch/file/view"
					class="btn btn-default btn-sm" role="button"><span>批量更新大图</span></a>
			</div>
		</form>
	</div>
	<div>
		<form>
			<input type="hidden" name="pageNum" value="${pageNum }">
			<table class="table table-striped">
				<thead>
					<tr>
						<!-- <th>素材id</th> -->
						<th>素材名称</th>
						<!-- <th>预览图</th> -->
						<th>素材地址</th>
						<th>素材大小</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<th>是否存在</th>
						<th>分类名称</th>
						<th>功能</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list}" var="animRes">
						<tr>
							<%-- <td>${animRes.resId }</td> --%>
							<td><a
								href="
							${pageContext.request.contextPath }/res/view/${animRes.resId}?pageNum=${pageInfo.pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">${animRes.resName }</a></td>
							<%-- <td>${animRes.resReviewUrl }</td> --%>
							<td>${animRes.resUrl }</td>
							<td>${animRes.resSize }</td>
							<td>${animRes.resCreatetime }</td>
							<td>${animRes.resUpdatetime }</td>
							<td><c:choose>
									<c:when test="${animRes.isdeleted==false }">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose></td>
							<td>${animRes.animResCatagorty.resCatagortyName}</td>
							<td><a
								href="${pageContext.request.contextPath }/res/update/${animRes.resId }?pageNum=${pageInfo.pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">隐藏</a>
								<a
								href="${pageContext.request.contextPath }/res/edit/${animRes.resId }?pageNum=${pageInfo.pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">修改</a>
								<a
								href="${pageContext.request.contextPath }/res/delete/${animRes.resId }?pageNum=${pageInfo.pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">删除</a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页功能 -->
			<div style="margin: 10px;">
				<span> <a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res/list?pageNum=1&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">首页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res/list?pageNum=${pageInfo.prePage}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">上一页</a></span>
				<c:forEach begin="${pageInfo.pageNum }" end="${pageInfo.pageNum+10>pageInfo.pages?pageInfo.pages: pageInfo.pageNum+10}" step="1" var="num">
					<span><a 
						href="${pageContext.request.contextPath }/res/list?pageNum=${num}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}"><c:choose>
								<c:when test="${pageInfo.pageNum==num}">
									<span><u>${num }</u></span>
								</c:when>
								<c:otherwise>
									<span>${num }</span>
								</c:otherwise>
							</c:choose></a></span>
				</c:forEach>
				<select id="page" name="pageNum" onchange="changed()" class="btn btn-default btn-sm">
					<option selected>${pageInfo.pageNum }</option>
					<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
						<c:if test="${pageInfo.pageNum!=num }">
							<option value="${num }">${num}</option>
						</c:if>
					</c:forEach>
				</select> <span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res/list?pageNum=${pageInfo.nextPage}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">下一页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res/list?pageNum=${pageInfo.pages}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}">尾页</a></span>
			</div>
			<br />
		</form>
	</div>
</body>
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
</html>