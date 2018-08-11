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
		<form action="${pageContext.request.contextPath }/res_catagorty/list"
			method="post" class="form-inline">
			<div class="form-group">
				<label for="res">素材分类查询：</label><input type="text"
					name="resCatagortyNameQuery" placeholder="请输入素材分类名称">
			</div>
			<input type="submit" name="submit" value="查询">
			<div class="form-group">
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/res_catagorty/save?pageNum=${pageInfo.pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}"><span>添加素材分类</span></a>
			<%-- 	<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/res_catagorty/deleteAll"><span>删除所有素材分类</span></a> --%>
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/res_catagorty/batchAll"><span>批量更新素材分类</span></a>
			</div>
		</form>
	</div>
	<div>
		<form>
			<input type="hidden" name="pageNum" value="${pageNum }">
			<table class="table table-striped">
				<thead>
					<tr>
						<!-- <th>素材分类id</th> -->
						<th>素材分类名称</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<th>是否存在</th>
						<th>所属分类</th>
						<th>功能</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list}" var="animResCatagorty">
						<tr>
							<%-- <td>${animResCatagorty.resCatagortyId }</td> --%>
							<td><a
								href="
							${pageContext.request.contextPath }/res_catagorty/view/${animResCatagorty.resCatagortyId}?pageNum=${pageInfo.pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}">${animResCatagorty.resCatagortyName }</a></td>
							<td>${animResCatagorty.resCatagortyCreatetime }</td>
							<td>${animResCatagorty.resCatagortyUpdatetime }</td>
							<td>
							<c:choose>
									<c:when test="${animResCatagorty.isdeleted==false }">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose>
							</td>
							<td>${animResCatagorty.parent.resCatagortyName}</td>
							<td><a
								href="${pageContext.request.contextPath }/res_catagorty/update/${animResCatagorty.resCatagortyId }?pageNum=${pageInfo.pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}">隐藏</a>
								<a
								href="${pageContext.request.contextPath }/res_catagorty/edit/${animResCatagorty.resCatagortyId }?pageNum=${pageInfo.pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}">修改</a>
								<a
								href="${pageContext.request.contextPath }/res_catagorty/delete/${animResCatagorty.resCatagortyId }?pageNum=${pageInfo.pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}">删除</a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页功能 -->
			<div style="margin: 10px;">
				<span> <a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res_catagorty/list?pageNum=1&resCatagortyNameQuery=${resCatagortyNameQuery}">首页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res_catagorty/list?pageNum=${pageInfo.prePage}&resCatagortyNameQuery=${resCatagortyNameQuery}">上一页</a></span>
				<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
					<span><a
						href="${pageContext.request.contextPath }/res_catagorty/list?pageNum=${num}&resCatagortyNameQuery=${resCatagortyNameQuery}"><c:choose >
							<c:when test="${pageInfo.pageNum==num}">
								<span ><u>${num }</u></span>
							</c:when>
							<c:otherwise>
								<span >${num }</span>
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
					href="${pageContext.request.contextPath }/res_catagorty/list?pageNum=${pageInfo.nextPage}&resCatagortyNameQuery=${resCatagortyNameQuery}">下一页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/res_catagorty/list?pageNum=${pageInfo.lastPage}&resCatagortyNameQuery=${resCatagortyNameQuery}">尾页</a></span>
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
		window.location.href = "http://" + serverName + ":" + serverPort + "/"
				+ contextPath + "/res_catagorty/list?pageNum=" + value
				+ "&resCatagortyNameQuery=${resCatagortyNameQuery}";
	}
</script>
</html>