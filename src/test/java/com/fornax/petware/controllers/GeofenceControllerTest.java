package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.GeofenceContro.GeofenceController;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Repository.GeofencesRepo.GeofenceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GeofenceControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GeofenceController geofenceController;

    @Mock
    private GeofenceRepo geofenceRepo;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(geofenceController).build();
    }

    @Test
    void getGeofence() throws Exception {
        Geofences geofence = new Geofences();
        geofence.setId(14L);
        geofence.setName("geocerca jeremy");

        when(geofenceRepo.findById(14L)).thenReturn(Optional.of(geofence));

        mockMvc.perform(get("/geofences/14"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("geocerca jeremy"));
    }

    @Test
    void getUserGeofences() throws Exception {
        when(geofenceRepo.findGeofencesByUserId(118220722L)).thenReturn(Arrays.asList(new Geofences(), new Geofences()));

        mockMvc.perform(get("/geofences/user/118220722"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void updateGeofences() throws Exception {
        Geofences existingGeofence = new Geofences();
        existingGeofence.setId(14L);
        existingGeofence.setName("geocerca jeremy");
        existingGeofence.setColor("#ffb910");
        existingGeofence.setDescription("geocerca jeremy");

        when(geofenceRepo.findById(14L)).thenReturn(Optional.of(existingGeofence));
        when(geofenceRepo.save(any(Geofences.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Geofences updatedGeofence = new Geofences();
        updatedGeofence.setName("geocerca jeremy 2");
        updatedGeofence.setColor("#fff");
        updatedGeofence.setDescription("geocerca jeremy 2");

        mockMvc.perform(put("/geofences/14")
                        .content(asJsonString(updatedGeofence))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("geocerca jeremy 2"))
                .andExpect(jsonPath("$.color").value("#fff"))
                .andExpect(jsonPath("$.description").value("geocerca jeremy 2"));
    }

    private String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



