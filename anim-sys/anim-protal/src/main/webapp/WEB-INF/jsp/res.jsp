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
<title>Insert title here</title>
<link href="<%=baseUrl%>css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="<%=baseUrl%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=baseUrl%>js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#download').on('click', function() {

			$('#form_download').submit();
		})
	})

	function query() {
		$('#query_form').submit();
	}
</script>
</head>
<body>
	<div>
		<div style="margin-top: 15px; margin-left: 60px">
			<form action="${pageContext.request.contextPath }/res/list"
				method="post" class="form-inline" role="form" id="query_form">
				<div class="form-group">
					<label for="res">素材查询：</label><input type="text"
						value="${query.resNameQuery }" name="resNameQuery"
						placeholder="请输入素材名称" class="form-control">
				</div>
				<div class="form-group">
					<select id="queryType" name="queryType" class="form-control">
						<c:choose>
							<c:when test="${query.queryType==0 }">
								<option value="0" selected>精确查询</option>
								<option value="1">模糊查询</option>
							</c:when>
							<c:otherwise>
								<option value="0">精确查询</option>
								<option value="1" selected>模糊查询</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				<div class="form-group">
					<input type="button" name="btn" value="查询"
						class="btn btn-default btn-md" onclick="query()">
				</div>
				<div class="form-group">
					<input type="button" value="下载" class="btn btn-default btn-md"
						id="download">
				</div>
			</form>
		</div>
		<div style="width: 98%; margin-left: 30px" align="left">
			<form id="form_download"
				action="${pageContext.request.contextPath }/res/downLoad?pageNum=${pageNum}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}"
				method="post" enctype="application/multipart/form-data">
				<ul class="list-inline" style="margin: 10px; padding: 10px;">
					<c:forEach items="${pageInfo.list }" var="animRes">
						<li>
							<div align="center">
								<div>
									<img src="${animRes.resReviewUrl }" class="img-rounded"
										title="${animRes.resReviewUrl }"
										onclick="javascript:showBigImg('${animRes.resViewUrl}','${animRes.resName }','${animRes.resUrl }')">
								</div>
								<div>
									<div align="center" class="checkbox">
										<label><input type="checkbox" name="url"
											id="urlSelect" value="${animRes.resUrl }"
											class="btn btn-default btn-md"> ${animRes.resName }</label>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<!-- 分页功能 -->
				<div
					style="margin-left: 30px; margin-top: 10px; margin-bottom: 20px">
					<span> <a class="btn btn-default btn-md"
						href="${pageContext.request.contextPath }/res/list?pageNum=1&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}">首页</a></span>
					<span><a class="btn btn-default btn-md"
						href="${pageContext.request.contextPath }/res/list?pageNum=${pageInfo.prePage}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}">上一页</a></span>
					<c:forEach begin="${pageInfo.pageNum }"
						end="${(pageInfo.pageNum+10)>pageInfo.pages?pageInfo.pages: pageInfo.pageNum+10}"
						step="1" var="num">
						<span><a
							href="${pageContext.request.contextPath }/res/list?pageNum=${num}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}">
								<c:choose>
									<c:when test="${pageInfo.pageNum==num}">
										<span style="font-size: 15px"><u>${num }</u></span>
									</c:when>
									<c:otherwise>
										<span style="font-size: 15px">${num }</span>
									</c:otherwise>
								</c:choose>
						</a></span>
					</c:forEach>
					<select id="page" name="pageNum" onchange="changed()"
						class="btn btn-default btn-md">
						<option selected>${pageInfo.pageNum }</option>
						<c:forEach begin="1" end="${pageInfo.pages }" step="1" var="num">
							<c:if test="${pageInfo.pageNum!=num }">
								<option value="${num }">${num}</option>
							</c:if>
						</c:forEach>
					</select> <span><a class="btn btn-default btn-md"
						href="${pageContext.request.contextPath }/res/list?pageNum=${pageInfo.nextPage}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}">下一页</a></span>
					<span><a class="btn btn-default btn-md"
						href="${pageContext.request.contextPath }/res/list?pageNum=${pageInfo.pages}&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}">尾页</a></span>
				</div>
			</form>
		</div>
	</div>
	<div>
		<input type="hidden" id="hidden" value="">
		<div id="ShowImage_Form" class="modal fade" aria-hidden="true">
			<div class="modal-dialog" style="width: 70%">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<span id="img_title">jpg</span>
						<button id="view_download" value="" class="btn btn-default btn-md"
							onclick="view_download()">下载</button>
					</div>
					<div class="modal-body">
						<div id="img_show"></div>
						<img src="" id="bigImg"
							class='carousel-inner img-responsive img-rounded'>
					</div>
				</div>
			</div>
		</div>
	</div>
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
					+ "/res/list?pageNum="
					+ value
					+ "&resNameQuery=${query.resNameQuery}&resCatagortyNameQuery=${query.resCatagortyNameQuery}&queryType=${query.queryType}";
		}

		function showBigImg(imgUrl, name, resUrl) {
			//alert(name)
			var serverName = "${pageContext.request.serverName}";
			var serverPort = "${pageContext.request.serverPort}";
			var contextPath = "${pageContext.request.contextPath }";
			var url = "http://172.16.2.9:8001/" + imgUrl;
			//	alert(url);
			$('#bigImg').attr('src', url);
			$('#hidden').attr('value', resUrl)
			$('#img_title').text(name);
			$('#ShowImage_Form').modal();
		}

		function view_download() {
			var serverName = "${pageContext.request.serverName}";
			var serverPort = "${pageContext.request.serverPort}";
			var contextPath = "${pageContext.request.contextPath }";
			var url = $('#hidden').val();
			window.location.href = "http://" + serverName + ":" + serverPort
					+ contextPath + "/res/download/view?resUrl=" + url;
		}
	</script>
</body>
</html>