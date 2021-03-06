package com.kivanc.spring.service;

import com.kivanc.spring.dao.RoleDao;
import com.kivanc.spring.dao.UserDao;
import com.kivanc.spring.entity.Role;
import com.kivanc.spring.entity.User;
import com.kivanc.spring.user.CrmUser;
import com.kivanc.spring.user.VM.CrmUserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());

		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

		 // save user in the database
		userDao.save(user);
	}

	@Override
	@Transactional
	public void update(CrmUserVM crmUserVM) {
		User user = userDao.findByUserName(crmUserVM.getUserName());
		// assign user details to the user object
		user.setFirstName(crmUserVM.getFirstName());
		user.setLastName(crmUserVM.getLastName());

		// save user in the database
		userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<GrantedAuthority> getAuthority(String role) {
		return Collections.singletonList(new SimpleGrantedAuthority(role));
	}

	@Override
	@Transactional
	public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException{
	User theUser = userDao.findByEmail(email);
	if(theUser != null){
		theUser.setResetPasswordToken(token);
		userDao.save(theUser);
	} else{
		throw new UsernameNotFoundException("Could not found any user with the email" + email);
	}
	}

	@Override
	@Transactional
	public User getByResetPasswordToken(String token){
		return userDao.findByResetPasswordToken(token);
	}

	@Override
	@Transactional
	public void updatePassword(User theUser, String newPassword){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		theUser.setPassword(encodedPassword);

		theUser.setResetPasswordToken(null);
		userDao.save(theUser);
	}

}
