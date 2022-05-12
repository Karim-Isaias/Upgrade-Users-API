package com.example.basic.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
	
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "tbl_profiles")
public class Profile extends Base {
	@Column(name = "idprofile")
	private int idprofile;
	@Column(name = "profile")
	private String profile;
}
