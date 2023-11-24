package com.fornax.petware.Controller.UserContro;

import com.fornax.petware.Entity.UserPackage.Role;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Repository.UserRepo.UserRepository;
import com.fornax.petware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;
    @PostMapping("/add-user")
    public User submitUser(@RequestBody User newUser){
        User user = userService.adduser(newUser);
        return user;
    }

    @GetMapping("all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("user/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable(value = "email") String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));

        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> findUserByEmail2(@PathVariable String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value = "user", consumes = {"application/json"})
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User perfilUpdate) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(perfilUpdate.getEmail());
            user.setName(perfilUpdate.getName());
            user.setPassword(perfilUpdate.getPassword());
            user.setPhone(perfilUpdate.getPhone());
            user.setRole(perfilUpdate.getRole());

            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
