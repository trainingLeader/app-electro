package com.inventarioelectro.app_electro.infrastructure.repositories.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventarioelectro.app_electro.application.services.ICountryService;
import com.inventarioelectro.app_electro.domain.entity.Country;


@Service
public class CountryImpl implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
   }

    @Transactional
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    @Override
    public Optional<Country> update(Long id, Country country) {
        Optional<Country> countryOld = countryRepository.findById(id);
        if(countryOld.isPresent()){
            Country countryDb = countryOld.orElseThrow();
            countryDb.setName(country.getName());
            return Optional.of(countryRepository.save(countryDb));
        }
        return Optional.empty();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Country> delete(Long id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        countryOptional.ifPresent(countrytDb -> {
            countryRepository.delete(countrytDb);
        });
        return countryOptional;
    }

}
