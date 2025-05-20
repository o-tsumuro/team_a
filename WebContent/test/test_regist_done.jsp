<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/includes/header.jsp" %>

<div class="main-container">
	<%@ include file="/includes/sidebar.jsp"%>
	<c:if test="${not empty message}">
	    <p>${message}</p>
	</c:if>

	<a href="/team_a/main/TestRegist.action">戻る</a>
	<a href="/team_a/main/TestList.action">成績参照</a>
</div>

<%@include file="../includes/footer.jsp" %>