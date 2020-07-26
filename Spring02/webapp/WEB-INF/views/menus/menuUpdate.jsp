<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴 수정</h1>
	<form action="/Menus/Update" method="post">
		<div>메뉴 번호 : ${ menuVO.menu_id }
			<input type="hidden" name="menu_id" value="${ menuVO.menu_id }" />
		</div>
		<div>메뉴명 : <input type="text" name="menu_name" value="${ menuVO.menu_name }" /></div>
		<div>메뉴 순서 : <input type="text" name="menu_seq" value="${ menuVO.menu_seq }" /></div>
		<div><input type="submit" value="수정 완료"/></div>
	</form>
</body>
</html>