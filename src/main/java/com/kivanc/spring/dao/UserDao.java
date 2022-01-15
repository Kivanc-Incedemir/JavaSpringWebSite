package com.kivanc.spring.dao;

import com.kivanc.spring.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);

    public User findByEmail(String email);

    public User findByResetPasswordToken(String token);
}
