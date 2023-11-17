package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "driver_licence_types")
@Entity
public class DriverLicenceType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "driver_licence_type_def")
    private String driverLicenceTypeDef;

    @OneToMany(mappedBy = "driverLicenceType")
    private List<Customer> customers;

    @OneToMany(mappedBy = "driverLicenceReqType")
    private List<Vehicle> vehicles;
}
