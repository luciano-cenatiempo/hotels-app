package com.hotels.hotelsservice.controller;

import com.hotels.hotelsservice.model.Hotel;
import com.hotels.hotelsservice.service.IHotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/cities/{cityId}")
    public List<Hotel> getHotelsByCity(@PathVariable Long cityId){
        return hotelService.getHotelsByCity(cityId);
    }

    @PostMapping("/")
    public ResponseEntity<?> createHotel(@Valid @RequestBody Hotel hotel, BindingResult result){
        if (result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @GetMapping("/")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    public ResponseEntity<?> validation(BindingResult result){
        List<String> errors = new ArrayList<>();
        result.getFieldErrors().forEach(err->{
            errors.add("El campo " + err.getField() + " " + err.getDefaultMessage());

        });

        return ResponseEntity.badRequest().body(errors);
    }
}
