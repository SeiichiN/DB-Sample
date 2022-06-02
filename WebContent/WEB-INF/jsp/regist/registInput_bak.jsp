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
			<h1>新規社員登録</h1>
			<c:forEach var="errorMsg" items="${errorMsgList}">
				<p><c:out value="${errorMsg}"/></p>
			</c:forEach>

			<form action="<%=request.getContextPath()%>/registConfirm" method="post">
				<table>
					<tr>
						<th>名前</th>
						<td><input class="indata" type="text" name="name"
						     placeholder="木村太郎"
						     <c:if test="${not empty emp.name}">
						       value="${emp.name}"
						     </c:if>>
						</td>	
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" class="indata" name="pass"
						     placeholder="半角英数字16桁以内"
						     <c:if test="${not empty emp.pass}">
						         value="${emp.pass}"
						     </c:if>>
						</td>
					</tr>
					<tr>
						<th>性別</th>
						<td>
							<span class="gender">
							  <input type="radio" name="gender" value="1" ${emp.gender.gid == 1 ? 'checked' : '' }>男性
							</span>
							<span class="gender"><input type="radio" name="gender" value="2" ${emp.gender.gid == 2 ? 'checked' : '' }>女性</span>
							<span class="gender"><input type="radio" name="gender" value="3" ${emp.gender.gid == 3 ? 'checked' : '' }>その他</span>
						</td>
					</tr>
					<tr>
						<th>誕生日</th>
						<td><input class="indata" type="text" name="birthday"
						     placeholder="yyyy/mm/dd"
						     <c:if test="${not empty emp.birthday}">
						         value="${emp.birthday}"
						     </c:if>>
					   </td>
					</tr>
					<tr>
						<th>出身</th>
						<td>
							<select class="state" name="state">
								<c:forEach var="optState" items="${optStateList}">
									<option value="${optState.no}"
									         <c:if test="${emp.state.sid == optState.no}">
									          selected="selected"
									         </c:if>
									        >${optState.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>部署</th>
						<td>
							<select class="dept" name="dept">
								<option value="d01" ${emp.dept.did == 'd01' ? 'selected' : ''}>総務部</option>
								<option value="d02" ${emp.dept.did == 'd02' ? 'selected' : ''}>経理部</option>
								<option value="d03" ${emp.dept.did == 'd03' ? 'selected' : ''}>第一営業部</option>
								<option value="d04" ${emp.dept.did == 'd04' ? 'selected' : ''}>開発部</option>
								<option value="d05" ${emp.dept.did == 'd05' ? 'selected' : ''}>第二営業部</option>
							</select>
						</td>
					</tr>
				</table>
				<input class="submit-btn" id="create-confirm-btn" type="submit" value="確認">
			</form>
			<a href="<%=request.getContextPath() %>/list">
			    <button class="cancel-btn" id="create-cancel-btn">戻る</button></a>
		</main>
	</div>
	<!-- #content -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>