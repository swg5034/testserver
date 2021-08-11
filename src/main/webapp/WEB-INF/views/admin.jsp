<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style = "display : flex; justify-content: space-between;">
	<div>
		<h1>회원관리</h1>
	</div>
	<div>
		<button>로그아웃</button>
	</div>
</div>
<table>
<tr>
<th>ID</th>
<th>PW</th>
<th>Name</th>
<th>Point</th>
<th>수정</th>
<th>삭제</th>
</tr>
</table>
<h1>스케줄러관리</h1>
<button onclick = "start()">스케쥴러(20초마다 포인트1증가) 실행시작</button>
<button onclick = "stop()">스케줄러 실행 중지</button>
<script>
	function start(){
		location.href="start";
	}
	function stop(){
		location.href = "stop";
	}
</script>
</body>
</html>