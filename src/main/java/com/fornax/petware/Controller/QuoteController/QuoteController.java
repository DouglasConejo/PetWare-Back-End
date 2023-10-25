package com.fornax.petware.Controller.QuoteController;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Repository.QuoteRepo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuoteController {
    @Autowired
    QuoteRepository quoteRepository;


    @GetMapping("Quotes")
    public List<Quote> getAllPet() {
        return quoteRepository.findAll();
    }

    @GetMapping("quote/{id}")
    public Optional<Quote> getPet(@PathVariable(value = "id") Long id) {
        return quoteRepository.findById(id);
    }

    @PostMapping("quote")
    public Quote addPet(@RequestBody Quote quote) {
        return quoteRepository.save(quote);
    }
}
