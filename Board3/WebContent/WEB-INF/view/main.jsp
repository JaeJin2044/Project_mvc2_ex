<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지입니다.</h1>
	
	${sessionScope.user_id}님 안녕하세요 비밀번호는 : ${user_pw} 
	
	<a href="/logout"><input type="button" value="로그아웃"></a>

</body>
</html>

