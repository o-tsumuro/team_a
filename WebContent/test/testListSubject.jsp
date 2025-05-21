<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="subject-result-container-unique">
  <table class="subject-table-unique">
    <thead class="subject-table-head-unique">
      <tr class="subject-table-row-unique">
        <th class="subject-table-header-unique">入学年度</th>
        <th class="subject-table-header-unique">クラス</th>
        <th class="subject-table-header-unique">学生番号</th>
        <th class="subject-table-header-unique">氏名</th>
        <th class="subject-table-header-unique">1回</th>
        <th class="subject-table-header-unique">2回</th>
      </tr>
    </thead>
    <tbody class="subject-table-body-unique">
      <c:forEach var="t" items="${sbjTestList}">
        <tr class="subject-table-row-unique">
          <td class="subject-table-cell-unique">${t.entYear}</td>
          <td class="subject-table-cell-unique">${t.classNum}</td>
          <td class="subject-table-cell-unique">${t.studentNo}</td>
          <td class="subject-table-cell-unique">${t.studentName}</td>

          <c:forEach var="point" items="${t.points}">
            <c:choose>
              <c:when test="${point.value == -1}">
                <td class="subject-table-cell-unique">-</td>
              </c:when>
              <c:otherwise>
                <td class="subject-table-cell-unique">${point.value}</td>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>