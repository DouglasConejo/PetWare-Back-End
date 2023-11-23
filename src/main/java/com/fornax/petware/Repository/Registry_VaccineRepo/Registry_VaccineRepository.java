package com.fornax.petware.Repository.Registry_VaccineRepo;

import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Registry_VaccineRepository extends JpaRepository<Vaccine_Registry, Long> {
}
