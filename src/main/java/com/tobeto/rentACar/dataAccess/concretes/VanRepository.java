package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.Van;
import com.tobeto.rentACar.services.dtos.vans.responses.GetAllVanResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VanRepository  extends JpaRepository<Van, Integer> {
    List<Van> findByPlateNumberStartingWith(String plateNumber);    // Derived Query Methods

    @Query("select new com.tobeto.rentACar.services.dtos.vans.responses.GetAllVanResponse" +
            "(v.plateNumber, " +
            "new com.tobeto.rentACar.services.dtos.brands.response.GetAllBrandsByCustomerResponse(b.id, b.brandName), " +
            "new com.tobeto.rentACar.services.dtos.models.response.GetAllModelsResponse(m.id,m.modelName), " +
            "v.passengerCapacity, v.baggageCapacity, v.image) " +
            "from Van v " +
            "join v.model m " +
            "join m.brand b"
    )
    List<GetAllVanResponse> getAllVans();   // JPQL Methods

    boolean existsVanByPlateNumber(String plateNumber);    // Derived Query Methods

}
