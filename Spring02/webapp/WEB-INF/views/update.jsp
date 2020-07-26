<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<style>
	th:nth-of-type(1) { width: 100px;}
</style>
</head>
<body>
	<form action="/Board/Update" method="POST">
		<table>
		<caption>
			<h1>글 수정</h1>
			<a href="/Board/List">목록으로</a>
		</caption>
			<tr>
				<th>번호</th>
				<td>${ board.idx }</td>
				<input type="hidden" name="idx" value="${ board.idx }"/>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${ board.title }"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${ board.name }"/></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${ board.regdate }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>