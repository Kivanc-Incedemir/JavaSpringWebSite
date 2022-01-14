package com.kivanc.spring.service;

import com.kivanc.spring.entity.User;
import com.kivanc.spring.user.CrmUser;

import com.kivanc.spring.user.VM.CrmUserVM;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);

	public void update(CrmUserVM crmUservm);

	List<GrantedAuthority> getAuthority(String role);
}
