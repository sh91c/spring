<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		border: 1px solid blue; width:300px; margin: 20px;
		float: left; border-radius: 10px;
	}
</style>
</head>
<body>
	<h1>List 회원 목록</h1>
	<c:forEach var="user" items="${userList}">
		<div>
			<h2>이름:${user.name}</h2>
			<p>연락처:<a href="/View?tel=${user.tel}">${user.tel}</a></p>
		</div>
	</c:forEach>
	<p/>
	<a href="/WriteForm">글쓰기</a>
</body>
</html>