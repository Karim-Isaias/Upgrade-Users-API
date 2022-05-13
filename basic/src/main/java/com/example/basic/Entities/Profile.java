package com.example.basic.Entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "tbl_profiles")


public class Profile extends Base {
	/*
	@Column(name = "idprofile")
	private int idprofile;
	*/
	@Column(name = "profile")
	private String profile;
}
