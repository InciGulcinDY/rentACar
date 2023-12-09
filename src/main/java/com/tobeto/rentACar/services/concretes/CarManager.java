package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CarRepository;
import com.tobeto.rentACar.dataAccess.concretes.DriverLicenceTypeRepository;
import com.tobeto.rentACar.entities.concretes.*;
import com.tobeto.rentACar.services.abstracts.*;
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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ColorService colorService;
    private final ModelService modelService;
    private final GearTypeService gearTypeService;
    private final EnergyTypeService energyTypeService;
    private final DriverLicenceTypeService driverLicenceTypeService;


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
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public void addCar(AddCarRequest request) {
        //Business Rule-1:
        if(carRepository.existsCarByPlateNumber(request.getPlateNumber())){
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
        Car car = new Car();
        car.setPlateNumber(request.getPlateNumber());
        car.setPassengerCapacity(request.getPassengerCapacity());
        car.setImage(request.getImage());
        car.setBaggageCapacity(request.getBaggageCapacity());
        car.setDriverAgeLimit(request.getDriverAgeLimit());
        car.setDriverExperienceReqLimit(request.getDriverExperienceReqLimit());
        car.setManufacturedYear(request.getManufacturedYear());
        car.setTrafficPermitLicenceDate(request.getTrafficPermitLicenceDate());
        Color color = colorService.getById(request.getColorId());
        car.setColor(color);
        Model model = modelService.getById(request.getModelId());
        car.setModel(model);
        GearType gearType = gearTypeService.getById(request.getGearTypeId());
        car.setGearType(gearType);
        EnergyType energyType = energyTypeService.getById(request.getEnergyTypeId());
        car.setEnergyType(energyType);
        DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceReqTypeId());
        car.setDriverLicenceReqType(driverLicenceType);
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
        //Business Rule-1:
        if(carRepository.existsCarByPlateNumber(request.getPlateNumber())){
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

        for (Car car:cars) {
            if(car.getPlateNumber().equals(plateNumber)){
                car.setPlateNumber(request.getPlateNumber());
                car.setPassengerCapacity(request.getPassengerCapacity());
                car.setImage(request.getImage());
                car.setBaggageCapacity(request.getBaggageCapacity());
                car.setDriverAgeLimit(request.getDriverAgeLimit());
                car.setDriverExperienceReqLimit(request.getDriverExperienceReqLimit());
                car.setManufacturedYear(request.getManufacturedYear());
                car.setTrafficPermitLicenceDate(request.getTrafficPermitLicenceDate());
                Color color = colorService.getById(request.getColorId());
                car.setColor(color);
                Model model = modelService.getById(request.getModelId());
                car.setModel(model);
                GearType gearType = gearTypeService.getById(request.getGearTypeId());
                car.setGearType(gearType);
                EnergyType energyType = energyTypeService.getById(request.getEnergyTypeId());
                car.setEnergyType(energyType);
                DriverLicenceType driverLicenceType = driverLicenceTypeService.getById(request.getDriverLicenceReqTypeId());
                car.setDriverLicenceReqType(driverLicenceType);
                carRepository.save(car);
            }
        }
    }


}
