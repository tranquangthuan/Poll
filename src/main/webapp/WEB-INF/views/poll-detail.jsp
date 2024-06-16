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
		<h1>Màn hình nội dung chi tiết khảo sát</h1>
	</div>
	<div align="center">
		<form id="pollForm" action="polls" method="get">
			<div>
				<table class="table table-bordered">
					<tr>
						<td>Tên cuộc khảo sát</td>
						<td>${poll.content }<input type="hidden" name="pollId"
							value="${poll.id }" />
						</td>
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
							<td>${question.content }
						</tr>
						<c:forEach var="answer" items="${question.answers}">
							<tr>
								<td>Answer</td>
								<td>${answer.content }</td>
							</tr>
						</c:forEach>
					</table>
				</c:forEach>
			</div>
			<div>
				<input type="submit" value="Back To List" />
			</div>
		</form>
	</div>
</body>
</html>