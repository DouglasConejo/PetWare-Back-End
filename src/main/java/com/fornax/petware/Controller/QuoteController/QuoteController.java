package com.fornax.petware.Controller.QuoteController;

import com.fornax.petware.Entity.AnimalPackage.PetResponse;
import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Entity.QuotePackage.QuoteDTO;
import com.fornax.petware.Repository.QuoteRepo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class QuoteController {
    @Autowired
    QuoteRepository quoteRepository;


    @GetMapping("Quotes")
    public List<Quote> getAllPet() {
        return quoteRepository.findAll();
    }

    //citas con sus especificaciones y mascotas
    @GetMapping("/users/{userId}/quotes")
    public List<QuoteDTO> getUserQuotes(@PathVariable Long userId) {

        List<Object[]> rawQuotes = quoteRepository.findQuotesByUser(userId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm ");

        List<QuoteDTO> quotes = rawQuotes.stream()
                .map(result -> {

                    Timestamp timestamp = (Timestamp) result[2];
                    Long timestampMillis = null;

                    if(timestamp != null) {
                        timestampMillis = timestamp.getTime();
                    }

                    String date = "";
                    if(timestampMillis != null) {
                        date = dateFormat.format(new Date(timestampMillis));
                    }

                    String location = (String) result[1];
                    String reason = (String) result[0];
                    String petName = (String) result[3];
                    String petType = (String) result[4];
                    String petRace = (String) result[5];

                    QuoteDTO quote = new QuoteDTO();
                    quote.setDate(date);
                    quote.setPet(new PetResponse(petName, petType, petRace));
                    quote.setLocation(location);
                    quote.setReason(reason);
                    quote.setId_user(userId);

                    return quote;

                })
                .collect(Collectors.toList());

        return quotes;
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
