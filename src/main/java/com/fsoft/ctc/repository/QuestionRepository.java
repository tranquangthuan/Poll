package com.fsoft.ctc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fsoft.ctc.entity.Question;
import com.fsoft.ctc.util.HibernateUtils;

public class QuestionRepository {

	public Question get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Question question = session.get(Question.class, id);
		session.close();
		return question;
	}

}
