<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String contextPath = request.getContextPath();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String baseUrl = "http://" + serverName + ":" + port + "/" + contextPath + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<div>个人信息</div>
	<hr>
	<div align="center">
		<table class="table table-striped" style="width: 60%;">
			<tbody align="center">
				<tr>
					<td>姓名：</td>
					<td>${employee.employeeName }</td>
					<td>性别：</td>
					<td>${employee.employeeSex }</td>
					<td></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td>${employee.employeeAge }</td>
					<td>入职日期：</td>
					<td>${employee.employeeBorn }</td>
					<td></td>
				</tr>
				<tr>
					<td>毕业院校：</td>
					<td>${employee.employeeSchool }</td>
					<td>所学专业：</td>
					<td>${employee.employeeMajor }</td>
					<td></td>
				</tr>
				<tr>
					<td>最高学历：</td>
					<td>${employee.employeeEducation }</td>
					<td>所属部门：</td>
					<td>${employee.animDept.deptName }</td>
					<td></td>
				</tr>
				<tr>
					<td>现有岗位：</td>
					<td>${employee.animRole.roleName }</td>
					<td>电话号码：</td>
					<td>${employee.employeeTelephone }</td>
					<td></td>
				</tr>
					<tr>
					<td>微信号：</td>
					<td>${employee.employeeWechant }</td>
					<td>QQ号：</td>
					<td>${employee.employeeQq }</td>
					<td></td>
				</tr>
					<tr>
					<td>广州现住址：</td>
					<td>${employee.employeeNowAddress }</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr >
					<td><a class="btn btn-default btn-md">密码修改</a></td>
					
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>