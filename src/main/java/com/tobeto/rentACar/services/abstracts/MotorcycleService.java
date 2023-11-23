package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.motorcycles.request.AddMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.DeleteMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.UpdateMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse;

import java.util.List;

public interface MotorcycleService {
    public List<GetAllMotorcycleResponse> getAllMotorcycles();
    public void addMotorcycle(AddMotorcycleRequest request);
    public void deleteMotorcycle(DeleteMotorcycleRequest request);
    public void updateMotocycle(String plateNumber, UpdateMotorcycleRequest request);
}
