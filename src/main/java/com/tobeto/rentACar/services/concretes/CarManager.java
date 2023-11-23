package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
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
        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> responses = new ArrayList<>();
        for (Car car:cars) {
            GetAllCarsResponse responseItem = new GetAllCarsResponse();
            responseItem.setBaggageCapacity(car.getBaggageCapacity());
            responseItem.setImage(car.getImage());
            responseItem.setPlateNumber(car.getPlateNumber());
            responseItem.setPassengerCapacity(car.getPassengerCapacity());
            responses.add(responseItem);
        }
        return responses;

        //TODO: Add model & brand
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
}
