package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsControllers {
    private final CarRepository carRepository;

    public CarsControllers(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setColor(car.getColor());
        carToUpdate.setImage(car.getImage());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setBaggageCapacity(car.getBaggageCapacity());
        carToUpdate.setCategoryVehicles(car.getCategoryVehicles());
        carToUpdate.setDriverAgeLimit(car.getDriverAgeLimit());
        carToUpdate.setDriverExperienceReqLimit(car.getDriverExperienceReqLimit());
        carToUpdate.setEnergyType(car.getEnergyType());
        carToUpdate.setGearType(car.getGearType());
        carToUpdate.setManufacturedYear(car.getManufacturedYear());
        carToUpdate.setDriverLicenceReqType(car.getDriverLicenceReqType());
        carToUpdate.setPassengerCapacity(car.getPassengerCapacity());
        carToUpdate.setPlateNumber(car.getPlateNumber());
        carToUpdate.setTrafficPermitLicenceDate(car.getTrafficPermitLicenceDate());
        carRepository.save(carToUpdate);
    }
}
