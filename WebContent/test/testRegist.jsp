<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/sidebar.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.ClassNum" %>
<%@ page import="bean.Subject" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>成績管理</h2>

<form action="/team_a/main/TestRegist.action" method="post">
	<label for="entYear">入学年度</label><br>
	<select name="entYear" id="entYear">
	<c:forEach var="e" items="${entYearList}">
		<option value="${e}" ${e == selectedYear ? "selected" : ""}>${e}</option>
	</c:forEach>
	</select>
	<br><br>

    <label for="class">クラス</label><br>
	<select name="class" id="class">
  	<c:forEach var="c" items="${classList}">
    	<option value="${c}" ${c == selectedClass ? "selected" : ""}>${c}</option>
  	</c:forEach>
	</select>
    <br><br>

    <label for="subject">科目</label><br>
	<select name="subject" id="subject">
  	<c:forEach var="s" items="${subjectList}">
    	<option value="${s.cd}" ${s.cd == selectedSubjectCd ? "selected" : ""}>${s.name}</option>
  	</c:forEach>
	</select>
    <br><br>

    <label for="times">回数</label><br>
	<select name="times" id="times">
		<option value=1 ${1 == selectedTimes ? "selected" : ""}>1</option>
		<option value=2 ${2 == selectedTimes ? "selected" : ""}>2</option>
	</select>
    <br><br>

    <input type="submit" value="検索">
</form>


<%@include file="/includes/footer.jsp" %>