package com.fornax.petware.service;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service

public class QuoteService {

    private List<Disease_Registry> quoteStringData;

    private List<String> quotesStringData;

    public QuoteService(){
        quoteStringData = new LinkedList<>();
    }

    public Quote addQuote(Quote quote) throws ParseException {
        quote.setId(1);
        quote.setReason("Perro Cita");
        quote.setLocation("Alajuela ");

        // Crear una instancia de Pet
        Pet pet = new Pet();
        pet.setId(1); // Asignar el ID de la enfermedad
        quote.setQuotePet(pet);

        // Crear una instancia de Pet
        User user = new User();
        user.setId(1); // Asignar el ID de la mascota
        quote.setQuotes(user);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        quote.setDate(date);

        this.quotesStringData.add(String.valueOf(quote));
        return quote;
    }

}
