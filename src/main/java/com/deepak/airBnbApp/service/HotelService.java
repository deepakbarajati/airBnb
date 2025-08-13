package com.deepak.airBnbApp.service;

import com.deepak.airBnbApp.dto.HotelDto;


public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id,HotelDto hotelDto);

    void deleteHotelById(Long id);

    void  activateHotel(Long hotelId);
}
