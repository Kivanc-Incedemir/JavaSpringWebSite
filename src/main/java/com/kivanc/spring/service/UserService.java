package com.kivanc.spring.service;

import com.kivanc.spring.entity.User;
import com.kivanc.spring.user.CrmUser;

import com.kivanc.spring.user.VM.CrmUserVM;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);

	public void update(CrmUserVM crmUservm);
}
