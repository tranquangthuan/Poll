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
		<h1>Danh sách các cuộc khảo sát</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>Id</td>
					<td>Tên Khảo Sát</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="poll" items="${polls}" varStatus="loop">
					<tr>
						<td><a href="poll-detail?poll_id=${ poll.id}">${poll.id}</a></td>
						<td><a href="poll-detail?poll_id=${ poll.id}">${poll.content}</a></td>
						<td><a href="poll-detail?poll_id=${ poll.id}"
							class="btn btn-primary">View Chi tiết khảo sát</a> <a
							href="poll-execute?poll_id=${ poll.id}" class="btn btn-success">Thực hiện khảo sát này</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>