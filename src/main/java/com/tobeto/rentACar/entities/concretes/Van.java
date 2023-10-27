package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Vehicle;

public class Van extends Vehicle {
    //Attributes
    private int doorNumber;

    //Constructors

    public Van(String brand, String model, int passengerCapacity, int baggageCapacity, String gearType, String energy, String image, int driverAgeLimit, int driverExperienceReqLimit, int manufacturedYear, boolean isTrafficPermitLicence, int doorNumber) {
        super(brand, model, passengerCapacity, baggageCapacity, gearType, energy, image, driverAgeLimit, driverExperienceReqLimit, manufacturedYear, isTrafficPermitLicence);
        this.doorNumber = doorNumber;
    }


    //Getters & Setters

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }
}
