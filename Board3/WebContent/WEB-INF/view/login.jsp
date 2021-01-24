<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type= "text/css" rel="stylesheet" href="/css/login.css">
</head>
<body>
	<div class="container">
        <form id="login-form" method="get" action="/front/join.html">
            <div class="form-title">
                <h2>LOGO</h2>
            </div>
            <div class="form-input">
                <input class="login-input"type="text" placeholder="ID">
                <input class="login-input"type="password" placeholder="password">
            </div>
            <div class="form-btn">
                <input class="login-btn" type="submit" value="Login">
                <a href="/join"><input class="login-btn" type="button" value="Join"></a>
            </div>
            <a href="#">ID / Password 찾기</a>
        </form>
    </div>

</body>
</html>