package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.VanRepository;
import com.tobeto.rentACar.entities.concretes.*;
import com.tobeto.rentACar.services.abstracts.*;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetMotorcycleByPlateNumberStartingWithResponse;
import com.tobeto.rentACar.services.dtos.vans.requests.AddVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.DeleteVanRequest;
import com.tobeto.rentACar.services.dtos.vans.requests.UpdateVanRequest;
import com.tobeto.rentACar.services.dtos.vans.responses.GetAllVanResponse;
import com.tobeto.rentACar.services.dtos.vans.responses.GetVanByPlateNumberResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VanManager implements VanService {
    private final VanRepository vanRepository;
    private final ColorService colorService;
    private final ModelService modelService;
    private final GearTypeService gearTypeService;
    private final EnergyTypeService energyTypeService;
    private final DriverLicenceTypeService driverLicenceTypeService;

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
        //Business Rule-1:
        if(vanRepository.existsVanByPlateNumber(request.getPlateNumber())){
            throw new RuntimeException("A second vehicle with the same license plate cannot be added");
        }
        //Business Rule-2:
        if(Year.now().getValue() - request.getManufacturedYear() > 10){
            throw  new RuntimeException("Vehicles can not be older than 10 years old.");
        }
        //Business Rule-3:
        if(Year.now().getValue() - request.getTrafficPermitLicenceDate().getYear() < 2){
            throw new RuntimeException("Cars must have valid traffic permit licence!");
        }

        // Mapping:
        Van van = new Van();
        van.setPlateNumber(request.getPlateNumber());
        van.setPassengerCapacity(request.getPassengerCapacity());
        van.setImage(request.getImage());
        van.setBaggageCapacity(request.getBaggageCapacity());
        van.setDriverAgeLimit(request.getDriverAgeLimit());
        van.setDriverExperienceReqLimit(request.getDriverExperienceReqLimit());
        van.setManufacturedYear(request.getManufacturedYear());
        van.setTrafficPermitLicenceDate(request.getTrafficPermitLicenceDate());
        Color color = colorService.getById(request.getColorId());
        van.setColor(color);
        Model model = modelService.getById(request.getModelId());
        van.setModel(model);
        GearType gearType = gearTypeService.getById(request.getGearTypeId());
        van.setGearType(gearType);
        EnergyType energyType = energyTypeService.getById(request.getEnergyTypeId());
        van.setEnergyType(energyType);
        DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceReqTypeId());
        van.setDriverLicenceReqType(driverLicenceType);
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
        //Business Rule-1:
        if(vanRepository.existsVanByPlateNumber(request.getPlateNumber())){
            throw new RuntimeException("A second vehicle with the same license plate cannot be added");
        }
        //Business Rule-2:
        if(Year.now().getValue() - request.getManufacturedYear() > 10){
            throw  new RuntimeException("Vehicles can not be older than 10 years old.");
        }
        //Business Rule-3:
        if(Year.now().getValue() - request.getTrafficPermitLicenceDate().getYear() < 2){
            throw new RuntimeException("Cars must have valid traffic permit licence!");
        }

        for (Van van : vans) {
            if(van.getPlateNumber().equals(plateNumber)){
                van.setPlateNumber(request.getPlateNumber());
                van.setPassengerCapacity(request.getPassengerCapacity());
                van.setImage(request.getImage());
                van.setBaggageCapacity(request.getBaggageCapacity());
                van.setDriverAgeLimit(request.getDriverAgeLimit());
                van.setDriverExperienceReqLimit(request.getDriverExperienceReqLimit());
                van.setManufacturedYear(request.getManufacturedYear());
                van.setTrafficPermitLicenceDate(request.getTrafficPermitLicenceDate());
                Color color = colorService.getById(request.getColorId());
                van.setColor(color);
                Model model = modelService.getById(request.getModelId());
                van.setModel(model);
                GearType gearType = gearTypeService.getById(request.getGearTypeId());
                van.setGearType(gearType);
                EnergyType energyType = energyTypeService.getById(request.getEnergyTypeId());
                van.setEnergyType(energyType);
                DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceReqTypeId());
                van.setDriverLicenceReqType(driverLicenceType);
                vanRepository.save(van);
            }
        }

    }
}
