package com.tobeto.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "branches")
@Entity
public class Branch {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "branch_name")
    private String branchName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;


    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private List<Personnel> personnels;
}
