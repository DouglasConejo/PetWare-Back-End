package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.AnimalContro.AnimalController;
import com.fornax.petware.Controller.UserContro.UserController;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Repository.AnimalRepo.AnimalRepository;
import com.fornax.petware.service.PetService;
import com.fornax.petware.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PetControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AnimalController lookupController;

    @Mock
    PetService petService;

    /**
     * @throws java.lang.Exception
     */

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lookupController).build();
    }

    @Test
    void whenSubmitPet_thenPetIdIsGenerated() throws Exception {
        Pet newPet = new Pet();
        newPet.setName("Marco");

        Pet result = new Pet();
        result.setName("Marco");
        Long id = Long.valueOf(7);
        result.setId(id);
        result.setBreed("Español");
        result.setSpecie("Toro");
        result.setSick(1);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        result.setDate(date);

        Mockito.when(petService.addPet(Mockito.any(Pet.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/pets").content(asJsonString(newPet)).contentType(MediaType.APPLICATION_JSON)
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
