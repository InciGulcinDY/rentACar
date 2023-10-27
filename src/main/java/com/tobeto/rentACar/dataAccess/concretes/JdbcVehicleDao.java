package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.dataAccess.abstracts.VehicleDao;
import com.tobeto.rentACar.entities.abstracts.Vehicle;

public class JdbcVehicleDao implements VehicleDao {
    @Override
    public void add(Vehicle vehicle) {
        System.out.println("Data has been successfully incorporated into the database using JDBC.");
    }

    @Override
    public void update(Vehicle vehicle) {
        System.out.println("The database has been effectively updated with data through JDBC.");
    }

    @Override
    public void delete(Vehicle vehicle) {
        System.out.println("Data within the database has been successfully removed using JDBC.");
    }
}
