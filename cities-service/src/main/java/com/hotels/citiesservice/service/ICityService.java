package com.hotels.citiesservice.service;

import com.hotels.citiesservice.dto.CityDto;
import com.hotels.citiesservice.model.City;

import javax.naming.Name;
import java.util.List;

public interface ICityService {
    public City createCity(City city);
    public List<City> getAllCities();
    public CityDto getHotelsByCity(Long cityId);
    public CityDto findCityByCountryAndName(String country, String name);
    public CityDto fallbackGetHotelsByCity(Throwable throwable);
}
