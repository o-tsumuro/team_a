<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">
	<%@ include file="/includes/sidebar.jsp"%>
	<div class="test-list-container-unique">
		<h2 class="test-list-heading-unique">科目管理</h2>

		<form class="test-list-form-unique" action="../main/TestListSubjectExecute.action" method="post">
			<div class="form-layout-unique">
				<div class="form-title-column-unique">
					<p class="form-title-unique">科目情報</p>
				</div>
				<div class="form-content-column-unique">
					<div class="form-row-unique form-labels-unique">
						<label for="f1" class="test-list-label-unique">入学年度</label>
						<label for="f2" class="test-list-label-unique">クラス</label>
						<label for="f3" class="test-list-label-unique">科目</label>
					</div>

					<div class="form-row-unique">
						<select name="f1" id="f1" class="test-list-select-unique">
							<option value="">--------</option>
							<c:forEach var="entYear" items="${entYearList}">
							<option value="${entYear}">${entYear}</option>
							</c:forEach>
						</select>

						<select name="f2" id="f2" class="test-list-select-unique">
							<option value="">--------</option>
							<c:forEach var="classNum" items="${classList}">
							<option value="${classNum}">${classNum}</option>
							</c:forEach>
						</select>

						<select name="f3" id="f3" class="test-list-select-unique">
							<option value="">--------</option>
							<c:forEach var="subject" items="${subjectList}">
							<option value="${subject.cd}">${subject.name}</option>
							</c:forEach>
						</select>

						<button type="submit" class="search-button-unique">検索</button>
					</div>

					<c:if test="${not empty sbjListError}">
						<div class="error-message-unique">${sbjListError}</div>
					</c:if>
				</div>
			</div>
		</form>

		<form class="test-list-form-unique" action="/team_a/main/TestListStudentExecute.action" method="post">
			<div class="form-layout-unique">
				<div class="form-title-column-unique">
					<p class="form-title-unique">学生情報</p>
				</div>
				<div class="form-content-column-unique">
					<div class="student-form-wrapper-unique">
						<div class="form-column-unique">
							<label for="f4" class="test-list-label-unique">学生番号</label>
							<select name="student_no" id="f4" class="test-list-select-unique">
								<c:forEach var="student" items="${sessionScope.studentList}">
									<option value="${student.no}">${student.no}</option>
								</c:forEach>
							</select>
						</div>
						<div class="button-wrapper-unique">
							<button type="submit" class="search-button-unique">検索</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<c:if test="${not empty sbjTestList}">
			<%@include file="testListSubject.jsp" %>
		</c:if>

		<c:if test="${not empty studentTestList}">
			<%@include file="testListStudent.jsp" %>
		</c:if>
	</div>
</div>

<%@include file="/includes/footer.jsp" %>