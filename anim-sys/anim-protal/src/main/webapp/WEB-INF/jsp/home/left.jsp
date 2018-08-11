<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/jsp/home/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能菜单</title>

</head>
<body style="background-color: #383E4B; margin-top: 20px">
	<div class="panel-group" id="accordion" align="center">
		<div style="margin-bottom: 20px">
			<div style="background-color: #383E4B;">
				<h4>
					<a
						href="${pageContext.request.contextPath }/emp/info?employeeId=${accout_session.employeeId}"
						target="right"><span style="color: white;">个人信息</span> </a>
				</h4>
			</div>
		</div>
		<div style="margin-bottom: 20px">
			<div style="background-color: #383E4B;">
				<h4>
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo"><span style="color: white;"> 日常事务</span>
					</a>
				</h4>
			</div>
		</div>
		<div id="collapseTwo" class=" collapse out">
			<div style="background-color: #40444B;">
				<div style="padding: 5px;">
					<a><span style="color: white;">个人考勤</span></a>
				</div>
				<div style="padding: 5px;">
					<a><span style="color: white;">个人请假</span></a>
				</div>
				<div style="padding: 5px;">
					<a><span style="color: white;">工作日志</span></a>
				</div>
				<div style="padding: 5px;">
					<a><span style="color: white;">周考核表</span></a>
				</div>
				<div style="padding: 5px;">
					<a><span style="color: white;">待办事务</span></a>
				</div>
				<div style="padding: 5px;">
					<a><span style="color: white;">已完成事务</span></a>
				</div>
			</div>
		</div>
		<div style="margin-bottom: 20px">
			<div style="background-color: #383E4B; color: white;">
				<h4>
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> <span style="color: white;">动画素材 </span></a>
				</h4>
			</div>
			<div id="collapseOne" class=" collapse out">
				<div style="background-color: #40444B;">
					<c:forEach items="${ resCatas}" var="resCata">
						<div style="padding: 5px;">
							<a
								href="${pageContext.request.contextPath }/res/list?resCatagortyNameQuery=${resCata.resCatagortyName}"
								target="right"><span style="color: white;">${resCata.resCatagortyName }</span></a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div style="margin-bottom: 20px">
			<div style="background-color: #383E4B; color: white;">
				<h4>
					<a data-toggle="collapse" data-parent="#accordion" href=""> <span
						style="color: white;">音频素材 </span></a>
				</h4>
			</div>
		</div>
		<div style="margin-bottom: 20px">
			<div style="background-color: #383E4B; color: white;">
				<h4>
					<a data-toggle="collapse" data-parent="#accordion" href=""> <span
						style="color: white;">常用动作 </span></a>
				</h4>
			</div>
		</div>
	</div>
</body>
</html>