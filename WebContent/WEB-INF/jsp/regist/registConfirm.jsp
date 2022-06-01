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
			<h1>新規社員登録・確認</h1>

			<table>
				<tr>
					<th>名前</th>
					<td><c:out value="${emp.name}" /></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><c:out value="${emp.pass}" /></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><c:out value="${emp.gender.gname}" /></td>
				</tr>
				<tr>
					<th>誕生日</th>
					<td><c:out value="${emp.birthday}" /></td>
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
			<form action="<%=request.getContextPath()%>/registDone" method="post">
				<input type="hidden" name="id" value="${emp.id}">
				<input type="hidden" name="name" value="${emp.name}"> 
				<input type="hidden" name="pass" value="${emp.pass}"> 
				<input type="hidden" name="gender" value="${emp.gender.gid}"> 
				<input type="hidden" name="birthday" value="${emp.birthday}"> 
				<input type="hidden" name="state" value="${emp.state.sid}"> 
				<input type="hidden" name="dept" value="${emp.dept.did}"> 
				<input class="submit-btn" type="submit" value="登録">
			</form>
			<a href="<%=request.getContextPath()%>/input">
				<button class="cancel-btn">取消</button>
			</a>
		</main>
	</div>
	<!-- #content -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>