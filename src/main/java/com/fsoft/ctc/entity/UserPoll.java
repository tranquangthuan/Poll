package com.fsoft.ctc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserPoll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "nvarchar(255)")
	private String userName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poll_id", referencedColumnName = "id")
	private Poll poll;

	@OneToMany(mappedBy = "userPoll", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserPollDetail> userPollDetails;

	public UserPoll() {
		super();
	}

	public UserPoll(String userName) {
		super();
		this.userName = userName;
	}

	public UserPoll(String userName, Poll poll) {
		super();
		this.userName = userName;
		this.poll = poll;
	}

	public UserPoll(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public List<UserPollDetail> getUserPollDetails() {
		return userPollDetails;
	}

	public void setUserPollDetails(List<UserPollDetail> userPollDetails) {
		this.userPollDetails = userPollDetails;
	}

}
