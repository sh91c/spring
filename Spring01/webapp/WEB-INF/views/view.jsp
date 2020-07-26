<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 300px;
		margin: 0 auto;
	}
	table, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	td:ntd-child(1) {
		width: 100px;
	}
	td:ntd-child(2) {
		width: 200px;
	}
</style>
</head>
<body>
	<table>
		<tr>	
			<td>이름</td>
			<td>${ user.name }</td>
		</tr>
		<tr>	
			<td>연락처</td>
			<td>${ user.tel }</td>
		</tr>
		<tr>	
			<td align="center" colspan="2">
				<a href="/List">목록으로 /</a>
				<a href="/UpdateForm?tel=${user.tel}"> 수정 / </a>
				<a href="/DeleteForm?tel=${user.tel}&name=${user.name}"> 삭제 </a>
			</td>
		</tr>
	</table>
	
</body>
</html>