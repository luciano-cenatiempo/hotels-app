package com.hotels.citiesservice.service;

import com.hotels.citiesservice.dto.CityDto;
import com.hotels.citiesservice.dto.HotelDto;
import com.hotels.citiesservice.model.City;
import com.hotels.citiesservice.repository.ICityRepository;
import com.hotels.citiesservice.repository.IHotelsApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private IHotelsApi hotelsApi;

    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public CityDto getHotelsByCity(Long cityId) {
        return null;
    }

    @Override
    @CircuitBreaker(name="hotels-service", fallbackMethod = "fallbackGetHotelsByCity")
    @Retry(name="hotels-service")
    public CityDto findCityByCountryAndName(String country, String name) {
        CityDto city = new CityDto();

        City cityDb = cityRepository.findCityByCountryAndName(country, name);

        if (cityDb != null){
            city.setId(cityDb.getId());
            city.setCountry(cityDb.getCountry());
            city.setContinent(cityDb.getContinent());
            city.setProvince(cityDb.getProvince());
            city.setName(cityDb.getName());

            System.out.println(city.getName());

            List<HotelDto> hotels = hotelsApi.getHotelsByCity(city.getId());

            city.setHotels(hotels);

            return city;

        }
        return null;
    }

    @Override
    public CityDto fallbackGetHotelsByCity(Throwable throwable) {
        return new CityDto(99999L,"Fallido","Fallido","Fallido","Fallido",null);
    }

}
