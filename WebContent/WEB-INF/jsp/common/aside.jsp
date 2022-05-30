<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="util.Const" %>

<aside id="sub-content">
	<div id="menu-line"><div id="menu-btn">メニュー</div></div>
	<nav id="menu" class="no-disp">
		<ul>
			<li><a href="<%=request.getContextPath()%>/input">新規社員登録</a></li>
			<li class="search-box">
				<form action="<%=request.getContextPath()%>/search_id" method="post">
					<input placeholder="社員ID" type="text" name="id">
					<button class="no-btn" type="submit"><%=Const.IMG_FIND %></button>
				</form>
			</li>
			<li class="search-box">
				<form action="<%=request.getContextPath()%>/search_name" method="post">
					<input placeholder="社員名" type="text" name="name">
					<button class="no-btn" type="submit"><%=Const.IMG_FIND %></button>
				</form>
			</li>
			<li class="search-box">
				<form action="<%=request.getContextPath() %>/list" method="post">
					<input placeholder="表示件数" type="text" name="per_page">
					<button class="no-btn" type="submit"><%=Const.IMG_CHECK %></button>
				</form>
			</li>
		</ul>
	</nav>
</aside>
