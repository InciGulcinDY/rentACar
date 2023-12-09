package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.DriverLicenceTypeRepository;
import com.tobeto.rentACar.entities.concretes.DriverLicenceType;
import com.tobeto.rentACar.services.abstracts.DriverLicenceTypeService;
import com.tobeto.rentACar.services.dtos.driverLicenceTypes.request.AddDriverLicenceTypeRequest;
import com.tobeto.rentACar.services.dtos.driverLicenceTypes.request.UpdateDriverLicenceTypeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverLicenceTypeManager implements DriverLicenceTypeService {
    private DriverLicenceTypeRepository driverLicenceTypeRepository;
    @Override
    public DriverLicenceType getById(int id) {
        return driverLicenceTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public void addDriverLicenceType(AddDriverLicenceTypeRequest request) {
        // Mapping:
        DriverLicenceType driverLicenceType = new DriverLicenceType();
        driverLicenceType.setDriverLicenceTypeDef(request.getDriverLicenceTypeDef());
        driverLicenceTypeRepository.save(driverLicenceType);
    }

    @Override
    public void updateDriverLicenceType(String driverLicenceTypeDef, UpdateDriverLicenceTypeRequest request) {
        List<DriverLicenceType> driverLicenceTypes = driverLicenceTypeRepository.findAll();
        for (DriverLicenceType driverLicenceType:driverLicenceTypes) {
            driverLicenceType.setDriverLicenceTypeDef(request.getDriverLicenceTypeDef());
            driverLicenceTypeRepository.save(driverLicenceType);
        }

    }
}
