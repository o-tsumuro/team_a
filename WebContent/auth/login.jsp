<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<h2>ログイン</h2>

<c:if test="${not empty error}">
    <li>${error}</li>
</c:if>


<form action="/team_a/LoginExecute.action" method="post">
	<input type="text"
		   name="id"
		   maxlength="10"
		   style="ime-mode: disabled;"
		   required
		   placeholder="半角でご入力ください"
		   value="${id}">

	<input type="text"
		   name="password"
		   maxlength="30"
		   style="ime-mode: disabled;"
		   required
		   placeholder="30文字以内の半角英数字でご入力ください">

	<input type="checkbox" name="chk_d_ps" id="chk_d_ps">
	<label for="chk_d_ps">パスワードを表示</label>
	<input type="submit" name="login" value="ログイン">
</form>

<%@include file="/includes/footer.jsp" %>