package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByPlateNumberStartingWithResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsControllers {
    private final CarService carService;

    public CarsControllers(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("getall")
    public List<GetAllCarsResponse> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("getallwithgeartypes")
    public List<GetAllCarsWithGearTypesResponse> getAllCarsWithGearTypes(){
        return carService.getAllCarsWithGearTypes();
    }
    @GetMapping("{brandName}")
    public List<GetCarByBrandResponse> getCarByBrand(String brandName){
        return carService.getCarByBrand(brandName);
    }

    @GetMapping("plateNumber")
    public List<GetCarByPlateNumberStartingWithResponse> getCarByPlateNumber(@RequestParam String plateNumber){
        return carService.getCarByPlateNumber(plateNumber);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request) {
        carService.addCar(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCarRequest request) {
        carService.deleteCar(request);
    }

    @PutMapping("{plateNumber}")
    public void update(@RequestParam String plateNumber, @RequestBody @Valid UpdateCarRequest request) {
        carService.updateCar(plateNumber, request);
    }
}