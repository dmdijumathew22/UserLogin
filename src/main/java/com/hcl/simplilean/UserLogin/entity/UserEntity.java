package com.hcl.simplilean.UserLogin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	

}
