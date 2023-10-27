package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Vehicle;

public class Car extends Vehicle {
    //Attributes
    private String carType;


    //Constructors


    public Car(String brand, String model, int passengerCapacity, int baggageCapacity, String gearType, String energy, String image, int driverAgeLimit, int driverExperienceReqLimit, int manufacturedYear, boolean isTrafficPermitLicence, String carType) {
        super(brand, model, passengerCapacity, baggageCapacity, gearType, energy, image, driverAgeLimit, driverExperienceReqLimit, manufacturedYear, isTrafficPermitLicence);
        this.carType = carType;
    }

    //Getters & Setters
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
