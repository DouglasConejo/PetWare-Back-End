package com.fornax.petware.Controller.UserContro;

import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Repository.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("user")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
