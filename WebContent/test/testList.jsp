<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/sidebar.jsp" %>

<h2>科目管理</h2>

<form action="../main/TestListSubjectExecute.action" method="post">
	<p>科目情報</p>

	<label for="f1">入学年度</label>
	<label for="f2">クラス</label>
	<label for="f3">科目</label>

	<select name="f1">
		<option>--------</option>
		<c:forEach var="entYear" items="${entYearList}">
		<option value="${entYear}">${entYear}</option>
		</c:forEach>
	</select>

	<select name="f2">
		<option>--------</option>
		<c:forEach var="classNum" items="${classList}">
		<option value="${classNum}">${classNum}</option>
		</c:forEach>
	</select>

	<select name="f3">
		<option>--------</option>
		<c:forEach var="subject" items="${subjectList}">
		<option value="${subject}">${subject.name}</option>
		</c:forEach>
	</select>

	<button type="submit">検索</button>
</form>



<%@include file="/includes/footer.jsp" %>