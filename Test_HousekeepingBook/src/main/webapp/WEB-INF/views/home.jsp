<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿メイン</title>
</head>
<body>
	<h1>[ 家計簿 ]</h1>
	<ul>
		<c:choose>
			<c:when test="${not empty sessionScope.loginId }">
				<li><a href="/moneybook/selectList">私の家計簿</a></li>
				<li><a href="/account/logout">ログアウト</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/account/insertAccountForm">メンバー加入</a></li>
				<li><a href="/account/loginForm">ログイン</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>
