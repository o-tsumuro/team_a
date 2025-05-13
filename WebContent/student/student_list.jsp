<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/sidebar.jsp" %>

<h2>学生管理</h2>

<a href="/team_a/main/StudentCreateForm.action">新規登録</a>
<form action="StudentList.action" method="post">
    <p>入学年度:</p>
    <select name="entYear">
        <option value="">------</option>
        <%
            int baseYear = 2025;
            for (int year = baseYear - 10; year <= baseYear + 10; year++) {
        %>
            <option value="<%= year %>"><%= year %></option>
        <% } %>
    </select><br>

<p>クラス番号:</p>
<select name="classNum">
    <option value="">------</option>
    <c:forEach var="classNum" items="${classNumList}">
        <option value="${classNum}">${classNum}</option>
    </c:forEach>
</select><br>

<c:if test="${not empty message}">
    <p style="color:red;">${message}</p>
</c:if>

    <p>在学中:</p>
    <input type="checkbox" name="isAttend" value="true" checked>在学中<br>

    <input type="submit" value="絞り込み">
</form>

<c:if test ="${studentCount == 0}">
	<p>学生情報が存在しませんでした</p>
	</c:if>

<c:if test="${studentCount != 0}">
<table border="1">
    <thead>
        <tr>
            <th>入学年度</th>
            <th>学生番号</th>
            <th>氏名</th>
            <th>クラス</th>
            <th>在学中</th>

        </tr>
    </thead>
    <p>検索結果：${studentCount} 件</p>

   <tbody>
       <c:forEach var="student" items="${studentList}">
           <tr>
               <td>${student.entYear}</td>
               <td>${student.no}</td>
               <td>${student.name}</td>
               <td>${student.classNum}</td>
               <td><c:choose>
                       <c:when test="${student.attend}">〇</c:when>
                       <c:otherwise>×</c:otherwise>
                   </c:choose>
               </td>

               <td>
             <c:url value="./StudentUpdate.action" var="updateUrl">
   			<c:param name="no" value="${student.no}" />
			</c:url>
			<a href="${updateUrl}">変更</a>

                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>

<%@ include file="/includes/footer.jsp" %>
