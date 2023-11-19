package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.UserContro.UserController;
import com.fornax.petware.Entity.UserPackage.Role;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.Repository.UserRepo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void addUser() throws Exception {
        User newUser = new User();
        newUser.setId(118570146);
        newUser.setName("Sebastián Saprissa Aragón");
        newUser.setEmail("ssaprissaa@ucenfotec.ac.cr");
        newUser.setPassword("password123");
        newUser.setPhone("887-984-07");
        newUser.setRole(Role.valueOf("User"));

        when(userRepository.save(any(User.class))).thenReturn(newUser);

        mockMvc.perform(post("/user")
                        .content(asJsonString(newUser))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sebastián Saprissa Aragón"));
    }

    @Test
    void findUserByEmail() throws Exception {
        when(userRepository.findByEmail("ssaprissaa@ucenfotec.ac.cr")).thenReturn(new User());

        mockMvc.perform(get("/user/ssaprissaa@ucenfotec.ac.cr"))
                .andExpect(status().isOk());
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

