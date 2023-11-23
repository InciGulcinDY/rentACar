package com.tobeto.rentACar.controllers.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsControllers {
    private CarService carService;

    public CarsControllers(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("getall")
    public List<GetAllCarsResponse> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request) {
        carService.addCar(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCarRequest request) {
        carService.deleteCar(request);
    }

    @PutMapping("{plateNumber}")
    public void update(@RequestParam String plateNumber, @RequestBody UpdateCarRequest request) {
        carService.updateCar(plateNumber, request);
    }
}