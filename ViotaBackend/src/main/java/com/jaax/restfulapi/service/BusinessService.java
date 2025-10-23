package com.jaax.restfulapi.service;

import com.jaax.restfulapi.entity.Business;
import com.jaax.restfulapi.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BusinessService {
    List<Business> findAllBussnies();
    Business saveBusiness(Business business);
//  Business updateBussnies(Long id, Business business);
    void deleteBusiness(Long id);
    Optional<Business> findBusinessByNameWithJPQL(String name);
    Optional<Business> findByName(String name) ;
    Optional<Business> findByNameIgnoreCase(String name);
    Business findBusinessById(Long id) throws LocalNotFoundException;
}
