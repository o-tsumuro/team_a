<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="/includes/header.jsp"%>

<div class="login-container">

	<h2 class="login-title">ログイン</h2>

	<c:if test="${not empty error}">
		<li>${error}</li>
	</c:if>

	<form action="/team_a/LoginExecute.action" method="post">
		<div class="input-group">
		<input type="text" name="id" maxlength="10"
			style="ime-mode: disabled;" required placeholder="半角でご入力ください"
			value="${id}">
		</div>

		<div class="input-group">
		<input type="password" id="password"
			name="password" maxlength="30" style="ime-mode: disabled;" required
			placeholder="30文字以内の半角英数字でご入力ください">
		</div>

		<div class="checkbox-group">
			<input type="checkbox" name="chk_d_ps" id="chk_d_ps"
				onclick="togglePassword()"> <label for="chk_d_ps">パスワードを表示</label>
		</div>

		<input class="login-submit" type="submit" name="login" value="ログイン">
	</form>

	<script>
		function togglePassword() {
			const pwdField = document.getElementById("password");
			const checkbox = document.getElementById("chk_d_ps");
			pwdField.type = checkbox.checked ? "text" : "password";
		}
	</script>
</div>

<%@include file="/includes/footer.jsp"%>
