<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="student-result-container-unique">
  <p class="student-info-unique">氏名：${student.name}(${student.no})</p>
  <table class="result-table-unique">
    <tr class="result-table-row-unique">
      <th class="result-table-header-unique">科目名</th>
      <th class="result-table-header-unique">科目コード</th>
      <th class="result-table-header-unique">回数</th>
      <th class="result-table-header-unique">点数</th>
    </tr>
    <c:forEach var="t" items="${studentTestList}">
      <tr class="result-table-row-unique">
        <td class="result-table-cell-unique">${t.subjectName}</td>
        <td class="result-table-cell-unique">${t.subjectCd}</td>
        <td class="result-table-cell-unique">${t.num}</td>
        <td class="result-table-cell-unique">${t.point}</td>
      </tr>
    </c:forEach>
  </table>
</div>