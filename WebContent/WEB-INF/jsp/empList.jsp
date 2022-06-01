<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Const" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>社員管理システム</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

	<div id="content">
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		<main id="main">
			<h1>社員一覧</h1>

			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>性別</th>
					<th>誕生日</th>
					<th>出身</th>
					<th>部署名</th>
					<th class="no-border"></th>
					<th class="no-border"></th>					
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td><c:out value="${emp.id}" /></td>
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value="${emp.gender.gname}" /></td>
						<td><c:out value="${emp.birthday}" /></td>
						<td><c:out value="${emp.state.sname}" /></td>
						<td><c:out value="${emp.dept.dname}" /></td>
						<td class="no-border img-btn">
							<form action="<%=request.getContextPath()%>/edit" method="post">
								<input type="hidden" name="id" value="${emp.id}">
								<button class="no-btn" type="submit"><%=Const.IMG_PENCIL %></button>
							</form>
						</td>
						<td class="no-border img-btn">
							<form action="<%=request.getContextPath()%>/delete" method="post">
								<input type="hidden" name="id" value="${emp.id}">
								<button class="no-btn" type="submit"><%=Const.IMG_TRASH %></button> 
							</form>
						</td>						
					</tr>
				</c:forEach>
			</table>
			<div id="pagenation">
				<ul>
					<li><a href="<%=request.getContextPath() %>/list?page=${pageInfo.current - 1 < 1 ? 1 : pageInfo.current - 1}">&lt;</a></li>
					<c:forEach var="c" begin="${pageInfo.first}" end="${pageInfo.last}" step="1">
						<c:choose>
							<c:when test="${c == pageInfo.current}">
								<li style="font-weight: bold;">
								  <a href="<%=request.getContextPath() %>/list?page=${c}">${c}</a>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="<%=request.getContextPath() %>/list?page=${c}">${c}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li><a href="<%=request.getContextPath() %>/list?page=${
						pageInfo.current + 1 > pageInfo.last ? pageInfo.last : pageInfo.current + 1}">&gt;</a></li>
				</ul>
			</div>
		</main>
	</div>
	<!-- #content -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%=request.getContextPath() %>/js/script.js"></script>
</body>
</html>