<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/sidebar.jsp" %>

<h2>科目管理</h2>

<a href="#">新規登録</a>

<table><thead><th>科目コード</th><th>科目名</th></thead>
<tbody>
	<c:forEach var="sbj" items="${subjectList}">
		<tr>
			<td>${sbj.cd}</td>
			<td>${sbj.name}</td>
			<a href="#">変更</a>
			<a href="#">削除</a>
		</tr>
	</c:forEach>
</tbody>
</table>

<a href="#">科目管理</a>

<%@include file="/includes/footer.jsp" %>