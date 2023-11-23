package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.cars.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.cars.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;

import java.util.List;

public interface CarService {
    public List<GetAllCarsResponse> getAllCars();
    public void addCar(AddCarRequest request);
    public void deleteCar(DeleteCarRequest request);
    public void updateCar(String plateNumber, UpdateCarRequest request);

}
