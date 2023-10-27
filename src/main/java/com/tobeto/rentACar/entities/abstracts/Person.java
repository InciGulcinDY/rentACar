package com.tobeto.rentACar.entities.abstracts;

public abstract class Person {
    //Attributes:
    private int personId;
    private String firstName;
    private String lastName;
    private int age;
    private String internationalId;

    //Constructor

    public Person(int personId, String firstName, String lastName, int age, String internationalId) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.internationalId = internationalId;
    }


    //Getters & Setters
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInternationalId() {
        return internationalId;
    }

    public void setInternationalId(String internationalId) {
        this.internationalId = internationalId;
    }
}
