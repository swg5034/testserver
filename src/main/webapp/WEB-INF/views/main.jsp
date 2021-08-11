<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% String id = (String)(session.getAttribute("loginId")); %>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
${point }
	<div style = "display : flex; justify-content: space-between;">
		<div><h1>메인페이지</h1></div>
		<div>
			<div>
			${dto.name }(<%=id %>)님 안녕하세요.
			<button>로그아웃</button>
			</div>
			<div>
			포인트 :${dto.point }점
			</div>
		</div>
	</div>
	<h3>구입할 컨텐츠를 선택하세요</h3>
	<div style = "display : flex; justify-content: space-between;">
		<div style = "cursor: pointer;" onclick = "point10()">
			<img src = "resources/img/Cpp_350_408.png"/>
			<div style = "text-align: center;">100000point</div>
		</div>
		<div  style = "cursor: pointer;" onclick = "point50()">
			<img src = "resources/img/Intro_350_408.png"/>
			<div style = "text-align: center;">500000point</div>
		</div>
		<div  style = "cursor: pointer;" onclick = "point30()">
			<img src = "resources/img/Java_350_408.png"/>
			<div style = "text-align: center;">300000point</div>
		</div>
	</div>
	<div style = "cursor: pointer; display : flex; justify-content : flex-end; margin-top : 20px;"onclick = "point1000()">
		<img src = "resources/img/korea_it.png"/>
	</div>
	<script>
		function point10(){
			location.href = "point10?point=" + ${dto.point};
		}
		function point30(){
			location.href = "point30?point=" + ${dto.point};
		}
		function point50(){
			location.href = "point50?point=" + ${dto.point};
		}
		function point1000(){
			alert("1000점이 적립되엇습니다");
			location.href = "point1000";
		}
	</script>
</body>
</html>