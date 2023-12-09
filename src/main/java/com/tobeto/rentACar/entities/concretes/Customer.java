package com.tobeto.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.rentACar.entities.abstracts.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
@Entity
@PrimaryKeyJoinColumn(name = "person_id")

public class Customer extends Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "licence_issue_date")
    private LocalDateTime licenceIssueDate;

    @ManyToOne
    @JoinColumn(name = "driver_licence_type_id")
    private DriverLicenceType driverLicenceType;

    @OneToMany(mappedBy = "customer")
    private List<Rent> rents;

}
