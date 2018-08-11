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
<title>素材分类查看</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="roleId"
		value="${animResCatagorty.resCatagortyId }">
	<input type="hidden" name="resCatagortyNameQuery"
		value="${resCatagortyNameQuery}">
	<table>
		<tbody>
			<tr>
				<td>素材分类名称</td>
				<td><span>${animResCatagorty.resCatagortyName }</span></td>
			</tr>
			<tr>
				<td>素材分类创建时间</td>
				<td><span>${animResCatagorty.resCatagortyCreatetime }</span></td>
			</tr>
			<tr>
				<td>素材分类更新时间</td>
				<td><span>${animResCatagorty.resCatagortyUpdatetime }</span></td>
			</tr>
			<tr>
				<td>所在部门</td>
				<td><span>${animResCatagorty.parent.resCatagortyName }</span></td>
			</tr>
		</tbody>
	</table>
	<a
		href="${pageContext.request.contextPath }/res_catagorty/view/back?pageNum=${pageNum}&resCatagortyNameQuery=${resCatagortyNameQuery}">返回上一级</a>

</body>
</html>