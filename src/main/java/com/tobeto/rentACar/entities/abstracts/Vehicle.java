package com.tobeto.rentACar.entities.abstracts;

public abstract class Vehicle {
    //Attributes
    private String brand;
    private String model;
    private int passengerCapacity;
    private int baggageCapacity;
    private String gearType;
    private String energy;
    private String image;
    private int driverAgeLimit;
    private int driverExperienceReqLimit;
    private int manufacturedYear;
    private boolean isTrafficPermitLicence;

    //Constructors

    public Vehicle(String brand, String model, int passengerCapacity, int baggageCapacity, String gearType, String energy, String image, int driverAgeLimit, int driverExperienceReqLimit, int manufacturedYear, boolean isTrafficPermitLicence) {
        this.brand = brand;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.baggageCapacity = baggageCapacity;
        this.gearType = gearType;
        this.energy = energy;
        this.image = image;
        this.driverAgeLimit = driverAgeLimit;
        this.driverExperienceReqLimit = driverExperienceReqLimit;
        this.manufacturedYear = manufacturedYear;
        this.isTrafficPermitLicence = isTrafficPermitLicence;
    }


    //Getters & Setters

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public boolean isTrafficPermitLicence() {
        return isTrafficPermitLicence;
    }

    public void setTrafficPermitLicence(boolean trafficPermitLicence) {
        isTrafficPermitLicence = trafficPermitLicence;
    }

    public int getDriverAgeLimit() {
        return driverAgeLimit;
    }

    public void setDriverAgeLimit(int driverAgeLimit) {
        this.driverAgeLimit = driverAgeLimit;
    }

    public int getDriverExperienceReqLimit() {
        return driverExperienceReqLimit;
    }

    public void setDriverExperienceReqLimit(int driverExperienceReqLimit) {
        this.driverExperienceReqLimit = driverExperienceReqLimit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(int baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
