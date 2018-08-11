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
<title>素材查看</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
</head>
<body>
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="resId" value="${animRes.resId }">
	<input type="hidden" name="resNameQuery" value="${resNameQuery}">
	<input type="hidden" name="resCatagortyNameQuery"
		value="${resCatagortyNameQuery}">
	<table>
		<tbody>
			<tr>
				<td>素材名称</td>
				<td><span>${animRes.resName }</span></td>
			</tr>
			<tr>
				<td>预览图地址</td>
				<td><span>${animRes.resReviewUrl }</span></td>
			</tr>
			<tr>
				<td>素材名称</td>
				<td><span>${animRes.resUrl }</span></td>
			</tr>
			<tr>
				<td>素材创建时间</td>
				<td><span>${animRes.resCreatetime }</span></td>
			</tr>
			<tr>
				<td>素材更新时间</td>
				<td><span>${animRes.resUpdatetime }</span></td>
			</tr>
			<tr>
				<td>素材大小</td>
				<td><span>${animRes.resSize }</span></td>
			</tr>
			<tr>
				<td>所在分类</td>
				<td><span>${animRes.animResCatagorty.resCatagortyName }</span></td>
			</tr>

		</tbody>
	</table>
	<a
		href="${pageContext.request.contextPath }/res/view/back?pageNum=${pageNum}&resNameQuery=${resNameQuery}&resCatagortyNameQuery=${resCatagortyNameQuery}">返回上一级</a>

</body>
</html>