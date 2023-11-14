package com.fornax.petware.Repository.DeviceRepo;

import com.fornax.petware.Entity.DevicePackage.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepository  extends JpaRepository<Device, Long> {

    @Query("SELECT d.serialNumber, d.ubication " +
            "FROM Device d " +
            "WHERE d.pet.id = :petId")
    List<String[]> findDeviceDataByPet(@Param("petId") Long userId);

    @Query("SELECT d.serialNumber, d.ubication " +
            "FROM Device d " +
            "JOIN d.coordinate c " +
            "WHERE c.id = :coordinateId")
    List<String[]> findDeviceDataByCoordinate(@Param("coordinateId") Long coordinateId);
}
