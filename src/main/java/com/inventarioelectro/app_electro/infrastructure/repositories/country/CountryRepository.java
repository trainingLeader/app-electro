package com.inventarioelectro.app_electro.infrastructure.repositories.country;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventarioelectro.app_electro.domain.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {

}
