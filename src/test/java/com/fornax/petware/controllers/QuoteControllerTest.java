package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.Disease_RegistryController.Disease_RegistryController;
import com.fornax.petware.Controller.QuoteController.QuoteController;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.service.Disease_RegistryService;
import com.fornax.petware.service.QuoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QuoteControllerTest {



    private MockMvc mockMvc;

    @InjectMocks
    private QuoteController lookupController;

    @Mock
    QuoteService quoteService;

    /**
     * @throws java.lang.Exception
     */

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lookupController).build();
    }

    @Test
    void whenSubmitQuote_thenQuoteIdIsGenerated() throws Exception {

        Quote newQuote = new Quote();
        newQuote.setReason("Cita Test");

        Quote result = new Quote();
        result.setReason("Cita Test");

        // Crear una instancia de User
        User user = new User();
        user.setId(1); // Asignar el ID de la mascota
        result.setQuotes(user);

        result.setLocation("Location test ");
        Long id = Long.valueOf(7);
        result.setId(id);
        result.setCall("Llamada test");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        result.setDate(date);


        Mockito.when(quoteService.addQuote(Mockito.any(Quote.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/").content(asJsonString(quoteService)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(notNullValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(equalTo(id.toString()))))
                .andReturn();
    }

    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
