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
@Table(name = "colors")
@Entity
public class Color {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color_def")
    private String colorDef;

    @OneToMany(mappedBy = "color")
    private List<Vehicle> vehicles;

}
