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
   <table>
	<caption>
   <h1>Board 목록(list)</h1>
	<a href="/Board/WriteForm">글쓰기</a>
	</caption>
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>이름</th>
         <th>날짜</th>
         <td colspan="2"></td>
      </tr>
   <c:forEach var="board" items="${ boardList }">
      <tr>
         <td>${ board.idx }</td>
         <td>${ board.title }</td>
         <td>${ board.name }</td>
         <td>${ board.regdate }</td>
         <td><a href="/Board/UpdateForm?idx=${ board.idx }">수정</a></td>
         <td><a href="/Board/Delete?idx=${ board.idx }">삭제</a></td>
      </tr>
   </c:forEach>
   </table>
   
   
</body>
</html>