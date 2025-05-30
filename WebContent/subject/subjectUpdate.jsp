<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">

	<%@include file="/includes/sidebar.jsp" %>

	<div class="column-child">
		<h2>科目情報変更</h2>

			<form action="../main/SubjectUpdateExecute.action" method="post">

			<label for="cd">科目コード</label>
			<input type="text"
					name="cd"
					value="${subject.cd}"
					readonly />
			<br>
			<label for="name">科目名</label>
			<input type="text"
					name="name"
					maxlength="20"
					value="${subject.name}"
					required />

			<c:if test="${not empty message}">
			    <li>${message}</li>
			</c:if>

			<button type="submit">変更</button>

		</form>
		<a href="/team_a/main/SubjectList.action">戻る</a>
	</div>
</div>

<%@include file="/includes/footer.jsp" %>