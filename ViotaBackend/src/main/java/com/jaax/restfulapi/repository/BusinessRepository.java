package com.jaax.restfulapi.repository;

import com.jaax.restfulapi.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Long> {
    @Query("SELECT bs FROM Business bs WHERE bs.name = :name")
    Optional<Business> findBusinessByNameWithJPQL(String name);

    Optional<Business> findByName(String name);

    Optional<Business> findByNameIgnoreCase(String name);
}