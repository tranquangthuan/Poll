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
import com.fsoft.ctc.entity.UserPoll;
import com.fsoft.ctc.entity.UserPollDetail;
import com.fsoft.ctc.repository.AnswerRepository;
import com.fsoft.ctc.repository.PollRepository;
import com.fsoft.ctc.repository.QuestionRepository;
import com.fsoft.ctc.repository.UserPollRepository;

@WebServlet(value = "/poll-execute")
public class PollExecuteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pollId = req.getParameter("poll_id");
		int id = Integer.parseInt(pollId);
		PollRepository pollRepository = new PollRepository();
		Poll poll = pollRepository.get(id);
		req.setAttribute("poll", poll);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/poll-execute.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userNameParam = req.getParameter("userName");
		String pollIdParam = req.getParameter("pollId");
		String[] questionIdsParam = req.getParameterValues("questionIds");
		int index = 1;

		PollRepository pollRepository = new PollRepository();
		Poll poll = pollRepository.get(Integer.parseInt(pollIdParam));
		UserPoll userPoll = new UserPoll(userNameParam, poll);
		QuestionRepository questionRepository = new QuestionRepository();
		AnswerRepository answerRepository = new AnswerRepository();

		List<UserPollDetail> userPollDetails = new ArrayList<UserPollDetail>();
		try {
			for (String questionId : questionIdsParam) {
				String yourAnswerid = req.getParameter("yourAnswer".concat(String.valueOf(index)));
				Question question = questionRepository.get(Integer.parseInt(questionId));
				Answer answer = answerRepository.get(Integer.parseInt(yourAnswerid));

				UserPollDetail userPollDetail = new UserPollDetail(userPoll, question, answer);
				userPollDetails.add(userPollDetail);
				index++;
			}

			// Add to DB
			userPoll.setUserPollDetails(userPollDetails);
			UserPollRepository userPollRepository = new UserPollRepository();
			userPollRepository.saveOrUpdate(userPoll);
			resp.sendRedirect("poll-executes");
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
