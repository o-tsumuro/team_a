<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">
	<%@include file="/includes/sidebar.jsp" %>

	<h2>科目情報削除</h2>

	<form action="../main/SubjectDeleteExecute.action" method="post">

		<p>「${subject.name}(${subject.cd})」を削除してもよろしいですか</p>

		<button type="submit">削除</button>

	</form>

	<a href="/team_a/main/SubjectList.action">戻る</a>
</div>

<%@include file="/includes/footer.jsp" %>