package com.fsoft.ctc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Poll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "nvarchar(1000)")
	private String content;

	@OneToMany(mappedBy = "poll", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Question> questions;
	
	@OneToMany(mappedBy = "poll", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<UserPoll> userPolls;

	public Poll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poll(String content) {
		super();
		this.content = content;
	}

	public Poll(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Poll(String content, List<Question> questions) {
		super();
		this.content = content;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", content=" + content + "]";
	}

}
