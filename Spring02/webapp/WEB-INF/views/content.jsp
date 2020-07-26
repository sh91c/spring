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
	<table>
	<caption>
		<h1>글 내용</h1>
		<a href="/Board/List">목록보기</a>
		<a href="/Board/WriteForm">새 글 쓰기</a>
		<a href="/Board/UpdateForm?idx=${ board.idx }">수정</a>
		<a href="/Board/Delete?idx=${ board.idx }">삭제</a>
	</caption>
		<tr>
			<th>번호</th>
			<td>${ board.idx }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${ board.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${ board.name }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${ board.regdate }</td>
		</tr>
	</table>
</body>
</html>