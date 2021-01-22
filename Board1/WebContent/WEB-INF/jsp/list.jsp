<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin-left: auto;
    	margin-right: auto;
	}
	h1{
		text-align: center;
	}
	td{
		text-align: center;
	}
	
	a{
	text-decoration: none;
	color: green;
}
	

</style>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<table width="900" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td><a href="/content_view.do?bId=${dto.bId}">${dto.bTitle}<a/></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5"> <a href="/write_view.do">글작성</a></td>
		</tr>
	
		<tr>
			<td colspan="5">
		<c:forEach begin="1" end="5" var="i">
			 <a href="/write_view.do">${i}</a> 
		</c:forEach>	
			 </td>
		</tr>
	
	</table>
	
	

</body>
</html>