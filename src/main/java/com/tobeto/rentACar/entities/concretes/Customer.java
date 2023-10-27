package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Person;

public class Customer extends Person {
    //Attributes:
    private int customerId;
    private int driverLicenceIssueYear;

    //Constructor
    public Customer(int personId, String firstName, String lastName, int age, String internationalId, int customerId, int driverLicenceIssueYear) {
        super(personId, firstName, lastName, age, internationalId);
        this.customerId = customerId;
        this.driverLicenceIssueYear = driverLicenceIssueYear;
    }

    //Getters & Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getDriverLicenceIssueYear() {
        return driverLicenceIssueYear;
    }

    public void setDriverLicenceIssueYear(int driverLicenceIssueYear) {
        this.driverLicenceIssueYear = driverLicenceIssueYear;
    }
}
