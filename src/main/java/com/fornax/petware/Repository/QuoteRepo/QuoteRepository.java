package com.fornax.petware.Repository.QuoteRepo;

import com.fornax.petware.Entity.QuotePackage.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository  extends JpaRepository<Quote, Long> {
}
