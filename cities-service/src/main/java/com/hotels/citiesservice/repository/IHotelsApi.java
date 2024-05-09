package com.hotels.citiesservice.repository;

import com.hotels.citiesservice.dto.HotelDto;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="hotels-service")
public interface IHotelsApi {
    @GetMapping("/hotels/cities/{cityId}")
    public List<HotelDto> getHotelsByCity(@PathVariable Long cityId);
}
