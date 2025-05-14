<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="menu-container">
	<h3><a href="<c:url value='/main/Menu.action'/>">メニュー</a></h3>
	<p><a href="<c:url value='/main/StudentList.action'/>">学生管理</a></p>
	<h3>成績管理</h3>
	<ul class="menu-list">
		<li><a href="/team_a/main/TestRegist.action">成績登録</a></li>
		<li><a href="/team_a/main/TestList.action">成績参照</a></li>
	</ul>
	<p><a href="/team_a/main/SubjectList.action">科目管理</a></p>
</div>