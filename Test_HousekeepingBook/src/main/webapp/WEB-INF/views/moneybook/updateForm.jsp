<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿修正フォーム</title>
<script src="/resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function formCheck() {
		var moneybook_memo = $('#moneybook_memo').val();
		var moneybook_amount = $('#moneybook_amount').val();

		if (moneybook_memo == '') {
			alert("メモを入力してください");
			return false;
		}

		if (moneybook_amount == '') {
			alert("金額を入力してください");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h1>[ 家計簿修正 ]</h1>
	<form action="/moneybook/updateMoneyBook" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td>メモ</td>
				<td>
					<input type="text" id="moneybook_memo" name="moneybook_memo" value="${moneybook.moneybook_memo }">
				</td>
			</tr>
			<tr>
				<td>分類</td>
				<td>
					<c:if test="${moneybook.moneybook_type eq '収入' }">
						<select id="moneybook_type" name="moneybook_type">
							<option value="income" selected="selected">収入</option>
							<option value="outcome">支出</option>
						</select>
					</c:if>
					<c:if test="${moneybook.moneybook_type eq '支出' }">
						<select id="moneybook_type" name="moneybook_type">
							<option value="income">収入</option>
							<option value="outcome" selected="selected">支出</option>
						</select>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>金額</td>
				<td>
					<input type="text" id="moneybook_amount" name="moneybook_amount" value="${moneybook.moneybook_amount }">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修正"></td>
			</tr>
		</table>
		<input type="hidden" id="moneybook_no" name="moneybook_no" value="${moneybook.moneybook_no }">
	</form>
</body>
</html>