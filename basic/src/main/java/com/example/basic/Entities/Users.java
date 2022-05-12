package com.example.basic.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
	
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "tbl_users")
public class Users extends Base {
	@Column(name = "iduser ")
	private int iduser;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private int password;
	@Column(name = "idprofile")
	private String idprofile;
	@Column(name = "idemployee")
	private int idemployee;
	@Column(name = "status")
	private String status;
	@Column(name = "createddate")
	private String createddate;
	@Column(name = "updatedate")
	private String updatedate;
	@Column(name = "login")
	private String login;
}