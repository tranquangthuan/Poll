package com.fsoft.ctc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fsoft.ctc.entity.Answer;
import com.fsoft.ctc.util.HibernateUtils;

public class AnswerRepository {

	public Answer get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Answer answer = session.get(Answer.class, id);
		session.close();
		return answer;
	}

}
