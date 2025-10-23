package com.jaax.restfulapi.controller;

import com.jaax.restfulapi.entity.Business;

import com.jaax.restfulapi.error.LocalNotFoundException;
import com.jaax.restfulapi.service.BusinessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        maxAge = 3600)

@RestController
public class BusinessController {

    @Autowired
    BusinessService businessService; //estamos inyectando nuestro servico (BusinessService) con la anotacion @Autowired, para poder usarlo en nuestro controlador.

    @GetMapping("/findAllBusiness")
    public List<Business> findAllLocals(){
        return businessService.findAllBussnies();
    }

    @GetMapping("/findBusinessById/{id}")
    Business findLocalById(@PathVariable Long id) throws LocalNotFoundException {
        return businessService.findBusinessById(id);
    }

    @GetMapping("/findLocalByNameWithJPQL/{name}")
    Optional<Business> findLocalByNameWithJPQL(@PathVariable String name){
        return businessService.findBusinessByNameWithJPQL(name);
    }

    @GetMapping("/findByName/{name}")
    Optional<Business> findByName (@PathVariable String name) {
        return businessService.findByName(name);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<Business> findByNameIgnoreCase(@PathVariable String name){
        return businessService.findByNameIgnoreCase(name);
    }

    @PostMapping("/saveBusiness")
    public Business saveBusiness(@Valid @RequestBody Business business){
        return businessService.saveBusiness(business);
    }

//    @PutMapping("/updateLocal/{id}")
//    public Business updateLocal(@PathVariable Long id, @Re
//    questBody Business business){
//        return businessService.updateBussnies(id, business);
//    }
    
    @DeleteMapping("/deleteBusiness/{id}")
    public String deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return "Successfully deleted";
    }

}