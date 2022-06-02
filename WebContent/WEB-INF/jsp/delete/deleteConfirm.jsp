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
			<h1>削除処理・確認</h1>
			
			<jsp:include page="/WEB-INF/jsp/common/confirm.jsp" />

			<form action="<%=request.getContextPath()%>/deleteDone" method="post">
				<input type="hidden" name="id" value="${emp.id}">
				<input class="submit-btn" type="submit" value="削除">
			</form>
			<a href="<%=request.getContextPath()%>/list">
				<button class="cancel-btn">取消</button>
			</a>
		</main>
	</div>
	<!-- #content -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>