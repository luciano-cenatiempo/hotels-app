package com.hotels.hotelsservice.service;

import com.hotels.hotelsservice.model.Hotel;
import com.hotels.hotelsservice.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements IHotelService{

    @Autowired
    private IHotelRepository hotelRepository;
    @Override
    public List<Hotel> getHotelsByCity(Long cityId) {
       return hotelRepository.getHotelsByCity(cityId);
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


}
