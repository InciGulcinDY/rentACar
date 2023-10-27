package com.tobeto.rentACar.business.concretes;

import com.tobeto.rentACar.business.abstracts.VehicleService;
import com.tobeto.rentACar.core.abstracts.Logger;
import com.tobeto.rentACar.dataAccess.abstracts.VehicleDao;
import com.tobeto.rentACar.entities.abstracts.Vehicle;

import java.time.Year;
import java.util.Date;

public class VehicleManager implements VehicleService {
    //Attributes:
    private VehicleDao vehicleDao;
    private Logger[] loggers;

    //Dependency Injection:
    public VehicleManager(VehicleDao vehicleDao, Logger[] loggers) {
        this.vehicleDao = vehicleDao;
        this.loggers = loggers;
    }


    @Override
    public void addingVehicle(Vehicle vehicle) throws Exception {
        //Business Rules:
        //Rule-1: A vehicle without a traffic permit license cannot be registered.
        if (!vehicle.isTrafficPermitLicence()){
            throw new Exception(" vehicle without a traffic permit license cannot be registered.");
        }
        //Rule-2: The vehicle must not exceed a maximum age of 10 years.
        if((Year.now().getValue() - vehicle.getManufacturedYear()) > 10){
            throw new Exception("The vehicle must not exceed a maximum age of 10 years.");
        }

        // Adding processes:
        vehicleDao.add(vehicle);
        for (Logger logger:loggers) {
            logger.log(vehicle.getBrand() + " " + vehicle.getModel());
        }
    }
}

//cannot rent under the specified age limit
//cannot rent under the specified experience limit