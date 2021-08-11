<%@page import="com.test.dao.MemberDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<%@ page import = "com.test.*" %>
<html>
<head>
<title>Login</title>
</head>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<body>
${msg }
<form action="login">
	<h2>로그인 페이지</h2>
	ID: <input type="text" id="id" name = "id"/><br/>
	PW: <input type="password" id="pw" name = "pw"/><br/>
	<button type="submit">로그인</button>
	<button type="button" onclick = "join()">회원가입</button>
	
</form>
<script>
	function join(){
		location.href = "joinPage";
	}
</script>
</body>
</html>
