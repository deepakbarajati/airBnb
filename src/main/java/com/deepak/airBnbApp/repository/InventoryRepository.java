package com.deepak.airBnbApp.repository;

import com.deepak.airBnbApp.entity.Inventory;
import com.deepak.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByDateAfterAndRoom(LocalDate now, Room room);
}
