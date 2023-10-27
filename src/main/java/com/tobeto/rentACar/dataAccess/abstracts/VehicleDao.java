package com.tobeto.rentACar.dataAccess.abstracts;

import com.tobeto.rentACar.entities.abstracts.Vehicle;

public interface VehicleDao {
    void add(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
