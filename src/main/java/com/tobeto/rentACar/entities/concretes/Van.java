package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vans")
@Entity
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Van extends Vehicle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "door_number")
    private int doorNumber;
}
