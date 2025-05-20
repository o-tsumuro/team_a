
<table><thead><th>入学年度</th><th>クラス</th><th>学生番号</th><th>1回</th><th>2回</th></thead></table>
<tbody>
	<c:forEach var="test" items="${sbjTestList}">
		<tr>
			<td>${test.entYear}</td>
			<td>${test.classNum}</td>
			<td>${test.studentNo}</td>
			<td>${test.studentName}</td>

			<c:forEach var="point" items="${test.points}">
				<td>${point.value}</td>
			</c:forEach>

		</tr>
	</c:forEach>
</tbody>

