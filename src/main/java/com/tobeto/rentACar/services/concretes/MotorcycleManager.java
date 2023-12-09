package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.MotorcycleRepository;
import com.tobeto.rentACar.entities.concretes.*;
import com.tobeto.rentACar.services.abstracts.*;
import com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByPlateNumberStartingWithResponse;
import com.tobeto.rentACar.services.dtos.gearTypes.response.GetAllGearTypesResponse;
import com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.request.AddMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.DeleteMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.request.UpdateMotorcycleRequest;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetMotorcycleByPlateNumberStartingWithResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MotorcycleManager implements MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;
    private final ColorService colorService;
    private final ModelService modelService;
    private final GearTypeService gearTypeService;
    private final EnergyTypeService energyTypeService;
    private final DriverLicenceTypeService driverLicenceTypeService;

    @Override
    public List<GetAllMotorcycleResponse> getAllMotorcycles() {
        return motorcycleRepository.getAllMotorcycles();
    }

    @Override
    public List<GetMotorcycleByPlateNumberStartingWithResponse> findByPlateNumberStartingWith(String plateNumber) {
        return motorcycleRepository.findByPlateNumberStartingWith(plateNumber)
                .stream()
                .filter(motorcycle -> motorcycle.getPlateNumber().equals(plateNumber))
                .map(motorcycle -> new GetMotorcycleByPlateNumberStartingWithResponse(
                        motorcycle.getPlateNumber(),
                        new GetAllBrandsByCustomerResponse(motorcycle.getModel().getBrand().getId(),
                                motorcycle.getModel().getBrand().getBrandName()),
                        new GetAllModelsResponse(motorcycle.getModel().getId(),motorcycle.getModel().getModelName()),
                        new GetAllGearTypesResponse(motorcycle.getGearType().getId(), motorcycle.getGearType().getGearTypeDef())
                )).toList();
    }

    @Override
    public List<GetAllMotorcycleWithGearTypesResponse> getAllMotorcycleWithGearTypes() {
        return motorcycleRepository.getAllMotorcycleWithGearTypesResponse();
    }

    @Override
    public void addMotorcycle(AddMotorcycleRequest request) {
        Motorcycle motorcycle = new Motorcycle();
        //Business Rule-1:
        if(motorcycleRepository.existsMotorcycleByPlateNumber(request.getPlateNumber())){
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
        motorcycle.setPlateNumber(request.getPlateNumber());
        motorcycle.setPassengerCapacity(request.getPassengerCapacity());
        motorcycle.setImage(request.getImage());
        motorcycle.setBaggageCapacity(request.getBaggageCapacity());
        motorcycle.setDriverAgeLimit(request.getDriverAgeLimit());
        motorcycle.setDriverExperienceReqLimit(request.getDriverExperienceReqLimit());
        motorcycle.setManufacturedYear(request.getManufacturedYear());
        motorcycle.setTrafficPermitLicenceDate(request.getTrafficPermitLicenceDate());
        Color color = colorService.getById(request.getColorId());
        motorcycle.setColor(color);
        Model model = modelService.getById(request.getModelId());
        motorcycle.setModel(model);
        GearType gearType = gearTypeService.getById(request.getGearTypeId());
        motorcycle.setGearType(gearType);
        EnergyType energyType = energyTypeService.getById(request.getEnergyTypeId());
        motorcycle.setEnergyType(energyType);
        DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceReqTypeId());
        motorcycle.setDriverLicenceReqType(driverLicenceType);

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

        //Business Rule-1:
        if(motorcycleRepository.existsMotorcycleByPlateNumber(request.getPlateNumber())){
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

        for (Motorcycle motorcycle : motorcycles) {
            if(motorcycle.getPlateNumber().equals(plateNumber)){
                motorcycle.setPlateNumber(request.getPlateNumber());
                motorcycle.setPassengerCapacity(request.getPassengerCapacity());
                motorcycle.setImage(request.getImage());
                motorcycle.setBaggageCapacity(request.getBaggageCapacity());
                motorcycle.setDriverAgeLimit(request.getDriverAgeLimit());
                motorcycle.setDriverExperienceReqLimit(request.getDriverExperienceReqLimit());
                motorcycle.setManufacturedYear(request.getManufacturedYear());
                motorcycle.setTrafficPermitLicenceDate(request.getTrafficPermitLicenceDate());
                Color color = colorService.getById(request.getColorId());
                motorcycle.setColor(color);
                Model model = modelService.getById(request.getModelId());
                motorcycle.setModel(model);
                GearType gearType = gearTypeService.getById(request.getGearTypeId());
                motorcycle.setGearType(gearType);
                EnergyType energyType = energyTypeService.getById(request.getEnergyTypeId());
                motorcycle.setEnergyType(energyType);
                DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceReqTypeId());
                motorcycle.setDriverLicenceReqType(driverLicenceType);
                motorcycleRepository.save(motorcycle);
            }
        }

    }
}
