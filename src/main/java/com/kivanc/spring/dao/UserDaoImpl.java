package com.kivanc.spring.dao;

import com.kivanc.spring.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public User findByEmail(String email) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("FROM User WHERE email=:eMail");
		theQuery.setParameter("eMail",email);

		User theUser = null;

		try{
			theUser = theQuery.getSingleResult();
		} catch (Exception e){
			theUser = null;
		}
		return theUser;
	}

	@Override
	public User findByResetPasswordToken(String token) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("FROM User WHERE reset_password_token =:token");
		theQuery.setParameter("token",token);

		User theUser = null;

		try{
			theUser = theQuery.getSingleResult();
		} catch (Exception e){
			theUser = null;
		}
		return theUser;
	}


}
