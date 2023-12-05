package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Motorcycle;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse;
import com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleWithGearTypesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

    @Query("select new com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleResponse" +
            "(mo.plateNumber, " +
            "new com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse(b.id, b.brandName), " +
            "new com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse(m.id,m.modelName), " +
            "mo.passengerCapacity, mo.image) " +
            "from Motorcycle mo " +
            "inner join mo.model m " +
            "inner join m.brand b")
    List<GetAllMotorcycleResponse> getAllMotorcycles(); // JPQL Methods
    List<Motorcycle> findByPlateNumberStartingWith (String plateNumber);    // Derived Query Methods
    @Query("select new com.tobeto.rentACar.services.dtos.motorcycles.response.GetAllMotorcycleWithGearTypesResponse" +
            "(mo.plateNumber, " +
            "new com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse(b.id, b.brandName), " +
            "new com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse(m.id,m.modelName), " +
            "new com.tobeto.rentACar.services.dtos.gearTypes.response.GetAllGearTypesResponse(g.id, g.gearTypeDef)) " +
            "from Motorcycle mo " +
            "join mo.model m " +
            "join m.brand b " +
            "join mo.gearType g")
    List<GetAllMotorcycleWithGearTypesResponse> getAllMotorcycleWithGearTypesResponse();    // JPQL Methods
}
