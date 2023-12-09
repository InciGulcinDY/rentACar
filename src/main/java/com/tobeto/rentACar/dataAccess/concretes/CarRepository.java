package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByPlateNumberStartingWithResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository  extends JpaRepository<Car, Integer> {
    @Query("select new com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse (c.plateNumber, " +
            "new com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse(b.id, b.brandName), " +
            "new com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse(m.id,m.modelName), " +
            "c.passengerCapacity, c.baggageCapacity, c.image) " +
            "from Car c " +
            "inner join c.model m " +
            "inner join m.brand b"
    )
    List<GetAllCarsResponse> getAllCars();  // JPQL Methods

    @Query("select new com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse (c.plateNumber, " +
            "new com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse(b.id, b.brandName), " +
            "new com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse(m.id,m.modelName), " +
            "new com.tobeto.rentACar.services.dtos.gearTypes.response.GetAllGearTypesResponse(g.id, g.gearTypeDef)) " +
            "from Car c " +
            "inner join c.model m " +
            "inner join m.brand b " +
            "inner join c.gearType g")
    List<GetAllCarsWithGearTypesResponse> getAllCarsWithGearTypes();    // JPQL Methods

    List<Car> findByPlateNumberStartingWith(String plateNumber);    // Derived Query Methods

    @Query("select new com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse" +
            "(c.plateNumber, " +
            "new com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse(b.id, b.brandName), " +
            "new com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse(m.id,m.modelName)) " +
            "from Car c " +
            "join c.model m " +
            "join m.brand b")
    List<GetCarByBrandResponse> getCarByBrand();    // JPQL Methods

    boolean existsCarByPlateNumber(String plateNumber);    // Derived Query Methods
}
