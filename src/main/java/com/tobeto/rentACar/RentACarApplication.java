package com.tobeto.rentACar;

import com.tobeto.rentACar.business.abstracts.VehicleService;
import com.tobeto.rentACar.business.concretes.VehicleManager;
import com.tobeto.rentACar.core.abstracts.Logger;
import com.tobeto.rentACar.core.concretes.DatabaseLogger;
import com.tobeto.rentACar.core.concretes.FileLogger;
import com.tobeto.rentACar.core.concretes.Mail;
import com.tobeto.rentACar.dataAccess.concretes.HibernateVehicleDao;
import com.tobeto.rentACar.entities.abstracts.Person;
import com.tobeto.rentACar.entities.abstracts.Vehicle;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.entities.concretes.Van;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentACarApplication {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(RentACarApplication.class, args);

        Vehicle vehicle1 = new Car("Suzuki", "S-Cross", 4, 3, "automatic", "Hybrid/Fuel", "imageCar1.jpg", 23, 2, 2022,true,"SUV");
        Vehicle vehicle2 = new Car("Renault", "Clio", 4, 2, "automatic", "Diesel/Fuel", "imageCar2.jpg", 21, 1, 2018,true,"Sedan");
        Vehicle vehicle3 = new Car("Fiat", "Egea Hb", 4, 2, "automatic", "Diesel/Fuel", "imageCar3.jpg", 21, 1, 2020,true,"Hatchback");
        Vehicle vehicle4 = new Car("Mercedes", "C", 5, 2, "automatic", "Diesel/Fuel", "imageCar4.jpg", 27, 3, 2021,true,"Sedan");
        Vehicle vehicle5 = new Car("Volvo", "XC60", 5, 3, "automatic", "Diesel/Fuel", "imageCar5.jpg", 27, 3, 2022,true,"Hatchback");

        Van van1 = new Van("Fiat","Ulysse",9,3,"automatic","Diesel","imageVan1.jpg",25,2,2020,true,5);
        Van van2 = new Van("Hyundai","Staria",9,3,"automatic","","imageVan1.jpg",25,2,2020,true,5);

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new Mail()};

        VehicleManager vehicleManager = new VehicleManager(new HibernateVehicleDao(), loggers);
        vehicleManager.addingVehicle(vehicle1);
        vehicleManager.addingVehicle(vehicle2);
        vehicleManager.addingVehicle(vehicle3);
        vehicleManager.addingVehicle(vehicle4);
        vehicleManager.addingVehicle(vehicle5);
        vehicleManager.addingVehicle(van1);
        vehicleManager.addingVehicle(van2);

    }

}
