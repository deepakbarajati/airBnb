package com.deepak.airBnbApp.service;

import com.deepak.airBnbApp.dto.HotelDto;
import com.deepak.airBnbApp.dto.HotelPriceDto;
import com.deepak.airBnbApp.dto.HotelSearchRequest;
import com.deepak.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService{

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);

}
