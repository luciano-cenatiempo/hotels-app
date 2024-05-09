package com.hotels.citiesservice.controller;

import com.hotels.citiesservice.dto.CityDto;
import com.hotels.citiesservice.model.City;
import com.hotels.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("/")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/")

    public ResponseEntity<?> createCity(@RequestBody City city) {

        return ResponseEntity.ok(cityService.createCity(city));
    }

    @GetMapping("/hotels/{country}/{city}")
    public CityDto getHotelsByCity(@PathVariable String country, @PathVariable String city){
        return cityService.findCityByCountryAndName(country, city);
    }
}