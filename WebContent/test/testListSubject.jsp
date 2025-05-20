
<table border="1"><thead><th>入学年度</th><th>クラス</th><th>学生番号</th><th>1回</th><th>2回</th></thead></table>
<tbody>
	<c:forEach var="t" items="${sbjTestList}">
		<tr>
			<td>${t.entYear}</td>
			<td>${t.classNum}</td>
			<td>${t.studentNo}</td>
			<td>${t.studentName}</td>

			<c:forEach var="point" items="${t.points}">
				<c:choose>
					<c:when test="${point.value == -1}">
						<td>-</td>
					</c:when>
					<c:otherwise>
						<td>${point.value}</td>
					</c:otherwise>
				</c:choose>
			</c:forEach>

		</tr>
	</c:forEach>
</tbody>

