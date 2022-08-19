package com.baranbatur.ftTechnology.service;

import com.baranbatur.ftTechnology.model.User;
import com.baranbatur.ftTechnology.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByNameOrEmail(username, email);
    }


}
