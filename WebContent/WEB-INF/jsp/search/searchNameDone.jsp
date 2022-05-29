<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Const" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>どこつぶ社員管理システム</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

	<div id="content">
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		<main id="main">
			<h1>社員名検索・結果</h1>

			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
					<th class="no-border"></th>
					<th class="no-border"></th>					
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td><c:out value="${emp.id}" /></td>
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value="${emp.age}" /></td>
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

			<a href="<%=request.getContextPath()%>/list">
				<button class="cancel-btn">一覧</button>
			</a>
		</main>
	</div>
	<!-- #content -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>