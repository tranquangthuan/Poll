package com.fsoft.ctc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.ctc.entity.UserPoll;
import com.fsoft.ctc.repository.UserPollRepository;

@WebServlet(value = "/poll-execute-detail")
public class PollExecuteDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userPollId = req.getParameter("user_poll_id");
		int id = Integer.parseInt(userPollId);
		UserPollRepository userPollRepository = new UserPollRepository();
		UserPoll userPoll = userPollRepository.get(id);
		req.setAttribute("userPoll", userPoll);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/poll-execute-detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
