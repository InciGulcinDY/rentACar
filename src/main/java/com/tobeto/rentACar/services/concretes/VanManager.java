package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.VanRepository;
import com.tobeto.rentACar.entities.concretes.Van;
import com.tobeto.rentACar.services.abstracts.VanService;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetMotorcycleByPlateNumberStartingWithResponse;
import com.tobeto.rentACar.services.dtos.vans.requests.AddVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.DeleteVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.UpdateVanRequest;
import com.tobeto.rentACar.services.dtos.vans.responses.GetAllVanResponse;
import com.tobeto.rentACar.services.dtos.vans.responses.GetVanByPlateNumberResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VanManager implements VanService {
    private VanRepository vanRepository;

    public VanManager(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    @Override
    public List<GetAllVanResponse> getAllVans() {
        return vanRepository.getAllVans();
    }

    @Override
    public List<GetVanByPlateNumberResponse> getVanByPlateNumber(String plateNumber) {
        return vanRepository.findByPlateNumberStartingWith(plateNumber)
                .stream()
                .map(van -> new GetVanByPlateNumberResponse(
                        van.getPlateNumber(),
                        new GetAllBrandsByCustomerResponse(van.getModel().getBrand().getId(),van.getModel().getBrand().getBrandName()),
                        new GetAllModelsResponse(van.getModel().getId(),van.getModel().getModelName()),
                        van.getPassengerCapacity(),
                        van.getBaggageCapacity(),
                        van.getImage())).toList();
    }

    @Override
    public void addVan(AddVanRequest request) {
        Van van = new Van();
        van.setPassengerCapacity(request.getPassengerCapacity());
        van.setImage(request.getImage());
        van.setPlateNumber(request.getPlateNumber());
        vanRepository.save(van);
    }

    @Override
    public void deleteVan(DeleteVanRequest request) {
        List<Van> vans = vanRepository.findAll();
        for (Van van : vans) {
            if(van.getPlateNumber().equals(request.getPlateNumber())){
                request.setId(van.getId());
            }
        }
        //Checking the existance of the van
        vanRepository.findById(request.getId()).orElseThrow();
        //Delete the van
        vanRepository.deleteById(request.getId());
    }

    @Override
    public void updateVan(String plateNumber, UpdateVanRequest request) {
        List<Van> vans = vanRepository.findAll();
        for (Van van : vans) {
            if(van.getPlateNumber().equals(plateNumber)){
                request.setId(van.getId());
                van.setImage(request.getImage());
                van.setPlateNumber(request.getPlateNumber());
                van.setImage(request.getImage());
                vanRepository.save(van);
            }
        }
        //Checking the existance of the van
        vanRepository.findById(request.getId()).orElseThrow();
    }
}
