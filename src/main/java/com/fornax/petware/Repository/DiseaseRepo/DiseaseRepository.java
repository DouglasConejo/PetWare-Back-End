package com.fornax.petware.Repository.DiseaseRepo;

import com.fornax.petware.Entity.DiseasePackage.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
