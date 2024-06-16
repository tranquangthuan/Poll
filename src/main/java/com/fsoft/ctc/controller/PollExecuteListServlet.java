package com.fsoft.ctc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.ctc.entity.UserPoll;
import com.fsoft.ctc.repository.UserPollRepository;

@WebServlet(value = "/poll-executes")
public class PollExecuteListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserPollRepository userPoll = new UserPollRepository();
		List<UserPoll> userPolls = userPoll.getUserPolls();
		req.setAttribute("userPolls", userPolls);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/poll-executes.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
