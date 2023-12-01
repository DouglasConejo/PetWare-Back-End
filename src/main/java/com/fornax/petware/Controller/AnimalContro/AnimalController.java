package com.fornax.petware.Controller.AnimalContro;

import com.fornax.petware.Entity.AnimalPackage.AnimalDetailPackage;
import com.fornax.petware.Entity.AnimalPackage.FilterAnimalBody;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.DevicePackage.Device;
import com.fornax.petware.Repository.AnimalRepo.AnimalRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin("*")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Value("${aioKey}")
    private String adafruitKey;

    @Value("${FeedBaseUrl}")
    private String FeedBaseUrl;

    private HttpClient client = HttpClient.newHttpClient();


    @GetMapping("pets")
    public List<Pet> getAllPet() {
        return animalRepository.findAll();
    }

    @GetMapping("pets/search")
    public List<Pet> getPetsByName(@RequestParam(value = "name") String name) {
        return animalRepository.searchPetByName(name);
    }

    @GetMapping("/petsData")
    public List<Object[]> getPetData() {
        return animalRepository.findPetData();
    }

    @GetMapping("/user/{userId}/pets")
    public List<Pet> getPets(@PathVariable Long userId) {
        List<Pet> pets = animalRepository.findPetDataByUser(userId);
        return pets;
    }

    @GetMapping("pets/{id}")
    public
    Optional<Pet> getPet(@PathVariable(value = "id") Long id) {
        return animalRepository.findById(id);
    }

    @PostMapping("pets")
    public Pet addPet(@RequestBody Pet pet) {
        return animalRepository.save(pet);
    }
    @DeleteMapping("/pet/{id}")
    public ResponseEntity<?> deletePet(@PathVariable(value = "id") Long id) {
        animalRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("pet/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable(value = "id") Long id,
                                         @RequestBody Pet petUpdate) {

        Optional<Pet> pet = animalRepository.findById(id);

        pet.get().setName(petUpdate.getName());
        pet.get().setSpecie(petUpdate.getSpecie());
        pet.get().setBreed(petUpdate.getBreed());
        pet.get().setDate(petUpdate.getDate());
        Pet updatedPost = animalRepository.save(pet.get());
        return ResponseEntity.ok(updatedPost);
    }

    @PostMapping("pet/filter")
    public ResponseEntity<List<AnimalDetailPackage>> filterAnimals(@RequestBody FilterAnimalBody requestBody) {
        // [lat, long]
        List<Pet> animalsList = this.animalRepository.findPetDataByUser(requestBody.getUserId());
        List<AnimalDetailPackage> animalDetailList = new ArrayList<>();
        animalsList.forEach(a -> {
            AnimalDetailPackage animal = new AnimalDetailPackage(a.getId(), a.getName(), a.getSpecie(), a.getBreed(), a.getDate(), a.getUser(), a.getDevice());
            if (requestBody.isGetCoordinates()) {
                if (a.getDevice() != null) {
                    String[] coordinates = this.getDeviceCoordinates(a.getDevice());
                    if (coordinates != null) {
                        animal.setLatitude(coordinates[0]);
                        animal.setLongitude(coordinates[1]);
                    }
                }
            }
            animalDetailList.add(animal);
        });
        return ResponseEntity.ok(animalDetailList);
    }

    private String[] getDeviceCoordinates(Device device) {
        try {
            String aioKey = this.adafruitKey;
            String feedURL = this.FeedBaseUrl + "/" + device.getUbication();
            System.out.println(feedURL);
            URI url = URI.create(feedURL);
            HttpRequest request = HttpRequest.newBuilder(url).header("X-AIO-KEY", aioKey).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JSONObject json = new JSONObject(response.body());
                String lastValue = (String) json.get("last_value");
                return getCoordinatesLastValue(lastValue);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] getCoordinatesLastValue(String lastValue) {
            // Split the lastValue into two parts using the "|" character
            String[] values = lastValue.split("\\|");
            return values;
    }
    //Mostrar cantidad de mascotas por usuario
    @GetMapping("/countPetsByUser/{userId}")
    public ResponseEntity<Long> countPetsByUser(@PathVariable(value = "userId") Long userId) {
        List<Object[]> result = animalRepository.countPetsByUserId(userId);

        // Verifica si hay resultados y devuelve el conteo
        if (!result.isEmpty()) {
            Long count = (Long) result.get(0)[1];
            return new ResponseEntity<>(count, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0L, HttpStatus.OK); // o puedes devolver HttpStatus.NOT_FOUND
        }
    }
    //ID de pruebas:
    // 118220722=3
    ////1822298222=2
    ////118220722=1
    @GetMapping("/countSickPetsThisMonth/{userId}")
    public ResponseEntity<Long> countSickPetsThisMonthForUser(@PathVariable(value = "userId") Long userId) {
        Long count = animalRepository.countSickPetsThisMonthForUser(userId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //Todas las enfermedades con fecha de recuperacion
    @GetMapping("/totalDiseases/{userId}/{year}")
    public ResponseEntity<Long> getTotalDiseasesByUserAndYear(@PathVariable Long userId, @PathVariable int year) {
        Long totalDiseases = animalRepository.getTotalDiseasesByUserAndYear(userId, year);
        return new ResponseEntity<>(totalDiseases, HttpStatus.OK);
    }
    //Todas las enfermedades con fecha de recuperacion y sin fecha de recuperacion
    @GetMapping("/totalDiseases/{userId}")
    public ResponseEntity<Long> getTotalDiseasesByUser(@PathVariable Long userId) {
        Long totalDiseases = animalRepository.getTotalDiseasesByUserByYear(userId);
        return new ResponseEntity<>(totalDiseases, HttpStatus.OK);
    }

    @GetMapping("/mostCommonDisease")
    public ResponseEntity<List<Object[]>> getMostCommonDisease() {
        List<Object[]> mostCommonDisease = animalRepository.findMostCommonDisease();
        return new ResponseEntity<>(mostCommonDisease, HttpStatus.OK);
    }
}
