package com.fornax.petware.Repository.Pet_HistoryRepo;
import com.fornax.petware.Entity.Pet_History.PetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Pet_HistoryRepository extends JpaRepository<PetHistory, Long> {

    @Query("SELECT ph.height, ph.temperature, ph.date, ph.weight " +
            "FROM PetHistory ph " +
            "WHERE ph.petHistory.id = :petId")
    List<Object[]>  findByPetId(@Param("petId") Long petId);

}
