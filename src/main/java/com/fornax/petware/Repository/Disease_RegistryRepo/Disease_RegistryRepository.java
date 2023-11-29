package com.fornax.petware.Repository.Disease_RegistryRepo;

import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Disease_RegistryRepository extends JpaRepository<Disease_Registry, Long> {

}
