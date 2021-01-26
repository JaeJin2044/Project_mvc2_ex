
function joinCheck(){
	
	var userGender = document.getElementsByName("userGender");
	
	/*if(userGender[0].checked == false && userGender[1].checked == false){
		alert('성별을 선택해주세요');
		return false;
	}*/
	
	if(document.myform.userID.value.length == 0){
		alert('아이디를 입력해주세요');
		myform.userID.focus();
		return false;	
	}
	
	if(document.myform.userID.value.length < 5){
		alert('아이디가 너무 짧습니다.');
		myform.userID.focus();
		return false;	
	}
	
	if(document.myform.userPassword.value.length == 0){
		alert('비밀번호를 입력해주세요');
		myform.userPassword.focus();
		return false;
	}
	
	if(document.myform.userPassword.value != document.myform.userPassword_check.value){
		alert('비밀번호가 맞지 않습니다.');
		myform.userPassword_check.focus();
		return false;
	}
	if(document.myform.userName.value.length ==0){
		alert('이름을 입력해주세요');
		myform.userName.focus();
		return false;
	}
	
	if(document.myform.userGender.value.length ==0){
		alert('성별을 체크해주세요');
		myform.userGender.focus();
		return false;
	}
	
	if(document.myform.userEmail.value.length ===0){
		alert('이메일을 입력해주세요');
		myform.userEmail.focus();
		return false;
	}
	
	
	
	return true;
}


function loginCheck(){
	
	if(document.myform.userID.value.length == 0){
		alert('아이디를 입력해주세요');
		myform.userID.focus();
		return;
	}
	if(document.myform.userPassword.value.length == 0){
		alert('비밀번호를 입력해주세요');
		myform.userPassword.focus();
		return;
	}
	
	
	document.myform.submit();
}




