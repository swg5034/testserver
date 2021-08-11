<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입페이지</h2>
	<form action="join">
		ID: <input type="text" name="id" required/><br/>
		PW: <input type="password" name="pw" required/><br/>
		NAME: <input type="text" name="name" required/><br/>
		<input type="submit" id="btn-submit" value="제출하기" onclick = "signup()"/>
	</form>
	<script>
		function signup(){
			alert("가입되었습니다. 로그인해주세요.");
		}
	</script>
</body>
</html>