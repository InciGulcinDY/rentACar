package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.MotorcycleRepository;
import com.tobeto.rentACar.entities.concretes.Motorcycle;
import com.tobeto.rentACar.services.abstracts.MotorcycleService;
import com.tobeto.rentACar.services.dtos.motorcycles.request.AddMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.DeleteMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.UpdateMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleWithGearTypesResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotorcycleManager implements MotorcycleService {
    private MotorcycleRepository motorcycleRepository;

    public MotorcycleManager(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @Override
    public List<GetAllMotorcycleResponse> getAllMotorcycles() {
        return motorcycleRepository.getAllMotorcycles();
    }

    @Override
    public List<Motorcycle> findByPlateNumberStartingWith(String plateNumber) {
        return motorcycleRepository.findByPlateNumberStartingWith(plateNumber);
    }

    @Override
    public List<GetAllMotorcycleWithGearTypesResponse> getAllMotorcycleWithGearTypes() {
        return motorcycleRepository.getAllMotorcycleWithGearTypesResponse();
    }

    @Override
    public void addMotorcycle(AddMotorcycleRequest request) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setImage(request.getImage());
        motorcycle.setPlateNumber(request.getPlateNumber());
        motorcycle.setPassengerCapacity(request.getPassengerCapacity());
        motorcycleRepository.save(motorcycle);
    }

    @Override
    public void deleteMotorcycle(DeleteMotorcycleRequest request) {
        List<Motorcycle> motorcycles = motorcycleRepository.findAll();
        for (Motorcycle motorcycle : motorcycles) {
            if(motorcycle.getPlateNumber().equals(request.getPlateNumber())){
                request.setId(motorcycle.getId());
            }
        }
        //Checking the existance of the car
        motorcycleRepository.findById(request.getId()).orElseThrow();
        //Delete the car
        motorcycleRepository.deleteById(request.getId());
    }

    @Override
    public void updateMotocycle(String plateNumber, UpdateMotorcycleRequest request) {
        List<Motorcycle> motorcycles = motorcycleRepository.findAll();
        for (Motorcycle motorcycle : motorcycles) {
            if(motorcycle.getPlateNumber().equals(plateNumber)){
                request.setId(motorcycle.getId());
                motorcycle.setPassengerCapacity(request.getPassengerCapacity());
                motorcycle.setImage(request.getImage());
                motorcycle.setPlateNumber(request.getPlateNumber());
                motorcycleRepository.save(motorcycle);
            }
        }
        //Checking the existance of the motorcycle
        motorcycleRepository.findById(request.getId()).orElseThrow();
    }
}
