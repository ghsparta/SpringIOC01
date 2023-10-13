package com.demo.service;

import com.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final User user;

    public UserService(User user) {
        this.user = user;
    }

    public void displayUser() {
        System.out.println("User Name: " + user.getName());
    }
}
