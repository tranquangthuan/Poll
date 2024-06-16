<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="#">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/poll">Tạo khảo sát</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/polls">List khảo sát</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/poll-executes">List
					người dùng thực hiện khảo sát</a></li>
		</ul>
	</nav>
</body>
</html>