<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">
	<%@ include file="/includes/sidebar.jsp"%>

	<div class="menu-wrapper">
		<h2>メニュー</h2>

		<div class="menu-cards">

			<!-- 学生管理 -->
			<div class="menu-card card-student">
				<a href="/team_a/main/StudentList.action">学生管理</a>
			</div>

			<!-- 成績管理 -->
			<div class="menu-card card-score">
				<p>成績管理</p>
				<a href="/team_a/main/TestRegist.action">成績登録</a>
				<a href="/team_a/main/TestList.action">成績参照</a>
			</div>

			<!-- 科目管理 -->
			<div class="menu-card card-subject">
				<a href="/team_a/main/SubjectList.action">科目管理</a>
			</div>
		</div>
	</div>
</div>

<%@include file="/includes/footer.jsp" %>