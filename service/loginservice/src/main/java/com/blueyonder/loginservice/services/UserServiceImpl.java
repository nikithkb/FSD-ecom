package com.blueyonder.loginservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.blueyonder.loginservice.entities.User;
import com.blueyonder.loginservice.exceptions.UserNotFoundException;
import com.blueyonder.loginservice.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        Assert.hasText(username, "Username must not be empty");
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(String username) {
        Assert.hasText(username, "Username must not be empty");
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new UserNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public void updateUser(User user) {
        Assert.notNull(user, "User must not be null");
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // Update the existing user with the new details
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setAdmin(user.isAdmin());
            userRepository.save(existingUser);
        } else {
            throw new UserNotFoundException("User not found with username: " + user.getUsername());
        }
    }
}
