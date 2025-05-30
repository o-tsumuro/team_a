<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/includes/header.jsp"%>


<div class="main-container">
<%@ include file="/includes/sidebar.jsp"%>
<div class="column-child">
<h2>学生情報変更</h2>

<form action="StudentUpdateExecute.action" method="post">


	<p>入学年度: ${student.entYear}</p>
	<input type="hidden" name="entYear" value="${student.entYear}" readonly>

	<p>学生番号: ${student.no}</p>
	<input type="hidden" name="no" value="${student.no}" readonly>

	<p>氏名:</p>
	<input type="text" name="name" maxlength="10" value="${student.name}" required><br>

	<p>クラス:</p>
	<select name="classNum" required>
		<option value="">------</option>
		<c:forEach var="classNum" items="${classNumList}">
			<option value="${classNum}">${classNum}</option>
		</c:forEach>
	</select><br>

	<p>在学中:</p>
	<input type="checkbox" name="isAttend" value="true"
		<c:if test="${student.attend}">checked</c:if>>在学中<br>

	<input type="submit" value="更新">
</form>
    <a href="/team_a/main/StudentList.action">戻る</a>
</div>
</div>
<%@ include file="/includes/footer.jsp"%>
