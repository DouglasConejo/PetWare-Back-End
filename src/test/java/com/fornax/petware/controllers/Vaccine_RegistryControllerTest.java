package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.Disease_RegistryController.Disease_RegistryController;
import com.fornax.petware.Controller.Vaccine_Registry_Contro.Vaccine_RegistryController;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import com.fornax.petware.service.Disease_RegistryService;
import com.fornax.petware.service.Vaccine_RegistryService;
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

public class Vaccine_RegistryControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private Vaccine_RegistryController lookupController;

    @Mock
    Vaccine_RegistryService vaccine_registryService;

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

        Vaccine_Registry newVaccine_Registry = new Vaccine_Registry();
        newVaccine_Registry.setDescription("Enfermedad de regsitro");
        Vaccine_Registry result = new Vaccine_Registry();

        // Crear una instancia de Disease
        Vaccine vaccine = new Vaccine();
        vaccine.setId(1); // Asignar el ID de la enfermedad
        result.setVaccine(vaccine);

        // Crear una instancia de Pet
        Pet pet = new Pet();
        pet.setId(1); // Asignar el ID de la mascota
        result.setPet(pet);

        result.setDescription("Vacuna test");
        Long id = Long.valueOf(7);
        result.setId(id);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        result.setRecovery_date(date);


        Mockito.when(vaccine_registryService.addRegistry_Vaccine(Mockito.any(Vaccine_Registry.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/vaccine_registry_add").content(asJsonString(vaccine_registryService)).contentType(MediaType.APPLICATION_JSON)
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
