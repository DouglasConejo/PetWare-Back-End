package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.AnimalContro.AnimalController;
import com.fornax.petware.Controller.DeviceContro.DeviceController;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.service.DeviceService;
import com.fornax.petware.service.PetService;
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

public class DeviceControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private DeviceController lookupController;

    @Mock
    DeviceService deviceService;

    /**
     * @throws java.lang.Exception
     */

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lookupController).build();
    }

    @Test
    void whenSubmitDevice_thenDeviceIdIsGenerated() throws Exception {

        Device device = new Device();
        device.setSerialNumber(1224634);

        Device result = new Device();
        result.setSerialNumber(1224634);
        Long id = Long.valueOf(7);
        result.setId(id);
        result.setUbication("Alajuela");

        Mockito.when(deviceService.addDevice(Mockito.any(Device.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/").content(asJsonString(device)).contentType(MediaType.APPLICATION_JSON)
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
