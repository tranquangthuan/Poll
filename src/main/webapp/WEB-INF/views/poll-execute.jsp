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
		<h1>Màn hình thực hiện khảo sát</h1>
	</div>
	<div align="center">
		<form id="pollForm" action="poll-execute" method="post">
			<div>
				<table class="table table-bordered">
					<tr>
						<td>Tên cuộc khảo sát</td>
						<td>${poll.content }<input type="hidden" name="pollId"
							value="${poll.id }" />
						</td>
					</tr>
					<tr>
						<td>Nhập tên người thực hiện khảo sát</td>
						<td><input type="text" name="userName" size="50" /></td>
					</tr>
				</table>
			</div>
			<div id="questionDiv" align="left">
				<c:forEach var="question" items="${poll.questions}"
					varStatus="loopQuestion">
					<table id="question${loopQuestion.index + 1 }"
						class="table table-bordered">
						<tr>
							<td>Question</td>
							<td>${question.content }<input type="hidden"
								name="questionIds" value="${question.id}">
							</td>
						</tr>
						<tr>
							<td>Your Answer</td>
							<td><c:forEach var="answer" items="${question.answers}">
									<input type="radio" name="yourAnswer${loopQuestion.index + 1 }"
										value="${answer.id }" />&nbsp;${answer.content } &nbsp;&nbsp;
								</c:forEach></td>
						</tr>
					</table>
				</c:forEach>
			</div>
			<div>
				<input type="submit" value="Thực hiện" />
			</div>
		</form>
	</div>
</body>
</html>