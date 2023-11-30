package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse;
import com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByPlateNumberStartingWith(String plateNumber);    // Derived Query Methods

    @Query("select new com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsResponse" +
            "(c.plateNumber, b.brandName, m.modelName, c.passengerCapacity, c.baggageCapacity, c.image) " +
            "from Car c " +
            "join c.model m " +
            "join m.brand b"
    )
    List<GetAllCarsResponse> getAllCars();  // JPQL Methods

    @Query("select new com.tobeto.rentACar.services.dtos.cars.response.GetAllCarsWithGearTypesResponse" +
            "(c.plateNumber, b.brandName, m.modelName, g.gearTypeDef) " +
            "from Car c " +
            "join c.model m " +
            "join m.brand b " +
            "join c.gearType g")
    List<GetAllCarsWithGearTypesResponse> getAllCarsWithGearTypes();    // JPQL Methods

    @Query("select new com.tobeto.rentACar.services.dtos.cars.response.GetCarByBrandResponse" +
            "(c.plateNumber, b.brandName, m.modelName) " +
            "from Car c " +
            "join c.model m " +
            "join m.brand b")
    List<GetCarByBrandResponse> getCarByBrand();    // JPQL Methods
}
