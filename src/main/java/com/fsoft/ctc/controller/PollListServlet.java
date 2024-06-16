package com.fsoft.ctc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.ctc.entity.Poll;
import com.fsoft.ctc.repository.PollRepository;

@WebServlet(value = "/polls")
public class PollListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PollRepository pollRepository = new PollRepository();
		List<Poll> polls = pollRepository.getPolls();
		req.setAttribute("polls", polls);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/polls.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
