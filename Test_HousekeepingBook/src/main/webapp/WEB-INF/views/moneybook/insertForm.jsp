<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿入力フォーム</title>
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
	<h1>[ 家計簿入力 ]</h1>
	<form action="/moneybook/insertMoneyBook" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td>メモ</td>
				<td><input type="text" name="moneybook_memo" id="moneybook_memo"></td>
			</tr>
			<tr>
				<td>分類</td>
				<td><select name="moneybook_type" id="moneybook_type">
						<option value="income">収入</option>
						<option value="outcome">支出</option>
				</select></td>
			</tr>
			<tr>
				<td>金額</td>
				<td><input type="text" name="moneybook_amount" id="moneybook_amount"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="入力"></td>
			</tr>
		</table>
	</form>
</body>
</html>