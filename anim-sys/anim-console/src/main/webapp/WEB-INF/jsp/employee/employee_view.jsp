<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位查看</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="employeeId"
		value="${animEmployee.employeeId }">
	<input type="hidden" name="employeeNameQuery"
		value="${query.employeeNameQuery}">
	<input type="hidden" name="roleNameQuery" value="${query.roleNameQuery}">
	<input type="hidden" name="deptNameQuery" value="${query.deptNameQuery}">
	<div align="center" style="margin-left: 200px; margin-right: 200px">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-1 control-label"> 员工姓名</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeName }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 员工性别</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeSex }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 员工年龄</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeAge }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 出生年月</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeBorn }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 身份证号</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeCardnum }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 毕业院校</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeSchool }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 所学专业</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeMajor }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 最高学历</label>
				<div class="col-sm-1">
					<p class="form-control-static">
						${animEmployee.employeeEducation }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 家庭住址</label>
				<div class="col-sm-1">
					<p class="form-control-static">
						${animEmployee.employeeFamilyAddress }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 现住址</label>
				<div class="col-sm-1">
					<span class="form-control-static">
						${animEmployee.employeeNowAddress }</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 电话号码</label>
				<div class="col-sm-1">
					<p class="form-control-static">
						${animEmployee.employeeTelephone }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 微信号</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeWechant }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> qq号</label>
				<div class="col-sm-1">
					<p class="form-control-static">${animEmployee.employeeQq }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 入职日期</label>
				<div class="col-sm-1">
					<span class="form-control-static">
						${animEmployee.employeeWorkedTime }</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 现任岗位</label>
				<div class="col-sm-1">
					<p class="form-control-static">
						${animEmployee.animRole.roleName }</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 所在部门</label>
				<div class="col-sm-1 ">
					<p class="form-control-static">
						${animEmployee.animDept.deptName }</p>
				</div>
			</div>

			<div class="form-group" align="center">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath }/employee/view/back?pageNum=${pageNum}&employeeNameQuery=${query.employeeNameQuery}&roleNameQuery=${query.roleNameQuery}&deptNameQuery=${query.deptNameQuery}">返回上一级</a>
			</div>
		</form>
	</div>
</body>
</html>