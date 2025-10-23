package com.jaax.restfulapi.service;


import com.jaax.restfulapi.entity.Business;
import com.jaax.restfulapi.error.LocalNotFoundException;
import com.jaax.restfulapi.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service// marcamos con esta anotacion que es un servicio, aqui va a ir la logica de negocio
public class BusinessServiceImpl implements BusinessService { // BusinessServiceImplentation hereda de BusinessService

    @Autowired // **DUDA**  hace inyeccion de dependencias, de businesslRepository (segun entiendo, los repositorios de spring o springboot se deben heredar asi, por que? no se
    BusinessRepository businesslRepository;

    @Override //override porque estamos sobreescribiendo metodos de la interfaz BusinessService
    public List<Business> findAllBussnies() {
        return businesslRepository.findAll();
    }  //businessRepository tiene una funcion predeterminada llamada businessRepository.findAll() que nos devuelve una lista de local

    @Override //override porque estamos sobreescribiendo metodos de la interfaz BusinessService
    public Business saveBusiness(Business business) {
        return businesslRepository.save(business);
    }

//    @Override
//    public Business updateBussnies(Long id, Business business) {
//        Business businessDb = businesslRepository.findById(id).get();
//        return businesslRepository.save(businessDb);//utilizamos otra vez save
//    }

    @Override
    public void deleteBusiness(Long id) {
        businesslRepository.deleteById(id);
    }

    // Consulta con JPQL (se puede usar lenguaje de consulta sql nativo
    @Override
    public Optional<Business> findBusinessByNameWithJPQL(String name) {
        return businesslRepository.findByName(name);
//        return BusinessRepository.findbusinessByNameWithJPQL(name);
    }

    // Consulta con Inversión de Control JPA (consulta igual que la de arriba pero automatizada)
    @Override
    public Optional<Business> findByName(String name){
      return businesslRepository.findByName(name);
    }

    // Consulta con Inversión de Control JPA (consulta igual que la de arriba pero automatizada)
    @Override
    public Optional<Business> findByNameIgnoreCase(String name) {
        return businesslRepository.findByNameIgnoreCase(name);
    }

    // Consulta con manejo de exepciones
    @Override
    public Business findBusinessById(Long id) throws LocalNotFoundException {
        Optional<Business> local = businesslRepository.findById(id);
        if(!local.isPresent()){//este if evalua si el bussnies que estamos buscando por id retorna un nulo, significa que no encontro nada
            throw new LocalNotFoundException("Business is not available");
        }
        return local.get();
    }


}
