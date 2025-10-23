package com.jaax.restfulapi.controller;

import com.jaax.restfulapi.entity.Business;
import com.jaax.restfulapi.service.BusinessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocalController.class)
class BusinessControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService businessService;

    private Business business;

    @BeforeEach
    void setUp() {
         business = Business.builder()
                .id(1L)
                .name("Cinema")
                .floor("Fourth Floor")
                .code("Cin-040-4")
                .build();
    }

    @Test
    public void saveBusiness() throws Exception{
        Business postBusiness = Business.builder()
                .name("Cinema")
                .floor("Fourth Floor")
                .code("Cin-040-4")
                .build();
        Mockito.when(businessService.saveBusiness(postBusiness)).thenReturn(business);
        mockMvc.perform(post("/saveLocal").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"Cinema\",\n" +
                        "    \"floor\": \"Fourth Floor\",\n" +
                        "    \"code\":\"Cin-040-4\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    public void findLocalById() throws Exception{
        Mockito.when(businessService.findBusinessById(1L)).thenReturn(business);
        mockMvc.perform(get("/findLocalById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(business.getName()));
    }

}