package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.DriverLicenceType;
import com.tobeto.rentACar.services.dtos.driverLicenceTypes.request.AddDriverLicenceTypeRequest;
import com.tobeto.rentACar.services.dtos.driverLicenceTypes.request.UpdateDriverLicenceTypeRequest;

public interface DriverLicenceTypeService {
    DriverLicenceType getById(int id);
    public void addDriverLicenceType(AddDriverLicenceTypeRequest request);
    public void updateDriverLicenceType(String driverLicenceTypeDef, UpdateDriverLicenceTypeRequest request);

}
