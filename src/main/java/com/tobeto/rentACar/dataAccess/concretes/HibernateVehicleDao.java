package com.tobeto.rentACar.dataAccess.concretes;

import com.tobeto.rentACar.dataAccess.abstracts.VehicleDao;
import com.tobeto.rentACar.entities.abstracts.Vehicle;

public class HibernateVehicleDao implements VehicleDao {
    @Override
    public void add(Vehicle vehicle) {
        System.out.println("Data has been successfully incorporated into the database using Hibernate.");
    }

    @Override
    public void update(Vehicle vehicle) {
        System.out.println("The database has been effectively updated with data through Hibernate.");
    }

    @Override
    public void delete(Vehicle vehicle) {
        System.out.println("Data within the database has been successfully removed using Hibernate.");
    }
}
