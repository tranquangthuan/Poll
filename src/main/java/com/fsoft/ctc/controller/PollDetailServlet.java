package com.fsoft.ctc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.ctc.entity.Poll;
import com.fsoft.ctc.repository.PollRepository;

@WebServlet(value = "/poll-detail")
public class PollDetailServlet extends HttpServlet {

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/poll-detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
