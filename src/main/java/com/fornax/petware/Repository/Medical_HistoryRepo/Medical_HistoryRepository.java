package com.fornax.petware.Repository.Medical_HistoryRepo;

import com.fornax.petware.Entity.Medical_HistoryPackage.Medical_History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Medical_HistoryRepository extends JpaRepository<Medical_History, Long> {
}
