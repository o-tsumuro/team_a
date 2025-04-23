<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/sidebar.jsp" %>

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


<input type="submit" value="変更">
</form>
<a href="/team_a/main/SubjectList.action">戻る</a>

<%@include file="/includes/footer.jsp" %>