package com.fornax.petware.Repository.DeviceRepo;

import com.fornax.petware.Entity.DevicePackage.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository  extends JpaRepository<Device, Long> {
}
