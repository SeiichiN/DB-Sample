<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
	<c:if test="${not empty emp.id}">
		<tr>
			<th>ID</th>
			<td><c:out value="${emp.id}" /></td>
		</tr>
	</c:if>
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

