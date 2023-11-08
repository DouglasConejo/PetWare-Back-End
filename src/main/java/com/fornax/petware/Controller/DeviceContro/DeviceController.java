package com.fornax.petware.Controller.DeviceContro;

import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Repository.DeviceRepo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DeviceController {

    @Autowired
  DeviceRepository deviceRepository;

    @GetMapping("devices")
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("devices/{id}")
    public Optional<Device> getDevices(@PathVariable(value = "id") Long id) {
        return deviceRepository.findById(id);
    }

    @PostMapping("device")
    public Device addDevices(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @PutMapping("device/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable(value = "id") Long id,
                                               @RequestBody Device deviceUpdate) {

        Optional<Device> perfil = deviceRepository.findById(id);

        perfil.get().setCoordinates(deviceUpdate.getCoordinates());
        perfil.get().setUbication(deviceUpdate.getUbication());
        perfil.get().setSerialNumber(perfil.get().getSerialNumber());
        Device updatedDevice = deviceRepository.save(perfil.get());
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/device/{id}")
    public ResponseEntity<?> deletedevice(@PathVariable(value = "id") Long id) {
        deviceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
