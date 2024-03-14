package com.blueyonder.loginservice.services;

import org.springframework.stereotype.Service;

import com.blueyonder.loginservice.entities.User;

@Service
public interface UserService {
    public void registerUser(User user);
    public User getUser(String username);
    public void deleteUser(String username);
    public void updateUser(User user);
}
