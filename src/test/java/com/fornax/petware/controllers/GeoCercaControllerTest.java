package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.GeofenceContro.GeofenceController;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.service.GeoFenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GeoCercaControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GeofenceController lookupController;

    @Mock
    GeoFenceService geoFenceService;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lookupController).build();
    }

    @Test
    void whenSubmitUser_thenUserIdIsGenerated() throws Exception {
        Geofences newGeoFence = new Geofences();
        newGeoFence.setName("My Refactor");

        Geofences result = new Geofences();
        result.setName("My Refactor");

        result.setId(1L);
        result.setName("Fencee2");
        result.setDescription("fence de prueba");
        result.setColor("FFFOOO");

        Mockito.when(geoFenceService.addgeofence(Mockito.any(Geofences.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/add-geocercas").content(asJsonString(newGeoFence)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(notNullValue())))
                .andReturn();
    }

    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception{
        // given - precondition or setup
        UUID geoCercaId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        willDoNothing().given(geoFenceService).borrarGeoCercas(geoCercaId);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/Deletegeofence/{id}", geoCercaId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
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
