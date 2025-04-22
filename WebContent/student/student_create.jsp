<%@page import="bean.Teacher"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="/includes/header.jsp" %>

<h2>学生情報登録</h2>

<p><label for="year-select">入学年度</label><p>

<form action="/team_a/main/StudentCreateExecute.action" method="post">


<select name="ent_year" id="year-select" >
<option value="">------</option>
<%
    int baseYear = 2025;
    for (int year = baseYear - 10; year <= baseYear + 10; year++) {
  %>
<option value="<%= year %>"><%= year %></option>
<%}%>
</select>


<%-- 入学年度が選ばれていない場合のエラーメッセージ --%>
<c:if test="${not empty error}">
    <div class="error-message"><span style="color:orange;">${error}</span></div>
</c:if>


<p><label for="student-no">学生番号</label></p>
<input type="text"
	   name="no"
	   id="student-no"
	   maxlength="10"
	   placeholder="学生番号を入力してください"
	   >

<%-- 学生番号が重複している場合のエラーメッセージ --%>
<c:if test="${not empty error2}">
   <div class="error-message"><span style="color:orange;">${error2}</span></div>
</c:if>

<p><label for="student-name">氏名</label></p>
<input type="text"
	   name="name"
	   id="student-name"
	   maxlength="30"
	   placeholder="氏名を入力して下さい"
	   required>

<p><label for="student-class">クラス</label></p>
<p><select name="class_num" id="student-class" required>
<option value="">------</option>
<option value="101">101</option>
<option value="202">202</option>
</select></p>

<p><input value="登録して終了"type="submit" name="end"></p>
</form>
<a href="student-list.jsp">戻る</a>
<%@include file="/includes/footer.jsp" %>