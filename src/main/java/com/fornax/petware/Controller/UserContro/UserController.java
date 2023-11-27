package com.fornax.petware.Controller.UserContro;

import com.fornax.petware.Entity.UserPackage.Role;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Repository.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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

    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
                                           @RequestBody User perfilUpdate) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Validación de campos
            if (perfilUpdate.getEmail() != null && !perfilUpdate.getEmail().isEmpty()) {
                user.setEmail(perfilUpdate.getEmail());
            }

            if (perfilUpdate.getName() != null) {
                user.setName(perfilUpdate.getName());
            }

            if (perfilUpdate.getPassword() != null) {
                user.setPassword(perfilUpdate.getPassword());
            }

            if (perfilUpdate.getPhone() != null) {
                user.setPhone(perfilUpdate.getPhone());
            }

            if (perfilUpdate.getRole() != null) {
                user.setRole(perfilUpdate.getRole());
            }

            // Guardar el usuario actualizado
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }

    }



}
