<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Poll</title>
<script>
	let questionCount = 1;

	function addAnswer(questionId) {
		const table = document.getElementById(questionId);
		const newRow = table.insertRow(-1);
		const cell1 = newRow.insertCell(0);
		const cell2 = newRow.insertCell(1);
		cell1.innerHTML = "Answer";
		cell2.innerHTML = '<input type="text" name="answers'+ questionCount + '"/>';
	}

	function addQuestion() {
		questionCount++;
		const questionDiv = document.getElementById("questionDiv");

		const newTable = document.createElement("table");
		newTable.setAttribute("class", "table table-bordered");

		newTable.id = "question" + questionCount;

		const questionRow = newTable.insertRow(0);
		const cell1 = questionRow.insertCell(0);
		const cell2 = questionRow.insertCell(1);
		cell1.innerHTML = "Question";
		cell2.innerHTML = '<input type="text" name="questions"/>';

		const answerRow = newTable.insertRow(1);
		const cell3 = answerRow.insertCell(0);
		const cell4 = answerRow.insertCell(1);
		const cell5 = answerRow.insertCell(2);
		cell3.innerHTML = "Answer";
		cell4.innerHTML = '<input type="text" name="answers'+ questionCount + '"/>';
		cell5.innerHTML = '<button type="button" onclick="addAnswer(\'question'
				+ questionCount + '\')">Add Answer</button>';

		questionDiv.appendChild(newTable);

		const br = document.createElement("br");
		questionDiv.appendChild(br);
	}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div align="center">
		<form id="pollForm" action="poll" method="post">
			<div>
				<table class="table table-bordered">
					<tr>
						<td>Tên cuộc khảo sát</td>
						<td colspan="2"><input type="text" name="poll" /></td>
					</tr>
				</table>
			</div>
			<div id="questionDiv">
				<table id="question1" class="table table-bordered">
					<tr>
						<td>Question</td>
						<td><input typqe="text" name="questions" /></td>
					</tr>
					<tr>
						<td>Answer</td>
						<td><input type="text" name="answers1" /></td>
						<td><button type="button" onclick="addAnswer('question1')">Add Thêm câu trả lời</button></td>
					</tr>
				</table>
				</br>
			</div>
			<div>
				<button type="button" onclick="addQuestion()">Add Thêm câu hỏi</button>
			</div>
			</br>
			<div>
				<input type="submit" value="Tạo cuộc khảo sát" />
			</div>
		</form>
	</div>
</body>
</html>