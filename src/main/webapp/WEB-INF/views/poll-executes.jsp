<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp"%>

	<div align="center">
		<h1>Danh sách người dùng đã thực hiện khảo sát</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Id</td>
					<td>User Name</td>
					<td>Poll Name</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="userPoll" items="${userPolls}" varStatus="loop">
					<tr>
						<td>${userPoll.id}</a></td>
						<td>${userPoll.userName}</a></td>
						<td>${userPoll.poll.content}</a></td>
						<td><a href="poll-execute-detail?user_poll_id=${userPoll.id}"
							class="btn btn-primary">View Details</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>