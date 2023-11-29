package com.fornax.petware.Repository.Registry_VaccineRepo;

import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Registry_VaccineRepository extends JpaRepository<Vaccine_Registry, Long> {

    @Query("SELECT vr.description, vr.recovery_date, v.name " +
            "FROM Vaccine_Registry vr " +
            "JOIN vr.vaccine v " )
    List<String[]> listPrincipalData();

}
