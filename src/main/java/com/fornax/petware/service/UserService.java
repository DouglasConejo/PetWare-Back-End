package com.fornax.petware.service;

import com.fornax.petware.Entity.UserPackage.Role;
import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> userStringData;

    public UserService(){
        userStringData = new LinkedList<>();
    }

    public User adduser(User user){
        user.setId(1L);
        user.setName("Daniel");
        user.setPassword("Test123");
        user.setEmail("Test@gmail.com");
        user.setPhone("12239882");
        this.userStringData.add(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userStringData;
    }

}
