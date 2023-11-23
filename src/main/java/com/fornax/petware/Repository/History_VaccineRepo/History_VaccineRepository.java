package com.fornax.petware.Repository.History_VaccineRepo;

import com.fornax.petware.Entity.History_VaccinePackage.History_Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface History_VaccineRepository extends JpaRepository<History_Vaccine, Long> {
}
