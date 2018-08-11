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
<br>
<div>
	<form
		action="${pageContext.request.contextPath }/employee/edit_employee"
		method="post" class="form-horizontal " role="form">
		<input type="hidden" name="pageNum" value="${pageNum }"> <input
			type="hidden" name="employeeId" value="${animEmployee.employeeId }">
		<input type="hidden" name="employeeNameQuery"
			value="${employeeNameQuery}"> <input type="hidden"
			name="roleNameQuery" value="${roleNameQuery}"> <input
			type="hidden" name="deptNameQuery" value="${deptNameQuery}">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label"> 员工姓名</label> <input
				type="text" name="employeeName"
				value="${animEmployee.employeeName }">
		</div>
		<div class="form-group">
			<label for="sex" class="col-sm-2 control-label"> 员工性别</label>
			<c:choose>
				<c:when test="${animEmployee.employeeSex=='男' }">
					<input type="radio" name="employeeSex" value="男" checked="checked">男
						<input type="radio" name="employeeSex" value="女">女
					</c:when>
				<c:otherwise>
					<input type="radio" name="employeeSex" value="男">男
						<input type="radio" name="employeeSex" value="女" checked="checked">女
					</c:otherwise>
			</c:choose>
		</div>
		<div class="form-group">
			<label for="born" class="col-sm-2 control-label"> 出生年月</label> <input
				type="text" name="employeeBorn"
				value="${animEmployee.employeeBorn }">
		</div>
		<div class="form-group">
			<label for="card" class="col-sm-2 control-label"> 身份证号</label> <input
				type="text" name="employeeCardnum"
				value="${animEmployee.employeeCardnum }">
		</div>
		<div class="form-group">
			<label for="school" class="col-sm-2 control-label"> 毕业院校</label> <input
				type="text" name="employeeSchool"
				value="${animEmployee.employeeSchool }">
		</div>
		<div class="form-group">
			<label for="major" class="col-sm-2 control-label"> 所学专业</label> <input
				type="text" name="employeeMajor"
				value="${animEmployee.employeeMajor }">
		</div>
		<div class="form-group">
			<label for="edu" class="col-sm-2 control-label"> 最高学历</label> <input
				type="text" name="employeeEducation"
				value="${animEmployee.employeeEducation }">
		</div>
		<div class="form-group">
			<label for="famliy" class="col-sm-2 control-label"> 家庭住址</label> <input
				type="text" name="employeeFamilyAddress"
				value="${animEmployee.employeeFamilyAddress }">
		</div>
		<div class="form-group">
			<label for="now" class="col-sm-2 control-label"> 现住址</label> <input
				type="text" name="employeeNowAddress"
				value="${animEmployee.employeeNowAddress }">
		</div>
		<div class="form-group">
			<label for="telephone" class="col-sm-2 control-label"> 电话号码</label> <input
				type="text" name="employeeTelephone"
				value="${animEmployee.employeeTelephone }">
		</div>
		<div class="form-group">
			<label for="wechant" class="col-sm-2 control-label"> 微信号</label> <input
				type="text" name="employeeWechant"
				value="${animEmployee.employeeWechant }">
		</div>
		<div class="form-group">
			<label for="qq" class="col-sm-2 control-label"> qq号</label> <input
				type="text" name="employeeQq" value="${animEmployee.employeeQq }">
		</div>
		<div class="form-group">
			<label for="time" class="col-sm-2 control-label"> 入职日期</label> <input
				type="text" name="employeeWorkedTime"
				value="${animEmployee.employeeWorkedTime }">
		</div>
		<div class="form-group">
			<label for="role" class="col-sm-2 control-label"> 现任岗位</label> <select
				name="roleId">
				<option value="${animEmployee.roleId }">${animEmployee.animRole.roleName }</option>
				<c:forEach items="${roleList }" var="role">
					<c:if test="${animEmployee.roleId!=role.roleId }">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" name="submit" value="提交" class="btn btn-primary">
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath }/employee/view/back?pageNum=${pageNum}&employeeNameQuery=${employeeNameQuery}&roleNameQuery=${roleNameQuery}&deptNameQuery=${deptNameQuery}">返回上一级</a>
		</div>
	</form>
</div>
</body>
</html>