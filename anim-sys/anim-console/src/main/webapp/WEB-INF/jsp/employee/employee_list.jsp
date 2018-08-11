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
		<form action="${pageContext.request.contextPath }/employee/list"
			method="post" class="form-inline">
			<div class="form-group">
				<label for="name">姓名查询：</label> <input type="text"
					name="employeeNameQuery" placeholder="请输入姓名"
					value="${query.employeeNameQuery }">
			</div>
			<div class="form-group">
				<label for="role"> 岗位查询：</label><input type="text"
					name="roleNameQuery" placeholder="请输入岗位"
					value="${query.roleNameQuery }">
			</div>
			<div class="form-group">
				<label for="dept">部门查询：</label><input type="text"
					name="deptNameQuery" placeholder="请输入部门"
					value="${query.deptNameQuery }">
			</div>
			<input type="submit" name="submit" value="查询">
			<div class="form-group" style="padding-right: 10px">
				<a
					href="${pageContext.request.contextPath }/employee/save?pageNum=${pageInfo.pageNum}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}"
					class="btn btn-default btn-sm" role="button"><span>添加员工</span></a>
				<%-- <a href="${pageContext.request.contextPath }/employee/deleteAll"
					class="btn btn-default btn-sm" role="button"><span>删除所有员工</span></a> --%>
				<a href="${pageContext.request.contextPath }/employee/batchAll"
					class="btn btn-default btn-sm" role="button"><span>批量导入员工</span></a>
			</div>
		</form>
	</div>
	<div>
		<form>
			<input type="hidden" name="pageNum" value="${pageNum }">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>员工姓名</th>
						<th>员工性别</th>
						<th>员工年龄</th>
						<th>毕业院校</th>
						<th>主修专业</th>
						<th>最高学历</th>
						<th>入职日期</th>
						<th>所在岗位</th>
						<th>所在部门</th>
						<th>联系方式</th>
						<th>是否离职</th>
						<th>功能</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list}" var="animEmployee">
						<tr>
							<%-- <td>${animEmployee.employeeId }</td> --%>

							<td><a
								href="
							${pageContext.request.contextPath }/employee/view/${animEmployee.employeeId}?pageNum=${pageInfo.pageNum}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">${animEmployee.employeeName }</a></td>
							<td>${animEmployee.employeeSex }</td>
							<td>${animEmployee.employeeAge }</td>
							<td>${animEmployee.employeeSchool }</td>
							<td>${animEmployee.employeeMajor }</td>
							<td>${animEmployee.employeeEducation }</td>
							<td>${animEmployee.employeeWorkedTime }</td>
							<td>${animEmployee.animRole.roleName }</td>
							<td>${animEmployee.animDept.deptName}</td>
							<td>${animEmployee.employeeTelephone}</td>
							<td><c:choose>
									<c:when test="${animEmployee.isleaved==true }">
										<span>是</span>
									</c:when>
									<c:otherwise>
										<span>否</span>
									</c:otherwise>
								</c:choose></td>
							<td><a
								href="${pageContext.request.contextPath }/employee/update/${animEmployee.employeeId }?pageNum=${pageInfo.pageNum}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">隐藏</a>
								<a
								href="${pageContext.request.contextPath }/employee/edit/${animEmployee.employeeId }?pageNum=${pageInfo.pageNum}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">修改</a>
								<a
								href="${pageContext.request.contextPath }/employee/delete/${animEmployee.employeeId }?pageNum=${pageInfo.pageNum}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 分页功能 -->
			<div style="margin: 10px;">
				<span> <a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/employee/list?pageNum=1&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">首页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/employee/list?pageNum=${pageInfo.prePage}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">上一页</a></span>
				<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
					<span><a
						href="${pageContext.request.contextPath }/employee/list?pageNum=${num}&employeeNameQuery=${employeeNameQuery}&roleNameQuery=${roleNameQuery }&deptNameQuery=${deptNameQuery}">
							<c:choose>
								<c:when test="${pageInfo.pageNum==num}">
									<span><u>${num }</u></span>
								</c:when>
								<c:otherwise>
									<span>${num }</span>
								</c:otherwise>
							</c:choose>
					</a></span>
				</c:forEach>
				<select id="page" name="pageNum" onchange="changed()" class="btn btn-default btn-sm">
					<option selected>${pageInfo.pageNum }</option>
					<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
						<c:if test="${pageInfo.pageNum!=num }">
							<option value="${num }">${num}</option>
						</c:if>
					</c:forEach>
				</select> <span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/employee/list?pageNum=${pageInfo.nextPage}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">下一页</a></span>
				<span><a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath }/employee/list?pageNum=${pageInfo.lastPage}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery }&deptNameQuery=${query.deptNameQuery}">尾页</a></span>
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
				+ "/employee/list?pageNum="
				+ value
				+ "&employeeNameQuery=${employeeNameQuery}&roleNameQuery=${roleNameQuery }&deptNameQuery=${deptNameQuery}";
	}
</script>
</html>