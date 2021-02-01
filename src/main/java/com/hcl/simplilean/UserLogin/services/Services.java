package com.hcl.simplilean.UserLogin.services;

import org.hibernate.Session;

import com.hcl.simplilean.UserLogin.entity.UserEntity;
import com.hcl.simplilean.UserLogin.hibernate.HibernateUtils;

public class Services {
	public static Session hibernateSession;

	// Function to Search Database for existing elements with given userid
	public static UserEntity find(String userid) {
		hibernateSession = HibernateUtils.buildSessionFactory().openSession();
		hibernateSession.beginTransaction();
		
		//Hibernate query using entity parameters class to map to the database
		UserEntity u = (UserEntity) hibernateSession.createQuery("FROM UserEntity  U WHERE U.userid= :userid")
				.setParameter("userid", userid).uniqueResult();
		
		//returns User information UserEntity
		return u;

	}

	
	//Validates the userid and password given by the user
	public static boolean validate(String userid, String pwd) {

		UserEntity u = Services.find(userid);
		if (u != null) {
			
			// comparison btw password from DB and User
			if (u.getPwd().equals(pwd)) {
				return true;
			}

		}

		return false;

	}

	// Saves UserEntity read from user to Database
	public static void save(UserEntity U) {
		hibernateSession.saveOrUpdate(U);
		hibernateSession.getTransaction().commit();

	}

}
