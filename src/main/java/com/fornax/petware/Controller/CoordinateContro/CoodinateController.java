package com.fornax.petware.Controller.CoordinateContro;

import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Repository.CoordinateRepo.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CoodinateController {


    @Autowired
    CoordinateRepository coordinateRepository;


    @GetMapping("coordinates")
    public List<Coordinate> getAllPet() {
        return coordinateRepository.findAll();
    }

    @GetMapping("/coordinate/{Id}/pets")
    public List<Coordinate> getCoordinateJSON(@PathVariable Long coordinateId) {
        List<String[]> queryResponse = coordinateRepository.findByGeofenceId(coordinateId);
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        queryResponse.forEach(p -> {
            Coordinate coordinate = new Coordinate();
            coordinate.setId(Long.parseLong(p[0]));
            coordinate.setLng(Float.parseFloat(p[1]));
            coordinate.setLat(Float.parseFloat(p[2]));
            coordinate.setOrderNum(Integer.parseInt(p[4]));
            coordinates.add(coordinate);
        });
        return coordinates;
    }


    @GetMapping("coordinates/{id}")
    public Optional<Coordinate> getCoordinate(@PathVariable(value = "id") Long id) {
        return coordinateRepository.findById(id);
    }

    @PostMapping("coordinate")
    public Coordinate addCoordinate(@RequestBody Coordinate coordinate) {
        return coordinateRepository.save(coordinate);
    }
    @DeleteMapping("/coordinate/{id}")
    public ResponseEntity<?> deleteCoordinate(@PathVariable(value = "id") Long id) {
        coordinateRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("coordinate/{id}")
    public ResponseEntity<Coordinate> updateCoordinate(@PathVariable(value = "id") Long id,
                                                @RequestBody Coordinate coordinateUpdate) {

        Optional<Coordinate> coordinate = coordinateRepository.findById(id);

        coordinate.get().setOrderNum(coordinateUpdate.getOrderNum());
        coordinate.get().setLat(coordinateUpdate.getLat());
        coordinate.get().setLng(coordinateUpdate.getLng());
        Coordinate updatedCoordinate = coordinateRepository.save(coordinate.get());
        return ResponseEntity.ok(updatedCoordinate);
    }

}
