package com.fornax.petware.Repository.Disease_RegistryRepo;

import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Disease_RegistryRepository extends JpaRepository<Disease_Registry, Long> {
}
