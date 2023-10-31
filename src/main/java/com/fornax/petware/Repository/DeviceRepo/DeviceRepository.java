package com.fornax.petware.Repository.DeviceRepo;

import com.fornax.petware.Entity.DevicePackage.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository  extends JpaRepository<Device, Long> {

}
