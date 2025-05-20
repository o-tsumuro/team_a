<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">
	<%@ include file="/includes/sidebar.jsp"%>
	<h2>科目管理</h2>

	<form action="../main/TestListSubjectExecute.action" method="post">
		<p>科目情報</p>

		<label for="f1">入学年度</label>
		<label for="f2">クラス</label>
		<label for="f3">科目</label>

		<select name="f1">
			<option value="">--------</option>
			<c:forEach var="entYear" items="${entYearList}">
			<option value="${entYear}">${entYear}</option>
			</c:forEach>
		</select>

		<select name="f2">
			<option value="">--------</option>
			<c:forEach var="classNum" items="${classList}">
			<option value="${classNum}">${classNum}</option>
			</c:forEach>
		</select>

		<select name="f3">
			<option value="">--------</option>
			<c:forEach var="subject" items="${subjectList}">
			<option value="${subject.cd}">${subject.name}</option>
			</c:forEach>
		</select>

		<button type="submit">検索</button>

		<c:if test="${not empty sbjListError}">
		    <li>${sbjListError}</li>
		</c:if>

	</form>

	<form action="/team_a/main/TestListStudentExecute.action" method="post">
		<p>学生情報</p>

		<label for="f4">学生番号</label>
		<select name="student_no" id="f4">
			<c:forEach var="student" items="${sessionScope.studentList}">
				<option value="${student.no}">${student.no}</option>
			</c:forEach>
		</select>
		<button type="submit">検索</button>
	</form>

	<c:if test="${not empty sbjTestList}">
		<%@include file="testListSubject.jsp" %>
	</c:if>

	<c:if test="${not empty studentTestList}">
		<%@include file="testListStudent.jsp" %>
	</c:if>
</div>

<%@include file="/includes/footer.jsp" %>