package com.jaax.restfulapi.service;

import com.jaax.restfulapi.entity.Business;
import com.jaax.restfulapi.repository.BusinessRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BusinessServiceTest {

    @Autowired
    private BusinessService businessService;
    @MockBean
    private BusinessRepository BusinesslRepository;

    @BeforeEach
    void setUp() {
        Business business = Business.builder()
                .id(1L)
                .name("Jujutsu chicken")
                .address("Cr 48 No. 35S-30, C.P 05266, Envigado")
                .telephone("123456789")
                .type("restaurant")
                .owner("jose luis")
                .build();
        Mockito.when(BusinesslRepository.findByNameIgnoreCase("Jujutsu chicken")).thenReturn(Optional.of(business));
    }

    @Test
    @DisplayName("Prueba de obtención de información de un negocio enviando un nombre válido")
    public void findByNameIgnoreCaseShouldFound(){
        String bsName = "Jujutsu chicken";
        Business business = businessService.findByNameIgnoreCase(bsName).get();
        assertEquals(bsName, business.getName());
        System.out.println("business = " + business);
    }

}