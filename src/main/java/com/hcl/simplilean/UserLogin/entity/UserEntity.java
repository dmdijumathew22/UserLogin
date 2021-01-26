package com.hcl.simplilean.UserLogin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import com.hcl.simplilean.UserLogin.hibernate.HibernateUtils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Table(name = "User")
@Entity
@Getter @Setter
@ToString
public class UserEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Session hibernateSession;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	
	@Column(name = "user_id",unique=true)
	@NonNull
	private String userid;
	
	@Column(name = "first_name")
	@NonNull
	private String firstName;
	
	@Column(name = "last_name")
	@NonNull
	private String lastName;
	
	@Column(name = "pwd")
	@NonNull
	private String pwd;
	
	@Column(name = "email",unique=true)
	@NonNull
	private String email;
	
	public static UserEntity find(String userid) {
		hibernateSession = HibernateUtils.buildSessionFactory().openSession();
    	hibernateSession.beginTransaction();
    	UserEntity u = (UserEntity) hibernateSession.
    					createQuery("FROM UserEntity  U WHERE U.userid= :userid").
    					setParameter("userid",userid).uniqueResult();
    	hibernateSession.getTransaction().commit();
    	hibernateSession.close();
		
		return u;
		
	}
	
	public static boolean validate(String userid, String pwd) {
		
    	UserEntity u = UserEntity.find(userid);
    	if (u!=null) {
    		if (u.getPwd().equals(pwd)) {
    			return true;
    		}
    			
    	}
    	
		
		return false;
		
	}

}
