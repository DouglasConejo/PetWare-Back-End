package com.fornax.petware.Controller.QuoteController;

import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Repository.QuoteRepo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class QuoteController {
    @Autowired
    QuoteRepository quoteRepository;


    @GetMapping("Quotes")
    public List<Quote> getAllPet() {
        return quoteRepository.findAll();
    }

    @GetMapping("/users/{userId}/quotes")
    public List<Object[]> getUserQuotes(@PathVariable Long userId) {
        return quoteRepository.findQuotesByUser(userId);

    }

    @GetMapping("quote/{id}")
    public Optional<Quote> getPet(@PathVariable(value = "id") Long id) {
        return quoteRepository.findById(id);
    }

    @PostMapping("quote")
    public Quote addPet(@RequestBody Quote quote) {
        return quoteRepository.save(quote);
    }

    @DeleteMapping("/quote/{id}")
    public ResponseEntity<?> deleteQuote(@PathVariable(value = "id") Long id) {
        quoteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
