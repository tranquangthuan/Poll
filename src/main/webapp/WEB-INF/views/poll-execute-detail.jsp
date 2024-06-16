<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="UTF-8">
<title>Poll Detail</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div align="center">
		<h1>Màn hình kết quả chi tiết khảo sát</h1>
	</div>
	<div align="center">
		<div>
			<table class="table table-bordered">
				<tr>
					<td>Tên khảo sát</td>
					<td>${userPoll.poll.content }</td>
				</tr>
				<tr>
					<td>Người thực hiện khảo sát</td>
					<td>${userPoll.userName }</td>
				</tr>
			</table>
		</div>
		<div id="questionDiv" align="left">
			<c:forEach var="userPollDetail" items="${userPoll.userPollDetails}"
				varStatus="loopQuestion">
				<table id="question${loopQuestion.index + 1 }"
					class="table table-bordered">
					<tr>
						<td>Question</td>
						<td>${userPollDetail.question.content }</td>
					</tr>
					<tr>
						<td>Your Answer</td>
						<td><c:forEach var="answer"
								items="${userPollDetail.question.answers}">
								<input class="form-check-input" type="radio"
									name="yourAnswer${loopQuestion.index + 1 }"
									value="${answer.id }"
									<c:if test="${answer.id == userPollDetail.answer.id}">checked</c:if>
									disabled />&nbsp;${answer.content } &nbsp;&nbsp;
								</c:forEach></td>
					</tr>
				</table>
			</c:forEach>
		</div>
		<div>
			<a href="poll-executes" class="btn btn-primary">Back về List người dùng thực
				hiện khảo sát</a>
		</div>
	</div>
</body>
</html>