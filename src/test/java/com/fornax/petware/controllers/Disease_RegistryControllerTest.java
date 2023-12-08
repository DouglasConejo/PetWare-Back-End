package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.DeviceContro.DeviceController;
import com.fornax.petware.Controller.Disease_RegistryController.Disease_RegistryController;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.DiseasePackage.Disease;
import com.fornax.petware.Entity.Disease_RegistryPackage.Disease_Registry;
import com.fornax.petware.service.DeviceService;
import com.fornax.petware.service.Disease_RegistryService;
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

public class Disease_RegistryControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private Disease_RegistryController lookupController;

    @Mock
    Disease_RegistryService disease_registryService;

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

        Disease_Registry newDisease_Registry = new Disease_Registry();
        newDisease_Registry.setDescription("Enfermedad de regsitro");
        Disease_Registry result = new Disease_Registry();

        // Crear una instancia de Disease
        Disease disease = new Disease();
        disease.setId(1); // Asignar el ID de la enfermedad
        result.setDisease(disease);

        // Crear una instancia de Pet
        Pet pet = new Pet();
        pet.setId(1); // Asignar el ID de la mascota
        result.setPetDisease(pet);

        result.setDescription("Enfermedad de regsitro ");
        Long id = Long.valueOf(7);
        result.setId(id);
        result.setTreatment("Tratamiento prueba");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = formatter.parse("2023-11-15T21:21:36.033+00:00");
        result.setRecovery_date(date);


        Mockito.when(disease_registryService.addDisease_Registry(Mockito.any(Disease_Registry.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/").content(asJsonString(disease_registryService)).contentType(MediaType.APPLICATION_JSON)
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
