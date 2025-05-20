<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/sidebar.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.ClassNum" %>
<%@ page import="bean.Subject" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="main-container">
	<%@ include file="/includes/sidebar.jsp"%>
	<h2>成績管理</h2>

	<c:if test="${not empty error}">
	    <p style="color:red;">${error}</p>
	</c:if>

	<form action="/team_a/main/TestRegist.action" method="post">
		<label for="entYear">入学年度</label><br>
		<select name="entYear" id="entYear">
			<option value="">---------</option>
		<c:forEach var="e" items="${entYearList}">
			<option value="${e}" ${e == selectedYear ? "selected" : ""}>${e}</option>
		</c:forEach>
		</select>
		<br><br>

	    <label for="class">クラス</label><br>
		<select name="class" id="class">
			<option value="">---------</option>
	  	<c:forEach var="c" items="${classList}">
	    	<option value="${c}" ${c == selectedClass ? "selected" : ""}>${c}</option>
	  	</c:forEach>
		</select>
	    <br><br>

	    <label for="subject">科目</label><br>
		<select name="subject" id="subject">
			<option value="">---------</option>
	  	<c:forEach var="s" items="${subjectList}">
	    	<option value="${s.cd}" ${s.cd == selectedSubjectCd ? "selected" : ""}>${s.name}</option>
	  	</c:forEach>
		</select>
	    <br><br>

	    <label for="times">回数</label><br>
		<select name="times" id="times">
			<option value="">---------</option>
			<option value=1 ${1 == selectedTimes ? "selected" : ""}>1</option>
			<option value=2 ${2 == selectedTimes ? "selected" : ""}>2</option>
		</select>
	    <br><br>

	    <input type="submit" value="検索">
	</form>

	<c:if test="${not empty studentList}">
	    <p>科目：${selectedSubject.name} (${selectedTimes}回)</p>

	    <form action="/team_a/main/TestRegistExecute.action" method="post">

	        <input type="hidden" name="subjectCd" value="${selectedSubjectCd}">
	        <input type="hidden" name="classNum" value="${selectedClass}">
	        <input type="hidden" name="times" value="${selectedTimes}">

	        <table border="1">
	            <tr>
	                <th>入学年度</th>
	                <th>クラス</th>
	                <th>学生番号</th>
	                <th>氏名</th>
	                <th>点数</th>
	            </tr>
	            <c:forEach var="stu" items="${studentList}">
	                <tr>
	                    <td>${stu.entYear}</td>
	                    <td>${stu.classNum}</td>
	                    <td>
	                        ${stu.no}
	                        <input type="hidden" name="studentNo" value="${stu.no}">
	                    </td>
	                    <td>${stu.name}</td>
	                    <td>
	    					<input type="number" name="score_${stu.no}" min="0" max="100" required>
	    					<c:if test="${not empty errorMap[stu.no]}">
	        					<br><span style="color:red">${errorMap[stu.no]}</span>
	    					</c:if>
						</td>
	                </tr>
	            </c:forEach>
	        </table>

	        <input type="submit" value="登録して終了">
	    </form>
	</c:if>
</div>

<%@include file="/includes/footer.jsp" %>