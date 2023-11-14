package com.fornax.petware.Controller.UserContro;

import com.fornax.petware.Entity.UserPackage.Role;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Repository.UserRepo.UserRepository;
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

        Optional<User> user = userRepository.findById(id);

        user.get().setEmail(perfilUpdate.getEmail());
        user.get().setName(perfilUpdate.getName());
        user.get().setPassword(user.get().getPassword());
        user.get().setPhone(user.get().getPassword());

        User updatedUser = userRepository.save(user.get());
        return ResponseEntity.ok(updatedUser);
    }
}
