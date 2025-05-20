<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">
	<%@ include file="/includes/sidebar.jsp"%>
	<h2>メニュー</h2>

	<a href="#">学生管理</a>

	<div class="score_management">
		成績管理
		<a href="#">成績登録</a>
		<a href="#">成績参照</a>
	</div>

	<a href="/team_a/SubjectList.action">科目管理</a>
</div>

<%@include file="/includes/footer.jsp" %>