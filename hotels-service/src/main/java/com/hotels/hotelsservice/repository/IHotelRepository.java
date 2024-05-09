package com.hotels.hotelsservice.repository;

import com.hotels.hotelsservice.model.Hotel;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h WHERE city_id = :cityId")
    public List<Hotel> getHotelsByCity(Long cityId);
}
