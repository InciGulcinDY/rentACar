package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Motorcycle;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.request.AddMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.DeleteMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.UpdateMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetMotorcycleByPlateNumberStartingWithResponse;

import java.util.List;

public interface MotorcycleService {
    public List<GetAllMotorcycleResponse> getAllMotorcycles();
    public List<GetMotorcycleByPlateNumberStartingWithResponse> findByPlateNumberStartingWith (String PlateNumber);
    public List<GetAllMotorcycleWithGearTypesResponse> getAllMotorcycleWithGearTypes();
    public void addMotorcycle(AddMotorcycleRequest request);
    public void deleteMotorcycle(DeleteMotorcycleRequest request);
    public void updateMotocycle(String plateNumber, UpdateMotorcycleRequest request);
}
