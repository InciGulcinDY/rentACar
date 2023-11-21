package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.MotorcycleRepository;
import com.tobeto.rentACar.entities.concretes.Motorcycle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/motorcycles")
public class MotorcycleControllers {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleControllers(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @GetMapping
    public List<Motorcycle> getAll(){
        List<Motorcycle> motorcycles = motorcycleRepository.findAll();
        return motorcycles;
    }

    @GetMapping("{id}")
    public Motorcycle getById(@PathVariable int id){
        return motorcycleRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Motorcycle motorcycle){
        motorcycleRepository.save(motorcycle);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       Motorcycle motorcycleToBeDeleted = motorcycleRepository.findById(id).orElseThrow();
        motorcycleRepository.delete(motorcycleToBeDeleted);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Motorcycle motorcycle){
        Motorcycle motorcycleToBeUpdated = motorcycleRepository.findById(id).orElseThrow();
        motorcycleToBeUpdated.setBaggageCapacity(motorcycle.getBaggageCapacity());
        motorcycleToBeUpdated.setColor(motorcycle.getColor());
        motorcycleToBeUpdated.setImage(motorcycle.getImage());
        motorcycleToBeUpdated.setCategoryVehicles(motorcycle.getCategoryVehicles());
        motorcycleToBeUpdated.setDriverAgeLimit(motorcycle.getDriverAgeLimit());
        motorcycleToBeUpdated.setDriverLicenceReqType(motorcycle.getDriverLicenceReqType());
        motorcycleToBeUpdated.setDriverExperienceReqLimit(motorcycle.getDriverExperienceReqLimit());
        motorcycleToBeUpdated.setEnergyType(motorcycle.getEnergyType());
        motorcycleToBeUpdated.setGearType(motorcycle.getGearType());
        motorcycleToBeUpdated.setManufacturedYear(motorcycle.getManufacturedYear());
        motorcycleToBeUpdated.setModel(motorcycle.getModel());
        motorcycleToBeUpdated.setPassengerCapacity(motorcycle.getPassengerCapacity());
        motorcycleToBeUpdated.setPlateNumber(motorcycle.getPlateNumber());
        motorcycleToBeUpdated.setTrafficPermitLicenceDate(motorcycle.getTrafficPermitLicenceDate());
        motorcycleRepository.save(motorcycleToBeUpdated);
    }


}
