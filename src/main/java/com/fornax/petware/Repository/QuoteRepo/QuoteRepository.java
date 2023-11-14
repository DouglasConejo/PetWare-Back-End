package com.fornax.petware.Repository.QuoteRepo;

import com.fornax.petware.Entity.QuotePackage.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuoteRepository  extends JpaRepository<Quote, Long> {

    @Query("SELECT q.reason, q.call, q.date FROM Quote q")
    List<Object[]> findQuoteData();

    @Query("SELECT q.reason, q.call, q.date " +
            "FROM Quote q " +
            "WHERE q.quotes.id = :userId")
    List<Object[]> findQuotesByUser(@Param("userId") Long userId);



}

