package com.jaax.restfulapi.repository;

import com.jaax.restfulapi.entity.Business;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class BusinessRepositoryTest {

    @Autowired
    businesslRepository businesslRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Business business =
                Business.builder()
                        .name("Supermarket")
                        .floor("Third Floor")
                        .code("Sup-010-3")
                        .build();
        testEntityManager.persist(business);
    }


    @Test
    public void findLocalByNameIgnoreCaseFound(){
        Optional<Business> local = businesslRepository.findByNameIgnoreCase("Supermarket");
        assertEquals(local.get().getName(),"Supermarket");
        System.out.println("local.get() = " + local.get());
    }

    @Test
    public void findLocalByNameIgnoreCaseNotFound(){
        Optional<Business> local = businesslRepository.findByNameIgnoreCase("Cinema");
        assertEquals(local,Optional.empty());
    }


}