package com.example.demo2.service.impl;

import com.example.demo2.entity.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {

    }
}
