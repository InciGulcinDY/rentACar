package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Override
    public List<GetAllCarsResponse> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public List<GetAllCarsWithGearTypesResponse> getAllCarsWithGearTypes() {
        return carRepository.getAllCarsWithGearTypes();
    }

    @Override
    public List<Car> getCarByPlateNumber(String plateNumber) {
        return carRepository.findByPlateNumberStartingWith(plateNumber);
    }

    @Override
    public void addCar(AddCarRequest request) {
        Car car = new Car();
        car.setPlateNumber(request.getPlateNumber());
        car.setPassengerCapacity(request.getPassengerCapacity());
        car.setImage(request.getImage());
        car.setBaggageCapacity(request.getBaggageCapacity());
        carRepository.save(car);
    }
    @Override
    public void deleteCar(DeleteCarRequest request) {
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            if(car.getPlateNumber().equals(request.getPlateNumber())){
                request.setId(car.getId());
            }
        }
        //Checking the existance of the car
        carRepository.findById(request.getId()).orElseThrow();
        //Delete the car
        carRepository.deleteById(request.getId());
    }
    @Override
    public void updateCar(String plateNumber, UpdateCarRequest request) {
        List<Car> cars = carRepository.findAll();
        for (Car car:cars) {
            if(car.getPlateNumber().equals(plateNumber)){
                request.setId(car.getId());
                car.setPlateNumber(request.getPlateNumber());
                car.setBaggageCapacity(request.getBaggageCapacity());
                car.setImage(request.getImage());
                car.setPassengerCapacity(request.getPassengerCapacity());
                carRepository.save(car);
            }
        }
        //Checking the existance of the car
        carRepository.findById(request.getId()).orElseThrow();
    }

    @Override
    public List<GetCarByBrandResponse> getCarByBrand(String brandName) {
        List<GetCarByBrandResponse> carByBrandResponseList = carRepository.getCarByBrand();
        List<GetCarByBrandResponse> responses = new ArrayList<>();
        for (GetCarByBrandResponse response : carByBrandResponseList) {
            GetCarByBrandResponse carByBrandResponse = new GetCarByBrandResponse();
            if(response.getBrand().equals(brandName)){
                carByBrandResponse.setBrand(response.getBrand());
                carByBrandResponse.setPlateNumber(response.getPlateNumber());
                carByBrandResponse.setModel(response.getModel());
                responses.add(carByBrandResponse);
            }
        }
        return responses;
    }
}
