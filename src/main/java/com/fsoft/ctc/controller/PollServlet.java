package com.fsoft.ctc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.ctc.entity.Answer;
import com.fsoft.ctc.entity.Poll;
import com.fsoft.ctc.entity.Question;
import com.fsoft.ctc.repository.PollRepository;

@WebServlet(value = "/poll")
public class PollServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/poll.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pollParam = req.getParameter("poll");
		String[] questionsParam = req.getParameterValues("questions");
		int index = 1;
		Poll poll = new Poll(pollParam);
		List<Question> questions = new ArrayList<Question>();
		for (String questionParam : questionsParam) {
			Question question = new Question(questionParam);
			List<Answer> answers = new ArrayList<Answer>();
			String[] answerParam = req.getParameterValues("answers".concat(String.valueOf(index)));
			for (String anString : answerParam) {
				Answer answer = new Answer(anString);
				answer.setQuestion(question);
				answers.add(answer);
			}
			question.setAnswers(answers);
			question.setPoll(poll);
			questions.add(question);
			index++;
		}
		poll.setQuestions(questions);

		// Add to DB
		PollRepository pollRepository = new PollRepository();
		pollRepository.saveOrUpdate(poll);
		resp.sendRedirect("polls");
	}

}
