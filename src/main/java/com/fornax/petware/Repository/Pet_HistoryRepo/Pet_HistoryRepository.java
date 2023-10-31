package com.fornax.petware.Repository.Pet_HistoryRepo;
import com.fornax.petware.Entity.Pet_History.PetHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pet_HistoryRepository extends JpaRepository<PetHistory, Long> {
}
