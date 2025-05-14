<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>氏名：${student.name}(${student.no})</p>
<table>
  <tr><th>科目名</th><th>科目コード</th><th>回数</th><th>点数</th></tr>
  <c:forEach var="t" items="${studentTestList}">
    <tr>
      <td>${t.subjectName}</td>
      <td>${t.subjectCd}</td>
      <td>${t.num}</td>
      <td>${t.point}</td>
    </tr>
  </c:forEach>
</table>