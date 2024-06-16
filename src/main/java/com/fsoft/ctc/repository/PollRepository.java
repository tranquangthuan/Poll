package com.fsoft.ctc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fsoft.ctc.entity.Poll;
import com.fsoft.ctc.util.HibernateUtils;

public class PollRepository {

	public void delete(Poll Poll) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.delete(Poll.class);
		t.commit();
		session.close();
	}

	public Poll get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Poll poll = session.get(Poll.class, id);
		session.close();
		return poll;
	}

	public List<Poll> getPolls() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Poll";
		Query<Poll> query = session.createQuery(hql, Poll.class);
		List<Poll> Polls = query.getResultList();
		session.close();
		return Polls;
	}

	public void saveOrUpdate(Poll Poll) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(Poll);
		t.commit();
		session.close();
	}
}
