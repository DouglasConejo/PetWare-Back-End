package com.fornax.petware.service;

import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CoordinateService {

    private List<Coordinate> coordinatesStringData;

    private List<String> cordinateStringData;


    public CoordinateService(){
        coordinatesStringData = new LinkedList<>();
    }

    public Coordinate addCoordinate(Coordinate coordinate) throws ParseException {
        coordinate.setId(1);
        coordinate.setOrderNum(12464);
        coordinate.setLat(3543468);
        coordinate.setLng(3093498);

        this.coordinatesStringData.add(coordinate);
        return coordinate;
    }

    public List<String> getCoordinates(){
        return cordinateStringData;
    }

    public List<Coordinate> getAllCoordinatesBackend(){
        return coordinatesStringData;
    }
}
