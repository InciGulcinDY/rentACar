package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Van;
import com.tobeto.rentACar.services.dtos.vans.requests.AddVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.DeleteVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.UpdateVanRequest;
import com.tobeto.rentACar.services.dtos.vans.responses.GetAllVanResponse;
import com.tobeto.rentACar.services.dtos.vans.responses.GetVanByPlateNumberResponse;

import java.util.List;

public interface VanService {
    public List<GetAllVanResponse> getAllVans();
    public List<GetVanByPlateNumberResponse> getVanByPlateNumber(String plateNumber);
    public void addVan(AddVanRequest request);
    public void deleteVan(DeleteVanRequest request);
    public void updateVan(String plateNumber, UpdateVanRequest request);
}
