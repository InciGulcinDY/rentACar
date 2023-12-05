package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByPlateNumberStartingWithResponse;

import java.util.List;

public interface CarService {
    public List<GetAllCarsResponse> getAllCars();
    public List<GetAllCarsWithGearTypesResponse> getAllCarsWithGearTypes();
    public List<GetCarByPlateNumberStartingWithResponse> getCarByPlateNumber(String plateNumber);
    public void addCar(AddCarRequest request);
    public void deleteCar(DeleteCarRequest request);
    public void updateCar(String plateNumber, UpdateCarRequest request);
    public List<GetCarByBrandResponse> getCarByBrand(String brandName);

}
