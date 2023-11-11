package com.fornax.petware.Repository.UserRepo;

import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
