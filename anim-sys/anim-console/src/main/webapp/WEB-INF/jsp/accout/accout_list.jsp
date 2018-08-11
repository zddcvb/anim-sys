<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String baseUrl = "http://" + serverName + ":" + port + "/" + contextPath + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dept_list_page</title>
</head>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<div style="margin: 10px;">
		<form action="${pageContext.request.contextPath }/accout/list"
			method="post" class="form-inline">
			<div class="form-group">
				<label for="name">姓名查询：</label> <input type="text"
					name="nameQuery" placeholder="请输入姓名"
					value="${query.nameQuery }">
			</div>
			<input type="submit" name="submit" value="查询">
			<div class="form-group" style="padding-right: 10px">
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/accout/save?pageNum=${pageInfo.pageNum}&nameQuery=${query.nameQuery}"><span>添加用户</span></a>
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/accout/deleteAll"><span>删除所有用户</span></a>
				<a class="btn btn-default btn-sm" role="button"
					href="${pageContext.request.contextPath }/accout/batchAll"><span>批量更新用户</span></a>
			</div>
		</form>
	</div>
	<form>
		<input type="hidden" name="pageNum" value="${pageNum }">
		<table class="table table-striped">
			<thead>
				<tr>
					<!-- <th>部门id</th> -->
					<th>用户名</th>
					<th>密码</th>
					<th>账户类型</th>
					<th>创建时间</th>
					<th>修改时间</th>
					<th>是否启用</th>
					<th>功能</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageInfo.list}" var="animAccout">
					<tr>
						<%-- <td>${animDept.deptId }</td> --%>
						<td><a
							href="
							${pageContext.request.contextPath }/accout/list/${animAccout.id}">${animAccout.username }</a></td>
						<td>${animAccout.password }</td>
						<td>${animAccout.accoutType }</td>
						<td>${animAccout.accoutCreatetime }</td>
						<td>${animAccout.accoutUpdatetime }</td>
						<td><c:choose>
								<c:when test="${animAccout.isdeleted==true }">
									<span>是</span>
								</c:when>
								<c:otherwise>
									<span>否</span>
								</c:otherwise>
							</c:choose></td>
						<td><a
							href="${pageContext.request.contextPath }/accout/update/password/${animAccout.id}?pageNum=${pageInfo.pageNum}&nameQuery=${query.nameQuery}">初始化密码</a>
							<a
							href="${pageContext.request.contextPath }/accout/update/state/${animAccout.id}?pageNum=${pageInfo.pageNum}&nameQuery=${query.nameQuery}">
								<c:choose>
									<c:when test="${accout.isdeleted==true }">
									禁用
								</c:when>
									<c:otherwise>
									启用
								</c:otherwise>
								</c:choose>
						</a> <a
							href="${pageContext.request.contextPath }/accout/edit/${animAccout.id}?pageNum=${pageInfo.pageNum}&nameQuery=${query.nameQuery}">修改</a>
							<a
							href="${pageContext.request.contextPath }/accout/delete/${animAccout.id}?pageNum=${pageInfo.pageNum}&nameQuery=${query.nameQuery}">删除</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<!-- 分页功能 -->
	<div style="margin: 10px;">
		<div>
			<span> <a class="btn btn-default btn-sm"
				href="${pageContext.request.contextPath }/accout/list?pageNum=1">首页</a></span>
			<span><a class="btn btn-default btn-sm"
				href="${pageContext.request.contextPath }/accout/list?pageNum=${pageInfo.prePage}">上一页</a></span>
			<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
				<span><a
					href="${pageContext.request.contextPath }/accout/list?pageNum=${num}"><c:choose>
							<c:when test="${pageInfo.pageNum==num}">
								<span><u>${num }</u></span>
							</c:when>
							<c:otherwise>
								<span>${num }</span>
							</c:otherwise>
						</c:choose></a></span>
			</c:forEach>
			<select id="page" name="pageNum" onchange="changed()"
				class="btn btn-default btn-sm">
				<option selected>${pageInfo.pageNum }</option>
				<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
					<c:if test="${pageInfo.pageNum!=num }">
						<option value="${num }">${num}</option>
					</c:if>
				</c:forEach>
			</select> <span><a class="btn btn-default btn-sm"
				href="${pageContext.request.contextPath }/accout/list?pageNum=${pageInfo.nextPage}">下一页</a></span>
			<span><a class="btn btn-default btn-sm"
				href="${pageContext.request.contextPath }/accout/list?pageNum=${pageInfo.lastPage}">尾页</a></span>
		</div>

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
				+ contextPath + "/accout/list?pageNum=" + value;
	}
	//返回上一级
	function back() {
		window.history.back(-1);
	}
	//前进
	function next() {
		window.history.back(1);
	}
</script>
</html>