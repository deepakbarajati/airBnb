package com.deepak.airBnbApp.service;

import com.deepak.airBnbApp.entity.Room;

public interface InventoryService{

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);
}
