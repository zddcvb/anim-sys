<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/jsp/home/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能菜单</title>

</head>
<body style="background-color: #f5f5f5">
	<div class="container-fluid" >
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar"
				style="background-color: rgb();">
				<ul class="nav nav-sidebar" style="margin-left: 10px;margin-top: 10px;">
					<li class="active"><span>行政管理</span>

						<ul class="nav nav-sidebar">
							<li><a
								href="${pageContext.request.contextPath }/dept/list/0"
								target="right">部门管理</a></li>
							<li><a href="${pageContext.request.contextPath }/role/list"
								target="right">岗位管理</a></li>
							<li><a
								href="${pageContext.request.contextPath }/employee/list"
								target="right">员工管理</a></li>
							<li><a
								href="${pageContext.request.contextPath }/accout/list"
								target="right">账号管理</a></li>
						</ul></li>

					<li><span>素材管理</span>

						<ul class="nav nav-sidebar">
							<li><a
								href="${pageContext.request.contextPath }/res_catagorty/list"
								target="right">素材分类</a></li>
							<li><a href="${pageContext.request.contextPath }/res/list"
								target="right">素材管理</a></li>
						</ul></li>
					<li><span>工作管理</span>

						<ul class="nav nav-sidebar">
							<li><a
								href="${pageContext.request.contextPath }/res/list/all"
								target="right">已完成工作</a></li>
							<li><a href="${pageContext.request.contextPath }/res/list"
								target="right">未完成工作</a></li>
						</ul></li>
					<li><span>请假管理</span>
						<ul class="nav nav-sidebar">
							<li><a
								href="${pageContext.request.contextPath }/res_catagorty/list"
								target="right">请假流程管理</a></li>
							<li><a href="${pageContext.request.contextPath }/res/list"
								target="right">员工假期管理</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>