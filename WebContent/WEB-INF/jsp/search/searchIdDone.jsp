<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>社員ID検索・結果</h1>

			<table>
				<tr>
					<th>ID</th>
					<td><c:out value="${emp.id}" /></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><c:out value="${emp.name}" /></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><c:out value="${emp.gender.gname}" /></td>
				</tr>
				<tr>
					<th>年齢</th>
					<td><c:out value="${emp.age}" /></td>
				</tr>
				<tr>
					<th>出身</th>
					<td><c:out value="${emp.state.sname}" /></td>
				</tr>
				<tr>
					<th>部署</th>
					<td><c:out value="${emp.dept.dname}" /></td>
				</tr>
			</table>
			<form action="<%=request.getContextPath()%>/edit" method="post">
				<input type="hidden" name="id" value="${emp.id}"> <input
					class="submit-btn-00" type="submit" value="編集">
			</form>
			<form action="<%=request.getContextPath()%>/delete" method="post">
				<input type="hidden" name="id" value="${emp.id}"> <input
					class="submit-btn" type="submit" value="削除">
			</form>
			<a href="<%=request.getContextPath()%>/list">
				<button class="cancel-btn">一覧</button>
			</a>
		</main>
	</div>
	<!-- #content -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>