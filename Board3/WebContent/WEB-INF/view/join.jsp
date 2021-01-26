<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/join_.css">
<style>
	.join_form{
		display: flex;
		text-align: center;
		justify-content: center;
		border: 1px solid black;
	}
</style>
</head>
<body>
	<div class = "join_form">
		<form action ="/joinOk" method="post">
			<div>
				<input type="text" placeholder="아이디" name="user_id"/>
			</div>
			<div>
				<input type="text" placeholder="이름" name="user_name"/>
			</div>
			<div>
				<input type="text" placeholder="닉네임" name="user_nick"/>
			</div>
			<div>
				<input type="password" placeholder="비밀번호" name="user_pw"/>
			</div>
			<div>
				<input type="password" placeholder="비밀번호 확인" name="user_pw_check"/>
			</div>
			<div>
				<input type="text" name="user_phone" placeholder="연락처">
			</div>
			<div>
				<input type="text" name="user_age" placeholder="나이">
			</div>
			<div>
				주소1<input type="text" name="user_addr1"> 주소2<input type="text" name="user_addr2"> 
			</div>
			<div>
				<input type="text" name="user_mail" placeholder="이메일">
			</div>

			<div>
				<span>성별: </span> 
				<input type="radio" name="user_gender" value="man"/>남자
				<input type="radio" name="user_gender" value="woman"/>여자
			</div>
			<div>
				<input type="submit" value="회원가입"/>
			</div>
		</form>
	
	</div>
	
</body>



</html>