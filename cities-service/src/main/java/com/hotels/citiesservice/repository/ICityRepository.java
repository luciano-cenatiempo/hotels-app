package com.hotels.citiesservice.repository;

import com.hotels.citiesservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c FROM City c WHERE name = :name AND country = :country")
    public City findCityByCountryAndName(String country, String name);
}
