package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.brands.response.GetBrandByBrandNameStartingWithResponse;
import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByPlateNumberStartingWithResponse;
import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<GetCarByPlateNumberStartingWithResponse> getCarByPlateNumber(String plateNumber) {
        List<Car> cars = carRepository.findByPlateNumberStartingWith(plateNumber);
        return cars.stream()
                .map(car -> {
                    Model model = car.getModel();
                    if(model != null){
                        return new GetCarByPlateNumberStartingWithResponse(
                                car.getPlateNumber(),
                                new GetAllModelsResponse(model.getId(), model.getModelName()),
                                car.getPassengerCapacity(),
                                car.getBaggageCapacity(),
                                car.getImage());
                    }else {
                        return null;
                    }
                })
                .filter(Objects :: nonNull)
                .toList();
    }
    @Override
    public List<GetCarByBrandResponse> getCarByBrand(String brandName) {
        return carRepository.getCarByBrand().stream()
                .filter(car -> car.getBrand().getBrandName().equals(brandName))
                .map(car -> new GetCarByBrandResponse(
                                car.getPlateNumber(),
                                new GetAllBrandsByCustomerResponse(car.getBrand().getId(),car.getBrand().getBrandName()),
                                new GetAllModelsResponse(car.getModel().getId(), car.getModel().getModelName())))
                .toList();
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
