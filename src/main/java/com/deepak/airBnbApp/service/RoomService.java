package com.deepak.airBnbApp.service;

import com.deepak.airBnbApp.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createNewRoom(Long hotelId,RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long id);

    RoomDto getRoomById(Long id);

    void deleteRoomById(Long roomId);
}
