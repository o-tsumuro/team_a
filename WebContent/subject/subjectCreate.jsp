<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/sidebar.jsp" %>

<h2>科目情報登録</h2>

<form action="../main/SubjectCreateExecute.action" method="post">
<label>
<p>科目コード</p>
<input type="text"
		name="cd"
		maxlength="3"
		placeholder="科目コードを入力してください。"
		value="${cd}">
</label>
<br>
<label>
<p>科目名</p>
<input type="text"
		name="name"
		maxlength="20"
		placeholder="科目名を入力してください。"
		value="${name}">
</label>

<c:if test="${not empty message}">
    <li>${message}</li>
</c:if>


<input type="submit" value="登録">
</form>
<a href="/team_a/main/SubjectList.action">戻る</a>

<%@include file="/includes/footer.jsp" %>