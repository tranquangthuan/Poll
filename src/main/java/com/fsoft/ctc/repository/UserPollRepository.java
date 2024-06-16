package com.fsoft.ctc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fsoft.ctc.entity.Poll;
import com.fsoft.ctc.entity.UserPoll;
import com.fsoft.ctc.util.HibernateUtils;

public class UserPollRepository {

	public void delete(UserPoll Poll) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.delete(Poll.class);
		t.commit();
		session.close();
	}

	public UserPoll get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		UserPoll userPoll = session.get(UserPoll.class, id);
		session.close();
		return userPoll;
	}

	public List<UserPoll> getUserPolls() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM UserPoll";
		Query<UserPoll> query = session.createQuery(hql, UserPoll.class);
		List<UserPoll> Polls = query.getResultList();
		session.close();
		return Polls;
	}

	public void saveOrUpdate(UserPoll Poll) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(Poll);
		t.commit();
		session.close();
	}
}
