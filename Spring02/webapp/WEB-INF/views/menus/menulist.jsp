<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴 목록</h1>
	<c:forEach var="menuVO" items="${ menuList }">
		<div>		
			${ menuVO.menu_id } - ${ menuVO.menu_name } - ${ menuVO.menu_seq }
			<a href="/Menus/UpdateForm?menu_id=${ menuVO.menu_id }">
				<img src="/img/aa.jpg" alt="수정" />
			</a>
			<a href="/Menus/DeleteForm?menu_id=${ menuVO.menu_id }">
				<img src="/img/bb.jpg" alt="삭제" />
			</a>
		</div>
	</c:forEach>
	<div>
		<a href="/Menus/WirteForm">메뉴 추가</a>
	</div>
</body>
</html>