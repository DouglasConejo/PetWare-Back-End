package com.fornax.petware.Repository.VaccineRepo;

import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
