<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加入フォーム</title>
<script src="/resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function formCheck(){
	var acc_id = $('#acc_id').val();
	var acc_pw = $('#acc_pw').val();
	var acc_pw_check = $('#acc_pw_check').val();
	var acc_nm = $('#acc_nm').val();

	if(acc_id == ''){
		alert("IDを入力してください");
		return false;
	}else if(acc_id.length < 3 || acc_id.length > 8){
		alert("IDは３~８文字で入力してください");
		return false;
	}

	if(acc_pw == ''){
		alert("パスワードを入力してください");
		return false;
	}else if(acc_pw.length < 5 || acc_pw.length > 10){
		alert("パスワードは５~１０文字で入力してください");
		return false;
	}else if(acc_pw != acc_pw_check){
		alert("同じパスワードを入力してください");
		return false;
	}

	if(acc_nm == ''){
		alert("お名前を入力してください");
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
	<h1>[ メンバー加入 ]</h1>
	<form action="/account/insertAccount" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="acc_id" id="acc_id"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="acc_pw" id="acc_pw"></td>
			</tr>
			<tr>
				<td>パスワード確認</td>
				<td><input type="password" id="acc_pw_check"></td>
			</tr>
			<tr>
				<td>お名前</td>
				<td><input type="text" name="acc_nm" id="acc_nm"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="加入"></td>
			</tr>
		</table>
	</form>
</body>
</html>
