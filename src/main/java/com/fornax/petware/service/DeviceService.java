package com.fornax.petware.service;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service

public class DeviceService {

    private List<Device> deviceStringData;

    private List<String> devicesStringData;


    public DeviceService(){
        deviceStringData = new LinkedList<>();
    }

    public Device addDevice(Device device) throws ParseException {
        device.setId(7);
        device.setSerialNumber(1238937);
        device.setUbication("Alaueja");
        this.devicesStringData.add(String.valueOf(device));
        return device;
    }

    public List<String> getPets(){
        return devicesStringData;
    }

    public List<Device> getAllPetsBackend(){
        return deviceStringData;
    }

}
