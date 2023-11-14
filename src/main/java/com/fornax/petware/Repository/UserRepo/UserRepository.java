package com.fornax.petware.Repository.UserRepo;

import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select U from User U where U.email = :userEmail")
    User findByEmail(@Param("userEmail") String userEmail);


}
