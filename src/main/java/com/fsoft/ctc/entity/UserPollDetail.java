package com.fsoft.ctc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserPollDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_poll_id", referencedColumnName = "id")
	private UserPoll userPoll;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private Question question;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_id", referencedColumnName = "id")
	private Answer answer;

	public UserPollDetail() {
		super();
	}

	public UserPollDetail(UserPoll userPoll, Question question, Answer answer) {
		super();
		this.userPoll = userPoll;
		this.question = question;
		this.answer = answer;
	}

	public UserPollDetail(int id, UserPoll userPoll, Question question, Answer answer) {
		super();
		this.id = id;
		this.userPoll = userPoll;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserPoll getUserPoll() {
		return userPoll;
	}

	public void setUserPoll(UserPoll userPoll) {
		this.userPoll = userPoll;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
