<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>temp7 넘어온 값</h1>
	<p>a : ${ vo.a } model.addAttribute를 하지 않은 결과</p>
	<p>b : ${ vo.b } model.addAttribute를 하지 않은 결과</p>
	<hr>
	<p>attrName a : ${ attrName.a }</p>
	<p>attrName b : ${ attrName.b }</p>
	<hr>
	<p>param a : ${ param.a } || param의 풀 명령어 : (request.getParameter("a"))</p>
	<p>param a : ${ param.b } || param의 풀 명령어 : (request.getParameter("b"))</p>
	<hr>
	
</body>
</html>