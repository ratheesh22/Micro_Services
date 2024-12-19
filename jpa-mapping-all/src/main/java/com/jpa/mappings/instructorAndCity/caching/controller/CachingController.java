package com.jpa.mappings.instructorAndCity.caching.controller;

import com.jpa.mappings.instructorAndCity.caching.entity.City;
import com.jpa.mappings.instructorAndCity.caching.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CachingController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city/json")
    public String postJSON(@RequestBody List<City> list){

        long startTime = System.currentTimeMillis();
        cityService.saveAllCity(list);
        long endTime = System.currentTimeMillis();
        Long longee=endTime-startTime;
        return longee.toString();
    }

    @GetMapping ("/city/all")
    public List<City> getAllCities(){
        long s=System.currentTimeMillis();
        List<City> cities=cityService.getAllCities();
        long e=System.currentTimeMillis();
        System.out.println(e-s);
        return  cities;
    }

    @GetMapping("/city/{name}")
    public  List<City> findByName(@PathVariable  String name){
        return  cityService.findByName(name);
    }
    @GetMapping("/country/{country}")
    public  List<City> findByCountry(@PathVariable  String country){
        return  cityService.findByCountry(country);
    }

    @DeleteMapping("/delete/city/{id}")
    public String deleteById(@PathVariable int id){
        return cityService.deleteByName(id);
    }

    @PostMapping("/city/save")
    public  City saveCity(@RequestBody City city){
        return  cityService.saveOrUpdateCity(city);
    }


}
