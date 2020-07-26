<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border: 1px solid black; border-collapse: collapse;
	}
	table { width: 300px; margin: 0 auto; }
	td:nth-of-type(1){ width: 100px;}
	td:nth-of-type(2){ width: 200px;}
	td[colspan] { text-align : center; }
</style>
</head>
<body>
	<h1>회원정보수정</h1>
	<form action="/Update" method="POST">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${ user.name }"/></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="tel" value="${ user.tel }" readonly/></td>
				<!-- readonly속성 수정못하게 막음, disable 속성은 값이 넘어가지않으므로 사용 X  -->
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정 완료"/></td>
			</tr>
		</table>
	</form>
</body>
</html>