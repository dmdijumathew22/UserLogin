package com.hcl.simplilean.UserLogin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Table(name = "User")
@Entity
@Data
public class UserEntity implements Serializable{
	
	/** Entity Class.
	 * getters and setters generated using project lombok //@Data annotation
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
	
	@Column(name = "user_id",unique=true)
	
	private String userid;
	
	@Column(name = "first_name")
	
	private String firstName;
	
	@Column(name = "last_name")
	
	private String lastName;
	
	@Column(name = "pwd")
	
	private String pwd;
	
	@Column(name = "email",unique=true)
	
	private String email;
	
	
	

}
