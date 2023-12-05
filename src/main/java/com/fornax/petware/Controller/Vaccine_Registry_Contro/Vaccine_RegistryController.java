package com.fornax.petware.Controller.Vaccine_Registry_Contro;

import com.fornax.petware.Entity.Vaccine_RegistryPackage.VaccineRegistryDTO;
import com.fornax.petware.Entity.Vaccine_RegistryPackage.Vaccine_Registry;
import com.fornax.petware.Repository.Registry_VaccineRepo.Registry_VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Vaccine_RegistryController {

    @Autowired
    Registry_VaccineRepository vaccine_registryRepository;

    @PostMapping("vaccine_registry_add")
    public Vaccine_Registry addVaccineRegistry(@RequestBody Vaccine_Registry vaccineRegistry) {
        return vaccine_registryRepository.save(vaccineRegistry);
    }
    @DeleteMapping("/vaccine_registry/{id}")
    public ResponseEntity<?> deleteVaccineRegistry(@PathVariable(value = "id") Long id) {
        vaccine_registryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/vaccine_registry/{petId}")
    public List<VaccineRegistryDTO> getPetVaccines(@PathVariable(value = "petId") Long petId) throws ParseException {
        List<String[]> vaccinesString = vaccine_registryRepository.findVaccinesByPetId(petId);

        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        List<VaccineRegistryDTO> vaccinesDTO = new ArrayList<>();
        for (String[] strings : vaccinesString) {
            VaccineRegistryDTO vaccineRegistryDTO = new VaccineRegistryDTO();
            vaccineRegistryDTO.setVaccineName(strings[3]);
            vaccineRegistryDTO.setId(Long.parseLong(strings[0]));
            vaccineRegistryDTO.setDescription(strings[1]);
            vaccineRegistryDTO.setRecovery_date(formatter.parse(strings[2]));
            vaccinesDTO.add(vaccineRegistryDTO);
        }
        return vaccinesDTO;
    }

}
