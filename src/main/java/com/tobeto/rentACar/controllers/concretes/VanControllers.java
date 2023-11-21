package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.VanRepository;
import com.tobeto.rentACar.entities.concretes.Van;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vans")
public class VanControllers {
    private final VanRepository vanRepository;

    public VanControllers(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    @GetMapping
    public List<Van> getAll(){
        return vanRepository.findAll();
    }

    @GetMapping("{id}")
    public Van getById(@PathVariable int id){
        return vanRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Van van){
        vanRepository.save(van);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Van vanToBeDeleted = vanRepository.findById(id).orElseThrow();
        vanRepository.delete(vanToBeDeleted);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Van van){
        Van vanToBeUpdated = vanRepository.findById(id).orElseThrow();
        vanToBeUpdated.setDoorNumber(van.getDoorNumber());
        vanToBeUpdated.setColor(van.getColor());
        vanToBeUpdated.setBaggageCapacity(van.getBaggageCapacity());
        vanToBeUpdated.setCategoryVehicles(van.getCategoryVehicles());
        vanToBeUpdated.setImage(van.getImage());
        vanToBeUpdated.setDriverAgeLimit(van.getDriverAgeLimit());
        vanToBeUpdated.setDriverLicenceReqType(van.getDriverLicenceReqType());
        vanToBeUpdated.setDriverExperienceReqLimit(van.getDriverExperienceReqLimit());
        vanToBeUpdated.setEnergyType(van.getEnergyType());
        vanToBeUpdated.setGearType(van.getGearType());
        vanToBeUpdated.setManufacturedYear(van.getManufacturedYear());
        vanToBeUpdated.setModel(van.getModel());
        vanToBeUpdated.setPlateNumber(van.getPlateNumber());
        vanToBeUpdated.setPassengerCapacity(van.getPassengerCapacity());
        vanToBeUpdated.setTrafficPermitLicenceDate(van.getTrafficPermitLicenceDate());
        vanRepository.save(vanToBeUpdated);
    }
}

