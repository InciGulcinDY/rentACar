package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.entities.concretes.DriverLicenceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverLicenceTypeRepository extends JpaRepository<DriverLicenceType, Integer> {
}
