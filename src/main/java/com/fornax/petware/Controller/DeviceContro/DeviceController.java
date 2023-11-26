package com.fornax.petware.Controller.DeviceContro;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Repository.DeviceRepo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/device/{petId}/devices")
    public List<Device> getDevicePet(@PathVariable Long petId) {
        List<String[]> queryResponse = deviceRepository.findDeviceDataByPet(petId);
        ArrayList<Device> devices = new ArrayList<>();
        queryResponse.forEach(p -> {
            Device device = new Device();
            device.setId(Long.parseLong(p[0]));
            device.setSerialNumber(Integer.parseInt(p[1]));
            device.setUbication(p[2]);
            devices.add(device);
        });
        return devices;
    }

    @PostMapping("device")
    public Device addDevices(@RequestBody Device device) {
        return deviceRepository.save(device);
    }
    @PutMapping("deviceCoords/{id}")
    public ResponseEntity<Device> updateCoords(@PathVariable(value = "id") Long id,
                                               @RequestBody Device deviceUpdate){
        Optional<Device> perfil = deviceRepository.findById(id);
        String[] coordsNuevas = perfil.get().updateCoords();
        float newlat = Float.parseFloat(coordsNuevas[0]);
        float newlong = Float.parseFloat(coordsNuevas[1]);
        perfil.get().updateCoordinates(newlat,newlong);
        Device updatedDevice = deviceRepository.save(perfil.get());
        return ResponseEntity.ok(updatedDevice);
    }

    @PutMapping("device/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable(value = "id") Long id,
                                               @RequestBody Device deviceUpdate) {

        Optional<Device> perfil = deviceRepository.findById(id);


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
