<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style2.css'/>">
</head>


<div class="header-wrapper">
    <h1>得点管理システム</h1>
    <div class="header-log">
        <c:if test="${not empty user and not empty teacher}">
        	<span>${teacher.name}</span>
        	<a href="/team_a/main/Logout.action">ログアウト</a>
    	</c:if>
    </div>
</div>
