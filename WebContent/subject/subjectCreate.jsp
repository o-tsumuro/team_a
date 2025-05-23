<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>


<div class="main-container">

	<%@include file="/includes/sidebar.jsp" %>

	<div class="column-child">
		<h2>科目情報登録</h2>

		<form action="../main/SubjectCreateExecute.action" method="post">

			<label for="cd">科目コード</label>
				<input type="text"
						name="cd"
						maxlength="3"
						placeholder="科目コードを入力してください。"
						value="${subject.cd}"
						required />
				<c:if test="${not empty sbjCdError}">
				    <li class="error-message">${sbjCdError}</li>
				</c:if>
			<br>
			<label for="name">科目名</label>
				<input type="text"
						name="name"
						maxlength="20"
						placeholder="科目名を入力してください。"
						value="${subject.name}"
						required />

			<button type="submit">登録</button>

		</form>
		<a href="/team_a/main/SubjectList.action">戻る</a>
	</div>
</div>

<%@include file="/includes/footer.jsp" %>