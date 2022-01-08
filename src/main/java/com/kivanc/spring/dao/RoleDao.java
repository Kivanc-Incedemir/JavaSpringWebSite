package com.kivanc.spring.dao;

import com.kivanc.spring.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
