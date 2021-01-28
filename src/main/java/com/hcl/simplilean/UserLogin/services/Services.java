package com.hcl.simplilean.UserLogin.services;

import org.hibernate.Session;

import com.hcl.simplilean.UserLogin.entity.UserEntity;
import com.hcl.simplilean.UserLogin.hibernate.HibernateUtils;

public class Services {
	public static Session hibernateSession;

		

	
	public static UserEntity find(String userid) {
		hibernateSession = HibernateUtils.buildSessionFactory().openSession();
    	hibernateSession.beginTransaction();
		
    	UserEntity u = (UserEntity) hibernateSession.
    					createQuery("FROM UserEntity  U WHERE U.userid= :userid").
    					setParameter("userid",userid).uniqueResult();
    	
		
		return u;
		
	}

	public static boolean validate(String userid, String pwd) {
		
    	UserEntity u = Services.find(userid);
    	if (u!=null) {
    		if (u.getPwd().equals(pwd)) {
    			return true;
    		}
    			
    	}
    	
		
		return false;
		
	}
	public static void save (UserEntity U) {
		hibernateSession.save(U);
		hibernateSession.getTransaction().commit();
    		
	}

}
