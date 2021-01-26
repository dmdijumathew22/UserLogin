package com.hcl.simplilean.UserLogin;

import org.hibernate.Session;
import com.hcl.simplilean.UserLogin.entity.UserEntity;
import com.hcl.simplilean.UserLogin.hibernate.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{ static Session hibernateSession;

    public static void main( String[] args )
    {
    	
   
        System.out.println( "Hello World!" );
        
       UserEntity u =new UserEntity();
//        for (int i=0; i<10;i++) {
//        	hibernateSession = HibernateUtils.buildSessionFactory().openSession();
//        	hibernateSession.beginTransaction();
//        	u.setEmail("user"+i+".email.com");
//        	u.setUserid("user"+i);
//        	u.setFirstName("user first name" +i);
//        	u.setLastName("user last name" +i);
//        	u.setPwd("passworduser"+i);
//        	hibernateSession.save(u);
//            hibernateSession.getTransaction().commit();
//        }
        hibernateSession = HibernateUtils.buildSessionFactory().openSession();
    	hibernateSession.beginTransaction();
    	u=(UserEntity) hibernateSession.createQuery("FROM UserEntity  U WHERE U.userid= :userid").setParameter("userid","user0").uniqueResult();
    	  hibernateSession.getTransaction().commit();
    	hibernateSession.close();
     System.out.println(u.toString());
    }
}
