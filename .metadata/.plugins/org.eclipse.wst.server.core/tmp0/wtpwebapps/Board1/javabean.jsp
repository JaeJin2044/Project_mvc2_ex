<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="student" class="com.java.student.ex.Student" scope="page"></jsp:useBean>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty name="student" property="gender" value="남자"/>
	<jsp:setProperty  name="student" property="name" value="이재진"/>
	<jsp:setProperty  name="student" property="age" value= "27"/>
	<jsp:setProperty  name="student" property="stuNum" value="21312637"/>
	
	이름 : <%out.println(student.getName());%><br/>
	나이 : <%out.println((student.getAge()+10));%><br/>
	성별 : <jsp:getProperty property="gender" name="student"/><br/>
	학번 :  <jsp:getProperty property="stuNum" name="student"/><br/>




</body>
</html>
 --%>