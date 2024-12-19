package com.jpa.mappings.instructorAndCity.caching.service;

import com.jpa.mappings.instructorAndCity.caching.entity.City;
import com.jpa.mappings.instructorAndCity.caching.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public void saveAllCity(List<City> cities){
        cityRepository.saveAll(cities);
    }

    @Cacheable("Cities")
    public  List<City> getAllCities(){
        return  cityRepository.findAll();
    }


    @Cacheable(key = "#name",value = "Cities")
    public  List<City> findByName(String name){
        List<City> city= cityRepository.findByName(name);
        return city;
    }

    public  List<City> findByCountry(String name){
        List<City> city= cityRepository.findByCountryCode(name);
        return city;
    }

    @CachePut(key = "#city.id", value = "Cities")
    public City saveOrUpdateCity(City city){
        return  cityRepository.save(city);
    }

    @CacheEvict(key = "#id",value = "Cities")
    public String deleteByName(int id) {
        City city=cityRepository.getReferenceById(id);

        cityRepository.delete(city);
        return "success";
    }

    @CacheEvict(value = "Cities", allEntries = true)
    public void clearAllCache() {
        System.out.println("Clearing all cache entries...");
    }
}
