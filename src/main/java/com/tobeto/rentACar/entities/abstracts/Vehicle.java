package com.tobeto.rentACar.entities.abstracts;

import com.tobeto.rentACar.entities.concretes.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehicles")

public abstract class Vehicle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "passenger_capacity")
    private int passengerCapacity;
    @Column(name = "baggage_capacity")
    private int baggageCapacity;
    @Column(name = "image")
    private String image;
    @Column(name = "driver_age_limit")
    private int driverAgeLimit;
    @Column(name = "driver_experience_req_limit")
    private int driverExperienceReqLimit;
    @Column(name = "manufactured_year")
    private int manufacturedYear;
    @Column(name = "traffic_permit_licence_date")
    private LocalDateTime trafficPermitLicenceDate;
    @Column(name = "plate_number")
    private String plateNumber;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @ManyToOne
    @JoinColumn(name = "gear_type_id")
    private GearType gearType;
    @ManyToOne
    @JoinColumn(name = "energy_type_id")
    private EnergyType energyType;
    @ManyToOne
    @JoinColumn(name = "driver_licence_req_type_id")
    private DriverLicenceType driverLicenceReqType;
    @OneToMany(mappedBy = "vehicle")
    private List<CategoryVehicle> categoryVehicles;
    @OneToMany(mappedBy = "vehicle")
    private List<Rent> rents;
}
