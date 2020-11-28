package com.mscourse.hruser.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roleName;
	
	public Role() {}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}
}
