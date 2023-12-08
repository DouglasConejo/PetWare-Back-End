package com.fornax.petware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fornax.petware.Controller.ProductContro.ProductController;
import com.fornax.petware.Controller.UserContro.UserController;
import com.fornax.petware.Entity.ProductPackage.Product;
import com.fornax.petware.Entity.UserPackage.User;
import com.fornax.petware.service.ProductService;
import com.fornax.petware.service.UserService;
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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private ProductController lookupController;

    @Mock
    ProductService productService;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lookupController).build();
    }

    @Test
    void whenSubmitProduct_thenProductIdIsGenerated() throws Exception {
        Product newProduct = new Product();
        newProduct.setName("Test Product Name");

        Product result = new Product();
        result.setName("Test Product Name");
        result.setId(1L);
        result.setImage("Test images");
        result.setDescription("Test descrpcion");
        result.setPrice(2.25);

        Mockito.when(productService.adduser(Mockito.any(Product.class))).thenReturn(result);

        this.mockMvc
                .perform(post("/add-user").content(asJsonString(newProduct)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(notNullValue())))
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
