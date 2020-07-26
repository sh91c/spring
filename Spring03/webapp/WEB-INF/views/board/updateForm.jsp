<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/commons.css" />
</head>
<body>
	<form action="/Board/Update" method="POST">
	   <table>
		<caption>
		<h1>Update Form</h1>
		</caption>
	   <c:forEach var="board" items="${ boardList }">
	      <tr>
	      	<td>번호</td>
	        <td>${ board.idx }</td>
	        <input type="hidden" name="idx" value="${ board.idx }" />
	      </tr>
	      <tr>
	      	<td>제목</td>
	        <td><input type="text" name="title" value="${ board.title }"></td>
	      </tr>
	      <tr>
	      	<td>이름</td>
	        <td><input type="text" name="name" value="${ board.name }"></td>
	      </tr>
	      <tr>
	      	<td>날짜</td>
	        <td>${ board.title }</td>
	      </tr>
	      <tr>
	      	<td colspan="2">
	      		<input type="submit" value="수정" />
	      	</td> 
	      </tr>
	   </c:forEach>
	   </table>
   </form>
</body>
</html>