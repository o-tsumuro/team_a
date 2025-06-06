<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">

	<%@include file="/includes/sidebar.jsp" %>

	<div class="column-child">
		<h2>科目管理</h2>
		<a href="./SubjectCreate.action">新規登録</a>

		<table border="1"><thead><th>科目コード</th><th>科目名</th></thead>
		<tbody>
			<c:forEach var="sbj" items="${subjectList}">
				<tr>
					<td>${sbj.cd}</td>
					<td>${sbj.name}</td>
					<td>
						<c:url value="./SubjectUpdate.action" var="sbjUpdateUrl">
							<c:param name="cd" value="${sbj.cd}" />
						</c:url>
						<a href="${sbjUpdateUrl}">変更</a>
					</td>
					<td>
						<c:url value="./SubjectDelete.action" var="sbjDeleteUrl">
							<c:param name="cd" value="${sbj.cd}" />
						</c:url>
						<a href="${sbjDeleteUrl}">削除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</div>


<%@include file="/includes/footer.jsp" %>