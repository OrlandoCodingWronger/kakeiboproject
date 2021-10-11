<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 家計簿 ]</title>
<script src="/resources/js/jquery-3.4.1.js"></script>
<script>
	function searchMoneyBook() {
		var search_type = $("#search_type").val();
		var search_value = $("#search_value").val();

		$("#type").val(search_type);
		$("#value").val(search_value);

		$("#searchForm").submit();
	}

	function getTotalResult(searchType) {
		$.ajax({
			  url: "/moneybook/totalResult"
			, data: {"searchType": searchType}
			, type: "GET"
		})
		.done(function(res) {
			$("#total_result").val(res);
		});
	}

	function getMinMax(searchType) {
		$.ajax({
			  url: "/moneybook/minMax"
			, data: {"searchType": searchType}
			, type: "GET"
		})
		.done(function(res) {
			$("#min_max").val(res);
		});
	}
</script>
</head>
<body>
	<h1>[ 家計簿 ]</h1>
	<table border=1>
		<tr>
			<th>番号</th>
			<th>メモ</th>
			<th>種類</th>
			<th>金額</th>
			<th>作成日</th>
			<th></th>
			<th></th>
		</tr>
		<c:choose>
			<c:when test="${not empty list }">
				<c:forEach items="${list }" var="data" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${data.MONEYBOOK_MEMO }</td>
						<td>${data.MONEYBOOK_TYPE }</td>
						<td>${data.MONEYBOOK_AMOUNT }</td>
						<td>${data.MONEYBOOK_INDATE }</td>
						<td><input type="button" value="修正"
							onclick="location.href='/moneybook/updateForm?moneybook_no=${data.MONEYBOOK_NO}'"></td>
						<td><input type="button" value="削除"
							onclick="location.href='/moneybook/deleteMoneyBook?moneybook_no=${data.MONEYBOOK_NO}'"></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<td colspan=7>登録されたデータがありません。</td>
			</c:otherwise>
		</c:choose>
	</table>
	<input type="button" value="家計簿作成"
		onclick="location.href='/moneybook/insertForm'">
	<br><br>
	
	<select id="search_type">
		<option value="all">全体</option>
		<option value="income">収入</option>
		<option value="outcome">支出</option>
	</select>
	<input type="text" id="search_value" placeholder="検索したい言葉を入力">
	<input type="button" value="検索" onclick="searchMoneyBook()">
	
	<form id="searchForm" action="/moneybook/selectList" method="get">
		<input type="hidden" id="type" name="search_type">
		<input type="hidden" id="value" name="search_value">
	</form>
	<br>
	
	<input type="button" value="総収入" onclick="getTotalResult('収入');">
	<input type="button" value="総支出" onclick="getTotalResult('支出');">
	<input type="text" id="total_result" placeholder="総収入及び支出" readonly="readonly">
	<br><br>
	
	<input type="button" value="最少額" onclick="getMinMax('min');">
	<input type="button" value="最大額" onclick="getMinMax('max');">
	<input type="text" id="min_max" placeholder="最少及び最大額" readonly="readonly">
</body>
</html>