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
		<form action="${pageContext.request.contextPath }/role/list"
			method="post" class="form-inline">
			<div class="form-group">
				<label for="role">岗位查询：</label><input type="text"
					name="roleNameQuery" placeholder="请输入岗位名称">
			</div>
			<div class="form-group">
				<label for="dept">部门查询：</label><input type="text"
					name="deptNameQuery" placeholder="请输入部门名称">
			</div>
			<input type="submit" name="submit" value="查询">
			<div class="form-group">
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/role/save?pageNum=${pageInfo.pageNum}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}"><span>添加岗位</span></a>
				<%-- <a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/role/deleteAll"><span>删除所有岗位</span></a> --%>
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/role/batchAll"><span>批量更新岗位</span></a>
			</div>
		</form>
	</div>
	<div>
		<form>
			<input type="hidden" name="pageNum" value="${pageNum }">
			<table class="table table-striped">
				<thead>
					<tr>
						<!-- <th>岗位id</th> -->
						<th>岗位名称</th>
						<th>岗位描述</th>
						<th>岗位职责</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<!-- <th>是否存在</th> -->
						<th>部门名称</th>
						<th>功能</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list}" var="animRole">
						<tr>
							<%-- <td>${animRole.roleId }</td> --%>
							<td><a
								href="
							${pageContext.request.contextPath }/role/view/${animRole.roleId}?pageNum=${pageInfo.pageNum}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">${animRole.roleName }</a></td>
							<td>${animRole.roleDesc }</td>
							<td>${animRole.roleDuty }</td>
							<td>${animRole.roleCreatetime }</td>
							<td>${animRole.roleUpdatetime }</td>
							<%-- <td>${animRole.isdeleted }</td> --%>
							<td>${animRole.animDept.deptName}</td>
							<td><a
								href="${pageContext.request.contextPath }/role/update/${animRole.roleId }?pageNum=${pageInfo.pageNum}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">隐藏</a>
								<a
								href="${pageContext.request.contextPath }/role/edit/${animRole.roleId }?pageNum=${pageInfo.pageNum}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">修改</a>
								<a
								href="${pageContext.request.contextPath }/role/delete/${animRole.roleId }?pageNum=${pageInfo.pageNum}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">删除</a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页功能 -->
			<div style="margin: 10px;">
				<span> <a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/role/list?pageNum=1&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">首页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/role/list?pageNum=${pageInfo.prePage}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">上一页</a></span>
				<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
					<span><a
						href="${pageContext.request.contextPath }/role/list?pageNum=${num}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}"><c:choose>
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
					href="${pageContext.request.contextPath }/role/list?pageNum=${pageInfo.nextPage}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">下一页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/role/list?pageNum=${pageInfo.lastPage}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">尾页</a></span>
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
				+ "/role/list?pageNum="
				+ value
				+ "&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}";
	}
</script>
</html>