package com.hotels.hotelsservice.service;

import com.hotels.hotelsservice.model.Hotel;

import java.util.List;

public interface IHotelService {
    public List<Hotel> getHotelsByCity(Long cityId);
    public Hotel saveHotel(Hotel hotel);
    public List<Hotel> getAllHotels();
}
