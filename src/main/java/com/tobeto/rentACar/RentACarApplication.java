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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentACarApplication {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(RentACarApplication.class, args);

        //Person customer1 = new Customer(1,"elon","musk",30,"000000111111",1,2000);
        Vehicle vehicle1 = new Car("Suzuki", "S-Cross", 5, 3, "automatic", "Hybrid/Fuel", "image.jpg", 23, 2, 2023,true,"SUV");

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new Mail()};



        VehicleManager vehicleManager = new VehicleManager(new HibernateVehicleDao(), loggers);
        vehicleManager.addingVehicle(vehicle1);



    }

}
