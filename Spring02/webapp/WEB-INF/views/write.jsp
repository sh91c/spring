<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<style>
	input[type="text"] {
		width: 80%;
	}
</style>
</head>
<body>
	<form action="/Board/Write" method="POST">
		<table>
			<caption>
			<h1>새 글 쓰기</h1>
			<a href="javascript:history.back()">뒤로</a>
			<a href="/Board/List">목록보기</a>
			</caption>
			<!-- name속성은 VO의 필드명과 같이 사용 -->
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" placeholder="제목을 입력하세요." /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" placeholder="이름을 입력하세요." /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기" /></td>
			</tr>
		</table>
	</form>
</body>
</html>